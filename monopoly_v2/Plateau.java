import java.util.ArrayList;

public class Plateau {
    private static final int NB_CASES = 4;

    private ArrayList<Case> cases ;
    private CaseDepart dep;
    private CaseImpots imp;
    private CaseChance chance;
    private CaseAllerEnPrison allerPrison;
    private CasePrison prison;

    public Plateau (){

        initCases();
    }

    private void initCases(){
        this.cases = new ArrayList<Case>();

        this.dep = new CaseDepart();
        this.imp = new CaseImpots();
        this.chance= new CaseChance();
        this.prison = new CasePrison();
        this.allerPrison = new CaseAllerEnPrison();

        ajouterCase(dep);
        ajouterCase(imp);
        ajouterCase(chance);
        ajouterCase(allerPrison);
        ajouterCase(prison);

    }

    private void ajouterCase(Case c){
        if(cases.size()<NB_CASES ) {
            this.cases.add(c);
        }
    }

    public void effet(int i, Joueur j){
        cases.get(i).effet(j);
        System.out.println(cases.get(i).toString());

    }

    public int getNbCases(){
        return NB_CASES;
    }


}
