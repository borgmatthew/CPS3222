package com.assignment.validations;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import com.assignment.DBObjects.User;
import com.assignment.requests.UserRequest;
import com.assignment.requests.UserRequestImpl;

public class RegistrationValidationImp implements RegistrationValidation {

	public boolean validateName(String name) {
		if(name == null){
			return false;
		}
		String regex = "^[A-Za-z\\s]*";
		if (name.matches(regex)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean validateSName(String sname) {
		if(sname == null){
			return false;
		}
		String regex = "^[A-Za-z\\s]*";
		if (sname.matches(regex)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean validateUsername(String user) {
		if(user == null){
			return false;
		}
		UserRequest request = new UserRequestImpl();
		User tempUser = new User();
		tempUser.setUsername(user);
		if (request.getUser(tempUser).size() == 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean validatePassword(String pass) {
		if(pass == null){
			return false;
		}
		if (pass.length() < 8) {
			return false;
		}
		return true;
	}

	public boolean validateDOB(String dob) {
		if(dob == null){
			return false;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date date;
		try {
			date = sdf.parse(dob);
		} catch (ParseException e) {
			return false;
		}
		Calendar parsed = Calendar.getInstance();
		parsed.setTime(date);
		if (Calendar.getInstance().get(Calendar.YEAR)
				- parsed.get(Calendar.YEAR) < 18) {
			return false;
		}

		return true;
	}

	public boolean validateCard(String number) {
		if(number == null){
			return false;
		}
		if (isAmerican(number) || isVisa(number) || isMaster(number)) {
			return true;
		} else {
			return false;
		}
	}

	private boolean isMaster(String card) {
		if (luhn(card)
				&& card.length() == 16
				&& ((card.charAt(0) == '5' && card.charAt(1) == '1')
						|| (card.charAt(0) == '5' && card.charAt(1) == '2')
						|| (card.charAt(0) == '5' && card.charAt(1) == '3')
						|| (card.charAt(0) == '5' && card.charAt(1) == '4') || (card
						.charAt(0) == '5' && card.charAt(1) == '5'))) {
			return true;
		} else {
			return false;
		}
	}

	private boolean isAmerican(String card) {
		if (((card.charAt(0) == '3' && card.charAt(1) == '4') || (card
				.charAt(0) == '3' && card.charAt(1) == '7'))
				&& card.length() == 15 && luhn(card)) {
			return true;
		} else {
			return false;
		}
	}

	private boolean isVisa(String card) {
		if (card.charAt(0) == '4'
				&& (card.length() == 13 || card.length() == 16) && luhn(card)) {
			return true;
		} else {
			return false;
		}
	}

	private boolean luhn(String card) {
		int[] numbers = new int[card.length()];
		String reverse = new StringBuilder().append(card).reverse().toString();
		ArrayList<Integer> evens = new ArrayList<Integer>();
		ArrayList<Integer> odds = new ArrayList<Integer>();

		for (int k = 0; k < numbers.length; k++) {
			try {
				numbers[k] = Integer.parseInt("" + reverse.charAt(k));
			} catch (Exception e) {
				return false;
			}

		}
		int totalOdds = 0;
		int totalEvens = 0;

		for (int i = 0; i < numbers.length; i++) {
			if (i % 2 == 0) {
				totalOdds += numbers[i];
				odds.add(numbers[i]);
			} else {

				evens.add(numbers[i]);
			}
		}
		for (int i = 0; i < evens.size(); i++) {
			// evendoubles.add(2*evens.get(i));
			int temp = 2 * evens.get(i);
			String strtemp = Integer.toString(temp);
			if (strtemp.length() == 2) {
				char tempchar = strtemp.charAt(0);
				char tempchar1 = strtemp.charAt(1);
				int temptotal;
				try {
					temptotal = Integer.parseInt("" + tempchar)
							+ Integer.parseInt("" + tempchar1);
				} catch (Exception e) {
					return false;
				}
				totalEvens += temptotal;
			} else {
				try {

					totalEvens += Integer.parseInt(strtemp);
				} catch (Exception e) {
					return false;
				}
			}
		}

		int total = totalOdds + totalEvens;
		if (total % 10 == 0) {
			return true;
		} else {
			return false;
		}

	}

	public boolean validateEXP(String expdate) {
		if(expdate == null){
			return false;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Date expirydate;
		try {
			expirydate = sdf.parse(expdate);
		} catch (Exception e) {
			return false;
		}
		Date today = new Date();
		
		if (expirydate.after(today)) {
			return true;
		}

		return false;
	}

	public boolean validateCvv(String cvv) {
		if(cvv == null){
			return false;
		}
		String regex = "^[0-9\\s]{3}";
		if (cvv.matches(regex)) {
			return true;
		} else {
			return false;
		}
	}
}
