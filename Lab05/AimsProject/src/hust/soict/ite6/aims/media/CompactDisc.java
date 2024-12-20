package Lab05.AimsProject.src.hust.soict.ite6.aims.media;

import java.util.ArrayList;
import java.util.List;

import javax.naming.NameNotFoundException;

import Lab05.AimsProject.src.hust.soict.ite6.aims.exception.Playerexception;

public class CompactDisc extends disc implements playable {
    private String artist;
    private List<track> tracks = new ArrayList<track>();
    private static int nbCD = 0;
    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public CompactDisc(String title, String category, String director, float cost, String artist) {
        super(title, category, director, cost, 0);
        this.artist = artist;
        setId(nbCD++);
    }

    public void addTrack(track t) throws DuplicateTrackException {
        if(tracks.contains(t)) {
            throw new DuplicateTrackException("Track is already in the list");
        } else {
            tracks.add(t);
            System.out.println("Track has been added");
        }
    }
    
    public void removeTrack(track t) throws NameNotFoundException {
        if(tracks.contains(t)) {
            tracks.remove(t);
            System.out.println("Track has been removed");
        } else {
            throw new NameNotFoundException("Track not found");
        }
    }

    public int getLength(){
        int length = 0;
        for (track track : tracks) {
            length += track.getLength();
        }
        return length;
    }

    public void play() throws Playerexception {
        if (this.getLength() <= 0) throw new Playerexception("CD is not available.");
        else{
            java.util.Iterator<track> iter = tracks.iterator();
            track neTrack;
            while (iter.hasNext()) {
                neTrack = iter.next();
               try {
                   neTrack.play();
               } catch (Playerexception e) {
                    throw new Playerexception(e.getMessage());
               }
            }
        }
    }

    public String toString() {
        return "CompactDisc - " + getTitle() + " - " + getCategory() + " - " + getArtist() + " - " + getCost() + "$";
    }

    public class DuplicateTrackException extends Exception {
        public DuplicateTrackException(String message) {
            super(message);
        }
    }
}
