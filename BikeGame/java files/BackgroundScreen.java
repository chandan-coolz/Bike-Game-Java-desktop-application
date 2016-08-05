import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.geom.Line2D;
import java.net.URL;

import javax.swing.ImageIcon;

public class BackgroundScreen {
	// initialize variable
	Image Mbackground,sky1,p1,p2,p3,p4,p5;
	int xSky1,x4P1,x4P2,x4P3,x4P4;
	
    int[] x,y;
	public BackgroundScreen() {

		initBackgroundScreen();
	} // BackgroundScreen

	private void loadImages() {

		URL imgURL = getClass().getClassLoader().getResource("sky2.jpg");
		ImageIcon backsky1 = new ImageIcon(imgURL);
		sky1 = backsky1.getImage();

		URL imgURL1 = getClass().getClassLoader().getResource("p1.png");
		ImageIcon path1 = new ImageIcon(imgURL1);
		p1 = path1.getImage(); 

		URL imgURL2 = getClass().getClassLoader().getResource("p2.png");
		ImageIcon path2 = new ImageIcon(imgURL2);
		p2 = path2.getImage();
		
		URL imgURL3 = getClass().getClassLoader().getResource("p3.png");
		ImageIcon path3 = new ImageIcon(imgURL3);
		p3 = path3.getImage(); 

		URL imgURL4 = getClass().getClassLoader().getResource("p4.png");
		ImageIcon path4 = new ImageIcon(imgURL4);
		p4 = path4.getImage();
		
		URL imgURL5 = getClass().getClassLoader().getResource("p5.png");
		ImageIcon path5 = new ImageIcon(imgURL5);
		p5 = path5.getImage(); 
	}
	
	private void loadPlayerPath(){
		x=new int[12000];
		y=new int[12000];
		int k=0; // for increase of 1;
		int j=0;//for increase of 2;
		for(int i=0;i<10000;i++){
			x[i]=i;
			if(i>=0 && i<200) y[i]=200;
			
			if(i>=200 && i<300){ 
				y[i]=200+k;
				k++;
			}
			if(i>=300 && i<500) {
				y[i]=300;
				k=0;
			}
			
			if(i>=500 && i<600) {
				y[i]=300-k;
				k++;
			}
			
			if(i>=600 && i<700){
				y[i]=200;
				k=0;
			}
			
			if(i>=700 && i<1000){
				y[i]=200+k;
				k+=1;
			}
			if(i>=1000 && i<1100){
				y[i]=500;
				k=0;
			}
			if(i>=1100 && i<1150){
				y[i]=500-k;
				k++;
			}
			if(i>=1150 && i<1250){
				y[i]=450;
				k=0;
			}
			
			if(i>=1250 && i<1300){
				y[i]=450+k;
				k++;
			}
			if(i>=1300 && i<1400){
				y[i]=500;
				k=0;
			}
			
			if(i>=1400 && i<1450){
				y[i]=500-k;
				k++;
			}
			if(i>=1450 && i<1550){
				y[i]=450;
				k=0;
			}
			
			if(i>=1550 && i<1600){
				y[i]=450+k;
				k++;
			}
			if(i>=1600 && i<1700){
				y[i]=500;
				k=0;
			}
			if(i>=1700 && i<1750){
				y[i]=500-k;
				k++;
			}
			if(i>=1750 && i<1850){
				y[i]=450;
				k=0;
			}
			
			if(i>=1850 && i<1900){
				y[i]=450+k;
				k++;
			}
			
			if(i>=1900 && i<2000){
				y[i]=500;
				k=0;
			}
			if(i>=2000 && i<2050){
				y[i]=500-k;
				k++;
			}
			if(i>=2050 && i<2150){
				y[i]=450;
				k=0;
			}
			
			if(i>=2150 && i<2200){
				y[i]=450+k;
				k++;
			}
			if(i>=2200 && i<2300){
				y[i]=500;
				k=0;
			}
			if(i>=2300 && i<2350){
				y[i]=500-k;
				k++;
			}
			if(i>=2350 && i<2450){
				y[i]=450;
				k=0;
			}
			
			if(i>=2450 && i<2500){
				y[i]=450+k;
				k++;
			}
			
			if(i>=2500 && i<2600){
				y[i]=500;
				k=0;
			}
			
			if(i>=2600 && i<2900){
				y[i]=500-k;
				k++;
			}
			if(i>=2900 && i<2950){
				y[i]=200;
				k=0;
			}	
			
			if(i>=2950 && i<3250){
				y[i]=200+k;
				k++;
			}
			
			if(i>=3250 && i<4200){
				  y[i]=500;
				  k=0;
			  }
				
			if(i>=4200 && i<4400){
				  y[i]=500-k;
				  k++;
			  }
			
			if(i>=4400 && i<4500){
				  y[i]=300;
				  k=0;
			  }
			if(i>=4500 && i<4750){
				  y[i]=300+k;
				  k++;
			  }			
			
			if(i>=4750 && i<4850){
				y[i]=550;
				k=0;
			}
			
			if(i>=4850 && i<5000){
				y[i]=550-k;
				k++;
			}
			
			if(i>=5000 && i<5100){
				y[i]=400;
				k=0;
			}
			
			
			if(i>=5100 && i<5300){
				y[i]=400-k;
				k++;
			}
			
			if(i>=5300 && i<5400){
				y[i]=200;
				k=0;
			}
			
			if(i>=5400 && i<5700){
				y[i]=200+k;
				k++;
			}
			
			if(i>=5700 && i<5900){
				y[i]=500;
				k=0;
			}
			//add piller after this
			
			
			if(i>=5900 && i<6300){
				y[i]=500-k;
				k++;
				
			}
			if(i>=6300 && i<6350){
				y[i]=100;
				k=0;
				
			}
			
			if(i>=6350 && i<6650){
				y[i]=100+k;
				k++;
			}
			if(i>=6650 && i<6700){
				y[i]=400;
				k=0;
				
			}
			if(i>=6700 && i<7000){
				y[i]=400-k;
				k++;
			}
			
			if(i>=7000 && i<7050){
				y[i]=100;
				k=0;
			}
			if(i>=7050 && i<7450){
				y[i]=100+k;
				k++;
			} 
			if(i>=7450 && i<7500){
				y[i]=500;
				k=0;
			} 
			
			//repeating
			if(i>=7500 && i<7900){
				y[i]=500-k;
				k++;
				
			}
			if(i>=7900 && i<7950){
				y[i]=100;
				k=0;
				
			}
			
			if(i>=7950 && i<8250){
				y[i]=100+k;
				k++;
			}
			if(i>=8250 && i<8300){
				y[i]=400;
				k=0;
				
			}
			if(i>=8300 && i<8600){
				y[i]=400-k;
				k++;
			}
			
			if(i>=8600 && i<8650){
				y[i]=100;
				k=0;
			}
			if(i>=8650 && i<9050){
				y[i]=100+k;
				k++;
			} 
			
			if(i>=9050 && i<10500){
				y[i]=500;
				k=0;
			} 
			if(i>=10500 && i<10800){
				y[i]=500-k;
				k++;
			} 	
			
			
		} //for
		
	} //loadPath

	private void initBackgroundScreen() {

		loadImages();
		// initialize other methods
        loadPlayerPath();
		xSky1 = 0;
		//xSky2 = sky1.getWidth(null);
	    x4P1=50;x4P2=650;x4P3=2925;x4P4=5350;
		//ySky2 = 0;

	}

	public void draw(Graphics g, GameScreen gc) {

		    Graphics2D g2d=(Graphics2D) g;
			g2d.drawImage(sky1, xSky1, 0, null);
		
		//	g2d.drawImage(Mbackground, 0,0 , null); 
			//to draw p400 images

			g.drawImage(p1, x4P1-gc.getCameraX(), 200, null);
	
			 
			g.drawImage(p1, x4P2-gc.getCameraX(), 200, null);
			
            g.drawImage(p1, x4P3-gc.getCameraX(), 200, null);

		     g.drawImage(p1, x4P4-gc.getCameraX(), 200, null);
		     
	            g.drawImage(p1, x4P3-gc.getCameraX(), 200, null);

			
		     
		 // to draw all 100 pipes    
					 
				g.drawImage(p2, 1050-gc.getCameraX(), 500, null);
				 
				g.drawImage(p2, 1350-gc.getCameraX(), 500, null);
				
	            g.drawImage(p2, 1650-gc.getCameraX(), 500, null);

			     g.drawImage(p2, 1950-gc.getCameraX(), 500, null);
		     
					g.drawImage(p2, 2250-gc.getCameraX(), 500, null);
					 
					g.drawImage(p2, 2550-gc.getCameraX(), 500, null);
					
		            g.drawImage(p2, 3250-gc.getCameraX(), 500, null);

				     g.drawImage(p2, 4200-gc.getCameraX(), 500, null);
				     
				     g.drawImage(p2, 9075-gc.getCameraX(), 500, null);
				  

				     g.drawImage(p2, 7475-gc.getCameraX(), 500, null);
		 // to draw all 200 pipes
				     g.drawImage(p3, 5050-gc.getCameraX(), 400, null);
				     g.drawImage(p3, 6675-gc.getCameraX(), 400, null);
				     g.drawImage(p3, 8275-gc.getCameraX(), 400, null);
		     
		// to draw all 300 pipes
				     g.drawImage(p4, 4450-gc.getCameraX(), 300, null);
				     //to draw 500
					 	g.drawImage(p5, 6325-gc.getCameraX(), 100, null);
						 
						g.drawImage(p5, 7025-gc.getCameraX(), 100, null);
						
			            g.drawImage(p5, 7925-gc.getCameraX(), 100, null);
			            g.drawImage(p5, 8625-gc.getCameraX(), 100, null);
				     
				     
				     
				
				     
		/* if ((xP2 >= gc.getCameraX() && xP2 < gc.getCameraWidth())
				|| (xP2 + p2.getWidth(null) > gc.getCameraX() && xP2
						+ p2.getWidth(null) <= gc.getCameraWidth())) {
			
			g.drawImage(p2, xP2-gc.getCameraX(), 200, null);
		} */
			
			//to draw the path
		
		 Composite originalComposite = g2d.getComposite();

		// g2d.setComposite(makeComposite(0.0f));
            g2d.setColor(Color.DARK_GRAY);
			for(int i=gc.getCameraX();i<gc.getCameraX()+gc.getCameraWidth()-1;i++){
				
          
				
				g2d.setStroke(new BasicStroke(4));
			    if(y[i]<y[i+1]){
			    	
			    	g2d.draw(new Line2D.Double(x[i]-gc.getCameraX()-20, y[i], x[i+1]-gc.getCameraX(),y[i+1]));
			    	
			    }
			    if(y[i]>y[i+1]){
			    	g2d.draw(new Line2D.Double(x[i]-gc.getCameraX()+20, y[i], x[i+1]-gc.getCameraX(),y[i+1]));
			    }
				g2d.draw(new Line2D.Double(x[i]-gc.getCameraX()+20, y[i], x[i+1]-gc.getCameraX(),y[i+1]));

				
			}
			//g2d.setComposite(makeComposite(90.0f));
			//g2d.setComposite(originalComposite);
			
			
	} // draw

	
	public void drawAfter(Graphics g,GameScreen gc){
		  Graphics2D g2d=(Graphics2D) g;
		
		  
		  for(int i=gc.getCameraX()+gc.getCameraWidth();i<400;i++){
			
			  
			
			g2d.setStroke(new BasicStroke(4));

			g2d.draw(new Line2D.Double(x[i]+20, y[i], x[i+1],y[i+1]));

			
		}		
		
		
		
	}
	
	
	// for tranmsperancy
	 private AlphaComposite makeComposite(float alpha) {
		  int type = AlphaComposite.SRC_OVER;
		  return(AlphaComposite.getInstance(type, alpha));
		 }

	
	
	
	
	public int[] getY() {
		return y;
	}

	
	
	
	
} // BackGroundScreen
