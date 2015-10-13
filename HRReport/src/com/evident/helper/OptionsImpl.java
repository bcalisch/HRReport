package com.evident.helper;

import java.util.ArrayList;
import java.util.List;

public class OptionsImpl implements Options{
   private List<String> options = new ArrayList<String>();

    public OptionsImpl(){
        options.add("-ts");
        options.add("-ts:r");
        options.add("-ts:t");
        options.add("-ts:tr");
    }

    public static void printHelp() {
        System.out.println();
        System.out.println("This program needs two parameters; a file name and the report desired");
        System.out.println("The options allowed at this time are as follows:");
        System.out.println("-ts      - Total Salary for all in the data file.");
        System.out.println("-ts:r    - Total Salary categorized by role.");
        System.out.println("-ts:t    - Total Salary divided by various amounts of time (quarterly, monthly, weekly, and hourly).");
        System.out.println("-ts:tr   - Total Salary divided by time and categorized by role");
        System.out.println("Salary total (e.g. 200,000)    - Gives all the groupings of people in the file ");
        System.out.println("                                 whose annual salary come as close to equalling");
        System.out.println("                                 the entered number without going over.");

    }


    @Override
    public boolean hasOption(String option) {
        if(options.contains(option)){
            return true;
        }
        return false;
    }

}
