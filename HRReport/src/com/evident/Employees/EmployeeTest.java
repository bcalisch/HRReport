package com.evident.Employees;

import org.junit.Test;

/**
 * Created by benjamin on 10/11/15.
 */
public class EmployeeTest {

    @Test
    public void testEmployee_confirmEmployeeExists(){
        Employee employee = new Employee();
        employee.setDOB("01/01/1950");
        employee.setName("George Washington");
        employee.setRole("President");
        employee.setSalary(400000.00);

        org.junit.Assert.assertEquals( 400000.00, employee.getSalary(), 0.0);
        org.junit.Assert.assertTrue(employee.getDOB().equals("01/01/1950"));
        org.junit.Assert.assertTrue(employee.getName().equals("George Washington"));
        org.junit.Assert.assertTrue(employee.getRole().equals("President"));
    }
}