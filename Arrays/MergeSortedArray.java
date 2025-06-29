package Arrays;

import java.util.Scanner;

public class MergeSortedArray{
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1;
        int j = n-1;
        int k = m+n-1;

        while(j >= 0){
            if(i>=0 && nums1[i] > nums2[j]){
                nums1[k--] = nums1[i--];
            }
            else{
                nums1[k--] = nums2[j--];
            }
        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the nums1 array length:");
        int s1 = scanner.nextInt();

        System.out.println("Please enter the values into array:");
        int[] nums1 = new int[s1];

        for(int i = 0; i < s1; i++){
            nums1[i] = scanner.nextInt();
        }

        System.out.println("Please enter the nums2 array length:");
        int s2 = scanner.nextInt();

        System.out.println("Please enter the values into array:");
        int[] nums2 = new int[s2];

        for(int i = 0; i < s2; i++){
            nums2[i] = scanner.nextInt();
        }

        System.out.println("Please enter the value of m:");
        int m = scanner.nextInt();

        System.out.println("Please enter the value of n");
        int n = scanner.nextInt();

        merge(nums1, m, nums2, n);

        scanner.close();
    }
}