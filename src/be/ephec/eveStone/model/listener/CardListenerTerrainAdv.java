package be.ephec.eveStone.model.listener;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import be.ephec.eveStone.controller.Controller;
import be.ephec.eveStone.model.Dommage;
import be.ephec.eveStone.model.Invisible;
import be.ephec.eveStone.model.Protection;
import be.ephec.eveStone.model.Serviteur;
import be.ephec.eveStone.model.SortHeroique;
import be.ephec.eveStone.vieuw.container.CardPanel;

/**
 * Listener sur les cartes du terrain adverse.
 * 
 * Comme il existe des regles particulières en terme d'attaque, ces dernières
 * seront détaillées dans les méthodes adéquates.
 * 
 * @author Dasseler Nicolas & Vanbutsele Andy
 *
 */
public class CardListenerTerrainAdv extends CardListenerTerrain{

	/** The is targetable. */
	private boolean isTargetable;
	
	/** The card attacking. */
	private CardPanel cardAttacking;
	
	/** The sort. */
	private SortHeroique sort;
	
	/** The label sort. */
	private JLabel labelSort;
	
	/** The heros. */
	private JLabel heros;
	
	/** The controller. */
	private Controller controller;

	/** The Constant targetable. */
	private static final Cursor targetable = new Cursor(Cursor.CROSSHAIR_CURSOR);
	
	/** The Constant notTargetable. */
	private static final Cursor notTargetable = new Cursor(Cursor.DEFAULT_CURSOR);

	/**
	 * Constructeur.
	 *
	 * @param card le panel de la carte ciblée
	 * @param controller the controller
	 */
	public CardListenerTerrainAdv(CardPanel card, Controller controller) {
		super(card, controller.getArea());
		this.controller = controller;
		this.heros=controller.getArea().getjLabelHerosAdversaire();
		isTargetable=false;
	}
	
	/**
	 * On verifie si la cible est targetable. On definit ensuite la nature des degats :
	 * -Si la source de dégat est un serviteur adverse, le sort enregistré est forcement null (voir CardListenerTerrain)
	 * On vérifie donc si on peut l'attaquer (makeDegat).
	 * Si toute les conditions sont favorables, les serviteurs vont s'infliger des dégats mutuels
	 * On supprime donc les flags de target et on réinitialise la carte attaquante à null
	 * Si la cible qui attaquait était invisible, elle ne l'est plus et peut maintenant subir des dégats
	 * 
	 * -Si la source de dégats est un sort,
	 * On vérifie que les condition sont favorable (même règle que pour les carte en jeu)
	 * On retire le montant de points de vie du sort a la cible.
	 *
	 * @param arg0 the arg0
	 */
	@Override
	public void mouseClicked(MouseEvent arg0) {
		if (isTargetable){
			int degats;
			if (sort==null){
				if (cardAttacking.getCard() instanceof Serviteur)
					degats=((Serviteur)cardAttacking.getCard()).getNbDommage();
				else
					degats=((Dommage)cardAttacking.getCard()).getDegats();
				if (makeDommage(arg0)){
					dommageClicked((CardPanel)arg0.getComponent(), degats);
					controller.sendModif();
					degats=((Serviteur)((CardPanel)arg0.getComponent()).getCard()).getNbDommage();
					if(cardAttacking.getCard() instanceof Serviteur){
						if (cardAttacking.getCard() instanceof Invisible){
							if (((Invisible)cardAttacking.getCard()).isInvisible());
							((Invisible)cardAttacking.getCard()).setInvisible(false);
						}
						dommageClicked(cardAttacking, degats);
						controller.sendModif();

						MouseListener ml[]=cardAttacking.getMouseListeners();
						((CardListenerTerrain)ml[0]).setCanAttack(false);
						for(int i=0; i<getTerrainAdv().getComponentCount(); i++){
							ml = getTerrainAdv().getComponent(i).getMouseListeners();
							((CardListenerTerrainAdv)ml[0]).setTargetable(false);
							((CardListenerTerrainAdv)ml[0]).setCardAttacking(null);
						}
					}	
				}
			}
			else{
				degats=sort.getDegats();
				if(makeDommage(arg0)){
					dommageClicked(((CardPanel)arg0.getComponent()), degats);
					controller.sendModif();
					MouseListener ml[] = labelSort.getMouseListeners();
					((SortHerosListener)ml[0]).setEnable(false);
					for(int i=0; i<getTerrainAdv().getComponentCount(); i++){
						ml = getTerrainAdv().getComponent(i).getMouseListeners();
						((CardListenerTerrainAdv)ml[0]).setTargetable(false);
						((CardListenerTerrainAdv)ml[0]).setSortHero(null, null);
					}
				}
			}
			MouseListener ml[] = heros.getMouseListeners();
			((HerosListener)ml[0]).setTargetable(false);
			((HerosListener)ml[0]).setCardAttacking(null);
			((HerosListener)ml[0]).setSortAttacking(null);
			arg0.getComponent().setCursor(notTargetable);
		}
	}
	/*
	public void sendModifCarte(CardPanel cAttacking, CardPanel cAttacked)
	{


		try {
			if (controller.getMyClient() == null)
			{
				// Coté Serveur
				int i = retrieveIndex(getTerrainAdv(), cAttacked);
				System.out.println("INDICE CARTE : "+i);
				//Envoi carte attaquante
				controller.getMyClientServer().getOos().writeObject(new ObjectSend(2, cAttacked, i));
				i=retrieveIndex(getTerrain(), cAttacking);
				controller.getMyClientServer().getOos().writeObject(new ObjectSend(3, cAttacking, i));
			}
			else
			{
				// Coté client
				int i = retrieveIndex(getTerrainAdv(), cAttacked);
				controller.getMyClient().getOos().writeObject(new ObjectSend(2, cAttacked, i));
				i = retrieveIndex(getTerrain(), cAttacking);
				controller.getMyClient().getOos().writeObject(new ObjectSend(3, cAttacking, i));
			}
		} catch (IOException ey) {
			// TODO Auto-generated catch block
			ey.printStackTrace();
		}
	}

	public void sendModifCarteBack(CardPanel cAttacking, CardPanel cAttacked){
		try{
			if (controller.getMyClient() == null)
			{
				// Coté Serveur
				int i = retrieveIndex(getTerrainAdv(), cAttacking);
				System.out.println("INDICE CARTE : "+i);
				//Envoi carte attaquante
				controller.getMyClientServer().getOos().writeObject(new ObjectSend(2, cAttacking, i));
				i=retrieveIndex(getTerrain(), cAttacked);
				controller.getMyClientServer().getOos().writeObject(new ObjectSend(3, cAttacked, i));
			}
			else
			{
				// Coté client
				int i = retrieveIndex(getTerrainAdv(), cAttacking);
				controller.getMyClient().getOos().writeObject(new ObjectSend(2, cAttacking, i));
				i = retrieveIndex(getTerrain(), cAttacked);
				controller.getMyClient().getOos().writeObject(new ObjectSend(3, cAttacked, i));
			}
		}catch(IOException e){
			e.printStackTrace();
		}
	}*/
	/* (non-Javadoc)
	 * @see be.ephec.eveStone.model.listener.CardListenerTerrain#mouseEntered(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseEntered(MouseEvent arg0) {
		super.mouseEntered(arg0);
		if(isTargetable)
			getCard().setCursor(targetable);
		else
			getCard().setCursor(notTargetable);
	}

	/* (non-Javadoc)
	 * @see be.ephec.eveStone.model.listener.CardListenerTerrain#mouseExited(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseExited(MouseEvent arg0) {
		super.mouseExited(arg0);
	}

	/* (non-Javadoc)
	 * @see be.ephec.eveStone.model.listener.CardListenerTerrain#mousePressed(java.awt.event.MouseEvent)
	 */
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see be.ephec.eveStone.model.listener.CardListenerTerrain#mouseReleased(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * Méthode qui permet de définir si une carte de protection se trouve sur le terrain panel.
	 *
	 * @param panel le terrain à vérifier
	 * @return false si aucune carte Protection n'est en jeu sur le terrain panel, true sinon
	 */
	protected boolean checkListProtection(JPanel panel)
	{
		boolean check = false;
		for (int i = 0; i< panel.getComponentCount(); i++)
		{
			if (((CardPanel)panel.getComponent(i)).getCard() instanceof Protection)
			{
				return true;
			}
		}
		return check;
	}

	/**
	 * Gets the card attacking.
	 *
	 * @return the card attacking
	 */
	public CardPanel getCardAttacking() {
		return cardAttacking;
	}

	/**
	 * Sets the card attacking.
	 *
	 * @param cardAttacking the new card attacking
	 */
	public void setCardAttacking(CardPanel cardAttacking) {
		this.cardAttacking = cardAttacking;
	}

	/**
	 * Retrieve index.
	 *
	 * @param toFind the to find
	 * @param card the card
	 * @return the int
	 */
	public int retrieveIndex(JPanel toFind, CardPanel card){
		Component[] list = toFind.getComponents();
		int i=0;
		for(i=0; i<controller.getArea().getjPanelTerrainAdversaire().getComponentCount(); i++){
			if(list[i]==card)
				return i;
		}
		return -1;
	}

	/**
	 * Méthode qui permet de définir si la cible est une cible attaquable.
	 *
	 * @param e la source du clic
	 * @return true si la cible est attaquable, false sinon
	 */
	private boolean makeDommage(MouseEvent e)
	{
		if ((((CardPanel) e.getComponent()).getCard()) instanceof Invisible){
			if (((Invisible)((CardPanel) e.getComponent()).getCard()).isInvisible() == true)
			{
				JOptionPane.showMessageDialog(null, "Vous ne pouvez pas attaquer ce serviteur car il est invisible");
				return false;
			}
			else{
				return true;
			}
		}
		else{
			if (checkListProtection(getTerrainAdv()) == false || (((CardPanel)e.getComponent()).getCard()) instanceof Protection== true){
				return true;
			}
			else
			{
				JOptionPane.showMessageDialog(null, "L'adversaire a un serviteur sous protection, vous devez l'attaquer!");
				return false;
			}
		}
	}
	
	/**
	 * Méthode qui permet de retire une nombre de point de dégat dommage à une carte.
	 *
	 * @param card Le Label contenant la carte
	 * @param dommage Le nombre de point de dégats a retirr à la carte
	 */
	protected void dommageClicked(CardPanel card, final int dommage)
	{
		if (((Serviteur) (card.getCard())).getNbVie()-dommage >0){
			((Serviteur)(card.getCard())).setNbVie(((Serviteur)(card.getCard())).getNbVie() - dommage);
			card.update();
		}
		else{
			((Serviteur)card.getCard()).setNbVie(0);
		}
		if (((Serviteur)card.getCard()).getNbVie() == 0){
			card.setVisible(false);
			card.getParent().remove(card);
		}
	}

	/**
	 * Sets the targetable.
	 *
	 * @param check the new targetable
	 */
	public void setTargetable(boolean check){
		this.isTargetable=check;
	}

	/**
	 * Sets the sort hero.
	 *
	 * @param sort the sort
	 * @param labelSort the label sort
	 */
	public void setSortHero(SortHeroique sort, JLabel labelSort){
		this.sort=sort;
		this.labelSort=labelSort;
	}
}
