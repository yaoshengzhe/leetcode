/**
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
*/

import java.lang.Math;

public class Solution {

    private int[] getParent(ArrayList<ArrayList<Integer>> triangle, int level, int i) {
        if (i == 0) {
            return new int[] {0, 0};
        } else if (i == triangle.get(level-1).size() ) {
            return new int[] {i-1, i-1};
        } else {
            return new int[] {i-1, i};
        }
    }

    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        List<List<Integer>> shortestPath = new ArrayList<List<Integer>>();
        List<Integer> r = new ArrayList<Integer>();
        r.add(triangle.get(0).get(0));
        shortestPath.add(r);

        for (int level=1; level < triangle.size(); ++level) {
            List<Integer> row = triangle.get(level);
            shortestPath.add(new ArrayList<Integer>());

            for (int i=0; i < row.size(); ++i) {
                int[] parent = getParent(triangle, level, i);
                List<Integer> shortestPathParent = shortestPath.get(level-1);
                int minVal = Math.min(shortestPathParent.get(parent[0]), shortestPathParent.get(parent[1]));
                shortestPath.get(level).add(minVal + row.get(i));
            }
        }
        int minVal = Integer.MAX_VALUE;

        for (int i : shortestPath.get(shortestPath.size()-1)) {
            if (i < minVal) {
                minVal = i;
            }
        }
        return minVal;
    }
}
