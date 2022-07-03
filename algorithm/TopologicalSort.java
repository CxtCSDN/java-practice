package javase.datastruct.graph.algorithm;

import javase.datastruct.graph.Graph;
import javase.datastruct.graph.Node;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopologicalSort {
    public static List<Node> topologicalSort(Graph graph){
        HashMap<Node,Integer>hashMap = new HashMap<>();
        Queue<Node>queue = new LinkedList<>();
        //先遍历一遍图，将图中的结点及其入度进行记录
        //同时寻找入度为0的结点加入队列
        for(Node node : graph.nodes.values()){
            hashMap.put(node,node.in);
            if(node.in == 0){
                queue.add(node);
            }
        }
        //res存放拓扑排序结果
        List<Node>res = new LinkedList<>();
        //进行拓扑排序
        while(!queue.isEmpty()){
            //取出度为0的结点即结果加入结果链表中
            Node node = queue.poll();
            res.add(node);
            //遍历其next（擦除其对相邻结点的入度产生的影响）
            for(Node next : node.nexts){
                hashMap.put(next,hashMap.get(next)-1);
                //擦除影响后入度变为0则人队列
                if(hashMap.get(next) == 0){
                    res.add(next);
                }
            }
        }
        return res;
    }
}
