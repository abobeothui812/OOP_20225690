package hust.soict.ite6.aims.test.media;

import java.util.ArrayList;
import java.util.Collections;

import hust.soict.ite6.aims.media.CompactDisc;
import hust.soict.ite6.aims.media.DigitalVideoDisc;
import hust.soict.ite6.aims.media.book;
import hust.soict.ite6.aims.media.media;

public class mediaTest {
    public static void main(String[] args) {
        
        ArrayList<media> mediaList = new ArrayList<media>();

        
        mediaList.add(new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 24.95f, 124));
        mediaList.add(new CompactDisc("Greatest Hits", "Music","Michael Jackson",12, "Michael Jackson"));
        mediaList.add(new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 19.95f, 87));
        mediaList.add(new book("Java Programming", "Education", 500));

       

        Collections.sort(mediaList,media.COMPARE_BY_COST_TITLE);
        for (media media : mediaList) {
            System.out.println(media.toString());
        }
        System.out.println("-------------------------------------------------");
        Collections.sort(mediaList,media.COMPARE_BY_TITLE_COST);
        for (media media : mediaList) {
            System.out.println(media.toString());
        }


    }
}
