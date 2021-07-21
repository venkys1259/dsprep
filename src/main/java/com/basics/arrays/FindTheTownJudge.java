package com.basics.arrays;
/* https://leetcode.com/problems/find-the-town-judge/ */
import javafx.util.Pair;

import java.util.*;

public class FindTheTownJudge {
  class Trust{
      int trusts,trustedBy;
      public int getTrusts() {
          return trusts;
      }
      public void setTrusts(int trusts) {
          this.trusts = trusts;
      }
      public int getTrustedBy() {
          return trustedBy;
      }
      public void setTrustedBy(int trustedBy) {
          this.trustedBy = trustedBy;
      }
  }
  /** naive approach*/
    public int findJudge(int n, int[][] trustArr) {
      if(n == 1) return 1;
      Map<Integer,Trust> trustMap = new LinkedHashMap<> ();
      for(int[] people: trustArr){
          Trust trust,trustedBy;
          if(trustMap.containsKey (people[0])){
              trust = trustMap.get(people[0]);
              trust.setTrusts(trust.getTrusts ()+1);
          }else{
              trust = new Trust();
              trust.setTrusts (1);
          }
          if(trustMap.containsKey (people[1])){
              trustedBy = trustMap.get(people[1]);
              trustedBy.setTrustedBy (trustedBy.getTrustedBy ()+1);
          }else{
              trustedBy = new Trust();
              trustedBy.setTrustedBy (1);
          }
          trustMap.put (people[0],trust);
          trustMap.put (people[1],trustedBy);
      }
       for(Map.Entry<Integer,Trust> trustEntry: trustMap.entrySet()){
           Trust trust = trustEntry.getValue ();
           if(trust.getTrusts () == 0 && trust.getTrustedBy () == n-1){
               return trustEntry.getKey();
           }
       }
        return -1;
    }

    public int findJudge1(int n, int[][] trustArr) {
        Map<Integer,Pair<Integer,Integer>> trustMap = new HashMap<> ();
        if(n == 1) return 1;
        for(int[] people: trustArr) {
            Pair<Integer,Integer> trusts = trustMap.getOrDefault (people[0],new Pair(0,0));
            Pair<Integer,Integer> trustedBy = trustMap.getOrDefault (people[1],new Pair(0,0));
            trustMap.put(people[0], new Pair(trusts.getKey ()+1,trusts.getValue ()));
            trustMap.put(people[1], new Pair(trustedBy.getKey(),trustedBy.getValue()+1));
        }

        for(Map.Entry<Integer,Pair<Integer,Integer>> trustEntry: trustMap.entrySet()){
            Pair<Integer,Integer> pairs = trustEntry.getValue ();
            if(pairs.getKey()== 0 && pairs.getValue() == n-1){
                return trustEntry.getKey();
            }
        }
      return -1;
    }

    public static void main(String[] args) {
       int[][] trust = {{1,3}, {2,3}};
        FindTheTownJudge townJudge = new FindTheTownJudge();
        System.out.println (townJudge.findJudge (3, trust));
        System.out.println (townJudge.findJudge1 (3, trust));
    }

}
