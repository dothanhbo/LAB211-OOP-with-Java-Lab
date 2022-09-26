/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab211.assignment;

public class Motobike extends Vehicles {

    private int speed;
    private String license;

    public Motobike(String ID, String name, String color, Integer price, String brand, int speed, String license) {
        super(ID, name, color, price, brand);
        this.speed = speed;
        this.license = license;
    }

    @Override
    public void showInfor() {
        super.showInfor();
        System.out.printf("speed: %s, Require license: %s, ", speed, license);
        Sound();
        System.out.println();
    }

    @Override
    public void update() {
        super.update();
        this.setSpeed(Utils.updateInt("new Speed(1-200): ", 1, 200, getSpeed()));
        this.setLicense(Utils.updateString("newLicense: ", getLicense()));
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public void Sound() {
        System.out.printf("Tin Tin Tin");
    }

}
