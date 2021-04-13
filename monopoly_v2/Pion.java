public class Pion {

    private String couleur;
    private int position;
    private int nbCasesMax;

        public Pion(String couleur, Plateau p){
            this.position = 0;
            this.nbCasesMax = p.getNbCases();

        }

        public int deplacer(int nbCases){
            this.position = (this.position + nbCases) % this.nbCasesMax;
            return this.position;
        }

        public int getPosition(){
            return this.position;
        }






}


