package javase.datastruct.graph.algorithm;

import javase.datastruct.graph.Edge;
import javase.datastruct.graph.Graph;
import javase.datastruct.graph.Node;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
//从点的角度出发，每次都是选已解锁的点的最小权值的边
public class Prim {
    public static Set<Edge> prim(Graph graph){
        //解锁的边中权值最小的边
        PriorityQueue<Edge>priorityQueue = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight-o2.weight;
            }
        });
        //对已经添加过的结点进行记录
        HashSet<Node>hashSet = new HashSet<>();
        //最后的结果
        Set<Edge>res = new HashSet<>();
        //从任意一个结点开始都可（for循环是考虑到了森林的特殊情况）
        for(Node node : graph.nodes.values()){
            if(!hashSet.contains(node)){
                //任意一个点开始，将结点记录
                hashSet.add(node);
                for(Edge edge : node.edges){
                    priorityQueue.add(edge);
                }
                while(!priorityQueue.isEmpty()){
                    //取出当前“已解锁”的最小权值的边
                    Edge edge = priorityQueue.poll();
                    //to点如果并未考察过则记录该点，并将该边放入结果
                    Node toNode = edge.to;
                    if(!hashSet.contains(toNode)){
                        res.add(edge);
                        hashSet.add(toNode);
                        for(Edge nextEdge : toNode.edges){
                            priorityQueue.add(nextEdge);
                        }
                    }
                }
            }
            //若该图默认联通则while循环结束即可break出循环
            //break;
        }
        return res;
    }
}
