package com.grafos;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ToStringTest {
    
    @Test
    public void test1() {
        
        int[][] matrix = new int[][] {
            {0,1,1,1},
            {1,0,1,1},
            {1,1,0,1},
            {1,1,1,0}
        };
        
        String expected = 
                "0 1 1 1 \n" + //
                "1 0 1 1 \n" + //
                "1 1 0 1 \n" + //
                "1 1 1 0 \n" ;

        GraphMatrix gm = new GraphMatrix(4, matrix);
        System.out.println( gm.toString() );
        assertEquals( gm.toString(), expected );

    }
    
    

}
