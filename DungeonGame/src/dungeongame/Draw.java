package dungeongame;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.SwingUtilities;

public class Draw extends Canvas implements KeyListener, MouseListener {
	private ArrayList<Character> characters;
	private ArrayList<Projectile> projectiles;
	private World world;
	private int score;

	public Draw(World world) {
		this.world = world;
		this.addMouseListener(this);
		this.addKeyListener(this);
		characters = world.getCharacterArray();
		projectiles = world.getProjectileArray();
	}

	public void paint(Graphics g) {
		score = world.score;
//		g.setFont(new Font("Arial", 0, 100));
//		g.drawString("" + score, 5, 80);
		for (int i = 0; i < characters.size(); i++) {
			characters.get(i).Paint(g);
		}
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).paint(g);
		}

	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		if (characters.get(0) instanceof Player) {
			((Player) characters.get(0)).KeyPressed(arg0);
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		if (characters.get(0) instanceof Player) {
			((Player) characters.get(0)).KeyReleased(arg0);
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {

	}

	@Override
	public void mouseExited(MouseEvent arg0) {

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		if (!characters.isEmpty() && characters.get(0) instanceof Player) {
			((Player) characters.get(0)).shoot(arg0);
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {

	}
}
