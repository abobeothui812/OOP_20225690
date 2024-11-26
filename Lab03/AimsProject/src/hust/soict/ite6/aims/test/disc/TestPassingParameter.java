package hust.soict.ite6.aims.test.disc;
import hust.soict.ite6.aims.disc.DigitalVideoDisc;

public class TestPassingParameter {
    public static void main(String[] args) {
        // Tạo hai đối tượng DigitalVideoDisc
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");

        // Gọi hàm swap để đổi chỗ hai đối tượng (sẽ không có hiệu lực)
        Rightswap(jungleDVD, cinderellaDVD);
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());

        // Gọi hàm changeTitle để thay đổi tiêu đề của jungleDVD
        changeTitle(jungleDVD, cinderellaDVD.getTitle());
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
    }

    // Hàm swap: Thực hiện đổi chỗ hai đối tượng (nhưng không hiệu quả trong Java)
    public static void Rightswap(DigitalVideoDisc Dvd1, DigitalVideoDisc Dvd2) {
        DigitalVideoDisc tmp = new DigitalVideoDisc(Dvd1.getTitle(), Dvd1.getCategory(), Dvd1.getDirector(), Dvd1.getLength(), Dvd1.getCost());
        
        Dvd1.setTitle(Dvd2.getTitle());
        Dvd1.setCategory(Dvd2.getCategory());
        Dvd1.setDirector(Dvd2.getDirector());
        Dvd1.setLength(Dvd2.getLength());
        Dvd1.setCost(Dvd2.getCost());

        Dvd2.setTitle(tmp.getTitle());
        Dvd2.setCategory(tmp.getCategory());
        Dvd2.setDirector(tmp.getDirector());
        Dvd2.setLength(tmp.getLength());
        Dvd2.setCost(tmp.getCost());
        
    }

    public static void swap(Object o1, Object o2) {
        Object tmp = o1;
        o1 = o2;
        o2 = tmp;
    }

    // Hàm changeTitle: Thay đổi tiêu đề của một DigitalVideoDisc
    public static void changeTitle(DigitalVideoDisc dvd, String title) {
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);
        // Tạo một đối tượng mới, nhưng không gán lại cho dvd
        dvd = new DigitalVideoDisc(oldTitle);
    }
}