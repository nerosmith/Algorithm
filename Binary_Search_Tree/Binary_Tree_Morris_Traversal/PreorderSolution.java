package com.nero.main.java.algrorithm.Binary_Search_Tree.Binary_Tree_Morris_Traversal;

import java.util.ArrayList;
import java.util.List;

// PreOrder Morris Traversal
// Time Complexity: O(n), n is the node number in the tree
// Space Complexity: O(1)
public class PreorderSolution {
    public List<Integer> preorderTraversal(TreeNode root){
            ArrayList<Integer> res = new ArrayList<Integer>();
            if(root == null)
                return res;

            TreeNode cur = root;
            while (cur != null){
                    if (cur.left == null){
                            res.add(cur.val);
                            cur = cur.right;
                        }
                    else {
                        TreeNode prev = cur.left;
                        while (prev.right != null && prev.right != cur)
                            prev = prev.right;

                        if (prev.right == null){
                                res.add(cur.val);
                                prev.right = cur;
                                cur = cur.left;
                            }
                        else {
                            prev.right = null;
                            cur = cur.right;
                        }
                    }
                }
            return res;
        }
}
