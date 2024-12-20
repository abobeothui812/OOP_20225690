package Lab05.AimsProject.src.hust.soict.ite6.aims.media;

public abstract class disc extends media {
    private String director;
    private int length;
    public String getDirector() {
        return director;
    }
    public void setDirector(String director) {
        this.director = director;
    }
    public void setLength(int length) {
        this.length = length;
    }
    public int getLength() {
        return length;
    }
    public disc(String title, String category, String director, float cost, int length) { 
        setTitle(title);
        setCategory(category);
        setCost(cost);
        this.director = director;
        this.length = length;
    }
    public disc(){
        
    }
}
