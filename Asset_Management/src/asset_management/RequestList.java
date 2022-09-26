/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asset_management;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author NCC
 */
public class RequestList extends ArrayList<Request> implements I_Request {
    
    @Override
    public void readFile(String fName) {
        try {
            File f = new File(fName);
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String detail;
            while ((detail = br.readLine()) != null) {
                StringTokenizer stk = new StringTokenizer(detail, ",");
                String rID = stk.nextToken();
                String assetID = stk.nextToken();
                String employeeID = stk.nextToken();
                int quantity = Integer.parseInt(stk.nextToken());
                String datetime = stk.nextToken();
                this.add(new Request(rID, assetID, employeeID, quantity, datetime));

            }
            fr.close();
            br.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    @Override
    public void output() {
        for (Request o : this) {
            o.showInfor();
            System.out.println();
        }
    }
    @Override
    public int find(String code) {
        int index = -1;
        index = this.indexOf(new Request(code));
        return index;
    }
    @Override
    public void Approve(String code) {        
            this.remove(new Request(code));
            
        }
    
    @Override
    public String getcode() {
        String code = Utils.getString("Input ID want to approve: ");
        int index = this.find(code);
        return code;
    }
    @Override
    public String showAssetIDbyID(String ID) {
        for (Request o : this) {
            if (o.rID.equals(ID) == true) {
                return o.getAssetID();
            }
        }
        return null;
    }
    @Override
    public int getnumberbyID(String ID) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getrID().equals(ID) == true) {
                return i;
            }
        }
        return 0;
    }
    public void writeFile(String fName){
          
     try{
            File f = new File(fName);
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
            for (int i = 0; i < this.size(); i++) {
                pw.println(this.get(i).toString());
            }
            pw.close();
            fw.close();
        } catch (IOException ex){
            System.out.println("Write file error encountered! \n" + ex);
        }
   }
}
