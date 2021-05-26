public class Pion {

    private String couleur;
    private int position;
    private int nbCasesMax;
    	/**
    	 * Constructeur de Pion.
    	 * @param String couleur - Couleur du pion
    	 * @param Plateau p - Plateau auquel est associé le pion
    	 */
        public Pion(String couleur, Plateau p){
        	this.couleur = couleur;
            this.position = 0;
            this.nbCasesMax = p.getNbCases();
        }
        /**
         * Déplace le pion sur le plateau d'un nombre fixé de case.
         * @param Int nbCases - Nombres de cases dont doit se déplacer le pion
         * @return Int position - La position du pion sur le plateau
         */
        public int deplacer(int nbCases){
            this.position = (this.position + nbCases) % this.nbCasesMax;
            return this.position;
        }
        /**
         * Retourne la position actuelle du pion.
         * @return Int position - Position actuelle du pion sur le plateau
         */
        public int getPosition(){
            return this.position;
        }
        /**
         * Retourne la couleur du pion.
         * @return String couleur - La couleur du pion
         */
        public String getCouleur(){
            return couleur;
        }





}


