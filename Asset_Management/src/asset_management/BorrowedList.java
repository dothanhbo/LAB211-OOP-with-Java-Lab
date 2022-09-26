/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asset_management;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;




/**
 *
 * @author NCC
 */
public class BorrowedList extends ArrayList<Borrowed> implements I_Borrowed {
    
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
                this.add(new Borrowed(rID, assetID, employeeID, quantity, datetime));

            }
            fr.close();
            br.close();
        } catch (Exception e) {
            System.out.println(e);
        }
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

    
   
    @Override
    public void add(String rID, String AssetID, String EmployeeID, int quantity, String datetime) {
        this.add(new Borrowed(changeID(rID), AssetID, EmployeeID, quantity, datetime));
    }
    
    @Override
    public void output() {
        for (Borrowed o : this) {
            o.showInfor();
            System.out.println();
        }
    }
    
    
    @Override
    public String changeID(String rID){
        for (int i=1 ;i<100;i++){
            if (i<10){
                rID="B00"+String.valueOf(i);
            }
            else rID="B0"+String.valueOf(i);
            boolean check =true;
            for (Borrowed o : this){
                if (o.bID.equals(rID)){
                    check=false;
                } 
            }
            if (check==true){
                break;
            }
        }
        
        return rID;
    }
        
    @Override
    public String removeCharAt(String s, int pos){
      return s.substring(0, pos) + s.substring(pos + 1);
    }
}
