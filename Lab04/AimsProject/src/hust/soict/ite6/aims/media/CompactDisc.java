package hust.soict.ite6.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends disc implements playable {
    private String artist;
    private List<track> tracks = new ArrayList<track>();
    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public CompactDisc(String title, String category, String director, float cost, String artist) {
        super(title, category, director, cost, 0);
        this.artist = artist;
    }

    public void addTrack(track t) {
        if(tracks.contains(t)) {
            System.out.println("Track is already in the list");
        } else {
            tracks.add(t);
            System.out.println("Track has been added");
        }
    }
    
    public void removeTrack(track t) {
        if(tracks.contains(t)) {
            tracks.remove(t);
            System.out.println("Track has been removed");
        } else {
            System.out.println("Track is not in the list");
        }
    }

    public int getLength(){
        int length = 0;
        for (track track : tracks) {
            length += track.getLength();
        }
        return length;
    }

    public void play() {
        System.out.println("Playing CD: " + this.getTitle());
        System.out.println("CD length: " + this.getLength());
        for (track track : tracks) {
            track.play();
        }
    }
}
