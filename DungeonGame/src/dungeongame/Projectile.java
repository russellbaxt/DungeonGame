package dungeongame;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Projectile {
	private int x;
	private int y;
	private int width;
	private int height;
	private int endpos;
	private Rectangle rect = new Rectangle();
	private Draw paint = null;
	private int speed;
	private int angle;
	private boolean isOnScreen = true;
	int playerShot;

	public Projectile(int x, int y, int width, int height, int speed,
			int angle, int playerShot) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.speed = speed;
		this.angle = angle;
		this.playerShot = playerShot;

	}

	public void move() {
		x += speed * Math.cos(Math.toRadians(angle));
		y += speed * Math.sin(Math.toRadians(angle));
	}

	public boolean isOnDaScreen() {
		return isOnScreen;
	}
	
	public void setOnDaScreen(boolean value) {
		isOnScreen = value;
	}

	public void paint(Graphics g) {
		g.setColor(new Color(127, 127, 127));
		g.fillRect(x, y, width, height);
		rect.setBounds(x, y, 6, 6);

		if (x < 0) {
			isOnScreen = false;
		}

		if (x > 1264) {
			isOnScreen = false;
		}

		if (y < 0) {
			isOnScreen = false;
		}

		if (y > 922) {
			isOnScreen = false;
		}
	}

	public Rectangle getRect() {
		return rect;
	}
}
