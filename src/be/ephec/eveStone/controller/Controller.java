package be.ephec.eveStone.controller;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import be.ephec.eveStone.model.*;
import be.ephec.eveStone.model.listener.BuffingListener;
import be.ephec.eveStone.model.listener.CardListenerMain;
import be.ephec.eveStone.model.listener.CardListenerTerrain;
import be.ephec.eveStone.model.listener.CardListenerTerrainAdv;
import be.ephec.eveStone.model.listener.HerosListener;
import be.ephec.eveStone.model.listener.SortHerosListener;
import be.ephec.eveStone.model.net.ObjectSend;
import be.ephec.eveStone.model.net.client.MyClient;
import be.ephec.eveStone.model.net.server.ClientServer;
import be.ephec.eveStone.model.net.server.MyServer;
import be.ephec.eveStone.vieuw.Area;
import be.ephec.eveStone.vieuw.ConnectionFrame;
import be.ephec.eveStone.vieuw.RulesFrame;
import be.ephec.eveStone.vieuw.StartFrame;
import be.ephec.eveStone.vieuw.container.CardPanel;

public class Controller {


	// Modèles
	private Hero myHero;
	private Hero adverseHero;

	// Views
	private Area area;
	private StartFrame start;
	private ConnectionFrame connexion;
	private RulesFrame rules;

	private final int NB_MAX_RESSOURCE = 10;
	private final int NB_MAX_CARTE_TERRAIN = 7;
	private final int NB_MAX_CARTE_MAIN = 7;
	private final int NB_CARTE_DEPART = 4;

	//Port serveur
	private final int NUM_PORT = 2013;

	//client NET
	private MyClient myClient = null;
	private ClientServer myClientServer = null;
	private MyServer server;

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
		this.start.getjButtonChoixHeros().setEnabled(false);
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
		this.connexion.getjButtonMakeServer().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				jButtonMakeServerClicked(evt);
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
	 * Construit la fenêtre de regles
	 */
	public void makeRulesFrame()
	{
		this.rules = new RulesFrame(this);
		this.rules.getjButtonClose().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				jButtonCloseClicked(evt);
			}
		});
	}
	/**
	 * Affiche la fenêtre de regles
	 */
	public void displayRulesFrame()
	{
		rules.display();
	}
	/**
	 * Contsruit la zone de jeu qui permet de jouer contre un adversaire.
	 */
	public void makeArea(){
		/*
		if (myClient == null)
		{
			try {
				ObjectInputStream ois = new ObjectInputStream(myClientServer.getSocket().getInputStream());
				String message = (String)ois.readObject();
				System.out.println("Le héro de l'adversaire est " + message);
			} catch (IOException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else 
		{
			try {
				ObjectInputStream ois = new ObjectInputStream(myClient.getSocket().getInputStream());
				String message = (String)ois.readObject();
				System.out.println("Le héro de l'adversaire est " + message);
			} catch (IOException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		*/
		
		
		this.area = new Area(this);
		this.area.getjLabelHeros().setIcon(new ImageIcon(getClass().getClassLoader().getResource(myHero.getImage())));
		this.area.getFinTourButton().addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent evt){
				jButtonFinTourClicked(evt);
			}
		});
		nbTour=1;
		piocheDepart();
		initSortHero(area.getjLabelSortHeroique());
		adverseHero = new Hero("Fregate", "img/Fregate.png", null, null);
		area.getjLabelHerosAdversaire().setIcon(new ImageIcon(getClass().getClassLoader().getResource(adverseHero.getImage())));
		area.getjLabelHerosAdversaire().addMouseListener(new HerosListener(adverseHero, area));

		// Test
		CardPanel carteEnnemi = new CardPanel();
		carteEnnemi.setCard(new Serviteur("Hornet", 2, "img/FregateCard/hornet.png", "Drone d'attaque léger", 2, 2));
		carteEnnemi.makeCard();
		carteEnnemi.showInfo(false);
		carteEnnemi.setName(carteEnnemi.getName());
		carteEnnemi.addMouseListener(new CardListenerTerrainAdv(carteEnnemi, area));
		area.getjPanelTerrainAdversaire().add(carteEnnemi);
		/*
		CardPanel carteEnnemi2 =  new CardPanel();
		carteEnnemi2.setCard(new Protection("Wasp EC-900",2, "img/FregateCard/waspEC900.png", "Protection : L'ennemi ne peut attaquer aucun autre serviteur ou votre héros tant que cette carte est en jeu", 2, 2, true));
		carteEnnemi2.makeCard();
		carteEnnemi2.showInfo(false);
		carteEnnemi2.setName("Wasp EC-900");
		carteEnnemi2.addMouseListener(new CardListenerTerrainAdv(carteEnnemi2, area));
		area.getjPanelTerrainAdversaire().add(carteEnnemi2);
		 */
	}

	/**
	 * Affiche la Zone de jeu
	 */
	public void displayArea(){
		area.display();
	}

	/**
	 * Initialise l'affichage du sort héroique
	 */
	private void initSortHero(JLabel sortHero){
		sortHero.setIcon(new ImageIcon(getClass().getClassLoader().getResource(myHero.getSortHero().getImage())));
		sortHero.addMouseListener(new SortHerosListener(myHero, area));
	}

	public Area getArea(){
		return this.area;
	}
	/**
	 * Cette m�thode permet de retourner l'attaque d'un serviteur et d'un sort
	 * @param une carte (NE PEUT PAS ETRE NULL)
	 * @return 0 si ce n'est pas un serviteur ou un sort de dommage, retourne l'attaque du serviteur ou le nombre de dommage du sort
	 */
	public int getDommage(Carte c)
	{
		int attaque = 0;
		if (c instanceof Serviteur)
		{
			return ((Serviteur) c).getNbDommage();
		}
		else if (c instanceof Dommage)
		{
			return ((Dommage) c).getDegats();
		}
		else 
		{
			return attaque;
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

	// Actions
	/**
	 * Pioche NB_CARTE_DEPART au début du jeu
	 * @param evt
	 */
	private void piocheDepart() {
		for(int i = 0; i<NB_CARTE_DEPART; i++){
			pioche();
		}
	}
	/**
	 * ajoute une carte a la main, si NB_MAX_CARTE_MAIN non atteint, sinon retire 1 pv au héros
	 */
	private void pioche(){
		if(area.getPanelMain().getComponentCount()<NB_MAX_CARTE_MAIN){
			final CardPanel card = new CardPanel();
			card.setLayout(null);
			card.setCard(myHero.getDeck().getTabCartes().poll());
			card.setName(card.getCard().getNom());
			System.out.println(card.getName());
			card.makeCard();
			area.getPanelMain().add(card);
			card.showInfo(false);
			card.getButton().addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent evt){
					jButtonJouerClicked(evt, card);
				}
			});
			card.addMouseListener(new CardListenerMain(card, area.getLabelInfo()));
		}
		else{
			myHero.getDeck().getTabCartes().poll();
			if (myHero.getNbCoque()>0)
				myHero.setNbCoque(myHero.getNbCoque()-1);
			else
				myHero.setNbStructure(myHero.getNbStructure()-1);
		}
	}

	/**
	 * Permet d'engager une carte
	 * 		- Les serviteurs s'ajoutent sur le terrain
	 * @param evt
	 * @param label
	 */
	protected void jButtonJouerClicked(MouseEvent evt, CardPanel label) {
		if(myHero.getRessource() >= label.getCard().getRessource()){
			if((label.getCard() instanceof Serviteur) && area.getjPanelTerrain().getComponentCount()>=NB_MAX_CARTE_TERRAIN){
				JOptionPane.showMessageDialog(null, "Terrain Plein !");
			}
			else{
				if(label.getCard() instanceof Serviteur)
				{
					label.remove(label.getButton());
					if (((Serviteur)label.getCard()).isBuffing()){
						if (area.getjPanelTerrain().getComponentCount() > 0){
							JOptionPane.showMessageDialog(null, "Choisissez la carte à buffer");
							for(int i=0; i<area.getjPanelTerrain().getComponentCount(); i++){
								area.getjPanelTerrain().getComponent(i).addMouseListener(new BuffingListener(label, area.getjPanelTerrain()));
							}
						}
					}
					area.getjPanelTerrain().add(label);
					MouseListener ml[] = label.getMouseListeners();
					label.removeMouseListener(ml[ml.length-1]);
					label.addMouseListener(new CardListenerTerrain(label, area));
				}
				else if (label.getCard() instanceof Buff)
				{
					if (area.getjPanelTerrain().getComponentCount() > 0){
						JOptionPane.showMessageDialog(null, "Choisissez la carte à buffer");
						for(int i=0; i<area.getjPanelTerrain().getComponentCount(); i++){
							area.getjPanelTerrain().getComponent(i).addMouseListener(new BuffingListener(label, area.getjPanelTerrain()));
						}
					}
				}
				else if (label.getCard() instanceof Dommage){
					MouseListener ml[];
					for(int i=0; i< area.getjPanelTerrainAdversaire().getComponentCount(); i++){
						ml = area.getjPanelTerrainAdversaire().getComponent(i).getMouseListeners();
						((CardListenerTerrainAdv)ml[0]).setCardAttacking(label);
						((CardListenerTerrainAdv)ml[0]).setSortHero(null, null);
						((CardListenerTerrainAdv)ml[0]).setTargetable(true);
					}
					ml = area.getjLabelHerosAdversaire().getMouseListeners();
					((HerosListener)ml[0]).setCardAttacking(label);
					((HerosListener)ml[0]).setSortAttacking(null);
					((HerosListener)ml[0]).setTargetable(true);
				}
				myHero.setRessource(myHero.getRessource()-label.getCard().getRessource());
				this.area.getjLabelRessource().setText("<html><font color=white>"+myHero.getRessource()+"</font></html>");
				area.getPanelMain().remove(label);
				label.showInfo(false);
				label.setIcon(new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource(label.getCard().getImage())).getImage().getScaledInstance(85, 132, Image.SCALE_AREA_AVERAGING)));
				area.revalidate();
				area.repaint();
			}
		}
		else
			JOptionPane.showMessageDialog(null, "Ressources Inssufisantes !");
	}

	protected void jButtonFinTourClicked(MouseEvent evt) {
		nbTour++;
		if (nbTour < NB_MAX_RESSOURCE)
		{
			myHero.setRessource(nbTour);
		}
		else
		{
			myHero.setRessource(NB_MAX_RESSOURCE);
		}
		setTargetableFalse();
		this.area.getjLabelRessource().setText("<html><font color=white>"+myHero.getRessource()+"</font></html>");
		setCanAttack();
		MouseListener ml[] = area.getjLabelSortHeroique().getMouseListeners();
		((SortHerosListener)ml[0]).setEnable(true);
		this.area.revalidate();
		this.area.repaint();
		pioche();
	}

	private void setCanAttack(){
		MouseListener ml[];
		for (int i=0; i<area.getjPanelTerrain().getComponentCount(); i++){
			System.out.println("terrain : "+i);
			ml = area.getjPanelTerrain().getComponent(i).getMouseListeners();
			((CardListenerTerrain)ml[0]).setCanAttack(true);
		}
	}

	private void setTargetableFalse(){
		MouseListener ml[];
		for(int i=0; i<area.getjPanelTerrainAdversaire().getComponentCount(); i++){
			ml = area.getjPanelTerrainAdversaire().getComponent(i).getMouseListeners();
			((CardListenerTerrainAdv)ml[0]).setTargetable(false);
		}
		ml = area.getjLabelHerosAdversaire().getMouseListeners();
		((HerosListener)ml[0]).setTargetable(false);
	}

	protected void jButtonAnnulerClicked(MouseEvent evt)
	{
		this.connexion.dispose();
	}

	protected void jButtonCloseClicked(MouseEvent evt)
	{
		this.rules.dispose();
	}
	protected void jButtonCommencerClicked(MouseEvent evt)
	{
		myClient = new MyClient(this.connexion.getjTextFieldIP().getText());
		this.connexion.dispose();
		this.start.getjButtonChoixHeros().setEnabled(true);
		this.start.getjButtonConfig().setEnabled(false);
	}
	protected void jButtonMakeServerClicked(MouseEvent evt)
	{
		try {
			server = new MyServer();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, "Serveur lancé");
		
		
		
		try {
			myClientServer = new ClientServer(server.getS().accept());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		this.connexion.dispose();
		this.start.getjButtonChoixHeros().setEnabled(true);
		this.start.getjButtonConfig().setEnabled(false);
	}

	public MyClient getMyClient() {
		return myClient;
	}

	public ClientServer getMyClientServer() {
		return myClientServer;
	}
	public MyServer getServer()
	{
		return server;
	}
	
	
}
