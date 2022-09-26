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
public interface I_Asset {
    public void readFile(String fName);
    //read the file from disk
    public int find(String code);
    //find asset by ID(code)
    public void add();
    //add a new asset
    public void update();
    //update an asset
    public void searchAssetbyname();
    //search the asset by its name
    public int showquantitybyID(String ID);
    //show the asset quantity by its asset ID
    public void update(String ID, int i);
    //update an asset(change it quantity)
    public void output();
    //output
}
