package BellmanFord;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

    private String name;
    private List<Edge> adjacenciesList;
    private double distance = Double.MAX_VALUE;
    private Vertex predecessor;
    private boolean visited;

    public Vertex(String name) {
        this.name = name;
        this.adjacenciesList = new ArrayList<>();
    }

    public List<Edge> getAdjacenciesList() {
        return adjacenciesList;
    }

    public void setAdjacenciesList(List<Edge> adjacenciesList) {
        this.adjacenciesList = adjacenciesList;
    }

    public void addAdgacency(Edge edge) {
        this.adjacenciesList.add(edge);
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public Vertex getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(Vertex predecessor) {
        this.predecessor = predecessor;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
