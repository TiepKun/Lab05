package hust.soict.hedspi.test.cart;
import hust.soict.hedspi.aims.cart.Cart;
import javax.naming.LimitExceededException;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class CartTest {
   public static void main(String[] args) throws LimitExceededException {
   
       Cart cart = new Cart();
      
       DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
       		"Animation", 19.95f, "Roger Allers", 87);
       cart.addMedia(dvd1);
       DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star War",
       		"Science Fiction", 24.95f, "George Lucas", 87);
       cart.addMedia(dvd2);
       DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
       		"Animation", 18.99f);
       cart.addMedia(dvd3);
       DigitalVideoDisc dvd4 = new DigitalVideoDisc("Aladin",
          		"Animation", 18.99f);
       cart.addMedia(dvd4);
       cart.print();
       cart.searchByID(1);
       cart.searchByTitle("Star");
       cart.searchByTitle("Baby");
   }
}