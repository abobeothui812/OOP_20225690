package OtherProjects.Lab04.AimsProject.src;
import java.util.Collections;
import java.util.Scanner;

import OtherProjects.Lab04.AimsProject.src.hust.soict.ite6.aims.cart.Cart;
import OtherProjects.Lab04.AimsProject.src.hust.soict.ite6.aims.media.CompactDisc;
import OtherProjects.Lab04.AimsProject.src.hust.soict.ite6.aims.media.book;
import OtherProjects.Lab04.AimsProject.src.hust.soict.ite6.aims.media.media;
import OtherProjects.Lab04.AimsProject.src.hust.soict.ite6.aims.media.DigitalVideoDisc;
import OtherProjects.Lab04.AimsProject.src.hust.soict.ite6.aims.store.Store;
public class Aims {
    
    private static Store DvDstore = new Store();
    private static Cart cart = new Cart();
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
       
        DvDstore.addItemtoStore(new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 24.95f, 124));
        DvDstore.addItemtoStore(new CompactDisc("Greatest Hits", "Music","Michael Jackson",12, "Michael Jackson"));
        DvDstore.addItemtoStore(new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 19.95f, 87));
        DvDstore.addItemtoStore(new book("Java Programming", "Education", 500));
        DvDstore.addItemtoStore(new DigitalVideoDisc("Inception", "Science Fiction", "Christopher Nolan", 14.99f, 148));
        DvDstore.addItemtoStore(new CompactDisc("Thriller", "Music", "Quincy Jones", 9.99f, "Michael Jackson"));
        DvDstore.addItemtoStore(new DigitalVideoDisc("Interstellar", "Adventure", "Christopher Nolan", 18.50f, 169));
        DvDstore.addItemtoStore(new book("Effective Java", "Education", 45.00f));
        DvDstore.addItemtoStore(new CompactDisc("Back in Black", "Rock", "Mutt Lange", 10.00f, "AC/DC"));
        DvDstore.addItemtoStore(new DigitalVideoDisc("Avatar", "Fantasy", "James Cameron", 20.99f, 162));
        DvDstore.addItemtoStore(new book("Clean Code", "Programming", 50.00f));
        DvDstore.addItemtoStore(new CompactDisc("Dark Side of the Moon", "Progressive Rock", "Pink Floyd", 15.00f, "Pink Floyd"));
        DvDstore.addItemtoStore(new DigitalVideoDisc("Titanic", "Drama", "James Cameron", 17.99f, 195));
        DvDstore.addItemtoStore(new book("The Pragmatic Programmer", "Education", 42.00f));

        cart.addItemtoCart(new book("The Pragmatic Programmer", "Education", 42.00f));
        cart.addItemtoCart(new DigitalVideoDisc("Titanic", "Drama", "James Cameron", 17.99f, 195));
        cart.addItemtoCart(new CompactDisc("Dark Side of the Moon", "Progressive Rock", "Pink Floyd", 15.00f, "Pink Floyd"));
        cart.addItemtoCart(new book("Clean Code", "Programming", 50.00f));
        cart.addItemtoCart(new DigitalVideoDisc("Avatar", "Fantasy", "James Cameron", 20.99f, 162));
        cart.addItemtoCart(new CompactDisc("Back in Black", "Rock", "Mutt Lange", 10.00f, "AC/DC"));

       
        showMenu();
        
    }
    
    public static void showMenu() {
          char choice;
          System.out.println("AIMS: ");
          System.out.println("--------------------------------");
          System.out.println("1. View store");
          System.out.println("2. Update store");
          System.out.println("3. See current cart");
          System.out.println("0. Exit");
          System.out.println("--------------------------------");
          System.out.println("Please choose a number: 0-1-2-3");
          
                   choice = sc.next().charAt(0);
                   sc.nextLine();
                   switch(choice){
                       case '1': {DvDstore.listItem();storeMenu();break;}  
                       case '2': {
                           System.out.println("Which option you want to update (add or remove): ");
                           String Option = sc.nextLine();
                           switch(Option){
                               case "add": {
                                System.out.println("Which type of item you want to add (DVD/CD/Book): ");
                                String type = sc.nextLine();
                                if(type.equals("DVD") || type.equals("CD") || type.equals("Book")){
                                    EnterItemInformation(type);
                                }
                                else{
                                    System.out.println("Invalid type of item");
                                }
                                
                                break;
                               }
                               case "remove": {
                                   System.out.println("Enter the title of the item you want to remove: ");
                                   String title = sc.nextLine();
                                   DvDstore.removeItemfromStore(DvDstore.search(title));
                                   break;    
                               }
                               
                           }
                           
                           showMenu() ; 
                           break;      
                       }
                       case '3': {cart.listItem();cartMenu();break;}
                       case '0': return;
               }
               System.out.println("--------------------------------");
            
    }

    public static void storeMenu() {
        char choice;
        System.out.println("--------------------------------");
        System.out.println("--------------------------------");
        System.out.println("--------------------------------");
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");

        
                 choice = sc.next().charAt(0);
                 sc.nextLine(); 
                 switch(choice){
                     case '1': {
                          System.out.println("Enter the title you want to search: ");
                          String title = sc.nextLine();
                          media item = DvDstore.search(title);
                          if(item != null){
                            mediaDetailsMenu(item);
                          }
                          
                          break;
                          
                     }  
                     case '2': {
                          System.out.println("Enter the title of the item you want to add: ");
                          String title = sc.nextLine();
                          media item = DvDstore.search(title);
                          cart.addItemtoCart(item);
                          System.out.println("Item added to cart");
                          System.out.println(cart.numberOfItemsInCart);
                          storeMenu();
                          break;}
                     case '3': {
                          System.out.println("Enter the DVD/CD you want to play: ");
                          String title = sc.nextLine();
                          media item = DvDstore.search(title);
                          if( item instanceof DigitalVideoDisc || item instanceof CompactDisc){
                              if (item instanceof DigitalVideoDisc) {
                                  ((DigitalVideoDisc) item).play();
                              } else if (item instanceof CompactDisc) {
                                  ((CompactDisc) item).play();
                              }
                          }
                          else{
                              System.out.println("This item is not playable");
                          }
                          storeMenu();
                          break;
                          
                     }
                     case '4': {cart.listItem();storeMenu();break;}
                     case '0': {showMenu(); break;}
      }
      System.out.println("--------------------------------");
    }


    public static void mediaDetailsMenu(media  item) {
        char choice;
        System.out.println("--------------------------------");
        System.out.println("--------------------------------");
        System.out.println("--------------------------------");
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");

        
          
                 choice = sc.next().charAt(0);
                 sc.nextLine(); 
                 switch(choice){
                     case '1': {
                          cart.addItemtoCart(item);
                          mediaDetailsMenu(item);
                          break;
                     }  
                     
                     case '2': {
                        if (item instanceof DigitalVideoDisc) {
                            ((DigitalVideoDisc) item).play();
                        } else if (item instanceof CompactDisc) {
                            ((CompactDisc) item).play();
                        } else {
                            System.out.println("This item is not playable");
                        }
                        mediaDetailsMenu(item);
                        break;
                    
                     }
                     case '0': {storeMenu();break;}
             }
             System.out.println("--------------------------------");
      }
    
    

    public static void cartMenu() {
        char choice;
            
            System.out.println("--------------------------------");
            System.out.println("--------------------------------");
          System.out.println("Options: ");
          System.out.println("--------------------------------");
          System.out.println("1. Filter medias in cart");
          System.out.println("2. Sort medias in cart");
          System.out.println("3. Remove media from cart");
          System.out.println("4. Play a media");
          System.out.println("5. Place order");
          System.out.println("0. Back");
          System.out.println("--------------------------------");
          System.out.println("Please choose a number: 0-1-2-3-4-5");
    

          

                  choice = sc.next().charAt(0);
                  sc.nextLine(); 
                  switch(choice){
                      case '1': {
                            System.out.println("Enter the filter Option (title/id): ");
                            String filterOption = sc.nextLine();
                            if(filterOption.equals("title")){
                                System.out.println("Enter the title you want to filter: ");
                                String title = sc.nextLine();
                                cart.search(title);
                            }
                            if(filterOption.equals("id")){
                              System.out.println("Enter the title you want to filter: ");
                              int id = sc.nextInt();
                              cart.search(id);
                            }else{
                                System.out.println("Invalid filter element");
                            }
                            cartMenu();
                            break;
                      }  
                      case '2': {
                        System.out.println("Enter the sort option (title/cost): ");
                        String SortOption = sc.nextLine();
                        
                        if(SortOption.equals("title")){
                            Collections.sort(cart.itemsOrdered,media.COMPARE_BY_TITLE_COST);
                            for (media media : cart.itemsOrdered) {
                                System.out.println(media.toString());
                            }
                        }else if(SortOption.equals("cost")){
                          Collections.sort(cart.itemsOrdered,media.COMPARE_BY_COST_TITLE);
                          for (media media : cart.itemsOrdered) {
                              System.out.println(media.toString());
                          } 
                        }else{
                            System.out.println("Invalid sort element");
                        } 
                        cartMenu();
                        break;
                      
                      }
                      case '3': {
                        System.out.println("Enter the title of the item you want to remove: ");
                        String title = sc.nextLine();
                        media item = cart.search(title);
                        cart.removeItemtoCart(item);
                        System.out.println("Item removed from cart");
                        cartMenu();
                        break;
                        
                      }
                      case '4': {
                        System.out.println("Enter the DVD/CD you want to play: ");
                          String title = sc.nextLine();
                          media item = DvDstore.search(title);
                          if( item instanceof DigitalVideoDisc || item instanceof CompactDisc){
                              if (item instanceof DigitalVideoDisc) {
                                  ((DigitalVideoDisc) item).play();
                              } else if (item instanceof CompactDisc) {
                                  ((CompactDisc) item).play();
                              }
                          }
                          else{
                              System.out.println("This item is not playable");
                          }
                           cartMenu();
                            break;
                      }
                      case '5': {
                        System.out.println("Your Order has been placed: ");
                        break;
                      }
                      case '0': {showMenu();break;}
              }
              System.out.println("--------------------------------");
        
      }
    

    public static void EnterItemInformation(String type){
        
            System.out.println("Enter the following information: ");
            
            
            System.out.println("Title: ");
            String title = sc.nextLine();
            System.out.println("Category: ");
            String category = sc.nextLine();
            System.out.println("Cost: ");
            float cost = sc.nextFloat();
            
            sc.nextLine();
            switch(type){
                case "DVD": {
                    System.out.println("Director: ");
                    String director = sc.nextLine();
                    System.out.println("Length: ");
                    int length = sc.nextInt();
                    
                    DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, cost, length);
                    DvDstore.addItemtoStore(dvd);
                    break;
                }
                case "CD": {
                    System.out.println("Artist: ");
                    String artist = sc.nextLine();
                    System.out.println("Director: ");
                    String director = sc.nextLine();
                    
                    CompactDisc cd = new CompactDisc(title, category,director, cost, artist);
                    DvDstore.addItemtoStore(cd);
                    break;
                }
                case "Book": {
                    book bk = new book(title, category, cost);
                    DvDstore.addItemtoStore(bk);
                    break;
                } 
            }
        }

    }


        


