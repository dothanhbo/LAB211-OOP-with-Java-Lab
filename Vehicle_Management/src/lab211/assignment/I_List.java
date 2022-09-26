package lab211.assignment;

import java.util.ArrayList;

/* Interface for a group of objects
 */
/**
 *
 * @author Hoa Doan
 */
public interface I_List {

    int find(String code);
    // add new element( input from scanner) to I_List

    void readFile(String fName);
    //read from file

    void add(int type);
    // Input the id wanna remove

    void delete();
    // input the id want to update, after that update other information--> use set method

    void update();
    // sort list use Collections.sort(this, new Comparator<Clock>()..., sort based price or make

    void sort(ArrayList<Vehicles> Vehicle);
    // show detail of each element of List

    void output();

    void searchVehiclebyID();

    void searchVehiclebyname();

    void writeFile(ArrayList<Vehicles> Vehicle, String fName);
}
