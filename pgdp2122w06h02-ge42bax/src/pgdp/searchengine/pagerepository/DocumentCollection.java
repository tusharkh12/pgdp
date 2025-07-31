package pgdp.searchengine.pagerepository;

import pgdp.searchengine.util.Date;

public class DocumentCollection {
    private int listNumber;
    private final Bucket[] buckets;




    public DocumentCollection(int listNumber) {
        //this.buckets = new Bucket[listNumber];
        if (listNumber <= 0) {
            this.listNumber = 1;
        }

        else {
            this.listNumber = listNumber;
        }
        this.buckets = new Bucket[this.listNumber];
        for (int i = 0; i <this.listNumber ; i++) {
            Bucket bucket = new Bucket();
            buckets[i]=bucket;

        }
    }
    private int indexFunction(int documentId){
        return documentId % listNumber;

    }


    public boolean add(Document d){
        if(d==null){
            return false;}
        if(d.getDocumentId()<0){
            return false;
        }

        int index =indexFunction(d.getDocumentId());
        DocumentListElement documentListElement= new DocumentListElement(d);
        Bucket bucket = buckets[index];
        DocumentListElement numberCurrent = bucket.getHead(); ///////////TO Dooo

        if(numberCurrent==null){
            buckets[index].add(0,d);
            return true;
        }
        while(numberCurrent.getNext()!=null){
            if(numberCurrent.getNext().getDocument().getDocumentId()==d.getDocumentId()){
                return false;
            }
            numberCurrent = numberCurrent.getNext();
        }

        if(bucket==null){
            bucket.add(0,d);
            buckets[index]=bucket;
            return true;
        }
        else{
            int insert = 0;
            numberCurrent=bucket.getHead();
            while (numberCurrent!=null){

                if(numberCurrent.getDocument().getDocumentId()<documentListElement.getDocument().getDocumentId()){
                    insert++;
                }

                numberCurrent = numberCurrent.getNext();
            }
            bucket.add(insert,d);
            buckets[index]=bucket;
            return true;
        }

    }

    public boolean isEmpty(){

        for (int i = 0; i < buckets.length; i++) {
            if(buckets[i].getHead()!=null ||
            buckets[i].getTail()!= null ){
                return false;
            }

        }
        return true;
    }

    public Document find(int documentId){
        for (int i = 0; i < buckets.length; i++) {
            DocumentListElement numberCurrent =buckets[i].getHead();
            while(numberCurrent!=null){
                if(numberCurrent.getDocument().getDocumentId()==documentId){
                    return numberCurrent.getDocument();
                }
                numberCurrent=numberCurrent.getNext();
            }

        }
        return null;
    }

    public DocumentListElement findElement(int documentId){
        for (int i = 0; i < buckets.length; i++) {
            DocumentListElement numberCurrent =buckets[i].getHead();
            while(numberCurrent!=null){
                if(numberCurrent.getDocument().getDocumentId()==documentId){
                    return numberCurrent;
                }
                numberCurrent= numberCurrent.getNext();
            }

        }
        return null;
    }


    public boolean removeDocument(int documentId)  {
        if (find(documentId) != null) {
            DocumentListElement Document = findElement(documentId);
            DocumentListElement preDocument = Document.getPre();
            DocumentListElement nextDocument = Document.getNext();
            int index = indexFunction(Document.getDocument().getDocumentId());
            if (preDocument == null && nextDocument == null) {
                buckets[index].setHead(null);
                buckets[index].setTail(null);


            }
            else {
                if(preDocument!=null){
                    preDocument.setNext(nextDocument);

                }
                else {
                    buckets[index].setHead(nextDocument);
                }

                if(nextDocument!=null){
                    nextDocument.setPre(preDocument);
                }
                else {
                    buckets[index].setTail(preDocument);
                }
            }
            Document.setPre(null);
            Document.setNext(null);
          //  Document=null;
            return true;


        }
        return false;

    }


    public boolean removeDocumentsFromAuthor(Author author){
      
        for (int i = 0; i < buckets.length; i++) {
            DocumentListElement current = buckets[i].getHead();
            while (current!=null){
                DocumentListElement next =current.getNext();
                if(current.getDocument().getAuthor().equals(author)){
                    removeDocument(current.getDocument().getDocumentId());
                    return true;
                }
                current=next;
            }

        }
        return false;
    }

    public boolean removeAll(){
        if(!isEmpty()){
            for (int i = 0; i < buckets.length; i++) {
                buckets[i].setHead(null);
                buckets[i].setTail(null);
            }
            return true;

            }
        else {
            return false;
        }
    }
    public boolean removeOldDocuments(Date releaseDate, Date lastUpdated){
        return false;
    }

   
    
    



  

    public int getlistNumber() {
        return listNumber;
    }
}
