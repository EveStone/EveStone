package be.ephec.eveStone.vieuw;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

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

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				StartFrame inst = new StartFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public StartFrame() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			pack();
			setSize(850, 638);
			{
				JLabel background = new JLabel();
				this.setContentPane(background);
				background.setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/StartFrame.png")));
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
					background.add(jButtonCommencer);
					jButtonCommencer.setLayout(null);
					jButtonCommencer.setText("<html><font color=white>Commencer</font></html>");
					jButtonCommencer.setBounds(367, 408, 124, 22);
					jButtonCommencer.setBackground(new java.awt.Color(0,0,0));
					jButtonCommencer.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							jButtonCommencerActionPerformed(evt);
						}
					});
				}
				{
					jButtonConfig = new JButton();
					background.add(jButtonConfig);
					jButtonConfig.setLayout(null);
					jButtonConfig.setBounds(367, 442, 124, 22);
					jButtonConfig.setText("<html><font color=white>Configuration</font></html>");
					jButtonConfig.setBackground(new java.awt.Color(0,0,0));
					jButtonConfig.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							jButtonConfigActionPerformed(evt);
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
	
	private void jButtonConfigActionPerformed(ActionEvent evt) {
		//System.out.println("jButtonConfig.actionPerformed, event="+evt);
		//TODO add your code for jButtonConfig.actionPerformed
		ConnectionFrame connect = new ConnectionFrame();
	}
	
	private void jButtonCommencerActionPerformed(ActionEvent evt) {
		//System.out.println("jButtonCommencer.actionPerformed, event="+evt);
		//TODO add your code for jButtonCommencer.actionPerformed
		Area newGame = new Area();
		this.dispose();
		newGame.run();
	}

}
