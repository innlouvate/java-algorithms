package DepthFirstSearch;

import java.util.List;
import java.util.Stack;

public class DFS {

    private Stack<Vertex> stack;

    public DFS() {
        this.stack = new Stack<>();
    }

    public void dfs(List<Vertex> vertexList) {
        for (Vertex v : vertexList) {
            if (!v.isVisited()) {
                v.setVisited(true);
                dfsWithStack(v);
            }
        }
    }

    private void dfsWithStack(Vertex rootVertex) {
        this.stack.add(rootVertex);
        rootVertex.setVisited(true);

        while (!stack.isEmpty()) {
            Vertex vertex = this.stack.pop();
            System.out.println(vertex.getName()+" ");

            for (Vertex v : vertex.getNeighbourList()) {
                if (!v.isVisited()) {
                    v.setVisited(true);
                    this.stack.push(v);
                }
            }
        }

    }

    public void dfsRecursive(List<Vertex> vertexList) {
        for (Vertex v : vertexList) {
            if (!v.isVisited()) {
                v.setVisited(true);
                dfsRecursion(v);
            }
        }
    }

    private void dfsRecursion(Vertex vertex) {
        System.out.print(vertex.getName()+"  ");
        for (Vertex v : vertex.getNeighbourList()) {
            v.setVisited(true);
            dfsRecursion(v);
        }
    }

}
