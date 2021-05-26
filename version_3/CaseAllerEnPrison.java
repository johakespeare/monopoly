public class CaseAllerEnPrison extends Case {

    //------------------------------------------------METHODES--------------------------------------------------------//
    @Override
    /**
     * Effet de la case AllerEnPrison.
     */
    public void effet(Joueur joueur) {
        emprisonner(joueur);
    }
    /**
     * Envoie le joueur en prison.
     * @param Joueur joueur - Joueur qui est envoyé en prison.
     */
    public void emprisonner(Joueur joueur){
        joueur.setEnPrison(true,1);

    }
    @Override
    /**
     * Retourne la description de la case AllerEnPrison.
     * @return String description - Description de la case AllerEnPrison.
     */
    public String toString() {
        return "Case 'Aller en prison', le joueur va en prison !";
    }
}
