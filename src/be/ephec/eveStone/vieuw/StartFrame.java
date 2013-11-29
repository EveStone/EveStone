package be.ephec.eveStone.vieuw;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import be.ephec.eveStone.controller.Controller;

/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class StartFrame extends javax.swing.JWindow {
	private JButton jButtonQuitter;
	private JButton jButtonCommencer;
	private JButton jButtonConfig;
	private JButton jButtonChoixHeros;
	
	private static final String PATH_START = "img/StartFrame.png";

	/**
	* Auto-generated main method to display this JFrame
	*/
	/*
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				StartFrame inst = new StartFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}*/
	
	public StartFrame(final Controller controller) {
		super();
		initGUI(controller);
	}
	
	private void initGUI(final Controller controller) {
		try {
			pack();
			setSize(850, 638);
			this.setLocationRelativeTo(null);
			this.setVisible(true);
			{
				JLabel background = new JLabel();
				this.setContentPane(background);
				background.setIcon(new ImageIcon(getClass().getClassLoader().getResource(PATH_START)));
				{
					jButtonQuitter = new JButton();
					background.add(jButtonQuitter);
					jButtonQuitter.setLayout(null);
					jButtonQuitter.setText("<html><font color=white>Quitter</font></html>");
					jButtonQuitter.setBounds(700, 587, 124, 22);
					jButtonQuitter.setBackground(new java.awt.Color(0,0,0));
					jButtonQuitter.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							jButtonQuitterActionPerformed(evt);
						}
					});
				}
				{
					jButtonCommencer = new JButton();
					jButtonCommencer.setEnabled(false);
					background.add(jButtonCommencer);
					jButtonCommencer.setLayout(null);
					jButtonCommencer.setText("<html><font color=white>Commencer</font></html>");
					jButtonCommencer.setBounds(355, 408, 151, 22);
					jButtonCommencer.setBackground(new java.awt.Color(0,0,0));
					jButtonCommencer.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							jButtonCommencerActionPerformed(evt, controller);
						}
					});
				}
				{
					jButtonConfig = new JButton();
					background.add(jButtonConfig);
					jButtonConfig.setLayout(null);
					jButtonConfig.setBounds(355, 442, 151, 22);
					jButtonConfig.setText("<html><font color=white>Configuration</font></html>");
					jButtonConfig.setBackground(new java.awt.Color(0,0,0));
					jButtonConfig.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							jButtonConfigActionPerformed(evt, controller);
						}
					});
				}
				{
					jButtonChoixHeros = new JButton();
					background.add(jButtonChoixHeros);
					jButtonChoixHeros.setLayout(null);
					jButtonChoixHeros.setText("<html><font color=white>Choix du Héros</font></html>");
					jButtonChoixHeros.setBounds(355, 475, 151, 22);
					jButtonChoixHeros.setBackground(new java.awt.Color(0,0,0));
					jButtonChoixHeros.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							jButtonChoixHerosActionPerformed(evt, controller, jButtonCommencer);
						}
					});
				}
			}
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private void jButtonQuitterActionPerformed(ActionEvent evt) {
		//System.out.println("jButtonQuitter.actionPerformed, event="+evt);
		//TODO add your code for jButtonQuitter.actionPerformed
		this.dispose();
	}
	
	private void jButtonConfigActionPerformed(ActionEvent evt, final Controller controller) {
		//System.out.println("jButtonConfig.actionPerformed, event="+evt);
		//TODO add your code for jButtonConfig.actionPerformed
		new ConnectionFrame(controller);
	}
	
	private void jButtonCommencerActionPerformed(ActionEvent evt, final Controller controller) {
		//System.out.println("jButtonCommencer.actionPerformed, event="+evt);
		//TODO add your code for jButtonCommencer.actionPerformed
		Area newGame = new Area(controller);
		this.dispose();
	}
	
	private void jButtonChoixHerosActionPerformed(ActionEvent evt, final Controller controller, JButton commencer) {
		//System.out.println("jButtonChoixHeros.actionPerformed, event="+evt);
		//TODO add your code for jButtonChoixHeros.actionPerformed
		new ChoixHeros(controller, commencer);
	}
}
