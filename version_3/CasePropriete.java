import java.util.ArrayList;

public class CasePropriete extends Case{

	static final float RATIOLOYER = 0.10f;
	static final float RATIOPRIXREVENTE = 0.50f;
	
    private int prixAchat;
    private ArrayList<Logement> logements;
    private String couleur;
    private String nom;
    private Joueur proprietaire;
    
    //----------------------------------------------CONSTRUCTEUR------------------------------------------------------//
    /**
     * Constructeur de CasePropriete.
     * @param String nom - Nom de la propriete.
     * @param String couleur - Couleur de la famille de la propriete.
     * @param int prixAchat - Prix d'achat de la propriete.
     */
    public CasePropriete(String nom, String couleur,int prixAchat){
    	this.nom = nom;
    	this.couleur = couleur;
    	this.prixAchat = prixAchat;
        logements = new ArrayList<Logement>();
    }
    //-------------------------------------------------GETTERS--------------------------------------------------------//
    /**
     * Retourne le nom de la propriété.
     * @return String Nom - Nom de la propriété.
     */
    public String getNom() {
    	return nom;
    }
    /**
     *  Retourne le propriétaire de la propriété.
     * @return Joueur propriétaire - Joueur qui possède la propriété
     */
    public Joueur getProprietaire() {
    	return proprietaire;
    }
    /**
     *  Retire le propriétaire actuel.
     */
    public void resetProprietaire() {
    	proprietaire = null;
    }
    //------------------------------------------------METHODES--------------------------------------------------------//
    /**
     * Demande au joueur de payer le loyer.
     * @param Joueur joueur - Joueur qui doit payer le loyer au propriétaire.
     */
    public void payerLeLoyer(Joueur joueur){
    	int loyer = calculerLoyer();
    	joueur.perdreArgent(loyer);
    	proprietaire.gagnerArgent(loyer);
    	System.out.println(joueur.toString() + " a payé un loyer de " + loyer + "$ au joueur " + proprietaire.toString());
    }
    /**
     *  Analyse l'action qui doit être effectuée ou proposée au joueur.
     *  @param Joueur joueur - Joueur qui arrive sur cette case.
     */
    public void effet(Joueur joueur){
    	if(proprietaire != null && joueur != proprietaire){
        	payerLeLoyer(joueur);
    	}else if(proprietaire == null){
    		acheterPropriete(joueur);
    	}else if(proprietaire == joueur){
    		acheterLogement(Logement.logements.get(0));
    	}
    	
    }
    /**
     * Calcule le prix actuel du loyer pour cette case.
     * @return Int loyer - Montant du loyer.
     */
    public int calculerLoyer(){
    	int loyer;
    	if(logements.size() == 0){
    		loyer = (int) (prixAchat * RATIOLOYER);
    	}else{
    		loyer = 0;
    		for (Logement log : logements){ 		      
    			loyer += ((int) prixAchat * log.getRatioLoyer());
    		}
    	}
    	return loyer;
    }
    /**
     * Propose au joueur de pouvoir acheter la propriété si elle n'est pas déjà possedée.
     * @param Joueur joueur - Joueur à qui le choix d'achat est proposé.
     */
    public void acheterPropriete(Joueur joueur){
    	if(proprietaire == null){
    		if(joueur.getArgent() >= prixAchat){
    			joueur.perdreArgent(prixAchat);
    			proprietaire = joueur;
    			joueur.ajouterPropriete(this);
    			System.out.println("La propriété "+ nom +" a été achetée par le joueur " + proprietaire.toString());
    	    }else{
    			System.out.println("La propriété "+ nom +" n'a pu être achetée par le joueur " + joueur.toString());   	   
    	    }
    	}else{
    		System.out.println("La propriété "+ nom +" est possédée par le joueur " + proprietaire.toString());
    	}
    }
    /**
     * Achat d'un logement sur cette propriété.
     * @param Logement logement - Logement dont on veut effectuer l'achat.
     */
    public void acheterLogement(Logement log){
    	int cout = ((int) (log.getRatioAchat() * prixAchat));
    	if(proprietaire != null && proprietaire.getArgent() >= cout){
    		proprietaire.perdreArgent(cout);
    		logements.add(new Logement(log));
    		System.out.println("La propriété "+ nom +" a pu recevoir un nouveau logement de type "+log.getNom()+" pour un coût de "+cout+" $");
    	}else{
    		System.out.println("La propriété "+ nom +" n'a pas pu recevoir un nouveau logement de type "+log.getNom()+" car le joueur ne possède pas assez d'argent");
    	}
    }
    /**
     * Effectue la vente des logements en priorité puis des propriétés pour rendre de l'argent au joueur.
     */
    public void vendre(){
    	int montant;
    	if(logements.size() == 0){
    		montant = (int)(RATIOPRIXREVENTE * prixAchat);
    		System.out.println("Le joueur " + proprietaire.toString() + " a vendu " + nom + " pour "+montant+" $");
    		proprietaire.retirerPropriete(nom);
    		proprietaire.gagnerArgent(montant);
    		resetProprietaire();
    	}else{
    		montant = (int)(logements.get(logements.size()-1).getRatioRevente() * prixAchat);
    		System.out.println("Le joueur " + proprietaire.toString() + " a vendu un(e) " + logements.get(logements.size()-1).getNom() + " pour "+montant+" $ à "+nom);
    		logements.remove(logements.size()-1);
    		proprietaire.gagnerArgent(montant);
    	}
    }
    /**
     * Créer la description de cette case propriété.
     *  @return String description - Description de la case propriété.
     */
    @Override
    public String toString(){
    	String proprio = proprietaire != null ? "Joueur " + proprietaire.toString()  : "personne";
    	String desc = proprietaire != null ? "prix de loyer: " + calculerLoyer()+" $" : "prix d'achat: "+prixAchat+" $" ;
    	
        return "Case 'Propriété', \""
    			+ nom
    			+"\", possédée par : "
    			+ proprio
    			+", "
        		+ desc ;
    }
    /**
     * Retourne la disponibilité de la case propriété.
     * @return Boolean disponibilite - Disponibilité à l'achat de la propriété.
     */
    public boolean estDisponible() {
    	return proprietaire == null;
    }
}