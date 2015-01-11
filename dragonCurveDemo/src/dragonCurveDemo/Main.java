package dragonCurveDemo;
import java.util.HashMap;

public class Main
{
    private static HashMap<String, String> rules = new HashMap<String, String>();
    private static HashMap<String, String> rules2 = new HashMap<String, String>();
    
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
        Window w = new Window(1200,1000);
        String dragon = proce("L",14);
        w.drawDragon(dragon,800,750,3);
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
    
}
