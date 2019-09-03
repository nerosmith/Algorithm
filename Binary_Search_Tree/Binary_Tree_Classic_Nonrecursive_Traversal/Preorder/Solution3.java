package com.nero.main.java.algrorithm.Binary_Search_Tree.Binary_Tree_Classic_Nonrecursive_Traversal.Preorder;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution3 {
    public List<Integer> preorderTraversal(TreeNode root){
            ArrayList<Integer> res = new ArrayList<>();
            if (root == null)
                return res;

            Stack<TreeNode> stack = new Stack<>();
            TreeNode cur = root;
            while (cur != null || !stack.isEmpty()){
                    if (cur != null){
                            res.add(cur.val);
                            stack.push(cur);
                            cur = cur.left;
                        }
                    else{
                        cur = stack.pop();
                        cur = cur.right;
                    }
                }
            return res;
        }
}
