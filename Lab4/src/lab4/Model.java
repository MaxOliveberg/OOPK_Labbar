/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

/**
 *
 * @author hugo
 */
public class Model {
    

    private static double L = 1;
    private Particle[] particleArray;
    
    public Model(int particleNum) {
        particleArray = new Particle[particleNum];
        for (int i = 0; i < particleNum; i++){
            particleArray[i] = new Particle();
        }
    }

    public void updateTotalPosition() {
        for (int i = 0; i < particleArray.length; i++){
            particleArray[i].updatePosition(); 
        }
    }

    public double[] getTotalPosition() {
        double[] positionArray = new double[particleArray.length * 2];
        int index = 0;
        
        for (int i = 0; i < particleArray.length; i = i+2){
            
            positionArray[i] = particleArray[index].getX();
            positionArray[i+1] = particleArray[index].getY();
            index++;
        }
        return positionArray;
        
    }

    public void setLength(double l) {
        L = l;
    }

    public double getLength() {
        return L;
    }

    private class Particle {

        private double x;
        private double y;
    
        
        
        public Particle(double xIn, double yIn) {
            x = xIn;
            y = yIn;
         
        }

        public Particle() {
            this(Math.random(), Math.random());
        }

        public void updatePosition() {
            double theta = Math.random()*2*3.1415;
            x = x + L*Math.cos(theta);
            y = y + L*Math.sin(theta);
        }   
        public double getX(){
            return x;
        }
        public double getY(){
            return y;
        }
    }
}
    