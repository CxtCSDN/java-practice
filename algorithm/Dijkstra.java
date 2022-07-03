package javase.datastruct.graph.algorithm;

import javase.datastruct.graph.Edge;
import javase.datastruct.graph.Node;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

//赋权图的单元最小路径问题
//迪克斯特拉算法
public class Dijkstra {
    public static HashMap<Node,Integer> dijkstra(Node head){
        /**
         * 该Map中记录从head出发到所有结点的最小距离
         * key为从head出发到达key结点
         * value为从head出发到key的最小距离
         * 默认没记录在Map中的结点则可意为着head到该结点距离为正无穷
         */
        HashMap<Node,Integer>distanceMap = new HashMap<>();//每个结点到源结点的距离
        HashSet<Node>selectedSet = new HashSet<>();//已经选择过的结点
        //一定是从某个结点出发
        distanceMap.put(head,0);
        //获取当前到源节点距离最小的结点
        Node minNode = getMinDistanceAndUnselectedNode(distanceMap,selectedSet);
        //当全部结点都在SelectSet中记录了则再无minNode结点
        while(minNode != null){
            //获取当前结点到minNode的已记录的最短路径
            int distance = distanceMap.get(minNode);
            //遍历该结点的每一条边
            for(Edge edge : minNode.edges){
                Node toNode = edge.to;
                //如果to结点未曾记录则将记录添加，即distance为当前结点的路径+边的权值（距离）
                if(!distanceMap.containsKey(toNode)){
                    distanceMap.put(toNode,distance+edge.weight);
                }else{
                    //如果已经存在，则考察是否需要更新记录
                    distanceMap.put(toNode,Math.min(distanceMap.get(toNode),distance+edge.weight));
                }
            }
            //处理完当前最小结点后则将其记录于Set中避免重复进行记录
            selectedSet.add(minNode);
            //再次获取一个最小距离的结点
            minNode = getMinDistanceAndUnselectedNode(distanceMap,selectedSet);
        }
        return distanceMap;
    }
    public static Node getMinDistanceAndUnselectedNode(HashMap<Node,Integer>distanceMap,HashSet<Node>touchedNode){
        Node minNode = null;
        int minDistance = Integer.MAX_VALUE;
        //遍历已记录的点，获取一个未被锁定（记录于Set）的最小距离的点
        for(Map.Entry<Node,Integer> entry : distanceMap.entrySet()){
            Node node = entry.getKey();
            int distance = entry.getValue();
            //如果未被绑定，选出最小距离的那个结点
            if(!touchedNode.contains(node) && distance < minDistance){
                minNode = node;
                minDistance = distance;
            }
        }
        return minNode;
    }
}
