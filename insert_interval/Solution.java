/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
import java.lang.Math;
 
public class Solution {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> result = new ArrayList<Interval>();
        for (Interval i : intervals) {
            if (newInterval == null || i.end < newInterval.start) {
                result.add(i);
            } else if (newInterval.end < i.start) {
                result.add(newInterval);
                result.add(i);
                newInterval = null;
            } else {
                newInterval = merge(i, newInterval);
            }
        }
        if (newInterval != null) {
            result.add(newInterval);
        }
        return result;
    }
    
    private Interval merge(Interval i, Interval j) {
        return new Interval(Math.min(i.start, j.start),
                            Math.max(i.end, j.end));
    }
}