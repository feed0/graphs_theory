package com.grafos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
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
        gm = new GraphMatrix(4, matrix);
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

        GraphMatrix gm = new GraphMatrix(4, matrix);
        assertEquals(gm.toString(), expected);

    }

    @Test
    public void isIsomorphicTo() {

        int[][] matrix1, matrix2;
        GraphMatrix gm1, gm2;

        matrix1 = new int[][] {
                { 0, 1, 1, 1 },
                { 1, 0, 1, 1 },
                { 1, 1, 0, 1 },
                { 1, 1, 1, 0 }
        };
        matrix2 = new int[][] {
                { 0, 1, 1, 1 },
                { 1, 0, 1, 1 },
                { 1, 1, 0, 1 },
                { 1, 1, 1, 0 }
        };
        gm1 = new GraphMatrix(4, matrix1);
        gm2 = new GraphMatrix(4, matrix2);
        assertTrue(gm1.isIsomorphicTo(gm2));

        matrix1 = new int[][] {
                { 0, 1, 1, 1 },
                { 1, 0, 0, 1 },
                { 1, 0, 0, 1 },
                { 1, 1, 1, 0 }
        };
        matrix2 = new int[][] {
                { 0, 1, 1, 1 },
                { 1, 0, 1, 1 },
                { 1, 1, 0, 1 },
                { 1, 1, 1, 0 }
        };
        gm1.setMatrix(matrix1);
        assertFalse(gm1.isIsomorphicTo(gm2));

    }
}
