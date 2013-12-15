package be.ephec.eveStone.vieuw.container;

import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.io.Serializable;

import be.ephec.eveStone.model.*;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 * La classe CardPanel qui permet de contenir tout les informations d'une carte essentielle à son affichage.
 * Cette classe étend JLabel.
 * 
 * @author Dasseler Nicolas & Vanbutsele Andy
 */
public class CardPanel extends JLabel implements Serializable{

	
	/** La Constante serialVersionUID. */
	private static final long serialVersionUID = 8382233582936491148L;
	
	/** La carte. */
	private Carte card;
	
	/** le bouton jouer. */
	JButton jouer;
	
	/** les ressources. */
	JLabel ressource;
	
	/** l'attaque. */
	JLabel attaque;
	
	/** la vie. */
	JLabel vie;
	
	/** la constante FONT_SIZE. */
	private static final int FONT_SIZE = 25;

	/**
	 * Constructeur d'un nouveau carte panel
	 */
	public CardPanel(){

	}

	/**
	 * Constructeur d'un nouveau carte panel
	 *
	 * @param image: Icon (image de la carte)
	 */
	public CardPanel(Icon image) {
		super(image);
	}

	/**
	 * Créer une nouvelle carte
	 */
	public void makeCard(){

		this.setIcon(new ImageIcon((new ImageIcon(getClass().getClassLoader().getResource(card.getImage()))).getImage().getScaledInstance(85, 132, Image.SCALE_AREA_AVERAGING)));

		jouer = new JButton("Jouer");
		jouer.setBounds(15, 60, 75, 20);
		this.add(jouer);
		jouer.setVisible(false);

		ressource = new JLabel("<html><font color=\"#00FFFF\">"+card.getRessource()+"</font></html>");
		ressource.setBounds(5, 5, 30, 30);

		//85 x 132
		if (card instanceof Serviteur)
		{
			attaque = new JLabel("<html><font color=\"#FBF2B7\">"+((Serviteur) card).getNbDommage()+"</font></html>");
			attaque.setBounds(5, 135, 30, 30);
			this.add(attaque);
			attaque.setFont(new Font("Arial", 6, FONT_SIZE));
		}
		else if (card instanceof Dommage)
		{
			attaque = new JLabel("<html><font color=\"#FBF2B7\">"+((Dommage) card).getDegats()+"</font></html>");
			attaque.setBounds(5, 135, 30, 30);
			this.add(attaque);
			attaque.setFont(new Font("Arial", 6, FONT_SIZE));
		}

		if (card instanceof Serviteur)
		{
			vie = new JLabel("<html><font color=\"#FBF2B7\">"+((Serviteur) card).getNbVie()+"</font></html>");
			vie.setBounds(85, 135, 30, 30);
			this.add(vie);
			vie.setFont(new Font("Arial", 6, FONT_SIZE));
		}
		this.add(ressource);
		ressource.setFont(new Font("Arial", 6, FONT_SIZE));

	}

	/**
	 * Montre les info
	 *
	 * @param show: Boolean
	 * true ==> affiche
	 * false ==> n'affiche pas.
	 */
	public void showInfo(boolean show){

		this.ressource.setVisible(show);
		if(this.card instanceof Serviteur || card instanceof Dommage)
			this.attaque.setVisible(show);
		if(card instanceof Serviteur)
				this.vie.setVisible(show);
		this.revalidate();
		this.repaint();
	}

	/**
	 * Sets la carte.
	 *
	 * @param carte : Carte 
	 */
	public void setCard(Carte card){
		this.card = card;
	}

	/**
	 * Retourne la carte
	 *
	 * @return la carte
	 */
	public Carte getCard(){
		return this.card;
	}

	/**
	 * Retourne le bouton Jouer
	 *
	 * @return jouer : JButton
	 */
	public JButton getButton(){
		return this.jouer;
	}
	
	/**
	 * Met à jour le carte Panel
	 */
	public void update()
	{
		attaque.setText("<html><font color=\"#FBF2B7\">"+((Serviteur) card).getNbDommage()+"</font></html>");
		vie.setText("<html><font color=\"#FBF2B7\">"+((Serviteur) card).getNbVie()+"</font></html>");
		this.revalidate();
		this.repaint();

	}

	/* (non-Javadoc)
	 * @see javax.swing.JComponent#getBaselineResizeBehavior()
	 */
	@Override
	public Component.BaselineResizeBehavior getBaselineResizeBehavior() {
	    return Component.BaselineResizeBehavior.CONSTANT_ASCENT;
	}

	/* (non-Javadoc)
	 * @see javax.swing.JComponent#getBaseline(int, int)
	 */
	@Override
	public int getBaseline(int width, int height) {
	    return 0;
	}
	
	/* (non-Javadoc)
	 * @see java.awt.Container#add(java.awt.Component)
	 */
	public Component add(Component comp){
		super.add(comp);
		return comp;
	}

	
	
}
