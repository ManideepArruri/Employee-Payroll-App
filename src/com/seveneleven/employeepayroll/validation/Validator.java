package com.seveneleven.employeepayroll.validation;

import java.util.regex.Pattern;

import com.seveneleven.employeepayroll.exception.*;

public class Validator {

    private static String sanitize(String input) {

        if (input == null) return "";

        return input.trim();
    }

    public static void validateEmail(String email)
            throws EmailValidationException {

        email = sanitize(email);

        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

        if (!Pattern.matches(regex, email)) {
            throw new EmailValidationException(
                    "Invalid Email Format. Example: user@email.com");
        }

    }

    public static void validatePhone(String phone)
            throws PhoneValidationException {

        phone = sanitize(phone);

        String regex = "^[6-9][0-9]{9}$";

        if (!Pattern.matches(regex, phone)) {
            throw new PhoneValidationException(
                    "Phone must be 10 digits and start with 6-9");
        }

    }

    public static void validatePassword(String password)
            throws PasswordValidationException {

        password = sanitize(password);

        String regex =
                "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[@#$%^&+=!]).{8,}$";

        if (!Pattern.matches(regex, password)) {

            throw new PasswordValidationException(
                    "Password must contain uppercase, lowercase, number, symbol and be 8+ characters");

        }

    }

    public static void validateEmployeeId(String empId)
            throws EmployeeIdValidationException {

        empId = sanitize(empId);

        String regex = "^EMP-[0-9]{4}$";

        if (!Pattern.matches(regex, empId)) {

            throw new EmployeeIdValidationException(
                    "Employee ID must follow format EMP-XXXX");

        }

    }

}