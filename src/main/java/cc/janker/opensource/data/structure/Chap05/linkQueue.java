package cc.janker.opensource.data.structure.Chap05;

/**
 * 用联表实现队列
 * Created by zhiyongliu3 on 2017/8/4.
 */
class Link2 {
    public long dData;                // data item
    public Link2 next;                 // next link in list

    // -------------------------------------------------------------
    public Link2(long d)               // constructor
    {
        dData = d;
    }

    // -------------------------------------------------------------
    public void displayLink()         // display this link
    {
        System.out.print(dData + " ");
    }
// -------------------------------------------------------------
}  // end class Link

class FirstLastList {
    private Link2 first;               // ref to first item
    private Link2 last;                // ref to last item

    // -------------------------------------------------------------
    public FirstLastList()            // constructor
    {
        first = null;                  // no items on list yet
        last = null;
    }

    // -------------------------------------------------------------
    public boolean isEmpty()          // true if no links
    {
        return first == null;
    }

    // -------------------------------------------------------------
    public void insertLast(long dd) // insert at end of list
    {
        Link2 newLink = new Link2(dd);   // make new link
        if (isEmpty())                // if empty list,
            first = newLink;            // first --> newLink
        else
            last.next = newLink;        // old last --> newLink
        last = newLink;                // newLink <-- last
    }

    // -------------------------------------------------------------
    public long deleteFirst()         // delete first link
    {                              // (assumes non-empty list)
        long temp = first.dData;
        if (first.next == null)         // if only one item
            last = null;                // null <-- last
        first = first.next;            // first --> old next
        return temp;
    }

    // -------------------------------------------------------------
    public void displayList() {
        Link2 current = first;          // start at beginning
        while (current != null)         // until end of list,
        {
            current.displayLink();      // print data
            current = current.next;     // move to next link
        }
        System.out.println("");
    }
// -------------------------------------------------------------
}  // end class FirstLastList

class LinkQueue {
    private FirstLastList theList;

    public LinkQueue(){
        theList = new FirstLastList();
    }
    public boolean isEmpty(){
        return (theList.isEmpty());
    }

    public void insert(long j){
        theList.insertLast(j);
    }

    public long remove(){
        return theList.deleteFirst();
    }

    public void displayQueue(){
        System.out.print("Queue (front-->rear): ");
        theList.displayList();
    }
}

class LinkQueueApp{
    public static void main(String[] args) {
        LinkQueue queue = new LinkQueue();
        queue.insert(20);
        queue.insert(40);
        queue.displayQueue();

        queue.insert(60);
        queue.insert(80);

        queue.displayQueue();

        queue.remove();
        queue.remove();

        queue.displayQueue();
    }
}