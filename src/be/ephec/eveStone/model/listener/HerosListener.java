package be.ephec.eveStone.model.listener;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import be.ephec.eveStone.controller.Controller;
import be.ephec.eveStone.model.Dommage;
import be.ephec.eveStone.model.Heros;
import be.ephec.eveStone.model.Invisible;
import be.ephec.eveStone.model.Protection;
import be.ephec.eveStone.model.Serviteur;
import be.ephec.eveStone.model.SortHeroique;
import be.ephec.eveStone.vieuw.container.CardPanel;

// TODO: Auto-generated Javadoc
/**
 * The listener interface for receiving heros events.
 * The class that is interested in processing a heros
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addHerosListener<code> method. When
 * the heros event occurs, that object's appropriate
 * method is invoked.
 *
 * @see HerosEvent
 */
public class HerosListener implements MouseListener{

	/** The is targetable. */
	private boolean isTargetable;
	
	/** The terrain adv. */
	private JPanel terrainAdv;
	
	/** The heros. */
	private Heros heros;
	
	/** The card attacking. */
	private CardPanel cardAttacking;
	
	/** The sort heroique. */
	private SortHeroique sortHeroique;
	
	/** The label coque. */
	private JLabel labelCoque;
	
	/** The label structure. */
	private JLabel labelStructure;
	
	/** The anim. */
	private JLabel anim; 
	
	/** The heros label. */
	private JLabel herosLabel;
	
	/** The controller. */
	private Controller controller;

	/** The Constant targetable. */
	private static final Cursor targetable = new Cursor(Cursor.CROSSHAIR_CURSOR);
	
	/** The Constant notTargetable. */
	private static final Cursor notTargetable = new Cursor(Cursor.DEFAULT_CURSOR);

	/**
	 * Instantiates a new heros listener.
	 *
	 * @param heros the heros
	 * @param controller the controller
	 */
	public HerosListener(Heros heros, Controller controller){
		this.heros=heros;
		this.cardAttacking=null;
		this.sortHeroique=null;
		this.terrainAdv=controller.getArea().getjPanelTerrainAdversaire();
		this.labelCoque=controller.getArea().getjLabelCoqueAdverse();
		this.labelStructure=controller.getArea().getjLabelStructureAdverse();
		this.controller = controller;
		isTargetable=false;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseClicked(MouseEvent arg0) {
		if (isTargetable){
			if(!checkProtection()){
				int degats=0;
				if(sortHeroique==null){
					if (cardAttacking.getCard() instanceof Serviteur){
						degats=((Serviteur)cardAttacking.getCard()).getNbDommage();
					}
					else
					{
						degats=((Dommage)cardAttacking.getCard()).getDegats();
					}
					if  (cardAttacking.getCard() instanceof Invisible){
						((Invisible)cardAttacking.getCard()).setInvisible(false);
					}
					resetTarget();
				}
				else
					degats=sortHeroique.getDegats();
				resetTarget();
				makeDommage(degats);
				controller.sendDommageHero();
				boum(arg0);
				updateUI();
				arg0.getComponent().setCursor(notTargetable);
			}
			else{
				JOptionPane.showMessageDialog(null, "L'adversaire a un serviteur sous protection ! Vous devez d'abord l'attaquer !");
			}
			isTargetable=false;
		}
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseEntered(MouseEvent arg0) {
		if(isTargetable)
			arg0.getComponent().setCursor(targetable);
		else
			arg0.getComponent().setCursor(notTargetable);
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseExited(MouseEvent arg0) {

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
	 * Sets the card attacking.
	 *
	 * @param card the new card attacking
	 */
	public void setCardAttacking(CardPanel card){
		this.cardAttacking=card;
	}

	/**
	 * Sets the sort attacking.
	 *
	 * @param sort the new sort attacking
	 */
	public void setSortAttacking(SortHeroique sort){
		this.sortHeroique=sort;
	}

	/**
	 * Reset target.
	 */
	private void resetTarget(){
		MouseListener ml[];
		if((cardAttacking!=null) && (!(cardAttacking.getCard() instanceof Dommage))){
			ml = cardAttacking.getMouseListeners();
			((CardListenerTerrain)ml[0]).setCanAttack(false);
		}
		for(int i=0; i<terrainAdv.getComponentCount(); i++){
			ml = terrainAdv.getComponent(i).getMouseListeners();
			((CardListenerTerrainAdv)ml[0]).setCardAttacking(null);
			((CardListenerTerrainAdv)ml[0]).setSortHero(null, null);
			((CardListenerTerrainAdv)ml[0]).setTargetable(false);
		}
		this.setCardAttacking(null);
	}

	/**
	 * Check protection.
	 *
	 * @return true, if successful
	 */
	private boolean checkProtection(){
		boolean check=false;
		for(int i=0; i<terrainAdv.getComponentCount(); i++){
			if(((CardPanel)terrainAdv.getComponent(i)).getCard() instanceof Protection){
				check=true;
			}
		}
		return check;
	}

	/**
	 * Update ui.
	 */
	private void updateUI(){
		labelCoque.setText(""+heros.getNbCoque());
		labelStructure.setText("<html><font color=white>"+heros.getNbStructure()+"</font></html>");
		labelCoque.revalidate();
		labelCoque.repaint();
		labelStructure.revalidate();
		labelStructure.repaint();
	}

	/**
	 * Make dommage.
	 *
	 * @param degats the degats
	 */
	private void makeDommage(int degats){
		if(heros.getNbCoque()-degats>=0)
			heros.setNbCoque(heros.getNbCoque()-degats);
		else{
			degats=degats-heros.getNbCoque();
			if(heros.getNbCoque()!=0)
				heros.setNbCoque(0);
			heros.setNbStructure(heros.getNbStructure()-degats);
			if (heros.getNbStructure() <=0){
				JOptionPane.showMessageDialog(null, "Vous avez gagné !");
				controller.sendDommageHero();
				System.exit(0);
			}
		}	
	}

	/**
	 * Boum.
	 *
	 * @param e the e
	 */
	private void boum(MouseEvent e){
		herosLabel = ((JLabel)e.getComponent());
		herosLabel.setLayout(new BorderLayout());
		anim = new JLabel();
		anim.setIcon(new ImageIcon(getClass().getClassLoader().getResource("animation/explosion.gif")));
		((JLabel)e.getComponent()).add(anim, BorderLayout.CENTER);
		
		ActionListener stop = new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				anim.setIcon(null);
				herosLabel.revalidate();
				herosLabel.repaint();
				herosLabel.remove(anim);
			}
			
		};
		javax.swing.Timer thread = new javax.swing.Timer(300, stop);
		thread.setRepeats(false);
		thread.start();
	}
}
