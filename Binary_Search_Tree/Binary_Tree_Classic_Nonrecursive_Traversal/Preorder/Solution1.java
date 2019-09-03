package com.nero.main.java.algrorithm.Binary_Search_Tree.Binary_Tree_Classic_Nonrecursive_Traversal.Preorder;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// Another Classic Non-Recursive algorithm for preorder traversal
// Time Complexity: O(n), n is the node number in the tree
// Space Complexity: O(h), h is the height of the tree
public class Solution1 {
    public List<Integer> preorderTraversal(TreeNode root){
            ArrayList<Integer> res = new ArrayList<>();
            if (root == null)
                return res;

            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);

            while (!stack.empty()){
                    TreeNode curNode = stack.pop();
                    res.add(curNode.val);

                    if (curNode.right != null)
                        stack.push(curNode.right);
                    if (curNode.left != null)
                        stack.push(curNode.left);
                }
            return res;
        }
}
