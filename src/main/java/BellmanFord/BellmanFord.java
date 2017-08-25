package BellmanFord;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BellmanFord {

    private List<Edge> edgeList;
    private List<Vertex> vertexList;


    public BellmanFord(List<Edge> edgeList, List<Vertex> vertexList) {
        this. edgeList = edgeList;
        this.vertexList = vertexList;
    }

    public void computePaths(Vertex sourceVertex) {
        sourceVertex.setDistance(0);

        for (int i = 0; i < vertexList.size() -1; i++) {

            for (Edge e : edgeList) {
                Vertex u = e.getStartVertex();
                Vertex v = e.getTargetVertex();

                if (u.getDistance() == Double.MAX_VALUE) continue;

                double newDistance = u.getDistance() + e.getWeight();

                if (newDistance < v.getDistance()) {
                    v.setDistance(newDistance);
                    v.setPredecessor(u);
                }
            }
        }

        for (Edge e : edgeList) {
            if (e.getStartVertex().getDistance() != Double.MAX_VALUE) {
                if (hasCycle(e)) {
                    System.out.println("A negative cycle has been detected...");
                    return;
                }
            }
        }
    }

    private boolean hasCycle(Edge e) {
        return e.getStartVertex().getDistance() + e.getWeight() < e.getTargetVertex().getDistance();
    }

    public List<Vertex> getShortestPath(Vertex targetVertex) {
        List<Vertex> shortestPath = new ArrayList<>();

        if (targetVertex.getDistance() == Double.MAX_VALUE) {
            System.out.print("There is no path from the source to the target!");
        }

        for (Vertex v = targetVertex; v !=  null; v = v.getPredecessor()) {
            shortestPath.add(v);
        }

        Collections.reverse(shortestPath);
        return shortestPath;
    }


}
