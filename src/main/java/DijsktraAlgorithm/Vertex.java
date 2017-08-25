package DijsktraAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class Vertex implements Comparable<Vertex> {

    private String name;
    private boolean visited;
    private List<Edge> adjacenciesList;
    private Vertex predecessor;
    private double distance = Double.MAX_VALUE;

    public Vertex(String name) {
        this.name = name;
        adjacenciesList = new ArrayList<>();
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public List<Edge> getAdjacenciesList() {
        return adjacenciesList;
    }

    public void setAdjacenciesList(List<Edge> adjacenciesList) {
        this.adjacenciesList = adjacenciesList;
    }

    public void addAdjecency(Edge edge) {
        this.adjacenciesList.add(edge);
    }

    public Vertex getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(Vertex predecessor) {
        this.predecessor = predecessor;
    }

    public double getdistance() {
        return distance;
    }

    public void setdistance(double distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public int compareTo(Vertex secondVertex) {
        return Double.compare(this.getdistance(), secondVertex.getdistance());
    }
}
