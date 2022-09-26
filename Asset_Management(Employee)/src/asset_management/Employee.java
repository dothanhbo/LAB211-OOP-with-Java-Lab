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
public class Employee {

    protected String employID;
    protected String name;
    protected String birthday;
    protected String role;
    protected String sex;
    protected String password;

    @Override
    public boolean equals(Object obj) {
        Employee employee = (Employee) obj;
        return this.employID.equalsIgnoreCase(employee.getEmployID());
    }

    public Employee(String employID, String name, String birthday, String role, String sex, String password) {
        this.employID = employID;
        this.name = name;
        this.birthday = birthday;
        this.role = role;
        this.sex = sex;
        this.password = password;
    }

    public Employee() {
    }

    public Employee(String employID) {
        this.employID = employID;
    }

    public String getEmployID() {
        return employID;
    }

    public void setEmployID(String employID) {
        this.employID = employID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
