package contactos;
import java.awt.Graphics;
import javax.swing.ImageIcon;

public class mipanel extends javax.swing.JPanel {
    private int b=0;
    
    public mipanel(int w, int h){    
        this.setSize(w,h);
    }
    
   public mipanel(int w, int h, int b) {
        this.b=b;
        this.setSize(w,h);
   }
   
    @Override
    //public void paintComponent(Graphics g){
    public void paint(Graphics g){
        //Dimension tamanio = getSize();
        
        if (this.b == 0){
            ImageIcon imagenFondo = new ImageIcon(getClass().getResource("/imagenes/vista.jpg"));                     
            g.drawImage(imagenFondo.getImage(),0,0,getWidth(),getHeight(), null);                
        }
        else
        {
            ImageIcon imagenFondo = new ImageIcon(getClass().getResource("/imagenes/banner.jpg"));                                 
            g.drawImage(imagenFondo.getImage(),0,0,getWidth(),getHeight(), null);                
        }           
        setOpaque(false);
        super.paintComponent(g);
    }    
}
