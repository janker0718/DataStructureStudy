package cc.janker.opensource.data.structure.Chap02;

/**
 * Created by zhiyongliu3 on 2017/8/2.
 */
class HighArray {
    private long[] a;

    private int nElems;
    //-------------------------
    public  HighArray(int max){
        a = new long[max];
        nElems = 0;
    }

    public boolean find(long searchKey){

        int j ;
        for(j = 0;j<nElems; j++){
            if (a[j] == searchKey){
                break;
            }
        }
        if (j==nElems){
            return false;
        }else{
            return true;
        }
    }   //end find

    public void insert(long value){
        a[nElems] = value;
        nElems++;
    }


    public boolean delete(long value){
        int j;

        for (j=0;j<nElems;j++){
            if (a[j]==value){
                break;
            }
        }
        if (j==nElems){
            return false;
        }else{
            for (int k = j; k<nElems;k++){
                a[k] = a[k+1];
            }
            nElems--;
            return  true;
        }
    }//end del

    public void display(){
        for(int j=0; j<nElems; j++)       // for each element,
            System.out.print(a[j] + " ");  // display it
        System.out.println("");
    }

}

class HighArrayApp{
    public static void main(String[] args) {
        int maxSize = 100;  //array size
        HighArray arr;                // reference to array
        arr = new HighArray(maxSize); // create the array
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

        arr.display();

        arr.delete(55);
        int searchKey = 35;           // search for item
        if( arr.find(searchKey) )
            System.out.println("Found " + searchKey);
        else
            System.out.println("Can't find " + searchKey);

        arr.delete(00);               // delete 3 items
        arr.delete(55);
        arr.delete(99);

        arr.display();

    }
}
