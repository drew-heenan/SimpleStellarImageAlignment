package gui.displaymodes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import gui.Display;
import java.awt.event.MouseEvent;

/**
 *
 * @author Drew
 */
public interface DisplayMode {
    
    void filter(Display dis);
    
    void mouseMoved(MouseEvent me);
    
}
