//package postfix;
// Name: Weiting Li, Lopsii Olagoke, Max Sotsky, Ayomide Adekiitan, Ayomide Adekiitan
import java.util.*;

public class PostfixNotFixed {

	public static void main(String [] args){
        
        Scanner keyboard = new Scanner(System.in);
        
        System.out.println("Enter a postfix expression to process: ");
        String mathExpression = keyboard.nextLine();
        
        Character thisToken;
        StringTokenizer tokens = new StringTokenizer(mathExpression,"0123456789+-*/",true);
        double op1, op2, tokenVal;
        
        Stack<Double> numStack = new Stack<Double>();
        while (tokens.hasMoreTokens()){
            thisToken = tokens.nextToken().charAt(0);
            System.out.println(" token: " + thisToken);

            if(Character.isDigit(thisToken)){
                int token_num = Character.getNumericValue(thisToken);
                double value = (double)token_num;
                numStack.push(value);
            }else{
                op2 = numStack.pop();
                op1 = numStack.pop();
                if(thisToken == '+'){
                    numStack.push(op1+op2);
                }else if(thisToken == '-'){
                    numStack.push(op1-op2);
                }else if(thisToken == '*'){
                    numStack.push(op1*op2);
                }else{
                    numStack.push(op1/op2);
                }
            }
            System.out.println(Arrays.toString(numStack.toArray()));
        }
        System.out.println("Result is "+numStack.pop());
    }
}
