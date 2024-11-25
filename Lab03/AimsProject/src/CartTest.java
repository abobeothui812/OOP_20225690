import java.util.Scanner;

public class CartTest {
    public static void main(String[] args) {
        // Tạo một giỏ hàng mới
        Cart cart = new Cart();
        try (Scanner sc = new Scanner(System.in)) {
            // Tạo các đối tượng DVD mới và thêm vào giỏ hàng
            DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
                                                       "Animation",
                                                       "Roger Allers",
                                                       87,
                                                       19.95f);
            cart.addDigitalVideoDisc(dvd1);

            DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
                                                       "Science Fiction",
                                                       "George Lucas",
                                                       87,
                                                       24.95f);
            cart.addDigitalVideoDisc(dvd2);

            DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin",
                                                       "Animation",
                                                       18.99f);
            cart.addDigitalVideoDisc(dvd3);

            // Kiểm tra phương thức in
            cart.print();

            System.out.println("Enter the DVD you want to search (By title:)");
            String searchedTitle = sc.nextLine();
            cart.search(searchedTitle);

            System.out.println("Enter the DVD you want to search (By id: )");
            int searchedId = sc.nextInt();
            cart.search(searchedId);
        }
        
    }

    
}