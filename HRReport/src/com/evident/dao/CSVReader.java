package com.evident.dao;

import com.evident.Employees.ConvertToEmployee;
import com.evident.Employees.Employee;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class CSVReader implements FileReader {

    /**
     *
     * @param fileName *include the file path if necessary
     * @return list of employees
     */
    @Override
    public List<Employee> getRoster(String fileName) {
            List<Employee> roster = new ArrayList<Employee>() {
            };
            String line;


            java.io.FileReader fileReader = null;
            try {
                File thisFile = new File(fileName);
                fileReader = new java.io.FileReader(fileName);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            BufferedReader bufferedReader = new BufferedReader(fileReader);
            try {
                int prodID = 0;
                bufferedReader.readLine();
                while ((line = bufferedReader.readLine()) != null) {
                    roster.add(ConvertToEmployee.convertToEmployee(line));
//                    employee.get(prodID).setId(++prodID);

                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            return roster;


    }
}
