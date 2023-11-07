package com.gmail.psyh2409;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	
	public static void main(String[] args) {
		System.out.println("Enter month:");
		String s = "";
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			s = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		Months[] months = Months.values();
		boolean isInEnum = false;
		String month = "";
		try {
		System.out.println("Month " + s + " is in Enum like: " + Months.valueOf(s.toUpperCase()).toString());
		isInEnum = true;
		}catch (IllegalArgumentException iae){
			System.out.println("Invalid month!");
			isInEnum = false;
		}
		if(isInEnum) {
		System.out.println("Print all months with the same season:");
		allMonthsOfSeason(s);
		System.out.println("Print all months with the same number of days:");
		allMonthsWithSameDays(s);
		System.out.println("Display all months with less than the same number of days:");
		allMonthsWithLassDays(s);
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
		
		
//		System.out.println(Arrays.toString(months));
	}
	
	public static void isEven(String s) {
		System.out.println(Months.valueOf(s.toUpperCase()) + (Months.valueOf(s.toUpperCase()).getDays()%2==0 ? " has even number of days." : " has odd number of days."));
	}

	public static void allOdd() {
		for (int i = 0; i < Months.values().length; i++) {
			if(Months.values()[i].getDays()%2!=0) {
				System.out.println(Months.values()[i]);
			}
		}
	}

	public static void allEven() {
		for (int i = 0; i < Months.values().length; i++) {
			if(Months.values()[i].getDays()%2==0) {
				System.out.println(Months.values()[i]);
			}
		}
	}

	public static void allMonthsWithMoreDays(String s) {
		for (int i = 0; i < Months.values().length; i++) {
			if(Months.valueOf(s.toUpperCase()).getDays() < Months.values()[i].getDays()) {
				System.out.println(Months.values()[i]);
			}
		}
	}
	
	public static void allMonthsWithLassDays(String s) {
		for (int i = 0; i < Months.values().length; i++) {
			if(Months.valueOf(s.toUpperCase()).getDays() > Months.values()[i].getDays()) {
				System.out.println(Months.values()[i]);
			}
		}
	}
	
	public static void allMonthsWithSameDays(String s) {
		for (int i = 0; i < Months.values().length; i++) {
			if(Months.valueOf(s.toUpperCase()).getDays() == Months.values()[i].getDays()) {
				System.out.println(Months.values()[i]);
			}
		}
	}
	
	public static void allMonthsOfSeason(String s) {
		for (int i = 0; i < Months.values().length; i++) {
			if(Months.valueOf(s.toUpperCase()).getSeasons() == Months.values()[i].getSeasons()) {
				System.out.println(Months.values()[i]);
			}
		}
	}
	
	public static void nextSeason(String s) {
		for (int i = 0; i < Seasons.values().length; i++) {
			if(Months.valueOf(s.toUpperCase()).getSeasons() == Seasons.values()[i]) {
				System.out.println(Seasons.values()[i==Seasons.values().length-1 ? 0 : i+1]);
			}
		}
	}
	
	public static void previousSeason(String s) {
		for (int i = 0; i < Seasons.values().length; i++) {
			if(Months.valueOf(s.toUpperCase()).getSeasons() == Seasons.values()[i]) {
				System.out.println(Seasons.values()[i==0 ? Seasons.values().length-1 : i-1]);
			}
		}
	}
}
/*Output:
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
