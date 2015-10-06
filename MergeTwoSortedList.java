/*
* 合并两个有序单链表l1,l2
* 先要确定l1,l2中哪个头结点最小
* 要建一个dummyHead来保存head的地址
* 对于接下来的的结点一一比较，将较小的先连上去
* 要注意考虑最后有没有某个链表还有剩余结点，将剩余的部分一次性全部连上去
*/

public class MergeTwoSortedList{
	public static ListNode merge(ListNode l1, ListNode l2){
		if (l1 == null){
			return l2;
		}
		if (l2 == null) {
			return l1;
		}

		ListNode l3; //新建一个结点作为合并链表的头结点

		//找出l1,l2中的最小结点
		if (l1.val > l2.val) {
			l3 = l1;
			l1 = l1.next;
		}
		else {
			l3 = l2;
			l2 = l2.next;
		}

		//用dummyHead保存l3的地址
		ListNode dummyHead = new ListNode(-1);
		dummyHead.next = l3;

		while(l1 != null && l2 != null){
			if (l1.val > l2.val) {
				l3.next = l2;
				l2 = l2.next;
				l3 = l3.next;
			}
			else {
				l3.next = l1;
				l1 = l1.next;
				l3 = l3.next;
			}
		}

		//判断l1或l2是否有剩余部分
		if (l1 != null) {
			l3.next = l1;
		}
		if (l2 != null) {
			l3.next = l2;
		}

		return dummyHead.next;
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
