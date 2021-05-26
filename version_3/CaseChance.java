import java.util.Random;

public class CaseChance extends Case implements Bonus,Malus{
	final static int CHOICE = 3;
	final static int MONEYGAINLIMIT = 250;
	final static int MONEYLOSELIMIT = 150;
	static Random rand = new Random();

    //------------------------------------------------METHODES--------------------------------------------------------//


	/**
	 *  Effet de case chance qui ajoute un montant al�atoire d'argent � un joueur.
	 *  @param Joueur joueur - Joueur qui re�oit le montant d'argent.
	 */
    public void donnerArgent(Joueur joueur) {
    	int somme = rand.nextInt(MONEYGAINLIMIT );
        joueur.gagnerArgent(somme);
        System.out.println("Gain d'argent d'un total de "+somme+" $");
    }


    @Override
    /**
     *  Effet de la case chance.
     */
    public void effet(Joueur joueur) {
        piocher(joueur);
    }

    @Override
    /**
     * Retourne la description de la case chance.
     * @return String description - Description de la case chance.
     */
    public String toString() {
        return "Case 'Chance'";
    }
    /**
     * Effet de case chance qui va faire perdre une propri�t� al�atoirement au joueur.
     * @param Joueur joueur - Joueur qui va perdre une propri�t�.
     */
	public void pertePropriete(Joueur joueur) {
		String str = joueur.retirerProprieteRandom();
		System.out.println(str);
		System.out.println("Perte d'une propri�t� al�atoire");
	}
	@Override
	/**
	 * Effet de case chance qui retire un montant al�atoire au joueur.
	 * @param Joueur joueur - Joueur qui va perdre de l'argent.
	 */
	public void retirerArgent(Joueur joueur) {
    	int somme = rand.nextInt(MONEYGAINLIMIT );
        joueur.perdreArgent(somme);
        System.out.println("Perte d'argent d'un total de "+somme+" $");	
	}
	/**
	 * Selectionne al�atoirement un effet � appliquer au joueur.
	 * @param Joueur joueur - Joueur qui re�oit l'effet.
	 */
    public void piocher(Joueur joueur) {
    	
    	int choice = rand.nextInt(CHOICE);
    	switch(choice) 
    	{
    		case 0:
    			donnerArgent(joueur);
    			break;
    		case 1:
    			retirerArgent(joueur);
    			break;
    		case 2:
    			pertePropriete(joueur);
    			break;
    	
    	}
    }
}
