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
        int in ,out ,min;
        for (out = 0; out < nElems -1 ; out++) {
            min = out;
            for (in = out+1;  in< nElems;in ++) {
                if (a[in]<a[min]){
                    min = in;
                }
            }
            swap(out,min);
        }
    }

    private void swap(int out, int min) {
        long temp = a[out];
        a[out] = a[min];
        a[min] = temp;
    }
}
class ArraySelApp{
    public static void main(String[] args) {
        int maxSize = 100;            // array size
        ArraySel arr;                 // reference to array
        arr = new ArraySel(maxSize);  // create the array

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

        arr.selectSort();          // selection-sort them

        arr.display();                // display them again
    }
}
