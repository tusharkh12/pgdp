package pgdp.messenger;



public class UserArray {
    private int initCapacity;
    private User[] users;

    //private Us
//	private PinguTalk pinguTalk;
//	private User user;
    // TODO: Implementiere die fehlenden Attribute

    public UserArray(int initCapacity) {
        this.initCapacity = initCapacity;
        if (initCapacity >= 1) {
            this.users = new User[initCapacity];

        } else {
            this.users = new User[1];
        }

        //users[0]= user;
        // TODO: Implementiere den Konstruktor
    }

    /**
     * Fügt den übergebenen Nutzer in das durch dieses Objekt dargestellte 'UserArray' ein
     *
     * @param user Eine beliebige User-Referenz (schließt 'null' mit ein)
     */
    public void addUser(User user) {

        if (user == null) {
            // users=users;
            return;
        }
       // boolean found = false;

      //  User[] nUsers = new User[users.length];
       // System.arraycopy(users, 0, nUsers, 0, users.length);

        for (int i = 0; i < users.length; i++) {
            if (users[i] == null) {
                users[i] = user;
              //  found = true;
                return;
            }
        }


           User[] nUsers = new User[2 * users.length];
            System.arraycopy(users, 0, nUsers, 0, users.length);
            nUsers[users.length] = user;
            users = nUsers;
//         users = new User[nUsers.length];
//         System.arraycopy(nUsers, 0, users, 0, nUsers.length);
        // TODO: Implementiere diese Methode!
    }

    /**
     * Entfernt den Nutzer mit der übergebenen ID aus dem Array und gibt diesen zurück.
     * Wenn kein solcher Nutzer existiert, wird 'null' zurückgegeben.
     *
     * @param id Ein beliebiger long
     * @return Der eben aus dem UserArray entfernte Nutzer, wenn ein Nutzer mit der übergebenen id darin existiert, sonst 'null'
     */
    public User deleteUser(long id) {
        int count = 0;
        for (int i = 0; i < users.length; i++) {
            if (users[i] == null) {
                count++;
            }

        }
        if (count == users.length) {
            return null;
        }


        // CHECK AFTERWARDS
        for (int i = 0; i < users.length; i++) {
            if(users[i]!=null) {
                if (users[i].getId() == id) {
                    //  user=new User(users[i].getId(),users[i].getName(),users[i].getSupervisor());
                    User user = users[i];
                    users[i] = null;
                    return user;
                    //return null;
                }
            }

        }
        return null;

    }

    public int size() {
        int count = 0;
//        if (users == null) {
//            return 0;
//        }
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null) {
                count++;
            }
        }
        return count;
    }

    public int getInitCapacity() {
        return initCapacity;
    }

    public void setInitCapacity(int initCapacity) {
        this.initCapacity = initCapacity;
    }

    public User[] getUsers() {
        return users;
    }

    public void setUsers(User[] users) {
//		if(users.length==0){
//			this.users=new User[0];
//		}else {
        this.users = users;
        //}
    }




    // TODO: Implementiere die fehlenden Methoden!
}
