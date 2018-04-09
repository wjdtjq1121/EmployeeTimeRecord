package edu.handong.csee.java.lecture.multidimensionalarray;

import java.util.Scanner;

public class TimeRecorder {
	
	private final int NUM_OF_WORK_DAYS = 5; // An employee works for five days from Monday to Friday 
	private int[][] hours;
	private enum WeekDays {Monday, Tuesday, Wendesday, Thursday, Friday};
	private int[] dayHours = new int[WeekDays.values().length];
	private int[] weekHours;
	
	public static void main(String[] args) {
		
		TimeRecorder myTimeRecoder = new TimeRecorder();
		
		myTimeRecoder.getData();
		
		myTimeRecoder.computeTotals();
		
		myTimeRecoder.printResults();

	}
	
	public void getData() {
		
		Scanner myScanner = new Scanner(System.in);
		
		System.out.print("How many employees do you want" +
								"to process for their work time? ");
		
		int numOfEmployees = myScanner.nextInt();
		
		hours = new int[numOfEmployees][NUM_OF_WORK_DAYS];
		
		for(int employeeCount=0; employeeCount < hours.length; employeeCount++) {
			
			System.out.println("Input work time for Employee " + (employeeCount+1) + ": ");
			
			for(WeekDays currentDay:WeekDays.values()) {
				
				System.out.print("  Input work time for Employee " + (employeeCount+1) 
									+ " on " + currentDay + ": ");
				hours[employeeCount][currentDay.ordinal()] = myScanner.nextInt();
			}
		}
		
		myScanner.close();	
	}
	// // 
	public void computeTotals() {
		
		weekHours = new int[hours.length];
		
		for(WeekDays currentDay:WeekDays.values()) {
			
			dayHours[currentDay.ordinal()] = 0;
			
			for(int employeeCount=0; employeeCount < hours.length; employeeCount++) {	
				dayHours[currentDay.ordinal()] = dayHours[currentDay.ordinal()] 
															+ hours[employeeCount][currentDay.ordinal()];
			}
		}
		
		
		
		for(int employeeCount=0; employeeCount < hours.length; employeeCount++) {
			
			weekHours[employeeCount] = 0;
		
			for(WeekDays currentDay:WeekDays.values()) {
				weekHours[employeeCount] = weekHours[employeeCount] 
															+ hours[employeeCount][currentDay.ordinal()];
			}
		}
		
	}
	
	
	
	public void printResults() {
		
		System.out.println();
		
		// print the first line: Employee   1   2   3   Totals
		System.out.print("Employee" + addSpace("Employee".length()));
		
		for(int employeeCount = 0; employeeCount < hours.length; employeeCount++) {
			System.out.print(employeeCount+1 + "\t");
		}
		
		System.out.print("Totals");
		System.out.println();
		
		// print work time per each weekday
		for(WeekDays currentDay:WeekDays.values()) {
			
			System.out.print(currentDay + addSpace(currentDay.name().length()));
			for(int employCount = 0; employCount < hours.length ;employCount++) {
				System.out.print(hours[employCount][currentDay.ordinal()] + "\t");
			}
			System.out.print(dayHours[currentDay.ordinal()]);
			System.out.println();
		}
		
		// print total per employee
		System.out.print("Total = " + addSpace("Total = ".length()));
		for(int employeeCount = 0; employeeCount < hours.length; employeeCount++) {
			System.out.print(weekHours[employeeCount] +"\t");
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

