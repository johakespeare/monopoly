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
     * Retourne le nom de la propri�t�.
     * @return String Nom - Nom de la propri�t�.
     */
    public String getNom() {
    	return nom;
    }
    /**
     *  Retourne le propri�taire de la propri�t�.
     * @return Joueur propri�taire - Joueur qui poss�de la propri�t�
     */
    public Joueur getProprietaire() {
    	return proprietaire;
    }
    /**
     *  Retire le propri�taire actuel.
     */
    public void resetProprietaire() {
    	proprietaire = null;
    }
    //------------------------------------------------METHODES--------------------------------------------------------//
    /**
     * Demande au joueur de payer le loyer.
     * @param Joueur joueur - Joueur qui doit payer le loyer au propri�taire.
     */
    public void payerLeLoyer(Joueur joueur){
    	int loyer = calculerLoyer();
    	joueur.perdreArgent(loyer);
    	proprietaire.gagnerArgent(loyer);
    	System.out.println(joueur.toString() + " a pay� un loyer de " + loyer + "$ au joueur " + proprietaire.toString());
    }
    /**
     *  Analyse l'action qui doit �tre effectu�e ou propos�e au joueur.
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
     * Propose au joueur de pouvoir acheter la propri�t� si elle n'est pas d�j� possed�e.
     * @param Joueur joueur - Joueur � qui le choix d'achat est propos�.
     */
    public void acheterPropriete(Joueur joueur){
    	if(proprietaire == null){
    		if(joueur.getArgent() >= prixAchat){
    			joueur.perdreArgent(prixAchat);
    			proprietaire = joueur;
    			joueur.ajouterPropriete(this);
    			System.out.println("La propri�t� "+ nom +" a �t� achet�e par le joueur " + proprietaire.toString());
    	    }else{
    			System.out.println("La propri�t� "+ nom +" n'a pu �tre achet�e par le joueur " + joueur.toString());   	   
    	    }
    	}else{
    		System.out.println("La propri�t� "+ nom +" est poss�d�e par le joueur " + proprietaire.toString());
    	}
    }
    /**
     * Achat d'un logement sur cette propri�t�.
     * @param Logement logement - Logement dont on veut effectuer l'achat.
     */
    public void acheterLogement(Logement log){
    	int cout = ((int) (log.getRatioAchat() * prixAchat));
    	if(proprietaire != null && proprietaire.getArgent() >= cout){
    		proprietaire.perdreArgent(cout);
    		logements.add(new Logement(log));
    		System.out.println("La propri�t� "+ nom +" a pu recevoir un nouveau logement de type "+log.getNom()+" pour un co�t de "+cout+" $");
    	}else{
    		System.out.println("La propri�t� "+ nom +" n'a pas pu recevoir un nouveau logement de type "+log.getNom()+" car le joueur ne poss�de pas assez d'argent");
    	}
    }
    /**
     * Effectue la vente des logements en priorit� puis des propri�t�s pour rendre de l'argent au joueur.
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
    		System.out.println("Le joueur " + proprietaire.toString() + " a vendu un(e) " + logements.get(logements.size()-1).getNom() + " pour "+montant+" $ � "+nom);
    		logements.remove(logements.size()-1);
    		proprietaire.gagnerArgent(montant);
    	}
    }
    /**
     * Cr�er la description de cette case propri�t�.
     *  @return String description - Description de la case propri�t�.
     */
    @Override
    public String toString(){
    	String proprio = proprietaire != null ? "Joueur " + proprietaire.toString()  : "personne";
    	String desc = proprietaire != null ? "prix de loyer: " + calculerLoyer()+" $" : "prix d'achat: "+prixAchat+" $" ;
    	
        return "Case 'Propri�t�', \""
    			+ nom
    			+"\", poss�d�e par : "
    			+ proprio
    			+", "
        		+ desc ;
    }
    /**
     * Retourne la disponibilit� de la case propri�t�.
     * @return Boolean disponibilite - Disponibilit� � l'achat de la propri�t�.
     */
    public boolean estDisponible() {
    	return proprietaire == null;
    }
}