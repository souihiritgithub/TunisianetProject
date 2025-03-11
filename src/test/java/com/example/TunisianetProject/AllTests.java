package com.example.TunisianetProject;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AjouterUnProduitPanier.class, Connexion.class, ConnexionMailIncorrect.class,
		ConnexionPassIncorrect.class, FiltrerPrix.class, RechercheCategorieInformatique.class,
		RechercheMotCaractereSpeciaux.class, RechercheMotCleInexistant.class, RechercheMotCleValide.class})
public class AllTests {

}
 