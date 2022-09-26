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
public class Borrowed {

    protected String bID;
    protected String AssetID;
    protected String EmployeeID;
    protected int quantity;
    protected String datetime;

    public void showInfor() {
        System.out.printf("Borrowed ID: %s, Asset ID: %s, Employee ID: %s, quantity: %s, date and time: %s", bID, AssetID, EmployeeID, quantity, datetime);
    }

    public Borrowed(String bID, String AssetID, String EmployeeID, int quantity, String datetime) {
        this.bID = bID;
        this.AssetID = AssetID;
        this.EmployeeID = EmployeeID;
        this.quantity = quantity;
        this.datetime = datetime;
    }

    public Borrowed() {
    }

    public Borrowed(String bID) {
        this.bID = bID;
    }

    public String getbID() {
        return bID;
    }

    public void setbID(String bID) {
        this.bID = bID;
    }

    public String getAssetID() {
        return AssetID;
    }

    public void setAssetID(String AssetID) {
        this.AssetID = AssetID;
    }

    public String getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(String EmployeeID) {
        this.EmployeeID = EmployeeID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String toString(){
        return (bID+","+AssetID+","+EmployeeID+","+quantity+","+datetime);
    }
}
