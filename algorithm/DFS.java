package javase.datastruct.graph.algorithm;

import javase.datastruct.graph.Node;

import java.util.HashSet;
import java.util.Stack;

public class DFS {
    public static void dfs(Node node){
        if(node == null){
            return;
        }
        HashSet<Node>hashSet = new HashSet<>();
        Stack<Node>stack = new Stack<>();
        stack.push(node);
        hashSet.add(node);
        System.out.println(node.value);
        while(!stack.empty()){
            Node top = stack.pop();
            for(Node next : top.nexts){
                if(!hashSet.contains(next)){
                    stack.push(top);
                    stack.push(next);
                    hashSet.add(next);
                    System.out.println(next.value);
                    break;
                }
            }
        }
    }
}
