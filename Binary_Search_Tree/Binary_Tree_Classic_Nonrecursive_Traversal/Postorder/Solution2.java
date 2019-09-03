package com.nero.main.java.algrorithm.Binary_Search_Tree.Binary_Tree_Classic_Nonrecursive_Traversal.Postorder;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution2 {
    public List<Integer> inorderTraversal(TreeNode root){
            ArrayList<Integer> res = new ArrayList<>();
            if (root == null)
                return res;

            Stack<TreeNode> stack = new Stack<>();
            Stack<Integer> output = new Stack<>();

            stack.push(root);

            while (!stack.empty()){
                    TreeNode cur = stack.pop();
                    output.push(cur.val);

                    if (cur.left != null)
                        stack.push(cur.left);
                    if (cur.right != null)
                        stack.push(cur.right);
                }

            while (!output.empty())
                res.add(output.pop());

            return res;

        }
}
