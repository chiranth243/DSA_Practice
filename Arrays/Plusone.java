package Arrays;
import java.util.Scanner;

public class Plusone {
    public static int[] plusOne(int[] digits) {
        for(int i = digits.length-1; i >= 0; i--){
            if(digits[i] < 9){
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        int[] result = new int[digits.length+1];
        result[0] = 1;
        return result;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the array length:");
        int n = scanner.nextInt();

        System.out.println("Please enter the values into array:");
        int[] nums = new int[n];

        for(int i = 0; i < n; i++){
            nums[i] = scanner.nextInt();
        }

        System.out.println(plusOne(nums));

        scanner.close();
    }
}
