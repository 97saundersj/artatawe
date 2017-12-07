
import java.awt.Image;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alex
 */
public class Profile {

	private String lastName;
	private String firstName;
	private String userName;
	private String phoneNo;
	private String adress;
	private String postCode;
	private Image profilePic;
	private ArrayList<Profile> favourites;
	private ArrayList<Artwork> artworksWon;

	public Profile(String lastName, String firstName, String userName, String phoneNo, String adress, String postCode) {

		favourites = new ArrayList<Profile>();
		artworksWon = new ArrayList<Artwork>();
		this.lastName = lastName;
		this.firstName = firstName;
		this.userName = userName;
		this.phoneNo = phoneNo;
		this.adress = adress;
		this.postCode = postCode;
		profilePic = null;
		

	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public Image getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(Image profilePic) {
		this.profilePic = profilePic;
	}

	public void addFavourite(Profile profile) {
		favourites.add(profile);
	}
	public ArrayList<Profile> getFavourites() {
		return favourites;
	}
	public void addArtworkWon(Artwork art) {
		artworksWon.add(art);
	}
	public ArrayList<Artwork> getArtworksWon() {
		return artworksWon;
	}
}
