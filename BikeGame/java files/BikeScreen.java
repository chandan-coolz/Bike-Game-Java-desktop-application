import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.net.URL;

import javax.swing.ImageIcon;


public class BikeScreen {

	Image bike,h1;
	int bfy,bby;
	int gravity; //define the gravvity
	boolean accelaration,backAcceleration;
	double angle;
	public int score;
	//
	int lbY;
	// to keep track of player death and score
	boolean pdeath,pscore,p2score;
	public BikeScreen(){
		
		initBikeScreen();
	}
	private void loadImage(){
		URL imgURL = getClass().getClassLoader().getResource("bike.gif");
		ImageIcon Bike = new ImageIcon(imgURL);
		bike = Bike.getImage();
	}
	private void initBikeScreen(){
		loadImage();
		 bfy=105+bike.getHeight(null);
		 bby=105+bike.getHeight(null);
		 gravity=4;
		 pdeath=true;
		 pscore=true;
	}
	
	//getters and setters
	
	
	public boolean isAccelaration() {
		return accelaration;
	}
	public boolean isP2score() {
		return p2score;
	}
	public void setP2score(boolean p2score) {
		this.p2score = p2score;
	}
	public boolean isPdeath() {
		return pdeath;
	}
	public void setPdeath(boolean pdeath) {
		this.pdeath = pdeath;
	}
	public boolean isPscore() {
		return pscore;
	}
	public void setPscore(boolean pscore) {
		this.pscore = pscore;
	}
	public boolean isBackAcceleration() {
		return backAcceleration;
	}
	public void setBackAcceleration(boolean backAcceleration) {
		this.backAcceleration = backAcceleration;
	}
	public int getBby() {
		return bby;
	}
	public int getLbY() {
		return lbY;
	}
	public void setAccelaration(boolean accelaration) {
		this.accelaration = accelaration;
	}
	
	
	public double getAngle() {
		return angle;
	}
	public void setAngle(double angle) {
		this.angle = angle;
	}
	
	
	//end of getters and setters

	public void draw(Graphics g,GameScreen gc, int[] lineY){
		
		int fX,bX; //to get x cordinate of bike
		int lfY; // to get y coordinate of a line
		
       
		
		
		
		fX=gc.getCameraX()+10+bike.getWidth(null);
		bX=gc.getCameraX()+10;
		
		
		lfY=lineY[fX-50];
		lbY=lineY[fX-49];
		
		
		
		  //if(lfY-bfy>=2) bfy+=gravity; 
		  if(lbY-bby>=2) bby+=gravity;
		
    //    if(bfy>lfY) bfy=lfY;
          if(bby>lbY) bby=lbY;
        
          //check for acceleration
     
          
          
        Double angle=Math.atan2( lbY-lfY, 1);
        
        
        Graphics2D g2d = (Graphics2D) g;
        int spriteHeight = bike.getHeight(null);
        int spriteWidth = bike.getWidth(null);

          AffineTransform affineTransform = new AffineTransform();
          if(lbY-bby<2){
          affineTransform.rotate(angle+this.angle, bX-gc.getCameraX() + spriteWidth / 2, bby-bike.getHeight(null)
                + spriteHeight / 2);
          
          } else {
        	  //  System.out.println(Math.toDegrees(angle));
        	     affineTransform.rotate(this.angle, bX-gc.getCameraX() + spriteWidth / 2, bby-bike.getHeight(null)
        	                + spriteHeight / 2);  
        	     
          }
        affineTransform.translate(bX-gc.getCameraX(), bby-bike.getHeight(null));

        g2d.drawImage(bike, affineTransform,null);		
		
//  g2d.drawImage(bike,bX-gc.getCameraX(),bby-bike.getHeight(null), null);
		
		
		
		
	}
	
	
	
	
	
	
	
	
}//BikeScreen
