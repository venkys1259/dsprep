package com.sorting.practice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
https://leetcode.com/problems/car-pooling/
Approach:

Sort the given array by starting point and drop off point

 */
public class CarPooling {
    class Pool{
        private Integer numOfPassengers;
        private Integer startingPoint;
        private Integer endingPoint;
        public Integer getNumOfPassengers() {
            return numOfPassengers;
        }

        public void setNumOfPassengers(Integer numOfPassengers) {
            this.numOfPassengers = numOfPassengers;
        }

        public Integer getStartingPoint() {
            return startingPoint;
        }

        public void setStartingPoint(Integer startingPoint) {
            this.startingPoint = startingPoint;
        }

        public Integer getEndingPoint() {
            return endingPoint;
        }

        public void setEndingPoint(Integer endingPoint) {
            this.endingPoint = endingPoint;
        }
    }
    private boolean isCarPoolingFeasible(int[][] trips, int capacity) {
        List<Pool> pools = new ArrayList<>();
        for(int i =0; i<trips.length;i++){
            Pool pool = new Pool();
            for(int j = 0; j<trips[i].length;j++){
                pool.setNumOfPassengers(trips[i][0]);
                pool.setStartingPoint (trips[i][1]);
                pool.setEndingPoint (trips[i][2]);
            }
            pools.add(pool);
        }
        pools.sort(Comparator.comparing(Pool::getStartingPoint).thenComparing (Pool::getEndingPoint));
        Object[] poolArray =  pools.toArray ();
        int n = poolArray.length;
        int  occupiedCapacity = ((Pool)poolArray[0]).getNumOfPassengers();
        int aboutToDropoff = 0;
        boolean poolingIsfeasible;
        for(int i = 0; i< n-1;i++){
            Pool trip1 = (Pool)poolArray[i];
            Pool trip2 = (Pool)poolArray[i+1];
            Pool aboutToDrop = (Pool)poolArray[aboutToDropoff];
            if(trip2.getStartingPoint() < trip1.getEndingPoint ()) {
                occupiedCapacity = occupiedCapacity + trip2.getNumOfPassengers ();
            }
            if(aboutToDrop.getEndingPoint() > trip2.getEndingPoint ()){
                aboutToDropoff = i+1;
            }else{
                if(aboutToDrop.getNumOfPassengers()>trip2.getNumOfPassengers()){
                    aboutToDropoff=i;
                }else{
                    aboutToDropoff = i+1;
                }
            }
            Pool dropTrip = (Pool)poolArray[aboutToDropoff];
            if(trip2.getStartingPoint () >= dropTrip.getEndingPoint()){
                occupiedCapacity = occupiedCapacity -  dropTrip.getNumOfPassengers ();
            }
            if(occupiedCapacity > capacity ) return false;
        }
        if(occupiedCapacity > capacity ) poolingIsfeasible = false;
        else poolingIsfeasible = true;
        return  poolingIsfeasible;
    }

    public static void main(String[] args) {
        CarPooling carPooling = new CarPooling();
       // int[][] cp = {{3,2,7},{3,7,9},{8,3,9}};
       // int[][] cp = {{7,5,7},{8,1,9},{10,2,6},{4,7,8},{2,1,3}};
        int[][] cp = {{2,1,5},{3,3,7}};
        System.out.println (carPooling.isCarPoolingFeasible(cp,5));
    }
}
