class Solution {
    public ListNode partition(ListNode head,
                              int x) {

        ListNode smaller =
            new ListNode(0);

        ListNode greater =
            new ListNode(0);

        ListNode s = smaller;
        ListNode g = greater;

        while (head != null) {

            if (head.val < x) {
                s.next = head;
                s = s.next;
            } else {
                g.next = head;
                g = g.next;
            }

            head = head.next;
        }

        g.next = null;
        s.next = greater.next;

        return smaller.next;
    }
}