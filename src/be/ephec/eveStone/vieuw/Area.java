package be.ephec.eveStone.vieuw;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import be.ephec.eveStone.controller.Controller;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;

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
/**
 * 
 * @author Vanbutsele Andy
 *
 * Classe représentant la fenêtre de jeu.
 */
public class Area extends JFrame {
	
	private static final String PATH_BG = "img/Background.png";

	private JLabel jLabel1;

	public Area(final Controller controller){
		super();
		this.setSize(1200, 800);
		this.initGUI();
	}
	
	private void initGUI(){
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		{
			JLabel background = new JLabel();
			this.setContentPane(background);
			background.setIcon(new ImageIcon(getClass().getClassLoader().getResource(PATH_BG)));
			{
				jLabel1 = new JLabel();
				background.add(jLabel1);
				jLabel1.setText("");
				jLabel1.setLayout(null);
				jLabel1.setBounds(603, 530, 85, 76);
			}
		}
	}
}
