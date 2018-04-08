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

	}
	
	public void getData() {
		
		Scanner myScanner = new Scanner(System.in);
		
		System.out.print("How many employees do you want" +
								"to process for their work time?");
		
		int numOfEmployees = myScanner.nextInt();
		
		workTimePerEmployee = new int[numOfEmployees][NUM_OF_WORK_DAYS];
		
		for(int employeeCount=0; employeeCount < workTimePerEmployee.length; employeeCount++) {
			
			System.out.print("Input work time for Employee " + (employeeCount+1) + ": ");
			
			for(WeekDays currentDay:WeekDays.values()) {
				
				System.out.print("Input work time for Employee " + (employeeCount+1) 
									+ " on " + currentDay + ": ");
				workTimePerEmployee[employeeCount][currentDay.ordinal()] = myScanner.nextInt();
			}
		}
		
		myScanner.close();	
	}
	
	public void computeTotalPerWeekDay() {
		
	}
	
	public void computeTotalPerEmployee() {
		
	}
}
