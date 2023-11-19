package com.grafos;

import static org.junit.Assert.assertArrayEquals;
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
        public void depthSearch() {
                GraphMatrix gm;
                int[][] matrix;

                // 8 vertices
                /*      0: 2,3
                        1: 3, 5, 6
                        2: 0, 4, 5
                        3: 0, 1, 5, 7
                        4: 2
                        5: 1, 2, 3
                        6: 1, 7
                        7: 3, 6
                */
                matrix = new int[][] {
                        { 0, 0, 1, 1, 0, 0, 0, 0 },
                        { 0, 0, 0, 1, 0, 1, 1, 0 },
                        { 1, 0, 0, 0, 1, 1, 0, 0 },
                        { 1, 1, 0, 0, 0, 1, 0, 1 },
                        { 0, 0, 1, 0, 0, 0, 0, 0 },
                        { 0, 1, 1, 1, 0, 0, 0, 0 },
                        { 0, 1, 0, 0, 0, 0, 0, 1 },
                        { 0, 0, 0, 1, 0, 0, 1, 0 }
                };
                gm = new GraphMatrix(matrix);
                
                int expected = 1;
                int actual = gm.depthSearch(2);
                
                assertEquals(expected, actual);

                // a two component 3x3 atrix 
                matrix = new int[][] {
                        { 0, 1, 0 },
                        { 1, 0, 0 },
                        { 0, 0, 0 }
                };
                gm.setMatrix(matrix);

                expected = 2;
                actual = gm.depthSearch(0);

                assertEquals(expected, actual);

                // three components 3x3 matrix
                matrix = new int[][] {
                        { 0, 0, 0 },
                        { 0, 0, 0 },
                        { 0, 0, 0 }
                };
                gm.setMatrix(matrix);

                expected = 3;
                actual = gm.depthSearch(0);

                assertEquals(expected, actual);

                // 4-vertex digraph with 2 components (d is isolated)
                matrix = new int[][] {
                        { 0, 1, 1, 0 },
                        { 0, 0, 0, 0 },
                        { 0, 0, 0, 0 },
                        { 0, 0, 0, 0 }
                };
                gm.setMatrix(matrix);

                expected = 2;
                actual = gm.depthSearch(0);

                assertEquals(expected, actual);

                // 4-vertex digraph with 2 components (ab and cd)
                matrix = new int[][] {
                        { 0, 1, 0, 0 },
                        { 10, 0, 0, 0 },
                        { 0, 0, 0, 20 },
                        { 0, 0, 2, 0 }
                };
                gm.setMatrix(matrix);

                expected = 2;
                actual = gm.depthSearch(0);
        }

        @Test
        public void prim() {

                GraphMatrix gm;
                int[][] matrix;
                int[] expected;

                // 6 vertices graph with the following edges:
                // ab4 ac2 ae3
                // bd5 cd1 ce6
                // df6 ef2
                matrix = new int[][] {
                                { 0, 4, 2, 0, 3, 0 },
                                { 4, 0, 0, 5, 0, 0 },
                                { 2, 0, 0, 1, 6, 3 },
                                { 0, 5, 1, 0, 0, 6 },
                                { 3, 0, 6, 0, 0, 2 },
                                { 0, 0, 3, 6, 2, 0 }
                };
                gm = new GraphMatrix(matrix);

                int[] actual = gm.prim(0);

                // Previous = {0, a, a, c, a, e}
                expected = new int[] { 0, 0, 0, 2, 0, 4 };

                // assert expected == gm.prim
                assertArrayEquals(expected, actual);
        }
}
