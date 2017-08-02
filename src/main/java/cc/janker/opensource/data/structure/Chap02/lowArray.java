package cc.janker.opensource.data.structure.Chap02;

/**
 * Created by zhiyongliu3 on 2017/8/2.
 */
class LowArray {
    private long[] a;       //ref to array a
    //-------------------------------
    public LowArray(int size){  //构造函数
        a = new long[size];
    }
    //-------------------------------
    public void setElem(int index,long value){  //set value
        a[index] = value;
    }

    public long getElem(int index){             //get value
        return a[index];
    }
}
class LowArrayApp{
    public static void main(String[] args) {
        LowArray arr;
        arr = new LowArray(100);
        int nElems = 0;
        int j;
        arr.setElem(0, 77);           // insert 10 items
        arr.setElem(1, 99);
        arr.setElem(2, 44);
        arr.setElem(3, 55);
        arr.setElem(4, 22);
        arr.setElem(5, 88);
        arr.setElem(6, 11);
        arr.setElem(7, 00);
        arr.setElem(8, 66);
        arr.setElem(9, 33);

        nElems = 10;
        //show
        for (j=0; j<nElems;j++) {
            System.out.print(arr.getElem(j)+  "  ");
        }
        System.out.println();
        //search
        int searchKey = 26;
        for (j=0; j<nElems;j++){
            if (arr.getElem(j)==searchKey){
                break;
            }
        }
        if(j == nElems)                    // no
            System.out.println("Can't find " + searchKey);
        else                               // yes
            System.out.println("Found " + searchKey);

        //del
        for (j=0; j<nElems;j++){
            if (arr.getElem(j)==55){
                break;
            }
        }
        for (int k=j; k<nElems;k++){
            arr.setElem(k,arr.getElem(k+1));
        }
        nElems--;

        //show
        for (j=0; j<nElems;j++) {
            System.out.print(arr.getElem(j)+  "  ");
        }
        System.out.println();
    }
}