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
    class node{
        int val;
        node next;
        node(int val){this.val = val;}
    }

    /** Initialize your data structure here. */
    public MyLinkedList() {
        head = new node(0);
        size = 0;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index < 0 || index >=size){
            return -1;
        }
        node pre = head;
        for (int i = 0;i < index ;i++){
            pre = pre.next;
        }
        return pre.next.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        addAtIndex(0,val);
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        addAtIndex(size,val);
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index > size){
            return;
        }
        if (index < 0){
            index = 0;
        }
        node pre = head;
        for (int i = 0;i < index;i++){
            pre = pre.next;
        }
        node newNode = new node(val);
        newNode.next = pre.next;
        pre.next = newNode;
        size++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index>=0&&index<size){
            node pre = head;
            for (int i = 0;i<index;i++){
                pre = pre.next;
            }
            pre.next = pre.next.next;
            size--;
        }
    }

    private int size;
    private node head;
}