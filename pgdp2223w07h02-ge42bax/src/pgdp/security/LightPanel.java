package pgdp.security;

public class LightPanel extends SignalPost {
    /**
     * Diese Klasse ist nur da, damit keine Buildfails entstehen. Allerdings ist sie
     * bei Weitem noch nicht vollständig.
     *
     * @param postNumber
     */
    public LightPanel(int postNumber) {
        super(postNumber);
    }

    @Override
    public boolean up(String type) {

        if (type == "green") {
            if (getLevel() <= 0) {
                setDepiction("green");
                setLevel(1);
                return true;
            }
            return false;
        } else if (type == "blue") {
            if (getLevel() <= 1) {
                setDepiction("blue");
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
                setDepiction("yellow");
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
            if(getLevel()!=0) {
                setDepiction("");
                setLevel(0);
                return true;
            }
        } else if (type == "green") {
            if (getDepiction().equals("green")) {
                setDepiction("");
                setLevel(0);
                return true;
            }
            return false;
        } else if (type == "blue") {
            if (getDepiction().equals("blue")) {
                setDepiction("");
                setLevel(0);
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

    @Override
    public String toString() {

        if (getLevel() == 0) {
            return "Signal post " + getPostNumber() + " of type light panel is in level " + getLevel() + " and is switched off";
        } else {
            return "Signal post " + getPostNumber() + " of type light panel is in level " + getLevel() + " and is blinking " + getDepiction();
        }
        // return null;
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
