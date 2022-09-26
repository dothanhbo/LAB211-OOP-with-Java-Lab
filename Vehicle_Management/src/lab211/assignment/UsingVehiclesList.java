package lab211.assignment;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
* This is comment, do not delete 2021.10.31
 * and open the template in the editor.
 */
/**
 *
 * @author Hoa Doan
 */
public class UsingVehiclesList {

    public static void main(String args[]) {
        Menu menu = new Menu();
        menu.addItem("==================================");
        menu.addItem("Please select an option.");
        menu.addItem("1. Load data from file:");
        menu.addItem("2. Add new vehicle:");
        menu.addItem("3. Update vehicle by ID:");
        menu.addItem("4. Delete vehicle by ID:");
        menu.addItem("5. Search vehicle:");
        menu.addItem("6. Show vehicle list:");
        menu.addItem("7. Store date to file:");
        menu.addItem("Others. Quit");

        Menu subMenu1 = new Menu();
        subMenu1.addItem("1. Car");
        subMenu1.addItem("2. Motobike");

        Menu subMenu2 = new Menu();
        subMenu2.addItem("1. Search by name(descending):");
        subMenu2.addItem("2. Search by id:");

        Menu subMenu3 = new Menu();
        subMenu3.addItem("1. Show all:");
        subMenu3.addItem("2. Show all(descending by price):");

        VehicleList list = new VehicleList();
        int choice;
        boolean cont = false;

        do {
            menu.showMenu();
            choice = menu.getChoice();

            switch (choice) {
                case 1:
                    list.readFile("D:\\lab1\\input.txt");
                    break;

                case 2: {
                    subMenu1.showMenu();
                    int schoice1 = subMenu1.getChoice();
                    switch (schoice1) {
                        case 1: {
                            list.add(1);
                            break;
                        }

                        case 2: {
                            list.add(2);
                            break;
                        }
                    }
                    break;
                }

                case 3:
                    list.update();
                    break;

                case 4:
                    list.delete();
                    break;

                case 5: {
                    subMenu2.showMenu();
                    int schoice2 = subMenu2.getChoice();
                    switch (schoice2) {
                        case 1: {
                            list.sort(list);
                            list.searchVehiclebyname();
                            break;
                        }
                        case 2: {
                            list.searchVehiclebyID();
                            break;
                        }
                    }
                    break;
                }
                case 6: {
                    subMenu3.showMenu();
                    int schoice3 = subMenu3.getChoice();
                    switch (schoice3) {
                        case 1: {
                            list.output();
                            break;
                        }
                        case 2: {
                            list.sort(list);
                            list.output();
                            break;
                        }
                    }

                }

                case 7:
                    list.writeFile(list, "D:\\lab1\\output.txt");
                    break;
                default:
                    cont = menu.confirmYesNo("Do you want to quit?(Y/N)");
                    break;
            }
        } while (!cont);
    }
}
