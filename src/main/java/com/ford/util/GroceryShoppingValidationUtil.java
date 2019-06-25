package com.ford.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class GroceryShoppingValidationUtil {

	/*
	 * Method to validate date format
	 */
	public static LocalDate validateDateFormat(String date, Scanner input, LocalDate purchaseDate) {
		boolean flag;
		do {
			try {
				purchaseDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy[-MM[-dd]]"));
				flag = false;
			} catch (DateTimeParseException e) {
				System.out.println("Date formate is incorrect please Enter correct formate");
				date = input.next();
				flag = true;
			}
		} while (flag);
		return purchaseDate;
	}

	/*
	 * Method to validate discount price based on purchase date
	 */
	public static boolean validateDiscountDate(LocalDate purchaseDate, LocalDate appleDicountStartDate,
			LocalDate appleDicountEndtDate) {
		return (purchaseDate.equals(appleDicountStartDate) || purchaseDate.equals(appleDicountEndtDate))
				|| (purchaseDate.isAfter(appleDicountStartDate) && purchaseDate.isBefore(appleDicountEndtDate));
	}

	/*
	 * Method to validate product qty
	 */
	public static void validateProductQuantity(int qty, Scanner input) {
		while (qty < 0) {
			System.out.println("Please enter valid input");
			qty = input.nextInt();
		}
	}

	/*
	 * Method to validate product input
	 */
	public static void validateProductInput(int choice, Scanner input) {
		while (choice < 0 || choice > 4) {
			System.out.println("Please enter valid input");
			choice = input.nextInt();
		}
	}
}
