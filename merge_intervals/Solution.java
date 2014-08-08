/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {

        List<Interval> result = new LinkedList<Interval>();
        Collections.sort(intervals, new Comparator<Interval>() {
                public int compare(Interval a, Interval b) {
                    if (a.start < b.start) {
                        return -1;
                    } else if (a.start > b.start) {
                        return 1;
                    } else {
                        return 0;
                    }
                }
            });
        Interval current = null;
        for (Interval i : intervals) {
            if (current == null) {
                current = i;
            } else {
                if (i.start > current.end) {
                    result.add(current);
                    current = i;
                } else if (i.end >= current.end) {
                    current.end = i.end;
                }
            }
        }
        if (current != null) {
            result.add(current);
        }
        return result;
    }
}
