package cc.janker.opensource.data.structure.Chap02;

/**
 * Created by zhiyongliu3 on 2017/8/2.
 */
class OrdArray {
    private long[] a;

    private int nElems;

    public OrdArray(int max) {
        a = new long[max];
        nElems = 0;
    }


    public int size() {
        return nElems;
    }

    public int find(long searchKey) {
        int lower = 0;
        int upper = nElems - 1;
        int cur;
        while (true) {
            cur = (lower + upper) / 2;
            if (a[cur] == searchKey) {
                return cur;
            } else if (lower > upper) {
                return nElems;
            } else {
                //缩小范围
                if (a[cur] < searchKey) {
                    //在中间部分的右边 low左移
                    lower = cur + 1;
                } else {
                    //在中间部分的左边 uper 左移
                    upper = cur - 1;
                }
            }
        }
    }


    public void insert(long value) {
        int j;
        for (j = 0; j < nElems; j++) {
            if (a[j] > value){
                break;
            }
        }
        for (int k = nElems; k>j; k--){
            a[k] = a[k-1];  //较小后移  较大前移
        }
        a[j] =value;
        nElems++;

    }//end insert

    public boolean delete(long value){
        int j = find(value);
        if (j == nElems)
            return false;
        else{
            for (int k = j ; k< nElems; k++){
                a[k] = a[k+1];  //
            }
            nElems--;
            return true;
        }
    }

    public void display(){
        for (int j = 0; j< nElems; j++){
            System.out.print(a[j]+ "  ");
        }
        System.out.println();
    }
}

class OrderedApp{
    public static void main(String[] args) {
        int maxSize = 100;
        OrdArray arr;
        arr = new OrdArray(maxSize);
        arr.insert(77);                // insert 10 items
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

        int searchKey = 55;

        if (arr.find(searchKey)!= arr.size()){
            System.out.print("Found "+ searchKey);
        }else
            System.out.print("Can‘t find "+searchKey);
        System.out.println();
        arr.delete(00);                // delete 3 items
        arr.delete(55);
        arr.delete(99);
        arr.display();
    }
}
