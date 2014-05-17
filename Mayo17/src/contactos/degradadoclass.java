package contactos;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class degradadoclass extends javax.swing.JPanel{
    private Color color1 = new Color(66,111,166);
    private Color color2 = new Color(103,174,118);
    
    public degradadoclass(){
    }
    
     @Override
    public void paint(Graphics g) {    
        Graphics2D g2 = (Graphics2D) g.create();
               
        Rectangle clip = g2.getClipBounds();   
        g2.setPaint(new GradientPaint(0.0f, 0.0f, color1.darker(), this.getWidth() ,0, color2.darker()));         
        g2.fillRect(clip.x, clip.y, clip.width, clip.height);         
        
        
    }
     
}
