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
public class Request {

    protected String rID;
    protected String AssetID;
    protected String EmployeeID;
    protected int quantity;
    protected String datetime;

    public void showInfor() {
        System.out.printf("Request ID: %s, Asset ID: %s, Employee ID: %s, quantity: %s, date and time: %s", rID, AssetID, EmployeeID, quantity, datetime);
    }

    @Override
    public boolean equals(Object obj) {
        Request request = (Request) obj;
        return this.rID.equalsIgnoreCase(request.getrID());
    }

    public Request(String rID, String AssetID, String EmployeeID, int quantity, String datetime) {
        this.rID = rID;
        this.AssetID = AssetID;
        this.EmployeeID = EmployeeID;
        this.quantity = quantity;
        this.datetime = datetime;
    }

    public Request() {
    }

    public Request(String rID) {
        this.rID = rID;
    }

    public String getrID() {
        return rID;
    }

    public void setrID(String rID) {
        this.rID = rID;
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
        return (rID+","+AssetID+","+EmployeeID+","+quantity+","+datetime);
    }

}
