package MazeSolver;

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
            dfs(startPositionCol, startPositionRow);
            System.out.print("No solution found, stuck here forever!");
        } catch (RuntimeException e) {
            System.out.print("Solution found, you're free!");
        }
    }

    private void dfs(int colIndex, int rowIndex) {

        if ( mazeMap[rowIndex][colIndex] == 3) {
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
            visited[rowIndex][colIndex] = true;

            dfs(colIndex, rowIndex + 1); //go right
            dfs(colIndex + 1, rowIndex); //go down
            dfs(colIndex, rowIndex - 1); //go left
            dfs(colIndex - 1, rowIndex); //go up
        }
    }

}
