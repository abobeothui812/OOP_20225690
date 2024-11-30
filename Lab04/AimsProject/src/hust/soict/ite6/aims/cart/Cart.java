

package hust.soict.ite6.aims.cart;
import hust.soict.ite6.aims.media.DigitalVideoDisc;
public class Cart {
    public static int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    public int qtyOrdered=0;
    
    public void addDigitalVideoDisc(DigitalVideoDisc disc){
        if(qtyOrdered < MAX_NUMBERS_ORDERED){
            itemOrdered[qtyOrdered++] = disc;
            System.out.println("The disc has been added");
        }
        if(qtyOrdered == MAX_NUMBERS_ORDERED){
            System.out.println("The cart is almost full");
        }
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc){
        if(qtyOrdered > 0){
            for (int i = 0; i < qtyOrdered; i++) {
                if (itemOrdered[i].equals(disc)) {
                    itemOrdered[i] = itemOrdered[qtyOrdered - 1]; // Đưa phần tử cuối vào vị trí đã xóa
                    itemOrdered[qtyOrdered - 1] = null; // Xóa phần tử cuối
                    qtyOrdered--;
                    
                }
            }
            
        }
        System.out.println("The disc has been removed");
    }

    public void addDigitalVideoDisc(DigitalVideoDisc disc[]){
        if(qtyOrdered < MAX_NUMBERS_ORDERED){
            for (int i = 0; i < disc.length; i++) {
                itemOrdered[qtyOrdered++] = disc[i];
            }
            System.out.println("The disc has been added");
        }
        if(qtyOrdered == MAX_NUMBERS_ORDERED){
            System.out.println("The cart is almost full");
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc dvd1 , DigitalVideoDisc dvd2){
        if(qtyOrdered < MAX_NUMBERS_ORDERED){
            itemOrdered[qtyOrdered++] = dvd1;
            itemOrdered[qtyOrdered++] = dvd2;
            System.out.println("The disc has been added");
        }
        if(qtyOrdered == MAX_NUMBERS_ORDERED){
            System.out.println("The cart is almost full");
        }
    }



    public float totalCost(){
        float total = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            total += itemOrdered[i].getCost();
        }
        return total;
    }

    public void print() {
        System.out.println("*************************** Cart *************************************");
        for(int i = 0; i < qtyOrdered; i++) {
            System.out.println("DVD -" + itemOrdered[i].getTitle() + " -" + itemOrdered[i].getCategory() + " -" + itemOrdered[i].getDirector() + " -" + itemOrdered[i].getLength() + ": " + itemOrdered[i].getCost() + "$");
        }

        System.out.println("Total cost: " + totalCost());
        System.out.println("**********************************************************************");
    }

    public void search(int id){
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemOrdered[i].getId() == id) {
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

}
