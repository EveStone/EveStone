package be.ephec.eveStone.model.listener;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import be.ephec.eveStone.vieuw.container.CardPanel;

/**
 * Listener pour les carte de la main.
 * 
 * Elle permet de mettre en jeu différentes carte. La méthde associé au bonton "Jouer"
 * de la carte se trouve dans le controller (peut etre modifié par la suite)
 * 
 * @author Dasseler Nicolas @ Vanbutsele Andy
 *
 */
public class CardListenerMain implements MouseListener{

	/** The card. */
	private CardPanel card;
	
	/** The info label. */
	private JLabel infoLabel;

	/**
	 * Instantiates a new card listener main.
	 *
	 * @param card the card
	 * @param infoLabel the info label
	 */
	public CardListenerMain(CardPanel card, JLabel infoLabel){
		super();
		this.card=card;
		this.infoLabel = infoLabel;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseClicked(MouseEvent arg0) {
		cardClicked(arg0, card);
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseEntered(MouseEvent arg0) {
		cardMouseOn(card);
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseExited(MouseEvent arg0) {
		cardMouseOff(arg0, card);
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 */
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * Permet d'afficher ou non le bouton jouer de la carte lorsque l'on clique dessus.
	 *
	 * @param ev the ev
	 * @param label le Label contenant la carte
	 */
	protected void cardClicked(MouseEvent ev, final CardPanel label) {
		if(label.getButton().isVisible())
			label.getButton().setVisible(false);
		else
			label.getButton().setVisible(true);
	}
	
	/**
	 * Méthode d'animation et d'affichage d'information
	 * 
	 * Lors du survole d'une carte, la carte va zoomer et afficher ses informations
	 * distinctes (ressource necessaire a la mise en jeu, points d'attaque, pv)
	 * Elle va aussi mettre à jour un cadran sur le coté qui permet d'avoir une aide
	 * approffondie sur la carte (nom, type, description).
	 *
	 * @param card le Panel de la carte active
	 */
	protected void cardMouseOn(final CardPanel card) {
		card.setCursor(new Cursor(Cursor.HAND_CURSOR));
		infoLabel.setText("<html><font color=white>Carte : "+card.getCard().getNom()+"<br/><br/>"
				+"Type : "+card.getCard().toString()+"<br/><br/>"
				+"Description :<br/>"+card.getCard().getDescription()+"</font></html>");
		card.setIcon(new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource(card.getCard().getImage())).getImage().getScaledInstance(108, 157, Image.SCALE_DEFAULT)));
		card.showInfo(true);
	}
	
	/**
	 * Permet de dézoomer une carte et de supprimer l'affichage de toute les informations
	 * lui étant liées.
	 *
	 * @param evt the evt
	 * @param card the card
	 */
	protected void cardMouseOff(MouseEvent evt, final CardPanel card) {
		if (! (card.contains(evt.getPoint()))){
			infoLabel.setText("<html><font color=white>Carte : <br/><br/>"
					+"Type : <br/><br/>"
					+"Description : </font></html>");
			final Timer animation = new Timer();
			card.getButton().setVisible(false);
			card.showInfo(false);
			card.getButton().setVisible(false);
			animation.schedule(new TimerTask() {
				int width = 108;
				double height = 157;
				@Override
				public void run() {
					for(int i=0; i<23; i++) {
						card.setIcon(new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource(card.getCard().getImage())).getImage().getScaledInstance(width, (int)height, Image.SCALE_SMOOTH)));
						width=width-1;
						height=(height-(1*1.5));
						card.revalidate();
						card.repaint();
					}
					animation.cancel();
				}
			},5);		
		}
	}
}
