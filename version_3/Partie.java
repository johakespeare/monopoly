import java.util.ArrayList;

public class Partie {
    private static ArrayList<String> couleurs;{
    	remplirCouleurs();
    };
    private Plateau plateau;
    private De de1;
    private De de2;
    private int nbJoueurs;
    private ArrayList<Joueur> joueurs;
    private int joueurCourant;


    private static final int NB_TOURS = 2000;
    private int compteurTour = 0;

    /**
     * Constructeur de Partie, Instancie les dés, plateau, types de logements, et joueurs de la partie.
     * @param int nbJoueurs - Nombre de joueur dans la partie
     */
    public Partie(int nbJoueurs) {
        this.de1 = new De(6);
        this.de2 = new De(6);
        this.plateau = new Plateau();
        Logement.creerLogements();
        this.nbJoueurs = nbJoueurs;
        joueurs = new ArrayList<Joueur>();
        for(int i=0; i<nbJoueurs;i++){
            Pion p = new Pion(couleurs.get(i),plateau);
            Joueur j = new Joueur(p);
            joueurs.add(j);
        }
    }

    /**
     * Choisit le joueur qui commence en effectuant un jet de dés et selectionnant celui qui a la plus haute valeur.
     * @return Int premierJoueur - Index du joueur qui commence la partie.
     */
    public int init(){
        int premierJoueur= 0;
        int plusGrand = 0;
        for(int i=0;i<nbJoueurs;i++){
            this.de1.lancer();
            this.de2.lancer();
            int somme = this.de1.getResultat() + this.de2.getResultat();
            if(somme > plusGrand){
                plusGrand = somme;
                premierJoueur = i;
            }

        }
        System.out.println("-------------------------------------------------------------------------------------------------------");
        System.out.println("                                     Initialisation de la partie                                       ");
        System.out.println("-------------------------------------------------------------------------------------------------------");

        afficherJeu();
        System.out.println("C'est le joueur " + joueurs.get(premierJoueur).toString() + " qui commence !");
        return premierJoueur;
    }

    /**
     * Démarre la boucle de jeu et effectue les actions des joueurs au tour par tour.
     */
    public void lancerPartie(){
        boolean enJeu = true;
        this.joueurCourant = init();

        while(enJeu){
            System.out.println("-------------------------------------------------------------------------------------------------------");

            System.out.println("                                          Tour N°"+ compteurTour +"                                    ");
            System.out.println("-------------------------------------------------------------------------------------------------------");

            System.out.println("C'est au joueur "+ joueurs.get(joueurCourant)+" de jouer");
            Joueur joueur = joueurs.get(this.joueurCourant);

            int somme = lancerDes();

            if(!joueur.estEnPrison()){
                int position = joueur.deplacer(somme);
                plateau.effet(position,joueur);
            }
            afficherJeu();
            joueur.afficherPropriete();
            if(compteurTour > NB_TOURS){
                enJeu = false;
            }
            compteurTour++;

            joueurSuivant();
            if(joueur.getAPerdu()){
            	joueurs.remove(joueur);
            	if(joueurs.size() == 1)
            	{
            		enJeu = false;
            	}
            }
        }
        System.out.println("-------------------------------------------------------------------------------------------------------");

        System.out.println("                                                 Fin du jeu                                            ");
        System.out.println("-------------------------------------------------------------------------------------------------------");

        System.out.println("Le joueur "+ joueurs.get(0)+" a gagné la partie");   
    }
    /**
     * Effectue un jet de dé et retourne le résultat.
     * @return Int valeur - Valeur totale du lancé des deux dés.
     */
    private int lancerDes(){
        this.de1.lancer();
        this.de2.lancer();
        return this.de1.getResultat() + this.de2.getResultat();
    }
    /**
     *  Effectue le changement de joueur actif
     */
    private void joueurSuivant(){

        if(joueurCourant + 1 >= nbJoueurs ){
            joueurCourant = 0;
        }else{
            joueurCourant += 1;
        }

    }
    /**
     *  Effectue l'affichage des caractéristiques des joueurs : nom du joueur, position, argent
     */
    private void afficherJeu(){
    	 System.out.println("");
        for(int i=0;i<this.nbJoueurs;i++) {
            System.out.println("Joueur " + joueurs.get(i) + " position " + joueurs.get(i).getPion().getPosition() + " argent " + joueurs.get(i).getArgent());
        }
    }
    /**
     * Définit l'ensemble des couleurs disponibles que peut avoir un joueur.
     */
    private static void remplirCouleurs() {
    	couleurs = new ArrayList<String>();
    	couleurs.add("Rouge");
    	couleurs.add("Bleu");
    	couleurs.add("Vert");
    	couleurs.add("Rose");
    	couleurs.add("Jaune");
	}




}
