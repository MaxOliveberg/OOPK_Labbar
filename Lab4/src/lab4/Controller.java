/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;

/**
 *
 * @author hugo
 */
public class Controller extends JPanel implements ChangeListener, ActionListener{
    
    private View myView;
    private Model myModel;
    private Timer myTimer;
    private JSlider lengthSlider;
    private JSlider deltaSlider;
    private static final int L_MIN = 0;
    private static final int L_MAX = 50;
    private static final int L_INIT = 25;
    private static final int DELTA_MIN = 0;
    private static final int DELTA_MAX = 10;
    private static final int DELTA_INIT = 5;
    
 
    public Controller(Model modelArg, View viewArg){
        
        myModel = modelArg;
        myView = viewArg;
        
        myTimer = new Timer(DELTA_INIT*1000, this);
	myTimer.start();
	
        lengthSlider =  new JSlider(JSlider.VERTICAL, L_MIN, L_MAX, L_INIT);
        lengthSlider.addChangeListener(this);
        add(lengthSlider);
        
        deltaSlider = new JSlider(JSlider.VERTICAL, DELTA_MIN, DELTA_MAX, DELTA_INIT);
        deltaSlider.addChangeListener(this);
        add(deltaSlider);
        
        
    }

    @Override
    public void stateChanged(ChangeEvent e) {

        JSlider source = (JSlider) e.getSource();
        
        if (!source.getValueIsAdjusting()) {
            if (source == lengthSlider) {
                double l = (double) source.getValue();
                
                myModel.setLength(l);
            }
            if (source == deltaSlider) {
                myTimer.setDelay(source.getValue());
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        myModel.updateTotalPosition();
        myView.repaint();
    }
}