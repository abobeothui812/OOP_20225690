

package OtherProjects.Lab04.AimsProject.src.hust.soict.ite6.aims.cart;
import java.util.ArrayList;
import java.util.List;

import OtherProjects.Lab04.AimsProject.src.hust.soict.ite6.aims.media.media;
public class Cart {
    public static int MAX_NUMBERS_ORDERED = 20;
    public int numberOfItemsInCart = 0;
    public List<media> itemsOrdered = new ArrayList<media>();
    
    public void addItemtoCart(media media){
        if(itemsOrdered.size() < MAX_NUMBERS_ORDERED){
            itemsOrdered.add(media);
            System.out.println("The Item has been added");
            numberOfItemsInCart++;
        }
        if(itemsOrdered.size() == MAX_NUMBERS_ORDERED){
            System.out.println("The Cart is almost full");
        }
    }

    public void removeItemtoCart(media media){
        if(itemsOrdered.size() > 0){
            for (int i = 0; i < itemsOrdered.size(); i++) {
                if (itemsOrdered.contains(media)) {
                    itemsOrdered.remove(media);
                    System.out.println("The disc has been removed");
                    return;
                }
            }
            
        }
        System.out.println("The disc has been removed");
    }

    

    public void addItemtoCart(media media1 , media media2){
        if(itemsOrdered.size() < MAX_NUMBERS_ORDERED){
            itemsOrdered.add(media1);
            itemsOrdered.add(media2);
            System.out.println("Two item has been added");
        }
        if(itemsOrdered.size() == MAX_NUMBERS_ORDERED){
            System.out.println("The cart is almost full");
        }
    }



    public float totalCost(){
        float total = 0;
        for (media item : itemsOrdered) {
            total += item.getCost();
        }
        return total;
    }

    public void listItem() {
        for (media item : itemsOrdered) {
            System.out.println(item.toString());
        }
    }
    /* 
    public void print() {
        System.out.println("*************************** Cart *************************************");
        for(media item : itemsOrdered){ {
            System.out.println("DVD -" + item.getTitle() + " -" + item.getCategory() + " -" + {item.getDirector() =! "" ? item.getDirector() : "Unknown"} + " -" + item.getLength() + ": " + item.getCost() + "$");
        }

        System.out.println("Total cost: " + totalCost());
        System.out.println("**********************************************************************");
    }*/

    public media search(String title){
            
        for (media item : itemsOrdered) {
            if (item.getTitle().equals(title)) {
                System.out.println(item.toString());
                return item;
            }
        }
        System.out.println("The item is not in the store");
        return null;
    }

        public media search(int id){  
            for (media item : itemsOrdered) {
                if (item.getId()==id) {
                    System.out.println(item.toString());
                    return item;
                }
            }
            System.out.println("The item is not in the store");
            return null;
        }
    
}
