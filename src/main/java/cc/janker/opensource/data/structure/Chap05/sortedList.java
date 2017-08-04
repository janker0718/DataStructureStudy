package cc.janker.opensource.data.structure.Chap05;

/**
 * Created by zhiyongliu3 on 2017/8/4.
 */
class Link3
{
    public long dData;                  // data item
    public Link3 next;                   // next link in list
    // -------------------------------------------------------------
    public Link3(long dd)                // constructor
    { dData = dd; }
    // -------------------------------------------------------------
    public void displayLink()           // display this link
    { System.out.print(dData + " "); }
}  // end class Link
////////////////////////////////////////////////////////////////

class SortedList{
    private Link3 first;

    public SortedList(){
        first = null;
    }

    public boolean isEmpty(){
        return (first == null);
    }

    public void insert(long key){
        Link3 newLink = new Link3(key);
        //前一个为空
        Link3 previous = null;
        Link3 current = first;
        //寻找插入的位置
        while(current !=null && key > current.dData){
            previous = current;
            current = current.next;
        }
        if (previous == null){  //list开始
            first = newLink;
        }else{
            previous.next = newLink;
        }
        newLink.next = current;
    }

    public Link3 remove(){
        Link3 temp = first;
        first = temp.next;
        return temp;
    }

    public void displayList(){
        System.out.print("List (first-->last): ");
        Link3 current = first;
        while (current!=null){
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }

}

class SortedListApp{
    public static void main(String[] args) {
        SortedList sortedList = new SortedList();
        sortedList.insert(20);
        sortedList.insert(40);

        sortedList.displayList();

        sortedList.insert(10);
        sortedList.insert(30);
        sortedList.insert(50);
        sortedList.displayList();


        sortedList.remove();

        sortedList.displayList();
    }
}