package com.evident.main;

import com.evident.Employees.Employee;
import com.evident.Employees.Reports;
import com.evident.dao.CSVReader;
import com.evident.dao.FileReader;
import com.evident.helper.Options;
import com.evident.helper.OptionsImpl;

import java.io.File;
import java.util.List;

public class Main {
    public static void main(String[] args) {
       if(checkArguments(args)){
           FileReader reader = new CSVReader();
           List<Employee> roster = reader.getRoster(args[0]);
           Reports.runReport(args[1], roster);
       }
    }

    private static boolean checkArguments(String[] args) {
        Options options = new OptionsImpl();
        if(args.length==2){
            File inputFile= new File(args[0]);
            if (inputFile.exists()){
                if(options.hasOption(args[1])|| isDouble(args[1])){
                    return true;
                }
                else{
                    System.out.println("I'm sorry, we don't have the option for " + args[1]);
                    OptionsImpl.printHelp();
                }
            }
            else{
                System.out.println("There is no file by that name in that location!");
                OptionsImpl.printHelp();
            }
        }
        return false;
    }



    private static boolean isDouble(String amount) {
        Boolean parsable = true;
        String newAmount = amount.replaceAll("\\$", "").replaceAll(",", "");
        try{
            Double.parseDouble(newAmount);
        }catch(NumberFormatException e)
        {
            parsable = false;
        }
        return parsable;
    }
}
