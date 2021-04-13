import java.util.ArrayList;

public class Partie {

    private Plateau plateau;
    private De de1;
    private De de2;
    private int nbJoueurs;
    private ArrayList<Joueur> joueurs;
    private int joueurCourant;


    private static final int NB_TOURS = 20;
    private int compteurTour = 0;


    public Partie(int nbJoueurs) {
        this.de1 = new De(6);
        this.de2 = new De(6);
        this.plateau = new Plateau();
        this.nbJoueurs = nbJoueurs;
        joueurs = new ArrayList<Joueur>();
        for(int i=0; i<nbJoueurs;i++){
            Pion p = new Pion("red",plateau);
            Joueur j = new Joueur(p);
            joueurs.add(j);
        }
    }

    //pour savoir qui joue en premier
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
        System.out.println("c'est le joueur n°" + (premierJoueur+1) + " qui commence !");
        System.out.println("-------------------------------------------------------------------------------------------------------");
        System.out.println("                                          caseDepart                                                   ");
        System.out.println("-------------------------------------------------------------------------------------------------------");

        afficherJeu();
        return premierJoueur;
    }


    public void lancerPartie(){
        boolean enJeu = true;
        this.joueurCourant = init();

        while(enJeu){
            System.out.println("-------------------------------------------------------------------------------------------------------");

            System.out.println("                                       compteurTour"+ compteurTour +"                                 ");
            System.out.println("-------------------------------------------------------------------------------------------------------");

            System.out.println("c'est au joueur "+(joueurCourant+1)+" de jouer");
            Joueur joueur = joueurs.get(this.joueurCourant);

            int somme = lancerDes();

            if(!joueur.estEnPrison()){
                int position = joueur.deplacer(somme);
                plateau.effet(position,joueur);
            }

            afficherJeu();

            if(compteurTour > NB_TOURS){
                enJeu = false;
            }
            compteurTour++;

            joueurSuivant();

        }
    }

    private int lancerDes(){
        this.de1.lancer();
        this.de2.lancer();
        return this.de1.getResultat() + this.de2.getResultat();
    }

    private void joueurSuivant(){

        if(joueurCourant + 1 >= nbJoueurs ){
            joueurCourant = 0;
        }else{
            joueurCourant +=1;
        }

    }

    private void afficherJeu(){
        for(int i=0;i<this.nbJoueurs;i++) {
            System.out.println("Joueur n° " + (i + 1) + " position " + joueurs.get(i).getPion().getPosition() + " argent " + joueurs.get(i).getArgent());
        }
    }




}
