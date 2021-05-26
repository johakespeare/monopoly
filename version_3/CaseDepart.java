

public class CaseDepart extends Case implements Bonus{

    int somme = 200;

    //------------------------------------------------METHODES--------------------------------------------------------//


    @Override
    /**
     * Ajoute un montant d'argent à un joueur.
     * @param Joueur joueur - Joueur qui doit recevoir un montant d'argent.
     */
    public void donnerArgent(Joueur joueur) {
        joueur.gagnerArgent(this.somme);
    }

    @Override
    /**
     * Effet de la case Départ.
     */
    public void effet(Joueur joueur) {
        donnerArgent(joueur);
    }

    @Override
    /**
     * Retourne la description de la case départ.
     * @return String description - Description de la case départ.
     */
    public String toString() {
        return "Case départ, somme gagnée: "
        		+ somme ;
    }
}
