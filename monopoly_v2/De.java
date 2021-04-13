public class De {
    private int nbFaces;
    private int resultat;

    public De (int nbFaces){

        this.nbFaces = nbFaces;
        this.resultat = 0;
    }

    public void lancer(){

        this.resultat = 1 + (int)(Math.random() * ((nbFaces - 1) + 1));
    }

    public int getResultat(){
        return this.resultat;
    }









}
