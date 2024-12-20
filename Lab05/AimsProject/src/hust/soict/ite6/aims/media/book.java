package Lab05.AimsProject.src.hust.soict.ite6.aims.media;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NameNotFoundException;

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

    public void addAuthor(String authorName) throws Exception{
        if (authors.contains(authorName)){
            throw new Exception("Author is already in the list");
        }
        else{
            authors.add(authorName);
            System.out.println("Author added");
        }

    }

    public void removeAuthor(String authorName) throws NameNotFoundException{
        if (authors.contains(authorName)){
            authors.remove(authorName);
            System.out.println("Author removed");
        }
        else{
            throw new NameNotFoundException("Author not found");
        }
    }

    public String toString() {
        return "Book - " + getTitle() + " - " + getCategory() + " - " + getCost() + "$";
    }
}