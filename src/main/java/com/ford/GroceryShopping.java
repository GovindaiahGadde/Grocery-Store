package com.ford;

import java.time.LocalDate;
import java.util.Scanner;

import com.ford.util.GroceryShoppingValidationUtil;

/*
 * GroceryShopping 
 * @Author Govindaiah
 * 
 * This class is to calculate total price of purchased products
 */
public class GroceryShopping {

	public static void main(String args[]) {

		Scanner input = new Scanner(System.in);

		LocalDate currentDate = LocalDate.now();

		int choice = 1;
		double subtotal = 0;
		double price = 0;
		int soupQuantity = 0;
		CalculateProductPrice productPrice = new CalculateProductPrice();
		LocalDate purchaseDate = null;
		System.out.println("Enter the date of puchasing and date formate is yyyy-MM-dd");
		String date = input.next();
		purchaseDate = GroceryShoppingValidationUtil.validateDateFormat(date, input, purchaseDate);

		do {
			System.out.println("Welcome to GroceryStore-Billing");
			System.out.println();
			System.out.println("Product     unit      cost");
			System.out.println("==========================");
			System.out.println("1.soup      tin       0.65");
			System.out.println("2.bread     loaf      0.80");
			System.out.println("3.milk      bottle    1.30");
			System.out.println("4.apples    single    0.10");
			System.out.println();
			System.out.println("0. Quit");
			System.out.println("");

			System.out.println("Please Select Product Number or Enter 0 to exit");
			choice = input.nextInt();
			GroceryShoppingValidationUtil.validateProductInput(choice, input);
			if (choice == 0)
				break;

			System.out.println("Enter Quantity?");
			int qty = input.nextInt();
			GroceryShoppingValidationUtil.validateProductQuantity(qty, input);
			switch (choice) {
			case 1:
				soupQuantity = qty;
				price = 0.65;
				subtotal = productPrice.getSubTotal(subtotal, price, qty);
				break;
			case 2:
				price = 0.80;
				subtotal = productPrice.calculateBreadPrice(currentDate, subtotal, price, soupQuantity, purchaseDate,
						qty);
				break;
			case 3:
				price = 1.30;
				subtotal = productPrice.getSubTotal(subtotal, price, qty);
				break;
			case 4:
				price = 0.10;
				subtotal = productPrice.calculateApplePrice(currentDate, subtotal, price, purchaseDate, qty);
				break;
			default:
				break;
			}
		}

		while (choice > 0);
		System.out.println("Total price : " + subtotal);

	}

}
