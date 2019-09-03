package com.nero.main.java.algrorithm.Binary_Search_Tree.Binary_Tree_Classic_Nonrecursive_Traversal.Postorder;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// Non-Recursive
// Using a tag to record whether the node has been visited
// Time Complexity: O(n), n is the node number in the tree
// Space Complexity: O(h), h is the height of the tree
public class Solution {

    private class TagNode{
            TreeNode node;
            boolean isFirst;
            TagNode(TreeNode node){
                    this.node = node;
                    this.isFirst = false;
                }
        }


    public List<Integer> inorderTraversal(TreeNode root){
            ArrayList<Integer> res = new ArrayList<>();
            if (root == null)
                return res;

            Stack<TagNode> stack = new Stack<>();
            TreeNode cur = root;
            while (cur != null || !stack.empty()){
                    while (cur != null){
                            stack.push(new TagNode(cur));
                            cur = cur.left;
                        }

                    TagNode tagNode = stack.pop();
                    cur = tagNode.node;
                    if (tagNode.isFirst == false){
                            tagNode.isFirst = true;
                            stack.push(tagNode);
                            cur = cur.right;
                        }
                    else {
                        res.add(cur.val);
                        cur = null;
                      }
                }
            return res;
        }
}
