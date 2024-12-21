package hust.soict.hedspi.test.media;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class TestPassingParameter {
	public static void main(String[] args) {
		DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
		DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");
		
		// Wrap the DVD objects into wrapper classes
       DigitalVideoDiscWrapper jungleWrapper = new DigitalVideoDiscWrapper(jungleDVD);
       DigitalVideoDiscWrapper cinderellaWrapper = new DigitalVideoDiscWrapper(cinderellaDVD);
		
       // Call the wrong swap() method
       swap(jungleDVD, cinderellaDVD);
       System.out.println("Wrong swapped jungle dvd title: " + jungleDVD.getTitle());
       System.out.println("Wrong swapped cinderella dvd title: " + cinderellaDVD.getTitle());
      
       // Call the correct swap() method
       swap(jungleWrapper, cinderellaWrapper);
       System.out.println("Correct swapped jungle dvd title: " + jungleWrapper.dvd.getTitle());
       System.out.println("Correct swapped cinderella dvd title: " + cinderellaWrapper.dvd.getTitle());
		
		changeTitleLHY(jungleDVD, cinderellaDVD.getTitle());
		System.out.println("Change jungle dvd title: " + jungleDVD.getTitle());
	}
	
	// Wrong
	public static void swap(Object o1, Object o2)
	{
		Object tmp = o1;
		o1 = o2;
		o2 = tmp;
	}
	
	// Correct
	public static void swap(DigitalVideoDiscWrapper o1, DigitalVideoDiscWrapper o2)
	{
		DigitalVideoDisc tmp = o1.dvd;
		o1.dvd = o2.dvd;
		o2.dvd = tmp;
	}
	
	public static void changeTitleLHY(DigitalVideoDisc dvd, String title)
	{
		String oldTitle = dvd.getTitle();
		dvd.setTitle(title);
		dvd = new DigitalVideoDisc(oldTitle);
	}
}