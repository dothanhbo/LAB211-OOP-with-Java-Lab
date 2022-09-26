/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asset_management;

/**
 *
 * @author NCC
 */
public interface I_Request {
    public void readFile();
    //read data from file
    public void output();
    //print out the list
    public int find(String code);
    
    public void Approve(String code);
     public String getcode();
     public int getnumberbyID(String ID);
    public void add(String assetID, String employeeID);
}
