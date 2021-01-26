package etape2 ;

import java.util.List;
import java.util.Map;

import outils.* ;

/** Classe pour definir un etat pour le cas 3 de la tache 2
*/
public class EtatCas3 implements Etat {

    // attributs
    // A COMPLETER
    // //////////////////////////////////////////////
    GrapheDeLieux tg;

    // constructeurs
    // A ECRIRE/COMPLETER
    // //////////////////////////////////////////////
    /** constructeur d'un etat a partir du graphe representant le monde
    * @param tg graphe representant le monde
    */
    public EtatCas3(GrapheDeLieux tg) {
        this.tg = tg;
    }

    /** constructeur d'un etat a partir du graphe representant le monde
    * et du lieu de depart
    * @param tg graphe representant le monde
    * @param lieuDepart numero du lieu de depart
    */
    public EtatCas3(GrapheDeLieux tg, int lieuDepart) {
        this.tg = tg;
    }

    // methodes de l'interface Etat
    // //////////////////////////////////////////////
    /** methode detectant si l'etat est une solution
    * @return true si l'etat courant est une solution, false sinon
    */
    public boolean estSolution() {
	// A ECRIRE et MODIFIER le return en consequence
        return false ;
    }

    /** methode permettant de recuperer la liste des etats successeurs de l'etat courant
    * @return liste des etats successeurs de l'etat courant
    */
    public List<Etat> successeurs() {
	// A ECRIRE et MODIFIER le return en consequence
        return null ;
    }

    /** methode permettant de recuperer l'heuristique de l'etat courant 
    * @return heuristique de l'etat courant
    */
    public double h() {      
	// A ECRIRE et MODIFIER le return en consequence
        return 0 ;
    }

    /** methode permettant de recuperer le cout du passage de l'etat courant à l'etat e
    * @param e un etat
    * @return cout du passage de l'etat courant à l'etat e
    */
    public double k(Etat e) {
	// A ECRIRE et MODIFIER le return en consequence
        return 0 ;
    }

    /** methode permettant d'afficher le chamin qui a mene a l'etat courant en utilisant la map des peres
    * @param pere map donnant pour chaque etat, son pere 
    */
    public void displayPath(Map<Etat, Etat> pere) {
	// A ECRIRE
    }

    // methodes de l'interface Comparable
    // //////////////////////////////////////////////
    /** methode de comparaison de l'etat courant avec l'objet o
    * @param o l'objet avec lequel on compare
    * @return un entier qui donne le resultat de la comparaison 
    * (0 si egaux, negatif si inferieur, positif si superieur)
    */
    public int compareTo(Object o) {
	// A ECRIRE et MODIFIER le return en consequence
        return 0 ;
    }

    // methodes pour pouvoir utiliser cet objet dans des listes et des map
    // //////////////////////////////////////////////
    /** methode permettant de recuperer le code de hachage de l'etat courant
    *  pour une utilisation dans des tables de hachage
    * @return code de hachage
    */
    public int hashCode() {
	// A ECRIRE et MODIFIER le return en consequence
        return 0 ;
    }

    /** methode de comparaison de l'etat courant avec l'objet o
    * @param o l'objet avec lequel on compare
    * @return true si l'etat courant et o sont egaux, false sinon
    */
    public boolean equals(Object o) {
	// A ECRIRE et MODIFIER le return en consequence
        return false ;
    }
    

    // methode pour affichage futur (heritee d'Object)
    // //////////////////////////////////////////////
    /** methode mettant l'etat courant sous la forme d'une 
    * chaine de caracteres en prevision d'un futur affichage
    * @return representation de l'etat courant sour la forme d'une 
    *         chaine de caracteres
    */
    public String toString() {
	// A ECRIRE et MODIFIER le return en consequence
        return null ;
    }

}

