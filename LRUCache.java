/*
 * @Author: dxhInter dxh0530@gmail.com
 * @Date: 2024-02-23 14:36:13
 * @LastEditors: dxhInter dxh0530@gmail.com
 * @LastEditTime: 2024-02-23 15:44:11
 * @FilePath: \Java-LeetCode\Solution146.java
 */

import java.util.*;

public class LRUCache {
    /**
     * DListNode
     */
    class DListNode {
        int key;
        int value;
        DListNode prev;
        DListNode next;
        public DListNode () {};
        public DListNode (int key, int value) {this.key = key; this. value = value; };
    }

    private DListNode dummyHead, dummyTail;
    private int size;
    private int capacity;
    private Map<Integer, DListNode> cache = new HashMap<Integer, DListNode>();

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        // 使用虚拟头尾节点
        dummyHead = new DListNode();
        dummyTail = new DListNode();
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }
    
    /**
     * get方法，执行get方法的节点放到链表最前面
     * 查询的时候先查询缓存，没有就返回-1
     * @param key
     * @return
     */
    public int get(int key) {
        DListNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        move2Head(node);
        return node.value;
    }
    
    /**
     * 先从缓存中查找节点是否存在，如果存在则直接更新value，并且移到前面
     * 如果不存在则将节点信息保存到cache中，并且LRUCache的size++，如果大于容量，则删除尾节点也就是最长时间没有用的节点
     * 之后根据的删除尾节点的key从cache中删除，保持缓存一致性
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        DListNode node = cache.get(key);
        if(node == null){
           DListNode newNode = new DListNode(key, value);
           cache.put(key, newNode);
           add2Head(newNode);
           size++;
           if (size > capacity) {
               DListNode tail = removeTail();
               cache.remove(tail.key);
               size--;
           }
        } else {
            node.value = value;
            move2Head(node);
        }
    }

    private void move2Head (DListNode node){
        removeNode(node);
        add2Head(node);
    }

    private void add2Head(DListNode node) {
        node.next = dummyHead.next;
        node.prev = dummyHead;
        dummyHead.next.prev = node;
        dummyHead.next = node;
    }

    private void removeNode(DListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    /**
     * @return 为了保持缓存一致性所以需要返回被删除的尾节点
     */
    private DListNode removeTail(){
        DListNode res = dummyTail.prev;
        removeNode(res);
        return res;
    }
}