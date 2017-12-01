
import java.awt.Image;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Morco
 */
public class Sculpture extends Artwork{
    private int depth;
    private String material;
    public Sculpture(String title,String description, Image mainPhoto, Profile creator, int yearOfCreation, int reservePrice, int noOfBids, int width, int height,int depth, String material){
        super(title, description, mainPhoto, creator, yearOfCreation, reservePrice, noOfBids, width, height);
        this.depth = depth;
        this.material = material;
    }

    public int getDepth() {
        return depth; 
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
    
}
