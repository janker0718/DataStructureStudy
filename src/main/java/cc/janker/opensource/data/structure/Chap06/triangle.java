package cc.janker.opensource.data.structure.Chap06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by zhiyongliu3 on 2017/8/7.
 */
class TriangleApp {
    static int theNumber;
    public static void main(String[] args) throws IOException {
        System.out.print("Enter a number:");

        theNumber = getInt();

        int theAnswer = triangle(theNumber);
        System.out.println("Triangle="+theAnswer);
    }

    private static int triangle(int n) {
        if (n==1){
            return 1;
        }else{
            return ( n + triangle(n-1));
        }
    }

    public static int getInt() throws IOException {
        String s = getString();
        return Integer.parseInt(s);
    }

    private static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
}
