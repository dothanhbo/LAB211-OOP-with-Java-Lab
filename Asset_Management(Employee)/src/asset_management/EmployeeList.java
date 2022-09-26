/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asset_management;


import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NCC
 */
public class EmployeeList extends ArrayList<Employee> implements I_Employee {

    public List<Employee> empList = new ArrayList<>();

    @Override
    public int find(String code) {
        int index = -1;
        index = this.indexOf(new Employee(code));
        return index;
    }

    @Override
    public void readFile() {
        if (empList.isEmpty()) {
            try {
                empList = Utils.readFile("D:\\lab3\\employee.dat", 1);
            } catch (IOException ex) {
                Logger.getLogger(EmployeeList.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(EmployeeList.class.getName()).log(Level.SEVERE, null, ex);
            }
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
