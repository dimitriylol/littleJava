package org.Util;

/**
 * Created by dmytro on 29.02.16.
 */
class ListNode {
    public ListNode next;
    public int index;
    public Object data;

    public ListNode(Object data, ListNode next, int index) {
        this.next = next;
        this.data = data;
        this.index = index;
    }
}

public class CycleList {
    private ListNode head = null;
    private int numberOfElements = 0;
    private ListNode currentElement = null;

    public CycleList(Object data) {
        head = new ListNode(data, head, numberOfElements++);
        currentElement = head;
    }

    public void insertToEnd(Object data) {
        currentElement.next = new ListNode(data, head, numberOfElements++);
        currentElement = head;
    }

    public Object getNextData() {
        return currentElement.next.data;
    }

    public Object getCurrentData() {
        return currentElement.data;
    }

    public void next() {
        currentElement = currentElement.next;
    }
}
