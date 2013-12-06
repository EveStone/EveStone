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
import be.ephec.eveStone.model.Hero;
import be.ephec.eveStone.model.SortHeroique;
import be.ephec.eveStone.model.repositories.Deck;

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
public class ChoixHeros extends JFrame{
	private JPanel jPanel1;
	private JButton jButtonSave;
	private JLabel jLabelDescription;
	private JLabel jLabelTitle;
	private JButton jButtonQuitter;
	private JLabel jLabel2;
	private JLabel jLabel1;
	private JPanel jPanelDescription;
	private int choixHero = -1; // 0 alors interceptor, 1 alors fregate
	private JLabel jLabelCheckFregate;
	private JLabel jLabelcheckInterceptor;

	private final String IMG_FREGATE = "img/Fregate.png";
	private final String IMG_INTERCEPTOR = "img/Interceptor.png";

	public ChoixHeros(final Controller controller, final JButton commencer){
		super("Choix du Héros");
		initGUI(controller, commencer);
	}
	
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
	
	private void jLabel1MouseClicked(MouseEvent evt) {
		//System.out.println("jLabel1.mouseClicked, event="+evt);
		//TODO add your code for jLabel1.mouseClicked
		jLabelDescription.setText("<html><font color=white>Nom : Interceptor<br/><br/>"
								   + "Spécéficité : Petit et rapide, l'interceptor peut infliger des dégats important. Pour cela il utilise principalement"
								   + " des drones d'attaque et des drone protecteur pour esquiver les dégats.<br/><br/>"
								   + "Sort Héros : Bombe Kinétique (Inflige des dégats à tous les serviteurs ennemis)</font></html>");
		choixHero = 0;
		jLabelcheckInterceptor.setVisible(true);
		jLabelCheckFregate.setVisible(false);
	}
	
	private void jLabel2MouseClicked(MouseEvent evt) {
		//System.out.println("jLabel2.mouseClicked, event="+evt);
		//TODO add your code for jLabel2.mouseClicked
		jLabelDescription.setText("<html><font color=white>Nom : Frégate<br/><br/>"
				   + "Spécéficité : La frégate est un vaisseau robuste principalement conçu pour encaisser des dégats."
				   + " Elle utilise des drônes puissants et qui nombreux qui noient l'ennemi sous un pluie de coup.<br/><br/>"
				   + "Sort Héros : Renfort !(Invoques 2 drônes moyens)</font></html>");
		choixHero = 1;
		jLabelCheckFregate.setVisible(true);
		jLabelcheckInterceptor.setVisible(false);
	}
	
	private void jButtonQuitterActionPerformed(ActionEvent evt) {
		//System.out.println("jButtonQuitter.actionPerformed, event="+evt);
		//TODO add your code for jButtonQuitter.actionPerformed
		this.dispose();
	}
	private void jButtonSauverActionPerformed(ActionEvent evt, final Controller controller, JButton commencer) {
		//System.out.println("jButtonQuitter.actionPerformed, event="+evt);
		//TODO add your code for jButtonQuitter.actionPerformed
		if (choixHero == 0)
		{
			controller.setMyHero(new Hero("Interceptor",IMG_INTERCEPTOR, new Deck("interceptor"), new SortHeroique(2, 0)));
			System.out.println(""+ controller.getMyHero().getNom());
		}
		else if (choixHero == 1)
		{
			controller.setMyHero(new Hero("Fregate",IMG_FREGATE, new Deck("fregate"), new SortHeroique(0, 2)));
			System.out.println(""+ controller.getMyHero().getNom());
		}
		if (this.choixHero > -1)
			commencer.setEnabled(true);
		this.dispose();
	}

}
