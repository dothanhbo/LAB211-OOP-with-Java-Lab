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
        employee.readFile("D:\\lab2\\employee.dat");
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
        menuEM.addItem("Others. Quit");

        Menu menuMA = new Menu();
        menuMA.addItem("==================================");
        menuMA.addItem("Please select an option.");
        menuMA.addItem("1. Search asset by name:");
        menuMA.addItem("2. Create new asset:");
        menuMA.addItem("3. Update asset information:");
        menuMA.addItem("4. Approve the request of employee:");
        menuMA.addItem("5. Show list of borrow asset:");
        menuMA.addItem("Others. Quit.");

        AssetList asset = new AssetList();
        asset.readFile("D:\\lab2\\asset.dat");

        int k = employee.find(check);
        switch (employee.get(k).getRole()) {
            case "EM":
                boolean checkEM = false;
                int choiceEM;
                do {
                    menuEM.showMenu();
                    choiceEM = menuEM.getChoice();
                    switch (choiceEM) {
                        case 1:
                            asset.sort(asset);
                            asset.searchAssetbyname();
                            break;

                        default:
                            checkEM = menuEM.confirmYesNo("Do you want to quit?(Y/N)");
                            break;
                    }
                } while (!checkEM);
                break;

            case "MA":
                RequestList request = new RequestList();
                request.readFile("D:\\lab2\\request.dat");
                BorrowedList borrowed = new BorrowedList();
                borrowed.readFile("D:\\lab2\\borrow.dat");
                boolean checkMA = false;
                int choiceMA;
                do {
                    menuMA.showMenu();
                    choiceMA = menuMA.getChoice();
                    switch (choiceMA) {
                        case 1:
                            asset.sort(asset);
                            asset.searchAssetbyname();
                            break;

                        case 2:
                            asset.add();
                            break;

                        case 3:
                            boolean updatecheck = true;
                            do {
                                asset.update();
                                updatecheck = menuMA.confirmYesNo("Do you want to continue update?(Y/N)");
                            } while (updatecheck);

                            break;

                        case 4:
                            request.output();
                            String Re = null;
                            Re = request.getcode();
                            int count = 0;
                            int key = request.getnumberbyID(Re);
                            String assetID = request.showAssetIDbyID(Re);
                            int quantity = asset.showquantitybyID(assetID);
                            if (Re != null) {
                                for (int i = 0; i < asset.size(); i++) {
                                    if (asset.get(i).getAssetID().equals(assetID) == true) {
                                        if (quantity >= request.get(key).getQuantity()) {
                                            if (Utils.confirmYesNo("Are you sure want to approve(Y/N): ")) {
                                                borrowed.add(request.get(key).getrID(), request.get(key).getAssetID(), request.get(key).getEmployeeID(), request.get(key).getQuantity(), request.get(key).getDatetime());
                                                borrowed.writeFile("D:\\lab2\\borrow.dat");
                                                asset.update(asset.get(i).getAssetID(), request.get(key).getQuantity());
                                                asset.writeFile("D:\\lab2\\asset.dat");
                                                request.Approve(request.get(key).getrID());
                                                request.writeFile("D:\\lab2\\request.dat");
                                                System.out.println("Done!");
                                            }
                                        } else {
                                            System.out.println("Not enough assets to borrowed!");
                                        }
                                    } else {
                                        count++;
                                    }
                                }
                            }
                            if (count == asset.size()) {
                                System.out.println("Not found!");
                            }
                            break;

                        case 5:

                            borrowed.output();
                            break;

                        default:
                            checkMA = menuMA.confirmYesNo("Do you want to quit?(Y/N)");
                            break;
                    }
                } while (!checkMA);

        }
    }
}
