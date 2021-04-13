public class CaseAllerEnPrison extends Case {

    //------------------------------------------------METHODES--------------------------------------------------------//


    @Override
    public void effet(Joueur joueur) {
        emprisonner(joueur);
    }

    public void emprisonner(Joueur joueur){
        joueur.setEnPrison(true,1);

    }

    @Override
    public String toString() {
        return "CaseAllerEnPrison{}";
    }
}
