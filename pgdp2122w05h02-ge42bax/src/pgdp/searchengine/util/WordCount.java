package pgdp.searchengine.util;

public class WordCount {
    private String word;
    private int count;


    public WordCount(String word, int count){
        if(count>=0){
            this.word=word;
            this.count=count;
        }
        else{
            this.word=word;
            this.count=0;
        }
    }

    public WordCount(String word){
        this.word=word;
        this.count=count;
    }
    public void increment(){
        this.count=this.count+1;
    }

    public int getCount(){
        return this.count;
    }
    public String getWord(){
        return this.word;
    }

}
