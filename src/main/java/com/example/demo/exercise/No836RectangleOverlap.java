package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/12/18 11:11 下午
 */
public class No836RectangleOverlap {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return !(rec1[2] <= rec2[0] ||
                rec1[0] >= rec2[2] ||
                rec1[3] <= rec2[1] ||
                rec1[1] >= rec2[3]);
    }
}
