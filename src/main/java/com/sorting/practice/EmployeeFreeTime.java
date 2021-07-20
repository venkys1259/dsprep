package com.sorting.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
/*
Followed the below link
http://shibaili.blogspot.com/2019/02/759-employee-free-time.html

 */
public class EmployeeFreeTime {
    static class Interval{
        int start,end;
        Interval(int start,int end){
            this.start = start;
            this.end = end;
        }
    }
    private List<Interval> getFreeTime(List<List<Interval>> schedule){
        PriorityQueue<Interval> que = new PriorityQueue<> ((a, b) -> a.start - b.start);
        for (List<Interval> list : schedule) {
            for (Interval i : list) {
                que.add(i);
            }
        } // Heap will maintain the schedule as per increasing order of start times.

        List<Interval> rt = new ArrayList<>();
        int max = -1;
        while (!que.isEmpty()) {
            Interval top = que.poll();
            if (max != -1 && top.start > max) { // if current interval is starting after previous (max)end interval,overlap exists
                rt.add(new Interval(max, top.start));
            }
            max = Math.max(max, top.end);
        }

        return rt;
    }
    public static void main(String[] args) {
        EmployeeFreeTime freeTime = new EmployeeFreeTime();
        List<Interval> intervals1 = new ArrayList<> ();
        Interval interval1 = new EmployeeFreeTime.Interval (1,2);
        Interval interval2 = new EmployeeFreeTime.Interval (5,6);
        intervals1.add (interval1);
        intervals1.add (interval2);

        List<Interval> intervals2 = new ArrayList<> ();
        interval1 = new EmployeeFreeTime.Interval (1,3);
        intervals2.add(interval1);

        List<Interval> intervals3 = new ArrayList<> ();
        interval1 = new EmployeeFreeTime.Interval (4,10);
        intervals3.add(interval1);

        List<List<Interval>> schedules = new ArrayList<> ();
        schedules.add(intervals1);
        schedules.add(intervals2);
        schedules.add(intervals3);
        List<Interval> result = freeTime.getFreeTime (schedules);
        for(Interval interval:result){
            System.out.println (interval.start + " " +interval.end);
        }
    }
}
