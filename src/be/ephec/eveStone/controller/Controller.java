package be.ephec.eveStone.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import be.ephec.eveStone.model.*;
import be.ephec.eveStone.model.net.MyClient;
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

	//Port serveur
	private final int NUM_PORT = 2013;

	//client NET
	private MyClient client;

	private int nbTour;

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
		this.connexion.getjButtonAnnuler().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				jButtonAnnulerClicked(evt);
			}
		});
		this.connexion.getjButtonCommencer().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				jButtonCommencerClicked(evt);
			}
		});
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
		this.area.getjLabelHeros().setIcon(new ImageIcon(getClass().getClassLoader().getResource(myHero.getImage())));
		
		this.area.getDeckPanel().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				jLabel2MouseClicked(evt);
			}
		});
		this.main = new Main();
		this.area.getFinTourButton().addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent evt){
				jButtonFinTourClicked(evt);
			}
		});
		nbTour=1;
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
	 * @param une carte (NE PEUT PAS ETRE NULL)
	 * @return 0 si ce n'est pas un serviteur ou un sort de dommage, retourne l'attaque du serviteur ou le nombre de dommage du sort
	 */
	public int makeDommage(Carte c)
	{
		int attaque = 0;
		String check = getClassCarte(c);
		if ((check.compareTo("Serviteur") == 0) || (check.compareTo("Invisible") == 0) || (check.compareTo("Protection") == 0))
		{
			return ((Serviteur) c).getNbDommage();
		}
		else if (check.compareTo("Dommage") == 0)
		{
			return ((Dommage) c).getDegats();
		}
		else 
		{
			return attaque;
		}
	}
	public int[] makeBuff(Carte c)
	{
		int buff[] = {0 , 0};
		String check = getClassCarte(c);
		if ((check.compareTo("Serviteur") == 0) || (check.compareTo("Invisible") == 0) || (check.compareTo("Protection") == 0))
		{
			buff[0] = ((Serviteur) c).getServBuffPv();
			buff[1] = ((Serviteur) c).getServBuffDeg();
			return buff;
		}
		else if (check.compareTo("Buff") == 0)
		{
			buff[0] = ((Buff) c).getBuffPv();
			buff[1] = ((Buff) c).getBuffDegats();
			return buff;
		}
		else
		{
			return buff;
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


	public int getNUM_PORT() {
		return NUM_PORT;
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
			final CardPanel card = new CardPanel();
			card.setLayout(null);
			card.setIndex(indexOfCard);
			card.setCard(main.getCard(indexOfCard));
			card.setIcon(new ImageIcon(getClass().getClassLoader().getResource(card.getCard().getImage())));
			card.setName(card.getCard().getNom());
			card.makeCard();
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
		if(myHero.getRessource() >= label.getCard().getRessource()){
			this.main.remove(label.getIndex());
			myHero.setRessource(myHero.getRessource()-label.getCard().getRessource());
			this.area.getjLabelRessource().setText("<html><font color=white>"+myHero.getRessource()+"</font></html>");
			area.getPanelMain().remove(label);
			area.revalidate();
			area.repaint();
		}
		else
			JOptionPane.showMessageDialog(null, "Erreur : Ressources Inssufisantes !");
	}

	protected void jButtonFinTourClicked(MouseEvent evt) {
		nbTour++;
		if (nbTour < 10)
		{
			myHero.setRessource(nbTour);
		}
		else
		{
			myHero.setRessource(10);
		}
		this.area.getjLabelRessource().setText("<html><font color=white>"+myHero.getRessource()+"</font></html>");
		this.area.revalidate();
		this.area.repaint();
	}
	protected void jButtonAnnulerClicked(MouseEvent evt)
	{
		this.connexion.dispose();
	}
	protected void jButtonCommencerClicked(MouseEvent evt)
	{
		try {
			client = new MyClient(this.connexion.getjTextFieldIP().getText(), NUM_PORT);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String s = "";
		try {
			s = (String)client.getOis().readObject();
			client.setNum((int)client.getOis().readObject());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.connexion.dispose();
		JOptionPane.showMessageDialog(null, " Bienvenue sur EveStone!!!! vous êtes le  " + client.getNum() + " client \n" + s);
	}
}
