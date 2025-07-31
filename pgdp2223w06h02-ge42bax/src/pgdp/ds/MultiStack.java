package pgdp.ds;

public class MultiStack {

    private final Stack stacks;
    private Stack next;
    // private boolean full;

    public MultiStack() {
        stacks = new Stack(1);
    }

    // TODO implement missing methods
    public boolean isFull() {

//        if(!firstTime) {
//           //  next = stacks;
//             firstTime=true;
//        }
        //boolean full=false;
        if (next.getTop() == (next.getMem().length - 1)) {
            if (next.getNext() == null) {
                Stack temp = new Stack(next.getMem().length * 2);
                temp.setTop(-1);
                next.setNext(temp);
                // next=next.getNext();


                // full=true;
                return false;
            }
            next = next.getNext();
            isFull();
        }
        // return;

        return false;
    }


    public void helperPush(int value) {
        if (isFull()) {
            //next=isFull(next);
            //Stack full = new Stac
            // k(temp.getMem().length * 2);
            // temp.setNext(full);
            //  temp=temp.getNext();
            //stacks.getNext();
            // temp.setTop(-1);
            // temp=next;
            //next=next.getNext();
//            if (next.getTop() == (next.getMem().length - 1)) {
//                next = stacks.getNext();
//                helperPush(value);
//            }
            next.setTop(next.getTop() + 1);
            //temp=stacks;
            next.getMem()[next.getTop()] = value;
            //full=false;
            return;
        }

        if (next.getTop() == (next.getMem().length - 1)) {
            next = stacks.getNext();
            //stacks=stacks.getNext();
        } else {
            if (next != null) {
                next.setTop(next.getTop() + 1);
                next.getMem()[next.getTop()] = value;
                //   temp=next;
                return;
            }

        }
        helperPush(value);
    }

    public void push(int value) {
        next = stacks;
        helperPush(value);

        //  push(value);

//        if (stacks.getTop() < stacks.getMem().length - 1) {
//            stacks.setTop(stacks.getTop() + 1);
//            stacks.getMem()[stacks.getTop()] = value;
//
//
//        } else {


    }

    public int helperTop(Stack temp) {
        // int value=0;
        if ( temp.getNext() != null){
            temp = temp.getNext();
           return helperTop(temp);
        }

        return temp.getMem()[temp.getTop()];


    }

    public int top() {
        if ( stacks.getNext() == null) {
            if (stacks.getTop() == -1)
                return Integer.MIN_VALUE;
        }
        if(stacks==null){
            return Integer.MIN_VALUE;
        }
        // next=stacks;
        Stack temp = stacks;
        return helperTop(temp);

    }

    public int helperPop(Stack temp) {
        int value = 0;
        if (temp.getTop() == temp.getMem().length - 1 && temp.getNext() != null) {
            temp = temp.getNext();
         return    helperPop(temp);
        }
        value = temp.getMem()[temp.getTop()];
       // temp.getMem()[temp.getTop()]=0;
        temp.setTop(temp.getTop() - 1);
       // System.out.println(temp.getTop());
        if(temp.getTop()==-1){
            Stack toRemove =stacks;
            removeStack(toRemove);
        }
        return value;

    }

    public void removeStack(Stack toRemove){
        if(toRemove.getNext().getTop()==-1){
            toRemove.setNext(null);
            return;
        }
        toRemove=toRemove.getNext();
        removeStack(toRemove);

    }

    public int pop() {
        if(stacks==null){
            return Integer.MIN_VALUE;
        }
        if (stacks.getNext() == null) {
            if (stacks.getTop() != -1) {
                stacks.setTop(-1);
                int a=stacks.getMem()[stacks.getTop() + 1];
               // stacks.getMem()[stacks.getTop()+1]=0;
                return a;

            }
            else {
                return Integer.MIN_VALUE;
            }
        }


        Stack temp = stacks;
        return helperPop(temp);
    }

    @Override
    public String toString() {
        return stacks.toString();
    }

    public static void main(String[] args) {
        MultiStack stack=new MultiStack();
        stack.push(1);
        stack.push(11);
       // stack.push(111);
       int qa= stack.pop();

        System.out.println(stack);
        System.out.println(qa);

    }

}
