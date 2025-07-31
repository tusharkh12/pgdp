package pgdp.searchengine.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import org.junit.jupiter.api.Test;

import pgdp.searchengine.pagerepository.Author;
import pgdp.searchengine.pagerepository.Document;
import pgdp.searchengine.util.Date;
import pgdp.searchengine.util.WordCount;

public class SearchEngineTesting {
    Author author= new Author("a","a","1ss","ss",new Date(1,12,2000));
    Date releaseDate= new Date(2,11,2222);



    @Test
    public void testGetWordArrayRegular() {
        Document document = new Document("Title", "Decription", "A. b? b; d.(d)", releaseDate, author);
        assertEquals("a", document.getWordCountArray()[0].getWord());
        assertEquals("b", document.getWordCountArray()[1].getWord());
        assertEquals("2", document.getWordCountArray()[1].getWord());
    }

        @Test
                public void testWordCountArraySpecial(){
            Document document = new Document("Title", "Decription", "", releaseDate, author);
            assertEquals("", document.getWordCountArray()[0].getWord());
            assertEquals("0", document.getWordCountArray()[0].getWord());

        }


    }

    

