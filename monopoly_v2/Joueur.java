public class Joueur {

    private Pion pion;
    private int argent = 200;
    private boolean enPrison = false;
    private int tourPrison = 0;

    //----------------------------------------------CONSTRUCTEUR------------------------------------------------------//

    public Joueur(Pion pion){
        this.pion = pion;
    }

    //-------------------------------------------------GETTERS--------------------------------------------------------//

    public Pion getPion() {
        return this.pion;
    }

    public int getArgent() {
        return this.argent;
    }


    //-------------------------------------------------SETTERS--------------------------------------------------------//

    public void setEnPrison(boolean enPrison,int tour) {
        this.enPrison = enPrison;
        this.tourPrison = tour;
    }
    //------------------------------------------------METHODES--------------------------------------------------------//


    public int deplacer(int nbCases){
        return this.pion.deplacer(nbCases);
    }


    public void gagnerArgent(int somme){
        this.argent += somme;
    }

    public void perdreArgent(int somme){
        int sous = this.argent - somme;
        if(sous>=0){
            this.argent-=somme;
        }else{
            this.argent = 0;
        }
    }

    public boolean estEnPrison(){
        if(!enPrison){
            return false;
        }
        System.out.println("ce joueur est en prison!");
        this.tourPrison -=1;
        if(this.tourPrison ==0){
            this.enPrison = false;
        }
        return true;

    }









}
