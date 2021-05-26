import java.util.ArrayList;

public class Joueur {
	private boolean aPerdu= false;
    private Pion pion;
    private int argent = 600;
    private boolean enPrison = false;
    private int tourPrison = 0;
    private ArrayList<CasePropriete> proprietes;

    //----------------------------------------------CONSTRUCTEUR------------------------------------------------------//
    /**
     * Constructeur de joueur.
     * @param Pion pion - Pion qui représente le joueur sur le plateau.
     */
    public Joueur(Pion pion){
        this.pion = pion;
        proprietes = new ArrayList<CasePropriete>();
    }

    //-------------------------------------------------GETTERS--------------------------------------------------------//
    /**
     * Retourne le pion du joueur.
     * @return Pion pion - Pion du joueur.
     */
    public Pion getPion() {
        return this.pion;
    }
    /**
     * Retourne l'argent du joueur.
     * @return Int argent - Argent du joueur.
     */
    public int getArgent() {
        return this.argent;
    }
    /**
     * Retourne l'état du joueur.
     * @return Boolean aPerdu - Etat du joueur.
     */
    public boolean getAPerdu() {
    	return aPerdu;
    }
    //-------------------------------------------------SETTERS--------------------------------------------------------//
    /**
     * Modifie l'état d'emprisonnement du joueur et définit son temps d'attente.
     * @param Boolean enPrison - Etat d'emprisonnement du joueur.
     * @param int tour - Nombre de tour à attendre en prison.
     */
    public void setEnPrison(boolean enPrison,int tour) {
        this.enPrison = enPrison;
        this.tourPrison = tour;
        System.out.println("Le joueur "+toString()+" a été enfermé en prison pour : "+tour+" tour(s)");
    }
    //------------------------------------------------METHODES--------------------------------------------------------//

    /**
     * Déplace un pion sur le plateau.
     * @param Int nbCases - Nombre de case dont le pion doit se déplacer.
     * @return Int position - Nouvelle position du pion sur le plateau.
     */
    public int deplacer(int nbCases){
        return this.pion.deplacer(nbCases);
    }
    /**
     * Ajoute une quantité d'argent au joueur.
     * @param Int somme - Quantité d'argent à rajouter au joueur.
     */
    public void gagnerArgent(int somme){
        this.argent += somme;
        System.out.println("Le joueur "+toString()+" a reçu : "+somme+" $");
    }
    /**
     * Affiche les propriétés que possède le joueur (logements non compris).
     */
    public void afficherPropriete() {
		for(int i = 0 ; i < proprietes.size(); i++){
			System.out.println("Propriété du joueur "+toString() + " N°" + i +" : "+ proprietes.get(i).toString());
		}
    }
    /**
     * Retire une quantité d'argent au joueur et lui fait perdre la partie si il n'a plus moyen de rembourser.
     * @param Int somme - Quantité d'argent à retirer.
     */
    public void perdreArgent(int somme){
    	while(!aPerdu && somme >= argent) 
    	{
    		if(somme >= argent && proprietes.size() > 0 )
    		{
    			System.out.println("Le joueur "+toString()+" doit revendre des propriétés pour pouvoir rembourser. Argent possédé = "+getArgent()+" Argent à payer = "+somme);
    			proprietes.get(0).vendre();
    		}
    		else if(somme > argent && proprietes.size() == 0){
    	        System.out.println("Le joueur "+toString()+" a perdu toutes ses propriétés et ne peut plus rembourser");
    	        aPerdu = true;
    		}
    	}
        System.out.println("Le joueur "+toString()+" a perdu un maximum de : "+somme+" $");
        this.argent-=somme;
    }
    /**
     * Retourne l'état d'emprisonnement du joueur.
     * @return Boolean enPrison - Etat d'emprisonnement du joueur.
     */
    public boolean estEnPrison(){
        if(!enPrison){
            return false;
        }
        System.out.println("Le joueur "+toString()+" est en prison ! "+tourPrison+ " tour(s) restant(s) pour pouvoir en sortir");
        this.tourPrison -=1;
        if(this.tourPrison ==0){
            this.enPrison = false;
        }
        return true;

    }
    /**
     * Retourne les caractéristiques du joueur.
     * @return String description - Description du joueur.
     */
    @Override
    public String toString(){
    	return pion.getCouleur();
    }
    /**
     * Retire une propriété précise que possède le joueur.
     * @param String nom - Nom de la propriété à retirer.
     */
	public void retirerPropriete(String nom){
		int index = -1;
		for(int i = 0 ; i< proprietes.size() ; i++){
			if(proprietes.get(i).getNom() == nom){
				index = i;
			}
		}
		if(index != -1){
			proprietes.remove(index);
		}
	}
	/**
	 * Ajoute une propriété à celle(s) que possède le joueur.
	 * @param CasePropriete cp - Propriété que le joueur gagne.
	 */
	public void ajouterPropriete(CasePropriete cp)
	{
		proprietes.add(cp);	
	}
	/**
	 * Retire une propriété du joueur de manière aléatoire .
	 * @return String str - Description de l'eventuelle propriété retirée.
	 */
	public String retirerProprieteRandom() {
		String str;
		if(proprietes.size()>0)
		{
			CasePropriete cp = proprietes.get(0);
			proprietes.remove(0);
			str = "Le joueur " + toString() + " a perdu la propriété :" + cp.toString();
		}
		else
		{
			str = "Le joueur " + toString() + " ne possède aucune propriété.";
		}
		return str;
	}
}
