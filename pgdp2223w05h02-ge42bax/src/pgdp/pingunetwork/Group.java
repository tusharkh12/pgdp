package pgdp.pingunetwork;


// TODO: Erweitere die Klasse entsprechend der Aufgabenstellung so, dass ein Bild für die Gruppe dargestellt werden kann.
public class Group {
    private User owner;
    private String name;
    private String description;
    private User[] members;
    private Picture picture;

    public Group(String name, String description, User owner, Picture picture) {
        this.name = name;
        this.description = description;
        this.owner = owner;
        this.picture = picture;

        members = new User[1];
        members[0] = owner;
    }

    /**
     * Fügt den übergebenen Nutzer in das 'members'-Array mit ein.
     *
     * @param user Ein beliebiges User-Objekt
     */
    public void addUser(User user) {
        User[] nMembers = new User[members.length + 1];

        for (int i = 0; i < members.length; i++) {
            if (members[i] == user) {
                return;
            }
            nMembers[i] = members[i];
        }
        nMembers[nMembers.length - 1] = user;
        members = nMembers;

    }

    /**
     * Entfernt das übergebene User-Objekt aus dem 'members'-Array.
     * Wenn der entfernte Nutzer der Gruppen-Admin war, wird diese Position
     * entsprechend auf den ersten im übrigen Array angepasst.
     * Wenn der übergebene Nutzer gar nicht in der Gruppe ist, geschieht nichts.
     *
     * @param user Ein beliebiges User-Objekt.
     */
    public void removeUser(User user) {
        boolean found = false;
        for (int i = 0; i < members.length; i++) {
            if (user == members[i]) {
                found = true;
            }

        }
        if (!found) {
            return;
        }
        if (members.length == 0) {
            members = new User[0];
            // User[] nMembers = new User[0];
            //  members
        } else if (members.length == 1) {
            //user = owner;
            // User[] nMembers= new User[0];
            if (user == owner) {
                owner = null;
                members = new User[0];
            }

        } else {
            User[] nMembers = new User[members.length - 1];

            for (int i = 0, k = 0; i < members.length; i++) {

                if (members[i] == user) {
                    //continue;
                } else {
                    nMembers[k++] = members[i];
                }
            }
            //System.out.println(Arrays.toString(nMembers));

            members = new User[nMembers.length];

            System.arraycopy(nMembers, 0, members, 0, nMembers.length);
            owner = members[0];
            //System.out.println(Arrays.toString(members));

        }
    }

    /* ================ Getter und Setter ================ */

    public User getOwner() {
        return owner;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public User[] getMembers() {
        return members;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setOwner(User owner) {
        for (int i = 0; i < members.length; i++) {
            if (members[i] == owner) {
                this.owner = owner;
                break;
            }
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

//    public static void main(String[] args) {
//        User bob = new User("Bob", "i code stuff",null);
//        Group bob_gang = new Group("zulip-chat", "more recycling symbols than on most bottles", bob, new Picture("Bayern", new int[][]{{0,0,0},{0,1,0},{0,0,0}}));
//        User alice = new User("Alice", "lol",null);
//        User joe = new User("Joe", "jell-o is tasty",null);
//        User joey = new User("Joe", "jell-o is tasty",null);
////
////        bob_gang.addUser(alice);
////        bob_gang.addUser(joe);
////        //bob_gang.addUser(joey);
//
//        System.out.println(bob);
//       // System.out.println(alice);
//
//        //System.out.println(joe);
//       // System.out.println(joey);
//       // System.out.println(bob_gang.members.length);
//
//        bob_gang.removeUser(bob);
//       // bob_gang.removeUser(joey);
//      //  System.out.println();
//
//
//    }
}
