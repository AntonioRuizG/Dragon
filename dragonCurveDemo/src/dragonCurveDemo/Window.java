package dragonCurveDemo;
import java.awt.Graphics2D;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.Dimension;

/**
 * A window to draw simple graphics.
 * 
 * @author Antonio Ruiz
 *
 */
public class Window extends JFrame
{
	private static final long serialVersionUID = 6484935181546031766L;
	private final Image imagen;
    private Panel panel;
    private Color colorDeFondo;
    private Color colorBrocha=Color.red;

    /**
     * 
     * @param width
     * @param height
     */
    public Window(int width, int height)
    {
        super();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(width, height);
        panel=new Panel();
        setContentPane(panel);
        this.colorDeFondo=Color.white;
        imagen = createImage(width, height);
        
    }
    
    public void redraw()
    {
        panel.repaint();
    }
    
    public void drawLine(double x1, double y1, double x2, double y2){
        Graphics2D g = (Graphics2D)imagen.getGraphics();
        g.setColor(colorBrocha);
        g.drawLine((int)x1, (int)y1, (int)x2, (int)y2);
        redraw();
    }
    
    public void dibujar(Shape e)
    {
        Graphics2D g = (Graphics2D)imagen.getGraphics();
        g.setColor(Color.red);
        g.fill(e);
    } 
    
    public Graphics2D getGraphics2D()
    {
        return (Graphics2D)imagen.getGraphics();
    }
    
    public void borrar()
    {
        Graphics2D g = (Graphics2D)imagen.getGraphics();
        g.setColor(colorDeFondo);
        Dimension d = panel.getSize();
        g.fillRect(0,0,d.width,d.height);
    }
    
    public void drawDragon(String input, double x, double y, double size){
        char[] intputChar = input.toCharArray();
        double[] p1 = new double[]{x,y};
        double[] p2 = new double[]{x+size,y};
        int direccion=0;
        for(int i=0;i<intputChar.length;i++){
            
            if(intputChar[i]=='R'){
                direccion =(direccion+1)%4;
                
            }else{
                direccion =(direccion+3)%4;
            }
            switch(direccion){
                case 0:
                    p1[0]=p2[0];
                    p1[1]=p2[1];
                    
                    p2[0]=p1[0]+size;
                    p2[1]=p1[1];
                break;
                case 1:
                    p1[0]=p2[0];
                    p1[1]=p2[1];
                    
                    p2[0]=p1[0];
                    p2[1]=p1[1]+size;
                break;
                case 2:
                    p1[0]=p2[0];
                    p1[1]=p2[1];
                    
                    p2[0]=p1[0]-size;
                    p2[1]=p1[1];
                break;
                case 3:
                    p1[0]=p2[0];
                    p1[1]=p2[1];
                    
                    p2[0]=p1[0];
                    p2[1]=p1[1]-size;
                break;
            }
            if(i>(intputChar.length/2))changeBrushColor(0,0,0);
            
            drawLine(p1[0], p1[1], p2[0], p2[1]);
            
            try{
                Thread.sleep(1);
            }catch(Exception e){
                
            }
        }
    }
    
    public void changeBrushColor(double r, double g, double b){
        colorBrocha=new Color((float)r, (float)g, (float)b);
    }
    
    private class Panel extends JPanel
    {
		private static final long serialVersionUID = 7209536829904740803L;

		public void paint(Graphics g)
        {
            g.drawImage(imagen, 0, 0, null);
        }
    }
}