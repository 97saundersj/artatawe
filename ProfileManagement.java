import java.util.ArrayList;

/**
 * A class to manipulate and manage the profiles
 * @author Ziggy
 *
 */
public class ProfileManagement {
	private ArrayList<Profile> profiles;
	/**
	 * Constructs a profile management, the only class that will create this is 
	 * the database
	 */
	public ProfileManagement() {
		profiles = new ArrayList<Profile>();
	}
	
	public void addProfile(String lastName, String firstName, String userName, String phoneNo, String adress, String postCode) {
		if(phoneNo.length() != 11 && phoneNo.charAt(0) != 0 && phoneNo.charAt(1) != 7){
            System.out.println("Not a valid number");
        }
		else {
			Profile profile = new Profile( lastName,  firstName,  userName,  phoneNo,  adress,  postCode);
			profiles.add(profile);
		}
	}
	/**
	 * adds a favourite to a profile listed
	 * @param profile the profile of which to add the favourite to
	 * @param favourite the favourite to add
	 */
	public void addFavourite(Profile profile, Profile favourite) {
		profile.addFavourite(favourite);
	}
	/**
	 * search the profiles for the username given
	 * @param username the username to search
	 * @return the profile which has the username, or null if it doesnt
	 */
	public Profile searchProfile(String username) {
		for(int i = 0; i < profiles.size(); i++) {
			if(profiles.get(i).getUserName().equals(username)) {
				return profiles.get(i);
			}
		}
		return null;
	}
	/**
	 * checks that the username given is unique
	 * @param username the username to search
	 * @return true if the name is unique, false if not
	 */
	public boolean checkUniqueName(String username) {
		for(int i = 0; i < profiles.size(); i++) {
			if(profiles.get(i).getUserName().equals(username)) {
				return false;
			}
		}
		return true;
	}
	/**
	 * logs a user in
	 * @param username the username to login
	 * @return true if the user can be logged in, false if not
	 */
	public boolean login(String username) {
		for(int i = 0; i < profiles.size(); i++) {
			if(profiles.get(i).getUserName().equals(username)) {
				return true;
			}
		}
		return false;
	}
}
