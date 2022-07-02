package javase.datastruct.graph.shangguigu;

public class Text {
    public static void main(String[] args) {
        int n = 5;
        String vertexValue[] = {"A","B","C","C","D"};
        Graph graph = new Graph(n);
        for(String vertex : vertexValue){
            graph.addNode(vertex);
        }
        graph.insertEdge(0,1,1);
        graph.insertEdge(0,2,1);
        graph.insertEdge(1,2,1);
        graph.insertEdge(1,3,1);
        graph.insertEdge(1,4,1);
        graph.showGraph();
    }
}
