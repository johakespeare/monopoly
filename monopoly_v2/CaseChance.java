public class CaseChance extends Case implements Bonus{

    int somme = 50;


    //------------------------------------------------METHODES--------------------------------------------------------//



    @Override
    public void donnerArgent(Joueur joueur) {
        joueur.gagnerArgent(this.somme);
    }


    @Override
    public void effet(Joueur joueur) {
        donnerArgent(joueur);
    }

    @Override
    public String toString() {
        return "CaseChance{" +
                "somme=" + somme +
                '}';
    }
}
