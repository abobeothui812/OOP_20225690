package hust.soict.ite6.aims.media;

public class track {
    private String title;
    private int length;
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }

    public track(String title, int length) {
        this.title = title;
        this.length = length;
    }
}
