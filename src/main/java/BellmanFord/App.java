package BellmanFord;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {

        Vertex vertex0 = new Vertex("A");
        Vertex vertex1 = new Vertex("B");
        Vertex vertex2 = new Vertex("C");

        List<Vertex> vertexList = new ArrayList<>();
        vertexList.add(vertex0);
        vertexList.add(vertex0);
        vertexList.add(vertex0);

        Edge edge0 = new Edge(1, vertex0, vertex1);
        Edge edge1 = new Edge(2, vertex0, vertex2);
        Edge edge2 = new Edge(1, vertex1, vertex2);

        List<Edge> edgeList = new ArrayList<>();
        edgeList.add(edge0);
        edgeList.add(edge1);
        edgeList.add(edge2);

        vertex0.addAdgacency(edge0);
        vertex0.addAdgacency(edge1);
        vertex1.addAdgacency(edge2);

        BellmanFord algorithm = new BellmanFord(edgeList, vertexList);
        algorithm.computePaths(vertex0);

        System.out.print(algorithm.getShortestPath(vertex2));

    }
}
