package Arrays;
import java.util.*;

public class RemoveDuplicates {
    public static int removeDuplicates(int[] nums) {
       if(nums.length == 0) return 0;
       int i = 0;

       for(int j = 1; j < nums.length; j++){
        if(nums[i] != nums[j]){
            i++;
            nums[i] = nums[j];
        }
       }
       return i+1;
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

        System.out.println(removeDuplicates(nums));

        scanner.close();
    }
}
