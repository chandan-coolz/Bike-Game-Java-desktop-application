import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class ScreenManager {
	GameScreen Gs;

	public ScreenManager() {

		initScreenManager();

	}// ScreenManager

	private void initScreenManager() {
		Gs = new GameScreen();

	}

	//getter and setter
	
	
	
	
	
	public void draw(Graphics g) {
		Gs.draw(g);

	} // graphics

	public GameScreen getGs() {
		return Gs;
	}

	public void setGs(GameScreen gs) {
		Gs = gs;
	}

	public void update(){
		
		Gs.update();
	}
	
	
	
	
	
	
	
	
	// if key is pressed
	public void keyPressed(KeyEvent e) {
        
		Gs.keyPressed(e);

	} // if key is pressed

	// if key is released

	public void keyReleased(KeyEvent e) {

		Gs.keyReleased(e);
	} // if key is released

}// screenManager
