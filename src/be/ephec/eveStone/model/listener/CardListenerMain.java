package be.ephec.eveStone.model.listener;

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

	private CardPanel card;
	private JLabel infoLabel;

	public CardListenerMain(CardPanel card, JLabel infoLabel){
		super();
		this.card=card;
		this.infoLabel = infoLabel;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		cardClicked(arg0, card);
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		cardMouseOn(card);
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		cardMouseOff(arg0, card);
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
	 * Permet d'afficher ou non le bouton jouer de la carte lorsque l'on clique dessus
	 * @param ev
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
	 * approffondie sur la carte (nom, type, description)
	 * 
	 * @param card le Panel de la carte active
	 */
	protected void cardMouseOn(final CardPanel card) {
		final Timer animation = new Timer();
		infoLabel.setText("<html><font color=white>Carte : "+card.getCard().getNom()+"<br/><br/>"
				+"Type : "+card.getCard().toString()+"<br/><br/>"
				+"Desciption : "+card.getCard().getDescription()+"</font></html>");
		animation.schedule(new TimerTask() {
			int width = 85;
			double height = 132;
			@Override
			public void run() {
				for(int i=0; i<23; i++) {
					card.setIcon(new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource(card.getCard().getImage())).getImage().getScaledInstance(width, (int)height, Image.SCALE_DEFAULT)));
					width=width+1;
					height=(height+(1*1.5));
					card.revalidate();
					card.repaint();
				}
				animation.cancel();
			}
		},5);
		card.showInfo(true);
	}
	/**
	 * Permet de dézoomer une carte et de supprimer l'affichage de toute les informations
	 * lui étant liées.
	 * 
	 * @param evt
	 * @param card
	 */
	protected void cardMouseOff(MouseEvent evt, final CardPanel card) {
		if (! (card.contains(evt.getPoint()))){
			infoLabel.setText("<html><font color=white>Carte : <br/><br/>"
					+"Type : <br/><br/>"
					+"Desciption : </font></html>");
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
