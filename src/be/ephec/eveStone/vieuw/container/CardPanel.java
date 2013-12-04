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
	private int index;
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
		if (card.getClass().isInstance(Serviteur.class) || card.getClass().isInstance(Invisible.class) || card.getClass().isInstance(Protection.class))
		{
			attaque = new JLabel();
			attaque.setText("<html><font color=\"#FBF2B7\">"+((Serviteur) card).getNbDommage()+"</font></html>");
			attaque.setBounds(5, 125, 20, 20);
			System.out.println("coucou");
			this.add(attaque);
		}
		else if (card.getClass().isInstance(Dommage.class))
		{
			attaque = new JLabel();
			attaque.setText("<html><font color=\"#FBF2B7\">"+((Dommage) card).getDegats()+"</font></html>");
			attaque.setBounds(5, 125, 20, 20);
			this.add(attaque);
		}

		if (card.getClass().isInstance(Serviteur.class) || card.getClass().isInstance(Invisible.class) || card.getClass().isInstance(Protection.class))
		{
			vie = new JLabel();
			vie.setText("<html><font color=\"#FBF2B7\">"+((Serviteur) card).getNbDommage()+"</font></html>");
			vie.setBounds(80, 120, 20, 20);
			System.out.println("coucou1");
			this.add(vie);
		}


		this.add(ressource);
		
	}

	public void setIndex(int index){
		this.index = index;
	}

	public int getIndex(){
		return this.index;
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
