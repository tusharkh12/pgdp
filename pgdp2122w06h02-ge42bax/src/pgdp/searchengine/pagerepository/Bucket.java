package pgdp.searchengine.pagerepository;

public class Bucket{
    private DocumentListElement head;
    private DocumentListElement tail;




    public Bucket(){
        this.head=null;
        this.tail=null;

    }

    public DocumentListElement getHead() {

        return head;
    }

    public DocumentListElement getTail() {
        return tail;
    }


    public void setHead(DocumentListElement head){
        this.head = head;
    }

    public void setTail(DocumentListElement tail){
        this.tail= tail;
    }

    public void add(int i, Document d) {

    }
}
