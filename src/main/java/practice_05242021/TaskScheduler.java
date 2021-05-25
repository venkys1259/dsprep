package practice_05242021;

import java.util.*;

/*https://leetcode.com/problems/task-scheduler/
Given a characters array tasks, representing the tasks a CPU needs to do, where each letter represents a different task. Tasks could be done in any order. Each task is done in one unit of time. For each unit of time, the CPU could complete either one task or just be idle.

However, there is a non-negative integer n that represents the cooldown period between two same tasks (the same letter in the array), that is that there must be at least n units of time between any two same tasks.

Return the least number of units of times that the CPU will take to finish all the given tasks.

Example 1:
Input: tasks = ["A","A","A","B","B","B"], n = 2
Output: 8
Explanation:
A -> B -> idle -> A -> B -> idle -> A -> B
There is at least 2 units of time between any two same tasks.
Example 2:

Input: tasks = ["A","A","A","B","B","B"], n = 0
Output: 6
Explanation: On this case any permutation of size 6 would work since n = 0.
["A","A","A","B","B","B"]
["A","B","A","B","A","B"]
["B","B","B","A","A","A"]
...
And so on.
Example 3:

Input: tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
Output: 16
Explanation:
One possible solution is
A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> idle -> idle -> A -> idle -> idle -> A
 */
public class TaskScheduler {
    /* Approach: if the current element and previous element are same, put I (idleIndex) as filler for n times
     * whenever different element comes, first will try to fill it with idleIndexes
     * and then will schedule remaining ones.
     * */

    public int leastInterval(char[] tasks, int n) {
        List<Character> scheduleList = new ArrayList<> ();
        List<Integer> idleIndexList = new ArrayList<> ();
        if (n == 0) {
            return tasks.length;
        }
        scheduleList.add (0, tasks[0]);
        for (int i = 1; i < tasks.length; i++) {
            if (tasks[i] == scheduleList.get (scheduleList.size () - 1)) {
                int idle = scheduleList.size ();
                for (int j = idle; j < (idle + n); j++) {
                    scheduleList.add (j, 'I');
                    idleIndexList.add (j);
                }
                scheduleList.add (tasks[i]);
            } else {
                if (!idleIndexList.isEmpty () && (idleIndexList.get (idleIndexList.size () - 1) == i)) {
                    scheduleList.add (tasks[i]);
                } else {
                    if (!idleIndexList.isEmpty ()) {
                        int idleIndex = idleIndexList.get (0);
                        if (idleIndex != -1 && scheduleList.get (idleIndex - 1) == tasks[i]) {
                            idleIndex = idleIndexList.get (1);
                        }
                        scheduleList.set (idleIndex, tasks[i]);
                        idleIndexList.remove (idleIndexList.indexOf (idleIndex));
                    }
                }
            }

        }
       if (idleIndexList.isEmpty ()) return tasks.length;
        return scheduleList.size ();
    }

    public static void main(String[] args) {
        char[] tasks = {'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E','F','G'};
        TaskScheduler taskScheduler = new TaskScheduler ();
        System.out.println (taskScheduler.leastInterval (tasks, 2));

    }
}
