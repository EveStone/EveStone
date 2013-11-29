package be.ephec.eveStone.vieuw;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

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
	
	private JMenuItem jMenuItem2;
	private JMenuItem jMenuItem1;
	private JMenu jMenu3;
	private JMenu jMenu2;
	private JMenu jMenu1;
	private JMenuBar jMenuBar1;
	private JPanel jPanel1;
	private JLabel jLabel1;

	public Area(){
		super();
		this.setSize(1440, 1152);
		this.initGUI();
	}
	
	private void initGUI(){

	}
	
	public void run(){
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		{
			JLabel background = new JLabel();
			this.setContentPane(background);
			background.setIcon(new ImageIcon(getClass().getClassLoader().getResource(PATH_BG)));
			{
				jPanel1 = new JPanel();
				getContentPane().add(jPanel1, BorderLayout.CENTER);
				jPanel1.setLayout(new GridBagLayout());
			}
			{
				jLabel1 = new JLabel();
				background.add(jLabel1);
				jLabel1.setText(" ");
				jLabel1.setLayout(null);
				jLabel1.setBounds(603, 530, 85, 76);
			}
		}
		this.initGUI();
		{
			jMenuBar1 = new JMenuBar();
			setJMenuBar(jMenuBar1);
			{
				jMenu1 = new JMenu();
				jMenuBar1.add(jMenu1);
				jMenu1.setText("Fichier");
				jMenu1.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
				{
					jMenuItem1 = new JMenuItem();
					jMenu1.add(jMenuItem1);
					jMenuItem1.setText("Nouveau");
				}
				{
					jMenuItem2 = new JMenuItem();
					jMenu1.add(jMenuItem2);
					jMenuItem2.setText("Quitter");
				}
			}
			{
				jMenu2 = new JMenu();
				jMenuBar1.add(jMenu2);
				jMenu2.setText("Editer");
				jMenu2.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
			}
			{
				jMenu3 = new JMenu();
				jMenuBar1.add(jMenu3);
				jMenu3.setText("A Propos");
				jMenu3.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
			}
		}
	}
}
