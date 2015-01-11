package dragonCurveDemo;
import java.awt.Graphics2D;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Image;
import java.awt.Graphics;
import java.awt.RenderingHints;

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
    private Color colorBrocha=Color.red;
	private Graphics2D gr;

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
        imagen = createImage(width, height);
        gr = (Graphics2D)imagen.getGraphics();
    	gr.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
    	        RenderingHints.VALUE_ANTIALIAS_ON);
        
    }
    
    public void redraw()
    {
        panel.repaint();
    }
    
    public void drawLine(double x1, double y1, double x2, double y2){
        gr.drawLine((int)x1, (int)y1, (int)x2, (int)y2);
        redraw();
    }
    
    public void changeBrushColor(double r, double g, double b){
        colorBrocha=new Color((float)r, (float)g, (float)b);
        gr.setColor(colorBrocha);
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