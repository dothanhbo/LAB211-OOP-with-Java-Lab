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
public class UsingAssetList {

    public static void main(String args[]) {
        EmployeeList employee = new EmployeeList();
        employee.readFile();
        String check = employee.login();
        while (check == null) {
            System.out.println("Incorrect ID or password!");
            check = employee.login();
        }
        System.out.println("Successfully!");

        Menu menuEM = new Menu();
        menuEM.addItem("==================================");
        menuEM.addItem("Please select an option.");
        menuEM.addItem("1.Search asset by name:");
        menuEM.addItem("2.Borrow the asset:");
        menuEM.addItem("3.Cancel request:");
        menuEM.addItem("4.Return request:");
        menuEM.addItem("Others. Quit");

        Menu menuMA = new Menu();
        menuMA.addItem("==================================");
        menuMA.addItem("Please select an option.");
        menuMA.addItem("1. Search asset by name:");
        menuMA.addItem("Others. Quit.");

        AssetList asset = new AssetList();
        asset.readFile();

        int k = employee.find(check);
        switch (employee.get(k).getRole()) {
            case "MA":
                boolean checkMA = false;
                int choiceMA;
                do {
                    menuMA.showMenu();
                    choiceMA = menuMA.getChoice();
                    switch (choiceMA) {
                        case 1:
                            asset.searchAssetbyname();
                            break;

                        default:
                            checkMA = menuMA.confirmYesNo("Do you want to quit?(Y/N)");
                            break;
                    }
                } while (!checkMA);
                break;

            case "EM":
                RequestList request = new RequestList();
                request.readFile();
                BorrowedList borrowed = new BorrowedList();
                borrowed.readFile();
                boolean checkEM = false;
                int choiceEM;
                do {
                    menuEM.showMenu();
                    choiceEM = menuEM.getChoice();
                    switch (choiceEM) {
                        case 1:
                            asset.searchAssetbyname();
                            break;

                        case 2:
                            asset.output();
                            String assets = asset.check();
                            request.add(assets, employee.get(k).getEmployID());
                            break;

                        case 3:
                            boolean cancelcheck = true;
                            do {
                                request.showbyID((employee.get(k).getEmployID()));
                                String ID = null;
                                ID = request.getcode();
                                int key = request.getnumberbyID(ID);
                                String Employee = request.getEmployeeIDbyID(ID);
                                if (ID != null && request.find(ID) != -1 && Employee.equals(employee.get(k).getEmployID())) {
                                    if (Utils.confirmYesNo("Are you sure want to cancel(Y/N): ")) {
                                        request.Approve(request.get(key).getrID());
                                    }
                                } else {
                                    System.out.println("Not found the request!");
                                }
                                cancelcheck = menuEM.confirmYesNo("Do you want to continue cancle?(Y/N)");
                            } while (cancelcheck);

                            break;

                        case 4:
                            boolean returncheck = true;
                            do {
                                borrowed.output(employee.get(k).getEmployID());
                                String bID = null;
                                bID = borrowed.getcode();
                                String Employ = borrowed.getEmployeeIDbyID(bID);
                                String assetID = borrowed.showAssetIDbyID(bID);
                                int re = borrowed.getnumberbyID(bID);
                                int count = 0;
                                if (bID != null) {
                                    for (int i = 0; i < asset.size(); i++) {
                                        if (asset.get(i).getAssetID().equals(assetID) == true && Employ.equals(employee.get(k).getEmployID())) {
                                            if (Utils.confirmYesNo("Are you sure want to return(Y/N): ")) {
                                                asset.update(asset.get(i).getAssetID(), borrowed.get(re).getQuantity());
                                                borrowed.delete(bID);
                                                System.out.println("Done!");
                                                count++;
                                            }
                                        }
                                    }
                                    if (count == 0) {
                                        System.out.println("Not found the request!");
                                    }
                                }
                                returncheck = menuEM.confirmYesNo("Do you want to continue return?(Y/N)");
                            } while (returncheck);
                            break;

                        default:
                            checkEM = menuEM.confirmYesNo("Do you want to quit?(Y/N)");
                            break;
                    }
                } while (!checkEM);

        }
    }
}
