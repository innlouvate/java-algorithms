package DijsktraAlgorithm;

import java.util.*;

public class DijsktraAlgorithm {

    public void computePaths(Vertex startVertex) {
        startVertex.setdistance(0);
        PriorityQueue<Vertex> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(startVertex);

        while (!priorityQueue.isEmpty()) {

            Vertex actualVertex = priorityQueue.poll();

            for (Edge e : actualVertex.getAdjacenciesList()) {
                Vertex v = e.getTargetVertex();
                double newDistance = actualVertex.getdistance() + e.getWeight();

                if (v.getdistance() > newDistance) {
                    priorityQueue.remove(v);
                    v.setdistance(newDistance);
                    v.setPredecessor(actualVertex);
                    priorityQueue.add(v);
                }
            }
        }
    }

    public List<Vertex> getShortestPathToTarget(Vertex targetVertex) {
        List<Vertex> shortestPath = new ArrayList<>();

        for (Vertex v = targetVertex; v != null; v = v.getPredecessor()) {
            shortestPath.add(v);
        }
        Collections.reverse(shortestPath);

        return shortestPath;
    }
}
