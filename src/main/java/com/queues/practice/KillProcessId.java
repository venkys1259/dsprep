package com.queues.practice;

import java.util.*;

/*leetcode-582

Given n processes, each process has a unique PID (process id) and its PPID (parent process id).

Each process only has one parent process, but may have one or more children processes. This is just like a tree structure. Only one process has PPID that is 0, which means this process has no parent process. All the PIDs will be distinct positive integers.

We use two list of integers to represent a list of processes, where the first list contains PID for each process and the second list contains the corresponding PPID.

Now given the two lists, and a PID representing a process you want to kill, return a list of PIDs of processes that will be killed in the end. You should assume that when a process is killed, all its children processes will be killed. No order is required for the final answer.

Example 1:

Input:
pid =  [1, 3, 10, 5]
ppid = [3, 0, 5, 3]
kill = 5
Output: [5,10]
Explanation:
           3
         /   \
        1     5
             /
            10
Kill 5 will also kill 10.
*
* */
public class KillProcessId {
    /*
    Approach:
    1) Construct a map with parent process id as key and list of children process id as values
    2) Using queue technique of first in fist out, use the steps
     a) put the target kill element into queue first
     b) add all the children (if any) of first element to the queue
     c) remove the front element from queue and put it in result
     d) until queue is empty, repeat steps b and c.
     */

    private List<Integer> killPId(int[] pid,int[] ppid,int kill){
        List<Integer> resultList = new ArrayList<>();
        Map<Integer,List<Integer>> parentChildMap = new HashMap<>();
        List<Integer> pIdList;
        for(int i = 0; i<ppid.length;i++){
            if(parentChildMap.containsKey (ppid[i])){
                List<Integer> existingPidList = parentChildMap.get (ppid[i]);
                existingPidList.add(pid[i]);
                parentChildMap.put(ppid[i],existingPidList);
            }else{
                pIdList = new ArrayList<>();
                pIdList.add(pid[i]);
                parentChildMap.put(ppid[i],pIdList);
            }
        }
        // if the process to be killed just does not have children at all.
        if(!parentChildMap.containsKey(kill)){
            resultList.add(kill);
            return resultList;
        }else{
        Queue<Integer> queue = new LinkedList<>();
        queue.add(kill);
        while(!queue.isEmpty()){
            if(parentChildMap.get(queue.peek())!=null){ // check if the first element in queue has children
                List<Integer> children = parentChildMap.get(queue.peek());
                for(Integer child: children){
                    queue.add(child); // add all children to queue, so that they will process in FIFO order
                }
            }
            resultList.add(queue.poll());
        }
        }
        return resultList;
    }
    public static void main(String[] args) {
        KillProcessId killP = new KillProcessId();
        int[] pId = {1, 3, 10, 5};
        int[] ppId = {3, 0, 5, 3};
        System.out.println ( killP.killPId (pId, ppId, 5));
    }
}
