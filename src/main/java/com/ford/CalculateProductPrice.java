package com.ford;

import java.time.LocalDate;
import java.time.YearMonth;

import com.ford.util.GroceryShoppingValidationUtil;

public class CalculateProductPrice {
	
	/*
	 * Method to calculate the price of the bread
	 */
	public double calculateBreadPrice(LocalDate currentDate, double subtotal, double price, int soupQuantity,
			LocalDate purchaseDate, int qty) {
		LocalDate discountStartDate = currentDate.minusDays(1);
		LocalDate discountEndDate = discountStartDate.plusDays(7);
		if (soupQuantity > 2 && GroceryShoppingValidationUtil.validateDiscountDate(purchaseDate, discountStartDate,
				discountEndDate)) {
			int breadDiscount = (int) Math.floor(soupQuantity / 2);
			if (qty > breadDiscount) {
				subtotal = subtotal + (((qty - breadDiscount) * price) + (breadDiscount * 0.40));
			}
			if (qty < breadDiscount) {
				subtotal = subtotal + (qty * 0.40);
			}
		} else {
			subtotal = getSubTotal(subtotal, price, qty);
		}
		return subtotal;
	}

	/*
	 * Method to calculate the price of Apple
	 */
	public double calculateApplePrice(LocalDate currentDate, double subtotal, double price, LocalDate purchaseDate,
			int qty) {
		LocalDate appleDicountStartDate = currentDate.plusDays(3);
		LocalDate appleDicountEndtDate = YearMonth.from(appleDicountStartDate.plusMonths(1)).atEndOfMonth();
		if (GroceryShoppingValidationUtil.validateDiscountDate(purchaseDate, appleDicountStartDate,
				appleDicountEndtDate)) {
			subtotal = subtotal + (qty * (price - (price * 10 / 100)));
		} else {
			subtotal = getSubTotal(subtotal, price, qty);
		}
		return subtotal;
	}

	/*
	 * Method to calculate subtotal of purchased item
	 */
	public double getSubTotal(double subtotal, double price, int qty) {
		subtotal = subtotal + (qty * price);
		return subtotal;
	}

}
