package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2019/12/29 10:49 上午
 */
public class No744FindSmallestLetterGreaterThanTarget {
    public char nextGreatestLetter(char[] letters, char target) {
        if (letters.length < 2) {
            return ' ';
        }
        int low = 0;
        int high = letters.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (letters[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low > letters.length - 1 ? letters[0] : letters[low];
    }

    public static void main(String[] args) {
        No744FindSmallestLetterGreaterThanTarget solution = new No744FindSmallestLetterGreaterThanTarget();
        char[] letters = {'c', 'f', 'j'};
        System.out.println(solution.nextGreatestLetter(letters, 'a'));
    }
}
