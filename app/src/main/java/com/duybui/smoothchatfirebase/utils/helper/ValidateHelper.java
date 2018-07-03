package com.duybui.smoothchatfirebase.utils.helper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by buivu on 06/10/2016.
 */
public final class ValidateHelper {
    private ValidateHelper() {
    }

    /**
     * Hàm này dùng để kiểm tra định dạng email. Nếu đúng sẽ trả về true
     *
     * @param email email để kiểm tra
     */
    public static boolean isCheckEmailSuccess(String email) {
        boolean isValid = false;

        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        CharSequence inputStr = email;

        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;
    }

    /**
     * Hàm này dùng để kiểm tra length của sdt
     * nếu đúng trả về true
     *
     * @param phoneNumber input
     */
    public static boolean isCheckPhoneNumberSuccess(String phoneNumber) {
        if (9 < phoneNumber.length() && phoneNumber.length() < 12) {
            return true;
        }
        return false;
    }

    /**
     * Hàm này dùng để kiểm tra length của password
     * nếu đúng trả về true
     *
     * @param password input
     */
    public static boolean isCheckPasswordSuccess(String password) {
        if (password.length() >= 8) {
            return true;
        }
        return false;
    }

    /**
     * Hàm này dùng để kiểm tra sự hợp lệ của sdt
     * nếu đúng trả về true
     *
     * @param phoneNumber input
     */
    public static boolean isCheckPhoneNumberSuccessFull(String phoneNumber) {
        String phone = phoneNumber.replace(" ", "").replace(".", "").replace("-", "").replace("+84", "0").replace("(", "").replace(")", "");
        if ((phone.startsWith("09") || phone.startsWith("08") || phone.startsWith("01")) && phone.length() == 10)
            return true;

        if (phone.startsWith("01") && phone.length() == 11)
            return true;

        return false;
    }

    /*^ (bắt đầu của dòng)
        [a-zA-Z] {2,} (sẽ trừ tên có ít nhất hai ký tự)
        \ s (sẽ tìm khoảng trắng giữa tên và họ)
        [a-zA-Z] {1 ,} (cần ít nhất 1 Ký tự)
        '? -? (có thể là ' hoặc - đối với họ hai cột và dấu gạch ngang)
        [a-zA-Z] {2,} (trừ tên có ít nhất hai ký tự)
        \ s? (khả năng của một khoảng trắng khác)
        ([a-zA-Z] {1,})? * (khả năng họ thứ hai)*/
    public static boolean isCheckFullName(String fullname) {
        boolean isValid = false;
        String passwordValidation = "^([a-zA-Z]{2,}\\s[a-zA-z]{1,}'?-?[a-zA-Z]{2,}\\s?([a-zA-Z]{1,})?)";
        CharSequence inputStr = fullname;
        Pattern pattern = Pattern.compile(passwordValidation);
        Matcher matcher = pattern.matcher(inputStr);
        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;
    }
}
