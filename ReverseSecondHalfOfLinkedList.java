/* 反转单链表的后一半
* 先写反转单链表函数
* 再写找到单链表中点的函数(无论链表长度为奇偶数，中点在length/2+1位置)
* 最后调用这两个函数
*/
public class ReverseSecondHalfOfLinkedList{

	public static ListNode reverseSecondHalfOfLinkedList(ListNode head){
		if(head == null || head.next==null){
			return head;
		}
		ListNode mid = midOfLinkedList(head);
		ListNode reverseHead = reverseLinkedList(mid);
		return reverseHead;
	}

	public static ListNode reverseLinkedList(ListNode head){
		if(head == null || head.next == null){
			return head;
		}
		ListNode pre = head;
		ListNode cur = head.next;
		while(cur!=null){
			ListNode temp = cur;
			cur.next = pre;
			pre = cur;
			cur = temp;
		}
		head.next = null;
		return pre;
	}

	public static ListNode midOfLinkedList(ListNode head){
		if(head == null || head.next == null){
			return head;
		}

		//定义两个指针，一快一慢
		ListNode slow = head;
		ListNode fast = head;
		while(fast != null && fast.next != null){
			fast = fast.next;	//fast先向后移动一次
			if(fast.next != null){	//如果移动一次后不为null
				fast = fast.next;	//则再移动第二次，这样fast每次就向后移动了2次
			}
			slow = slow.next;	//slow每次仅向后移动1次
		}
		return slow;	//最后slow所在的位置就是中点位置
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
