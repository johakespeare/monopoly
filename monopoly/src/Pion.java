public class Pion {

    private String couleur;
    private int position;
    private int nbCasesMax;

        public Pion(String couleur, int nbCasesMax){
            this.position = 0;
            this.nbCasesMax = nbCasesMax;
        }

        public void deplacer(int nbCases){
            this.position = (this.position + nbCases) % this.nbCasesMax;

        }
        public int getPosition(){
            return this.position;
        }






}


