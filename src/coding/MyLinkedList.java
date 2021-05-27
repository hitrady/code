package coding;

/**
 * @author dingweiqiang
 * @description 707. 设计链表
 * @date 2021/5/25 19:59
 */
public class MyLinkedList {
    /**
     * Your MyLinkedList object will be instantiated and called as such:
     * MyLinkedList obj = new MyLinkedList();
     * int param_1 = obj.get(index);
     * obj.addAtHead(val);
     * obj.addAtTail(val);
     * obj.addAtIndex(index,val);
     * obj.deleteAtIndex(index);
     */
    class Node{
        int val;
        Node next;
        Node(int val){this.val = val;}
    }

    /** Initialize your data structure here. */
    public MyLinkedList() {
        head = new Node(0);
        size = 0;
    }

    /** Get the value of the index-th Node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index < 0 || index >=size){
            return -1;
        }
        Node pre = head;
        for (int i = 0;i < index ;i++){
            pre = pre.next;
        }
        return pre.next.val;
    }

    /** Add a Node of value val before the first element of the linked list. After the insertion, the new Node will be the first Node of the linked list. */
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next = head.next;
        head.next = newNode;
        size++;
    }

    /** Append a Node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node pre = head;
        while (pre.next !=null ){
            pre = pre.next;
        }
        pre.next = new Node(val);
        size++;
    }

    /** Add a Node of value val before the index-th Node in the linked list. If index equals to the length of linked list, the Node will be appended to the end of linked list. If index is greater than the length, the Node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index == size){
            addAtTail(val);
        }
        if (index<0){
            addAtHead(val);
        }
        if (index>=0 && index<size){
            Node pre = head;
            for (int i = 0;i<index;i++){
                pre = pre.next;
            }
            Node newNode = new Node(val);
            newNode.next = pre.next;
            pre.next = newNode;
            size++;
        }
    }

    /** Delete the index-th Node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index>=0&&index<size){
            Node pre = head;
            for (int i = 0;i<index;i++){
                pre = pre.next;
            }
            pre.next = pre.next.next;
            size--;
        }
    }

    private int size;
    private Node head;
}
