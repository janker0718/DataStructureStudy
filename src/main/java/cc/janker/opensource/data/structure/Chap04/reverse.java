package cc.janker.opensource.data.structure.Chap04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by zhiyongliu3 on 2017/8/3.
 */
class StackXX {
    private int maxSize;
    private char[] stackArray;
    private int top;

    //--------------------------------------------------------------
    public StackXX(int max)    // constructor
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
//--------------------------------------------------------------
}  // end class StackX
class Reverser{
    private String input;
    private String output;
    public Reverser(String in){
        input = in;
    }
    public String doRev(){
        int size = input.length();
        StackXX theStack = new StackXX(size);
        for (int i = 0; i < size; i++) {
            theStack.push(input.charAt(i));
        }
        output = "";

        while (!theStack.isEmpty()){
            char c = theStack.pop();
            output = output + c;
        }
        return output;

    }


}
class ReverseApp
{
    public static void main(String[] args) throws IOException
    {
        String input, output;
        while(true)
        {
            System.out.print("Enter a string: ");
            System.out.flush();
            input = getString();          // read a string from kbd
            if( input.equals("") )        // quit if [Enter]
                break;
            // make a Reverser
            Reverser theReverser = new Reverser(input);
            output = theReverser.doRev(); // use it
            System.out.println("Reversed: " + output);
        }  // end while
    }  // end main()
    //--------------------------------------------------------------
    public static String getString() throws IOException
    {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
//--------------------------------------------------------------
}  // end class ReverseApp
