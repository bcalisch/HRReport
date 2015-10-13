package com.evident.Employees;


public class Employee {
    private String name;
    private String DOB;
    private double salary;
    private String role;

    public Employee() {
    }


    public String getName() {
        return name;
    }

    public String getDOB() {
        return DOB;
    }

    public double getSalary() {
        return salary;
    }

    public String getRole() {
        return role;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString(){
        String employee = "Name: " + name + " DOB: "+ DOB+ " Salary: " + salary + " Role: " + role + ".";
        return employee;
    }


    public boolean equals(Employee e1){
        if(e1.getDOB().equals(DOB)
                && (e1.getName().equals(name))
                && (e1.getRole().equals(role))
                && (e1.getSalary()== salary )){
            return true;
        }
        return false;
    }

}
