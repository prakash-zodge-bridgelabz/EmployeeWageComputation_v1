package com.bridgelabz;

public class EmployeeWageComputation {
    //costants
    static final int IS_PART_TIME = 1;
    static final int IS_FULL_TIME = 2;
    private final String company;
    private final int empRatePerHour;
    private final int numOfWorkingDays;
    private int maxHoursPerMonth;
    private int totalEmpWage;
    EmployeeWageComputation(String company, int empRatePerHour,int numOfWorkingDays, int maxHoursPerMonth){
        this.company=company;
        this.empRatePerHour=empRatePerHour;
        this.numOfWorkingDays=numOfWorkingDays;
        this.maxHoursPerMonth=maxHoursPerMonth;
    }
    void computeEmpWage(){
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
        totalEmpWage = totalEmpHrs * empRatePerHour;
    }
    public String toString(){
        return "Total Employee Wage for Company : "+company +" is : "+totalEmpWage;
    }
    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation");
        EmployeeWageComputation dMart = new EmployeeWageComputation("Dmart",20,2,10);
        EmployeeWageComputation reliance = new EmployeeWageComputation("Reliance",10,4,20);
        dMart.computeEmpWage();
        System.out.println(dMart);
        reliance.computeEmpWage();
        System.out.println(reliance);
    }
}
