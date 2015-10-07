/* 实现一个LRUCache类，难
* 包括初始化方法 LRUCache(int capacity)
* get(int key) - get the value of the key if it exists in the cache, otherwise return -1
* set(key, value) - set or insert the value if the key is not already present. When the cache
* reached its capacity, it should invalidate the least recently used item before inserting
* a new item.
* 这里采用双向链表和HashMap来实现
*/

import java.util.HashMap;

// 双向链表定义
class DListNode{
	int key;
	int value;
	DListNode pre;
	DListNode post;
}

public class LRUCache{
	private int capacity;
	private int count;
	private HashMap<Integer, DListNode> cache = new HashMap<Integer, DListNode>();
	private DListNode dummyHead, dummyTail;

	public LRUCache(int capacity){
		this.count = 0;
		this.capacity = capacity;
		DListNode dummyHead = new DListNode();
		DListNode dummyTail = new DListNode();
		dummyHead.pre = null;
		dummyHead.post = dummyTail;
		dummyTail.post = null;
		dummyTail.pre = dummyHead;
	}

	// add new node right after dummyHead
	private void addNodeToHead(DListNode node){
		node.pre = dummyHead;
		node.post = dummyHead.post;
		dummyHead.post.pre = node;
		dummyHead.post = node;
	}

	// remove an existing node from the list
	private void removeNode(DListNode node){
		DListNode pre = node.pre;
		DListNode post = node.post;
		pre.post = post;
		post.pre = pre;
	}

	// move a certain node to the head of the list
	private void moveNodeToHead(DListNode node){
		this.removeNode(node);
		this.addNodeToHead(node);
	}

	// pop the current tail
	private DListNode popTail(){
		DListNode tail = dummyTail.pre;
		removeNode(tail);
		return tail;
	}

	public int get(int key){
		DListNode node = cache.get(key);
		if(node == null){
			return -1;
		}
		// move the accessed node to head
		this.moveNodeToHead(node);

		return node.value;
	}

	public void set(int key, int value){
		DListNode node = cache.get(key);
		if(node == null){
			// not find the key in cache
			// insert new node to list
			DListNode newNode = new DListNode();
			newNode.key = key;
			newNode.value = value;
			this.addNodeToHead(node);
			this.cache.put(key, newNode);
			count++; //node数量增加
			if(count > capacity){ // node数量大于capacity
				// 删除tail结点
				DListNode tail = dummyTail.pre;
				this.removeNode(tail);
				// 从HashMap中移除tail的key
				this.cache.remove(tail.key);
				count--;
			}
		}
		else{ // key在cache中

			// 更新node的value
			node.value = value;

			//把对应结点移至head
			moveNodeToHead(node);

		}
	}
}



