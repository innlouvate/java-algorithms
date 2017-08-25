package MazeSolver;

public class App {

    public static void main(String[] args) {

        int[][] mazeMap = {
                {1, 2, 1, 1, 1},
                {1, 0, 0, 0, 1},
                {1, 1, 1, 0, 1},
                {1, 1, 0, 0, 1},
                {1, 1, 3, 1, 1}};

        MazeSolver mazeSolver = new MazeSolver(mazeMap, 6, 0);
        mazeSolver.findWayOut();

    }
}
