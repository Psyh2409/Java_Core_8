/*
 * Copyright (c) 1979-2023, Psyh2409 and/or its affiliates. All rights reserved.
 * PSYH2409 PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.gmail.psyh2409;
/**
 * Enum is designed to list months with two fields: days and season. The season field is 
 * represented by an object of another enum Seasons. The enum has a constructor with 
 * the appropriate parameters, getters, and the toString method.
 * @see Seasons
 * @see Main
 * @author Psyh2409
 * @since 1.8
 */
public enum Months {
	
JANUARY(31, Seasons.WINTER),
FEBRUARY(28, Seasons.WINTER),
MARCH(31, Seasons.SPRING),
APRIL(30, Seasons.SPRING),
MAY(31, Seasons.SPRING),
JUNE(30, Seasons.SUMMER),
JULY(31, Seasons.SUMMER),
AUGUST(31, Seasons.SUMMER),
SEPTEMBER(30, Seasons.AUTUMN),
OCTOBER(30, Seasons.AUTUMN),
NOVEMBER(30, Seasons.AUTUMN),
DECEMBER(31, Seasons.WINTER);

	private int days;
	private Seasons seasons;

	private Months(int days, Seasons seasons) {
		this.days = days;
		this.seasons = seasons;
	}

	public int getDays() {
		return days;
	}

	public Seasons getSeasons() {
		return seasons;
	}

	@Override
	   public String toString() {
	       return "Months{" +
	    		   "month=" + this.name() + '\n' +
	               "days=" + days + '\n' +
	               "season=" + seasons + '}';
	   }
}
