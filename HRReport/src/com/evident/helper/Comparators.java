package com.evident.helper;

import com.evident.Employees.Employee;
import java.util.Comparator;

public class Comparators {

    /**
     * Sorts alphabetically
     */
    public static class RoleComparator implements Comparator<Employee> {
        @Override
        public int compare(Employee i1, Employee i2) {
            return i1.getRole().compareTo(i2.getRole());
        }
    }


}
