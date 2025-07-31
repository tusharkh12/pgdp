package pgdp.messenger;



public class PinguTalk {
    private static long topicID=0;
    private static long userID=0;
    private UserArray members;
    private Topic[] topics;

     public PinguTalk(int users,int topicsLength){
//        PinguTalk.topicID = topicID;
//        PinguTalk.userID = userID;
        if(users >1) {
            this.members = new UserArray(users);
        }else {
            this.members=new UserArray(1);
        }

        if(topicsLength >1){
        this.topics = new Topic[topicsLength];
        }else{
            this.topics=new Topic[1];
        }

    }


    public User addMember(String name, User supervisor) {
       // User user1;

//            if (user == null) {
//                members.addUser(null);
//                userID++;
//                return null;
//            }
//        if(user==null) {
//            return null;
//        }

           User user1 = new User(userID, name, supervisor);
            members.addUser(user1);
            userID++;
            return user1;
//        }
//        members.addUser(null);
//        userID++;
//        return null;



    }

    public User deleteMember(long userID) {
//        boolean notFound=false;
//
//        for (int i = 0; i < members.getUsers().length ; i++) {
//            if(i==userID){
//                notFound=true;
//            }
//
//        }
//        if(!notFound || userID>=members.size()){
//            return null;
//        }
        User user= members.deleteUser(userID);
        members.deleteUser(userID);

        return user;
    }

    public Topic createNewTopic(String name){
        Topic topic =new Topic(topicID,name);

         //   int count =0;
//            for (int i = 0; i < topics.length; i++) {
//                if (topics[i].getId() == topicID && topics[i].getName().equals(name)) {
//                    return null;
//                }
//
//            }

            for (int i = 0; i < topics.length; i++) {
                if (topics[i] == null) {
                    topics[i]=topic;
                   topicID++;
//                    if (i == topics.length - 1) {
//
//                        Topic[] temp=new Topic[topics.length+1];
//                        System.arraycopy(topics,0,temp,0,temp.length);
//                        topics=new Topic[temp.length];
//                        System.arraycopy(temp,0,topics,0,topics.length);
//                    }
                   return topic;
                }

            }
            return null;

        }



    public Topic deleteTopic(long ID){
//      //  boolean isNotFound=false;
//        Topic topic;
//        for (int i = 0; i < topics.length ; i++) {
//
//            if(topics[i].getId()!=topicID){
//                isNotFound=true;
//            }
//
//        }
//        if(!isNotFound){
//            return null;
//        }
        for (int i = 0; i < topics.length ; i++) {
            if(topics[i]!=null) {
                if (topics[i].getId() ==ID) {
                    Topic topic =topics[i];
                   // topic=
                    topics[i] = null;
                    return topic;
                }
            }

        }
        return null;

    }


    public UserArray getMembers() {
        return members;
    }

    public void setMembers(UserArray members) {
        this.members = members;
    }

    public Topic[] getTopics() {
        return topics;
    }

    public void setTopics(Topic[] topics) {
        this.topics = topics;
    }




// TODO: Implementiere die fehlenden Attribute

    // TODO: Implementiere den fehlenden Konstruktor

    // TODO: Implementiere die fehlenden Methoden
}
