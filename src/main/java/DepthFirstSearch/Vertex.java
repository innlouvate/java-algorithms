package DepthFirstSearch;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

    private String name;
    private Boolean visited = false;
    private List<Vertex> neighbourList;

    public Vertex(String name) {
        this.name = name;
        this.neighbourList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean isVisited() {
        return visited;
    }

    public void setVisited(Boolean visited) {
        this.visited = visited;
    }

    public List<Vertex> getNeighbourList() {
        return neighbourList;
    }

    public void setNeighbourList(List<Vertex> neighbourList) {
        this.neighbourList = neighbourList;
    }

    public void addNeighbour(Vertex vertex) {
        this.neighbourList.add(vertex);
    }
}
