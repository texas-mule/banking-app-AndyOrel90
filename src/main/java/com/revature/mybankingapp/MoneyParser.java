package com.revature.mybankingapp;

import java.text.DecimalFormat;
import java.text.ParseException;

public class MoneyParser {
	private DecimalFormat df = new DecimalFormat("#");

	public MoneyParser() {
		this.df.setMaximumFractionDigits(2);
		this.df.setMaximumIntegerDigits(12);
	}

	public double parse(double input) {
		String inputString = this.df.format(input);

		try {
			return Double.valueOf(df.parse(inputString).doubleValue());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
}
