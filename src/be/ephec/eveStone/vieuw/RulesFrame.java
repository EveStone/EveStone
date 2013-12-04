package be.ephec.eveStone.vieuw;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

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
public class RulesFrame extends javax.swing.JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7559119970281626969L;
	private JButton jButtonClose;
	private JLabel jLabelRegles;
	private JPanel jPanelRegles;
	private JLabel jLabel1;
	private JPanel jPanelTitre;

	/**
	 * Auto-generated main method to display this JFrame
	 */

	public RulesFrame(final Controller controller) {
		super("Règles");
		initGUI();
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setLocationRelativeTo(null);
			{
				jPanelTitre = new JPanel();
				getContentPane().add(jPanelTitre, BorderLayout.NORTH);
				jPanelTitre.setBackground(new java.awt.Color(0,0,0));
				{
					jLabel1 = new JLabel();
					jPanelTitre.add(jLabel1);
					jLabel1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/logoConnexion.png")));
					jLabel1.setLayout(null);
					jLabel1.setPreferredSize(new java.awt.Dimension(195, 120));
				}
			}
			{
				jPanelRegles = new JPanel();
				getContentPane().add(jPanelRegles, BorderLayout.CENTER);
				GridBagLayout jPanelReglesLayout = new GridBagLayout();
				jPanelReglesLayout.rowWeights = new double[] {0.0, 0.1};
				jPanelReglesLayout.rowHeights = new int[] {386, 7};
				jPanelReglesLayout.columnWeights = new double[] {0.1};
				jPanelReglesLayout.columnWidths = new int[] {7};
				jPanelRegles.setLayout(jPanelReglesLayout);
				jPanelRegles.setBackground(new java.awt.Color(0,0,0));
				{
					jLabelRegles = new JLabel();
					jPanelRegles.add(jLabelRegles, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
					jLabelRegles.setText("<html><font color=white>" 
							+ "EveStone<br/>"
							+ "========<br/>"
							+ "Dans le cardre de notre cours de langage avancé de programmation à l'Ephec (LLN).<br/>"
							+ "Nous devons créer Jeuxvideo. Dont voici le principe.<br/><br/>"


							+"Notre projet portera sur un jeu de carte typé TCG (Trading Card Game). Il sera basé"
							+"principalement sur les règles du jeu Heartstone accomodé à un univers de EVE Online.<br/>"
							+"Le principe repose en l'affrontement de 2 joueurs qui combatent grâce à des cartes qu'ils"
							+"auront choisies pour former des decks. Les joueurs devront alors gérer différentes ressources et des"
							+"barres de vie."
							+"Le jeu se déroule au tour par tour et à chaque tour, les joueurs tirent des cartes. Ils peuvent" 
							+"par la suite les poser sur l'aire de jeu ou les garder en main. Pour poser une carte, il est nécéssaire de" 
							+"posséder les ressources nécéssaire à son déployement. La partie se termine lorsque l'un des deux"
							+"joueurs voit ses points de vie atteindre 0.<br/><br/>"

							+"Référence des jeux : <br/><br/>" 

							+"– Heartstone : http://eu.battle.net/hearthstone/fr/<br/>"
							+"– EVE Online : http://www.eveonline.com/<br/>"

							+"Tout contenu utilisé de Eve ou Hearthstone appartient à leur société respective, © CCP et © Blizzard. <br/><br/>"
							+"Ce jeu ne sera pas commercialisé. <br/>" +

							"</font></html>");
				}
				{
					jButtonClose = new JButton();
					jPanelRegles.add(jButtonClose, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					jButtonClose.setText("Fermer");
				}

			}
			pack();
			this.setSize(619, 657);
		} catch (Exception e) {
			//add your error handling code here
			e.printStackTrace();
		}
	}
	public void display(){
		this.setVisible(true);
	}

	public JButton getjButtonClose() {
		return jButtonClose;
	}


}
