package cc.janker.opensource.data.structure.Chap05;

/**
 * Created by zhiyongliu3 on 2017/8/4.
 */
class Link5
{
    public long dData;                 // data item
    public Link5 next;                  // next link in list
    public Link5 previous;              // previous link in list
    // -------------------------------------------------------------
    public Link5(long d)                // constructor
    { dData = d; }
    // -------------------------------------------------------------
    public void displayLink()          // display this link
    { System.out.print(dData + " "); }
// -------------------------------------------------------------
}  // end class Link
////////////////////////////////////////////////////////////////

class DoublyLinkedList{
    private Link5 first; //首个item
    private Link5 last;  //最后一个item

    public DoublyLinkedList(){
        first = null;
        last = null;
    }
    public boolean isEmpty(){
        return (first ==null);
    }

    public void insertFirst(long dd){
        Link5 newLink = new Link5(dd);
        if (isEmpty()){
            last = newLink;
        }else{
            first.previous = newLink;
        }
        first.next =  first;
        first = newLink;
    }

    public void insertLast(long dd){
        Link5 newLink = new Link5(dd);
        if (isEmpty()){
            first = newLink;
        }
        else{
            last.next = newLink;
            newLink.previous = last;
        }
        last = newLink;
    }

    public Link5 deleteFirst(){
        Link5 temp = first;
        if (first.next == null){  //只有一个item
            last = null;
        }else {
            first.next.previous = null;
        }
        first = first.next;
        return temp;
    }

//    public Link5 deleteLast(){
//
//    }
}