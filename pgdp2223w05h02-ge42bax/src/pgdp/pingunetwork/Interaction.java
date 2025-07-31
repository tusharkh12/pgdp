package pgdp.pingunetwork;

// TODO: Fülle diese Klasse entsprechend der Aufgabenstellung
public class Interaction {
    private User user;
    private int interactionType;
    private Post interactions;


    public Interaction(User user, int interactionType) {
        this.user = user;
        this.interactionType = interactionType;
        // this.interactions = interactions;
    }

    public User getUser() {
        return user;
    }

    public int getInteractionType() {
        return interactionType;
    }
}
