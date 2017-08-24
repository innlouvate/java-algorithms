package BreadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    public void bfs(Vertex root) {

        Queue<Vertex> queue = new LinkedList<>();
        root.setVisited(true);
        queue.add(root);

        while(!queue.isEmpty()) {
            Vertex vertex = queue.remove();
            System.out.println(vertex.getData()+"  ");

            for (Vertex v : vertex.getNeighbourList()) {
                if(!v.isVisited()) {
                    v.setVisited(true);
                    queue.add(v);
                }
            }
        }

    }

}
