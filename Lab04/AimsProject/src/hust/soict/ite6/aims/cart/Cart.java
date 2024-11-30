

package hust.soict.ite6.aims.cart;
import java.util.ArrayList;
import java.util.List;

import hust.soict.ite6.aims.media.media;
public class Cart {
    public static int MAX_NUMBERS_ORDERED = 20;
   
    private List<media> itemsOrdered = new ArrayList<media>();
    
    public void addItemtoCart(media media){
        if(itemsOrdered.size() < MAX_NUMBERS_ORDERED){
            itemsOrdered.add(media);
            System.out.println("The Item has been added");
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

    /* 
    public void print() {
        System.out.println("*************************** Cart *************************************");
        for(media item : itemsOrdered){ {
            System.out.println("DVD -" + item.getTitle() + " -" + item.getCategory() + " -" + {item.getDirector() =! "" ? item.getDirector() : "Unknown"} + " -" + item.getLength() + ": " + item.getCost() + "$");
        }

        System.out.println("Total cost: " + totalCost());
        System.out.println("**********************************************************************");
    }

    public void search(int id){
        for (int i = 0; i < qtyOrdered; i++) {
            if (item.getId() == id) {
                System.out.println("DVD -" + itemOrdered[i].getTitle() + " -" + itemOrdered[i].getCategory() + " -" + itemOrdered[i].getDirector() + " -" + itemOrdered[i].getLength() + ": " + itemOrdered[i].getCost() + "$");
                return;
            }
        }
        System.out.println("DVD not found");
    }

    public void search(String title){
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemOrdered[i].isMatch(title)) {
                System.out.println("DVD -" + itemOrdered[i].getTitle() + " -" + itemOrdered[i].getCategory() + " -" + itemOrdered[i].getDirector() + " -" + itemOrdered[i].getLength() + ": " + itemOrdered[i].getCost() + "$");
                return;
            }
        }
        System.out.println("DVD not found");
    }
    */
}
