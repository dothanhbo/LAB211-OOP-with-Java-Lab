/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asset_management;

import java.util.ArrayList;

/**
 *
 * @author NCC
 */
public interface I_Borrowed {
     public void add(String rID, String AssetID, String EmployeeID, int quantity, String datetime);
     //add a borrewed asset in main program
     public void output();
  
     public String changeID(String rID);
     //change rID to bID
     public String removeCharAt(String s, int pos);
     //remove a char in rID
     public void readFile(String fName);
     public void writeFile(String fName);
}
