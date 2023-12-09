package com.bridgelabz;

class CompanyEmpWage{
    final String company;
    final int empRatePerHour, numOfWorkingDays, maxHoursPerMonth;
    int totalEmpWage;
    CompanyEmpWage(String company, int empRatePerHour,int numOfWorkingDays, int maxHoursPerMonth){
        this.company=company;
        this.empRatePerHour=empRatePerHour;
        this.numOfWorkingDays=numOfWorkingDays;
        this.maxHoursPerMonth=maxHoursPerMonth;
    }
    void setTotalEmpWage(int totalEmpWage){
        this.totalEmpWage = totalEmpWage;
    }
    public String toString(){
        return "Total Employee Wage for Company : "+company +" is : "+totalEmpWage;
    }
}
class EmployeeWageComputation {
    static final int IS_PART_TIME=1, IS_FULL_TIME=2;
    private int numOfCompany = 0;
    private CompanyEmpWage[] companyEmpWageArray;

    EmployeeWageComputation(){
        companyEmpWageArray = new CompanyEmpWage[5];
    }
    private void addCompanyEmpWage(String company, int empRatePerHour,int numOfWorkingDays, int maxHoursPerMonth){
        companyEmpWageArray[numOfCompany] = new CompanyEmpWage(company, empRatePerHour, numOfWorkingDays, maxHoursPerMonth);
        numOfCompany++;
    }
    void computeEmpWage() {
        for (int i = 0; i < numOfCompany; i++) {
            companyEmpWageArray[i].setTotalEmpWage(this.computeEmpWage(companyEmpWageArray[i]));
            System.out.println(companyEmpWageArray[i]);
        }
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

    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation");
        EmployeeWageComputation empWageBuilder = new EmployeeWageComputation();
        empWageBuilder.addCompanyEmpWage("DMart",20,2,10);
        empWageBuilder.addCompanyEmpWage("Reliance",10,4,20);
        empWageBuilder.computeEmpWage();
    }
}
