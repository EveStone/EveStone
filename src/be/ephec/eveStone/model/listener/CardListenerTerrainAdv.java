package be.ephec.eveStone.model.listener;

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
import be.ephec.eveStone.vieuw.Area;
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

	private boolean isTargetable;
	private CardPanel cardAttacking;
	private SortHeroique sort;
	private JLabel labelSort;
	private JLabel heros;
	private Controller controller;
	
	private static final Cursor targetable = new Cursor(Cursor.CROSSHAIR_CURSOR);
	private static final Cursor notTargetable = new Cursor(Cursor.DEFAULT_CURSOR);

	/**
	 * Constructeur
	 * @param card le panel de la carte ciblée
	 * @param infoLabel le label d'information complémentaire
	 * @param terrain le terrain du joueur
	 * @param terrainAdv le terrain de son adversaire
	 */
	public CardListenerTerrainAdv(CardPanel card, Controller controller) {
		super(card, controller.getArea());
		this.controller = controller;
		this.heros=controller.getArea().getjLabelHerosAdversaire();
		isTargetable=false;
	}
	/**
	 * On verifie si la cible est targetable. On definit ensuite la nature des degats :
	 * 	-Si la source de dégat est un serviteur adverse, le sort enregistré est forcement null (voir CardListenerTerrain)
	 * 	 On vérifie donc si on peut l'attaquer (makeDegat).
	 * 		Si toute les conditions sont favorables, les serviteurs vont s'infliger des dégats mutuels
	 * 		On supprime donc les flags de target et on réinitialise la carte attaquante à null
	 * 		Si la cible qui attaquait était invisible, elle ne l'est plus et peut maintenant subir des dégats
	 * 	
	 * 	-Si la source de dégats est un sort,
	 * 	 On vérifie que les condition sont favorable (même règle que pour les carte en jeu)
	 * 	 On retire le montant de points de vie du sort a la cible.
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
					degats=((Serviteur)((CardPanel)arg0.getComponent()).getCard()).getNbDommage();
					if(cardAttacking.getCard() instanceof Serviteur){
						if (cardAttacking.getCard() instanceof Invisible){
							if (((Invisible)cardAttacking.getCard()).isInvisible());
							((Invisible)cardAttacking.getCard()).setInvisible(false);
						}
						dommageClicked(cardAttacking, degats);
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

	@Override
	public void mouseEntered(MouseEvent arg0) {
		super.mouseEntered(arg0);
		if(isTargetable)
			getCard().setCursor(targetable);
		else
			getCard().setCursor(notTargetable);
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		super.mouseExited(arg0);
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
	/**
	 * Méthode qui permet de définir si une carte de protection se trouve sur le terrain panel
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

	public CardPanel getCardAttacking() {
		return cardAttacking;
	}

	public void setCardAttacking(CardPanel cardAttacking) {
		this.cardAttacking = cardAttacking;
	}
	/**
	 * Méthode qui permet de définir si la cible est une cible attaquable
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
	 * Méthode qui permet de retire une nombre de point de dégat dommage à une carte
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
			System.out.println(""+getTerrainAdv().getComponentCount());
		}
	}

	public void setTargetable(boolean check){
		this.isTargetable=check;
	}

	public void setSortHero(SortHeroique sort, JLabel labelSort){
		this.sort=sort;
		this.labelSort=labelSort;
	}
}
