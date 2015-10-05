public class LastKElements{
	public static ListNode lastKElements(ListNode head, int k){
		if(head==null || k<1){
			return head;
		}

		ListNode start = head;
		ListNode end = head;

		for (int i=0; i<k-1; i++) {
			if (end==null) {
				return null; // not found since list size < n
			}
			else{
				end=end.next;
			}
		}

		while(end.next != null){
			start=start.next;
			end=end.next;
		}

		return start;
	}
}


class ListNode{
	int val;
	ListNode next;
	ListNode(int x){
		val = x;
		next = null;
	}
}
