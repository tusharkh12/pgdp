package pgdp.searchengine.pagerepository;

import pgdp.searchengine.util.Date;

public class Document {
    private final int documentId;
    private static int nextDocumentId = 0;

    private String title;
    private String description;
    private String content;

    private final Date releaseDate;
    private Date lastUpdateDate;

    private final Author author;
    // Attribute ...

    public Document(String title, String description, String content, Date releaseDate, pgdp.searchengine.pagerepository.Author author) {
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



    // Getter ...

    // Setter ...

    public int yearsSinceRelease() {
        return 0;
    }

    public int daysSinceLastUpdate() {
        return 0;
    }

    public boolean equals(Document other) {
        return false;
    }

    public String toString() {
        return "";
    }

    public String toPrintText() {
        return "";
    }
}
