

public class CaseDepart extends Case implements Bonus{

    int somme = 200;

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
        return "CaseDepart{" +
                "somme=" + somme +
                '}';
    }
}
