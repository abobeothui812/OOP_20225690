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

    public float totalCost(){
        float total = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            total += itemOrdered[i].getCost();
        }
        return total;
    }
}
