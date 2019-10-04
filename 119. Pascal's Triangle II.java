package LeetCode;

import java.util.ArrayList;
import java.util.List;

// 119. Pascal's Triangle II
public class PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        if(rowIndex==0) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            return list;
        }

        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        for(int i=1; i<=rowIndex; i++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> preRow = triangle.get(i-1);

            row.add(1);
            for(int j=1; j<i; j++) {
                row.add(preRow.get(j-1) + preRow.get(j));
            }
            row.add(1);

            triangle.add(row);
        }
        return triangle.get(rowIndex);
    }
}
