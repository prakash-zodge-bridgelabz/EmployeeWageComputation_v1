package com.bridgelabz;

public class EmployeeWageComputation {
    //costants
    static final int IS_PART_TIME = 1;
    static final int IS_FULL_TIME = 2;
    static int computeEmpWage(String company, int empRatePerHour,int numOfWorkingDays, int maxHoursPerMonth){
        //variables
        int empHrs = 0, totalEmpHrs = 0, totalWorkingDays = 0;
        //computation
        while(totalEmpHrs <= maxHoursPerMonth && totalWorkingDays < numOfWorkingDays){
            totalWorkingDays++;
            int empCheck = (int) Math.floor(Math.random() * 10) % 3;
            switch(empCheck){
                case IS_PART_TIME:
                    empHrs = 4;
                    break;
                case IS_FULL_TIME:
                    empHrs = 8;
                    break;
                default:
                    empHrs = 0;
            }
            totalEmpHrs += empHrs;
            System.out.println("Day: "+ totalWorkingDays+" Employee Hr: "+empHrs);
        }
        int totalEmpWage = totalEmpHrs * empRatePerHour;
        System.out.println("Total Employee Wage for Company : "+company +" is : "+totalEmpWage);
        return totalEmpWage;
    }
    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation");
        computeEmpWage("DMart",100,20,160);
        computeEmpWage("Reliance", 10, 4, 20);
    }
}
