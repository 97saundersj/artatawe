import java.awt.Image;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * A class to store and manipulate the storage of artworks
 * @author Dan
 */
public class ArtworkManagement {
    private ArrayList<Artwork> artworks;
    /**
     * Creates a new ArtworkManagement object
     * There should only be one instance of this class, in database
    */
    ArtworkManagement() {
        artworks = new ArrayList<Artwork>();
    }
    
    /**
    * A method to return an array of bids from an araylist of bids
    * used internally
    * @param arrayList the array list of bids
    * @return a bid array containing the same elements as the array list
    */
    private Artwork[] convertToArray(ArrayList<Artwork> arrayList) {
	Artwork[] array = new Artwork[arrayList.size()];
	for(int i = 0; i < arrayList.size(); i++) {
            array[i] = arrayList.get(i);
	}
	return array;
    }
    
    /**
    * returns all of the artworks currently in the system
    * @return artworks array, an array of every artwork object registered
    */
    public Artwork[] getAllArtworks() {
    	return convertToArray(artworks);
    }
    
    /**
    * Adds a new bid to the system
    * @param title the title of the painting
    * @param description description of the painting
    * @param mainPhoto an image of the painting 
    * @param creator the profile that has put the painting up for auction
    * @param yearOfCreation LocalDateTime when the painting was added to the system
    * @param reservePrice the reserve price under which no successful bid can be made
    * @param noOfBids maximum amount of permitted bids before the painting is sold
    * @param width the width of the painting
    * @param height the height of the painting
    */
    public void addPainting(String title, String description, Image mainPhoto, Profile creator, int yearOfCreation, int reservePrice, int noOfBids, int width, int height) {
        Artwork painting = new Artwork(title, description, mainPhoto, creator, yearOfCreation, reservePrice, noOfBids, width, height);
        artworks.add(painting);
    }
    
    /**
    * Adds a new bid to the system
    * @param title the title of the sculpture
    * @param description description of the sculpture
    * @param mainPhoto an image of the sculpture 
    * @param creator the profile that has put the sculpture up for auction
    * @param yearOfCreation LocalDateTime when the sculpture was added to the system
    * @param reservePrice the reserve price under which no successful bid can be made
    * @param noOfBids maximum amount of permitted bids before the sculpture is sold
    * @param width the width of the sculpture
    * @param height the height of the sculpture
    * @param material the material the sculpture is made from
    */
    public void addSculpture(String title, String description, Image mainPhoto, Profile creator, int yearOfCreation, int reservePrice, int noOfBids, int width, int height, int depth, String material) {
        Sculpture sculpture = new Sculpture(title, description, mainPhoto, creator, yearOfCreation, reservePrice, noOfBids, width, height, depth, material);
    	artworks.add(sculpture);
    }
    
    /**
    * returns all of the artworks that a profile has put on to the system
    * @param profile the profile whose artworks are to be found
    * @return an artwork array of all of the artworks that the profile has listed
    */
    public Artwork[] getArtworkByProfile(Profile profile) {
        ArrayList<Artwork> temp = new ArrayList<Artwork>();
        for(int i = 0; i < artworks.size(); i++) {
            if(artworks.get(i).getCreator() == profile) {
                temp.add(artworks.get(i));
            }
        }
        return convertToArray(temp);
    }
    
    /**
    * returns all of the artworks that have those characters in the title
    * @param title the title of the artworks to be found
    * @return an artwork array of all of the artworks that have those characters in the title
    */
    public Artwork[] getArtworkByTitle(String title) {
        ArrayList<Artwork> temp = new ArrayList<Artwork>();
        title.toLowerCase();
        // it is now case insensitive
        for(int i = 0; i < artworks.size(); i++) {
            //it will look for partial matches too
            if(artworks.get(i).getTitle().toLowerCase().contains(title)) {
                temp.add(artworks.get(i));
            }
        }
        return convertToArray(temp);
    }
}
