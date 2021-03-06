/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

import mybutton.MyButton;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author hugo
 */
public class Lab2C_ram {
    
    private static JFrame frame;
    private static Color[] colors = {Color.RED,Color.BLUE, Color.GRAY,Color.GREEN,Color.PINK,Color.ORANGE,Color.YELLOW};
    private static String[] texts = {"Stockholm", "Göteborg","Malmö","Lund","Linköping","Umeå","Gävle","Uppsala","Södertälje"};

    
    public static void main(String[] args){
        
        int numButtons;
        frame = new JFrame();
        FlowLayout layout = new FlowLayout();
        frame.setLayout(layout);
        if(args.length>1){ // Checks if multiple arguments have been sent
            throw new IllegalArgumentException("Multiple arguments!");
        }
        
        try{ // tries to convert the string to an integer
            numButtons = Integer.parseInt(args[0]);
        }catch(NumberFormatException e){
            /* should an exception occur this is 
            thrown
            */
            throw new IllegalArgumentException("Argument not an integer!");    
        }
        
        createButtons(numButtons);
       
        frame.pack();
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    private static void createButtons(int numIn){
        MyButton[] b = new MyButton[numIn];
        for (int i = 0; i < numIn; i++){
            b[i] = new MyButton(colors[(int)(Math.random()*(colors.length-1))],
                                      colors[(int)(Math.random()*(colors.length-1))],
                                      texts[(int)(Math.random()*(texts.length-1))],
                                      texts[(int)(Math.random()*(texts.length-1))]);
            frame.add(b[i]);
            
        }
        
    }
    
  
}
