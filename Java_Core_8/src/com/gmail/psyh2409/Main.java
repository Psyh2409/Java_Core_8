/*
 * Copyright (c) 1979-2023, Psyh2409 and/or its affiliates. All rights reserved.
 * PSYH2409 PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.gmail.psyh2409;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/** 
 * The Main class is created to implement the main method, the method for checking 
 * for correct input from the console, and methods that is allowed to study 
 * the methods and ways of working with Enums.
 * @see Seasons
 * @see Months
 * @see WrongInputConsoleParametersException
 * @author Psyh2409
 * @since 1.8
 */
public class Main {

	/**
	 * The main method implements the program entry, the console reading block 
	 * (catches IOException), the input validation block (catches 
	 * WrongInputConsoleParametersException) and the training method calls. 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Enter month:");
		String s = "";
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			s = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		
		boolean isInEnum = false;
		try {
			isInEnum = hasInEnum(s);
		} catch (WrongInputConsoleParametersException e) {
			e.printStackTrace();
		}
	        	
		
		if(isInEnum) {
		System.out.println("Print all months with the same season:");
		allMonthsOfSeason(s);
		System.out.println("Print all months with the same number of days:");
		allMonthsWithSameDays(s);
		System.out.println("Display all months with less than the same number of days:");
		allMonthsWithLessDays(s);
		System.out.println("Display all months with more days:");
		allMonthsWithMoreDays(s);
		System.out.println("Display the next season:");
		nextSeason(s);
		System.out.println("Display the previous season:");
		previousSeason(s);
		System.out.println("Display all months with an even number of days:");
		allEven();
		System.out.println("Display all months with an odd number of days:");
		allOdd();
		System.out.println("Display if the month entered from the console has an even number of days:");
		isEven(s);
		}
		
	}
	
	/**
	 *  It checks the correctness of input from the console, passes  exception to a higher level.
	 * @param String s
	 * @return boolean
	 * @throws WrongInputConsoleParametersException
	 */
	public static boolean hasInEnum(String s) throws WrongInputConsoleParametersException {
		boolean isInEnum;
		Months mnth = null;
	        for (Months m : Months.values()) {
	            if (m.name().equalsIgnoreCase(s)) {
	                mnth = m;
	            }
	        }
	        if (mnth!=null) {
	        	System.out.println("Month " + s + " is in Enum like: " + mnth);
	        	isInEnum = true;
	        }else  {
				isInEnum = false;
				throw new WrongInputConsoleParametersException("Invalid month!");
	        }
		return isInEnum;
	}
	
	/**
	 * Displays if the month entered from the console has an even number of days
	 * @param String s
	 */
	public static void isEven(String s) {
		System.out.println(Months.valueOf(s.toUpperCase()) + (Months.valueOf(s.toUpperCase()).getDays()%2==0 ? " has even number of days." : " has odd number of days."));
	}
	
	/**
	 *  Displays all months with an odd number of days
	 */
	public static void allOdd() {
		for (int i = 0; i < Months.values().length; i++) {
			if(Months.values()[i].getDays()%2!=0) {
				System.out.println(Months.values()[i]);
			}
		}
	}
	
	/**
	 *  Displays all months with an even number of days
	 */
	public static void allEven() {
		for (int i = 0; i < Months.values().length; i++) {
			if(Months.values()[i].getDays()%2==0) {
				System.out.println(Months.values()[i]);
			}
		}
	}
	
	/**
	 *  Displays all months with more days
	 * @param String s
	 */
	public static void allMonthsWithMoreDays(String s) {
		for (int i = 0; i < Months.values().length; i++) {
			if(Months.valueOf(s.toUpperCase()).getDays() < Months.values()[i].getDays()) {
				System.out.println(Months.values()[i]);
			}
		}
	}
	
	/**
	 *  Displays all months with less than the same number of days
	 * @param String s
	 */
	public static void allMonthsWithLessDays(String s) {
		for (int i = 0; i < Months.values().length; i++) {
			if(Months.valueOf(s.toUpperCase()).getDays() > Months.values()[i].getDays()) {
				System.out.println(Months.values()[i]);
			}
		}
	}
	
	/**
	 *  Prints all months with the same number of days
	 * @param String s
	 */
	public static void allMonthsWithSameDays(String s) {
		for (int i = 0; i < Months.values().length; i++) {
			if(Months.valueOf(s.toUpperCase()).getDays() == Months.values()[i].getDays()) {
				System.out.println(Months.values()[i]);
			}
		}
	}
	
	/**
	 *  Prints all months with the same season
	 * @param String s
	 */
	public static void allMonthsOfSeason(String s) {
		for (int i = 0; i < Months.values().length; i++) {
			if(Months.valueOf(s.toUpperCase()).getSeasons() == Months.values()[i].getSeasons()) {
				System.out.println(Months.values()[i]);
			}
		}
	}
	
	/**
	 *  Displays the next season
	 * @param String s
	 */
	public static void nextSeason(String s) {
		for (int i = 0; i < Seasons.values().length; i++) {
			if(Months.valueOf(s.toUpperCase()).getSeasons() == Seasons.values()[i]) {
				System.out.println(Seasons.values()[i==Seasons.values().length-1 ? 0 : i+1]);
			}
		}
	}
	
	/**
	 *  Displays the previous season
	 * @param String s
	 */
	public static void previousSeason(String s) {
		for (int i = 0; i < Seasons.values().length; i++) {
			if(Months.valueOf(s.toUpperCase()).getSeasons() == Seasons.values()[i]) {
				System.out.println(Seasons.values()[i==0 ? Seasons.values().length-1 : i-1]);
			}
		}
	}
} 

/* Output 1:
Enter month:
Lystopad
com.gmail.psyh2409.WrongInputConsoleParametersException: Invalid month!
	at com.gmail.psyh2409.Main.hasInEnum(Main.java:63)
	at com.gmail.psyh2409.Main.main(Main.java:21)

 * Output 2:
Enter month:
JaNuary
Month JaNuary is in Enum like: Months{month=JANUARY
days=31
season=WINTER}
Print all months with the same season:
Months{month=JANUARY
days=31
season=WINTER}
Months{month=FEBRUARY
days=28
season=WINTER}
Months{month=DECEMBER
days=31
season=WINTER}
Print all months with the same number of days:
Months{month=JANUARY
days=31
season=WINTER}
Months{month=MARCH
days=31
season=SPRING}
Months{month=MAY
days=31
season=SPRING}
Months{month=JULY
days=31
season=SUMMER}
Months{month=AUGUST
days=31
season=SUMMER}
Months{month=DECEMBER
days=31
season=WINTER}
Display all months with less than the same number of days:
Months{month=FEBRUARY
days=28
season=WINTER}
Months{month=APRIL
days=30
season=SPRING}
Months{month=JUNE
days=30
season=SUMMER}
Months{month=SEPTEMBER
days=30
season=AUTUMN}
Months{month=OCTOBER
days=30
season=AUTUMN}
Months{month=NOVEMBER
days=30
season=AUTUMN}
Display all months with more days:
Display the next season:
SPRING
Display the previous season:
AUTUMN
Display all months with an even number of days:
Months{month=FEBRUARY
days=28
season=WINTER}
Months{month=APRIL
days=30
season=SPRING}
Months{month=JUNE
days=30
season=SUMMER}
Months{month=SEPTEMBER
days=30
season=AUTUMN}
Months{month=OCTOBER
days=30
season=AUTUMN}
Months{month=NOVEMBER
days=30
season=AUTUMN}
Display all months with an odd number of days:
Months{month=JANUARY
days=31
season=WINTER}
Months{month=MARCH
days=31
season=SPRING}
Months{month=MAY
days=31
season=SPRING}
Months{month=JULY
days=31
season=SUMMER}
Months{month=AUGUST
days=31
season=SUMMER}
Months{month=DECEMBER
days=31
season=WINTER}
Display if the month entered from the console has an even number of days:
Months{month=JANUARY
days=31
season=WINTER} has odd number of days.

 * */
