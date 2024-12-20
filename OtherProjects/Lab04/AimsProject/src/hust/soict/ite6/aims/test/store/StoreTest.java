package  OtherProjects.Lab04.AimsProject.src.hust.soict.ite6.aims.test.store;
import  OtherProjects.Lab04.AimsProject.src.hust.soict.ite6.aims.media.DigitalVideoDisc;
import  OtherProjects.Lab04.AimsProject.src.hust.soict.ite6.aims.store.Store;

public class StoreTest {
    public static void main(String[] args) {
        Store DvDstore = new Store();

    DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
                                                       "Animation",
                                                       "Roger Allers",
                                                       19.95f,
                                                       87);
    
    DvDstore.addItemtoStore(dvd1);
    

    DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
                                                       "Science Fiction",
                                                       "George Lucas",
                                                       24.95f,
                                                       124);
    DvDstore.addItemtoStore(dvd2);

    DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin",
                                                "Animation",
                                                18.99f);
    DvDstore.addItemtoStore(dvd3);

    DvDstore.listItem();

    }
}
