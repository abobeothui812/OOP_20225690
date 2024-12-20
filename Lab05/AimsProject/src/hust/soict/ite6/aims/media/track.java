package Lab05.AimsProject.src.hust.soict.ite6.aims.media;

import Lab05.AimsProject.src.hust.soict.ite6.aims.exception.Playerexception;

public class track implements playable {
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
    public void play() throws Playerexception {
        if (this.getLength() <= 0) throw new Playerexception("DVD is not available.");
        else{
            System.out.println("Playing DVD: " + this.getTitle());
            System.out.println("DVD length: " + this.getLength());
        }
        
    }
    
    @Override
public boolean equals(Object obj) {
    if (this == obj) return true;

    if (!(obj instanceof track)) return false;

    track other = (track) obj;

    return this.title != null && this.title.equals(other.title) 
           && this.length == other.length;
}
}