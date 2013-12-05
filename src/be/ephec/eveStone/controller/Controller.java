package be.ephec.eveStone.controller;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import be.ephec.eveStone.model.*;
import be.ephec.eveStone.model.net.MyClient;
import be.ephec.eveStone.vieuw.Area;
import be.ephec.eveStone.vieuw.ConnectionFrame;
import be.ephec.eveStone.vieuw.RulesFrame;
import be.ephec.eveStone.vieuw.StartFrame;
import be.ephec.eveStone.vieuw.container.CardPanel;

public class Controller {

	// Modèles
	private Hero myHero;
	private Hero adverseHero;
	private CardPanel current;

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
		this.area = new Area(this);
		this.area.getjLabelHeros().setIcon(new ImageIcon(getClass().getClassLoader().getResource(myHero.getImage())));
		this.area.getFinTourButton().addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent evt){
				jButtonFinTourClicked(evt);
			}
		});
		nbTour=1;
		piocheDepart();
	}

	/**
	 * Affiche la Zone de jeu
	 */
	public void displayArea(){
		area.display();
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
	private void makeDommage(final int dommage)
	{
		System.out.println(area.getjPanelTerrainAdversaire().getComponentCount());
		for (int i = 0; i< area.getjPanelTerrainAdversaire().getComponentCount(); i++)
		{
			area.getjPanelTerrainAdversaire().getComponent(i).addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e)
				{
					if (((Invisible)((CardPanel) e.getComponent()).getCard()).isInvisible() == true)
					{
						JOptionPane.showMessageDialog(null, "Vous ne pouvez pas attaquer ce serviteur car il est invisible");
					}
					else if (checkListProtection(area.getjPanelTerrainAdversaire()) == false || ((Protection)((CardPanel) e.getComponent()).getCard()).isProtection()== true)
					{
						dommageClicked(e, dommage);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "L'adversaire a un serviteur sous protection, vous devez l'attaquer!");
					}
					delLastMotionListener(area.getjPanelTerrain());
				}
			});
		}
	}
	protected boolean checkListProtection(JPanel panel)
	{
		boolean check = false;
		for (int i = 0; i< panel.getComponentCount(); i++)
		{
			if (((Protection)((CardPanel) panel.getComponent(i)).getCard()).isProtection()== true)
			{
				return true;
			}
		}
		return check;
	}
			
	
			
	protected void dommageClicked(MouseEvent e, final int dommage)
	{
		((Serviteur)((CardPanel) e.getComponent()).getCard()).setNbVie(((Serviteur)((CardPanel) e.getComponent()).getCard()).getNbVie() - dommage);
		JOptionPane.showMessageDialog(null, "Vous infligez " + dommage + " de dégats sur le serviteur" + ((Serviteur)((CardPanel) e.getComponent()).getCard()).getNom());
		((CardPanel) e.getComponent()).update();
	}
	/**
	 * Cette méthode permet de buff une carte ciblé elle est ainsi augmenter de X pts de vie et de X pts de degats
	 * @param buff[0] ==> pv
	 *        buff[1] ==> degats 
	 */
	private void makeBuff(final int[] buff)
	{
		if ((buff[1] != 0) && (buff[0] !=0))
		{
			JOptionPane.showMessageDialog(null, "Cliquez sur une carte pour augmenter de " + buff[0] + " le nombre de points de vie et de " + buff[1] + " le nombre de dégats du serviteur ciblé");
			System.out.println(area.getjPanelTerrain().getComponentCount());
			for (int i = 0; i< area.getjPanelTerrain().getComponentCount(); i++)
			{
				area.getjPanelTerrain().getComponent(i).addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e)
					{
						buffClicked(e, buff);
						delLastMotionListener(area.getjPanelTerrain());
					}
				});
			}
		}
		else if ((buff[1] == 0) && (buff[0] !=0))
		{
			JOptionPane.showMessageDialog(null, "Cliquez sur une carte pour augmenter de " + buff[0] + " de points de vie du serviteur ciblé");
			System.out.println(area.getjPanelTerrain().getComponentCount());
			for (int i = 0; i< area.getjPanelTerrain().getComponentCount(); i++)
			{
				area.getjPanelTerrain().getComponent(i).addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e)
					{
						buffClicked(e, buff);
						delLastMotionListener(area.getjPanelTerrain());
					}
				});
			}
		}
		else if ((buff[1] != 0) && (buff[0] ==0))
		{
			JOptionPane.showMessageDialog(null, "Cliquez sur une carte pour augmenter de " + buff[1] + " de points de dégats du serviteur ciblé");
			System.out.println(area.getjPanelTerrain().getComponentCount());
			for (int i = 0; i< area.getjPanelTerrain().getComponentCount(); i++)
			{
				area.getjPanelTerrain().getComponent(i).addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e)
					{
						buffClicked(e, buff);
						delLastMotionListener(area.getjPanelTerrain());
					}
				});
			}
		}
	}
	/**
	 * Retourne un tableau de int pour le buff de la carte
	 * @param une carte ne peut pas être null
	 * @return buff[0] ==> pv
	 *         buff[1] ==> degats
	 */
	private int[] getBuff(Carte c)
	{
		int buff[] = {0 , 0};
		if (c instanceof Serviteur)
		{
			buff[0] = ((Serviteur) c).getServBuffPv();
			buff[1] = ((Serviteur) c).getServBuffDeg();
			return buff;
		}
		else if (c instanceof Buff)
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

	// Actions
	/**
	 * Panel du deck, quand on clique sur le deck, on ajoute une carte a la main. (a supprimer car automatique)
	 * @param evt
	 */
	private void piocheDepart() {
		for(int i = 0; i<NB_CARTE_DEPART; i++){
			area.getDeckPanel().revalidate();
			area.getDeckPanel().repaint();
			final CardPanel card = new CardPanel();
			card.setLayout(null);
			card.setCard(myHero.getDeck().getTabCartes().poll());
			card.setName(card.getCard().getNom());
			card.makeCard();
			area.getPanelMain().add(card);
			card.getButton().addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent evt){
					jButtonJouerClicked(evt, card);
				}
			});
			card.addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent ev){
					cardClicked(ev, card);
				}
			});
			card.addMouseListener(new MouseAdapter(){
				public void mouseEntered(MouseEvent evt){
					cardMouseOn(card);
				}
			});
			card.addMouseListener(new MouseAdapter(){
				public void mouseExited(MouseEvent evt){
					cardMouseOff(evt,card);
				}
			});
		}
	}

	private void pioche(){
		if(area.getPanelMain().getComponentCount()<NB_MAX_CARTE_MAIN){
			area.getDeckPanel().revalidate();
			area.getDeckPanel().repaint();
			final CardPanel card = new CardPanel();
			card.setLayout(null);
			card.setCard(myHero.getDeck().getTabCartes().poll());
			card.setName(card.getCard().getNom());
			card.makeCard();
			area.getPanelMain().add(card);
			card.getButton().addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent evt){
					jButtonJouerClicked(evt, card);
				}
			});
			card.addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent ev){
					cardClicked(ev, card);
				}
			});
			card.addMouseListener(new MouseAdapter(){
				public void mouseEntered(MouseEvent evt){
					cardMouseOn(card);
				}
			});
			card.addMouseListener(new MouseAdapter(){
				public void mouseExited(MouseEvent evt){
					cardMouseOff(evt, card);
				}
			});
		}
		else{
			myHero.getDeck().getTabCartes().poll();
			myHero.setNbCoque(myHero.getNbCoque()-1);
		}
	}

	protected void cardMouseOff(MouseEvent evt, final CardPanel card) {
		Timer animation = new Timer();
		animation.schedule(new TimerTask() {
			@Override
			public void run() {
				int width = 200;
				double height = 300;
				for(int i=0; i<115; i++) {
					card.setIcon(new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource(card.getCard().getImage())).getImage().getScaledInstance(width, (int)height, Image.SCALE_DEFAULT)));
					width--;
					height=(height-1.5);
					card.revalidate();
					card.repaint();
				}
			}
		},2);
		animation.purge();
	}

	protected void cardMouseOn(final CardPanel card) {
		Timer animation = new Timer();
		animation.schedule(new TimerTask() {
			@Override
			public void run() {
				int width = 85;
				double height = 122;
				for(int i=0; i<115; i++) {
					card.setIcon(new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource(card.getCard().getImage())).getImage().getScaledInstance(width, (int)height, Image.SCALE_DEFAULT)));
					width++;
					height=(height+1.5);
					card.revalidate();
					card.repaint();
				}
			}
		},2);
		animation.purge();
	}
	/**
	 * Cette méthode permet de supprimer le dernier mouseListener d'un Jpanel 
	 * Utile pour supprimer un mouseListener d'un carte présent dans la main ou sur un terrain.
	 * @param p: JPanel non null
	 */
	protected void delLastMotionListener(JPanel p)
	{
		for (int i = 0; i< p.getComponentCount(); i++)
		{
			MouseListener ml[] = p.getComponent(i).getMouseListeners();
			p.getComponent(i).removeMouseListener(ml[ml.length-1]);
		}
	}
	/**
	 * Losque que l'on clique sur une carte, un bouton jouer apparait.
	 * @param ev
	 * @param label le CarPanel qui contient la carte.
	 */
	protected void cardClicked(MouseEvent ev, final CardPanel label) {
		if (current == null)
			current=label;
		else{
			current.getButton().setVisible(false);
			current=label;
		}
		if(label.getButton().isVisible())
			label.getButton().setVisible(false);
		else
			label.getButton().setVisible(true);
		area.getPanelMain().revalidate();
		area.getPanelMain().repaint();
		System.out.println(label.getName());
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
					area.getjPanelTerrain().add(label);
					makeBuff(getBuff(label.getCard()));
				}
				else if (label.getCard() instanceof Buff)
				{
					makeBuff(getBuff(label.getCard()));
				}
				myHero.setRessource(myHero.getRessource()-label.getCard().getRessource());
				this.area.getjLabelRessource().setText("<html><font color=white>"+myHero.getRessource()+"</font></html>");
				label.remove(label.getButton());
				area.getPanelMain().remove(label);
				area.revalidate();
				area.repaint();
			}

		}
		else
			JOptionPane.showMessageDialog(null, "Ressources Inssufisantes !");
	}

	protected void jButtonFinTourClicked(MouseEvent evt) {
		nbTour++;
		if(current != null)
			current.getButton().setVisible(false);
		if (nbTour < NB_MAX_RESSOURCE)
		{
			myHero.setRessource(nbTour);
		}
		else
		{
			myHero.setRessource(NB_MAX_RESSOURCE);
		}
		this.area.getjLabelRessource().setText("<html><font color=white>"+myHero.getRessource()+"</font></html>");
		this.area.revalidate();
		this.area.repaint();
		pioche();
	}
	/**
	 * Cette methode recoit un event et buff la carte en fonction du tableau buff
	 * @param e: event non null
	 * @param buff[0] ==> pv
	 *        buff[1] ==> degats 
	 */
	protected void buffClicked(MouseEvent e, final int buff[])
	{
		((Serviteur)((CardPanel) e.getComponent()).getCard()).setNbVie(((Serviteur)((CardPanel) e.getComponent()).getCard()).getNbVie() + buff[0]);
		((Serviteur)((CardPanel) e.getComponent()).getCard()).setNbDommage(((Serviteur)((CardPanel) e.getComponent()).getCard()).getNbDommage() + buff[1]);
		((CardPanel) e.getComponent()).update();


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
