/*Post Fix expression problem using stack*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class PostFixExpression {

    public static void main(String[] args) throws java.lang.Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter No of expresions ::");
        int target = Integer.parseInt(br.readLine().trim());

        while(target --> 0) {
            System.out.println("Enter expresion ::");
            String expression = br.readLine();
            int n = expression.length();

            evaluate_postfix(expression, n);
        }
    }

    static void evaluate_postfix(String arr, int n) {

        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i<n; i++) {
            char c = arr.charAt(i);
            if(Character.isDigit(c)) {
                stack.push(Character.getNumericValue(c));
            } else {

                int x = stack.pop();
                int y = stack.pop();

                switch(c) {

                    case '+':
                        stack.push( y + x );
                        break;

                    case '-':
                        stack.push( y - x);
                        break;

                    case '*':
                        stack.push( y * x);
                        break;

                    case '/':
                        stack.push( y/x);
                        break;
                }

            }
        }
        System.out.println("Answer :: "+ stack.pop());
    }
}
