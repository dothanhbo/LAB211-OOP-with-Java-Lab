/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asset_management;


import java.io.IOException;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NCC
 */
public class RequestList extends ArrayList<Request> implements I_Request {

    public List<Request> reqList = new ArrayList<>();
    @Override
    public void readFile() {
        Request temRequest=null;
        if (reqList.isEmpty()) {
            try {
                reqList = Utils.readFile("D:\\lab3\\Request.dat", 3);
            } catch (IOException ex) {
                Logger.getLogger(RequestList.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(RequestList.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void add(String assetID, String employeeID) {
        int quantity = Utils.getInt("Input quantity(1-1000): ", 1, 1000);
        this.add(new Request(getID(1), assetID, employeeID, quantity, date()));
    }

    public String getID(int num) {
        String k = this.get(0).getrID();
        String ID = null;
        String IDnum = null;
        int count = 0;

        if (num < 10) {
            IDnum = "00" + Integer.toString(num);
        } else {
            IDnum = "0" + Integer.toString(num);
        }
        ID = Character.toString('R').concat(IDnum);
        for (Request o : this) {
            if (o.rID.equals(ID) == true) {
                count++;
            }

        }
        if (count == 0) {
            return ID;
        }
        return getID(num + 1);

    }

    public String date() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date date = new Date();
        return formatter.format(date);
    }

    @Override
    public void output() {
        for (Request o : this) {
            o.showInfor();
            System.out.println();
        }
    }

    @Override
    public int find(String code) {
        int index = -1;
        index = this.indexOf(new Request(code));
        return index;
    }

    public void showbyID(String Employee) {
        for (Request o : this) {
            if (o.EmployeeID.toLowerCase().equals(Employee.toLowerCase())) {
                o.showInfor();
                System.out.println();
            }
        }
    }

    @Override
    public void Approve(String code) {
        this.remove(new Request(code));

    }

    @Override
    public String getcode() {
        String code = Utils.getString("Input ID you want to cancle: ");
        int index = this.find(code);
        return code;
    }

    @Override
    public int getnumberbyID(String ID) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getrID().equals(ID) == true) {
                return i;
            }
        }
        return 0;
    }

    public String getEmployeeIDbyID(String ID) {
        for (Request o : this) {
            if (o.rID.equals(ID) == true) {
                return o.getEmployeeID();
            }
        }
        return null;
    }
}
