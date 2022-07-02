package javase.datastruct.graph.algorithm;

import javase.datastruct.graph.Node;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public static void bfs(Node node){
        if(node == null){
            return;
        }
        Queue<Node>nodeQueue = new LinkedList<>();
        HashSet<Node>nodeSet = new HashSet<>();
        nodeQueue.add(node);
        nodeSet.add(node);
        while(!nodeQueue.isEmpty()) {
            Node front = nodeQueue.poll();
            System.out.println(front.value);
            for(Node next : front.nexts){
                if(!nodeSet.contains(next)){
                    nodeQueue.add(next);
                    nodeSet.add(next);
                }
            }
        }
    }
}
