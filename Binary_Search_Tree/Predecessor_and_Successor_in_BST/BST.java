package com.nero.main.java.algrorithm.Binary_Search_Tree.Predecessor_and_Successor_in_BST;

import java.util.LinkedList;
import java.util.Queue;

// 二分搜索樹
// 由於Key需要能夠進行比較，所以需要extends Comparable<Key>
public class BST<Key extends Comparable<Key>,Value> {

    // 樹中的節點為私有的類, 外界不需要了解二分搜索樹節點的具體實現
    private class Node{
            private Key key;
            private Value value;
            private Node left,right;

            public Node(Key key,Value value){
                    this.key = key;
                    this.value = value;
                    left = right =null;
                }

            public Node(Node node){
                    this.key = node.key;
                    this.value = node.value;
                    this.left = node.left;
                    this.right = node.right;
                }
        }

    private Node root; // 根節點
    private int count; // 樹的節點個數

    // 構造函數, 默認構造一棵空二分搜索樹
    public BST(){
            root = null;
            count = 0;
        }

    // 返回二分搜索樹的節點個數
    public int size(){
            return count;
        }

    // 返回二分搜索樹是否為空
    public boolean isEmpty(){
            return count == 0;
        }

    // 向二分搜索樹中插入一個新的(key, value)數據對
    public void insert(Key key,Value value){
            root = insert(root,key,value);
        }

    // 向以node為根的二分搜索樹中, 插入節點(key, value), 使用遞歸算法
    // 返回插入新節點後的二分搜索樹的根
    private Node insert(Node node,Key key,Value value) {
            if (node == null){
                    count++;
                    return new Node(key,value);
                }
            if (key.compareTo(node.key) == 0)
                node.value = value;
            else if (key.compareTo(node.key) < 0)
                node.left = insert(node.left,key,value);
            else
                node.right = insert(node.right,key,value);

            return node;
        }

    // 查看二分搜索樹中是否存在鍵key
    public boolean contain(Key key){
            return  contain(root,key);
        }

    // 查看以node為根的二分搜索樹中是否包含鍵值為key的節點, 使用遞歸算法
    private boolean contain(Node node,Key key){
            if (node == null)
                return false;

            if (key.compareTo(node.key) == 0)
                return true;
            else if (key.compareTo(node.key) < 0)
                return contain(node.left,key);
            else
                return contain(node.right,key);
        }

    // 在二分搜索樹中搜索鍵key所對應的值。如果這個值不存在, 則返回null
    public Value search(Key key){
            Node node = search(root,key);
            return node == null ? null : node.value;
        }

    // 在以node為根的二分搜索樹中查找key所對應的value, 遞歸算法
    // 若value不存在, 則返回NULL
    private Node search(Node node,Key key){
            if (node == null)
                return null;

            if (key.compareTo(node.key) == 0)
                return node;
            else if (key.compareTo(node.key) < 0)
                return search(node.left,key);
            else
                return search(node.right,key);
        }

    // 二分搜索樹的前序遍歷
    public void preOrder(){
            preOrder(root);
        }

    // 對以node為根的二叉搜索樹進行前序遍歷, 遞歸算法
    private void preOrder(Node node){
            if (node != null){
                    System.out.println(node.key);
                    preOrder(node.left);
                    preOrder(node.right);
                }
        }

    // 二分搜索樹的中序遍歷
    public void inOrder(){
            inOrder(root);
        }

    // 對以node為根的二叉搜索樹進行中序遍歷, 遞歸算法
    private void inOrder(Node node){
        if (node != null){
            inOrder(node.left);
            System.out.println(node.key);
            inOrder(node.right);
          }
      }

    // 二分搜索樹的後序遍歷
    public void postOrder(){
            postOrder(root);
        }

    // 對以node為根的二叉搜索樹進行後序遍歷, 遞歸算法
    private void postOrder(Node node){
            if (node != null){
                postOrder(node.left);
                postOrder(node.right);
                System.out.println(node.key);
            }
        }

    // 二分搜索樹的層序遍歷
    public void levelOrder(){

            // 我們使用LinkedList來作為我們的隊列
            Queue<Node> queue = new LinkedList<Node>();
            queue.add(root);

            while(!queue.isEmpty()){
                    Node node = queue.remove();
                    System.out.println(node.key);
                    if (node.left != null)
                        queue.add(node.left);
                    if (node.right != null)
                        queue.add(node.right);
                }
        }

    // 尋找二分搜索樹的最小的鍵值
    public Key minimum(){
            assert count != 0;
            Node minNode = minimum(root);
            return minNode.key;
        }

    // 返回以node為根的二分搜索樹的最小鍵值所在的節點
    private Node minimum(Node node){
            if (node.left == null)
                return node;

            return minimum(node.left);
        }

    // 尋找二分搜索樹的最大的鍵值
    public Key maximum(){
            assert count != 0;
            Node maxNode = maximum(root);
            return maxNode.key;
        }

    // 返回以node為根的二分搜索樹的最大鍵值所在的節點
    private Node maximum(Node node){
            if (node.right == null)
                return node;

            return minimum(node.right);
        }

    // 從二分搜索樹中刪除最小值所在節點
    public void removeMin(){
            if (root != null)
                root = removeMin(root);
        }

    // 刪除掉以node為根的二分搜索樹中的最小節點
    // 返回刪除節點後新的二分搜索樹的根
    private Node removeMin(Node node){
            if (node.left == null){
                    Node rightNode = node.right;
                    node.right = null;
                    count--;
                    return rightNode;
                }
            node.left = removeMin(node.left);
            return node;
       }

    // 從二分搜索樹中刪除最大值所在節點
    public void removeMax(){
            if (root != null)
                root = removeMax(root);
        }

    // 刪除掉以node為根的二分搜索樹中的最大節點
    // 返回刪除節點後新的二分搜索樹的根
    private Node removeMax(Node node){
            if (node.right == null){
                    Node leftNode = node.left;
                    node.left = null;
                    count--;
                    return leftNode;
                }

            node.right = removeMax(node.right);
            return node;
        }

    // 刪除掉以node為根的二分搜索樹中鍵值為key的節點, 遞歸算法
    // 返回刪除節點後新的二分搜索樹的根
    Node remove(Node node,Key key){
            if (node == null)
                return null;

            if (key.compareTo(node.key) < 0){
                    node.left = remove(node.left,key);
                    return node;
                }
            else if (key.compareTo(node.key) > 0){
                    node.right = remove(node.right,key);
                    return node;
                }
            else{// key == node.key

                // 待刪除節點左子樹為空的情況
                if (node.left == null){
                        Node rightNode = node.right;
                        node.right = null;
                        count--;
                        return rightNode;
                    }

                // 待刪除節點右子樹為空的情況
                if (node.left == null){
                        Node rightNode = node.right;
                        node.right = null;
                        count--;
                        return rightNode;
                    }

                // 待刪除節點左右子樹均不為空的情況

                // 找到比待刪除節點大的最小節點, 即待刪除節點右子樹的最小節點
                // 用這個節點頂替待刪除節點的位置
                Node successor = new Node(minimum(node.right));
                count++;

                successor.right = removeMin(node.right);
                successor.left = node.left;

                node.left = node.right = null;
                count--;

                //返回替代節點的地址即新樹的根節點地址給上一層連接用
                return successor;
              }
        }

    // 尋找key的floor值, 遞歸算法
    // 如果不存在key的floor值(key比BST中的最小值還小), 返回NULL
    public Key floor(Key key){

            if (count == 0 || key.compareTo(minimum()) < 0)
                return null;

            Node floorNode = floor(root,key);
            return floorNode.key;
        }

    // 在以node為根的二叉搜索樹中, 尋找key的floor值所處的節點, 遞歸算法
    private Node floor(Node node, Key key) {

            if (node == null)
                return null;

            // 如果node的key值和要尋找的key值相等
            // 則node本身就是key的floor節點
            if (node.key.compareTo(key) == 0)
                return node;

            // 如果node的key值比要尋找的key值大
            // 則要尋找的key的floor節點一定在node的左子樹中
            if (node.key.compareTo(key) > 0)
                return floor(node.left,key);

            // 如果node->key < key
            // 則node有可能是key的floor節點, 也有可能不是(存在比node->key大但是小於key的其餘節點)
            // 需要嘗試向node的右子樹尋找一下
            Node tempNode = floor(node.right,key);
            if (tempNode != null)
                return tempNode;

            return node;
        }

    // 尋找key的ceil值, 遞歸算法
    // 如果不存在key的ceil值(key比BST中的最大值還大), 返回NULL
   public Key ceil(Key key){

           if (count == 0 || key.compareTo(maximum()) > 0)
               return null;

           Node ceilNode = ceil(root,key);
           return ceilNode.key;
        }

   private Node ceil(Node node, Key key) {
           if (node == null)
               return null;

           // 如果node的key值和要尋找的key值相等
           // 則node本身就是key的floor節點
           if (node.key.compareTo(key) == 0)
               return node;

           // 如果node的key值比要尋找的key值大
           // 則要尋找的key的floor節點一定在node的左子樹中
           if (node.key.compareTo(key) < 0)
               return floor(node.right,key);

           // 如果node->key < key
           // 則node有可能是key的floor節點, 也有可能不是(存在比node->key大但是小於key的其餘節點)
           // 需要嘗試向node的右子樹尋找一下
           Node tempNode = floor(node.left,key);
           if (tempNode != null)
               return tempNode;

           return node;
        }

    // 查找key的前驅
    // 如果不存在key的前驅(key不存在, 或者key是整棵二叉樹中的最小值), 則返回NULL
   public Key predecessor(Key key){

            Node node = search(root,key);
            // 如果key所在的節點不存在, 則key沒有前驅, 返回NULL
            if (node == null)
                return null;

            // 如果key所在的節點左子樹不為空,則其左子樹的最大值為key的前驅
            if (node.left != null)
                return maximum(node.left).key;

            // 否則, key的前驅在從根節點到key的路徑上, 在這個路徑上尋找到比key小的最大值, 即為key的前驅
            Node preNode = predecessorFromAncestor(root, key);
            return preNode == null ? null : preNode.key;
        }

    // 在以node為根的二叉搜索樹中, 尋找key的祖先中,比key小的最大值所在節點, 遞歸算法
    // 算法調用前已保證key存在在以node為根的二叉樹中
   private Node predecessorFromAncestor(Node node, Key key) {

        if (node.key.compareTo(key) == 0)
               return null;

           if (key.compareTo(node.key) < 0)
            // 如果當前節點大於key, 則當前節點不可能是比key小的最大值
            // 向下搜索到的結果直接返回
                return predecessorFromAncestor(node.left,key);
           else {
                assert key.compareTo(node.key) > 0;
                // 如果當前節點小於key, 則當前節點有可能是比key小的最大值
                // 向右繼續搜索, 將結果存儲到tempNode中
                Node tempNode = predecessorFromAncestor(node.right,key);
                if (tempNode != null)
                    return tempNode;
                else
                    // 如果tempNode為空, 則當前節點即為結果
                    return node;
             }
        }

    // 查找key的後繼, 遞歸算法
    // 如果不存在key的後繼(key不存在, 或者key是整棵二叉樹中的最大值), 則返回NULL
   public Key successor(Key key){
            Node node = search(root,key);
            // 如果key所在的節點不存在, 則key沒有前驅, 返回NULL
            if (node == null)
                return null;

            // 如果key所在的節點右子樹不為空,則其右子樹的最小值為key的後繼
            if (node.right !=  null)
                return maximum(node.right).key;

            // 否則, key的後繼在從根節點到key的路徑上, 在這個路徑上尋找到比key大的最小值, 即為key的後繼
            Node sucNode = successorFromAncestor(root, key);
            return sucNode == null ? null : sucNode.key;
        }

   private Node successorFromAncestor(Node node, Key key) {
            if (node.key.compareTo(key) == 0)
                return null;

            if (key.compareTo(node.key) > 0)
                // 如果當前節點小於key, 則當前節點不可能是比key大的最小值
                // 向下搜索到的結果直接返回
                return successorFromAncestor(node.right,key);
            else {
                assert key.compareTo(node.key) < 0 ;
                // 如果當前節點大於key, 則當前節點有可能是比key大的最小值
                // 向左繼續搜索, 將結果存儲到tempNode中
                Node tempNode = successorFromAncestor(node.left,key);
                return tempNode == null ? node : tempNode;
              }
        }
}
