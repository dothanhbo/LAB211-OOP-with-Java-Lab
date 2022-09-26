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
    public void readFile();
    //read the file from disk
    public int find(String code);
    //find asset by ID(code)
    
    //add a new asset
   
    //update an asset
    public void searchAssetbyname();
    //search the asset by its name
   public void update(String ID, int i);
    public void output();
    public String check();
    //output
}
