package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable {
    public DigitalVideoDisc(String title) {
       	super(title);
    }

    public DigitalVideoDisc(String title, String category, float cost) {
    	super(title, category, cost);
    }

    public DigitalVideoDisc(String director, String category, String title, float cost) {
    	super(title, category, cost, director);
    }

    public DigitalVideoDisc(String title, String category, float cost, String director, int length) {
    	super(title, category, cost, director, length);
    }
    
    public String toString() {
		return this.getId() + " - DVD: " + this.getTitle() +
				" - Category: " + this.getCategory() +
				" - Director: " + this.getDirector() +
				" - DVD length: " + this.getLength() +
				" - Cost: " + this.getCost() + "$";
	}
    
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }
    
    public String playGUI() throws PlayerException {
        if (this.getLength() > 0) {
                return "Playing DVD: " + this.getTitle() + "\n" + 
                    "DVD length: " + formatDuration(this.getLength());
            } else {
                throw new PlayerException("ERROR: DVD length is non-positive!");
            }
    }

}
