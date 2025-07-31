package pgdp.searchengine.pagerepository;

import pgdp.searchengine.util.Date;

/**
 * @author Jan Wagener (wagener@in.tum.de)
 */
public class Review {
    // Id als eindeutiger Bezeichner eines 'Review'-Objektes
    private final int postId;
    private static int nextPostId = 0;

    // Restliche Attribute
    private String title;
    private String content;
    private final Date postDate;
    private final Author reviewer;
    private final Document reviewedDocument;

    private byte rating;
    public static final byte MIN_RATING = 0;
    public static final byte MAX_RATING = 5;

    // Konstruktor
    public Review(String title, String content, Date postDate, Author reviewer, Document reviewedDocument) {
        postId = nextPostId++;
        setTitle(title);
        setContent(content);
        this.postDate = postDate;
        this.reviewer = reviewer;
        this.reviewedDocument = reviewedDocument;
    }

    // Getter
    public String getTitle() {
        return title;
    }
    public String getContent() {
        return content;
    }
    public Date getPostDate() {
        return postDate;
    }
    public Author getReviewer() {
        return reviewer;
    }
    public Document getReviewedDocument() {
        return reviewedDocument;
    }
//    public byte getRating() {
//        return rating;
//    }

    // Setter
    public void setTitle(String title) {
        this.title = title;
    }
    public void setContent(String content) {
        this.content = content;
    }

    // Text mit Alter des Reviews
    public String getAgeText() {
        return "Vor " + postDate.daysUntil(Date.today()) + " Tagen gepostet";
    }

    // equals()-Methode
    public boolean equals(Review other) {
        return postId == other.postId;
    }

    // toString()-Methode: Kurze textuelle Beschreibung des Objektes
    public String toString() {
        return "[" + postId + ": " + reviewedDocument + ", " + rating + " stars]";
    }

    // toPrintText()-Methode: Längere textuelle Beschreibung des Objektes
    public String toPrintText() {
        return "<|==== Review of " + reviewedDocument + " ====|> (" + rating + " stars)"
                + "\nId: " + postId
                + "\nTitle: " + title
                + "\n" + content
                + "\nPosted at " + postDate
                + "\nPosted by " + reviewer;
    }
}