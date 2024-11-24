public class Store {
    private static int number=0;
    DigitalVideoDisc[] itemsInStore = new DigitalVideoDisc[1000];

    public void addDVD(DigitalVideoDisc[] dvd) {
        for( int i=0; i < dvd.length; i++) {
            itemsInStore[number] = dvd[i];
            
            number++;
        }
    }

    public void addDVD(DigitalVideoDisc dvd) {
            itemsInStore[number] = dvd;
            number++;
            
    }

    public void removeDVD(DigitalVideoDisc dvd) {
        for( int i=0; i < number; i++) {
            if( itemsInStore[i].isMatch(dvd.getTitle()) ) {
                itemsInStore[i] = itemsInStore[number-1];
                itemsInStore[number-1] = null;
                number--;
                break;
            }
        }
    }

    public void listDVD() {
        for( int i=0; i < number; i++) {
            System.out.println(itemsInStore[i].getTitle());
        }
    }


    
}
