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
public interface I_Employee {
    public int find(String code);
    //find the employee to compare
    public void readFile();
    //read date from file, to get ID and password
    public String login() ;
    //login   
    public String decrypt(byte[] bytes);
}
