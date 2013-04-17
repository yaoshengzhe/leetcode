/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
 
import java.util.Collections;
import java.util.Comparator;
import java.lang.Math;

public class Solution {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> result = new ArrayList<Interval>();
        
        if (intervals == null || intervals.isEmpty()) {
            return result;
        }
        
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
        Interval cur = intervals.get(0);
        for (int i=1; i < intervals.size(); ++i) {
            Interval next = intervals.get(i);
            
            if (cur == null || next.end < cur.start) {
                result.add(next);
            } else if (cur.end < next.start) {
                result.add(cur);
                cur = next;
            } else {
                cur = new Interval(Math.min(cur.start, next.start),
                                   Math.max(cur.end, next.end));
            }
        }
        if (cur != null) {
            result.add(cur);
        }
        return result;
    }
}