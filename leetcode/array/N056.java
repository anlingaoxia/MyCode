package array;

import node.Interval;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class N056 {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() <= 1)
            return intervals;
        intervals.sort(Comparator.comparingInt(i -> i.start));

        List<Interval> result = new ArrayList<>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        for (Interval interval : intervals) {
            if (interval.start <= end)
                end = Math.max(end, interval.end);
            else {
                result.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }
        result.add(new Interval(start, end));
        return result;
    }

    public Interval mergeHelper(Interval i1, Interval i2) {
        if (i1.end >= i2.start) return new Interval(i1.start, Math.max(i1.end, i2.end));
        return null;
    }


}
