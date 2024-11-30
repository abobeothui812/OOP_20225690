package hust.soict.ite6.aims.media;
public class DigitalVideoDisc extends disc {
    private static int nbDigitalVideoDiscs = 0;

    public DigitalVideoDisc(String title, String category, float cost ){
        super(title, category, "Unknown", 0, 0);
        setId(nbDigitalVideoDiscs++);
    }

    public DigitalVideoDisc(String title, String category, String director, float cost, int length){
        super(director, category, director, cost, length);
        setId(nbDigitalVideoDiscs++);
    }   

    public DigitalVideoDisc(String title, String category, float cost, String director){
        super(title, category, director, cost, 0);
        setId(nbDigitalVideoDiscs++);
    }   
    public DigitalVideoDisc(String title){
        super("Unknown", "Unknown", "Unknown", 0, 0);
        setTitle(title);
        setId(nbDigitalVideoDiscs++);
        

    }
    public boolean isMatch(String title){
        return getTitle().equals(title);
    }
}
