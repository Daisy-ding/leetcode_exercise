package com.example.demo.exercise;

/**
 * @author yubang.cwt on 2020/2/16
 */
public class No12IntegerToRoman {
    private String romain(int digit, char one, char five, char ten) {
        StringBuilder sb = new StringBuilder();
        switch (digit) {
            case 1:
                sb.append(one);
                break;
            case 2:
                sb.append(one).append(one);
                break;
            case 3:
                sb.append(one).append(one).append(one);
                break;
            case 4:
                sb.append(one).append(five);
                break;
            case 5:
                sb.append(five);
                break;
            case 6:
                sb.append(five).append(one);
                break;
            case 7:
                sb.append(five).append(one).append(one);
                break;
            case 8:
                sb.append(five).append(one).append(one).append(one);
                break;
            case 9:
                sb.append(one).append(ten);
                break;
        }
        return sb.toString();
    }

    public String intToRoman(int num) {
        char one = 'I';
        char five = 'V';
        char ten = 'X';
        String strNum = String.valueOf(num);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strNum.length(); ++i) {
            int digitNumber = strNum.length() - i - 1;

            if (digitNumber == 3) {
                one = 'M';
                sb.append(romain(strNum.charAt(i) - '0', one, five, ten));
            } else if (digitNumber == 2) {
                one = 'C';
                five = 'D';
                ten = 'M';
                sb.append(romain(strNum.charAt(i) - '0', one, five, ten));
            } else if (digitNumber == 1) {
                one = 'X';
                five = 'L';
                ten = 'C';
                sb.append(romain(strNum.charAt(i) - '0', one, five, ten));
            } else if (digitNumber == 0) {
                one = 'I';
                five = 'V';
                ten = 'X';
                sb.append(romain(strNum.charAt(i) - '0', one, five, ten));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        No12IntegerToRoman solution = new No12IntegerToRoman();
        System.out.println(solution.intToRoman(1994));
    }
}
