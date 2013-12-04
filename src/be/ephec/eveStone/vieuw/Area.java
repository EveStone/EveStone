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

	private JLabel jLabel1;

	public Area(final Controller controller){
		super("EVE STONE");
		this.setSize(1200, 819);
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
				jButtonFinTour.setBounds(1018, 371, 117, 28);
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
				jLabelHeros.setBounds(539, 522, 133, 142);
				jLabelHeros.setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/Interceptor.png")));
			}
			{
				jLabelRessource = new JLabel();
				background.add(jLabelRessource);
				jLabelRessource.setText("<html><font color=white>1</font></html>");
				jLabelRessource.setBounds(470, 573, 60, 31);
				jLabelRessource.setFont(new java.awt.Font("Purisa",1,20));
			}
			{
				jLabelSortHeroique = new JLabel();
				background.add(jLabelSortHeroique);
				jLabelSortHeroique.setText(" ");
				jLabelSortHeroique.setBounds(684, 541, 81, 78);
			}
			{
				jLabelRessourceAdversaire = new JLabel();
				background.add(jLabelRessourceAdversaire);
				jLabelRessourceAdversaire.setText("<html><font color=white>1</font></html>");
				jLabelRessourceAdversaire.setBounds(465, 168, 35, 41);
				jLabelRessourceAdversaire.setFont(new java.awt.Font("Purisa",1,20));
			}
			{
				jLabelHerosAdversaire = new JLabel();
				background.add(jLabelHerosAdversaire);
				jLabelHerosAdversaire.setText(" ");
				jLabelHerosAdversaire.setBounds(543, 119, 117, 120);
			}
			{
				jLabelSortHeroiqueAdversaire = new JLabel();
				background.add(jLabelSortHeroiqueAdversaire);
				jLabelSortHeroiqueAdversaire.setText(" ");
				jLabelSortHeroiqueAdversaire.setBounds(684, 138, 81, 83);
			}
			{
				jPanelMainAdversaire = new JPanel();
				background.add(jPanelMainAdversaire);
				jPanelMainAdversaire.setBounds(273, 12, 665, 95);
				jPanelMainAdversaire.setOpaque(false);
			}
			{
				jPanelTerrainAdversaire = new JPanel();
				background.add(jPanelTerrainAdversaire);
				jPanelTerrainAdversaire.setBounds(207, 255, 799, 116);
				jPanelTerrainAdversaire.setOpaque(false);
			}
			{
				jPanelTerrain = new JPanel();
				background.add(jPanelTerrain);
				jPanelTerrain.setBounds(202, 383, 799, 136);
				jPanelTerrain.setOpaque(false);
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
