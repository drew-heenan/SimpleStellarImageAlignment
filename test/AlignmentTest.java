/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import alignment.Alignment;
import alignment.Point;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertEquals;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Drew
 */
public class AlignmentTest {
    
    public AlignmentTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Test
    public void testFindPolarStar() {
        Point center = new Point(2435, 2529);
        Point b = new Point(2435, 2800);
        double angle = .0001;
        Point a = Alignment.rotate(b, center, Math.toRadians(angle)), c = Alignment.rotate(b, center, -Math.toRadians(angle));System.out.println(a + ", " + b + ", " + c);
        Point out = Alignment.findPolarStar(a,b,c);
        System.out.println(out);
        assertEquals(center.x, out.x, 1.5);
        assertEquals(center.y, out.y, 1.5);
    }
    
    @Test
    public void testRotate() {
        Point c = new Point(10,0);
        Point p = new Point(20, 0);
        Point out = Alignment.rotate(p, c, Math.PI/2);
        assertEquals(10, out.x, 0.05);
        assertEquals(10, out.y, 0.05);
    }
}
