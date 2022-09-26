/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asset_management;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 *
 * @author NCC
 */
public class AssetList extends ArrayList<Asset> implements I_Asset {

    @Override
    public void readFile(String fName) {
        try {
            File f = new File(fName);
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String detail;
            while ((detail = br.readLine()) != null) {
                StringTokenizer stk = new StringTokenizer(detail, ",");
                String ID = stk.nextToken();
                String name = stk.nextToken();
                String color = stk.nextToken();
                int price = Integer.parseInt(stk.nextToken());
                double weight = Double.parseDouble(stk.nextToken());
                int quantity = Integer.parseInt(stk.nextToken());
                this.add(new Asset(ID, name, color, price, weight, quantity));
            }
            fr.close();
            br.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public int find(String code) {
        int index = -1;
        index = this.indexOf(new Asset(code));
        return index;
    }

    @Override
    public void add() {
        String ID;
        do {
            ID = Utils.getString("Input Asset ID: ");
            if (find(ID) == -1) {
                break;
            } else {
                System.out.println("Duplicate ID");
            }
        } while (true);
        String name = Utils.getString("Input name: ");
        String color = Utils.getString("Input color: ");
        int price = Utils.getInt("Input price(1-10000): ", 1, 10000);
        double weight = Utils.getDouble("Input weight(0.01-20): ", 0.01, 20);
        int quantity = Utils.getInt("Input quantity(1-100): ", 1, 100);
        this.add(new Asset(ID, name, color, price, weight, quantity));
    }

    @Override
    public void update() {
        String ID = Utils.getString("Input ID want to update: ");
        int index = this.find(ID);
        if (index < 0 || index >= this.size()) {
            System.out.println("Asset does not exist");
            return;
        }
        this.get(index).update();
        this.get(index).showInfor();
    }

    @Override
    public void searchAssetbyname() {
        String name = Utils.getString("Input name: ");
        int k = 0;
        for (Asset o : this) {
            if (o.name.toLowerCase().contains(name.toLowerCase()) == true) {
                o.showInfor();              
                k++;
            }
        }
        if (k == 0) {
            System.out.println("Not found!!!");
        }
    }

    
    @Override
    public int showquantitybyID(String ID) {
        for (Asset o : this) {
            if (o.assetID.equals(ID) == true) {
                return o.getQuantity();

            }
        }
        return 0;
    }

    @Override
    public void update(String ID, int i) {
        for (Asset o : this) {
            if (o.assetID.equals(ID) == true) {
                o.borrowed(ID, i);
            }
        }
    }

    @Override
    public void output() {
        for (Asset o : this) {
            o.showInfor();
        }
    }
    public void sort(ArrayList<Asset> Assets) {
        Collections.sort(Assets, new Comparator<Asset>() {
            @Override
            public int compare(Asset o1, Asset o2) {
                if (o1.price < o2.price) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });
    }
    public void writeFile(String fName){
          
     try{
            File f = new File(fName);
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
            for (int i = 0; i < this.size(); i++) {
                pw.println(this.get(i).toString());
            }
            pw.close();
            fw.close();
        } catch (IOException ex){
            System.out.println("Write file error encountered! \n" + ex);
        }
   }
    
}
