package com.grafos;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**Unit test for simple App.
 */
public class IsCompleteTest {
    /**Rigorous Test :-)
     */
    @Test
    public void test1() {
        
        int[][] matrix = new int[][] {
            {0,1,1,1},
            {1,0,1,1},
            {1,1,0,1},
            {1,1,1,0}
        };

        GraphMatrix gm = new GraphMatrix(4, matrix);
        assertTrue( gm.isComplete() );

    }
    
    @Test
    public void test2() {
        
        int[][] matrix = new int[][] {
            {0,1,0,1},
            {1,0,1,1},
            {1,1,0,1},
            {1,1,1,0}
        };

        GraphMatrix gm = new GraphMatrix(4, matrix);
        assertFalse( gm.isComplete() );

    }
}
