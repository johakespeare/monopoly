import java.util.ArrayList;

public class Partie {

    private Plateau plateau;
    private De de1;
    private De de2;
    private int nbJoueurs;
    private ArrayList<Joueur> joueurs;
    private int joueurCourant;

    private static final int NB_CASES = 10;
    private static final int NB_TOURS = 2;
    private int compteurTour = 0;


    public Partie(int nbJoueurs) {
        this.de1 = new De(6);
        this.de2 = new De(6);
        Plateau plateau = new Plateau(NB_CASES);
        this.nbJoueurs = nbJoueurs;
        joueurs = new ArrayList<Joueur>();
        for(int i=0; i<nbJoueurs;i++){
            Pion p = new Pion("red",NB_CASES);
            Joueur j = new Joueur(p);
            joueurs.add(j);
        }
    }

    //pour savoir qui joue en premier
    public int init(){
        int premierJoueur= 0;
        int plusGrand = 0;
        for(int i=0;i<nbJoueurs;i++){
            int somme = this.de1.lancer() + this.de2.lancer();
            if(somme > plusGrand){
                plusGrand = somme;
                premierJoueur = i;
            }
        }
        return premierJoueur;
    }


    public void lancerPartie(){
        boolean enJeu = true;
        this.joueurCourant = init();

        while(enJeu){
            afficherJeu();
            int somme = this.de1.lancer() + this.de2.lancer();
            joueurs.get(this.joueurCourant).getPion().deplacer(somme);

            if(compteurTour/nbJoueurs >=NB_TOURS){
                enJeu = false;
            }
            compteurTour++;
            joueurSuivant();

        }
    }

    private void joueurSuivant(){

        if(joueurCourant + 1 >= nbJoueurs ){
            joueurCourant = 0;
        }else{
            joueurCourant +=1;
        }

    }

    private void afficherJeu(){
        for(int i=0;i<this.nbJoueurs;i++){
            System.out.println("Joueur n° "+ (i+1) + " position " + joueurs.get(i).getPion().getPosition());
        }
    }

















}
