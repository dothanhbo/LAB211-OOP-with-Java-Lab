/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asset_management;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NCC
 */
public interface I_Borrowed {
     public void add(String rID, String AssetID, String EmployeeID, int quantity, String datetime);
     //add a borrewed asset in main program
     public void output(String Employee);
     //print out the list 
     public List<Borrowed> readFile();

     public int find(String code);
     public String getcode();
     public int getnumberbyID(String ID);
     public void delete(String code);
     public String showAssetIDbyID(String ID);
}
