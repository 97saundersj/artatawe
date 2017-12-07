
public class Testicles {

	public static void main(String[] args) {
		/*ProfileManagement test = new ProfileManagement();
		ArtworkManagement test2 = new ArtworkManagement();
		test.addProfile("Dick", "John", "JohnDick", "07333333333", "a bush", "SA14LN");
		test.addProfile("Dick", "John 2", "JohnDick2", "07333333333", "a bush", "SA14LN");
		test.addFavourite(test.searchProfile("JohnDick"), test.searchProfile("JohnDick2"));
		test2.addPainting("Fuck me", "Nothing here", null, test.searchProfile("JohnDick"), 2019, 0, 1, 5, 5);
		test2.addPainting("Fuck me part 2", "Nothing here", null, test.searchProfile("JohnDick2"), 2019, 0, 1, 5, 5);
        System.out.println(test2.getAllArtworks().get(1).getTitle());	
		test2.save();*/
		ArtworkManagement test = new ArtworkManagement();
		test.load();
		System.out.println(test.getAllArtworks().get(0).getTitle());
		
	}

}
