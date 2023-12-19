package com.bridgelabz;
// UC 14
// Ability to get the Total Wage when queried by Company.

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

interface IComputeEmpWage{
    void addCompanyEmpWage(String company, int empRatePerHour,int numOfWorkingDays, int maxHoursPerMonth);
    void computeEmpWage();
    int getTotalWage(String company);           // Get the total wage when queried by company
}
class CompanyEmpWage{
    String company;
    int empRatePerHour, numOfWorkingDays, maxHoursPerMonth,totalEmpWage;
    int daily_wage;
    CompanyEmpWage(String company, int empRatePerHour,int numOfWorkingDays, int maxHoursPerMonth){
        this.company=company;
        this.empRatePerHour=empRatePerHour;
        this.numOfWorkingDays=numOfWorkingDays;
        this.maxHoursPerMonth=maxHoursPerMonth;
    }
    void setTotalEmpWage(int totalEmpWage){
        this.totalEmpWage = totalEmpWage;
    }
    void setDaily_wage(int daily_wage){         // Stores daily wage
        this.daily_wage = daily_wage;
    }
    public String toString(){
        return "Total Employee Wage for Company : "+company +" is : "+totalEmpWage+", Daily wage : "+daily_wage;
    }
}
class EmployeeWageComputation implements IComputeEmpWage{
    final int IS_PART_TIME=1, IS_FULL_TIME=2;
    int numOfCompany = 0;
    LinkedList<CompanyEmpWage> companyEmpWageList;              //Linked list of class
    Map<String, CompanyEmpWage> companyEmpWageMap;              // Hash map with named_company and company class

    EmployeeWageComputation(){
        companyEmpWageList = new LinkedList<>();
        companyEmpWageMap = new HashMap<>();
    }
    public void addCompanyEmpWage(String company, int empRatePerHour,int numOfWorkingDays, int maxHoursPerMonth){

        CompanyEmpWage companyEmpWage  = new CompanyEmpWage(company, empRatePerHour, numOfWorkingDays, maxHoursPerMonth);
        companyEmpWageList.add(companyEmpWage);
        companyEmpWageMap.put(company,companyEmpWage);
    }
    public void computeEmpWage() {
        for (int i = 0; i < companyEmpWageList.size(); i++) {
            CompanyEmpWage companyEmpWage = companyEmpWageList.get(i);
            companyEmpWage.setTotalEmpWage(this.computeEmpWage(companyEmpWage));
            //Daily wage = Day hours * rate per hour
            companyEmpWage.setDaily_wage(this.daily_wage(companyEmpWage));
            System.out.println(companyEmpWage);
        }
    }
    int daily_wage(CompanyEmpWage companyEmpWage){      //Calculated daily wage
        //variables
        int daily_wage,day_hour;
        day_hour = companyEmpWage.maxHoursPerMonth / companyEmpWage.numOfWorkingDays;
        daily_wage = day_hour * companyEmpWage.empRatePerHour;
        return daily_wage;
    }
    private int computeEmpWage(CompanyEmpWage companyEmpWage){
        //variables
        int empHrs = 0, totalEmpHrs = 0, totalWorkingDays = 0;
        //computation
        while(totalEmpHrs <= companyEmpWage.maxHoursPerMonth && totalWorkingDays < companyEmpWage.numOfWorkingDays){
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
        return totalEmpHrs * companyEmpWage.empRatePerHour;
    }
    public int getTotalWage(String company){
        return companyEmpWageMap.get(company).totalEmpWage;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation");
        EmployeeWageComputation empWageBuilder = new EmployeeWageComputation();
        empWageBuilder.addCompanyEmpWage("DMart",300,21,100);
        empWageBuilder.addCompanyEmpWage("Reliance",250,25,100);
        empWageBuilder.computeEmpWage();
        System.out.println("Total wage for Reliance company : "+empWageBuilder.getTotalWage("Reliance"));
    }
}
