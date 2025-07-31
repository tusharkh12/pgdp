package pgdp.security;

import java.util.Arrays;

public class Track {
    private SignalPost[] posts;
    private int postNumber;

    public Track(int postNumber) {
        this.postNumber = postNumber;
        if (postNumber <= 0) {
            posts = new SignalPost[10];
        } else {
            posts = new SignalPost[postNumber];
        }
        for (int i = 0; i < posts.length; i++) {
            this.postNumber = i;
            if (i == 0 &&posts.length>1 || i % 3 == 0 && i != posts.length - 1) {
                posts[i] = new LightPanel(i);
            } else if (i == posts.length - 1) {
                posts[i] = new FinishPost(i);
            } else {
                posts[i] = new FlagPost(i);
            }
        }
        //System.out.println(Arrays.toString(posts));

    }

    public void setAll(String type, boolean up) {
        if (up) {
            for (int i = 0; i < posts.length; i++) {
                posts[i].up(type);
            }
        } else {
            for (int i = 0; i < posts.length; i++) {
                posts[i].down(type);
            }
        }
    }

    public void setRange(String type, boolean up, int start, int end) {
        if (start >= posts.length) {
            start = 0;
        }
        if (up) {
            for (int i = start; i < posts.length; i++) {
                if (i == end) {
                    posts[i].up(type);
                    break;
                }
                posts[i].up(type);
                if (i == posts.length - 1) {
                    i = -1;
                    // start = -1;
                }
                // System.out.println(Arrays.toString(posts));
            }
        } else {
            for (int i = start; i < posts.length; i++) {
                if (i == end) {
                    posts[i].down(type);
                    break;
                }
                posts[i].down(type);
                if (i == posts.length - 1) {
                    i = -1;
                    //  start = -1;
                }
            }
        }
    }

    public void createHazardAt(int start, int end) {
        if (start >= posts.length) {
            start = 0;
        }

        for (int i = start; i < posts.length; i++) {
            if (i == end) {
                posts[i].up("green");
                break;
            }
            posts[i].up("yellow");
            if (i == posts.length - 1) {
                i = -1;
                // start = 0;
            }
        }
    }

    public void removeHazardAt(int start, int end) {
        if (start >= posts.length) {
            start = 0;
        }
        for (int i = start; i < posts.length; i++) {
            if (i == end) {
                posts[i].down("danger");
                break;
            }
            posts[i].down("danger");
            if (i == posts.length - 1) {
                i = -1;
            }
        }
    }

    public void createLappedCarAt(int post) {
        int i = 0;
        if (post >= posts.length) {
            post = 0;
        }
        while (i < 4) {
            posts[post].up("blue");
            post++;
            if (post > posts.length - 1) {
                post = 0;

            }
            //System.out.println(post);

            i++;
        }
    }

    public void removeLappedCarAt(int post) {
        int i = 0;

        if (post >= posts.length) {
            post = 0;
        }
        while (i < 4) {
            posts[post].down("blue");
            // System.out.println(i);
            post++;
            if (post > posts.length - 1) {
                post = 0;

            }
            i++;
        }
    }

    public void printStatus() {
        for (int i = 0; i < posts.length; i++) {
            System.out.print(posts[i].toString()+"\n");

        }
        System.out.println();
    }


    public void setPosts(SignalPost[] posts) {
        this.posts = posts;
    }

    public SignalPost[] getPosts() {
        return this.posts;
    }


    public int getPostNumber() {
        return postNumber;
    }

    public void setPostNumber(int postNumber) {
        this.postNumber = postNumber;
    }

    public static void main(String[] args) {
        Track track = new Track(10);
        // System.out.println(Arrays.toString(track.getPosts()));
        track.setRange("green", true, 1, 5);

    }
}
