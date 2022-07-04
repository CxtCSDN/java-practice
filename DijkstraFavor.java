package javase.datastruct.graph.algorithm;

import javase.datastruct.graph.Edge;
import javase.datastruct.graph.Node;

import java.util.HashMap;

public class DijkstraFavor {
    public static HashMap<Node,Integer> dijkstraFavor(Node head,int size){
        MyHeap myHeap = new MyHeap(size);
        myHeap.addOrUpdateOrIgnore(head,0);
        HashMap<Node,Integer>result = new HashMap<>();
        while(!myHeap.isEmpty()){
            MyHeap.NodeRecord nodeRecord = myHeap.pop();
            Node cur = nodeRecord.node;
            int distance = nodeRecord.distance;
            for(Edge edge : cur.edges){
                myHeap.addOrUpdateOrIgnore(edge.to, edge.weight+distance);
            }
            result.put(cur,distance);
        }
        return result;
    }
}
