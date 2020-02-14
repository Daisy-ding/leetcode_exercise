package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2019/12/6 10:10 下午
 */
public class No937ReorderDataInLogFiles {
    private boolean isDigit(String log) {
        String[] words = log.split(" ");
        return Character.isDigit(words[1].charAt(0));
    }

    private int compareLetterLog(String a, String b) {
        return a.substring(a.indexOf(" ")).compareTo(b.substring(b.indexOf(" ")));
    }

    public String[] reorderLogFiles(String[] logs) {
        for (int i = 0; i < logs.length; ++i) {
            for (int j = i; j < logs.length; ++j) {
                if (i == j) {
                    continue;
                }
                boolean isIDigit = isDigit(logs[i]);
                boolean isJDigit = isDigit(logs[j]);
                if (isJDigit) {
                    continue;
                }
                if (isIDigit) {
                    String temp = logs[j];
                    for (int k = j - 1; k >= i; --k) {
                        logs[k + 1] = logs[k];
                    }
                    logs[i] = temp;
                    continue;
                }
                if (compareLetterLog(logs[i], logs[j]) >= 0) {
                    String temp = logs[i];
                    logs[i] = logs[j];
                    logs[j] = temp;
                }
            }
        }
        return logs;
    }

    public static void main(String[] args) {
        No937ReorderDataInLogFiles solution = new No937ReorderDataInLogFiles();
        String[] logs = new String[]{"t kvr", "r 3 1", "i 403", "7 so", "t 54"};
        String[] reorderLogs = solution.reorderLogFiles(logs);
        for (String log : reorderLogs) {
            System.out.println(log);
        }
    }
}
