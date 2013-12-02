package be.ephec.eveStone.model.repositories;

import be.ephec.eveStone.model.Carte;

public class Main {
	private final int MAX_CARTE = 7;
	private int nbCarte;
	private Carte[] tabCarte;

	public Main(){
		nbCarte = 0;
		tabCarte = new Carte[MAX_CARTE];
	}
	/**
	 * 
	 * @param carte Ajoute une carte au tableau de la main
	 * @return Retourne l'index auqel la carte à été ajoutée dans le tableau de la main
	 * 			Et -1 sinon.
	 */
	public int add(Carte carte){
		int index = -1;
		if (nbCarte <= MAX_CARTE){
			nbCarte++;
			for(int i = 0; i<nbCarte; i++){
				if(tabCarte[i]==null){
					index=i;
					tabCarte[i]=carte;
					break;
				}
			}
			return index;
		}
		else{
			return index;
		}
	}
	
	public Carte remove(int index){
		Carte tmp = this.tabCarte[index];
		this.tabCarte[index] = null;
		nbCarte--;
		return tmp;
	}
	
	public Carte getCard(int index){
		if(index>=0 && index<=MAX_CARTE)
			return tabCarte[index];
		else
			return null;
	}
	
	public int getNbCarte(){
		return this.nbCarte;
	}

	public int getMaxCarte() {
		return this.MAX_CARTE;
	}
	
	public void affiche(){
		for(int i=0; i<MAX_CARTE; i++){
			if(tabCarte[i] != null)
				System.out.println(tabCarte[i].getNom() + " en : "+i);
		}
	}
}
