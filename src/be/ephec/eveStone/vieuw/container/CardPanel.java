package be.ephec.eveStone.vieuw.container;

import java.awt.Component;
import java.awt.Font;
import java.awt.Image;

import be.ephec.eveStone.model.*;

import javax.swing.Icon;
import javax.swing.ImageIcon;
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
	
	private static final int FONT_SIZE = 25;

	public CardPanel(){

	}

	public CardPanel(Icon image) {
		super(image);
	}

	public void makeCard(){

		this.setIcon(new ImageIcon((new ImageIcon(getClass().getClassLoader().getResource(card.getImage()))).getImage().getScaledInstance(85, 132, Image.SCALE_AREA_AVERAGING)));

		jouer = new JButton("Jouer");
		jouer.setBounds(15, 60, 75, 20);
		this.add(jouer);
		jouer.setVisible(false);

		ressource = new JLabel("<html><font color=\"#00FFFF\">"+card.getRessource()+"</font></html>");
		ressource.setBounds(5, 5, 30, 30);

		//85 x 132
		if (card instanceof Serviteur)
		{
			attaque = new JLabel("<html><font color=\"#FBF2B7\">"+((Serviteur) card).getNbDommage()+"</font></html>");
			attaque.setBounds(5, 135, 30, 30);
			this.add(attaque);
			attaque.setFont(new Font("Arial", 6, FONT_SIZE));
		}
		else if (card instanceof Dommage)
		{
			attaque = new JLabel("<html><font color=\"#FBF2B7\">"+((Dommage) card).getDegats()+"</font></html>");
			attaque.setBounds(5, 135, 30, 30);
			this.add(attaque);
			attaque.setFont(new Font("Arial", 6, FONT_SIZE));
		}

		if (card instanceof Serviteur)
		{
			vie = new JLabel("<html><font color=\"#FBF2B7\">"+((Serviteur) card).getNbVie()+"</font></html>");
			vie.setBounds(85, 135, 30, 30);
			this.add(vie);
			vie.setFont(new Font("Arial", 6, FONT_SIZE));
		}
		this.add(ressource);
		ressource.setFont(new Font("Arial", 6, FONT_SIZE));

	}

	public void showInfo(boolean show){

		this.ressource.setVisible(show);
		if(this.card instanceof Serviteur || card instanceof Dommage)
			this.attaque.setVisible(show);
		if(card instanceof Serviteur)
				this.vie.setVisible(show);
		this.revalidate();
		this.repaint();
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
	public void update()
	{
		attaque.setText("<html><font color=\"#FBF2B7\">"+((Serviteur) card).getNbDommage()+"</font></html>");
		vie.setText("<html><font color=\"#FBF2B7\">"+((Serviteur) card).getNbVie()+"</font></html>");
		this.revalidate();
		this.repaint();

	}

	@Override
	public Component.BaselineResizeBehavior getBaselineResizeBehavior() {
	    return Component.BaselineResizeBehavior.CONSTANT_ASCENT;
	}

	@Override
	public int getBaseline(int width, int height) {
	    return 0;
	}
	
	public Component add(Component comp){
		super.add(comp);
		return comp;
	}
	
}
