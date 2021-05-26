public class De {
    private int nbFaces;
    private int resultat;
    /**
     * Constructeur de d�.
     * @param Int nbFaces - Nombre de face que poss�de le d�.
     */
    public De (int nbFaces){

        this.nbFaces = nbFaces;
        this.resultat = 0;
    }
    /**
     * Lance le d� et enregistre le r�sultat.
     */
    public void lancer(){

        this.resultat = 1 + (int)(Math.random() * ((nbFaces - 1) + 1));
    }
    /**
     * Retourne le r�sultat du dernier lancement de d�.
     * @return Int resultat - r�sultat du dernier lancement de d�.
     */
    public int getResultat(){
        return this.resultat;
    }









}
