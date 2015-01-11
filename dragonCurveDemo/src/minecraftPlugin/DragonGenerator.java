package minecraftPlugin;

import java.util.ArrayList;
import java.util.HashMap;

public class DragonGenerator {
	
	private static HashMap<String, String> rules = new HashMap<String, String>();
    private static HashMap<String, String> rules2 = new HashMap<String, String>();
    
	public static ArrayList<Vec3> getDragon(){
		rules.put("R", "RrL");
	    rules.put("L", "RlL");
	    rules.put("r", "r");
	    rules.put("l", "l");
	    
	    rules2.put("r", "R");
	    rules2.put("l", "L");
	    rules2.put("R", "R");
	    rules2.put("L", "L");
        String dragon = proce("R",14);
        return drawDragon(dragon,0,0,2);
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
	
    public static ArrayList<Vec3> drawDragon(String input, int x, int y, int size){
        char[] intputChar = input.toCharArray();
        ArrayList<Vec3> result = new ArrayList<Vec3>();
        int[] p1 = new int[]{x,y};
        int[] p2 = new int[]{x+size,y};
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
			drawRectangle(p1[0], p1[1], p2[0], p2[1], result);
            
        }
		return result;
    }

	private static void drawRectangle(int x1, int y1, int x2, int y2, ArrayList<Vec3> result) {
		for(int i=x1;i<x2;i++){
			for(int j=y1;j<y2;j++){
				result.add(new Vec3(i,j,0));
			}
		}
	}
	
}
