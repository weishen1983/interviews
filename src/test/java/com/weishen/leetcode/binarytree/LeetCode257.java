package com.weishen.leetcode.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode257 {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if(root == null){
            return res;
        }

        Queue<Object> queue = new LinkedList<>();
        queue.add(root);
        queue.add(String.valueOf(root.val));
        while(!queue.isEmpty()){
            TreeNode cur = (TreeNode)queue.poll();
            String path = (String)queue.poll();

            if(cur.left == null && cur.right == null){
                res.add(path);
            }

            if(cur.left != null){
                String leftPath = path + "->" + cur.left.val;
                queue.add(cur.left);
                queue.add(leftPath);
            }

            if(cur.right != null){
                String rightPath = path + "->" + cur.right.val;
                queue.add(cur.right);
                queue.add(rightPath);
            }
        }

        return res;
    }

}
