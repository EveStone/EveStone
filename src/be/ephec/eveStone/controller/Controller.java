package be.ephec.eveStone.controller;

import be.ephec.eveStone.model.*;
import be.ephec.eveStone.vieuw.StartFrame;

public class Controller {
	
	private Hero myHero;
	private Hero adverseHero;
	
	private StartFrame start = new StartFrame();
	
	
	public Controller(){
		
	}
	/**
	 * Cette méthode retourne le String de la classe d'une carte
	 * @param carte ne peut pas etre null
	 * @return la Classe sous la forme de String
	 */
	public String getClassCarte(Carte c)
	{
		return (c.getClass()).toString();
	}
	/**
	 * Cette méthode permet de retourner l'attaque d'un serviteur et d'un sort
	 * @param une carte (NE PEUT PAS ETRE NULL
	 * @return 0 si ce n'est pas un serviteur ou un sort de dommage, retourne l'attaque du serviteur ou le nombre de dommage du sort
	 */
	public int attaque(Carte c)
	{
		int attaque = 0;
		String check = getClassCarte(c);
		switch (check)
		{
		case ("Serviteur") : return ((Serviteur) c).getNbDommage();
		case ("Invisible") : return ((Serviteur) c).getNbDommage();
		case ("Protection") : return ((Serviteur) c).getNbDommage();
		case ("Dommage") : return ((Dommage) c).getDegats();
		default : return attaque;
		}

	}

	/*
	 * Getters et setters pour avoir le hero adverse ou son hero 
	 * 
	 * 
	 */
	public Hero getMyHero() {
		return myHero;
	}
	public void setMyHero(Hero myHero) {
		this.myHero = myHero;
	}
	public Hero getAdverseHero() {
		return adverseHero;
	}
	public void setAdverseHero(Hero adverseHero) {
		this.adverseHero = adverseHero;
	}

	
}
