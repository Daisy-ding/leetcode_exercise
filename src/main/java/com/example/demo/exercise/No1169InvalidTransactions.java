package com.example.demo.exercise;

import java.util.*;

/**
 * @author yubang
 * @date 2020/1/29 12:08 上午
 */
public class No1169InvalidTransactions {
    private class Transaction {
        String name;
        int time;
        int amount;
        String city;

        public Transaction(String str) {
            String[] parts = str.split(",");
            this.name = parts[0];
            this.time = Integer.valueOf(parts[1]);
            this.amount = Integer.valueOf(parts[2]);
            this.city = parts[3];
        }

        @Override
        public String toString() {
            return name + "," + time + "," + amount + "," + city;
        }
    }

    public List<String> invalidTransactions(String[] transactions) {
        Map<String, List<Transaction>> transactionMap = new HashMap<>();
        for (String transaction : transactions) {
            Transaction t = new Transaction(transaction);
            if (!transactionMap.containsKey(t.name)) {
                transactionMap.put(t.name, new LinkedList<>());
            }
            transactionMap.get(t.name).add(t);
        }
        for (String key : transactionMap.keySet()) {
            transactionMap.get(key).sort(new Comparator<Transaction>() {
                @Override
                public int compare(Transaction o1, Transaction o2) {
                    return o1.time - o2.time;
                }
            });
        }
        List<String> results = new LinkedList<>();
        for (String key : transactionMap.keySet()) {
            List<Transaction> transactionList = transactionMap.get(key);
            for (int i = 0; i < transactionList.size(); ++i) {
                Transaction current = transactionList.get(i);
                if (current.amount > 1000) {
                    if (results.contains(current.toString())) {
                        continue;
                    }
                    results.add(current.toString());
                } else {
                    for (int j = 0; j < transactionList.size(); ++j) {
                        if (i == j) {
                            continue;
                        }
                        Transaction other = transactionList.get(j);
                        if (!other.city.equals(current.city) && Math.abs(other.time - current.time) <= 60) {
                            if (results.contains(current.toString())) {
                                continue;
                            }
                            results.add(current.toString());
                        }
                    }
                }
            }
        }
        return results;
    }
}
