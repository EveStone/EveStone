package be.ephec.eveStone.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import be.ephec.eveStone.model.*;
import be.ephec.eveStone.model.repositories.Main;
import be.ephec.eveStone.vieuw.Area;
import be.ephec.eveStone.vieuw.ConnectionFrame;
import be.ephec.eveStone.vieuw.StartFrame;
import be.ephec.eveStone.vieuw.container.CardPanel;

public class Controller {

	// Modèles
	private Hero myHero;
	private Hero adverseHero;
	private Main main;

	// Views
	private Area area;
	private StartFrame start;
	private ConnectionFrame connexion;

	// Path pour la construction des cartes
	private final String PATH_DRONE_ATTAQUE = "img/CarteFaceV2_petit.png";


	public Controller(){

	}
	/*
	 * Partie Construction des Frame et affichage pour lier les frames au Controller
	 */

	/**
	 * Construit la nouvelles Fenetre Start qui permet de séléctionner son héros, de se connecter
	 * à un serveur et de commencer une partie
	 */
	public void makeStartFrame(){
		this.start = new StartFrame(this);
	}
	/**
	 * Affiche la startFrame
	 */
	public void displayStartFrame(){
		start.setVisible(true);
	}
	/**
	 * Construit la fenêtre de connection
	 */
	public void makeConnectionFrame(){
		this.connexion = new ConnectionFrame(this);
	}
	/**
	 * Affiche la fenêtre de connection
	 */
	public void displayConnectionFrame(){
		connexion.display();
	}
	/**
	 * Contsruit la zone de jeu qui permet de jouer contre un adversaire.
	 */
	public void makeArea(){
		this.area = new Area(this);
		this.area.getDeckPanel().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				jLabel2MouseClicked(evt);
			}
		});
		this.main = new Main();
	}
	/**
	 * Affiche la Zone de jeu
	 */
	public void displayArea(){
		area.display();
	}
	/**
	 * Cette m�thode retourne le String de la classe d'une carte
	 * @param carte ne peut pas etre null
	 * @return la Classe sous la forme de String
	 */
	public String getClassCarte(Carte c)
	{
		return (c.getClass()).toString();
	}
	/**
	 * Cette m�thode permet de retourner l'attaque d'un serviteur et d'un sort
	 * @param une carte (NE PEUT PAS ETRE NULL
	 * @return 0 si ce n'est pas un serviteur ou un sort de dommage, retourne l'attaque du serviteur ou le nombre de dommage du sort
	 */
	public int attaque(Carte c)
	{
		int attaque = 0;
		String check = getClassCarte(c);
		switch (check)
		{
		case ("Serviteur") : return ((Serviteur) c).getNbDommage();
		case ("Invisible") : return ((Serviteur) c).getNbDommage();
		case ("Protection") : return ((Serviteur) c).getNbDommage();
		case ("Dommage") : return ((Dommage) c).getDegats();
		default : return attaque;
		}

	}

	/*
	 * Getters et setters pour avoir le hero adverse ou son hero 
	 * 
	 * 
	 */
	public Hero getMyHero() {
		return myHero;
	}
	public void setMyHero(Hero myHero) {
		this.myHero = myHero;
	}
	public Hero getAdverseHero() {
		return adverseHero;
	}
	public void setAdverseHero(Hero adverseHero) {
		this.adverseHero = adverseHero;
	}

	public void updateMain(Main main){
		this.main = main;
	}

	// Actions

	private void jLabel2MouseClicked(MouseEvent evt) {
		int indexOfCard = this.main.add(this.myHero.getDeck().getTabCartes().poll());
		if (indexOfCard != -1){
			area.getDeckPanel().revalidate();
			area.getDeckPanel().repaint();
			final CardPanel card = new CardPanel(new ImageIcon(getClass().getClassLoader().getResource(PATH_DRONE_ATTAQUE)));
			card.setLayout(null);
			card.setIndex(indexOfCard);
			card.setCard(main.getCard(indexOfCard));
			card.setName(card.getCard().getNom());
			System.out.println("Carte ajoutée : "+card.getCard().getNom()+" en : "+indexOfCard);
			main.affiche();
			area.getPanelMain().add(card);
			card.addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent ev){
					cardClicked(ev, card);
				}
			});
		}
		else
			javax.swing.JOptionPane.showMessageDialog(null, "Erreur : main pleine !");
	}

	protected void cardClicked(MouseEvent ev, final CardPanel label) {
		label.getButton().addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent evt){
				jButtonJouerClicked(evt, label);
			}
		});
		if(label.getButton().isVisible())
			label.getButton().setVisible(false);
		else
			label.getButton().setVisible(true);
		area.getPanelMain().revalidate();
		area.getPanelMain().repaint();
		System.out.println(label.getName());
	}

	protected void jButtonJouerClicked(MouseEvent evt, CardPanel label) {
		this.main.remove(label.getIndex());
		area.getPanelMain().remove(label);
		area.getPanelMain().revalidate();
		area.getPanelMain().repaint();
	}
}
