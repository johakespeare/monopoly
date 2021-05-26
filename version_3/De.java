public class De {
    private int nbFaces;
    private int resultat;
    /**
     * Constructeur de dé.
     * @param Int nbFaces - Nombre de face que possède le dé.
     */
    public De (int nbFaces){

        this.nbFaces = nbFaces;
        this.resultat = 0;
    }
    /**
     * Lance le dé et enregistre le résultat.
     */
    public void lancer(){

        this.resultat = 1 + (int)(Math.random() * ((nbFaces - 1) + 1));
    }
    /**
     * Retourne le résultat du dernier lancement de dé.
     * @return Int resultat - résultat du dernier lancement de dé.
     */
    public int getResultat(){
        return this.resultat;
    }









}
