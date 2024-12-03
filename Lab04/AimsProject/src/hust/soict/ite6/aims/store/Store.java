package hust.soict.ite6.aims.store;
import java.util.ArrayList;
import java.util.List;
import hust.soict.ite6.aims.media.media;

public class Store {
    private List<media> itemsInStore = new ArrayList<media>();

    public void addItemtoStore(media media){ {
        itemsInStore.add(media);
        System.out.println("The Item has been added");
    }
}

    

    public void removeItemfromStore(media media) {
        for( media item : itemsInStore) {
            if( itemsInStore.contains(item) ) {
                itemsInStore.remove(media);
                System.out.println("The DVD has been removed");
                return;
            }
        }
    }

    public void listItem() {
        for (media item : itemsInStore) {
            System.out.println(item.toString());
        }
    }

    public media search(String title){
            
            for (media item : itemsInStore) {
                if (item.getTitle().equals(title)) {
                    System.out.println(item.toString());
                    return item;
                }
            }
            System.out.println("The item is not in the store");
            return null;
    
    }

    
}

