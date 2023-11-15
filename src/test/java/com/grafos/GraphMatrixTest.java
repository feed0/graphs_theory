package com.grafos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class GraphMatrixTest {

    @Test
    public void isCompleteTest() {
        
        GraphMatrix gm;
        int[][] matrix;

        matrix = new int[][] {
                { 0, 1, 1, 1 },
                { 1, 0, 1, 1 },
                { 1, 1, 0, 1 },
                { 1, 1, 1, 0 }
        };
        gm = new GraphMatrix(matrix);
        assertTrue(gm.isComplete());

        matrix = new int[][] {
                { 0, 1, 0, 1 },
                { 1, 0, 1, 1 },
                { 1, 1, 0, 1 },
                { 1, 1, 1, 0 }
        };
        gm.setMatrix(matrix);
        assertFalse(gm.isComplete());
    }

    @Test
    public void toStringTest() {

        GraphMatrix gm;
        int[][] matrix;
        String expected;

        matrix = new int[][] {
                { 0, 1, 1, 1 },
                { 1, 0, 1, 1 },
                { 1, 1, 0, 1 },
                { 1, 1, 1, 0 }
        };

        expected = "0 1 1 1 \n" +
                "1 0 1 1 \n" +
                "1 1 0 1 \n" +
                "1 1 1 0 \n";

        gm = new GraphMatrix( matrix);
        assertEquals(gm.toString(), expected);

    }

    @Test
    public void primMinimumSpanningTree() {

        int[][] matrix1, expected, actual;
        GraphMatrix gm1;

        matrix1 = new int[][] {
                {0, 4, 2, 0, 3, 0},
                {4, 0, 0, 5, 0, 0},
                {2, 0, 0, 1, 6, 3},
                {0, 5, 1, 0, 0, 6},
                {3, 0, 6, 0, 0, 2},
                {0, 0, 3, 6, 2, 0}
        };
        gm1 = new GraphMatrix(matrix1);

        actual = gm1.prim(0);
        expected = new int[][] {
              // a, b, c, d, e, f
                {0, 4, 2, 0, 3, 0}, // a
                {4, 0, 0, 0, 0, 0}, // b
                {2, 0, 0, 1, 0, 0}, // c
                {0, 0, 1, 0, 0, 0}, // d
                {3, 0, 0, 0, 0, 2}, // e
                {0, 0, 0, 0, 2, 0}  // f
        };

        assertArrayEquals(expected, actual);
        gm1.toString();
    }
}
