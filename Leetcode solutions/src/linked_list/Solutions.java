package linked_list;




class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode root=head;
            ListNode rev=reverse(root);
        ListNode remove=removeElement(rev,n);
        ListNode normal=reverse(remove);
        return normal;
    }
    public ListNode removeElement(ListNode head,int n)
    {
        int cn=1;
        ListNode prevNode=null;
        ListNode nextNode=null;
        ListNode cur=head;
        while(cn<=n)
        {
            if(cn==n)
            {
                if(prevNode==null)
                {
                    prevNode=head;
                    prevNode=prevNode.next;;
                    return prevNode;
               }
                else{
                   prevNode.next=nextNode;
                    break;
                }
            }
            
            prevNode=cur;
            cur=cur.next;
            nextNode=cur.next;
            
            cn++;
        }
        return head;
    }
    public ListNode reverse(ListNode root)
    {
        if(root==null || root.next==null)
        {
            return root;
        }
        ListNode last=reverse(root.next);
        root.next.next=root;
        root.next=null;
        
        return last;
    }
}