package be.ephec.eveStone.vieuw;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import be.ephec.eveStone.controller.Controller;
import java.awt.BorderLayout;
import java.awt.CardLayout;

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
	private JPanel jPanelTerrainAdversaire;
	private JPanel jPanelMainAdversaire;
	private JLabel jLabelRessourceAdversaire;
	private JLabel jLabelSortHeroiqueAdversaire;
	private JLabel jLabelHerosAdversaire;
	private JLabel jLabelSortHeroique;
	private JLabel jLabelRessource;
	private JLabel jLabelHeros;
	private JPanel jPanelMain;
	private JLabel jLabelIconeCoque;
	private JLabel jLabelIconeCoqueAdverse;
	private JLabel jLabel1;
	private JLabel jLabelRessSort;
	private JLabel jLabelIconeStruct;
	private JLabel jLabelStructureAdverse;
	private JLabel jLabelIconeStructAdverse;
	private JLabel jLabelCoqueAdverse;
	private JLabel jLabelStructure;
	private JLabel jLabelCoque;
	private JLabel jLabelInfosCarte;
	private JPanel jPanelTerrain;
	private JButton jButtonFinTour;

	public Area(final Controller controller){
		super("EVE STONE");
		this.setSize(1240, 859);
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
				jButtonFinTour.setBounds(1076, 398, 117, 28);
				jButtonFinTour.setBackground(new java.awt.Color(0,0,0));
				jButtonFinTour.setEnabled(false);
			}
			{
				jPanelMain = new JPanel();
				FlowLayout jPanelMainLayout = new FlowLayout();
				jPanelMainLayout.setAlignOnBaseline(true);
				jPanelMain.setLayout(jPanelMainLayout);
				background.add(jPanelMain);
				jPanelMain.setBounds(243, 657, 708, 166);
				jPanelMain.setOpaque(false);
			}
			{
				jLabelRessource = new JLabel();
				background.add(jLabelRessource);
				jLabelRessource.setText("<html><font color=white>1</font></html>");
				jLabelRessource.setBounds(470, 596, 35, 32);
				jLabelRessource.setFont(new java.awt.Font("Bitstream Charter",1,26));
			}
			{
				jPanelTerrainAdversaire = new JPanel();
				background.add(jPanelTerrainAdversaire);
				FlowLayout jPanelTerrainAdversaireLayout = new FlowLayout();
				jPanelTerrainAdversaireLayout.setAlignOnBaseline(true);
				jPanelTerrainAdversaire.setLayout(jPanelTerrainAdversaireLayout);
				jPanelTerrainAdversaire.setBounds(206, 253, 799, 177);
				jPanelTerrainAdversaire.setOpaque(false);
			}
			{
				jLabelSortHeroique = new JLabel();
				background.add(jLabelSortHeroique);
				jLabelSortHeroique.setText(" ");
				jLabelSortHeroique.setBounds(693, 592, 80, 78);
			}
			{
				jLabelRessourceAdversaire = new JLabel();
				background.add(jLabelRessourceAdversaire);
				jLabelRessourceAdversaire.setText("<html><font color=white>1</font></html>");
				jLabelRessourceAdversaire.setBounds(465, 190, 41, 49);
				jLabelRessourceAdversaire.setFont(new java.awt.Font("Purisa",1,20));
			}
			{
				jLabelHerosAdversaire = new JLabel();
				background.add(jLabelHerosAdversaire);
				jLabelHerosAdversaire.setText(" ");
				jLabelHerosAdversaire.setBounds(542, 151, 117, 120);
			}
			{
				jLabelSortHeroiqueAdversaire = new JLabel();
				background.add(jLabelSortHeroiqueAdversaire);
				jLabelSortHeroiqueAdversaire.setText(" ");
				jLabelSortHeroiqueAdversaire.setBounds(686, 175, 79, 83);
			}
			{
				jPanelMainAdversaire = new JPanel();
				background.add(jPanelMainAdversaire);
				jPanelMainAdversaire.setBounds(20, 7, 1182, 133);
				jPanelMainAdversaire.setOpaque(false);
			}
			{
				jPanelTerrain = new JPanel();
				background.add(jPanelTerrain);
				jPanelTerrain.setBounds(141, 395, 901, 184);
				jPanelTerrain.setOpaque(false);
			}
			{
				jLabelInfosCarte = new JLabel();
				background.add(jLabelInfosCarte);
				jLabelInfosCarte.setText(" ");
				jLabelInfosCarte.setBounds(2, 285, 244, 256);
				jLabelInfosCarte.setBorder(BorderFactory.createTitledBorder(""));
			}
			{
				jLabelCoque = new JLabel();
				background.add(jLabelCoque);
				jLabelCoque.setText("<html><font color=cyan>20</font></html>");
				jLabelCoque.setBounds(519, 544, 35, 27);
				jLabelCoque.setBackground(Color.RED);
				jLabelCoque.setFont(new java.awt.Font("Bitstream Charter",1,24));
			}
			{
				jLabelStructure = new JLabel();
				background.add(jLabelStructure);
				jLabelStructure.setText("<html><font color=white>10</font></html>");
				jLabelStructure.setBounds(648, 541, 29, 32);
				jLabelStructure.setBackground(Color.BLACK);
				jLabelStructure.setFont(new java.awt.Font("Bitstream Charter",1,24));
			}
			{
				jLabelCoqueAdverse = new JLabel();
				background.add(jLabelCoqueAdverse);
				jLabelCoqueAdverse.setText("<html><font color=black>20</font></html>");
				jLabelCoqueAdverse.setBounds(519, 143, 28, 28);
				jLabelCoqueAdverse.setFont(new java.awt.Font("Purisa",1,20));
			}
			{
				jLabelStructureAdverse = new JLabel();
				background.add(jLabelStructureAdverse);
				{
					jLabelIconeStruct = new JLabel();
					background.add(jLabelIconeStruct);
					jLabelIconeStruct.setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/vieHeros_p.png")));
					jLabelIconeStruct.setBounds(637, 531, 52, 55);
				}
				{
					jLabelIconeStructAdverse = new JLabel();
					background.add(jLabelIconeStructAdverse);
					jLabelIconeStructAdverse.setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/vieHeros_p.png")));
					jLabelIconeStructAdverse.setBounds(640, 126, 54, 52);
				}
				{
					this.jLabelCoque = jLabelCoque;
					background.add(jLabelCoque);
				}
				{
					jLabelIconeCoque = new JLabel();
					background.add(jLabelIconeCoque);
					BorderLayout jLabelIconeCoqueLayout = new BorderLayout();
					jLabelIconeCoque.setLayout(jLabelIconeCoqueLayout);
					jLabelIconeCoque.setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/coqueHeros_p.png")));
					jLabelIconeCoque.setBounds(506, 126, 57, 64);
				}
				{
					jLabelIconeCoqueAdverse = new JLabel();
					background.add(jLabelIconeCoqueAdverse);
					BorderLayout jLabelIconeCoqueLayout = new BorderLayout();
					jLabelIconeCoqueAdverse.setLayout(jLabelIconeCoqueLayout);
					jLabelIconeCoqueAdverse.setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/coqueHeros_p.png")));
					jLabelIconeCoqueAdverse.setBounds(509, 526, 54, 64);
				}
				{
					jLabelHeros = new JLabel();
					background.add(jLabelHeros);
					jLabelHeros.setText(" ");
					jLabelHeros.setBounds(538, 546, 134, 143);
					jLabelHeros.setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/Interceptor.png")));
				}
				{
					jLabel1 = new JLabel();
					background.add(jLabel1);
					jLabel1.setText("<html><font color=orange>2</font></html>");
					jLabel1.setBounds(752, 574, 31, 27);
					jLabel1.setFont(new java.awt.Font("Bitstream Charter",1,36));
				}
				{
					jLabelRessSort = new JLabel();
					background.add(jLabelRessSort);
					jLabelRessSort.setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/CapacitorSort.png")));
					jLabelRessSort.setBounds(739, 558, 47, 58);
				}
				jLabelStructureAdverse.setText("<html><font color=white>10</font></html>");
				jLabelStructureAdverse.setBounds(652, 137, 32, 26);
				jLabelStructureAdverse.setFont(new java.awt.Font("Purisa",1,20));
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
	
	public JLabel getLabelInfo(){
		return this.jLabelInfosCarte;
	}

	public JLabel getjLabelStructureAdverse() {
		return jLabelStructureAdverse;
	}

	public void setjLabelStructureAdverse(JLabel jLabelStructureAdverse) {
		this.jLabelStructureAdverse = jLabelStructureAdverse;
	}

	public JLabel getjLabelCoqueAdverse() {
		return jLabelCoqueAdverse;
	}

	public void setjLabelCoqueAdverse(JLabel jLabelCoqueAdverse) {
		this.jLabelCoqueAdverse = jLabelCoqueAdverse;
	}

	public JLabel getjLabelStructure() {
		return jLabelStructure;
	}

	public void setjLabelStructure(JLabel jLabelStructure) {
		this.jLabelStructure = jLabelStructure;
	}

	public JLabel getjLabelCoque() {
		return jLabelCoque;
	}

	public void setjLabelCoque(JLabel jLabelCoque) {
	}
	
}
