package cc.janker.opensource.data.structure.Chap03;

/**
 * Created by zhiyongliu3 on 2017/8/2.
 */
class ArrayBub {
    private long[] a;

    private int nElems;

    public ArrayBub(int max) {
        a = new long[max];
        nElems = 0;
    }

    public void insert(long value) {
        a[nElems] = value;
        nElems++;
    }

    public void display()             // displays array contents
    {
        for (int j = 0; j < nElems; j++)       // for each element,
            System.out.print(a[j] + " ");  // display it
        System.out.println("");
    }

    public void bubbleSort(){
        int out, in;
        for (out = 0; out < nElems; out++) {
            for (in=0; in<out; in++) {
                if (a[in]> a[in+1]){
                    swap(in,in+1);
                }
            }
        }
    }

    private void swap(int in, int i) {
        long temp = a[in];
        a[in] = a[i];
        a[i] = temp;
    }

}

class BubbleSortApp{
    public static void main(String[] args) {
        int maxSize = 100;            // array size
        ArrayBub arr;                 // reference to array
        arr = new ArrayBub(maxSize);  // create the array

        arr.insert(77);               // insert 10 items
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(00);
        arr.insert(66);
        arr.insert(33);

        arr.display();                // display items

        arr.bubbleSort();             // bubble sort them

        arr.display();                // display them again
    }
}
