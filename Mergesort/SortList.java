package Mergesort;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        return merge(left, right);
    }

    private ListNode getMid(ListNode head){
        ListNode slow = head, fast = head, prev = null;

        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if(prev != null) prev.next = null;
        return slow;
    }

    private ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode();
        ListNode tail = dummy;

        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                tail.next = l1;
                l1 = l1.next;
            }
            else{
                tail.next = l2;
                l2 = l2.next;
            }

            tail = tail.next;
        }

        if(l1 != null) tail.next = l1;
        else tail.next = l2;

        return dummy.next;
    }

    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3))));
        System.out.print("Original: ");
        printList(head);

        SortList sorter = new SortList();
        ListNode sorted = sorter.sortList(head);

        System.out.print("Sorted: ");
        printList(sorted);
    }
}

