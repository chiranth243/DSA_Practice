package BinarySearch;

public class Rotated_Sorted_Array_Search {
    public boolean search(int[] nums, int target) {
        return searchRotated(nums, 0, nums.length-1, target);
    }

    private boolean searchRotated(int[] nums, int left, int right, int target){
        if(left > right) return false;

        int mid = left + (right-left)/2;

        if(nums[mid] == target){
            return true;
        }
        else if(nums[left] < target && nums[mid-1] > target){
            return searchRotated(nums, left, mid-1, target);
        }
        else{
            return searchRotated(nums, mid+1, right, target);
        }
    }
}
