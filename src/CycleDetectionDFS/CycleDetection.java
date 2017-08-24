package CycleDetectionDFS;

import java.util.List;
import java.util.Stack;

public class CycleDetection {

    public void detectCycles(List<Vertex> list) {

        for (Vertex v : list) {
            if (!v.isVisited()) {
                dfs(v);
            }
        }
    }

    private void dfs(Vertex vertex) {
        vertex.setBeingVistited(true);
        for (Vertex v : vertex.getNeighbourList()) {
            if (v.isBeingVistited()) {
                System.out.print("Backward edge, so there is a cycle! ");
                return;
            }
            if (!v.isVisited()) {
                v.setBeingVistited(true);
                dfs(v);
            }
        }
        vertex.setBeingVistited(false);
        vertex.setVisited(true);
    }

}
