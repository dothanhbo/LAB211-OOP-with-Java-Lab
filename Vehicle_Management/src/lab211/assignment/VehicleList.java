package lab211.assignment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.*;
import java.io.*;

import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * This is comment, do not delete 2021.10.31
 * and open the template in the editor.
 */
/**
 *
 * @author Hoa Doan
 */
public class VehicleList extends ArrayList<Vehicles> implements I_List {

    private static void nextToken() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int find(String code) {
        int index = -1;
        index = this.indexOf(new Vehicles(code));
        return index;
    }

    @Override
    public void readFile(String fName) {
        try {
            File f = new File(fName);
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String detail;
            while ((detail = br.readLine()) != null) {
                StringTokenizer stk = new StringTokenizer(detail, ",");
                String type = stk.nextToken();
                String ID = stk.nextToken();
                String name = stk.nextToken();
                String color = stk.nextToken();
                int price = Integer.parseInt(stk.nextToken());
                String brand = stk.nextToken();

                if ((type.equals("car")) == true) {
                    String typeofcar = stk.nextToken();
                    int year = Integer.parseInt(stk.nextToken());
                    this.add(new Car(ID, name, color, price, brand, typeofcar, year));
                } else {
                    int speed = Integer.parseInt(stk.nextToken());
                    String license = stk.nextToken();
                    this.add(new Motobike(ID, name, color, price, brand, speed, license));
                }
            }
            fr.close();
            br.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void add(int type) {
        String ID;
        do {
            ID = Utils.getString("Input ID: ");
            if (find(ID) == -1) {
                break;
            } else {
                System.out.println("Duplicate ID");
            }
        } while (true);
        String name = Utils.getString("Input name: ");
        String color = Utils.getString("Input color: ");
        int price = Utils.getInt("Input price(1-10000): ", 1, 10000);
        String brand = Utils.getString("Input brand: ");

        if (type == 1) {
            String typeofcar = Utils.getString("Input type: ");
            int year = Utils.getInt("Input yearOfManufacture(1-100): ", 1, 100);
            this.add(new Car(ID, name, color, price, brand, typeofcar, year));
        } else {
            int speed = Utils.getInt("Input speed(1-200): ", 1, 200);
            String license = Utils.getString("Input license?: ");
            this.add(new Motobike(ID, name, color, price, brand, speed, license));
        }
    }

    @Override
    public void delete() {
        String code = Utils.getString("Input ID want to remove: ");
        int index = this.find(code);
        if (index < 0 || index >= this.size()) {
            System.out.println("Vehicle does not exist");
        } else {
            if (Utils.confirmYesNo("Are you sure want to delete(Y/N): ")) {
                this.remove(new Vehicles(code));
                System.out.println("Deleted!");
            }
        }
    }

    @Override
    public void update() {
        String ID = Utils.getString("Input ID want to update: ");
        int index = this.find(ID);
        if (index < 0 || index >= this.size()) {
            System.out.println("Vehicle does not exist");
            return;
        }
        this.get(index).update();
        this.get(index).showInfor();
    }

    @Override
    public void sort(ArrayList<Vehicles> Vehicle) {
        Collections.sort(Vehicle, new Comparator<Vehicles>() {
            @Override
            public int compare(Vehicles o1, Vehicles o2) {
                if (o1.price < o2.price) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });
    }

    @Override

    public void output() {
        for (Vehicles o : this) {
            o.showInfor();
        }
    }

    @Override
    public void searchVehiclebyID() {
        String ID = Utils.getString("Input ID: ");
        int index = find(ID);
        if (index == -1) {
            System.out.println("Not Found");
        } else {
            this.get(index).showInfor();
        }
    }

    @Override
    public void searchVehiclebyname() {
        String name = Utils.getString("Input name: ");
        int k = 0;
        for (Vehicles o : this) {
            if (o.name.toLowerCase().contains(name.toLowerCase()) == true) {
                o.showInfor();
                k++;
            }
        }
        if (k == 0) {
            System.out.printf("Not found!!!");
        }
    }

    @Override
    public void writeFile(ArrayList<Vehicles> Vehicle, String fName) {
        try {
            File f = new File(fName);
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
            for (int i = 0; i < Vehicle.size(); i++) {
                pw.print(Vehicle.get(i));
            }
            fw.close();
            pw.close();
        } catch (IOException e) {
        }
    }

}
