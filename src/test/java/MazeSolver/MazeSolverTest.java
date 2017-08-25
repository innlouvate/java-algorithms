package MazeSolver;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class MazeSolverTest {

    private int[][] map = {
            {1, 2, 1, 1, 1},
            {1, 0, 0, 0, 1},
            {1, 1, 1, 0, 1},
            {1, 1, 0, 0, 1},
            {1, 1, 3, 1, 1}};

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

    @Test
    public void failsWhenPassedNonConnectingStartPosition() {
        MazeSolver mazeSolver = new MazeSolver(map, 0, 0);
        mazeSolver.findWayOut();
        assertEquals("No solution found, stuck here forever!", outContent.toString());
    }

    @Test
    public void passesWhenPassedConnectingStartPosition() {
        MazeSolver mazeSolver = new MazeSolver(map, 1, 0);
        mazeSolver.findWayOut();
        assertThat(outContent.toString(), containsString("Solution found, you're free!"));
    }
}