package etape3 ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random ;

import outils.* ;

/** Classe pour definir une solution pour le cas 3 de la tache 2
*/
public class UneSolution implements Solution {

  
    // attributs
    // A COMPLETER
    // //////////////////////////////////////////////
    /** le graphe representant le monde */
    GrapheDeLieux tg;
    
    // constructeurs
    // A ECRIRE/COMPLETER
    // //////////////////////////////////////////////
    /** constructeur d'une solution a partir du graphe representant le monde
    * @param tg graphe representant le monde
    */
    public UneSolution(GrapheDeLieux tg) {
        // A ECRIRE
    }
    // A COMPLETER AVEC d'AUTRES CONSTRUCTEURS si necessaire


    // methodes de l'interface Solution
    // //////////////////////////////////////////////
    /** methode recuperant la liste des voisins de la solution courante
    * @return liste des voisins de la solution courante
    */
    public List<Solution> lesVoisins() {
        // A ECRIRE et MAJ la valeur retournee
    	return null ;
    }

    /** methode recuperant un voisin de la solution courante
    * @return voisin de la solution courante
    */
    public List<Solution> unVoisin() {
        // A ECRIRE et MAJ la valeur retournee
    	return null ;
    }

    /** methode recuperant la valeur de la solution courante
    * @return valeur de la solution courante
    */
    public double eval() {
        // A ECRIRE et MAJ la valeur retournee
        return 0;
    }
    
    /** methode generant aleatoirement une nouvelle solution 
    * a partir de la solution courante
    * @return nouvelle solution generee aleatoirement a partir de la solution courante
    */
    public Solution nelleSolution() {
    	// A ECRIRE et MAJ la valeur retournee
    	return null ;
    }
    
    /** methode affichant la solution courante comme un chemin dans le graphe
    */
    public void displayPath() {
        // A ECRIRE
    }


    // methodes pour pouvoir utiliser cet objet dans des listes et des map
    // //////////////////////////////////////////////
    /** methode permettant de recuperer le code de hachage de la solution courante
    *  pour une utilisation dans des tables de hachage
    * @return code de hachage
    */
    public int hashCode() {
	// A ECRIRE et MODIFIER le return en consequence
        return 0 ;
    }

    /** methode de comparaison de la solution courante avec l'objet o
    * @param o l'objet avec lequel on compare
    * @return true si la solution courante et o sont egaux, false sinon
    */
    public boolean equals(Object o) {
	// A ECRIRE et MODIFIER le return en consequence
        return false ;
    }
    

    // methode pour affichage futur (heritee d'Object)
    // //////////////////////////////////////////////
    /** methode mettant la solution courante sous la forme d'une 
    * chaine de caracteres en prevision d'un futur affichage
    * @return representation de la solution courante sour la forme d'une 
    *         chaine de caracteres
    */
    public String toString() {
	// A ECRIRE et MODIFIER le return en consequence
        return null ;
    }

}
