package be.ephec.eveStone.vieuw;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
/**
 * 
 * @author Vanbutsele Andy
 *
 * Classe représentant la fenêtre de jeu.
 */
public class Area extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8140867745881460741L;
	private static final String PATH_BG = "img/Background.png";
	private JLabel jLabel2;
	private JLabel jLabelRessource;
	private JLabel jLabelHeros;
	public JPanel jPanelMain;
	private JButton jButtonFinTour;

	private JLabel jLabel1;

	public Area(final Controller controller){
		super("EVE STONE");
		this.setSize(1200, 800);
		this.initGUI(controller);
	}
	
	private void initGUI(final Controller controller){
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
			{
				jButtonFinTour = new JButton();
				background.add(jButtonFinTour);
				jButtonFinTour.setText("<html><font color=white>Fin de tour</font></html>");
				jButtonFinTour.setBounds(952, 366, 117, 28);
				jButtonFinTour.setBackground(new java.awt.Color(0,0,0));
				jButtonFinTour.setEnabled(false);
			}
			{
				jPanelMain = new JPanel();
				background.add(jPanelMain);
				jPanelMain.setBounds(246, 638, 706, 159);
				jPanelMain.setOpaque(false);
			}
			{
				jLabel2 = new JLabel();
				background.add(jLabel2);
				jLabel2.setText("");
				jLabel2.setBounds(975, 522, 77, 116);
			}
			{
				jLabelHeros = new JLabel();
				background.add(jLabelHeros);
				jLabelHeros.setText(" ");
				jLabelHeros.setBounds(536, 546, 124, 124);
			}
			{
				jLabelRessource = new JLabel();
				background.add(jLabelRessource);
				jLabelRessource.setText("<html><font color=white>1</font></html>");
				jLabelRessource.setBounds(470, 579, 60, 33);
				jLabelRessource.setFont(new java.awt.Font("Purisa",1,20));
			}
		}
	}
	
	public void display(){
		this.setVisible(true);
	}
	
	public JLabel getDeckPanel(){
		return this.jLabel2;
	}
	
	public JPanel getPanelMain(){
		return this.jPanelMain;
	}
	
	public JLabel getLabelHeros(){
		return this.jLabelHeros;
	}
	
	public JLabel getLabelRessource(){
		return this.jLabelRessource;
	}
	
	public JButton getFinTourButton(){
		return jButtonFinTour;
	}
}
