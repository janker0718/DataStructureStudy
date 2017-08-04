package cc.janker.opensource.data.structure.Chap05;

/**
 * Created by zhiyongliu3 on 2017/8/4.
 */
class Link4
{
    public long dData;                  // data item
    public Link4 next;                   // next link in list
    // -------------------------------------------------------------
    public Link4(long dd)                // constructor
    { dData = dd; }
// -------------------------------------------------------------
}  // end class Link
////////////////////////////////////////////////////////////////
class SortedList1{
    private Link4 first;

    public SortedList1(Link4[] linkArr){
        first = null;
        for (int i = 0; i < linkArr.length; i++) {
            insert(linkArr[i]);
        }
    }

    public boolean isEmpty(){
        return (first == null);
    }

    public void insert(Link4 key){
        //前一个为空
        Link4 previous = null;
        Link4 current = first;
        //寻找插入的位置
        while(current !=null && key.dData > current.dData){
            previous = current;
            current = current.next;
        }
        if (previous == null){  //list开始
            first = key;
        }else{
            previous.next = key;
        }
        key.next = current;
    }

    public Link4 remove(){
        Link4 temp = first;
        first = temp.next;
        return temp;
    }

}

class ListInsertionSortApp{
    public static void main(String[] args) {
        int size = 10;
        // create array of links
        Link4[] linkArray = new Link4[size];

        for (int i = 0; i < size; i++) {
            int n = (int) (Math.random()*99);
            Link4 newLink = new Link4(n);
            linkArray[i] = newLink;
        }
        System.out.print("Unsorted array: ");
        for(int j=0; j<size; j++)
            System.out.print( linkArray[j].dData + " " );
        System.out.println("");
        SortedList1 sortedList1 = new SortedList1(linkArray);
        System.out.print("Sorted array: ");

        for(int j=0; j<size; j++)  // links from list to array
            linkArray[j] = sortedList1.remove();


        for(int j=0; j<size; j++)
            System.out.print( linkArray[j].dData + " " );
        System.out.println("");

    }
}