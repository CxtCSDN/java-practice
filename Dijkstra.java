package javase.datastruct.graph.algorithm;

import javase.datastruct.graph.Edge;
import javase.datastruct.graph.Node;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

class MyHeap{
    private Node[] nodes;
    private HashMap<Node,Integer>nodeIndexMap;
    private HashMap<Node,Integer>distanceMap;
    private int size;
    public void addOrUpdateOrIgnore(Node node,int distance){
        if(inHeap(node)){
            distanceMap.put(node,Math.min(distanceMap.get(node),distance));
            AdjustUp(node,nodeIndexMap.get(node));
        }
        if(!isEntered(node)){
            nodes[size] = node;
            nodeIndexMap.put(node,size);
            distanceMap.put(node,distance);
            size++;
        }
        //没进过堆且不在堆上则说明该结点已经处理过，无需再次处理
    }
    public NodeRecord pop(){
        NodeRecord nodeRecord = new NodeRecord(nodes[0],distanceMap.get(nodes[0]));
        swap(0,size-1);
        nodeIndexMap.put(nodes[size-1],-1);
        distanceMap.remove(nodes[size-1]);
        nodes[size-1] = null;
        AdjustDown(0,--size);
        return nodeRecord;
    }
    public static class NodeRecord{
        Node node;
        int distance;
        NodeRecord(Node node,int distance){
            this.distance = distance;
            this.node = node;
        }
    }
    public MyHeap(int size) {
        this.nodes = new Node[size];
        this.nodeIndexMap = new HashMap<>();
        this.distanceMap = new HashMap<>();
        this.size = 0;
    }
    public void AdjustUp(Node node, int index){
        int child = index;
        int parent = (child-1)/2;
        while(child > 0){
            if(distanceMap.get(nodes[child]) < distanceMap.get(nodes[parent])){
                swap(child,parent);
                child = parent;
                parent = (child-1)/2;
            } else{
                break;
            }
        }
    }
    public void AdjustDown(int index, int size){
        int parent = index;
        int child = parent*2+1;
        while(child < size){
            if(child+1<size && distanceMap.get(nodes[child+1]) < distanceMap.get(nodes[child])){
                child++;
            }
            if(distanceMap.get(nodes[child])<distanceMap.get(nodes[parent])){
                swap(child,parent);
                parent = child;
                child = parent*2+1;
            } else{
                break;
            }
        }
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public boolean inHeap(Node node){
        return isEntered(node) && nodeIndexMap.get(node) != -1;
    }
    public boolean isEntered(Node node){
        return nodeIndexMap.containsKey(node);
    }
    public void swap(int index1,int index2){
        nodeIndexMap.put(nodes[index1],index2);
        nodeIndexMap.put(nodes[index2],index1);
        Node tmp = nodes[index1];
        nodes[index1] = nodes[index2];
        nodes[index2] = tmp;
    }
}


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
