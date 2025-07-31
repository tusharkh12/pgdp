package pgdp.pingunetwork;

public class Picture {
    private String location;
    private int width;
    private int height;
    private int[][] data;

    private Picture[] thumbnails;
    private Group group;
    private User user ;

    public Picture(String location, int[][] data) {
        this.location = location;
        this.data = data;


        if(data.length==0){
            this.height=0;
            this.width=0;
        }else {
            this.height = data.length;
            this.width = data[0].length;
        }
        thumbnails = new Picture[0];


    }

//    public void setLocation(String location) {
//        this.location = location;
//    }
//
//    public void setWidth(int width) {
//        this.width = width;
//    }
//
//    public void setHeight(int height) {
//        this.height = height;
//    }
//
//    public void setData(int[][] data) {
//        this.data = data;
//    }

    public String getLocation() {
        return location;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int[][] getData() {
        return data;
    }

    public Picture[] getThumbnails() {
        return thumbnails;
    }

    public void setThumbnails(Picture[] thumbnails) {
        this.thumbnails = thumbnails;
    }

}
