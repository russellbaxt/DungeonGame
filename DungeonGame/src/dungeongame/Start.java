package dungeongame;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

// Copyright 2014 Russ Baxt
public class Start implements ActionListener, KeyListener, MouseListener

{
	private JFrame frame;
	private Draw draw;
	private Timer paintTimer;
	private Timer worldTimer;
	private World world = new World();

	public static void main(String[] args)
	{
		new Start().getGoing();
	}

	public void getGoing()
	{
		draw = new Draw(world);
		paintTimer = new Timer(33, this);
		worldTimer = new Timer(33, this);
		frame = new JFrame("Dungeon Game");
		frame.setSize(1280, 960);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.add(this);
		frame.add(draw);
		frame.setVisible(true);
		paintTimer.start();
		worldTimer.start();
		//frame.addKeyListener(draw);
		//frame.addMouseListener(this);
	}

//	public void paint(Graphics g)
//	{
//		draw.paint(g);
//	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource().equals(paintTimer))
		{
			draw.repaint();
		}
		if (e.getSource().equals(worldTimer))
		{
			world.move();
		}
	}

	@Override
	public void keyPressed(KeyEvent arg0)
	{

	}

	@Override
	public void keyReleased(KeyEvent arg0)
	{
		
	}

	@Override
	public void keyTyped(KeyEvent arg0)
	{
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0)
	{
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0)
	{
		
	}

	@Override
	public void mouseExited(MouseEvent arg0)
	{
		
	}

	@Override
	public void mousePressed(MouseEvent arg0)
	{
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0)
	{
		
	}

}
