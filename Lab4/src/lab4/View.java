/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

/**
 *
 * @author hugo
 */
public class View extends JPanel {
    
    private Model myModel;
    private static final int X_SIZE = 800;  
    private static final int Y_SIZE = 600;
    
    public View(Model modelArg){
        super();
        setPreferredSize(new Dimension(X_SIZE,Y_SIZE));
        this.setOpaque(true);
       
        setVisible(true);
        repaint();
        myModel = modelArg;
    }


    public void paintComponent(Graphics g){
        super.paintComponent(g);
        double[] positions = myModel.getTotalPosition();
        Graphics2D g2 = (Graphics2D) g;
        g2.clearRect(0,0,X_SIZE,Y_SIZE);
        
        for (int i = 0; i < positions.length; i = i+2){
            double x = positions[i]*X_SIZE/myModel.getLength();
            double y = positions[i+1]*X_SIZE/myModel.getLength();
            
            g2.fill(new Ellipse2D.Double(x, y, 4, 4));
        }
        
    }
    
}

            
    
