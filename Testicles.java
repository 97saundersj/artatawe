import java.time.LocalDateTime;

public class Testicles {

	public static void main(String[] args) {
		Database test4 = new Database();
		/*ProfileManagement test = test4.manageProfiles();
		ArtworkManagement test2 = test4.manageArtwork();
		BidManagement test3 = test4.manageBids();
		test.addProfile("Dick", "John", "JohnDick", "07333333333", "a bush", "SA14LN");
		test.addProfile("Dick", "John 2", "JohnDick2", "07333333333", "a bush", "SA14LN");
		test.addFavourite(test.searchProfile("JohnDick"), test.searchProfile("JohnDick2"));
		test2.addPainting("Fuck me", "Nothing here", null, test.searchProfile("JohnDick"), 2019, 9, 3, 5, 5);
		test2.addPainting("Fuck me part 2", "Nothing here", null, test.searchProfile("JohnDick2"), 2019, 0, 1, 5, 5);
		test3.addBid(test.searchProfile("JohnDick"),test2.getArtworkByID(1),10);
        test3.addBid(test.searchProfile("JohnDick2"),test2.getArtworkByID(1),11);
        test2.addSculpture("Fuck me 3", "", null, test.searchProfile("JohnDick"), 1, 5, 10, 10, 10, 10, "tears");
        test4.save();*/
        test4.load();
        System.out.println(test4.manageProfiles().getProfiles().get(0).getUserName());
        System.out.println(test4.manageBids().getAllBids().get(1).getPrice());
        System.out.println(test4.manageArtwork().getAllArtworks().get(1).getTitle());
        System.out.println(test4.manageBids().getAllBids().get(0).getBidder().getUserName());
        System.out.println(test4.manageBids().getAllBids().get(1).getBidder().getUserName());
        System.out.println(test4.manageBids().getAllBids().get(0).getArt().getTitle());
        System.out.println(((Sculpture) test4.manageArtwork().getAllArtworks().get(2)).getMaterial()); 
		}

}
