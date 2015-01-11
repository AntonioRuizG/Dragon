package dragonCurveDemo;
import java.util.HashMap;

public class Main
{
    private static HashMap<String, String> rules = new HashMap<String, String>();
    private static HashMap<String, String> rules2 = new HashMap<String, String>();
    private static Window window;
    
    public static void main(String[] args)
    {
        rules.put("R", "RrL");
        rules.put("L", "RlL");
        rules.put("r", "r");
        rules.put("l", "l");
        
        rules2.put("r", "R");
        rules2.put("l", "L");
        rules2.put("R", "R");
        rules2.put("L", "L");
        window = new Window(640,480);
        String dragon = proce("R",14);
        drawDragon(dragon,230,350,2);
    }
    
    private static String proce(String input, int level){
        StringBuilder output=new StringBuilder();
        if(level<=0){
            return reproce(input);
        }
        char[] intputChar = input.toCharArray();
        for(int i=0;i<intputChar.length;i++){
            output.append(rules.get(intputChar[i]+""));
        }
        
        return proce(output.toString(), level-1);
    }
    
    private static String reproce(String input){
        StringBuilder output=new StringBuilder();
        char[] intputChar = input.toCharArray();
        for(int i=0;i<intputChar.length;i++){
            output.append(rules2.get(intputChar[i]+""));
        }
        return output.toString();
    }
	
    public static void drawDragon(String input, double x, double y, double size){
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
            if(i>(intputChar.length/2))window.changeBrushColor(1,0,0);
            else if(i>(intputChar.length/4))window.changeBrushColor(0,0,0);
            else if(i>(intputChar.length/8))window.changeBrushColor(1,0,0);
            else if(i>(intputChar.length/16))window.changeBrushColor(0,0,0);
            else if(i>(intputChar.length/32))window.changeBrushColor(1,0,0);
            else if(i>(intputChar.length/64))window.changeBrushColor(0,0,0);
            else if(i>(intputChar.length/128))window.changeBrushColor(1,0,0);
            
            window.drawLine(p1[0], p1[1], p2[0], p2[1]);
            
            try{
                Thread.sleep(1);
            }catch(Exception e){
                
            }
        }
    }
}
