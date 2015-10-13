package com.evident.Employees;

import com.evident.helper.Comparators;
import java.text.NumberFormat;
import java.util.*;

public class Reports {
    private static NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();

    /**
     *
     * @param option this determines which report to display
     * @param roster the list of employees that are being displayed
     */
    public static void runReport(String option, List<Employee> roster) {
        Double salary = 0.0;
        Double employeeSalary = 0.0;
        if (option.equals("-ts")) {
            salary = addSalary(roster, salary);
            System.out.println("Total Annual Salary is: " + currencyFormat.format(salary));
        } else if (option.equals("-ts:r")) {
            System.out.println("Running report to show totals by role.");
            printByRole(roster, employeeSalary);
        } else if (option.equals("-ts:t")) {
            System.out.println("Running report to show totals by time.");
            salary = addSalary(roster, salary);
            reportByTime(salary, "All Employees");
        } else if (option.equals("-ts:tr")) {
            System.out.println("Running report to show totals by time and role.");
            printByTimeAndRole(roster);
        } else {
            System.out.println("Running report to give all the groupings of people in the file ");
            System.out.println("whose annual salary come as close to equalling");
            System.out.println("the entered number without going over.\n");
            Double salaryCeiling = Double.parseDouble(option.replaceAll("\\$", "").replaceAll(",", ""));
            printGroups(roster, salaryCeiling);
        }

    }

    private static void printByTimeAndRole(List<Employee> roster) {
        Double employeeSalary;
        Collections.sort(roster, new Comparators.RoleComparator());
        Employee tempEmployee = roster.get(0);
        employeeSalary = 0.0;
        for (Employee employee : roster) {
            if (tempEmployee.getRole().equals(employee.getRole())) {
                employeeSalary += employee.getSalary();
            } else {
                reportByTime(employeeSalary, tempEmployee.getRole());
                employeeSalary = employee.getSalary();
                tempEmployee = employee;
            }
        }
        reportByTime(employeeSalary, tempEmployee.getRole());
    }

    private static void printByRole(List<Employee> roster, Double employeeSalary) {
        Collections.sort(roster, new Comparators.RoleComparator());
        Employee tempEmployee = roster.get(0);

        for (Employee employee : roster) {
            if (tempEmployee.getRole().equals(employee.getRole())) {
                employeeSalary += employee.getSalary();
            } else {
                System.out.println("The total salary for all " + tempEmployee.getRole() + "s: "
                        + currencyFormat.format(employeeSalary));
                employeeSalary = employee.getSalary();
                tempEmployee = employee;
            }
        }
        System.out.println("The total salary for all " + tempEmployee.getRole() + "s: "
                + currencyFormat.format(employeeSalary));
    }

    private static Double addSalary(List<Employee> roster, Double salary) {
        for (Employee employee : roster) {
            salary += employee.getSalary();
        }
        return salary;
    }

    private static void printGroup(ArrayList<Employee> rosterGroup, Double employeeSalary) {
        for (Employee employee : rosterGroup) {
            System.out.println("Total Salary: " + currencyFormat.format(employeeSalary));
            System.out.println(employee.toString());
            System.out.println();
        }
    }

    /**
     *
     * @param employees List of employees. Because of recursion, this changes throughout the calls
     * @param original Untouched list of employees
     * @param target The total dollar amount being checked against
     * @param partial partial list of employees.
     */
    private static void groupEmployees(List<Employee> employees, List<Employee> original, double target, ArrayList<Employee> partial) {
        int salarySum = 0;
        for (Employee employee : partial) salarySum += employee.getSalary();
        if ((targetReached(salarySum, target, original)) && !(salarySum > target)) {
            printEmployees(partial);
            return;
        }
        if (salarySum >= target)
            return;
        for (int i = 0; i < employees.size(); i++) {
            ArrayList<Employee> remaining = new ArrayList<Employee>();
            Employee thisEmployee = employees.get(i);
            for (int j = i + 1; j < employees.size(); j++) {
                remaining.add(employees.get(j));
            }
            ArrayList<Employee> partial_rec = new ArrayList<Employee>(partial);
            partial_rec.add(thisEmployee);
            groupEmployees(remaining, original, target, partial_rec);
        }
    }

    private static void printEmployees(ArrayList<Employee> partial) {
        String plural = "";
        if(partial.size()>1){
            plural = "s";
        }
        System.out.println("Displaying " + partial.size() + " employee"+ plural+ " in this group.");
        double totalSalary = 0.0;
        for (Employee employee : partial) {
            System.out.println(employee.toString());
            totalSalary += employee.getSalary();
        }
        System.out.println("Total Salary: " + currencyFormat.format(totalSalary)+"\n");

    }

    private static boolean targetReached(double salarySum, double target, List<Employee> employees) {
        boolean targetReached = true;
        for (Employee employee : employees) {
            if (salarySum + employee.getSalary() <= target) {
                targetReached = false;
            }
        }
        return targetReached;
    }


    private static void printGroups(List<Employee> employees, double target) {
        groupEmployees(employees, employees, target, new ArrayList<Employee>());
    }


    private static void reportByTime(double salary, String role) {
        double weeksInMonth = 4.34524;
        double hoursInWeek = 40;
        double quarterly = salary / 3;
        double monthly = salary / 12;
        double weekly = monthly / weeksInMonth;
        double hourly = weekly / hoursInWeek;

        System.out.println("Total By Time Frame for: " + role);
        System.out.println("Hourly: " + currencyFormat.format(hourly));
        System.out.println("Weekly: " + currencyFormat.format(weekly));
        System.out.println("Monthly: " + currencyFormat.format(monthly));
        System.out.println("Quarterly: " + currencyFormat.format(quarterly));
        System.out.println("Total: " + currencyFormat.format(salary));
        System.out.println();
    }
}
