package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2020/1/23 11:51 上午
 */
public class No537ComplexNumberMultiplication {
    private class Complex {
        int real;
        int imaginary;

        public Complex(String str) {
            String[] parts = str.split("\\+");
            real = Integer.valueOf(parts[0]);
            imaginary = Integer.parseInt(parts[1].substring(0, parts[1].length() - 1));
        }

        public void multiply(Complex other) {
            int newReal = real * other.real - imaginary * other.imaginary;
            int newImaginary = imaginary * other.real + real * other.imaginary;
            this.real = newReal;
            this.imaginary = newImaginary;
        }

        @Override
        public String toString() {
            return "" + real + "+" + imaginary + "i";
        }
    }

    public String complexNumberMultiply(String a, String b) {
        Complex ac = new Complex(a);
        Complex ab = new Complex(b);
        ac.multiply(ab);
        return ac.toString();
    }
}
