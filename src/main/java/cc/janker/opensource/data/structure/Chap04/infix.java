package cc.janker.opensource.data.structure.Chap04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by zhiyongliu3 on 2017/8/3.
 */
class StackXXX {
    private int maxSize;
    private char[] stackArray;
    private int top;

    //--------------------------------------------------------------
    public StackXXX(int max)    // constructor
    {
        maxSize = max;
        stackArray = new char[maxSize];
        top = -1;
    }

    //--------------------------------------------------------------
    public void push(char j)  // put item on top of stack
    {
        stackArray[++top] = j;
    }

    //--------------------------------------------------------------
    public char pop()         // take item from top of stack
    {
        return stackArray[top--];
    }

    //--------------------------------------------------------------
    public char peek()        // peek at top of stack
    {
        return stackArray[top];
    }

    //--------------------------------------------------------------
    public boolean isEmpty()  // true if stack is empty
    {
        return (top == -1);
    }

    public int size()         // return size
    {
        return top + 1;
    }

    public char peekN(int n)  // return item at index n
    {
        return stackArray[n];
    }

    public void displayStack(String s) {
        System.out.print(s);
        System.out.print("Stack (bottom-->top): ");
        for (int j = 0; j < size(); j++) {
            System.out.print(peekN(j));
            System.out.print(' ');
        }
        System.out.println("");
    }
//--------------------------------------------------------------
}  // end class StackX

class InToPost {
    private StackXXX theStack;
    private String input;
    private String output = "";

    public InToPost(String in) {
        input = in;
        int stackSize = input.length();
        theStack = new StackXXX(stackSize);
    }

    public String doTrans() {
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            theStack.displayStack("For " + ch + " ");
            switch (ch) {
                case '+':
                case '-':
                    gotOper(ch, 1);
                    break;
                case '*':
                case '/':
                    gotOper(ch, 2);
                    break;
                case '(':
                    theStack.push(ch);
                    break;
                case ')':
                    gotParen(ch);
                    break;
                default:
                    output = output + ch;
                    break;
            }
        }
        while (!theStack.isEmpty()) {
            theStack.displayStack("while  ");
            output = output + theStack.pop();
        }
        theStack.displayStack("End  ");
        return output;
    }

    private void gotOper(char opThis, int prec1) {
        while (!theStack.isEmpty()) {
            char opTop = theStack.pop();
            if (opTop == '(') {
                theStack.push(opTop);
                break;
            } else {
                int prec2;
                if (opTop == '+' || opTop == '-') {
                    prec2 = 1;
                } else {
                    prec2 = 2;
                }
                if (prec2 < prec1)          // if prec of new op less
                {                       //    than prec of old
                    theStack.push(opTop);   // save newly-popped op
                    break;
                } else                       // prec of new not less
                    output = output + opTop;  // than prec of old
                // end else (it's an operator)
            }
        }
        theStack.push(opThis);

    }

    public void gotParen(char ch) {                             // got right paren from input
        while (!theStack.isEmpty()) {
            char chx = theStack.pop();
            if (chx == '(')           // if popped '('
                break;                  // we're done
            else                       // if popped operator
                output = output + chx;  // output it
        }  // end while
    }  // end popOps()
}

class InfixApp {
    public static void main(String[] args) throws IOException {
        String input, output;
        while (true) {
            System.out.print("Enter infix: ");
            System.out.flush();
            input = getString();         // read a string from kbd
            if (input.equals(""))       // quit if [Enter]
                break;
            // make a translator
            InToPost theTrans = new InToPost(input);
            output = theTrans.doTrans(); // do the translation
            System.out.println("Postfix is " + output + '\n');
        }  // end while
    }  // end main()

    //--------------------------------------------------------------
    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
}

