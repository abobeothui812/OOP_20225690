package hust.soict.ite6.aims.media;
import java.util.Comparator;
public class MediaComparatorByTitleCost implements Comparator<media>{
    public int compare(media m1, media m2) {
        if (m1.getTitle().compareTo(m2.getTitle()) == 0) {
            return Double.compare(m1.getCost(), m2.getCost());
        }
        return m1.getTitle().compareTo(m2.getTitle());
    }
    
}
