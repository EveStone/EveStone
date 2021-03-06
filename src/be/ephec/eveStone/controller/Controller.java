package be.ephec.eveStone.controller;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import be.ephec.eveStone.model.*;
import be.ephec.eveStone.model.listener.BuffingListener;
import be.ephec.eveStone.model.listener.CardListenerMain;
import be.ephec.eveStone.model.listener.CardListenerTerrain;
import be.ephec.eveStone.model.listener.CardListenerTerrainAdv;
import be.ephec.eveStone.model.listener.FinTourListener;
import be.ephec.eveStone.model.listener.HerosListener;
import be.ephec.eveStone.model.listener.SortHerosListener;
import be.ephec.eveStone.model.net.ObjectSend;
import be.ephec.eveStone.model.net.Reception;
import be.ephec.eveStone.model.net.client.MyClient;
import be.ephec.eveStone.model.net.server.ClientServer;
import be.ephec.eveStone.model.net.server.MyServer;
import be.ephec.eveStone.vieuw.Area;
import be.ephec.eveStone.vieuw.ConnectionFrame;
import be.ephec.eveStone.vieuw.RulesFrame;
import be.ephec.eveStone.vieuw.StartFrame;
import be.ephec.eveStone.vieuw.container.CardPanel;

/**
 * La classe controller
 * 
 * @author Dasseler Nicolas & Vanbutsele Andy
 */
public class Controller {


	// Modèles
	/** mon héro*/
	private Heros myHero;
	
	/** le hero adverse */
	private Heros adverseHero;

	// Views
	/** l'area */
	private Area area;
	
	/** la fenetre de démarrage */
	private StartFrame start;
	
	/** la fenetre de connexion */
	private ConnectionFrame connexion;
	
	/** La fenetre de règles */
	private RulesFrame rules;

	/** La constante NB_MAX_RESSOURCE. */
	public final static int NB_MAX_RESSOURCE = 10;
	
	/** La constante NB_MAX_CARTE_TERRAIN. */
	public final static int NB_MAX_CARTE_TERRAIN = 7;
	
	/** La constante NB_MAX_CARTE_MAIN. */
	public final static int NB_MAX_CARTE_MAIN = 7;
	
	/** La constante NB_CARTE_DEPART. */
	public final static int NB_CARTE_DEPART = 4;



	//client NET
	/** mon client. */
	private MyClient myClient = null;
	
	/** mon client server. */
	private ClientServer myClientServer = null;
	
	/** le server. */
	private MyServer server;

	/** le nombre de tour. */
	public static int nbTour;

	/**
	 * Constructeur du controller.
	 */
	public Controller(){

	}
	/*
	 * Partie Construction des Frame et affichage pour lier les frames au Controller
	 */ 

	/**
	 * Construit la nouvelles Fenetre Start qui permet de séléctionner son héros, de se connecter
	 * à un serveur et de commencer une partie.
	 */
	public void makeStartFrame(){
		this.start = new StartFrame(this);
		this.start.getjButtonChoixHeros().setEnabled(false);
	}
	
	/**
	 * Affiche la startFrame.
	 */
	public void displayStartFrame(){
		start.setVisible(true);
	}
	
	/**
	 * Construit la fenêtre de connection.
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
	 * Affiche la fenêtre de connection.
	 */
	public void displayConnectionFrame(){
		connexion.display();
	}
	
	/**
	 * Construit la fenêtre de regles.
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
	 * Affiche la fenêtre de regles.
	 */
	public void displayRulesFrame()
	{
		rules.display();
	}
	/**
	 * Contsruit la zone de jeu qui permet de jouer contre un adversaire.
	 */
	public void makeArea(){

		this.area = new Area(this);
		this.area.getjLabelHeros().setIcon(new ImageIcon(getClass().getClassLoader().getResource(myHero.getImage())));
		nbTour=1;
		piocheDepart();
		initSortHero(area.getjLabelSortHeroique());

		sendHero();
		connexionStarted();
		

		this.area.getjLabelHerosAdversaire().setIcon(new ImageIcon(getClass().getClassLoader().getResource(adverseHero.getImage())));
		area.getjLabelHerosAdversaire().addMouseListener(new HerosListener(adverseHero, this));
		this.area.getjLabelSortHeroiqueAdversaire().setIcon(new ImageIcon(getClass().getClassLoader().getResource(adverseHero.getSortHero().getImage())));
		this.area.getFinTourButton().addMouseListener(new FinTourListener(this));

		if (myClient == null)
		{
			area.getFinTourButton().setEnabled(true);
		}
		else
		{
			area.getFinTourButton().setEnabled(false);
			stateOfEnd();
		}
		area.playSound();
	}

	/**
	 * Etat de fin de tour
	 */
	public void stateOfEnd()
	{
		MouseListener mlSh[] = area.getjLabelSortHeroique().getMouseListeners();
		((SortHerosListener)mlSh[0]).setEnable(false);
		for (int i = 0; i<area.getjPanelTerrain().getComponentCount(); i++)
		{
			MouseListener ml[] = area.getjPanelTerrain().getComponent(i).getMouseListeners();
			//area.getjPanelTerrain().getComponent(i).removeMouseListener(ml[0]);
			((CardListenerTerrain)ml[0]).setCanAttack(false);
		}
		for (int i = 0; i<area.getjPanelMain().getComponentCount(); i++)
		{
			MouseListener ml[] = area.getjPanelMain().getComponent(i).getMouseListeners();
			area.getjPanelMain().getComponent(i).removeMouseListener(ml[0]);
		}
	}
	
	/**
	 * Affiche la Zone de jeu.
	 */
	public void displayArea(){
		area.display();
	}

	/**
	 * Initialise l'affichage du sort héroique.
	 *
	 * @param sortHero the sort hero
	 */
	private void initSortHero(JLabel sortHero){
		sortHero.setIcon(new ImageIcon(getClass().getClassLoader().getResource(myHero.getSortHero().getImage())));
		sortHero.addMouseListener(new SortHerosListener(myHero, this));
	}

	/**
	 * Retourne l'area.
	 *
	 * @return area: Area
	 */
	public Area getArea(){
		return this.area;
	}
	
	/**
	 * Cette m�thode permet de retourner l'attaque d'un serviteur et d'un sort.
	 *
	 * @param c the c
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
	/**
	 * Retourne on héro
	 *
	 * @return hero: Heros
	 */
	public Heros getMyHero() {
		return myHero;
	}
	
	/**
	 * Sets mon héro
	 *
	 * @param myHero : Hero
	 */
	public void setMyHero(Heros myHero) {
		this.myHero = myHero;
	}

	/**
	 * Retourne le héros adverse
	 *
	 * @return adverseHero: Heros
	 */
	public Heros getAdverseHero() {
		return adverseHero;
	}

	/**
	 * Sets le Héro adverse
	 *
	 * @param adverseHero : Heros
	 */
	public void setAdverseHero(Heros adverseHero) {
		this.adverseHero = adverseHero;
	}

	// Actions
	/**
	 * Pioche NB_CARTE_DEPART au début du jeu.
	 *
	 */
	private void piocheDepart() {
		for(int i = 0; i<NB_CARTE_DEPART; i++){
			JLabel label = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("img/CarteDosV3.png")));
			area.getjPanelMainAdversaire().add(label);
			pioche();
		}
	}
	
	/**
	 * ajoute une carte a la main, si NB_MAX_CARTE_MAIN non atteint, sinon retire 1 pv au héros.
	 */
	public void pioche(){
		if(area.getPanelMain().getComponentCount()<NB_MAX_CARTE_MAIN){
			final CardPanel card = new CardPanel();
			card.setLayout(null);
			card.setCard(myHero.getDeck().getTabCartes().poll());
			card.setName(card.getCard().getNom());
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
	 * - Les serviteurs s'ajoutent sur le terrain.
	 *
	 * @param evt the evt
	 * @param label the label
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
								area.getjPanelTerrain().getComponent(i).addMouseListener(new BuffingListener(label, this));
							}
						}
					}
					area.getjPanelTerrain().add(label);
					if (myClient == null)
					{
						try {
							myClientServer.getOos().writeObject(new ObjectSend(1, label));
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					else 
					{
						try {
							myClient.getOos().writeObject(new ObjectSend(1, label));
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
					MouseListener[] ml = label.getMouseListeners();
					label.removeMouseListener(ml[ml.length-1]);
					label.addMouseListener(new CardListenerTerrain(label, area));
				}
				else if (label.getCard() instanceof Buff)
				{
					if (area.getjPanelTerrain().getComponentCount() > 0){
						JOptionPane.showMessageDialog(null, "Choisissez la carte à buffer");
						for(int i=0; i<area.getjPanelTerrain().getComponentCount(); i++){
							area.getjPanelTerrain().getComponent(i).addMouseListener(new BuffingListener(label, this));
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
				try {
					if(myClient == null)
						myClientServer.getOos().writeObject(new ObjectSend(4, this.getMyHero().getRessource()));
					else
						myClient.getOos().writeObject(new ObjectSend(4, this.getMyHero().getRessource()));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		else
			JOptionPane.showMessageDialog(null, "Ressources Inssufisantes !");
	}

	/**
	 * J button annuler clicked.
	 *
	 * @param evt : MouseEvent
	 */
	protected void jButtonAnnulerClicked(MouseEvent evt)
	{
		this.connexion.dispose();
	}

	/**
	 * J button close clicked.
	 *
	 * @param evt : MouseEvent
	 */
	protected void jButtonCloseClicked(MouseEvent evt)
	{
		this.rules.dispose();
	}


	//Partie NET
	/**
	 * Démarrer la partie, envoie des héros.
	 *
	 * @param evt : MouseEvent
	 */
	protected void jButtonCommencerClicked(MouseEvent evt)
	{
		try {
			myClient = new MyClient(this.connexion.getjTextFieldIP().getText(), Integer.parseInt(this.connexion.getTextFieldPort().getText()));
		} catch (UnknownHostException e) {
			System.err.println("Erreur lors de la création du client");
		} catch (IOException e) {
			System.err.println("Erreur lors de la création du client");
		}
		this.connexion.dispose();
		this.start.getjButtonChoixHeros().setEnabled(true);
		this.start.getjButtonConfig().setEnabled(false);
	}
	
	/**
	 * Création du serveur.
	 *
	 * @param evt : MouseEvent
	 */
	protected void jButtonMakeServerClicked(MouseEvent evt)
	{
		try {
			server = new MyServer(this);
		} catch (InterruptedException e) {
			System.err.println("Erreur lors de la création du serveur");;
		}
		JOptionPane.showMessageDialog(null, "Serveur lancé");

		this.connexion.dispose();
		this.start.getjButtonChoixHeros().setEnabled(true);
		this.start.getjButtonConfig().setEnabled(false);
	}
	
	/**
	 * Connexion demarrer.
	 */
	public void connexionStarted()
	{
		try {
			ObjectSend message = null;
			if (myClient == null)
			{

				message = (ObjectSend)myClientServer.getOis().readObject();
				System.out.println("Le héro de l'adversaire est " + ((Heros)message.getObj()).getNom());
				Thread tClientServer = new Thread(new Reception(this , myClientServer.getOis()));
				tClientServer.start();
			}
			else 
			{
				message = (ObjectSend)myClient.getOis().readObject();
				System.out.println("Le héro de l'adversaire est " + ((Heros)message.getObj()).getNom());
				Thread tClient = new Thread(new Reception(this , myClient.getOis()));
				tClient.start();
			}
			this.adverseHero = (Heros)message.getObj();
		} catch (IOException | ClassNotFoundException e) {
			System.err.println("Erreur d'envoi");
		}
	}
	
	/**
	 * Envoie dommage hero.
	 */
	public void sendDommageHero()
	{
		Boolean[] tabVisibleTerrain = new Boolean[area.getjPanelTerrain().getComponentCount()];

		for (int i = 0; i<area.getjPanelTerrain().getComponentCount(); i++)
		{
			if (((CardPanel)area.getjPanelTerrain().getComponent(i)).getCard() instanceof Invisible)
			{
				tabVisibleTerrain[i] = ((Invisible)((CardPanel)area.getjPanelTerrain().getComponent(i)).getCard()).isInvisible();
			}
		}
		try {
			if (myClient == null)
			{

				myClientServer.getOos().writeObject(new ObjectSend(3, adverseHero.getNbCoque(), adverseHero.getNbStructure(),tabVisibleTerrain));
				myClientServer.getOos().flush();

			}
			else
			{
				myClient.getOos().writeObject(new ObjectSend(3, adverseHero.getNbCoque(), adverseHero.getNbStructure(),tabVisibleTerrain));
				myClient.getOos().flush();
			}
		} catch (IOException e) {
			System.err.println("Erreur d'envoi");
		}
	}

	/**
	 * Envoie modif.
	 */
	public void sendModif()
	{
		int[] tabVieTerrain = new int[area.getjPanelTerrain().getComponentCount()];
		int[] tabDegatsTerrain = new int[area.getjPanelTerrain().getComponentCount()];
		Boolean[] tabVisibleTerrain = new Boolean[area.getjPanelTerrain().getComponentCount()];

		for (int i = 0; i<area.getjPanelTerrain().getComponentCount(); i++)
		{
			tabVieTerrain[i] = ((Serviteur)((CardPanel)area.getjPanelTerrain().getComponent(i)).getCard()).getNbVie();
			tabDegatsTerrain[i] = ((Serviteur)((CardPanel)area.getjPanelTerrain().getComponent(i)).getCard()).getNbDommage();
			if (((CardPanel)area.getjPanelTerrain().getComponent(i)).getCard() instanceof Invisible)
			{
				tabVisibleTerrain[i] = ((Invisible)((CardPanel)area.getjPanelTerrain().getComponent(i)).getCard()).isInvisible();
			}
			else
				tabVisibleTerrain[i] = false;
		}
		int[] tabVieTerrainAdv = new int[area.getjPanelTerrainAdversaire().getComponentCount()];
		int[] tabDegatsTerrainAdv = new int[area.getjPanelTerrainAdversaire().getComponentCount()];
		Boolean[] tabVisibleTerrainAdv = new Boolean[area.getjPanelTerrainAdversaire().getComponentCount()];
		for (int i = 0; i<area.getjPanelTerrainAdversaire().getComponentCount(); i++)
		{
			tabVieTerrainAdv[i] = ((Serviteur)((CardPanel)area.getjPanelTerrainAdversaire().getComponent(i)).getCard()).getNbVie();
			tabDegatsTerrainAdv[i] = ((Serviteur)((CardPanel)area.getjPanelTerrainAdversaire().getComponent(i)).getCard()).getNbDommage();
			if (((CardPanel)area.getjPanelTerrainAdversaire().getComponent(i)).getCard() instanceof Invisible)
			{
				tabVisibleTerrainAdv[i] = ((Invisible)((CardPanel)area.getjPanelTerrainAdversaire().getComponent(i)).getCard()).isInvisible();
			}
			else
				tabVisibleTerrainAdv[i] = false;
		}
		try {
			if (myClient == null)
			{

				myClientServer.getOos().writeObject(new ObjectSend(2, area.getjPanelTerrainAdversaire().getComponents(),area.getjPanelTerrain().getComponents(), tabVieTerrain, tabDegatsTerrain, tabVieTerrainAdv, tabDegatsTerrainAdv, tabVisibleTerrain, tabVisibleTerrainAdv));
				myClientServer.getOos().flush();

			}
			else
			{
				myClient.getOos().writeObject(new ObjectSend(2, area.getjPanelTerrainAdversaire().getComponents(),area.getjPanelTerrain().getComponents(),tabVieTerrain, tabDegatsTerrain, tabVieTerrainAdv, tabDegatsTerrainAdv, tabVisibleTerrain, tabVisibleTerrainAdv));
				myClient.getOos().flush();
			}
		} catch (IOException e) {
			System.err.println("Erreur d'envoi");
		}
	}
	
	/**
	 * Envoie hero.
	 */
	public void sendHero()
	{
		try {
			if (myClient == null)
			{
				myClientServer.getOos().writeObject(new ObjectSend(0,myHero));
			}
			else 
			{
				myClient.getOos().writeObject(new ObjectSend(0,myHero));
			}
		} catch (IOException e) {
			System.err.println("Erreur d'envoi");
		}
	}

	/**
	 * Retourne mon client
	 *
	 * @return myClient : MyClient
	 */
	public MyClient getMyClient() {
		return myClient;
	}

	/**
	 * Retourne le client server
	 *
	 * @return myClientServer : ClientServer
	 */
	public ClientServer getMyClientServer() {
		return myClientServer;
	}

	/**
	 * Set mon client
	 *
	 * @param myClient : MyClient
	 */
	public void setMyClient(MyClient myClient) {
		this.myClient = myClient;
	}

	/**
	 * Set mon client serveur
	 *
	 * @param myClientServer : ClientServer
	 */
	public void setMyClientServer(ClientServer myClientServer) {
		this.myClientServer = myClientServer;
	}

	/**
	 * Retourne le serveur
	 *
	 * @return myServer : MyServer
	 */
	public MyServer getServer()
	{
		return server;
	}



}
