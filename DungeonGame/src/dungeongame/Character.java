package dungeongame;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Character
{
	protected int speed = 0;
	protected int angle = 0;
	protected int x = 0;
	protected int y = 0;
	protected int maxHealth = 0;
	protected int health = 0;
	protected World world;
	protected Color color = null;
	protected Color color2 = null;
	protected Color color3 = null;
	protected Color color4 = null;
	private Rectangle rect = new Rectangle();
	protected int angle2 = 0;
	protected boolean intersect_the_bool = false;
	protected int width = 0;
	protected int height = 0;
	protected int damage = 1;
	protected boolean shoots = true;

	public Character(int x, int y, World world)
	{
		this.x = x;
		this.y = y;
		this.world = world;
	}

	public void Paint(Graphics g)
	{
		g.setColor(color2);
		g.fillRect(x + 1, y - 1, width - 2, height + 2);
		g.fillRect(x - 1, y + 1, width + 2, height - 2);
		g.setColor(color);
		g.fillRect(x, y, width, height);
		g.setColor(new Color(0, 255, 0));
		g.fillRect(x, y - 4, (int) ((double) health / maxHealth * width), 3);
		rect.setBounds(x, y, width, height);
	}

	public void checkIntersect(Character enemy)
	{
		if (enemy.getRect().intersects(rect))
		{
			intersect_the_bool = true;
			angle = (int) Math.toDegrees(Math.atan2(rect.y - enemy.y, rect.x - enemy.x));
			if (enemy.getShoot())
			{
				enemy.health -= enemy.getDamage();
			}
		} else
		{
			intersect_the_bool = false;
		}
	}

	public Rectangle getRect()
	{
		return rect;

	}

	public void Move()
	{
		x += speed * Math.cos(Math.toRadians(angle));
		y += speed * Math.sin(Math.toRadians(angle));
		if (intersect_the_bool)
		{
			x += speed * Math.cos(Math.toRadians(angle2));
			y += speed * Math.sin(Math.toRadians(angle2));
		}

		if (x < 0)
		{
			x = 0;
		}

		if (x > 1264)
		{
			x = 1264;
		}

		if (y < 0)
		{
			y = 0;
		}

		if (y > 922)
		{
			y = 922;
		}
	}

	public boolean getShoot() {
		return shoots;
	}
	
	public int getDamage() {
		return damage;
	}
	
	public void checkIntersect(Projectile shot)
	{
		if (rect.intersects(shot.getRect()))
		{
			if (this instanceof Enemy)
			{
				if (shot.playerShot == 1)
				{
					shot.setOnDaScreen(false);
					this.health -= 10;
					world.addToScore(10);
				} else
				{

				}
			}
			if (this instanceof Player)
			{
				if (shot.playerShot == 0)
				{
					shot.setOnDaScreen(false);
					this.health -= 1;
				} else
				{

				}
			}
		}

	}
}
