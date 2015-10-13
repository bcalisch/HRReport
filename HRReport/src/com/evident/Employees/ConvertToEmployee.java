package com.evident.Employees;


/**
 * Class to convert Employee from String.
 */
public class ConvertToEmployee {
    /**
     * this converts the CSV string line to a new Employee
     *
     * @param line string that contains all the product information
     * @return returns the employee as an object back to the caller.
     */
    public static Employee convertToEmployee(String line) {
        String[] row = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
        Employee employee = new Employee();
        String thisLine;
        for (int i = 0; i < row.length; i++) {
            switch (i) {
                case (0):
                    employee.setName(row[i]);
                    break;
                case (1):
                    employee.setDOB(row[i]);
                    break;
                case (2):
                    thisLine = row[i];
                        employee.setSalary(Double.parseDouble(thisLine.replaceAll("\\$", "").replaceAll("\"", "").replaceAll(",", "")));
                        break;
                case (3):
                    employee.setRole(row[i]);
            }
        }
        return employee;
    }
}
