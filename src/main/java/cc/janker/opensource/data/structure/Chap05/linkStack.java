package cc.janker.opensource.data.structure.Chap05;

/**
 * Created by zhiyongliu3 on 2017/8/4.
 */
class Link1 {
    public long dData;             // data item
    public Link1 next;              // next link in list

    // -------------------------------------------------------------
    public Link1(long dd)           // constructor
    {
        dData = dd;
    }

    // -------------------------------------------------------------
    public void displayLink()      // display ourself
    {
        System.out.print(dData + " ");
    }
}  // end class Link
class LinkList1
{
    private Link1 first;            // ref to first item on list
    // -------------------------------------------------------------
    public LinkList1()              // constructor
    { first = null; }           // no items on list yet
    // -------------------------------------------------------------
    public boolean isEmpty()       // true if list is empty
    { return (first==null); }
    // -------------------------------------------------------------
    public void insertFirst(long dd) // insert at start of list
    {                           // make new link
        Link1 newLink = new Link1(dd);
        newLink.next = first;       // newLink --> old first
        first = newLink;            // first --> newLink
    }
    // -------------------------------------------------------------
    public long deleteFirst()      // delete first item
    {                           // (assumes list not empty)
        Link1 temp = first;          // save reference to link
        first = first.next;         // delete it: first-->old next
        return temp.dData;          // return deleted link
    }
    // -------------------------------------------------------------
    public void displayList()
    {
        Link1 current = first;       // start at beginning of list
        while(current != null)      // until end of list,
        {
            current.displayLink();   // print data
            current = current.next;  // move to next link
        }
        System.out.println("");
    }
// -------------------------------------------------------------
}  // end class LinkList

class LinkStack{
    private LinkList1 theList;

    public LinkStack(){
        theList = new LinkList1();
    }

    public void push(long j){
        theList.insertFirst(j);
    }

    public long pop(){
        return theList.deleteFirst();
    }

    public boolean isEmpty(){
        return (theList.isEmpty());
    }

    public void displayStack(){
        System.out.print("Stack (top-->bottom): ");
        theList.displayList();
    }

}
class LinkStackApp{
    public static void main(String[] args) {
        LinkStack theStack = new LinkStack();

        theStack.push(20);
        theStack.push(40);

        theStack.displayStack();              // display stack
        theStack.push(60);                    // push items
        theStack.push(80);

        theStack.displayStack();              // display stack
        theStack.pop();                       // pop items
        theStack.pop();

        theStack.displayStack();              // display stack
    }
}
