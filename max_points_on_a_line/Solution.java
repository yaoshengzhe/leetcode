/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */

import java.lang.Math;
import java.util.HashMap;

public class Solution {

    public int maxPoints(Point[] points) {

        if (points == null || points.length == 0) {
            return 0;
        } else if (points.length <= 2) {
            return points.length;
        }

        int max = 0;

        for (int i=0; i < points.length; ++i) {
            HashMap<Long, Integer> slopeMap = new HashMap<Long, Integer>();
            int numOfSamePoints = 1;
            for (int j=i+1; j < points.length; ++j) {
                if (points[i].x == points[j].x && points[i].y == points[j].y) {
                    numOfSamePoints++;
                    continue;
                }

                long slp = slope(points[i], points[j]);
                Integer count = slopeMap.get(slp);
                if (count == null) {
                    count = 0;
                }

                slopeMap.put(slp, count + 1);
            }

            if (max < numOfSamePoints) {
                max = numOfSamePoints;
            }

            for (int count : slopeMap.values()) {
                if (max < (count + numOfSamePoints)) {
                    max = count + numOfSamePoints;
                }
            }
        }
        return max;
    }

    private long slope(Point a, Point b) {
        int xDiff = Math.abs(a.x - b.x);
        int yDiff = Math.abs(a.y - b.y);
        long g = gcd(xDiff, yDiff);

        return sgn(a.x - b.x, a.y - b.y) * ((xDiff / g) << 32) + yDiff / g;
    }

    private int sgn(int a, int b) {
        if ((a > 0 && b > 0) || (a < 0 && b < 0)) {
            return 1;
        } else if (a == 0 || b == 0) {
            return 0;
        } else {
            return -1;
        }
    }

    private int gcd(int a, int b) {
        return b > 0 ? gcd(b, a % b) : a;
    }
}
