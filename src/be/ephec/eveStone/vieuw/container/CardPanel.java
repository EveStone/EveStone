package be.ephec.eveStone.vieuw.container;

import be.ephec.eveStone.model.Carte;

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
		ressource.setText("<html><font color=\"#FBF2B7\">"+card.getRessource()+"</font></html>");
		ressource.setBounds(5, 0, 20, 20);
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
