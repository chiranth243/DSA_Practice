package BinarySearch;

public class TwoD_Matrix_Search {
    public static boolean searchMatrix(int[][] matrix, int target) {
        return searchTarget(matrix, 0, matrix.length-1, target);
    }

    private static boolean searchTarget(int[][] matrix, int outerLeft, int outerRight, int target){
        int outerMid = outerLeft + (outerRight - outerLeft)/2;
        int innerLength = matrix[outerMid].length;

        if(matrix[outerMid][0] > target){
            return searchTarget(matrix, outerLeft, outerMid-1, target);
        }
        else if(matrix[outerMid][innerLength-1] < target){
            return searchTarget(matrix, outerMid+1, outerRight, target);
        }
        else{
            for(int i = 0; i < innerLength; i++){
                if(matrix[outerMid][i] == target) return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 3;
        System.out.println(searchMatrix(matrix, target));
    }
}
