package be.ephec.eveStone.vieuw;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import be.ephec.eveStone.controller.Controller;
import be.ephec.eveStone.model.Heros;
import be.ephec.eveStone.model.SortHeroique;
import be.ephec.eveStone.model.repositories.Deck;

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
* 
* @author Dasseler Nicolas & Vanbutsele Andy
*/
public class ChoixHeros extends JFrame{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3248722263899412425L;
	
	/** The j panel1. */
	private JPanel jPanel1;
	
	/** The j button save. */
	private JButton jButtonSave;
	
	/** The j label description. */
	private JLabel jLabelDescription;
	
	/** The j label title. */
	private JLabel jLabelTitle;
	
	/** The j button quitter. */
	private JButton jButtonQuitter;
	
	/** The j label2. */
	private JLabel jLabel2;
	
	/** The j label1. */
	private JLabel jLabel1;
	
	/** The j panel description. */
	private JPanel jPanelDescription;
	
	/** The choix hero. */
	private int choixHero = -1; // 0 alors interceptor, 1 alors fregate
	
	/** The j label check fregate. */
	private JLabel jLabelCheckFregate;
	
	/** The j labelcheck interceptor. */
	private JLabel jLabelcheckInterceptor;

	/** The img fregate. */
	private final String IMG_FREGATE = "img/Fregate.png";
	
	/** The img interceptor. */
	private final String IMG_INTERCEPTOR = "img/Interceptor.png";
	
	/** The img sort fregate. */
	private final String IMG_SORT_FREGATE = "img/sortFregate.png";
	
	/** The img sort interceptor. */
	private final String IMG_SORT_INTERCEPTOR = "img/sortInterceptor.png";
	
	/** The descr sort fregate. */
	private final String DESCR_SORT_FREGATE = "Invoque 1 serviteur sur le terrain. Ce serviteur possède 1 d'attaque et 1 points de vie.";
	
	/** The descr sort intereptor. */
	private final String DESCR_SORT_INTEREPTOR = "Tir un missile qui inflige 2 points de degats à un serviteur ou héros ennemi";

	/**
	 * Instantiates a new choix heros.
	 *
	 * @param controller the controller
	 * @param commencer the commencer
	 */
	public ChoixHeros(final Controller controller, final JButton commencer){
		super("Choix du Héros");
		this.setResizable(false);
		initGUI(controller, commencer);
	}
	
	/**
	 * Inits the gui.
	 *
	 * @param controller the controller
	 * @param commencer the commencer
	 */
	private void initGUI(final Controller controller, final JButton commencer){
		this.setSize(484, 582);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		{
			jPanel1 = new JPanel();
			GridBagLayout jPanel1Layout = new GridBagLayout();
			getContentPane().add(jPanel1, BorderLayout.NORTH);
			jPanel1.setPreferredSize(new java.awt.Dimension(474, 193));
			jPanel1.setBackground(new java.awt.Color(0,0,0));
			jPanel1Layout.rowWeights = new double[] {0.1, 0.1, 0.1};
			jPanel1Layout.rowHeights = new int[] {7, 7, 7};
			jPanel1Layout.columnWeights = new double[] {0.1, 0.1, 0.1, 0.1, 0.1};
			jPanel1Layout.columnWidths = new int[] {7, 7, 7, 7, 7};
			jPanel1.setLayout(jPanel1Layout);
			{
				jLabel1 = new JLabel();
				jPanel1.add(jLabel1, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				jLabel1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/MaledictionHeros.jpg")));
				jLabel1.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel1MouseClicked(evt);
					}
				});
			}
			{
				jLabel2 = new JLabel();
				jPanel1.add(jLabel2, new GridBagConstraints(3, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				jLabel2.setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/fregate.jpg")));
				jLabel2.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel2MouseClicked(evt);
					}
				});
			}
			{
				jLabelcheckInterceptor = new JLabel();
				jPanel1.add(jLabelcheckInterceptor, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				jLabelcheckInterceptor.setText("");
				jLabelcheckInterceptor.setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/check.png")));
				jLabelcheckInterceptor.setVisible(false);
			}
			{
				jLabelCheckFregate = new JLabel();
				jPanel1.add(jLabelCheckFregate, new GridBagConstraints(3, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				jLabelCheckFregate.setText("");
				jLabelCheckFregate.setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/check.png")));
				jLabelCheckFregate.setVisible(false);
			}
		}
		{
			jPanelDescription = new JPanel();
			getContentPane().add(jPanelDescription, BorderLayout.CENTER);
			jPanelDescription.setPreferredSize(new java.awt.Dimension(490, 364));
			jPanelDescription.setBackground(new java.awt.Color(0,0,0));
			jPanelDescription.setLayout(null);
			{
				jButtonSave = new JButton();
				jPanelDescription.add(jButtonSave);
				jButtonSave.setText("<html><font color=white>Sauver</font></html>");
				jButtonSave.setBounds(202, 296, 90, 22);
				jButtonSave.setBackground(new java.awt.Color(0,0,0));
				jButtonSave.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jButtonSauverActionPerformed(evt, controller, commencer);
					}
				});
			}
			{
				jButtonQuitter = new JButton();
				jPanelDescription.add(jButtonQuitter);
				jButtonQuitter.setText("<html><font color=white>Quitter</font></html>");
				jButtonQuitter.setBounds(202, 329, 90, 22);
				jButtonQuitter.setBackground(new java.awt.Color(0,0,0));
				jButtonQuitter.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jButtonQuitterActionPerformed(evt);
					}
				});
			}
			{
				jLabelTitle = new JLabel();
				jPanelDescription.add(jLabelTitle);
				jLabelTitle.setText("<html><font color=white>Description :</font></html>");
				jLabelTitle.setBounds(168, 23, 175, 29);
			}
			{
				jLabelDescription = new JLabel();
				jPanelDescription.add(jLabelDescription);
				jLabelDescription.setText("");
				jLabelDescription.setBounds(101, 12, 301, 263);
			}
		}
	}
	
	/**
	 * J label1 mouse clicked.
	 *
	 * @param evt the evt
	 */
	private void jLabel1MouseClicked(MouseEvent evt) {
		//System.out.println("jLabel1.mouseClicked, event="+evt);
		//TODO add your code for jLabel1.mouseClicked
		jLabelDescription.setText("<html><font color=white>Nom : Interceptor<br/><br/>"
								   + "Spécéficité : Petit et rapide, l'interceptor peut infliger des dégats important. Pour cela il utilise principalement"
								   + " des drones d'attaque et des drone protecteur pour esquiver les dégats.<br/><br/>"
								   + "Sort Héros : Tir de missile ! Inflige 2 points de dégats.</font></html>");
		choixHero = 0;
		jLabelcheckInterceptor.setVisible(true);
		jLabelCheckFregate.setVisible(false);
	}
	
	/**
	 * J label2 mouse clicked.
	 *
	 * @param evt the evt
	 */
	private void jLabel2MouseClicked(MouseEvent evt) {
		//System.out.println("jLabel2.mouseClicked, event="+evt);
		//TODO add your code for jLabel2.mouseClicked
		jLabelDescription.setText("<html><font color=white>Nom : Frégate<br/><br/>"
				   + "Spécéficité : La frégate est un vaisseau robuste principalement conçu pour encaisser des dégats."
				   + " Elle utilise de nombreux drones qui noient l'ennemi sous un pluie de coup.<br/><br/>"
				   + "Sort Héros : Renfort ! Invoque 1 serviteur sur le terrain.</font></html>");
		choixHero = 1;
		jLabelCheckFregate.setVisible(true);
		jLabelcheckInterceptor.setVisible(false);
	}
	
	/**
	 * J button quitter action performed.
	 *
	 * @param evt the evt
	 */
	private void jButtonQuitterActionPerformed(ActionEvent evt) {
		//System.out.println("jButtonQuitter.actionPerformed, event="+evt);
		//TODO add your code for jButtonQuitter.actionPerformed
		this.dispose();
	}
	
	/**
	 * J button sauver action performed.
	 *
	 * @param evt the evt
	 * @param controller the controller
	 * @param commencer the commencer
	 */
	private void jButtonSauverActionPerformed(ActionEvent evt, final Controller controller, JButton commencer) {
		//System.out.println("jButtonQuitter.actionPerformed, event="+evt);
		//TODO add your code for jButtonQuitter.actionPerformed
		
		if (choixHero == 0)
		{
			controller.setMyHero(new Heros("Interceptor",IMG_INTERCEPTOR, new Deck("interceptor"), new SortHeroique("Tir de Missile", 2, 2, 0, IMG_SORT_INTERCEPTOR, DESCR_SORT_INTEREPTOR)));
			System.out.println(""+ controller.getMyHero().getNom());
		}
		else if (choixHero == 1)
		{
			controller.setMyHero(new Heros("Fregate",IMG_FREGATE, new Deck("fregate"), new SortHeroique("Renfort !", 2, 0, 1, IMG_SORT_FREGATE, DESCR_SORT_FREGATE)));
			System.out.println(""+ controller.getMyHero().getNom());
			
		}
		if (this.choixHero > -1)
			commencer.setEnabled(true);
		this.dispose();
	}

}
