package com.example.demo.exercise;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author yubang@alibaba-inc.com
 * @date 2020/1/8 11:51 下午
 */
public class No894AllPossibleFullBinaryTrees {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private Map<Integer, List<TreeNode>> memo = new HashMap();

    public List<TreeNode> allPossibleFBT(int N) {
        if (!memo.containsKey(N)) {
            List<TreeNode> result = new LinkedList<>();
            if (N == 1) {
                result.add(new TreeNode(0));
            } else if (N % 2 == 1) {
                for (int i = 0; i < N; ++i) {
                    int j = N - 1 - i;
                    for (TreeNode left : allPossibleFBT(i)) {
                        for (TreeNode right : allPossibleFBT(j)) {
                            TreeNode node = new TreeNode(0);
                            node.left = left;
                            node.right = right;
                            result.add(node);
                        }
                    }
                }
            }
            memo.put(N, result);
        }

        return memo.get(N);
    }
}
