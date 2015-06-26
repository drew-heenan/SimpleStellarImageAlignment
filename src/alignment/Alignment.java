/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package alignment;

import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
 *
 * @author Drew
 */
public class Alignment {
    
    private static final double PI = Math.PI;
    
    public static Point findPolarStar(Point a, Point b, Point c) {
        
        //Make sure 'b' is the point on the arc between 'a' and 'c'
        if(a.distance(c) < a.distance(b)) {
            Point bT = b;
            b = c;
            c = bT;
        }
        
        Point acMidpoint = new Point((a.x + c.x)/2, (a.y + c.y)/2);
        
        //Ascension angle of the angles formed by acMidpoint, 'a' and 'c', and 'b'.
        double bToacMidpointDistance = b.distance(acMidpoint);
        
        double abDistance = a.distance(b);
        double angleA = Math.asin(bToacMidpointDistance/abDistance);
        
        double bcDistance = b.distance(c);
        double angleC = Math.asin(bToacMidpointDistance/bcDistance);
        
        double angleBA = PI - (Math.abs(angleA) + PI/2.0);
        
        double vertAngle = PI - 2*angleBA; //It's an isosceles triangle.
        System.out.println(Math.toDegrees(vertAngle));
        double radiusFromPolarStar = (abDistance*Math.sin(angleBA))/Math.sin(vertAngle); //law of sines
        
        Point vecToPolarStar = new Point(acMidpoint.getX() - b.x, acMidpoint.getY() - b.y);
        double mag = Math.sqrt(vecToPolarStar.getX()*vecToPolarStar.getX() + vecToPolarStar.getY()*vecToPolarStar.getY());
        vecToPolarStar.setLocation(radiusFromPolarStar * vecToPolarStar.getX()/mag, radiusFromPolarStar * vecToPolarStar.getY()/mag); //Normalize, then extend
        
        return new Point((int)(b.x + vecToPolarStar.getX() + 0.5), (int)(b.y + vecToPolarStar.getY() + 0.5));
    }
    
    public static Point rotate(Point p, Point c, double theta) {
        double[] pt = new double[]{p.x, p.y};
        AffineTransform.getRotateInstance(theta, c.x, c.y).transform(pt, 0, pt, 0, 1);
        return new Point(pt[0], pt[1]);
    }
    
    
}
