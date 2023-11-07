/*
 * Copyright (c) 1979-2023, Psyh2409 and/or its affiliates. All rights reserved.
 * PSYH2409 PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.gmail.psyh2409;

/**
 * The WrongInputConsoleParametersException class was created as part of task #9 
 * for the Java_Core course by Logos_IT_Academy. It is inherited from the Exception class, 
 * which allows you to throw it to check the correct operation of the application.
 * It is used to stop the program if an incorrect argument is entered.
 * @see Months
 * @see Main
 * @author Psyh2409
 * @since 1.8
 */
public class WrongInputConsoleParametersException extends Exception{

	public WrongInputConsoleParametersException(String message) {
		super(message);
	}
}
