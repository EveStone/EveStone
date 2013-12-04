package be.ephec.eveStone.model.repositories;

import java.util.Collections;
import java.util.LinkedList;

import be.ephec.eveStone.model.*;




public class Deck {
	
	private static final String PATH_ACOLYTE = "img/acolyte.png";
	private static final String PATH_PRAETOR = "img/praetor.png";
	private static final String PATH_MISSILE = "img/missile.png";
	private static final String PATH_LASER = "img/laser.png";
	private static final String PATH_ACOLYTE_EV_300 = "img/acolyteEV300.png";
	private static final String PATH_HEAVY_MAINTENANCE = "img/heavyMaintenance.png";
	private static final String PATH_MALLEUS = "img/malleus.png";
	private static final String PATH_SHIELD_BOOST = "img/shieldBoost.png";
	private static final String PATH_TEMPLAR = "img/templar.png";
	private static final String PATH_INFILTRATOR = "img/infiltrator.png";
	private static final String PATH_DRONE_AMPLIFIER = "img/droneAmplifier.png";
	private static final String PATH_PRAETOR_TD_900 = "img/praetorTD900.png";
	private static final String PATH_LIGHT_MAINTENANCE = "img/lightMaintenance.png";
	private static final String PATH_HORNET = "img/hornet.png";
	private static final String PATH_WASP = "img/wasp.png";
	private static final String PATH_HORNET_EC_300 = "img/hornetEC300";
	private static final String PATH_MANTIS = "img/mantis.png";
	private static final String PATH_DRAGONFLY = "img/dragonfly.png";
	private static final String PATH_VESPA = "img/vespa.png";
	private static final String PATH_WASP_EC_900 = "img/waspEC900.png";
	
	private LinkedList<Carte> listCartes;
	private String nom;
	
	public Deck(String nom)
	{
		if (nom.compareTo("interceptor") == 0)
		{
			this.nom = nom;
			this.listCartes = makeListInterceptor();
		}
		else
		{ 
			if (nom.compareTo("fregate") == 0)
			{
				this.nom = nom;
				this.listCartes = makeListFregate();
				
			}
			else
			{
				System.out.println("ERROR: nom non valide");
			}
		}
		
	}

	public LinkedList<Carte> getTabCartes() {
		return listCartes;
	}

	public void setTabCartes(LinkedList<Carte> listCartes) {
		this.listCartes = listCartes;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	private LinkedList<Carte> makeListInterceptor()
	{
		LinkedList<Carte> tmp = new LinkedList<Carte>();
		// Amarr
		tmp.add(new Serviteur("Acolyte", 2, PATH_ACOLYTE, 2, 2));
		tmp.add(new Serviteur("Acolyte", 2, PATH_ACOLYTE, 2, 2));
		tmp.add(new Serviteur("Praetor", 5, PATH_PRAETOR, 3, 5));
		tmp.add(new Serviteur("Praetor", 5, PATH_PRAETOR, 3, 5));
		tmp.add(new Serviteur("Acolyte", 2, PATH_ACOLYTE, 2, 2));
		tmp.add(new Serviteur("Acolyte", 2, PATH_ACOLYTE, 2, 2));
		tmp.add(new Serviteur("Praetor", 5, PATH_PRAETOR, 3, 5));
		tmp.add(new Serviteur("Praetor", 5, PATH_PRAETOR, 3, 5));
		tmp.add(new Dommage("Tourelle Laser", 5, PATH_LASER, "Attaque directement un serviteur ou un Héro", 4));
		tmp.add(new Dommage("Tourelle Laser", 5, PATH_LASER, "Attaque directement un serviteur ou un Héro", 4));
		tmp.add(new Serviteur("Acolyte EV-300",2, PATH_ACOLYTE_EV_300, 2, 2, 1, 1));
		tmp.add(new Serviteur("Acolyte EV-300",2, PATH_ACOLYTE_EV_300, 2, 2, 1, 1));
		tmp.add(new Protection("Heavy Maintenance",6, PATH_HEAVY_MAINTENANCE, 5, 6, 1, 1, true));
		tmp.add(new Protection("Heavy Maintenance",6, PATH_HEAVY_MAINTENANCE, 5, 6, 1, 1, true));
		tmp.add(new Invisible("Malleus",4, PATH_MALLEUS, 4, 4, 2, true));
		tmp.add(new Invisible("Malleus",4, PATH_MALLEUS, 4, 4, 2, true));
		tmp.add(new Buff("Shield Boost",2, PATH_SHIELD_BOOST, "Augmente de 2 la vie d'un serviteur", 2, 0));
		tmp.add(new Buff("Shield Boost",2, PATH_SHIELD_BOOST, "Augmente de 2 la vie d'un serviteur", 2, 0));
		tmp.add(new Serviteur("Templar",8, PATH_TEMPLAR, 6, 8, 2, 2));
		tmp.add(new Serviteur("Templar",8, PATH_TEMPLAR, 6, 8, 2, 2));
		tmp.add(new Serviteur("Infiltrator", 3,PATH_INFILTRATOR, 3,3));
		tmp.add(new Serviteur("Infiltrator", 3,PATH_INFILTRATOR, 3,3));
		tmp.add(new Buff("Drone Amplifier",4, PATH_DRONE_AMPLIFIER, "Augmente de 4 les Pv et de 4 les dégats d'un serviteur", 4, 4));
		tmp.add(new Buff("Drone Amplifier",4, PATH_DRONE_AMPLIFIER, "Augmente de 4 les Pv et de 4 les dégats d'un serviteur", 4, 4));
		tmp.add(new Protection("Praetor TD-900",2, PATH_PRAETOR_TD_900, 2, 2, true));
		tmp.add(new Protection("Praetor TD-900",2, PATH_PRAETOR_TD_900, 2, 2, true));
		tmp.add(new Serviteur("Light Maintenance",1, PATH_LIGHT_MAINTENANCE, 1, 1, 1, 0));
		tmp.add(new Serviteur("Light Maintenance",1, PATH_LIGHT_MAINTENANCE, 1, 1, 1, 0));
		tmp.add(new Serviteur("Light Maintenance",1, PATH_LIGHT_MAINTENANCE, 1, 1, 1, 0));
		tmp.add(new Serviteur("Light Maintenance",1, PATH_LIGHT_MAINTENANCE, 1, 1, 1, 0));
		Collections.shuffle(tmp);
		return tmp;
	}
	private LinkedList<Carte> makeListFregate()
	{
		//caldari
		LinkedList<Carte> tmp = new LinkedList<Carte>();
		tmp.add(new Serviteur("Hornet", 2, PATH_HORNET, 2, 2));
		tmp.add(new Serviteur("Hornet", 2, PATH_HORNET, 2, 2));
		tmp.add(new Serviteur("Wasp", 5, PATH_WASP, 3, 5));
		tmp.add(new Serviteur("Wasp", 5, PATH_WASP, 3, 5));
		tmp.add(new Serviteur("Hornet", 2, PATH_HORNET, 2, 2));
		tmp.add(new Serviteur("Hornet", 2, PATH_HORNET, 2, 2));
		tmp.add(new Serviteur("Wasp", 5, PATH_WASP, 3, 5));
		tmp.add(new Serviteur("Wasp", 5, PATH_WASP, 3, 5));
		tmp.add(new Serviteur("Hornet EC-300",2, PATH_HORNET_EC_300, 2, 2, 1, 1));
		tmp.add(new Serviteur("Hornet EC-300",2, PATH_HORNET_EC_300, 2, 2, 1, 1));
		tmp.add(new Buff("Shield Boost",2, PATH_SHIELD_BOOST, "Augmente de 2 la vie d'un serviteur", 2, 0));
		tmp.add(new Buff("Shield Boost",2, PATH_SHIELD_BOOST, "Augmente de 2 la vie d'un serviteur", 2, 0));
		tmp.add(new Protection("Heavy Maintenance",6, PATH_HEAVY_MAINTENANCE, 5, 6, 1, 1, true));
		tmp.add(new Protection("Heavy Maintenance",6, PATH_HEAVY_MAINTENANCE, 5, 6, 1, 1, true));
		tmp.add(new Invisible("Mantis",4, PATH_MANTIS, 4, 4, 2, true));
		tmp.add(new Invisible("Mantis",4, PATH_MANTIS, 4, 4, 2, true));
		tmp.add(new Dommage("Tir de Missile", 2, PATH_MISSILE, "Attaque directement un serviteur ou un Héro", 2));
		tmp.add(new Dommage("Tir de Missile", 2,PATH_MISSILE, "Attaque directement un serviteur ou un Héro", 2));
		tmp.add(new Serviteur("Dragonfly",8, PATH_DRAGONFLY, 6, 8, 2, 2));
		tmp.add(new Serviteur("Dragonfly",8, PATH_DRAGONFLY, 6, 8, 2, 2));
		tmp.add(new Serviteur("Vespa", 3,PATH_VESPA, 3,3));
		tmp.add(new Serviteur("Vespa", 3,PATH_VESPA, 3,3));
		tmp.add(new Buff("Drone Amplifier",4, PATH_DRONE_AMPLIFIER, "Augmente de 4 les Pv et de 4 les dégats d'un serviteur", 4, 4));
		tmp.add(new Buff("Drone Amplifier",4, PATH_DRONE_AMPLIFIER, "Augmente de 4 les Pv et de 4 les dégats d'un serviteur", 4, 4));
		tmp.add(new Protection("Wasp EC-900",2, PATH_WASP_EC_900, 2, 2, true));
		tmp.add(new Protection("Wasp EC-900",2, PATH_WASP_EC_900, 2, 2, true));
		tmp.add(new Serviteur("Light Maintenance",1, PATH_LIGHT_MAINTENANCE, 1, 1, 1, 0));
		tmp.add(new Serviteur("Light Maintenance",1, PATH_LIGHT_MAINTENANCE, 1, 1, 1, 0));
		tmp.add(new Serviteur("Light Maintenance",1, PATH_LIGHT_MAINTENANCE, 1, 1, 1, 0));
		tmp.add(new Serviteur("Light Maintenance",1, PATH_LIGHT_MAINTENANCE, 1, 1, 1, 0));
		Collections.shuffle(tmp);
		return tmp;
	}
	

}
