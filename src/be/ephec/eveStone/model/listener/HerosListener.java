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

import be.ephec.eveStone.model.Dommage;
import be.ephec.eveStone.model.Hero;
import be.ephec.eveStone.model.Protection;
import be.ephec.eveStone.model.Serviteur;
import be.ephec.eveStone.model.SortHeroique;
import be.ephec.eveStone.vieuw.Area;
import be.ephec.eveStone.vieuw.container.CardPanel;

public class HerosListener implements MouseListener{

	private boolean isTargetable;
	private JPanel terrainAdv;
	private Hero heros;
	private CardPanel cardAttacking;
	private SortHeroique sortHeroique;
	private JLabel labelCoque;
	private JLabel labelStructure;
	private JLabel anim; 
	private JLabel herosLabel;

	private static final Cursor targetable = new Cursor(Cursor.CROSSHAIR_CURSOR);
	private static final Cursor notTargetable = new Cursor(Cursor.DEFAULT_CURSOR);

	public HerosListener(Hero heros, Area area){
		this.heros=heros;
		this.cardAttacking=null;
		this.sortHeroique=null;
		this.terrainAdv=area.getjPanelTerrainAdversaire();
		this.labelCoque=area.getjLabelCoqueAdverse();
		this.labelStructure=area.getjLabelStructureAdverse();
		isTargetable=false;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		System.out.println("Target = "+isTargetable);
		if (isTargetable){
			if(!checkProtection()){
				int degats=0;
				if(sortHeroique==null){
					if (cardAttacking.getCard() instanceof Serviteur){
						degats=((Serviteur)cardAttacking.getCard()).getNbDommage();
					}
					else
						degats=((Dommage)cardAttacking.getCard()).getDegats();
					resetTarget();
				}
				else
					degats=sortHeroique.getDegats();
				resetTarget();
				makeDommage(degats);
				boum(arg0);
				updateUI();
				System.out.println("Coque : "+heros.getNbCoque()+" Struct : "+heros.getNbStructure());
				arg0.getComponent().setCursor(notTargetable);
			}
			else{
				JOptionPane.showMessageDialog(null, "L'adversaire a un serviteur sous protection ! Vous devez d'abord l'attaquer !");
			}
			isTargetable=false;
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		if(isTargetable)
			arg0.getComponent().setCursor(targetable);
		else
			arg0.getComponent().setCursor(notTargetable);
	}

	@Override
	public void mouseExited(MouseEvent arg0) {

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {

	}

	public void setTargetable(boolean check){
		this.isTargetable=check;
	}

	public void setCardAttacking(CardPanel card){
		this.cardAttacking=card;
	}

	public void setSortAttacking(SortHeroique sort){
		this.sortHeroique=sort;
	}

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

	private boolean checkProtection(){
		boolean check=false;
		for(int i=0; i<terrainAdv.getComponentCount(); i++){
			if(((CardPanel)terrainAdv.getComponent(i)).getCard() instanceof Protection){
				check=true;
			}
		}
		return check;
	}

	private void updateUI(){
		labelCoque.setText(""+heros.getNbCoque());
		labelStructure.setText("<html><font color=white>"+heros.getNbStructure()+"</font></html>");
		labelCoque.revalidate();
		labelCoque.repaint();
		labelStructure.revalidate();
		labelStructure.repaint();
	}

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
				System.exit(0);
			}
		}	
	}

	private void boum(MouseEvent e){
		herosLabel = ((JLabel)e.getComponent());
		herosLabel.setLayout(new BorderLayout());
		System.out.println("boum");
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
