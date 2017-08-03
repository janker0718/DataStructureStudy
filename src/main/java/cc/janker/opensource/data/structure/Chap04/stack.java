package cc.janker.opensource.data.structure.Chap04;

/**
 * Created by zhiyongliu3 on 2017/8/3.
 */
class StackX {
    private int maxSize;        // size of stack array
    private long[] stackArray;
    private int top;            // top of stack

    // constructor
    public StackX(int s){
        maxSize = s;
        stackArray = new  long[s];
        top = -1;
    }
    public void push(long j){
        stackArray[++top] = j;
    }


    public long pop(){
        return stackArray[top--];
    }

    public long peek(){
        return stackArray[top];
    }       //查看

    public boolean isEmpty(){
        return (top == -1);
    }

    public boolean isFull(){
        return (top == maxSize -1);
    }

}
class StackApp {
    public static void main(String[] args) {
        StackX theStack = new StackX(10);  // make new stack
        theStack.push(20);               // push items onto stack
        theStack.push(40);
        theStack.push(60);
        theStack.push(80);

        while (!theStack.isEmpty())     // until it's empty,
        {                             // delete item from stack
            long value = theStack.pop();
            System.out.print(value);      // display it
            System.out.print(" ");
        }  // end while
        System.out.println("");
    }  // end main()
}