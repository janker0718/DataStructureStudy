package cc.janker.opensource.data.structure.Chap04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by zhiyongliu3 on 2017/8/3.
 */
class BracketChecker {
    private String input;

    public BracketChecker(String in) {
        input = in;
    }

    public void check() {
        int stackSize = input.length();
        StackXX stackXX = new StackXX(stackSize);
        for (int i = 0; i < stackSize; i++) {
            char ch = input.charAt(i);
            switch (ch) {
                case '{':                      // opening symbols
                case '[':
                case '(':
                    stackXX.push(ch);
                    break;
                case '}':                      // closing symbols
                case ']':
                case ')':
                    if (!stackXX.isEmpty()) {
                        char chx = stackXX.pop();
                        if ((ch == '{' && chx != '}') ||
                                (ch == '[' && chx != ']') ||
                                (ch == '(' && chx != ')')) {
                            System.out.println("Error: " + ch + " at " + i);
                        }
                    }else{
                        System.out.println("Error: " + ch + " at " + i);
                    }


                    break;
                default:    // no action on other characters
                    break;
            }
        }
        if( !stackXX.isEmpty() )
            System.out.println("Error: missing right delimiter");
    }  // end check()

}
class BracketsApp
{
    public static void main(String[] args) throws IOException
    {
        String input;
        while(true)
        {
            System.out.print(
                    "Enter string containing delimiters: ");
            System.out.flush();
            input = getString();     // read a string from kbd
            if( input.equals("") )   // quit if [Enter]
                break;
            // make a BracketChecker
            BracketChecker theChecker = new BracketChecker(input);
            theChecker.check();      // check brackets
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
}  // end class BracketsApp
