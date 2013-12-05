package be.ephec.eveStone.vieuw;

import java.awt.Color;
import java.awt.FlowLayout;

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
	private JPanel jPanelTerrain;
	private JPanel jPanelTerrainAdversaire;
	private JPanel jPanelMainAdversaire;
	private JLabel jLabelRessourceAdversaire;
	private JLabel jLabelSortHeroiqueAdversaire;
	private JLabel jLabelHerosAdversaire;
	private JLabel jLabelSortHeroique;
	private JLabel jLabelRessource;
	private JLabel jLabelHeros;
	private JPanel jPanelMain;
	private JButton jButtonFinTour;

	public Area(final Controller controller){
		super("EVE STONE");
		this.setSize(1220, 800);
		this.setBackground(Color.BLACK);
		this.setResizable(false);
		this.initGUI(controller);
	}
	
	private void initGUI(final Controller controller){
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		{
			JLabel background = new JLabel();
			this.setContentPane(background);
			background.setIcon(new ImageIcon(getClass().getClassLoader().getResource(PATH_BG)));
			background.setPreferredSize(new java.awt.Dimension(1204, 944));
			{
				jButtonFinTour = new JButton();
				background.add(jButtonFinTour);
				jButtonFinTour.setText("<html><font color=white>Fin de tour</font></html>");
				jButtonFinTour.setBounds(1023, 513, 117, 28);
				jButtonFinTour.setBackground(new java.awt.Color(0,0,0));
				jButtonFinTour.setEnabled(false);
			}
			{
				jPanelTerrain = new JPanel();
				background.add(jPanelTerrain);
				jPanelTerrain.setAlignmentY(BOTTOM_ALIGNMENT);
				jPanelTerrain.setBounds(199, 544, 799, 317);
				jPanelTerrain.setOpaque(false);
			}
			{
				jPanelMain = new JPanel();
				jPanelMain.setAlignmentY(BOTTOM_ALIGNMENT);
				FlowLayout jPanelMainLayout = new FlowLayout();
				jPanelMainLayout.setAlignOnBaseline(true);
				jPanelMain.setLayout(jPanelMainLayout);
				background.add(jPanelMain);
				jPanelMain.setBounds(20, 737, 1172, 324);
				jPanelMain.setOpaque(false);
			}
			{
				jLabelRessource = new JLabel();
				background.add(jLabelRessource);
				jLabelRessource.setText("<html><font color=white>1</font></html>");
				jLabelRessource.setBounds(474, 712, 59, 29);
				jLabelRessource.setFont(new java.awt.Font("Purisa",1,20));
			}
			{
				jLabelSortHeroique = new JLabel();
				background.add(jLabelSortHeroique);
				jLabelSortHeroique.setText(" ");
				jLabelSortHeroique.setBounds(686, 688, 81, 78);
			}
			{
				jLabelRessourceAdversaire = new JLabel();
				background.add(jLabelRessourceAdversaire);
				jLabelRessourceAdversaire.setText("<html><font color=white>1</font></html>");
				jLabelRessourceAdversaire.setBounds(463, 306, 35, 41);
				jLabelRessourceAdversaire.setFont(new java.awt.Font("Purisa",1,20));
			}
			{
				jLabelHerosAdversaire = new JLabel();
				background.add(jLabelHerosAdversaire);
				jLabelHerosAdversaire.setText(" ");
				jLabelHerosAdversaire.setBounds(546, 269, 117, 120);
			}
			{
				jLabelSortHeroiqueAdversaire = new JLabel();
				background.add(jLabelSortHeroiqueAdversaire);
				jLabelSortHeroiqueAdversaire.setText(" ");
				jLabelSortHeroiqueAdversaire.setBounds(686, 283, 81, 83);
			}
			{
				jPanelMainAdversaire = new JPanel();
				background.add(jPanelMainAdversaire);
				jPanelMainAdversaire.setBounds(20, 7, 1182, 250);
				jPanelMainAdversaire.setOpaque(false);
			}
			{
				jPanelTerrainAdversaire = new JPanel();
				background.add(jPanelTerrainAdversaire);
				jPanelTerrainAdversaire.setBounds(217, 288, 799, 223);
				jPanelTerrainAdversaire.setOpaque(false);
			}
			{
				jLabelHeros = new JLabel();
				background.add(jLabelHeros);
				jLabelHeros.setText(" ");
				jLabelHeros.setBounds(541, 663, 133, 142);
				jLabelHeros.setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/Interceptor.png")));
			}
		}
	}
	
	public void display(){
		this.setVisible(true);
	}
	
	public JPanel getPanelMain(){
		return this.jPanelMain;
	}
	
	public JPanel getjPanelTerrain() {
		return jPanelTerrain;
	}

	public JPanel getjPanelTerrainAdversaire() {
		return jPanelTerrainAdversaire;
	}

	public JPanel getjPanelMainAdversaire() {
		return jPanelMainAdversaire;
	}

	public JLabel getjLabelHerosAdversaire() {
		return jLabelHerosAdversaire;
	}

	public JLabel getjLabelHeros(){
		return this.jLabelHeros;
	}
	public JLabel getjLabelSortHeroique() {
		return this.jLabelSortHeroique;
	}
	
	
	public JLabel getjLabelRessourceAdversaire() {
		return jLabelRessourceAdversaire;
	}

	public JLabel getjLabelSortHeroiqueAdversaire() {
		return jLabelSortHeroiqueAdversaire;
	}

	public JLabel getjLabelRessource(){
		return this.jLabelRessource;
	}
	
	public JButton getFinTourButton(){
		return jButtonFinTour;
	}	
}
