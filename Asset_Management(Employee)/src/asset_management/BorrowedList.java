/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asset_management;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author NCC
 */
public class BorrowedList extends ArrayList<Borrowed> implements I_Borrowed {

    @Override
    public void add(String bID, String AssetID, String EmployeeID, int quantity, String datetime) {
        this.add(new Borrowed(bID, AssetID, EmployeeID, quantity, datetime));
    }
    
    @Override
    public void output(String Employee) {
        for (Borrowed o : this) {
            if (o.EmployeeID.toLowerCase().equals(Employee.toLowerCase())){
            o.showInfor();
            System.out.println();
        }
    }
    }
    
   public List<Borrowed> bList = new ArrayList<>();

    public List<Borrowed> readFile() {
        bList.clear();
        try {
            bList = Utils.readFile("D:\\lab3\\Borrow.dat", 4);
        } catch (IOException ex) {
            Logger.getLogger(BorrowedList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BorrowedList.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bList;
    }


    @Override
    public int find(String code) {
        int index = -1;
        index = this.indexOf(new Borrowed(code));
        return index;
    }
     @Override
    public String getcode() {
        String code = Utils.getString("Input ID you want to return: ");
        int index = this.find(code);
        return code;
    }
    @Override
    public int getnumberbyID(String ID) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getbID().equals(ID) == true) {
                return i;
            }
        }
        return 0;
    }
    @Override
    public void delete(String code) {        
            this.remove(new Borrowed(code));
            
        }
        @Override
    public String showAssetIDbyID(String ID) {
        for (Borrowed o : this) {
            if (o.bID.equals(ID) == true) {
                return o.getAssetID();
            }
        }
        return null;
    }
    public String getEmployeeIDbyID(String ID){
        for (Borrowed o : this) {
            if (o.bID.equals(ID) == true) {
                return o.getEmployeeID();
            }
        }
        return null;
    }
}
