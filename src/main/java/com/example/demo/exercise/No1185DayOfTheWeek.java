package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2019/11/26 11:09 下午
 */
public class No1185DayOfTheWeek {
    public String dayOfTheWeek(int day, int month, int year) {
        String[] daysOfWeek = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        java.util.Calendar cal = new java.util.GregorianCalendar(year, month - 1, day);
        return daysOfWeek[cal.get(java.util.Calendar.DAY_OF_WEEK) - 1];
    }

    public static void main(String[] args) {
        No1185DayOfTheWeek solution = new No1185DayOfTheWeek();
        System.out.println(solution.dayOfTheWeek(18, 7, 1999));
    }
}
