package pgdp.security;

public class FinishPost extends FlagPost {
    /**
     * Diese Klasse ist nur da, damit keine Buildfails entstehen. Allerdings ist sie
     * bei Weitem noch nicht vollständig.
     *
     * @param postNumber
     */
    public FinishPost(int postNumber) {
        super(postNumber);
    }

    @Override
    public boolean up(String type) {
        if (type == "end") {
            if (getLevel() <= 4) {
                this.setDepiction("chequered");
                setLevel(5);
                return true;
            }
        }
        return super.up(type);
    }

    @Override
    public boolean down(String type) {
        return super.down(type);
    }

    @Override
    public String toString() {
        if (getLevel() == 0) {
            return "Signal post " + getPostNumber() + " of type finish post is in level " + getLevel() + " and is  doing nothing";
        } else {
            return "Signal post " + getPostNumber() + " of type finish post is in level " + getLevel() + " and is  waving  " + getDepiction();
        }
    }

    @Override
    public int getPostNumber() {
        return super.getPostNumber();
    }

    @Override
    public void setPostNumber(int postNumber) {
        super.setPostNumber(postNumber);
    }

    @Override
    public String getDepiction() {
        return super.getDepiction();
    }

    @Override
    public void setDepiction(String depiction) {
        super.setDepiction(depiction);
    }

    @Override
    public int getLevel() {
        return super.getLevel();
    }

    @Override
    public void setLevel(int level) {
        super.setLevel(level);
    }
}
