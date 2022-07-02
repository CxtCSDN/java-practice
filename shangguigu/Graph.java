package javase.datastruct.graph.shangguigu;

import java.util.ArrayList;
import java.util.Arrays;

//邻接矩阵的方式表示图
public class Graph {
    private ArrayList<String> vertexList;
    private int[][]edges;
    private int numOfEdges;

    public Graph() {
        this.vertexList = new ArrayList<>();
        this.numOfEdges = 0;
    }

    public Graph(int n){
        edges = new int[n][n];
        vertexList = new ArrayList<>(n);
        numOfEdges = 0;
    }

    public void setEdges(int[][] edges) {
        this.edges = edges;
    }

    public void setVertexList(ArrayList<String> vertexList) {
        this.vertexList = vertexList;
    }

    public void setNumOfEdges(int numOfEdges) {
        this.numOfEdges = numOfEdges;
    }

    public String getVertixList(int i) {
        return vertexList.get(i);
    }

    public int getEdges(int v1,int v2) {
        return edges[v1][v2];
    }

    public int getNumOfEdges() {
        return numOfEdges;
    }

    public void showGraph(){
        for(int[] edge : edges){
            System.out.println(Arrays.toString(edge));
        }
    }

    public void addNode(String node){
        vertexList.add(node);
    }

    public void insertEdge(int v1,int v2,int weight){
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }
}
