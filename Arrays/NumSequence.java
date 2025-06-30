package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class NumSequence {

    private static final int MOD = 1_000_000_007;

    public static int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] powers = new int[n];
        powers[0] = 1;

        for (int i = 1; i < n; i++) {
            powers[i] = (powers[i - 1] * 2) % MOD;
        }

        int left = 0, right = n - 1;
        int result = 0;

        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                result = (result + powers[right - left]) % MOD;
                left++;
            } else {
                right--;
            }
        }

        return result;
    }

    public static void main(String[] args){
        Scanner sc  = new Scanner(System.in);

        System.out.println("Please enter the array size:");
        int s = sc.nextInt();

        int[] nums = new int[s];

        for(int i = 0; i < s; i++){
            nums[i] = sc.nextInt();
        }

        System.out.println("Please enter the target value:");
        int target = sc.nextInt();

        System.out.println(numSubseq(nums, target));

        sc.close();
    }
}
