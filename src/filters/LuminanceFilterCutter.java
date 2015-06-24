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
public class LuminanceFilterCutter extends LuminanceFilter {
    
    private float maxLuminance, minLuminance;
    
    public LuminanceFilterCutter(float maxLuminance, float minLuminance) {
        this.maxLuminance = maxLuminance;
        this.minLuminance = minLuminance;
    }

    @Override
    public BufferedImage filter(BufferedImage img) {
        BufferedImage out = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());
        for(int x = 0; x < img.getWidth(); x++)
            for(int y = 0; y < img.getHeight(); y++) {
                double lum = calculateLuminance(new Color(img.getRGB(x, y)));
                out.setRGB(x, y, (lum >= minLuminance && lum <= maxLuminance)?(int)Math.pow(lum, 3):0);
            }
        return out;
    }
    
}
