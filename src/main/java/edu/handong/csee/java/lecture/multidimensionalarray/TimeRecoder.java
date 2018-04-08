package edu.handong.csee.java.lecture.multidimensionalarray;

import java.util.Scanner;

public class TimeRecoder {
	
	private final int NUM_OF_WORK_DAYS = 5; // An employee works for five days from Monday to Friday 
	private int[][] workTimePerEmployee;
	private enum WeekDays {Monday, Tuesday, Wendesday, Thursday, Friday};
	private int[] totalPerWeekday = new int[WeekDays.values().length];
	private int[] totalPerEmployee;
	
	public static void main(String[] args) {
		
		TimeRecoder myTimeRecoder = new TimeRecoder();
		
		myTimeRecoder.getData();
		
		myTimeRecoder.computeTotalPerWeekDay();
		myTimeRecoder.computeTotalPerEmployee();
		
		myTimeRecoder.printResults();

	}
	
	public void getData() {
		
		Scanner myScanner = new Scanner(System.in);
		
		System.out.print("How many employees do you want" +
								"to process for their work time? ");
		
		int numOfEmployees = myScanner.nextInt();
		
		workTimePerEmployee = new int[numOfEmployees][NUM_OF_WORK_DAYS];
		
		for(int employeeCount=0; employeeCount < workTimePerEmployee.length; employeeCount++) {
			
			System.out.println("Input work time for Employee " + (employeeCount+1) + ": ");
			
			for(WeekDays currentDay:WeekDays.values()) {
				
				System.out.print("  Input work time for Employee " + (employeeCount+1) 
									+ " on " + currentDay + ": ");
				workTimePerEmployee[employeeCount][currentDay.ordinal()] = myScanner.nextInt();
			}
		}
		
		myScanner.close();	
	}
	
	public void computeTotalPerWeekDay() {
			
		for(WeekDays currentDay:WeekDays.values()) {
			
			totalPerWeekday[currentDay.ordinal()] = 0;
			
			for(int employeeCount=0; employeeCount < workTimePerEmployee.length; employeeCount++) {	
				totalPerWeekday[currentDay.ordinal()] = totalPerWeekday[currentDay.ordinal()] 
															+ workTimePerEmployee[employeeCount][currentDay.ordinal()];
			}
		}
	}
	
	public void computeTotalPerEmployee() {
		
		totalPerEmployee = new int[workTimePerEmployee.length];
		
		for(int employeeCount=0; employeeCount < workTimePerEmployee.length; employeeCount++) {
			
			totalPerEmployee[employeeCount] = 0;
		
			for(WeekDays currentDay:WeekDays.values()) {
				totalPerEmployee[employeeCount] = totalPerEmployee[employeeCount] 
															+ workTimePerEmployee[employeeCount][currentDay.ordinal()];
			}
		}
		
	}
	
	public void printResults() {
		
		System.out.println();
		
		// print the first line: Employee   1   2   3   Totals
		System.out.print("Employee" + addSpace("Employee".length()));
		
		for(int employeeCount = 0; employeeCount < workTimePerEmployee.length; employeeCount++) {
			System.out.print(employeeCount+1 + "\t");
		}
		
		System.out.print("Totals");
		System.out.println();
		
		// print work time per each weekday
		for(WeekDays currentDay:WeekDays.values()) {
			
			System.out.print(currentDay + addSpace(currentDay.name().length()));
			for(int employCount = 0; employCount < workTimePerEmployee.length ;employCount++) {
				System.out.print(workTimePerEmployee[employCount][currentDay.ordinal()] + "\t");
			}
			System.out.print(totalPerWeekday[currentDay.ordinal()]);
			System.out.println();
		}
		
		// print total per employee
		System.out.print("Total = " + addSpace("Total = ".length()));
		for(int employeeCount = 0; employeeCount < workTimePerEmployee.length; employeeCount++) {
			System.out.print(totalPerEmployee[employeeCount] +"\t");
		}
	}
	
	
	private String addSpace(int length) {
		
		final int maxWeekDayLength = 9;
		String spaces = " ";
		
		for(int spaceCount=0; spaceCount < maxWeekDayLength-length; spaceCount++) {
			spaces = spaces + " ";
		}
		
		return spaces;
	}
}
