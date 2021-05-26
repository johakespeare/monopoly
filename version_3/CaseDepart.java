

public class CaseDepart extends Case implements Bonus{

    int somme = 200;

    //------------------------------------------------METHODES--------------------------------------------------------//


    @Override
    /**
     * Ajoute un montant d'argent � un joueur.
     * @param Joueur joueur - Joueur qui doit recevoir un montant d'argent.
     */
    public void donnerArgent(Joueur joueur) {
        joueur.gagnerArgent(this.somme);
    }

    @Override
    /**
     * Effet de la case D�part.
     */
    public void effet(Joueur joueur) {
        donnerArgent(joueur);
    }

    @Override
    /**
     * Retourne la description de la case d�part.
     * @return String description - Description de la case d�part.
     */
    public String toString() {
        return "Case d�part, somme gagn�e: "
        		+ somme ;
    }
}
