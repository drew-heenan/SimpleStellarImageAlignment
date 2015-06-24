/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package filters;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 *
 * @author Drew
 */
public class LuminanceFilter extends Filter {
    
    public static final double R_PERCEPTION = 0.299, G_PERCEPTION = 0.587, B_PERCEPTION = 0.114;

    @Override
    public BufferedImage filter(BufferedImage img) {
        BufferedImage out = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());
        for(int x = 0; x < img.getWidth(); x++)
            for(int y = 0; y < img.getHeight(); y++)
                out.setRGB(x, y, (int) Math.pow(calculateLuminance(new Color(img.getRGB(x, y))), 3));
        return out;
    }
    
    protected double calculateLuminance(Color c) {
        int r = c.getRed(), g = c.getGreen(), b = c.getBlue();
        return Math.sqrt(R_PERCEPTION*r*r + G_PERCEPTION*g*g + B_PERCEPTION*b*b);
    }
    
}
