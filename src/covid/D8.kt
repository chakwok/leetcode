package covid

import helper.ListNode

class D8 {
    fun middleNode(head: ListNode?): ListNode? {
        if(head == null) {
            return null;
        }

        var fast = ListNode(-37);
        fast.next = head;
        var slow = ListNode(-37);
        slow.next = head;

        while(true) {
            if(fast.next == null) {
                return slow.next;
            } else if(fast.next.next == null){
                return slow.next;
            } else {
                fast = fast.next.next;
                slow = slow.next;
            }
        }
    }
}

fun main(){
    println(D8().middleNode(ListNode.of(1,2,3,4,5,6)))
}