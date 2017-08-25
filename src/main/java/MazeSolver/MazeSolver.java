package MazeSolver;

import java.util.ArrayList;
import java.util.List;

public class MazeSolver {

    private int[][] mazeMap;
    private boolean[][] visited;
    private int startPositionCol;
    private int startPositionRow;

    public MazeSolver(int[][] map, int startCol, int startRow) {
        this.mazeMap = map;
        this.startPositionCol = startCol;
        this.startPositionRow = startRow;
        this.visited = new boolean[mazeMap.length][mazeMap.length];
    }

    public void findWayOut() {
        try {
            List output = new ArrayList();
            dfs(startPositionCol, startPositionRow, output);
            System.out.print("No solution found, stuck here forever!");
        } catch (RuntimeException e) {
            System.out.println("Solution found, you're free!");
        }
    }

    private void dfs(int colIndex, int rowIndex, List output) {

        if ( mazeMap[rowIndex][colIndex] == 3) {
            output.add(colIndex + ":" + rowIndex);
            System.out.println(output);
            throw new RuntimeException();
        }

        int endOfMap = mazeMap.length -1; //assumes square map!

        if ( visited[rowIndex][colIndex] == true) {
            return; //already visited
        } else if (rowIndex < 0 || rowIndex > endOfMap || colIndex < 0 || colIndex > endOfMap) {
            return; //out of bounds
        } else if (mazeMap[rowIndex][colIndex] == 1) {
            return; //hit a wall
        } else {
            output.add(colIndex + ":" + rowIndex);
            visited[rowIndex][colIndex] = true;

            dfs(colIndex, rowIndex + 1, output); //go right
            dfs(colIndex + 1, rowIndex, output); //go down
            dfs(colIndex, rowIndex - 1, output); //go left
            dfs(colIndex - 1, rowIndex, output); //go up
        }
    }

}
