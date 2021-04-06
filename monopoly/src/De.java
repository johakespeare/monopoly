public class De {
    private int nbFaces;

    public De (int nbFaces){
        this.nbFaces = nbFaces;
    }

    public int lancer(){
        return 1 + (int)(Math.random() * ((nbFaces - 1) + 1));
    }









}
