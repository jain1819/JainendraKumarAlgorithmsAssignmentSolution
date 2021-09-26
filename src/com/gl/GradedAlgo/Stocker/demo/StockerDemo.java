package com.gl.GradedAlgo.Stocker.demo;

import java.util.Scanner;
import java.util.Arrays;
import java.util.InputMismatchException;

import com.gl.GradedAlgo.Stocker.service.*;

public class StockerDemo {

	private static Scanner scr;

	public static void main(String[] args) throws InputMismatchException {
		try {// try catch block to handle mismatch exception
			scr = new Scanner(System.in);
			// calling service methods from different package of project
			MergeAscending Ma = new MergeAscending();
			MergeDescending Md = new MergeDescending();
			MainOption Mo = new MainOption();
			// taking the size of array
			System.out.println("Enter the number of no. of companies");
			int noOfCompany = scr.nextInt();
			// declaring share array
			double share[] = new double[noOfCompany];
			// variable to count increase and decrease of share
			int shareInc = 0;
			int shareDec = 0;
			// taking share price of companies
			System.out.println("Enter the share price of companies");

			for (int i = 0; i < noOfCompany; i++) {
				System.out.println("Enter the  share price of company" + (i + 1));
				share[i] = scr.nextDouble();
				// taking boolean value from user for increase or decrease in
				// share and counting it.
				System.out.println("Enter true if share price rise today or "
						+ "enter false if share price decreased today");
				boolean a = scr.nextBoolean();
				boolean b = true;
				if (Boolean.compare(a, b) == 0)
					shareInc++;
				else
					shareDec++;
			}
			System.out.println("Entered  share price of companies by user are " + Arrays.toString(share));
			// declaring share price to be searched and operation choice
			// variable
			double key;
			int choice;
			// loop for carrying out operation
			do {
				Mo.Option();
				System.out.println("Enter the choice for operation");
				choice = scr.nextInt();
				switch (choice) {
				case 0:
					System.out.println("Exited Successfully");
					return;	
				case 1:
					System.out.println("Share price of company in ascending order are:");
					Ma.sort(share, 0, noOfCompany - 1);
					System.out.println(Arrays.toString(share));
					break;
				case 2:
					System.out.println("Share price of company in descending order are:");
					Md.sort(share, 0, noOfCompany - 1);
					System.out.println(Arrays.toString(share));
					break;
				case 3:
					System.out.println("Total number of companies whose share price increased today " + shareInc);
					break;
				case 4:
					System.out.println("Total number of companies whose share price decreased today " + shareDec);
					break;
				case 5:
					System.out.println("Enter the share price needed to be searched");
					key = scr.nextDouble();
					Ma.sort(share, 0, noOfCompany - 1);
					StockSearch.binarySearch(share, 0, noOfCompany - 1, key);
					break;
				}

			} while (choice >= 0 && choice < 6);
			if (choice > 6|| choice<0)
				System.out.println("you have entered invalid choice.EXIT!");
		} catch (InputMismatchException ex) {
			System.out.println("Some of the input given you does not match the data types as declared");
			System.out.println("Retry by running the  program again");
		}
	}
}
