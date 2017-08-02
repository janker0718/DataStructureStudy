package cc.janker.opensource.data.structure.Chap03;

/**
 * Created by zhiyongliu3 on 2017/8/2.
 */
class ArraySel {
    private long[] a;

    private int nElems;

    public ArraySel(int max) {
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

    public void selectSort(){
        int out ,in ,min;

        for (out = 0; out < nElems -1 ; out++) {
            min = out;
            
        }
    }
}
