package be.ephec.eveStone.vieuw.container;

import be.ephec.eveStone.model.*;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class CardPanel extends JLabel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1931817779287136633L;
	private Carte card;
	JButton jouer;
	JLabel ressource;
	JLabel attaque;
	JLabel vie;

	public CardPanel(){

	}

	public CardPanel(Icon image) {
		super(image);
	}

	public void makeCard(){
		jouer = new JButton("Jouer");
		jouer.setBounds(5, 100, 75, 20);
		this.add(jouer);
		jouer.setVisible(false);

		ressource = new JLabel();
		ressource.setText("<html><font color=\"#00FF00\">"+card.getRessource()+"</font></html>");
		ressource.setBounds(5, 0, 20, 20);

		//85 x 132
		if ((card instanceof Serviteur) || (card instanceof Invisible) || (card instanceof Protection))
		{
			attaque = new JLabel();
			attaque.setText("<html><font color=\"#FBF2B7\">"+((Serviteur) card).getNbDommage()+"</font></html>");
			attaque.setBounds(5, 110, 20, 20);
			this.add(attaque);
		}
		else if (card instanceof Dommage)
		{
			attaque = new JLabel();
			attaque.setText("<html><font color=\"#FBF2B7\">"+((Dommage) card).getDegats()+"</font></html>");
			attaque.setBounds(5, 110, 20, 20);
			this.add(attaque);
		}

		if ((card instanceof Serviteur) || (card instanceof Invisible) || (card instanceof Protection))
		{
			vie = new JLabel();
			vie.setText("<html><font color=\"#FBF2B7\">"+((Serviteur) card).getNbDommage()+"</font></html>");
			vie.setBounds(73, 110, 20, 20);
			this.add(vie);
		}


		this.add(ressource);
		
	}

	public void setCard(Carte card){
		this.card = card;
	}

	public Carte getCard(){
		return this.card;
	}

	public JButton getButton(){
		return this.jouer;
	}

}
