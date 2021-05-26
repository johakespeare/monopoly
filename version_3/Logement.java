import java.util.ArrayList;

public class Logement {

	private String nom;
	private float ratioLoyer;
	private float ratioAchat;
	private float ratioRevente;
	public static ArrayList<Logement> logements;
	
    //----------------------------------------------CONSTRUCTEUR------------------------------------------------------//

	/**
	 * Constructeur de logement.
	 * @param String nom - Nom du type du logement.
	 * @param Float ratioLoyer -  Ratio du prix initial qui définit le prix du loyer.
	 * @param Float ratioAchat - Ratio du prix initial qui définit le prix d'achat du logement.
	 * @param Float ratioRevente - Ratio du prix initial qui définit le prix de revente de ce logement.
	 */
	public Logement(String nom, float ratioLoyer,float ratioAchat,float ratioRevente){
		this.nom = nom;
		this.ratioLoyer = ratioLoyer;
		this.ratioAchat = ratioAchat;
		this.ratioRevente = ratioRevente;
	}
	/**
	 * Constructeur de logement
	 * @param Logement log - Logement depuis lequel on veut effectuer une duplication.
	 */
	public Logement(Logement log){
		this.nom = log.getNom();
		this.ratioLoyer = log.getRatioLoyer();
		this.ratioAchat = log.getRatioAchat();
	}
	
    //-------------------------------------------------GETTERS--------------------------------------------------------//
	/**
	 * Retourne le nom du logement
	 * @return String nom - Nom du logement.
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * Retourne le ratio du loyer.
	 * @return Float ratioLoyer - Ratio du loyer.
	 */
	public float getRatioLoyer() {
		return ratioLoyer;
	}
	/**
	 * Retourne le ratio d'achat.
	 * @return Float ratioAchat - Ratio d'achat.
	 */
	public float getRatioAchat() {
		return ratioAchat;
	}
	/**
	 * Retourne le ratio de revente
	 * @return Float ratioRevente - Ratio de revente.
	 */
	public float getRatioRevente() {
		return ratioRevente;
	}
	
    //------------------------------------------------METHODES--------------------------------------------------------//
	/**
	 *  Définit un ensemble de logement constructibles sur les propriétés.
	 */
	public static void creerLogements(){
		logements = new ArrayList<Logement>();
		logements.add(new Logement("Maison",0.25f,0.5f,0.5f));
		logements.add(new Logement("Villa",0.40f,0.60f,0.60f));
		logements.add(new Logement("Hotel",0.75f,1.25f,0.85f));
		
	}
}
