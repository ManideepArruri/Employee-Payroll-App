package com.seveneleven.employeepayroll.validation;

import java.util.regex.*;

import com.seveneleven.employeepayroll.exception.ValidationException;

public class Validator {

    public static void validateEmail(String email) throws ValidationException {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

        if (!Pattern.matches(emailRegex, email)) {
            throw new ValidationException("Invalid Email Format");
        }
    }

    public static void validatePhone(String phone) throws ValidationException {

        String phoneRegex = "^[6-9][0-9]{9}$";

        if (!Pattern.matches(phoneRegex, phone)) {
            throw new ValidationException("Invalid Phone Number (must start with 6-9 and contain 10 digits)");
        }
    }

    public static void validateEmpId(String empId) throws ValidationException {

        String empIdRegex = "^EMP-[0-9]{4}$";

        if (!Pattern.matches(empIdRegex, empId)) {
            throw new ValidationException("Invalid Employee ID format. Use EMP-XXXX");
        }
    }
}