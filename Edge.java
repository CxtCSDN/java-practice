package javase.datastruct.graph;

public class Edge {
    //权值
    public int weight;
    //属于哪个结点
    public Node from;
    //指向哪个结点
    public Node to;

    public Edge(int weight, Node from, Node to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
}
