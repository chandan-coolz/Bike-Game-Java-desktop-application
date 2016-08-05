import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.swing.JPanel;

public class Board extends JPanel implements Runnable, KeyListener,MouseListener {
	// to start the game
	AudioClip  bg;
	
	//
	ScreenManager Sm;

	// thread
	Thread thread;
	long startTime, endTime, framePeriod;
    //coordinate to start the game
	// cordinate to start the game
		int rect1xco, rect1yco, rect1width, rect1height;
		//replay coordinate
		int Rrect1xco, Rrect1yco, Rrect1width, Rrect1height;
	// screen size
	Dimension dim;
	BufferedImage bufferedImage;
	Graphics g;
   
	private final int B_WIDTH = 1000;
	private final int B_HEIGHT = 600;

	public Board() {
		initBoard();

	}

	private void loadImage() {

	} // loadImage

	private void loadAudio() {

		URL url2 = this.getClass().getClassLoader().getResource("bg.au");
		bg = Applet.newAudioClip(url2);
	
	} // ;oadAudio

	private void initBoard() {

		// dim=Toolkit.getDefaultToolkit().getScreenSize();
		setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
		setDoubleBuffered(true);
		setFocusable(true);
		addKeyListener(this);
		addMouseListener(this);
	
		
		loadImage();
		loadAudio();

		// initializing other things

		Sm = new ScreenManager();
		
		bufferedImage = new BufferedImage(B_WIDTH, B_HEIGHT,
				BufferedImage.TYPE_INT_RGB);

		g = bufferedImage.getGraphics();

		startTime = 0L;
		endTime = 0L;
		framePeriod = 15L;
		
		
		// Assign values to the rectanagle coordinates.
		rect1xco = 400;
		rect1yco = 300;
		rect1width = 150;
		rect1height = 40;
		
		// Assign values to the Replay coordinate coordinates.
		Rrect1xco = 400;
		Rrect1yco = 300;
		Rrect1width = 150;
		Rrect1height = 40;
		
		
	} // initBoard

	@Override
	public void addNotify() {
		super.addNotify();

		thread = new Thread(this);
		thread.start();
	}

	@Override
	protected void paintComponent(Graphics gfx) {
		// TODO Auto-generated method stub
		super.paintComponent(gfx);
		
		
		if(!Sm.getGs().gameStart){
			g.setColor(Color.black);
			g.fill3DRect(0, 0, 1000, 600, false);
			
			g.setColor(Color.green);
			g.fillRect(rect1xco, rect1yco, rect1width, rect1height);
			g.setColor(Color.white);
			Font newFont = new Font("TimesRoman", Font.PLAIN, 30);
			g.setFont(newFont);
			g.drawString(" P L A Y ", 420, 330);
			
		}
			
			else if(Sm.getGs().rePlay){
				bg.stop();
				g.setColor(Color.black);
				g.fill3DRect(0, 0, 1000, 600, false);
				
				g.setColor(Color.green);
				g.fillRect(Rrect1xco, Rrect1yco, Rrect1width, Rrect1height);
				g.setColor(Color.white);
				Font newFont = new Font("TimesRoman", Font.PLAIN, 30);
				g.setFont(newFont);
				g.drawString("REPLAY", 420, 330);
				
				if(Sm.getGs().gameOver)
				{
				g.setColor(Color.white);
				Font newFont2 = new Font("TimesRoman", Font.PLAIN, 50);
				g.setFont(newFont2);
				g.drawString("GAME OVER",306, 230);
				}
				
				if(Sm.getGs().gameFinished){
					
					g.setColor(Color.white);
					Font newFont2 = new Font("TimesRoman", Font.PLAIN, 50);
					g.setFont(newFont2);
					g.drawString("GAME FINISHED",300, 200);	
					g.drawString("Your Score :"+Sm.getGs().getBk().score, 350,245);
					
				}
			
		} else { 
		Sm.draw(g);
		}
		gfx.drawImage(bufferedImage, 0, 0, this);
		
	} //end of paint method

	public void update(){
		Sm.update();
	}
	
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {

			startTime = System.currentTimeMillis();
            
			update();
			repaint();
			endTime = System.currentTimeMillis();
			if (framePeriod - (endTime - startTime) > 0) {
				try {

					Thread.sleep(framePeriod - (endTime - startTime));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block

				} // catch
			} // if

		} // while

	} // run

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		Sm.keyPressed(e);

	} // keypressed

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

		Sm.keyReleased(e);

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	int	xpos = e.getX();
	int	ypos = e.getY();

		// Check if the click was inside the rectangle area.
	if(!Sm.getGs().gameStart){
	if (xpos > rect1xco && xpos < rect1xco + rect1width && ypos > rect1yco
				&& ypos < rect1yco + rect1height) {
              Sm.getGs().gameStart=true;
              Sm.getGs().gameOver=false;
             bg.play();
		   } else{
			   Sm.getGs().gameStart=false;

		}
	}//maoin oif
		// Check if the click was inside the rectangle area for replay.
	else {
	if (xpos > Rrect1xco && xpos < Rrect1xco + Rrect1width && ypos > Rrect1yco
				&& ypos < Rrect1yco + Rrect1height) {
              Sm.getGs().rePlay=false;
              Sm.getGs().gameOver=false;
              Sm.getGs().gameFinished=false;
              bg.stop();
              initBoard();
             
		   } else{
			   Sm.getGs().rePlay=true;;

		}
		
	} //main else
		
		
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

} // JPanel

