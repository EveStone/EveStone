package be.ephec.eveStone.vieuw;


import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;


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
public class GameArea extends javax.swing.JFrame {
	private JPanel jPanelMainHaut;
	private JPanel jPanelMainBas;
	private JPanel jPanelMainAdv;
	private JLabel jLabelHerosAdv;
	private JLabel jLabelSortHerosAdv;
	private JLabel jLabelStructureAdv;
	private JLabel jLabelCoqueAdv;
	private JLabel jLabelRessourceAdv;
	private JLabel jLabelAreaAdv;
	private JLabel jLabelArea;
	private JLabel jLabelRessource;
	private JLabel jLabelSortHero;
	private JLabel jLabelStructure;
	private JLabel jLabelCoque;
	private JLabel jLabelHeros;
	private JLabel jLabel1;
	private JLabel jLabelCarte1;
	private JLabel jLabelCimetiere;
	private JLabel jLabelCmetiereAdv;
	private JPanel jPanelArea;
	private JPanel jPanelAreaAdv;
	private JPanel jPanel2;
	private JPanel jPanel1;
	private JPanel jPanelInfoAdv;
	private JLabel jLabelDeckAdv;
	private JLabel jLabelDeck;
	private JPanel jPanelMain;
	private JButton jButtonFinTour;
	private JPanel jPanelBattleArea;
	private JPanel jPanelHistory;
	private JPanel jPanelDeck;
	
	public void run(){
		GameArea inst = new GameArea();
		inst.setLocationRelativeTo(null);
		inst.setVisible(true);
	}
	
	public GameArea() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				jPanelMainHaut = new JPanel();
				GridBagLayout jPanelMainHautLayout = new GridBagLayout();
				jPanelMainHautLayout.rowWeights = new double[] {0.1};
				jPanelMainHautLayout.rowHeights = new int[] {7};
				jPanelMainHautLayout.columnWeights = new double[] {0.0, 0.0, 0.1};
				jPanelMainHautLayout.columnWidths = new int[] {106, 579, 7};
				getContentPane().add(jPanelMainHaut, BorderLayout.NORTH);
				jPanelMainHaut.setPreferredSize(new java.awt.Dimension(806, 92));
				jPanelMainHaut.setBackground(new java.awt.Color(191,191,191));
				jPanelMainHaut.setBorder(BorderFactory.createTitledBorder(""));
				jPanelMainHaut.setLayout(jPanelMainHautLayout);
				{
					jPanelMainAdv = new JPanel();
					GridBagLayout jPanelMainAdvLayout = new GridBagLayout();
					jPanelMainAdvLayout.columnWidths = new int[] {7, 7, 7, 7, 7, 7, 7, 7, 7, 7};
					jPanelMainAdvLayout.rowHeights = new int[] {7};
					jPanelMainAdvLayout.columnWeights = new double[] {0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1};
					jPanelMainAdvLayout.rowWeights = new double[] {0.1};
					jPanelMainHaut.add(jPanelMainAdv, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
					jPanelMainAdv.setLayout(jPanelMainAdvLayout);
					jPanelMainAdv.setBackground(new java.awt.Color(255,210,102));
					{
						jLabelCarte1 = new JLabel();
						jPanelMainAdv.add(jLabelCarte1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
						jLabelCarte1.setText("Carte1");
						jLabelCarte1.setBorder(BorderFactory.createTitledBorder(""));
					}
				}
				{
					jLabelCmetiereAdv = new JLabel();
					jPanelMainHaut.add(jLabelCmetiereAdv, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					jLabelCmetiereAdv.setText("Cimetiere");
				}
			}
			{
				jPanelMainBas = new JPanel();
				GridBagLayout jPanelMainBasLayout = new GridBagLayout();
				jPanelMainBasLayout.rowWeights = new double[] {0.1};
				jPanelMainBasLayout.rowHeights = new int[] {7};
				jPanelMainBasLayout.columnWeights = new double[] {0.0, 0.0, 0.1};
				jPanelMainBasLayout.columnWidths = new int[] {105, 583, 7};
				getContentPane().add(jPanelMainBas, BorderLayout.SOUTH);
				jPanelMainBas.setPreferredSize(new java.awt.Dimension(806, 74));
				jPanelMainBas.setBackground(new java.awt.Color(191,191,191));
				jPanelMainBas.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
				jPanelMainBas.setLayout(jPanelMainBasLayout);
				{
					jPanelMain = new JPanel();
					GridBagLayout jPanelMainLayout = new GridBagLayout();
					jPanelMainLayout.columnWidths = new int[] {7, 7, 7, 7, 7, 7, 7, 7, 7, 7};
					jPanelMainLayout.rowHeights = new int[] {7};
					jPanelMainLayout.columnWeights = new double[] {0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1};
					jPanelMainLayout.rowWeights = new double[] {0.1};
					jPanelMainBas.add(jPanelMain, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
					jPanelMain.setLayout(jPanelMainLayout);
					jPanelMain.setBackground(new java.awt.Color(255,210,102));
					{
						jLabel1 = new JLabel();
						jPanelMain.add(jLabel1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
						jLabel1.setText("Carte1");
						jLabel1.setBorder(BorderFactory.createTitledBorder(""));
					}
				}
				{
					jLabelCimetiere = new JLabel();
					jPanelMainBas.add(jLabelCimetiere, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
					jLabelCimetiere.setText("Cimetiere");
					jLabelCimetiere.setBorder(BorderFactory.createTitledBorder(""));
				}
			}
			{
				jPanelDeck = new JPanel();
				GridBagLayout jPanelDeckLayout = new GridBagLayout();
				jPanelDeckLayout.rowWeights = new double[] {0.0, 0.0, 0.1};
				jPanelDeckLayout.rowHeights = new int[] {169, 69, 7};
				jPanelDeckLayout.columnWeights = new double[] {0.1};
				jPanelDeckLayout.columnWidths = new int[] {7};
				getContentPane().add(jPanelDeck, BorderLayout.EAST);
				jPanelDeck.setPreferredSize(new java.awt.Dimension(105, 281));
				jPanelDeck.setBackground(new java.awt.Color(77,77,77));
				jPanelDeck.setBorder(BorderFactory.createTitledBorder(""));
				jPanelDeck.setLayout(jPanelDeckLayout);
				{
					jButtonFinTour = new JButton();
					jPanelDeck.add(jButtonFinTour, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					jButtonFinTour.setText("Fin Tour");
				}
				{
					jLabelDeck = new JLabel();
					jPanelDeck.add(jLabelDeck, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
					jLabelDeck.setText("Deck");
					jLabelDeck.setBorder(BorderFactory.createTitledBorder(""));
				}
				{
					jLabelDeckAdv = new JLabel();
					jPanelDeck.add(jLabelDeckAdv, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
					jLabelDeckAdv.setText("Deck Adversaire");
					jLabelDeckAdv.setBorder(BorderFactory.createTitledBorder(""));
				}
			}
			{
				jPanelHistory = new JPanel();
				getContentPane().add(jPanelHistory, BorderLayout.WEST);
				jPanelHistory.setPreferredSize(new java.awt.Dimension(105, 281));
				jPanelHistory.setBackground(new java.awt.Color(77,77,77));
				jPanelHistory.setBorder(BorderFactory.createTitledBorder(""));
			}
			{
				jPanelBattleArea = new JPanel();
				GridBagLayout jPanelBattleAreaLayout = new GridBagLayout();
				getContentPane().add(jPanelBattleArea, BorderLayout.CENTER);
				jPanelBattleArea.setBackground(new java.awt.Color(5,2,46));
				jPanelBattleAreaLayout.rowWeights = new double[] {0.1, 0.1, 0.1};
				jPanelBattleAreaLayout.rowHeights = new int[] {7, 7, 7};
				jPanelBattleAreaLayout.columnWeights = new double[] {0.1};
				jPanelBattleAreaLayout.columnWidths = new int[] {7};
				jPanelBattleArea.setLayout(jPanelBattleAreaLayout);
				{
					jPanelInfoAdv = new JPanel();
					GridBagLayout jPanelInfoAdvLayout = new GridBagLayout();
					jPanelInfoAdvLayout.columnWidths = new int[] {7, 7, 7, 7, 7};
					jPanelInfoAdvLayout.rowHeights = new int[] {7};
					jPanelInfoAdvLayout.columnWeights = new double[] {0.1, 0.1, 0.1, 0.1, 0.1};
					jPanelInfoAdvLayout.rowWeights = new double[] {0.1};
					jPanelBattleArea.add(jPanelInfoAdv, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
					jPanelInfoAdv.setLayout(jPanelInfoAdvLayout);
					{
						jLabelHerosAdv = new JLabel();
						jPanelInfoAdv.add(jLabelHerosAdv, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
						jLabelHerosAdv.setText("Heros Adverse");
						jLabelHerosAdv.setBorder(BorderFactory.createTitledBorder(""));
					}
					{
						jLabelRessourceAdv = new JLabel();
						jPanelInfoAdv.add(jLabelRessourceAdv, new GridBagConstraints(4, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
						jLabelRessourceAdv.setText("Ressource Adverse");
						jLabelRessourceAdv.setBorder(BorderFactory.createTitledBorder(""));
					}
					{
						jLabelCoqueAdv = new JLabel();
						jPanelInfoAdv.add(jLabelCoqueAdv, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
						jLabelCoqueAdv.setText("Coque Adverse");
						jLabelCoqueAdv.setBorder(BorderFactory.createTitledBorder(""));
					}
					{
						jLabelStructureAdv = new JLabel();
						jPanelInfoAdv.add(jLabelStructureAdv, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
						jLabelStructureAdv.setText("Structure Adverse");
						jLabelStructureAdv.setBorder(BorderFactory.createTitledBorder(""));
					}
					{
						jLabelSortHerosAdv = new JLabel();
						jPanelInfoAdv.add(jLabelSortHerosAdv, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
						jLabelSortHerosAdv.setText("SortHeros Adverse");
						jLabelSortHerosAdv.setBorder(BorderFactory.createTitledBorder(""));
					}
				}
				{
					jPanel1 = new JPanel();
					GridBagLayout jPanel1Layout = new GridBagLayout();
					jPanel1Layout.columnWidths = new int[] {7, 7, 7, 7, 7};
					jPanel1Layout.rowHeights = new int[] {7};
					jPanel1Layout.columnWeights = new double[] {0.1, 0.1, 0.1, 0.1, 0.1};
					jPanel1Layout.rowWeights = new double[] {0.1};
					jPanelBattleArea.add(jPanel1, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
					jPanel1.setLayout(jPanel1Layout);
					{
						jLabelHeros = new JLabel();
						jPanel1.add(jLabelHeros, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
						jLabelHeros.setText("Heros");
						jLabelHeros.setBorder(BorderFactory.createTitledBorder(""));
					}
					{
						jLabelCoque = new JLabel();
						jPanel1.add(jLabelCoque, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
						jLabelCoque.setText("Coque");
						jLabelCoque.setBorder(BorderFactory.createTitledBorder(""));
					}
					{
						jLabelStructure = new JLabel();
						jPanel1.add(jLabelStructure, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
						jLabelStructure.setText("Structure");
						jLabelStructure.setBorder(BorderFactory.createTitledBorder(""));
					}
					{
						jLabelSortHero = new JLabel();
						jPanel1.add(jLabelSortHero, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
						jLabelSortHero.setText("SortHeros");
						jLabelSortHero.setBorder(BorderFactory.createTitledBorder(""));
					}
					{
						jLabelRessource = new JLabel();
						jPanel1.add(jLabelRessource, new GridBagConstraints(4, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
						jLabelRessource.setText("Ressource");
						jLabelRessource.setBorder(BorderFactory.createTitledBorder(""));
					}
				}
				{
					jPanel2 = new JPanel();
					GridBagLayout jPanel2Layout = new GridBagLayout();
					jPanel2Layout.columnWidths = new int[] {575};
					jPanel2Layout.rowHeights = new int[] {7, 7};
					jPanel2Layout.columnWeights = new double[] {0.0};
					jPanel2Layout.rowWeights = new double[] {0.1, 0.1};
					jPanelBattleArea.add(jPanel2, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
					jPanel2.setLayout(jPanel2Layout);
					{
						jPanelAreaAdv = new JPanel();
						jPanel2.add(jPanelAreaAdv, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
						jPanelAreaAdv.setBorder(BorderFactory.createTitledBorder(""));
						{
							jLabelAreaAdv = new JLabel();
							jPanelAreaAdv.add(jLabelAreaAdv);
							jLabelAreaAdv.setText("Zone de carte Adverse");
							jLabelAreaAdv.setPreferredSize(new java.awt.Dimension(203, 69));
						}
					}
					{
						jPanelArea = new JPanel();
						jPanel2.add(jPanelArea, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
						jPanelArea.setBorder(BorderFactory.createTitledBorder(""));
						{
							jLabelArea = new JLabel();
							jPanelArea.add(jLabelArea);
							jLabelArea.setText("Zone de carte");
							jLabelArea.setPreferredSize(new java.awt.Dimension(197, 49));
						}
					}
				}
			}
			pack();
			this.setSize(800, 600);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}
