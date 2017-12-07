import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * A class to manipulate and manage the profiles
 * 
 * @author Ziggy
 *
 */
public class ProfileManagement {
	private ArrayList<Profile> profiles;
	// this stores the name of the file in which the profiles are stored
	private static final String fileName = "src/Data/Profiles.txt";
	ArrayList<String[]> favouritesNamesAll = new ArrayList<String[]>();
	ArrayList<int[]> artworksWonAll = new ArrayList<int[]>();
	
	/**
	 * Constructs a profile management, the only class that will create this is
	 * the database
	 */
	public ProfileManagement() {
		profiles = new ArrayList<Profile>();
	}

	/**
	 * saves every profile to the text file listed
	 */
	public void save() {
		File file = new File(fileName);
		try {
			FileWriter fileWriter = new FileWriter(file);
			for (int i = 0; i < profiles.size(); i++) {
				String line = "";
				line += (profiles.get(i).getUserName()) + ",";
				line += (profiles.get(i).getLastName()) + ",";
				line += (profiles.get(i).getFirstName()) + ",";
				line += (profiles.get(i).getPhoneNo()) + ",";
				line += (profiles.get(i).getAddress()) + ",";
				line += (profiles.get(i).getPostCode()) + ",";
				line += ("**Image Thing**") + ",";
				int favouritesNumber = profiles.get(i).getFavourites().size();
				int artworksWonNumber = profiles.get(i).getArtworksWon().size();
				line += (favouritesNumber) + ",";
				for (int a = 0; a < favouritesNumber; a++) {
					line += profiles.get(i).getFavourites().get(a).getUserName() + ",";
				}
				line += (artworksWonNumber) + ",";
				for (int a = 0; a < artworksWonNumber; a++) {
					line += profiles.get(i).getArtworksWon().get(a).getId() + ",";
				}

				fileWriter.write(line);
				fileWriter.write("\n");
			}
			fileWriter.close();
		} catch (Exception e) {
			// file io error
		}
	}

	/**
	 * loads every profile to the text file listed
	 */
	public void load() {
		File file = new File(fileName);
		try {
			Scanner fileReader = new Scanner(file);
			while (fileReader.hasNext()) {
				String line = fileReader.nextLine();
				String[] data = line.split(",");
				String userName = data[0];
				String lastName = data[1];
				String firstName = data[2];
				String phoneNo = data[3];
				String address = data[4];
				String postCode = data[5];
				String IMAGETHING = data[6]; // to be done

				int favouritesNumber = Integer.parseInt(data[7]);
				favouritesNamesAll.add(new String[favouritesNumber]);
				for (int a = 0; a < favouritesNumber; a++) {
					favouritesNamesAll.get(favouritesNamesAll.size() - 1)[a] = data[8 + a];
				}

				int parser = 7 + favouritesNumber;

				int artworksWonNumber = Integer.parseInt(data[parser + 1]);
				artworksWonAll.add(new int[artworksWonNumber]);
				for (int a = 0; a < artworksWonNumber; a++) {
					artworksWonAll.get(artworksWonAll.size() - 1)[a] = Integer.parseInt(data[parser + 2 + a]);
				}
				profiles.add(new Profile(lastName, firstName, userName, phoneNo, address, postCode));
			}
			fileReader.close();
		} catch (Exception e) {
			// file io error
			e.printStackTrace();
		}
		
	}
	public void loadReferences(ArtworkManagement artworkManagement) {
		// handle refrences
				// for favourites
				for (int a = 0; a < favouritesNamesAll.size(); a++) {
					for (int b = 0; b < favouritesNamesAll.get(a).length; b++) {
						profiles.get(a).addFavourite(searchProfile(favouritesNamesAll.get(a)[b]));
					}
				}
				
				// for artworks
				for (int a = 0; a < artworksWonAll.size(); a++) {
					for (int b = 0; b < artworksWonAll.get(a).length; b++) {
						profiles.get(a).addArtworkWon(artworkManagement.getArtworkByID(artworksWonAll.get(a)[b]));
					}
				}
	}

	/**
	 * Adds a new profile with the following attributes -
	 * 
	 * @param lastName
	 * @param firstName
	 * @param userName
	 * @param phoneNo
	 * @param adress
	 * @param postCode
	 */
	public void addProfile(String lastName, String firstName, String userName, String phoneNo, String adress,
			String postCode) {
		if (checkUniqueName(userName)) {
			if (phoneNo.length() != 11 && phoneNo.charAt(0) != 0 && phoneNo.charAt(1) != 7) {
				System.out.println("Not a valid number");
				//exception, not a valid phone number
			} else {
				Profile profile = new Profile(lastName, firstName, userName, phoneNo, adress, postCode);
				profiles.add(profile);
			}
		}
		else {
			//cant make because username isnt unique
		}
	}

	/**
	 * adds a favourite to a profile listed
	 * 
	 * @param profile
	 *            the profile of which to add the favourite to
	 * @param favourite
	 *            the favourite to add
	 */
	public void addFavourite(Profile profile, Profile favourite) {
		profile.addFavourite(favourite);
	}

	/**
	 * search the profiles for the username given
	 * 
	 * @param username
	 *            the username to search
	 * @return the profile which has the username, or null if it doesnt
	 */
	public Profile searchProfile(String username) {
		for (int i = 0; i < profiles.size(); i++) {
			if (profiles.get(i).getUserName().equals(username)) {
				return profiles.get(i);
			}
		}
		return null;
	}

	/**
	 * checks that the username given is unique
	 * 
	 * @param username
	 *            the username to search
	 * @return true if the name is unique, false if not
	 */
	public boolean checkUniqueName(String username) {
		for (int i = 0; i < profiles.size(); i++) {
			if (profiles.get(i).getUserName().equals(username)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * logs a user in
	 * 
	 * @param username
	 *            the username to login
	 * @return true if the user can be logged in, false if not
	 */
	public boolean login(String username) {
		for (int i = 0; i < profiles.size(); i++) {
			if (profiles.get(i).getUserName().equals(username)) {
				return true;
			}
		}
		return false;
	}
}
