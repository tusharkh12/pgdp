package pgdp.searchengine.pagerepository;

public class DocumentListElement  {
    private Document document;
    private DocumentListElement pre;
    private DocumentListElement next;


    public DocumentListElement(Document document){
        this.document = document;
        pre = null;
        next = null;

    }

    public Document getDocument(){
        return document;
    }

    public DocumentListElement getPre() {
        return pre;
    }

    public DocumentListElement getNext() {
        return next;
    }

    public void setPre(DocumentListElement pre) {
        this.pre = pre;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public void setNext(DocumentListElement next) {
        this.next = next;
    }
}
