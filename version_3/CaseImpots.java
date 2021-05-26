public class CaseImpots extends Case implements Malus{

    int somme = 200;
    //------------------------------------------------METHODES--------------------------------------------------------//


    @Override
    /**
     * Retire une somme d'arget=nt � un joueur.
     * @param Joueur joueur - Joueur � qui on souhaite retirer de l'argent.
     */
    public void retirerArgent(Joueur joueur) {
            joueur.perdreArgent(this.somme);
    }
    /**
     * Effet de la case Impots
     */
    public void effet(Joueur joueur){
        retirerArgent(joueur);
    }

    @Override
    /**
     * Retourne la description de la Impots
     */
    public String toString() {
        return "Case 'Imp�ts', somme perdue: "
        		+ somme ;
    }
}



