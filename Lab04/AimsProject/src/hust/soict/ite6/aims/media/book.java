package hust.soict.ite6.aims.media;
import java.util.ArrayList;
import java.util.List;

public class book extends media {
    
    private List<String> authors = new ArrayList<String>();
    private static int nbBooks = 0;
    public List<String> getAuthors() {
        return authors;
    }
    

    public book( String title, String category, float cost) {
        setTitle(title);
        setCategory(category);
        setCost(cost);
        setId(nbBooks++);
    }

    public void addAuthor(String authorName){
        if (authors.contains(authorName)){
            System.out.println("Author is already in the list");
        }
        else{
            authors.add(authorName);
            System.out.println("Author added");
        }

    }

    public void removeAuthor(String authorName){
        if (authors.contains(authorName)){
            authors.remove(authorName);
            System.out.println("Author removed");
        }
        else{
            System.out.println("Author is not in the list");
        }
    }

    public String toString() {
        return "Book - " + getTitle() + " - " + getCategory() + " - " + getCost() + "$";
    }
}