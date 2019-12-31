package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/12/31 10:15 下午
 */
public class No949LargestTimeForGivenDigits {
    private boolean bucketEquals(int[] A, int[] B) {
        for (int i = 0; i <= 9; ++i) {
            if (A[i] != B[i]) {
                return false;
            }
        }
        return true;
    }

    public String largestTimeFromDigits(int[] A) {
        int[] buckets = new int[10];
        for (int digit : A) {
            buckets[digit]++;
        }
        for (int hour = 23; hour >= 0; --hour) {
            for (int minutes = 59; minutes >= 0; --minutes) {
                int[] newBuckets = new int[10];
                String hourStr = "";
                if (hour < 10) {
                    newBuckets[0]++;
                    newBuckets[hour]++;
                    hourStr = String.format("0%d", hour);
                } else {
                    newBuckets[hour % 10]++;
                    newBuckets[hour / 10]++;
                    hourStr = String.format("%d%d", hour / 10, hour % 10);
                }

                String minutesStr = "";
                if (minutes < 10) {
                    newBuckets[0]++;
                    newBuckets[minutes]++;
                    minutesStr = String.format("0%d", minutes);
                } else {
                    newBuckets[minutes % 10]++;
                    newBuckets[minutes / 10]++;
                    minutesStr = String.format("%d%d", minutes / 10, minutes % 10);
                }

                if (bucketEquals(newBuckets, buckets)) {
                    return hourStr + ":" + minutesStr;
                }
            }
        }
        return "";
    }
}
