package BinarySearch;

import java.util.Scanner;

class Sqrt{

    public static int mySqrt(int x) {
        if(x <= 1) return x;
        int left = 0;
        int right = x;
        int result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            long square = (long) mid * mid;

            if (square == x) {
                return mid;
            } else if (square < x) {
                result = mid;        
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter the number:");
        int x = sc.nextInt();

        mySqrt(x);

        sc.close();

    }
}