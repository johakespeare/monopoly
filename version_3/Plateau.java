import java.util.ArrayList;

public class Plateau {
    private static final int NB_CASES = 11;

    private ArrayList<Case> cases ;
    private CaseDepart dep;
    private CaseImpots imp;
    private CaseChance chance;
    private CaseAllerEnPrison allerPrison;
    private CasePrison prison;
    /**
     * Constructeur de Plateau.
     */
    public Plateau (){

        initCases();
    }
    /**
     *  Fait appel à l'ensemble des fonctions necessaires pour initialiser toutes les cases du plateau.
     */
    private void initCases(){
        this.cases = new ArrayList<Case>();
        this.dep = new CaseDepart();
        this.imp = new CaseImpots();
        this.chance= new CaseChance();
        this.prison = new CasePrison();
        this.allerPrison = new CaseAllerEnPrison();
        
        ajouterCasePropriete();

        ajouterCase(dep);
        ajouterCase(imp);
        ajouterCase(chance);
        ajouterCase(allerPrison);
        ajouterCase(prison);

    }
    /**
     *   Initialise toutes les cases du type Propriete.
     */
    private void ajouterCasePropriete(){
    	 ajouterCase(new CasePropriete("Rue du petit bois","Vert",60));
    	 ajouterCase(new CasePropriete("Quartiers jolis","Vert",80));
    	 ajouterCase(new CasePropriete("Grande avenue","Rouge",120));
         ajouterCase(chance);
    	 ajouterCase(new CasePropriete("Rue Lafayette","Rouge",140));
    	 ajouterCase(new CasePropriete("Rue de la paix","bleu",400));
	}
    /**
     *  Ajoute une case si celle ci ne fait pas en sorte que le plateau ne devienne trop grand.
     * @param Case c - La case à rajouter au plateau
     */
	private void ajouterCase(Case c){
        if(cases.size()<NB_CASES ) {
            this.cases.add(c);
        }
    }
	/**
	 * Affiche et execute l'effet qu'aura une case sur un joueur.
	 * @param Int i - Index de la case dont on veut l'effet
	 * @param Joueur j - Joueur qui recevra l'effet de la case
	 */
    public void effet(int i, Joueur j){
        System.out.println(cases.get(i).toString());
        cases.get(i).effet(j);

    }
    /**
     *  Retourne le nombre maximal de case qu'un plateau peut avoir.
     * @return Int NB_CASES - Le nombre de case maximal que peut posseder un plateau
     */
    public int getNbCases(){
        return NB_CASES;
    }


}
