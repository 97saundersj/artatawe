

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.imageio.ImageIO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alex
 */
public class Artwork {
	protected static int idList;
	protected final int id;
    protected String title;
    protected String description;
    protected String mainPhoto;
    protected ArrayList<String> allPhotos;
    protected Profile creator;
    protected int yearOfCreation;
    protected int reservePrice;
    protected int noOfBids;
    protected LocalDateTime startTime;
    protected int width;
    protected int height;
    protected Bid currentBid;
    protected String type;



	public Artwork(String title, String description, String mainPhoto, Profile creator, int yearOfCreation, 
			int reservePrice, int noOfBids, int width, int height,LocalDateTime startTime) {
        idList++;
        id = idList;
		this.title = title;
        this.description = description;
        this.creator = creator;
        this.yearOfCreation = yearOfCreation;
        this.reservePrice = reservePrice;
        this.noOfBids = noOfBids;
        this.width = width;
        this.height = height;
        this.mainPhoto = mainPhoto;
        this.allPhotos = new ArrayList<String>();
        allPhotos.add(mainPhoto);
        this.startTime = LocalDateTime.now();
        this.type = "Artwork";
    }

    public ArrayList<String> getAllPhotos() {
        return allPhotos;
    }

    public int getReservePrice() {
        return reservePrice;
    }

    public int getNoOfBids() {
        return noOfBids;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMainPhoto() {
        return mainPhoto;
    }

    public void setMainPhoto(String mainPhoto) {
        this.mainPhoto = mainPhoto;
    }
    public Profile getCreator() {
        return creator;
    }

    public void setCreator(Profile creator) {
        this.creator = creator;
    }

    public int getYearOfCreation() {
        return yearOfCreation;
    }

    public void setYearOfCreation(int yearOfCreation) {
        this.yearOfCreation = yearOfCreation;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public void addImageToArrayList(String image){
        allPhotos.add(image); 
    }
    public Bid getCurrentBid() {
		return currentBid;
	}

	public void setCurrentBid(Bid currentBid) {
		this.currentBid = currentBid;
	}
	public void addBid(Bid currentBid) {
		this.currentBid = currentBid;
		noOfBids --;
		
	}
	public int getId() {
		return id;
	}
	/**
	 * returns true if there is another bid avaliable, the
	 * no of bids is not less than 0
	 * @return
	 */
	public boolean bidAvaliable() {
		if(noOfBids <= 0) {
			return false;
		}
		return true;
	}

	public String getType() {
		return type;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

}
	
