package hust.soict.ite6.aims.test.store;
import hust.soict.ite6.aims.disc.DigitalVideoDisc;
import hust.soict.ite6.aims.store.Store;

public class StoreTest {
    public static void main(String[] args) {
        Store DvDstore = new Store();

    DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
                                                       "Animation",
                                                       "Roger Allers",
                                                       87,
                                                       19.95f);
    
    DvDstore.addDVD(dvd1);
    

    DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
                                                       "Science Fiction",
                                                       "George Lucas",
                                                       87,
                                                       24.95f);
    DvDstore.addDVD(dvd2);

    DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin",
                                                "Animation",
                                                18.99f);
    DvDstore.addDVD(dvd3);

    DvDstore.listDVD();

    }
}
