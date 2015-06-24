/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package alignment;

/**
 *
 * @author Drew
 */
public class Point {
    
    public double x, y;
    
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public double getX() {
        return x;
    }
    
    public double getY() {
        return y;
    }
    
    public double distance(Point p) {
        return Math.sqrt((x - p.x)*(x - p.x) + (y - p.y)*(y - p.y));
    }
    
    @Override
    public String toString() {
        return "(" + x + ", " + y +")";
    }
    
    public void setLocation(double x, double y) {
        this.x =x ;
        this.y = y;
    }
    
    public java.awt.Point toAWTPoint() {
        return new java.awt.Point((int)x, (int)y);
    }
    
}
