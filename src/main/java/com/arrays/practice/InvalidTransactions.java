package com.arrays.practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
https://leetcode.com/problems/invalid-transactions/
A transaction is possibly invalid if:

the amount exceeds $1000, or;
if it occurs within (and including) 60 minutes of another transaction with the same name in a different city.
You are given an array of strings transaction where transactions[i] consists of comma-separated values representing the name, time (in minutes), amount, and city of the transaction.

Return a list of transactions that are possibly invalid. You may return the answer in any order.


Example 1:

Input: transactions = ["alice,20,800,mtv","alice,50,100,beijing"]
Output: ["alice,20,800,mtv","alice,50,100,beijing"]
Explanation: The first transaction is invalid because the second transaction occurs within a difference of 60 minutes, have the same name and is in a different city. Similarly the second one is invalid too.
Example 2:

Input: transactions = ["alice,20,800,mtv","alice,50,1200,mtv"]
Output: ["alice,50,1200,mtv"]
Example 3:

Input: transactions = ["alice,20,800,mtv","bob,50,1200,mtv"]
Output: ["bob,50,1200,mtv"]


Constraints:

transactions.length <= 1000
Each transactions[i] takes the form "{name},{time},{amount},{city}"
Each {name} and {city} consist of lowercase English letters, and have lengths between 1 and 10.
Each {time} consist of digits, and represent an integer between 0 and 1000.
Each {amount} consist of digits, and represent an integer between 0 and 2000.

 */
public class InvalidTransactions {

    /*
    Approach: construct 4 arrays of names, time, amount, city.
    check if the transaction happens with same name different ciy with in less than 60 minutes.
     */
    private static List<String> invalidTransactions(String[] transactions){
        String[] names = new String[transactions.length];
        Integer[] time = new Integer[transactions.length];
        Integer[] amount = new Integer[transactions.length];
        String[] city = new String[transactions.length];
        int i = 0, j;
        List<String> invalidTransactions = new ArrayList<>();
        for(String trans:transactions){
            String[] transaction = trans.split (",");
            names[i] = transaction[0];
            time[i]  = Integer.valueOf (transaction[1]);
            amount[i] = Integer.valueOf (transaction[2]);
            city[i] = transaction[3];
            i++;
        }
        boolean[] isInvalid = new boolean[transactions.length];
        if(amount[0] > 1000){ // Only for first transaction
            invalidTransactions.add(transactions[0]);
            isInvalid[0] = true;
        }
        for(i = 0; i<names.length-1;i++){
            for(j = i+1; j<names.length;j++){
                if(amount[j] > 1000 && !isInvalid[j]){
                    invalidTransactions.add(transactions[j]);
                    isInvalid[j] = true;
                }
                if(names[i].equals(names[j])){
                    if(!city[i].equals(city[j]) && Math.abs(time[j]-time[i]) <= 60){
                        if(!isInvalid[i]) {
                            invalidTransactions.add (transactions[i]);
                            isInvalid[i] = true;
                        }
                            if (!isInvalid[j]) {
                                invalidTransactions.add (transactions[j]);
                                isInvalid[j] = true;
                            }
                        }
                }
            }
        }
        return  invalidTransactions;
    }
    public static void main(String[] args) {
   String[] transactions = {"alice,20,800,mtv","bob,50,1200,mtv","alice,20,800,mtv","alice,50,1200,mtv","alice,20,800,mtv","alice,50,100,beijing"};
  System.out.println (InvalidTransactions.invalidTransactions (transactions));

    }
}
