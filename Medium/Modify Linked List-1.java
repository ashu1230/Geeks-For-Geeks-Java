Given a singly linked list containing N nodes. Modify the Linked list as follows:

1. Modify the value of the first half nodes such that 1st node's new value is equal to the value of the last node minus the first node's current value, 2nd node's new value is equal to the second last nodes value minus 2nd nodes current value, likewise for first half nodes.
2. Replace the second half of nodes with the initial values of the first half nodes(values before modifying the nodes).
3. If N is odd then the value of the middle node remains unchanged.

Example 1:

Input:
N = 5
linked list = 10 -> 4 -> 5 -> 3 -> 6
Output:
-4 -1 5 4 10
Explanation:
For first half nodes modified list will be:
-4 -> -1 -> 5 -> 3 -> 6
For second half nodes modified list will be:
-4 -> -1 -> 5 -> 4 -> 10
Example 2:

Input:
N = 6
linked list = 2 -> 9 -> 8 -> 12 -> 7 -> 10
Output:
8 -2 4 8 9 2
Explanation:
After modifying the linked list as required,
we have a new linked list containing the elements as
8 -> -2 -> 4 -> 8 -> 9 -> 2.
YourTask:
The task is to complete the function modifyTheList() which should modify the list as required.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
1 <= N <= 10^5
-10^5  <= Node->data <= 10^5

#solution...
  //User function Template for Java
class Solution
{
    public static Node reverseList(Node head)
    {
        Node prev = null;
        Node temp = null;
        Node curr = head;
        while(curr!=null)
        {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
    public static Node modifyTheList(Node head)
    {
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node middle = reverseList(slow);
        slow.next = null;
        Node curr = middle;
        Node trav = head;
        Node prev = null;
        while(curr!=null && trav!=slow)
        {
            int temp = trav.data;
            trav.data = curr.data - trav.data;
            curr.data = temp;
            prev = trav;
            curr = curr.next;
            trav = trav.next;
        }
        prev.next = reverseList(middle);
        return head;
    }
}
