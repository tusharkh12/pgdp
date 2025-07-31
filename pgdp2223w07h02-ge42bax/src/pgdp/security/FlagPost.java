package pgdp.security;

public class FlagPost extends SignalPost {
    /**
     * Diese Klasse ist nur da, damit keine Buildfails entstehen. Allerdings ist sie
     * bei Weitem noch nicht vollständig.
     *
     * @param postNumber
     */
    public FlagPost(int postNumber) {
        super(postNumber);
    }

    @Override
    public boolean up(String type) {

        if (type == "green" && getDepiction()!="blue") {
            if (getLevel() <= 0) {
                setDepiction("green");
                setLevel(1);
                return true;
            }
            return false;
        } else if (type == "blue"&& getDepiction()!="green") {
            if (getLevel() <= 0) {
                setDepiction("blue");
                setLevel(1);
                return true;
            }
            return false;
        } else if (type == "blue" && getDepiction().equals("green") || type == "green" && getDepiction().equals("blue")) {
            if (getLevel() == 1) {
                setDepiction("green/blue");
                setLevel(1);
                return true;
            }
            return false;
        } else if (type == "yellow") {
            if (getLevel() <= 1) {
                setDepiction("yellow");
                setLevel(2);
                return true;
            }
            return false;
        } else if (type == "doubleYellow") {
            if (getLevel() <= 2) {
                setDepiction("doubleYellow");
                setLevel(3);
                return true;
            }
            return false;
        } else if (type == "[SC]") {
            if (getLevel() <= 3) {
                setDepiction("[SC]");
                setLevel(3);
                return true;
            }
            return false;
        } else if (type == "red") {
            if (getLevel() <= 3) {
                setDepiction("red");
                setLevel(4);
                return true;
            }
            return false;
        } else if (type == "end") {
            if (getLevel() <= 4) {
                setDepiction("green/yellow/red/blue");
                setLevel(5);
                return true;
            }
            return false;
        }
        return false;
    }

    @Override
    public boolean down(String type) {
        if (type == "clear") {
            if (getLevel() != 0) {
                setDepiction("");
                setLevel(0);
                return true;
            }
        } else if (type == "green") {
            if (getDepiction().equals("green")) {
                setDepiction("");
                setLevel(0);
                return true;
            } else if (getDepiction().equals("green/blue")) {
                setDepiction("blue");
                setLevel(1);
                return true;
            }
            return false;
        } else if (type == "blue") {
            if (getDepiction().equals("blue")) {
                setDepiction("");
                setLevel(0);
                return true;
            } else if (getDepiction().equals("green/blue")) {
                setDepiction("green");
                setLevel(1);
                return true;
            }
            return false;
        } else if (type == "danger") {
            if (getLevel() <= 4 && getLevel() >= 2) {
                setDepiction("green");
                setLevel(1);
                return true;
            }
            return false;
        }
        return false;
    }


    public String toString() {

        if (getLevel() == 0) {
            return "Signal post " + getPostNumber() + " of type  flag post  is in level " + getLevel() + " and is  doing nothing";
        } else {
            return "Signal post " + getPostNumber() + " of type  flag post  is in level " + getLevel() + " and is  waving  " + getDepiction();
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
