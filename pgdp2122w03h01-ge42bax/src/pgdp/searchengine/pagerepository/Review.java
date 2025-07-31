package pgdp.searchengine.pagerepository;

import pgdp.searchengine.util.Date;

public class Review {
    private Document reviewedDocument;
    private Date postDate;
    private int rating;
    private static int number = 0;
    private Author reviewer;
    private String title;
    private int postId;
    private String content;
    {
        number += 1;
    }

    public Review(String title, String content, Date postDate, Author review, Document reviewedDocument, int rating) {
        this.title = title;
        this.content = content;
        this.rating = rating;
        this.postDate = postDate;
        this.reviewer = review;
        this.reviewedDocument = reviewedDocument;
        this.postId = number;

    }

    public String getTitle() {
        return title;
    }
    public String getContent() {
        return content;
    }
    public int getRating() {
        return rating;
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

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }



    public void setReviewer(Author author) {
        this.reviewer=author;
    }


    public int getPostId() {
        return postId - 1;
    }

    public boolean equals(Review review) {
        if (this.postId == review.postId) {
            return true;
        }
        else {
            return false;
        }
    }
    public static int numberOfCreatedReviews() {
        return number;


    }

    public String toString() {
        return  title + " "+ rating + " " + reviewedDocument.toString();
    }

    public String toPrintText() {
        return reviewedDocument.toString() + "\n" + rating+ "\n" + title + "\n" + content+ "\n" + postDate.toString()+ "\n" + reviewer.toString();
    }
}