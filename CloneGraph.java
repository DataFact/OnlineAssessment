// 拷贝无向图
// 采用DFS递归

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class CloneGraph{

	public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node){
		if(node == null){
			return node;
		}

		HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
		UndirectedGraphNode copied = new UndirectedGraphNode(node.label);
		map.put(node, copied);
		DFS(map, node);
		return copied;
	}

	public static void DFS(HashMap<UndirectedGraphNode, UndirectedGraphNode> map, UndirectedGraphNode node){
		if(node == null){
			return;
		}

		for(UndirectedGraphNode cur : node.neighbors){
			if(!map.containsKey(cur)){
				UndirectedGraphNode copied = new UndirectedGraphNode(cur.label);
				map.put(cur, copied);
				DFS(map, cur);
			}
			map.get(node).neighbors.add(map.get(cur));
		}
	}

	public static void main(String[] args) {

	}
}

class UndirectedGraphNode{
		int label;
		List<UndirectedGraphNode> neighbors;
		UndirectedGraphNode(int x){
			label = x;
			neighbors = new ArrayList<UndirectedGraphNode>();
		}
	}
