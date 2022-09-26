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
public class Asset {

    protected String assetID;
    protected String name;
    protected String color;
    protected int price;
    protected double weight;
    protected int quantity;

    public void showInfor() {
        System.out.printf("ID: %s, name: %s, color: %s, price: %s, weight: %s, quantity: %s", assetID, name, color, price, weight, quantity);
        System.out.println();
    }

    @Override
    public boolean equals(Object obj) {
        Asset asset = (Asset) obj;
        return this.assetID.equalsIgnoreCase(asset.getAssetID());
    }

    public Asset(String assetID) {
        this.assetID = assetID;
    }

    public void borrowed(String ID, int i) {
        this.quantity = (this.quantity - i);
    }

    public void update() {
        this.setName(Utils.updateString("New name: ", getName()));
        this.setColor(Utils.updateString("New color: ", getColor()));
        this.setPrice(Utils.updateInt("New price(1-10000): ", 1, 10000, getPrice()));
        this.setWeight(Utils.updateDouble("New weight(0.01-20): ", 0.01, 20, getWeight()));
        this.setQuantity(Utils.updateInt("New quantity(1-1000): ", 1, 1000, getQuantity()));
    }

    public Asset(String assetID, String name, String color, int price, double weight, int quantity) {
        this.assetID = assetID;
        this.name = name;
        this.color = color;
        this.price = price;
        this.weight = weight;
        this.quantity = quantity;
    }

    public Asset() {
    }

    public String getAssetID() {
        return assetID;
    }

    public void setAssetID(String assetID) {
        this.assetID = assetID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
     public String toString(){
        return (assetID+","+name+","+color+","+price+","+weight+","+quantity);
    }
}
