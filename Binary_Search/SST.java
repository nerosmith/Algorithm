package com.nero.main.java.algorithm.Binary_Search;

public class SST<Key extends Comparable<Key>,Value>{

    // 順序查找表中的節點為私有的類, 外界不需要了解順序查找法節點的具體實現
    // 我們的順序查找表, 內部本質是一個鍊錶
    private class Node{
            private Key key;
            private Value value;
            private Node next;

            public Node(Key key,Value value){
                    this.key = key;
                    this.value = value;
                    next = null;
                }
        }

    private Node head; // 表頭
    private int count; // 順序查找表中的節點個數


    // 構造函數
    public SST(){
            head = null;
            count = 0;
        }

    // 返回順序查找表中的節點個數
    public int size(){
            return count;
        }

    // 返回順序查找表是否為空
    public boolean isEmpty(){
            return count == 0;
        }

    // 向順序查找表中插入一個新的(key, value)數據對
    public void insert(Key key,Value value){
            // 查找一下整個順序表，肯是否存在同樣大小的key
            Node node = head;
            while (node != null){
                    // 若在順序表中找到了同樣大小key的節點
                    // 則當前節點不需要插入，將該key所對應的值更新為value後返回
                    if (key.compareTo(node.key) == 0){
                            node.value = value;
                            return;
                        }
                    node = node.next;
                }

            // 若順序表中沒有同樣大小的key，則創建新節點，將新節點直接插在表頭
            Node newNode = new Node(key,value);
            newNode.next = head;
            head = newNode;
            count++;
        }

    // 查看順序查找表中是否包含鍵值為key的節點
    public boolean contain(Key key){
            Node node = head;
            while (node != null){
                    if (key.compareTo(node.key) == 0)
                        return true;
                    node = node.next;
                }
            return false;
        }

    // 在順序查找表中查找key所對應的value, 若value不存在, 則返回NULL
    public Value search(Key key){
            Node node = head;
            while (node != null){
                    if (key.compareTo(node.key) == 0)
                        return node.value;
                    node = node.next;
                }
            return null;
        }

    // 在順序查找表中刪除(key,value)所對應的節點
    public void remove(Key key){

            if (head == null)
                return;


            // 如果待刪除的節點就是頭結點, 則需要特殊處理
            if (key.compareTo(head.key) == 0){
                    Node delNode = head;
                    head = head.next;
                    delNode.next = null;
                    count--;
                    return;
                }

            Node node = head;
            while (node.next != null && node.next.key.compareTo(key) != 0 )
                node = node.next;

            if (node.next != null){
                    Node delNode = node.next;
                    node.next = delNode.next;
                    delNode.next = null;
                    count--;
                    return;
                }
        }
}
