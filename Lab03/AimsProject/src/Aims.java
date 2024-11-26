import hust.soict.ite6.aims.cart.Cart;
import hust.soict.ite6.aims.disc.DigitalVideoDisc;

public class Aims {
    public static void main(String[] args) {
        Cart anOrder = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King","Animation", "Roger Allers", 87, 19.95f);
        anOrder.addDigitalVideoDisc(dvd1); 


        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars","Science Fiction", "George Lucas", 87, 24.95f);
        anOrder.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", 18.99f);
        anOrder.addDigitalVideoDisc(dvd3);

        anOrder.removeDigitalVideoDisc(dvd3);

        // In tổng giá trị của các mặt hàng trong giỏ hàng
        System.out.println("Tong gia tri la: ");
        System.out.println(anOrder.totalCost());
        
    }
}
