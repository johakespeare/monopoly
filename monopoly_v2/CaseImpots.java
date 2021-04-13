public class CaseImpots extends Case implements Malus{

    int somme = 200;
    //------------------------------------------------METHODES--------------------------------------------------------//


    @Override
    public void retirerArgent(Joueur joueur) {
            joueur.perdreArgent(this.somme);
    }

    public void effet(Joueur joueur){
        retirerArgent(joueur);
    }

    @Override
    public String toString() {
        return "CaseImpots{" +
                "somme=" + somme +
                '}';
    }
}



