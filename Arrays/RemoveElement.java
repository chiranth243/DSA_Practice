package Arrays;

import java.util.Scanner;

public class RemoveElement {
    public static int removetargetElement(int[] nums, int val) {
       if(nums.length == 0) return 0;
       int j = 0;

       for(int i = 0; i < nums.length; i++){
        if(nums[i] != val){
            nums[j] = nums[i];
            j++;
        }
       }
       return j;
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

        System.out.println("Please enter the Target value:");
        int val = scanner.nextInt();

        System.out.println(removetargetElement(nums, val));

        scanner.close();
    }
}
