package pgdp.searchengine.pagerepository;

import pgdp.searchengine.util.Date;
import pgdp.searchengine.util.WordCount;

import java.util.Locale;

public class Document {
    private final int documentId;
    private static int nextDocumentId = 0;

    private String title;
    private String description;
    private String content;

    private final Date releaseDate;
    private Date lastUpdateDate;

    private final Author author;

    public Document(String title, String description, String content, Date releaseDate, Author author) {
        documentId = nextDocumentId++;
        this.title = title;
        this.description = description;
        this.content = content;
        this.releaseDate = releaseDate;
        this.lastUpdateDate = releaseDate;
        this.author = author;
    }

    public int getDocumentId() {
        return documentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Author getAuthor() {
        return author;
    }

    public boolean equals(Document other) {
        return documentId == other.documentId;
    }

    public WordCount[] getWordCountArray() {
        String stringContent = getContent().toLowerCase();
        stringContent = stringContent.replace(".", " ");
        stringContent = stringContent.replace(";", " ");
        stringContent = stringContent.replace("?", " ");
        stringContent = stringContent.replace("(", " ");
        stringContent = stringContent.replace(")", " ");
        stringContent = stringContent.replace("!", " ");
        stringContent = stringContent.replace("*", " ");
        stringContent = stringContent.replace(",", " ");

        String[] contentWithDuplicates = stringContent.split(" ");
        String[] contentWithoutDuplicates = new String[contentWithDuplicates.length];


        for (int i = 0; i < contentWithDuplicates.length; i++) {
            if (contentWithDuplicates[1] == null || contentWithDuplicates[i] == "") {
                for (int j = 0; j < contentWithDuplicates.length; j++) {
                    if (contentWithDuplicates[i].equals(contentWithDuplicates[j]) &&
                            contentWithDuplicates[i].equals(" ") == false && i != j) {

                        contentWithoutDuplicates[j] = " ";
                    } else {
                        contentWithoutDuplicates[i] = contentWithDuplicates[i];

                    }

                }
            }


            }
        int nullsAdded =0;
        for (int x = 0; x< contentWithoutDuplicates.length; x++) {
            if(contentWithoutDuplicates[x]==null){
                contentWithoutDuplicates[x]= " ";
            }
            if(contentWithoutDuplicates[x]==null){
                contentWithoutDuplicates[x] = " ";

            }
            if (contentWithoutDuplicates[x].equals(' ')){
                nullsAdded= nullsAdded+1;
            }
        }

        WordCount[] wordCount = new WordCount[contentWithoutDuplicates.length-nullsAdded];
        int j=0;
        for (int i = 0;i<contentWithoutDuplicates.length;i++){
            if(contentWithoutDuplicates[i].equals(" ")){}
                else {
                    wordCount[j]=new WordCount(contentWithoutDuplicates[i]);
                    j=j+1;



            }
        }
        for (int k = 0; k < wordCount.length; k++) {
            for (int i = 0; i <contentWithDuplicates.length ; i++) {
                if(wordCount[k].getWord().equals(contentWithDuplicates[i])){
                    wordCount[k].increment();
                }


            }

        }
        if(stringContent==null || stringContent==""){
            return new WordCount[]{
                    new WordCount("",0)};
            }
              return wordCount;
        }

        public static WordCount[] equalizeWordCountArray(WordCount[] first,WordCount[] second){
        
        String toAdd= "";
            for (int i = 0; i < second.length; i++) {
                boolean found = false;
                for (int j = 0; j < first.length; j++) {
                    if(second[i].getWord().equals(first[j].getWord())){
                        found=true;
                        break;
                    }

                }
                if(found==false){
                    if(toAdd.length()==0){
                        toAdd=second[i].getWord()+" ";
                    }
                    else{
                        toAdd=toAdd.concat(second[i].getWord()) + " ";
                    }
                }
                
            }
            if(toAdd!=""){
                String[] toSum=toAdd.split(" ");
                WordCount[] together =new WordCount[first.length+ toSum.length];

                for (int i = 0; i < first.length; i++) {
                    together[i]=first[i];

                }
                int k =0;
                for (int i = first.length; i < first.length+ toSum.length; i++) {
                    together[i]=new WordCount((toSum[k]));
                    k++;

                }
                return together;
            }
            else{
                return first;
            }
        }

        public static void sort(WordCount[] wordCount){
        if(wordCount[0].getWord()==null || wordCount[0].getWord()==""){

        }else{
            for (int i = 0; i < wordCount.length-1 ; i++) {
                for (int j = 0; j < wordCount.length ; j++) {
                    boolean done= false;
                    String tmp=wordCount[j].getWord().toLowerCase();
                    String tmp0 =wordCount[j-1].getWord().toLowerCase();
                    WordCount tmpWC= new WordCount(wordCount[j].getWord(),wordCount[j-1].getCount());  //check again
                    int k=0;
                    while (done==false&& k<tmp0.length()|| done==false && k<tmp0.length()){
                        if (k<tmp.length()&& k<tmp0.length()){
                            if(((int) tmp.charAt(k))>((int) tmp0.charAt(k))){
                                done = true;
                            }
                            else{
                                done=false;
                            }
                            k=k+1;
                        }
                        if(((int)tmp.charAt(k))>((int)tmp0.charAt(k))){
                            done=true;
                        }
                       else{
                           done=false;


                    }
                       k++;
                }
                    if(tmp.length()<tmp0.length()){
                        wordCount[j]=wordCount[j-1];
                        wordCount[j-1]=wordCount[j-1];
                        wordCount[j-1]=tmpWC;
                        done=true;
                    }
                    else{
                        done=false;
                    }



            }}

        }
        }


    @Override
    public String toString() {
        return title + ", by " + author + ", released " + releaseDate;
    }

    public String toPrintText() {
        return "<|==== " + title + " ====|>" + "\nBy " + author + "\n" + description + "\nLast updated at "
                + lastUpdateDate;
    }

    public static int numberOfCreatedDocuments() {
        return nextDocumentId;
    }
}
