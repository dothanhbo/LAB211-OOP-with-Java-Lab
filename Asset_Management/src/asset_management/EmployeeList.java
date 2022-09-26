/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asset_management;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;




/**
 *
 * @author NCC
 */
public class EmployeeList extends ArrayList<Employee> implements I_Employee {
    @Override
    public int find(String code) {
        int index = -1;
        index = this.indexOf(new Employee(code));
        return index;
    }
    @Override
    public void readFile(String fName) {
        try {
            File f = new File(fName);
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String detail;
            while ((detail = br.readLine()) != null) {
                StringTokenizer stk = new StringTokenizer(detail, ",");
                String ID = stk.nextToken();
                String name = stk.nextToken();
                String birthday = stk.nextToken();
                String role = stk.nextToken();
                String sex = stk.nextToken();
                String password = stk.nextToken();
                this.add(new Employee(ID, name, birthday, role, sex, password));

            }
            fr.close();
            br.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    @Override
    public String login() {
        String ID = Utils.getString("Enter the EmployeeID: ");
        String password = Utils.getString("Enter the password: ");
        byte[] pass = digest(password.getBytes(UTF_8));
        for (Employee o : this) {
            if ((o.employID.equals(ID) == true) & (o.password.equals(decrypt(pass)) == true)) {
                return o.getEmployID();
            }
        }
        return null;
    }
    private byte[] digest(byte[] input) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException(e);
        }
        byte[] result = md.digest(input);
        return result;
    }
    @Override
    public String decrypt(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();

}
    private static final Charset UTF_8 = StandardCharsets.UTF_8;

}
