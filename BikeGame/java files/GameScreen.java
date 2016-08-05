import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.net.URL;

public class GameScreen {
	
	//to start the game
	public boolean gameStart,gameOver,gameFinished,rePlay;
    // camera rendering
	int xCD;
	int GameLength=10500;
	int cameraX, cameraY, cameraWidth;
	BackgroundScreen bc;
	BikeScreen bk;
	int accelerate;
	int lAngle,rAngle;
	AudioClip  playercollide;
	
	
	
	public BikeScreen getBk() {
		return bk;
	}

	public int getCameraX() {
		return cameraX;
	}

	public void setCameraX(int cameraX) {
		this.cameraX = cameraX;
	}

	public int getCameraY() {
		return cameraY;
	}

	public void setCameraY(int cameraY) {
		this.cameraY = cameraY;
	}

	public int getCameraWidth() {
		return cameraWidth;
	}

	public void setCameraWidth(int cameraWidth) {
		this.cameraWidth = cameraWidth;
	}

	public GameScreen() {

		initGameScreen();
	}

	private void loadAudio() {
		URL url1 = this.getClass().getClassLoader().getResource("playercollide.au");
				playercollide = Applet.newAudioClip(url1);
	}

	private void initGameScreen() {
		loadAudio();
		cameraX = 0;
		cameraY = 0;
		cameraWidth = 1100;
		bc = new BackgroundScreen();
        bk = new BikeScreen();
        gameOver=false;
        gameFinished=false;
        rePlay=false;
        gameStart=false;
	}

	public void draw(Graphics g) {

		
		
		bc.draw(g, this);
		bk.draw(g, this, bc.getY());
		g.setColor(Color.white);
		Font newFont = new Font("TimesRoman", Font.PLAIN, 30);
		g.setFont(newFont);
		g.drawString("Score: "+bk.score,850, 50);
		
		
	} // to draw on the screen

	public void update(){
	
		if(cameraX+cameraWidth>GameLength-300){
		
		gameFinished=true;	
		rePlay=true;
		 } 
		
		
		if((bk.getLbY()-bk.getBby()<=1) && (Math.toDegrees(bk.getAngle())>90 || Math.toDegrees(bk.getAngle())<-90 ) && bk.isPdeath() ){
			
	      	   playercollide.play();
				rePlay=true;
				gameOver=true;
				
			
			
		}
		
		
		if( ( (Math.toDegrees(bk.getAngle())>=200 || Math.toDegrees(bk.getAngle())<=-203) && (bk.isPscore() || bk.isP2score()) ) )
		{
			bk.score+=10;
			if(bk.isPscore())
			bk.setPscore(false);
			else bk.setP2score(false);
		}
		
		if( bk.isAccelaration()&& (bk.getLbY()-bk.getBby()<=2) ){
			
		accelerate++;
		  if (bc.getY()[cameraX+50]>bc.getY()[cameraX+50+1]){
				accelerate++;
			} 
		
		} 
		
		else if(bk.isBackAcceleration() && (bk.getLbY()-bk.getBby()<=2) ){
			accelerate--;
			
			
		} else {
			
			  if(accelerate>0) accelerate--;
			  
			  if(accelerate<0) accelerate++;
			  if (bc.getY()[cameraX+50]>bc.getY()[cameraX+50+1]){
					accelerate=-2;
				}
			}//
		
		
		
		
		//if user encounter slide
		if(bc.getY()[cameraX+50]<bc.getY()[cameraX+50+1]){
			accelerate+=1;
		} 
		

		if(accelerate>6) accelerate=6;
		
		if(accelerate<-6) accelerate=-6;
		
		this.cameraX+=xCD+accelerate;
		
	    
		
		
		if(this.cameraX<0) this.cameraX=0;
		
		
		 
		
	}
	
	
	
	
	
	// if key is pressed
	public void keyPressed(KeyEvent e) {

		int key = e.getKeyCode();

		if (key == KeyEvent.VK_LEFT) {
			
				bk.setAngle(Math.toRadians(-lAngle));
				if(bk.getLbY()-bk.getBby()<2){
					lAngle+=3;
				} else lAngle+=5;
		}

		if (key == KeyEvent.VK_RIGHT) {
			bk.setAngle(Math.toRadians(rAngle));
			if(bk.getLbY()-bk.getBby()<2){
				rAngle+=3;
			} else rAngle+=5;
			
		}

		if (key == KeyEvent.VK_UP) {
			if(cameraX<GameLength-3)
	             bk.setAccelaration(true);
					xCD=4;
					
					
		}

		if (key == KeyEvent.VK_DOWN) {
			bk.setBackAcceleration(true);
			xCD=-4;
		}

	} // if key is pressed

	// if key is released
	public void keyReleased(KeyEvent e) {

		int key = e.getKeyCode();

		if (key == KeyEvent.VK_LEFT) {
          bk.setAngle(0); 
          lAngle=0;
          bk.setPscore(true);
		}

		if (key == KeyEvent.VK_RIGHT) {
		    bk.setAngle(0); 
	          rAngle=0;
	          bk.setPscore(true);
	          bk.setP2score(true);
		}

		if (key == KeyEvent.VK_UP) {
	           xCD=0;
	          // accelerate=0;
	           bk.setAccelaration(false);
		}

		if (key == KeyEvent.VK_DOWN) {
			bk.setBackAcceleration(false);
			xCD=0;
		}

	} // if key is released

}// GameScreen
