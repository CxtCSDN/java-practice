package javase.datastruct.graph.algorithm;

import javase.datastruct.graph.Edge;
import javase.datastruct.graph.Graph;
import javase.datastruct.graph.Node;

import java.util.*;

/**
 * 仿并查集的集合结构
 * 可以进行集合的查询与合并
 */
class MySet{
    public static List<Node>nodeSet = new ArrayList<>();
    public static HashMap<Node,List<Node>>nodeMap = new HashMap<>();
    MySet(Graph graph){
        for(Node node : graph.nodes.values()){
            List<Node> list = new ArrayList<>();
            list.add(node);
            nodeMap.put(node,list);
        }
    }
    public static boolean isSameSet(Node from,Node to){
        List<Node>fromSet = nodeMap.get(from);
        List<Node>toSet = nodeMap.get(to);
        return fromSet == toSet;
    }
    public static void union(Node from,Node to){
        List<Node>fromSet = nodeMap.get(from);
        List<Node>toSet = nodeMap.get(to);
        for(Node node : toSet){
            fromSet.add(node);
            nodeMap.put(node,fromSet);
        }
    }
}
//从边的角度出发，每次都是从最小边进行选择
public class Kruskal {
    public static Set<Edge> kruskal(Graph graph){
        MySet mySet = new MySet(graph);
        //建小堆，对边从小到大排序
        PriorityQueue<Edge>edges = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight-o2.weight;
            }
        });
        //遍历每一条边加入小根堆
        for(Edge edge : graph.edges){
            edges.add(edge);
        }
        Set<Edge>res = new HashSet<>();
        while(!edges.isEmpty()){
            //取出权值最小的一条边
            Edge edge = edges.poll();
            //如果其from点与to点处于不同集合则将其二者合并
            //并将该边加入结果集合中
            if(!MySet.isSameSet(edge.from,edge.to)){
                res.add(edge);
                MySet.union(edge.from,edge.to);
            }
        }
        return res;
    }
}
