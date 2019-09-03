package com.nero.main.java.algrorithm.Binary_Search_Tree.Binary_Tree_Classic_Nonrecursive_Traversal.Postorder;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution6 {

    // Classic Non-Recursive
    // Using a pre pointer to record the last visted node
    //
    // Time Complexity: O(n)
    // Space Complexity: O(h)
    public List<Integer> inorderTraversal(TreeNode root){
            ArrayList<Integer> res = new ArrayList<>();
            if (root == null)
                return res;

            Stack<TreeNode> stack = new Stack<>();
            TreeNode pre = null;
            TreeNode cur = root;


            while (cur != null || !stack.empty()){
                    if(cur != null){
                            stack.push(cur);
                            cur = cur.left;
                        }
                    else {
                        cur = stack.pop();
                        if (cur.right == null || pre == cur.right){
                                res.add(cur.val);
                                pre = cur;
                                cur = null;
                            }
                        else {
                            stack.push(cur);
                            cur = cur.right;
                        }
                     }
                }
            return res;
        }
}
