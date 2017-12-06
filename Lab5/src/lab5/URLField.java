/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.IOException;
import  java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author hugo
 */
public class URLField extends TextField implements ActionListener {
    
    private URL url;
    private ViewPane viewer;
    
    public URLField(ViewPane v){
        viewer = v;
        addActionListener(this);
        this.setPreferredSize(new Dimension(800,25));
    }
    
    public URL getURL(){
        return url;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
        try{
            url = new URL(getText());
        
        }   catch (MalformedURLException ex) {
            Logger.getLogger(URLField.class.getName()).log(Level.SEVERE, null, ex); // Autogenererad kod av netbeans, vettefan vad den gör
            
        }
        
        try {
            viewer.setPage(url);
        } catch (IOException ex) {
            System.err.println("Attempted to read a bad URL: " + url);
        }
    }
}
