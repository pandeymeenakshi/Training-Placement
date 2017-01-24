/*
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Main extends JWindow 
{

	JPanel panel = new JPanel();
	JProgressBar progressBar = new JProgressBar();        
	ImageIcon i1=new ImageIcon("GEHU.png");
	Image image = i1.getImage(); // transform it 
	Image newimg = image.getScaledInstance(500,500,java.awt.Image.SCALE_SMOOTH); 
	ImageIcon i2=new ImageIcon(newimg);
    JLabel background=new JLabel(i2,JLabel.CENTER);
	public Main() 
		{
	        background.setLayout(new BorderLayout());
			background.add(progressBar, BorderLayout.SOUTH);
			background.setFocusable(true); 
			progressBar.setForeground(Color.DARK_GRAY);
			progressBar.setStringPainted(true);
            add(background);
		Timer timer = new Timer(50, new ActionListener() {
			int i = 0;
			public void actionPerformed(ActionEvent evt) {
				progressBar.setValue(i);
				i++;
				panel.repaint();
				if (i == 100) {
					((Timer) evt.getSource()).stop();
					dispose();   MainMenu frm=new MainMenu();
		             frm.setVisible(true);
				}
			}
		});
		timer.start();
	}

	public static void main(String[] args) {
		
            Main w = new Main();
            w.pack();
            w.setLocationRelativeTo(null);
            w.setVisible(true);
	}
}
*/


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import javax.swing.*;

public class Main extends JWindow {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel panel = new JPanel();
	JProgressBar progressBar = new JProgressBar();
        JLabel background=new JLabel(new ImageIcon("psk.png"));
	public Main() {
                background.setLayout(new BorderLayout());
		background.add(progressBar, BorderLayout.SOUTH);
		background.setFocusable(true); 
		progressBar.setForeground(Color.red);
		progressBar.setStringPainted(true);
                add(background);
		Timer timer = new Timer(50, new ActionListener() {
			int i = 0;

			public void actionPerformed(ActionEvent evt) {
				progressBar.setValue(i);
				i++;
				panel.repaint();
				if (i == 100) {
					((Timer) evt.getSource()).stop();
					dispose();
                                      
                            				
                            	   MainMenu frm=new MainMenu();
                            		             frm.setVisible(true);
                            				
				}
			}
		});
		timer.start();
	}

	public static void main(String[] args) {
		
            Main w = new Main();
            w.setSize(1440, 730);
            w.setLocationRelativeTo(null);
            w.setVisible(true);    
	}
}
