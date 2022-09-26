/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab211.assignment;

public class Car extends Vehicles {

    private String type;
    private int year;

    public Car(String ID, String name, String color, Integer price, String brand, String type, int year) {
        super(ID, name, color, price, brand);
        this.type = type;
        this.year = year;
    }

    @Override
    public void showInfor() {
        super.showInfor();
        System.out.printf("type: %s, year of manufacture: %s\n", type, year);
    }

    @Override
    public void update() {
        super.update();
        this.setType(Utils.updateString("new Type: ", getType()));
        this.setYear(Utils.updateInt("new year of manufacture(1-100): ", 1, 100, getYear()));
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

}
