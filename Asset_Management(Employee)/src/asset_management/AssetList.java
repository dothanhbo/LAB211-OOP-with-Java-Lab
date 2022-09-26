/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asset_management;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NCC
 */
public class AssetList extends ArrayList<Asset> implements I_Asset {

    public List<Asset> assList = new ArrayList<>();

    @Override
    public void readFile() {
        assList.clear();
        if (assList.size() == 0) {
            try {
                assList = Utils.readFile("D:\\lab2_bit\\Asset.dat", 2);
            } catch (IOException ex) {
                Logger.getLogger(AssetList.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(AssetList.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public String check() {
        String ID = null;
        do {
            ID = Utils.getString("Input Asset ID: ");
            if (find(ID) != -1) {
                break;
            } else {
                System.out.println("Duplicate ID");
            }
        } while (true);
        return ID;
    }

    @Override
    public int find(String code) {
        int index = -1;
        index = this.indexOf(new Asset(code));
        return index;
    }

    @Override
    public void searchAssetbyname() {
        String name = Utils.getString("Input name: ");
        int k = 0;
        for (Asset o : this) {
            if (o.name.toLowerCase().contains(name.toLowerCase()) == true) {
                o.showInfor();
                k++;
            }
        }
        if (k == 0) {
            System.out.println("Not found!!!");
        }
    }

    @Override
    public void update(String ID, int i) {
        for (Asset o : this) {
            if (o.assetID.equals(ID) == true) {
                o.getback(ID, i);
            }
        }
    }

    @Override
    public void output() {
        for (Asset o : this) {
            o.showInfor();
        }
    }

}
