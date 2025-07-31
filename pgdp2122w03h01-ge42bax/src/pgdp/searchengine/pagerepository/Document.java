package pgdp.searchengine.pagerepository;

import pgdp.searchengine.util.Date;

public class Document {
    private static int number = 0;
    private Date releaseDate;
    private int documentId;
    private String content;
    private Date lastUpdateDate;
    private Author author;
    private String title;
    private String description;
    {
        number =number + 1;
    }

    public Document(String title, String description, String content, Date releaseDate, Author author) {
        this.lastUpdateDate = releaseDate;
        this.releaseDate = releaseDate;
        this.content = content;
        this.documentId =documentId;
        this.author = author;
        this.title = title;
        this.description = description;

    }
//Getter
    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
    public String getContent() {
        return content;
    }
    public int getDocumentId() {
        return documentId - 1;
    }
    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }
    public Date getReleaseDate() {
        return releaseDate;
    }

    public Author getAuthor() {
        return author;
    }

    //Setter
    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setLastUpdateDate(Date date) {
        this.lastUpdateDate = date;
    }


    public void setAuthor(Author author) {
        this.author=author;
    }

    public boolean equals(Document document) {
        if (this.documentId == document.documentId) {
            return true;
        } else {
            return false;
        }
    }
    public static int numberOfCreatedDocuments() {
        return Document.number;
    }

    public String toString() {
        return title + " " + releaseDate + " " + author.toString();
    }

    public String toPrintText() {
        return title + "\n" + author.toString()+ "\n" + description + "\n"+ lastUpdateDate.toString();
    }


}