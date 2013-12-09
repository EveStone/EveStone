package be.ephec.eveStone.vieuw;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
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
public class StartFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4679000391438807432L;
	private JButton jButtonQuitter;
	private JButton jButtonCommencer;
	private JButton jButtonConfig;
	private JButton jButtonRegles;
	private JButton jButtonChoixHeros;
	
	private static final String PATH_START = "img/StartFrame.png";
	
	public StartFrame(final Controller controller) {
		super();
		initGUI(controller);
	}
	
	private void initGUI(final Controller controller) {
		try {
			pack();
			setSize(850, 638);
			this.setLocationRelativeTo(null);
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
							jButtonQuitterActionPerformed(evt, controller);
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
				{
					jButtonRegles = new JButton();
					background.add(jButtonRegles);
					jButtonRegles.setLayout(null);
					jButtonRegles.setText("<html><font color=white>Règles</font></html>");
					jButtonRegles.setBackground(new java.awt.Color(0,0,0));
					jButtonRegles.setBounds(355, 508, 151, 23);
					jButtonRegles.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							jButtonReglesActionPerformed(evt, controller);
						}
					}); 
				}
			}
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private void jButtonQuitterActionPerformed(ActionEvent evt, final Controller controller) {
		//System.out.println("jButtonQuitter.actionPerformed, event="+evt);
		//TODO add your code for jButtonQuitter.actionPerformed
		try {
			if (controller.getMyClient() != null) controller.getMyClient().getSocket().close();
			if (controller.getServer() != null)controller.getServer().getS().close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.dispose();
	}
	
	private void jButtonConfigActionPerformed(ActionEvent evt, final Controller controller) {
		//System.out.println("jButtonConfig.actionPerformed, event="+evt);
		//TODO add your code for jButtonConfig.actionPerformed
		controller.makeConnectionFrame();
		controller.displayConnectionFrame();
	}
	
	private void jButtonCommencerActionPerformed(ActionEvent evt, final Controller controller) {
		//System.out.println("jButtonCommencer.actionPerformed, event="+evt);
		//TODO add your code for jButtonCommencer.actionPerformed
		controller.makeArea();
		controller.displayArea();
		this.dispose();
	}
	
	private void jButtonChoixHerosActionPerformed(ActionEvent evt, final Controller controller, JButton commencer) {
		//System.out.println("jButtonChoixHeros.actionPerformed, event="+evt);
		//TODO add your code for jButtonChoixHeros.actionPerformed
		new ChoixHeros(controller, commencer);
	}
	
	private void jButtonReglesActionPerformed(ActionEvent evt,final Controller controller) {
		controller.makeRulesFrame();
		controller.displayRulesFrame();
		//TODO add your code for jButtonRegles.actionPerformed
	}

	public JButton getjButtonConfig() {
		return jButtonConfig;
	}

	public void setjButtonConfig(JButton jButtonConfig) {
		this.jButtonConfig = jButtonConfig;
	}

	public JButton getjButtonChoixHeros() {
		return jButtonChoixHeros;
	}

	public void setjButtonChoixHeros(JButton jButtonChoixHeros) {
		this.jButtonChoixHeros = jButtonChoixHeros;
	}
	
}
