package etape2 ;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import outils.* ;

/** Classe pour definir un etat pour le cas 1 de la tache 2
*/
public class EtatCas1 implements Etat {

    // attributs
    // A COMPLETER
    // //////////////////////////////////////////////
    /** le graphe representant le monde */
    GrapheDeLieux tg;
    int etat = 0;
    int lieuDepart = 0;
    int lieuArrivee;

    // constructeurs
    // A ECRIRE/COMPLETER
    // //////////////////////////////////////////////
    /** constructeur d'un etat a partir du graphe representant le monde
    * @param tg graphe representant le monde
    */
    public EtatCas1(GrapheDeLieux tg) {
        this.tg = tg;
        this.lieuArrivee = this.tg.getNbSommets() -1;
    }

    /** constructeur d'un etat a partir du graphe representant le monde
    * et du lieu de depart
    * @param tg graphe representant le monde
    * @param lieuDepart numero du lieu de depart
    */
    public EtatCas1(GrapheDeLieux tg, int lieuDepart) {
        this.tg = tg;
        this.etat = lieuDepart;
        this.lieuDepart = lieuDepart;
        this.lieuArrivee = this.tg.getNbSommets() -1;
    }

    /** constructeur d'un etat a partir du graphe representant le monde,
    * et des lieux de depart et d'arrivee
    * @param tg graphe representant le monde
    * @param lieuDepart numero du lieu de depart
    * @param lieuArrivee numero du lieu d'arrivee
    */
    public EtatCas1(GrapheDeLieux tg, int lieuDepart, int lieuArrivee) {
        this.tg = tg;
        this.etat = lieuDepart;
        this.lieuDepart = lieuDepart;
        this.lieuArrivee = lieuArrivee;
    }

    public int getEtat(){
        return this.etat;
    }

    // methodes de l'interface Etat
    // //////////////////////////////////////////////
    /** methode detectant si l'etat est une solution
    * @return true si l'etat courant est une solution, false sinon
    */
    public boolean estSolution() {
        return this.etat == this.lieuArrivee;
    }

    /** methode permettant de recuperer la liste des etats successeurs de l'etat courant
    * @return liste des etats successeurs de l'etat courant
    */
    public List<Etat> successeurs() {
        List<Etat> liste = new ArrayList<>();

        for ( int adj : this.tg.getAdjacents(this.etat)){
            liste.add(new EtatCas1(this.tg, adj, this.lieuArrivee));
        }

        return liste;
    }

    /** methode permettant de recuperer l'heuristique de l'etat courant 
    * @return heuristique de l'etat courant
    */
    public double h() {      
	// A ECRIRE et MODIFIER le return en consequence
        return this.tg.dist(this.etat, this.lieuArrivee) ;
    }

    /** methode permettant de recuperer le cout du passage de l'etat courant à l'etat e
    * @param e un etat
    * @return cout du passage de l'etat courant à l'etat e
    */
    public double k(Etat e) {
        return this.tg.getCoutArete(this.etat, ((EtatCas1)e).getEtat());
    }

    /** methode permettant d'afficher le chamin qui a mene a l'etat courant en utilisant la map des peres
    * @param pere map donnant pour chaque etat, son pere 
    */
    public void displayPath(Map<Etat, Etat> pere) {
        Etat e = this;
        String s = "";
        int lieu = (int) ((EtatCas1)e).getEtat();
        s += lieu;
        while(pere.containsKey(e)) {
            e = pere.get(e);
            if(e == null) break;
            lieu = (int) ((EtatCas1)e).getEtat();
            s = ((EtatCas1)e).getEtat() + "-" + s;            
        }
        
        System.out.println(s);
    }

    // methodes de l'interface Comparable
    // //////////////////////////////////////////////
    /** methode de comparaison de l'etat courant avec l'objet o
    * @param o l'objet avec lequel on compare
    * @return un entier qui donne le resultat de la comparaison 
    * (0 si egaux, negatif si inferieur, positif si superieur)
    */
    public int compareTo(Object o) {
        if(this.equals(o))
            return 0;

        return (this.tg.dist(this.etat, this.lieuArrivee) <= this.tg.dist(((EtatCas1)o).getEtat(),((EtatCas1)o).lieuArrivee)?-1:1);
    }

    // methodes pour pouvoir utiliser cet objet dans des listes et des map
    // //////////////////////////////////////////////
    /** methode permettant de recuperer le code de hachage de l'etat courant
    *  pour une utilisation dans des tables de hachage
    * @return code de hachage
    */
    public int hashCode() {
        return this.tg.hashCode() + 1*this.etat + 2*this.lieuDepart + 3*this.lieuArrivee;
    }

    /** methode de comparaison de l'etat courant avec l'objet o
    * @param o l'objet avec lequel on compare
    * @return true si l'etat courant et o sont egaux, false sinon
    */
    public boolean equals(Object o) {
        if (! (o instanceof EtatCas1)){
            return false;
        }

        return this.hashCode() == ((EtatCas1)o).hashCode();

    }
    

    // methode pour affichage futur (heritee d'Object)
    // //////////////////////////////////////////////
    /** methode mettant l'etat courant sous la forme d'une 
    * chaine de caracteres en prevision d'un futur affichage
    * @return representation de l'etat courant sour la forme d'une 
    *         chaine de caracteres
    */
    public String toString() {
        String s = "";
        s = "Etat courant : " + this.etat;
        return s ;
    }

}

