package javase.datastruct.graph;

import java.util.HashMap;
import java.util.HashSet;
//偏邻接表的形式表示
public class Graph {
    //点集：结点及其对应的数据项
    public HashMap<Integer, Node>nodes;
    //边集：每条边
    public HashSet<Edge>edges;

    Graph(){
        nodes = new HashMap<>();
        edges = new HashSet<Edge>();
    }
}
