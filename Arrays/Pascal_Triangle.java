package Arrays;

import java.util.ArrayList;
import java.util.List;

public class Pascal_Triangle {
    public List<List<Integer>> generate(int numRows) {
        if(numRows < 1) return null;
        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i < numRows; i++){
            List<Integer> row = new ArrayList<>();
            for(int j = 0; j <= i; j++){
                if(j == 0 || j == i){
                    row.add(1);
                }
                else{
                    int val = result.get(i-1).get(j-1) + result.get(i-1).get(j);
                    row.add(val);
                }
            }
            result.add(row);
        }
        return result;
    }

    public static void main(String[] args) {
        Pascal_Triangle pt = new Pascal_Triangle();
        int numRows = 5;
        List<List<Integer>> triangle = pt.generate(numRows);

        if (triangle != null) {
            for (List<Integer> row : triangle) {
                System.out.println(row);
            }
        } else {
            System.out.println("Invalid number of rows.");
        }
    }
}
