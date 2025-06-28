package Arrays;

import java.util.Scanner;

public class SearchInsertPosition {

    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;

        while(left <= right){
            int mid = left+(right-left)/2;

            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] < target){
                left = mid+1;
            }
            else if(nums[mid] > target){
                right = mid-1;
            }
        }

        return left;
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
        int target = scanner.nextInt();

        System.out.println(searchInsert(nums, target));

        scanner.close();
    }
}
