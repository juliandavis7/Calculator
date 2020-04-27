package application;

import java.lang.*;

public class Model {
	public double calculate(long num1, long num2, String op) {
		switch (op) {
		case "+":
			return num1 + num2;
		case "-":
			return num1 - num2;
		case "*":
			return num1 * num2;
		case "/":
			if (num2 == 0) {
				System.err.println("Cannot divide by zero");
				return 0;
			}
			return num1 / num2;
		case "log":
			if (num2 <= 0) {
				System.err.println("Cannot log a non-positive number");
			}
			return Math.log(num2) / Math.log(num1); 
		default:
			return 0;
		}
	}
}
