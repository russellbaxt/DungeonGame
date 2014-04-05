package dungeongame;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Player extends Character
{
	boolean keyUp = false;
	boolean keyDown = false;
	boolean keyLeft = false;
	boolean keyRight = false;

	public Player(int x, int y, World world)
	{
		super(x, y, world);
		maxHealth = 30;
		health = maxHealth;
		color = new Color(0, 128, 255);
		color2 = new Color(0, 64, 192);
		width = 16;
		height = 16;
	}

	public void KeyPressed(KeyEvent arg0)
	{
		checkKeyPress(arg0);
	}

	private void checkKeyPress(KeyEvent arg0)
	{
		if (arg0.getKeyCode() == KeyEvent.VK_W)
		{
			keyUp = true;
			speed = 8;
		}

		if (arg0.getKeyCode() == KeyEvent.VK_S)
		{
			keyDown = true;
			speed = 8;
		}

		if (arg0.getKeyCode() == KeyEvent.VK_A)
		{
			keyLeft = true;
			speed = 8;
		}

		if (arg0.getKeyCode() == KeyEvent.VK_D)
		{
			keyRight = true;
			speed = 8;
		}
	}

	public void KeyReleased(KeyEvent arg0)
	{
		if (arg0.getKeyCode() == KeyEvent.VK_W)
		{
			keyUp = false;
		}

		if (arg0.getKeyCode() == KeyEvent.VK_S)
		{
			keyDown = false;
		}

		if (arg0.getKeyCode() == KeyEvent.VK_A)
		{
			keyLeft = false;
		}

		if (arg0.getKeyCode() == KeyEvent.VK_D)
		{
			keyRight = false;

		}
		if (keyUp == false && keyDown == false && keyRight == false && keyLeft == false)
		{
			speed = 0;
		}

	}

	public void shoot(MouseEvent arg0)
	{
		angle = (int) Math.toDegrees(Math.atan2(-y + arg0.getY(), -x + arg0.getX()));
		world.addProjectiles(new Projectile(x, y, 6, 6, 12, angle, 1));
	}

	public void Move()
	{
		if (keyUp)
		{
			angle = 270;
		}

		if (keyDown)
		{
			angle = 90;
		}

		if (keyLeft)
		{
			angle = 180;
		}

		if (keyRight)
		{
			angle = 0;
		}

		if (keyRight && keyUp)
		{
			angle = 315;
		}

		if (keyRight && keyDown)
		{
			angle = 40;
		}

		if (keyDown && keyLeft)
		{
			angle = 130;
		}

		if (keyLeft && keyUp)
		{
			angle = 220;
		}

		super.Move();

	}

}
