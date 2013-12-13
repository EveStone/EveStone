package be.ephec.eveStone.vieuw;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import be.ephec.eveStone.controller.Controller;
import be.ephec.eveStone.sound.SonPlayer;

import java.awt.BorderLayout;

// TODO: Auto-generated Javadoc
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
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8140867745881460741L;
	
	/** The Constant PATH_BG. */
	private static final String PATH_BG = "img/Background.png";
	
	/** The j panel terrain adversaire. */
	private JPanel jPanelTerrainAdversaire;
	
	/** The j panel main adversaire. */
	private JPanel jPanelMainAdversaire;
	
	/** The j label ressource adversaire. */
	private JLabel jLabelRessourceAdversaire;
	
	/** The j label sort heroique adversaire. */
	private JLabel jLabelSortHeroiqueAdversaire;
	
	/** The j label heros adversaire. */
	private JLabel jLabelHerosAdversaire;
	
	/** The j label sort heroique. */
	private JLabel jLabelSortHeroique;
	
	/** The j label ressource. */
	private JLabel jLabelRessource;
	
	/** The j label heros. */
	private JLabel jLabelHeros;
	
	/** The j panel main. */
	private JPanel jPanelMain;
	
	/** The j label icone coque. */
	private JLabel jLabelIconeCoque;
	
	/** The j label icone coque adverse. */
	private JLabel jLabelIconeCoqueAdverse;
	
	/** The j label1. */
	private JLabel jLabel1;
	
	/** The j label ress sort. */
	private JLabel jLabelRessSort;
	
	/** The j label icone struct. */
	private JLabel jLabelIconeStruct;
	
	/** The j label structure adverse. */
	private JLabel jLabelStructureAdverse;
	
	/** The j label icone struct adverse. */
	private JLabel jLabelIconeStructAdverse;
	
	/** The j label coque adverse. */
	private JLabel jLabelCoqueAdverse;
	
	/** The j label structure. */
	private JLabel jLabelStructure;
	
	/** The j label coque. */
	private JLabel jLabelCoque;
	
	/** The j label infos carte. */
	private JLabel jLabelInfosCarte;
	
	/** The j panel terrain. */
	private JPanel jPanelTerrain;
	
	/** The j button fin tour. */
	private JButton jButtonFinTour;
	
	/** The background. */
	private SonPlayer background;

	/**
	 * Instantiates a new area.
	 *
	 * @param controller the controller
	 */
	public Area(final Controller controller){
		super("EVE STONE");
		this.setSize(1240, 859);
		this.setBackground(Color.BLACK);
		this.setResizable(false);
		this.initGUI(controller);
	}
	
	/**
	 * Inits the gui.
	 *
	 * @param controller the controller
	 */
	private void initGUI(final Controller controller){
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
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
				jLabelHerosAdversaire.setBounds(542, 151, 126, 127);
			}
			{
				jLabelSortHeroiqueAdversaire = new JLabel();
				background.add(jLabelSortHeroiqueAdversaire);
				jLabelSortHeroiqueAdversaire.setText(" ");
				jLabelSortHeroiqueAdversaire.setBounds(686, 172, 79, 86);
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
	
	/**
	 * Display.
	 */
	public void display(){
		this.setVisible(true);
	}
	
	/**
	 * Gets the panel main.
	 *
	 * @return the panel main
	 */
	public JPanel getPanelMain(){
		return this.jPanelMain;
	}
	
	/**
	 * Gets the j panel terrain.
	 *
	 * @return the j panel terrain
	 */
	public JPanel getjPanelTerrain() {
		return jPanelTerrain;
	}

	/**
	 * Gets the j panel terrain adversaire.
	 *
	 * @return the j panel terrain adversaire
	 */
	public JPanel getjPanelTerrainAdversaire() {
		return jPanelTerrainAdversaire;
	}

	/**
	 * Gets the j panel main adversaire.
	 *
	 * @return the j panel main adversaire
	 */
	public JPanel getjPanelMainAdversaire() {
		return jPanelMainAdversaire;
	}

	/**
	 * Gets the j label heros adversaire.
	 *
	 * @return the j label heros adversaire
	 */
	public JLabel getjLabelHerosAdversaire() {
		return jLabelHerosAdversaire;
	}

	/**
	 * Gets the j label heros.
	 *
	 * @return the j label heros
	 */
	public JLabel getjLabelHeros(){
		return this.jLabelHeros;
	}
	
	/**
	 * Gets the j label sort heroique.
	 *
	 * @return the j label sort heroique
	 */
	public JLabel getjLabelSortHeroique() {
		return this.jLabelSortHeroique;
	}
	
	
	/**
	 * Gets the j label ressource adversaire.
	 *
	 * @return the j label ressource adversaire
	 */
	public JLabel getjLabelRessourceAdversaire() {
		return jLabelRessourceAdversaire;
	}

	/**
	 * Gets the j label sort heroique adversaire.
	 *
	 * @return the j label sort heroique adversaire
	 */
	public JLabel getjLabelSortHeroiqueAdversaire() {
		return jLabelSortHeroiqueAdversaire;
	}

	/**
	 * Gets the j label ressource.
	 *
	 * @return the j label ressource
	 */
	public JLabel getjLabelRessource(){
		return this.jLabelRessource;
	}
	
	/**
	 * Gets the fin tour button.
	 *
	 * @return the fin tour button
	 */
	public JButton getFinTourButton(){
		return jButtonFinTour;
	}	
	
	/**
	 * Gets the label info.
	 *
	 * @return the label info
	 */
	public JLabel getLabelInfo(){
		return this.jLabelInfosCarte;
	}

	/**
	 * Gets the j label structure adverse.
	 *
	 * @return the j label structure adverse
	 */
	public JLabel getjLabelStructureAdverse() {
		return jLabelStructureAdverse;
	}

	/**
	 * Sets the j label structure adverse.
	 *
	 * @param jLabelStructureAdverse the new j label structure adverse
	 */
	public void setjLabelStructureAdverse(JLabel jLabelStructureAdverse) {
		this.jLabelStructureAdverse = jLabelStructureAdverse;
	}

	/**
	 * Gets the j label coque adverse.
	 *
	 * @return the j label coque adverse
	 */
	public JLabel getjLabelCoqueAdverse() {
		return jLabelCoqueAdverse;
	}

	/**
	 * Sets the j label coque adverse.
	 *
	 * @param jLabelCoqueAdverse the new j label coque adverse
	 */
	public void setjLabelCoqueAdverse(JLabel jLabelCoqueAdverse) {
		this.jLabelCoqueAdverse = jLabelCoqueAdverse;
	}

	/**
	 * Gets the j label structure.
	 *
	 * @return the j label structure
	 */
	public JLabel getjLabelStructure() {
		return jLabelStructure;
	}

	/**
	 * Sets the j label structure.
	 *
	 * @param jLabelStructure the new j label structure
	 */
	public void setjLabelStructure(JLabel jLabelStructure) {
		this.jLabelStructure = jLabelStructure;
	}

	/**
	 * Gets the j label coque.
	 *
	 * @return the j label coque
	 */
	public JLabel getjLabelCoque() {
		return jLabelCoque;
	}

	/**
	 * Sets the j label coque.
	 *
	 * @param jLabelCoque the new j label coque
	 */
	public void setjLabelCoque(JLabel jLabelCoque) {
	}

	/**
	 * Sets the j panel terrain adversaire.
	 *
	 * @param jPanelTerrainAdversaire the new j panel terrain adversaire
	 */
	public void setjPanelTerrainAdversaire(JPanel jPanelTerrainAdversaire) {
		this.jPanelTerrainAdversaire = jPanelTerrainAdversaire;
		this.jPanelTerrainAdversaire.revalidate();
		this.jPanelTerrainAdversaire.repaint();
	}

	/**
	 * Sets the j label ressource adversaire.
	 *
	 * @param jLabelRessourceAdversaire the new j label ressource adversaire
	 */
	public void setjLabelRessourceAdversaire(JLabel jLabelRessourceAdversaire) {
		this.jLabelRessourceAdversaire = jLabelRessourceAdversaire;
		this.revalidate();
		this.repaint();
	}

	/**
	 * Sets the j panel terrain.
	 *
	 * @param jPanelTerrain the new j panel terrain
	 */
	public void setjPanelTerrain(JPanel jPanelTerrain) {
		this.jPanelTerrain = jPanelTerrain;
		this.revalidate();
		this.repaint();
	}

	/**
	 * Gets the j panel main.
	 *
	 * @return the j panel main
	 */
	public JPanel getjPanelMain() {
		return jPanelMain;
	}
	
	/**
	 * Play sound.
	 */
	public void playSound(){
		background = new SonPlayer(getClass().getClassLoader().getResource("./sound/soundEveStone.mp3").getPath());
		background.start();
	}
	
}
