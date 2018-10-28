package helper;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) { val = x; }

    public static ListNode of(int... vals) {
        if(vals.length == 0 ) {
            return null;
        }
        ListNode toReturn = null;
        ListNode ptr = toReturn;

        for (int val : vals) {
            if (toReturn == null) {
                toReturn = new ListNode(val);
                ptr = toReturn;
            } else {
                ptr.next = new ListNode(val);
                ptr = ptr.next;

            }
        }

        return toReturn;
    }

    @Override
    public String toString() {
        String toReturn = "" + val;
        ListNode ptr = next;
        while (ptr != null) {
            toReturn += "-> " + ptr.val;
            ptr = ptr.next;
        }

        return toReturn;
    }
}
