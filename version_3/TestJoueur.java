

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TestJoueur {

	@Test
	/**
	 * Fonction de test de Junit5, vérifie spécifiquement les fonctions liées aux conditions d'echec d'un joueur.
	 */
	void test() {
		Plateau plateau = new Plateau();
		Pion pion = new Pion("Rouge",plateau);
		Joueur joueur = new Joueur(pion);

		//On part du principe que le montant initial d'argent n'a pas été modifié, et sera toujours égal à 800
		assertEquals(600,joueur.getArgent());
		assertEquals(false,joueur.getAPerdu());
		
		joueur.perdreArgent(200);
		
		assertEquals(400,joueur.getArgent());
		
		joueur.perdreArgent(700);
		
		assertEquals(-300,joueur.getArgent());
		assertEquals(true,joueur.getAPerdu());
	
	}

}
