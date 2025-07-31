package pgdp.security;

public abstract class SignalPost {
    private int postNumber;
    private String depiction;
    private int level;

    /**
     * Diese Klasse ist nur da, damit keine Buildfails entstehen. Allerdings ist sie
     * bei Weitem noch nicht vollständig.
     */

    public SignalPost(int postNumber) {
        this.postNumber = postNumber;
        this.depiction = "";
        this.level = 0;
    }

    public abstract boolean up(String type);

    public abstract boolean down(String type);

    public String toString() {
        return "Signal Post " + getPostNumber() + ": " + getLevel() + " " + getDepiction();
    }


    public int getPostNumber() {
        return postNumber;
    }

    public void setPostNumber(int postNumber) {
        this.postNumber = postNumber;
    }

    public String getDepiction() {
        return depiction;
    }

    public void setDepiction(String depiction) {
        this.depiction = depiction;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public static void main(String[] args) {
//        SignalPost signalPost=new FlagPost(5);
//        System.out.println(signalPost.getPostNumber());
//        System.out.println(signalPost.getDepiction());
//        System.out.println(signalPost.getLevel());
//        System.out.println(signalPost.toString());
    }
}
