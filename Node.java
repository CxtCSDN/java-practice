package javase.datastruct.graph;

import java.util.ArrayList;

public class Node {
    //该结点上的值
    public int value;
    //入度（有多少条边指向自身）
    public int in;
    //出度（自身有多少条边指出去）
    public int out;
    //该结点的相邻结点（当前结点直接指向的结点）
    public ArrayList<Node>nexts;
    //该结点所拥有的边（当前结点直接指向的边）
    public ArrayList<Edge>edges;

    public Node(int value){
        this.value = value;
        in = 0;
        out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }
}
