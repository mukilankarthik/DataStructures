/*Add two singly linked list*/
public class AddTwoNumbers {
    public static void main(String[] args) {
        //[1,9,9,9,9,9,9,9,9,9]
        ListNode l1a = new ListNode(9);
        ListNode l1b = new ListNode(9, l1a);
        ListNode l1c = new ListNode(9, l1b);
        ListNode l1d = new ListNode(9, l1c);
        ListNode l1e = new ListNode(9, l1d);
        ListNode l1f = new ListNode(9, l1e);
        ListNode l1g = new ListNode(9, l1f);
        ListNode l1h = new ListNode(9, l1g);
        ListNode l1i = new ListNode(9, l1h);
        ListNode l1j = new ListNode(1, l1i);



        ListNode l2a = new ListNode(4);
        ListNode l2b = new ListNode(6, l2a);
        ListNode l2c = new ListNode(5, l2b);
        ListNode l2d = new ListNode(9);

        ListNode l2e = new ListNode(1);


        Solution s = new Solution();

        ListNode testcase1 = s.addTwoLists_sol1(l1c, l2c);
        ListNode testcase2 = s.addTwoLists_sol1(l1d, l2d);
        ListNode testcase3 = s.addTwoLists_sol1(l1j, l2d);

    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode() {

    }
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val; this.next = next;
    }
}

class Solution {

    public ListNode addTwoLists_sol1(ListNode l1, ListNode l2) {
        // res is head node of the resultant list
        ListNode res = null;
        ListNode prev = null;
        ListNode temp = null;
        int carry = 0, sum;

        while (l1 != null || l2 != null) {
            sum = carry + (l1 != null ? l1.val : 0)
                    + (l2 != null ? l2.val : 0);

            carry = (sum >= 10) ? 1 : 0;

            sum = sum % 10;

            temp = new ListNode(sum);

            if (res == null) {
                res = temp;
            } else {
                prev.next = temp;
            }

            prev = temp;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (carry > 0) {
            temp.next = new ListNode(carry);
        }

        return res;
    }

    public ListNode addTwoNumbers_sol2(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}


