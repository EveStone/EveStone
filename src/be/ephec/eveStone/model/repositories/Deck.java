package be.ephec.eveStone.model.repositories;

import java.util.Collections;
import java.util.LinkedList;

import be.ephec.eveStone.model.*;




public class Deck {
	
	private static final String PATH_ACOLYTE = "img/InterceptorCard/acolyte.png";
	private static final String PATH_PRAETOR = "img/InterceptorCard/praetor.png";
	private static final String PATH_MISSILE = "img/FregateCard/missile.png";
	private static final String PATH_LASER = "img/InterceptorCard/laser.png";
	private static final String PATH_ACOLYTE_EV_300 = "img/InterceptorCard/acolyteEV300.png";
	private static final String PATH_HEAVY_MAINTENANCE = "img/CommonCard/heavyMaintenance.png";
	private static final String PATH_MALLEUS = "img/InterceptorCard/malleus.png";
	private static final String PATH_SHIELD_BOOST = "img/CommonCard/shieldBoost.png";
	private static final String PATH_TEMPLAR = "img/InterceptorCard/templar.png";
	private static final String PATH_INFILTRATOR = "img/InterceptorCard/infiltrator.png";
	private static final String PATH_DRONE_AMPLIFIER = "img/CommonCard/droneAmplifier.png";
	private static final String PATH_PRAETOR_TD_900 = "img/InterceptorCard/praetorTD900.png";
	private static final String PATH_LIGHT_MAINTENANCE = "img/CommonCard/lightMaintenance.png";
	private static final String PATH_HORNET = "img/FregateCard/hornet.png";
	private static final String PATH_WASP = "img/FregateCard/wasp.png";
	private static final String PATH_HORNET_EC_300 = "img/FregateCard/hornetEC300.png";
	private static final String PATH_MANTIS = "img/FregateCard/mantis.png";
	private static final String PATH_DRAGONFLY = "img/FregateCard/dragonfly.png";
	private static final String PATH_VESPA = "img/FregateCard/vespa.png";
	private static final String PATH_WASP_EC_900 = "img/FregateCard/waspEC900.png";
	
	
	private static final String DESCR_ACOLYTE = "Drone d'attaque léger";
	private static final String DESCR_PRAETOR = "Drone de combat";
	private static final String DESCR_MISSILE = "Attaque un serviteur ou le héros ennemi et lui inflige 4 points de dégats";
	private static final String DESCR_LASER = "Attaque un serviteur ou le héros ennemi et lui inflige 4 points de dégats";
	private static final String DESCR_ACOLYTE_EV_300 = "Lorsqu'il est posé en jeu, ce serviteur augmente les points de vie et les points d'attaque d'un serviteur de 1";
	private static final String DESCR_HEAVY_MAINTENANCE = "Protection : L'ennemi ne peut attaquer aucun autre serviteur ou votre héros tant que cette carte est en jeu<br/>"
															+ "Rends 1 points de vie et augmentes l'attaque d'un drone de 1";
	private static final String DESCR_MALLEUS = "Invisible : Le serviteur ne peut etre ciblé tant que celui-ci n'a pas attaqué";
	private static final String DESCR_SHIELD_BOOST = "Augmente les points de vie d'un serviteur de 2";
	private static final String DESCR_TEMPLAR = "Lorsqu'il est posé en jeu, ce serviteur augmente les points de vie et les points d'attaque d'un serviteur de 2";
	private static final String DESCR_INFILTRATOR = "Drone d'attaque moyen";
	private static final String DESCR_DRONE_AMPLIFIER = "Augmente les points de vie et d'attaque d'un serviteur sur le terrain de 4";
	private static final String DESCR_PRAETOR_TD_900 = "Protection : L'ennemi ne peut attaquer aucun autre serviteur ou votre héros tant que cette carte est en jeu";
	private static final String DESCR_LIGHT_MAINTENANCE = "Augmente les points de vie d'un serviteur engagé sur le terrain de 1";
	private static final String DESCR_HORNET = "Drone d'attaque léger";
	private static final String DESCR_WASP="Drone de combat";
	private static final String DESCR_HORNET_EC_300="Lorsqu'il est posé en jeu, ce serviteur augmente les points de vie et les points d'attaque d'un serviteur de 1";
	private static final String DESCR_MANTIS = "Invisible : Le serviteur ne peut etre ciblé tant que celui-ci n'a pas attaqué";
	private static final String DESCR_DRAGONFLY = "Lorsqu'il est posé en jeu, ce serviteur augmente les points de vie et les points d'attaque d'un serviteur de 2";
	private static final String DESCR_VESPA = "Drone d'attaque moyen";
	private static final String DESCR_WASP_EC_900 = "Protection : L'ennemi ne peut attaquer aucun autre serviteur ou votre héros tant que cette carte est en jeu";
	
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
		tmp.add(new Serviteur("Acolyte", 2, PATH_ACOLYTE, DESCR_ACOLYTE, 2, 2));
		tmp.add(new Serviteur("Acolyte", 2, PATH_ACOLYTE, DESCR_ACOLYTE, 2, 2));
		tmp.add(new Serviteur("Praetor", 5, PATH_PRAETOR, DESCR_PRAETOR, 3, 5));
		tmp.add(new Serviteur("Praetor", 5, PATH_PRAETOR, DESCR_PRAETOR, 3, 5));
		tmp.add(new Serviteur("Acolyte", 2, PATH_ACOLYTE, DESCR_ACOLYTE, 2, 2));
		tmp.add(new Serviteur("Acolyte", 2, PATH_ACOLYTE, DESCR_ACOLYTE, 2, 2));
		tmp.add(new Serviteur("Praetor", 5, PATH_PRAETOR, DESCR_PRAETOR, 3, 5));
		tmp.add(new Serviteur("Praetor", 5, PATH_PRAETOR, DESCR_PRAETOR, 3, 5));
		tmp.add(new Dommage("Tourelle Laser", 5, PATH_LASER, DESCR_LASER, 4));
		tmp.add(new Dommage("Tourelle Laser", 5, PATH_LASER, DESCR_LASER, 4));
		tmp.add(new Serviteur("Acolyte EV-300",2, PATH_ACOLYTE_EV_300, DESCR_ACOLYTE_EV_300, 2, 2, 1, 1));
		tmp.add(new Serviteur("Acolyte EV-300",2, PATH_ACOLYTE_EV_300, DESCR_ACOLYTE_EV_300, 2, 2, 1, 1));
		tmp.add(new Protection("Heavy Maintenance",6, PATH_HEAVY_MAINTENANCE, DESCR_HEAVY_MAINTENANCE, 5, 6, 1, 1, true));
		tmp.add(new Protection("Heavy Maintenance",6, PATH_HEAVY_MAINTENANCE, DESCR_HEAVY_MAINTENANCE, 5, 6, 1, 1, true));
		tmp.add(new Invisible("Malleus",4, PATH_MALLEUS, DESCR_MALLEUS, 4, 4, 2, true));
		tmp.add(new Invisible("Malleus",4, PATH_MALLEUS, DESCR_MALLEUS, 4, 4, 2, true));
		tmp.add(new Buff("Shield Boost",2, PATH_SHIELD_BOOST, DESCR_SHIELD_BOOST, 2, 0));
		tmp.add(new Buff("Shield Boost",2, PATH_SHIELD_BOOST, DESCR_SHIELD_BOOST, 2, 0));
		tmp.add(new Serviteur("Templar",8, PATH_TEMPLAR, DESCR_TEMPLAR, 6, 8, 2, 2));
		tmp.add(new Serviteur("Templar",8, PATH_TEMPLAR, DESCR_TEMPLAR, 6, 8, 2, 2));
		tmp.add(new Serviteur("Infiltrator", 3,PATH_INFILTRATOR, DESCR_INFILTRATOR, 3,3));
		tmp.add(new Serviteur("Infiltrator", 3,PATH_INFILTRATOR, DESCR_INFILTRATOR, 3,3));
		tmp.add(new Buff("Drone Amplifier",4, PATH_DRONE_AMPLIFIER, DESCR_DRONE_AMPLIFIER, 4, 4));
		tmp.add(new Buff("Drone Amplifier",4, PATH_DRONE_AMPLIFIER, DESCR_DRONE_AMPLIFIER, 4, 4));
		tmp.add(new Protection("Praetor TD-900",2, PATH_PRAETOR_TD_900, DESCR_PRAETOR_TD_900, 2, 2, true));
		tmp.add(new Protection("Praetor TD-900",2, PATH_PRAETOR_TD_900, DESCR_PRAETOR_TD_900, 2, 2, true));
		tmp.add(new Serviteur("Light Maintenance",1, PATH_LIGHT_MAINTENANCE, DESCR_LIGHT_MAINTENANCE, 1, 1, 1, 0));
		tmp.add(new Serviteur("Light Maintenance",1, PATH_LIGHT_MAINTENANCE, DESCR_LIGHT_MAINTENANCE, 1, 1, 1, 0));
		tmp.add(new Serviteur("Light Maintenance",1, PATH_LIGHT_MAINTENANCE, DESCR_LIGHT_MAINTENANCE, 1, 1, 1, 0));
		tmp.add(new Serviteur("Light Maintenance",1, PATH_LIGHT_MAINTENANCE, DESCR_LIGHT_MAINTENANCE, 1, 1, 1, 0));
		Collections.shuffle(tmp);
		return tmp;
	}
	private LinkedList<Carte> makeListFregate()
	{
		//caldari
		LinkedList<Carte> tmp = new LinkedList<Carte>();
		tmp.add(new Serviteur("Hornet", 2, PATH_HORNET, DESCR_HORNET, 2, 2));
		tmp.add(new Serviteur("Hornet", 2, PATH_HORNET, DESCR_HORNET, 2, 2));
		tmp.add(new Serviteur("Wasp", 5, PATH_WASP, DESCR_WASP, 3, 5));
		tmp.add(new Serviteur("Wasp", 5, PATH_WASP, DESCR_WASP, 3, 5));
		tmp.add(new Serviteur("Hornet", 2, PATH_HORNET, DESCR_HORNET, 2, 2));
		tmp.add(new Serviteur("Hornet", 2, PATH_HORNET, DESCR_HORNET, 2, 2));
		tmp.add(new Serviteur("Wasp", 5, PATH_WASP, DESCR_WASP, 3, 5));
		tmp.add(new Serviteur("Wasp", 5, PATH_WASP, DESCR_WASP, 3, 5));
		tmp.add(new Serviteur("Hornet EC-300",2, PATH_HORNET_EC_300, DESCR_HORNET_EC_300, 2, 2, 1, 1));
		tmp.add(new Serviteur("Hornet EC-300",2, PATH_HORNET_EC_300, DESCR_HORNET_EC_300, 2, 2, 1, 1));
		tmp.add(new Buff("Shield Boost",2, PATH_SHIELD_BOOST, DESCR_SHIELD_BOOST, 2, 0));
		tmp.add(new Buff("Shield Boost",2, PATH_SHIELD_BOOST, DESCR_SHIELD_BOOST, 2, 0));
		tmp.add(new Protection("Heavy Maintenance",6, PATH_HEAVY_MAINTENANCE, DESCR_HEAVY_MAINTENANCE, 5, 6, 1, 1, true));
		tmp.add(new Protection("Heavy Maintenance",6, PATH_HEAVY_MAINTENANCE, DESCR_HEAVY_MAINTENANCE, 5, 6, 1, 1, true));
		tmp.add(new Invisible("Mantis",4, PATH_MANTIS, DESCR_MANTIS, 4, 4, 2, true));
		tmp.add(new Invisible("Mantis",4, PATH_MANTIS, DESCR_MANTIS, 4, 4, 2, true));
		tmp.add(new Dommage("Tir de Missile", 2, PATH_MISSILE, DESCR_MISSILE, 2));
		tmp.add(new Dommage("Tir de Missile", 2,PATH_MISSILE, DESCR_MISSILE, 2));
		tmp.add(new Serviteur("Dragonfly",8, PATH_DRAGONFLY, DESCR_DRAGONFLY, 6, 8, 2, 2));
		tmp.add(new Serviteur("Dragonfly",8, PATH_DRAGONFLY, DESCR_DRAGONFLY, 6, 8, 2, 2));
		tmp.add(new Serviteur("Vespa", 3,PATH_VESPA, DESCR_VESPA, 3,3));
		tmp.add(new Serviteur("Vespa", 3,PATH_VESPA, DESCR_VESPA, 3,3));
		tmp.add(new Buff("Drone Amplifier",4, PATH_DRONE_AMPLIFIER, DESCR_DRONE_AMPLIFIER, 4, 4));
		tmp.add(new Buff("Drone Amplifier",4, PATH_DRONE_AMPLIFIER, DESCR_DRONE_AMPLIFIER, 4, 4));
		tmp.add(new Protection("Wasp EC-900",2, PATH_WASP_EC_900, DESCR_WASP_EC_900, 2, 2, true));
		tmp.add(new Protection("Wasp EC-900",2, PATH_WASP_EC_900, DESCR_WASP_EC_900, 2, 2, true));
		tmp.add(new Serviteur("Light Maintenance",1, PATH_LIGHT_MAINTENANCE, DESCR_LIGHT_MAINTENANCE, 1, 1, 1, 0));
		tmp.add(new Serviteur("Light Maintenance",1, PATH_LIGHT_MAINTENANCE, DESCR_LIGHT_MAINTENANCE, 1, 1, 1, 0));
		tmp.add(new Serviteur("Light Maintenance",1, PATH_LIGHT_MAINTENANCE, DESCR_LIGHT_MAINTENANCE, 1, 1, 1, 0));
		tmp.add(new Serviteur("Light Maintenance",1, PATH_LIGHT_MAINTENANCE, DESCR_LIGHT_MAINTENANCE, 1, 1, 1, 0));
		Collections.shuffle(tmp);
		return tmp;
	}
	

}
