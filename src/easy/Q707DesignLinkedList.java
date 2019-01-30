package easy;

class Q707DesignLinkedList {
    Node sentinel;
    int size;


    /** Initialize your data structure here. */
    public Q707DesignLinkedList() {
        sentinel = new Node(37);
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index >= size) {
            return - 1;
        }
        Node ptr = sentinel.next;
        for (int i = 0; i < index; i++) {
            ptr = ptr.next;
        }
        return ptr.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        if (size == 0) {
            sentinel.next = new Node(val, null, null);
            size += 1;
        } else if (size == 1) {
            Node newNode = new Node(val, sentinel.next, sentinel.next);
            sentinel.next.next = newNode;
            sentinel.next.prev = newNode;
            sentinel.next = newNode;
            size += 1;
        } else {
            addAtIndex(0, val);
            sentinel.next = sentinel.next.prev;
        }



    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        //addAtIndex(size - 1, val);
        if (size == 0) {
            sentinel.next = new Node(val, null, null);
        } else if (size == 1) {
            Node newNode = new Node(val, sentinel.next, sentinel.next);
            sentinel.next.next = newNode;
            sentinel.next.prev = newNode;
        } else {
            Node newNode = new Node(val, sentinel.next, sentinel.next.prev);
            sentinel.next.prev.next = newNode;
            sentinel.next.prev = newNode;
        }
        size += 1;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index == size) {
            addAtTail(val);
        } else if (index > size) {
            return;
        } else {
            Node ptr = sentinel.next;
            for (int i = 0; i < index; i++) {
                ptr = ptr.next;
            }
            Node newNode = new Node(val, ptr, ptr.prev);
            ptr.prev.next = newNode;
            ptr.prev = newNode;
            size += 1;
        }

    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index >= size) {
            return;
        }
        Node ptr = sentinel.next;
        for (int i = 0; i < index; i++) {
            ptr = ptr.next;
        }
        ptr.prev.next = ptr.next;
        ptr.next.prev = ptr.prev;
        size -= 1;
    }

/*    public static void main(String[] args) {
        Q707DesignLinkedList main = new Q707DesignLinkedList();
        main.addAtHead(7);
        main.addAtHead(2);
        main.addAtHead(1);
        main.addAtIndex(3, 0);
        main.deleteAtIndex(2);
    }*/

    private static class Node {
        int val;
        Node next;
        Node prev;

        private Node(int val, Node next, Node prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }

        private Node(int val) {
            this(val, null, null);
        }

    }

}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */