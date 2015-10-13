package com.evident.dao;

import com.evident.Employees.Employee;

import java.util.List;


public interface FileReader {
     List<Employee> getRoster(String fileName);
}
