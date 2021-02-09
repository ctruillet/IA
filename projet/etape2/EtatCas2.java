package etape2 ;

import java.util.List;
import java.util.Map;

import java.util.ArrayList;

import outils.* ;

/** Classe pour definir un etat pour le cas 2 de la tache 2
*/
public class EtatCas2 implements Etat {

    // attributs
    // A COMPLETER
    // //////////////////////////////////////////////
    GrapheDeLieux tg;
    int etat = 0;
    int lieuDepart = 0;
    ArrayList<Integer> listeSommetsVisite = new ArrayList<>();

    // constructeurs
    // A ECRIRE/COMPLETER
    // //////////////////////////////////////////////
    /** constructeur d'un etat a partir du graphe representant le monde
    * @param tg graphe representant le monde
    */
    public EtatCas2(GrapheDeLieux tg) {
        this.tg = tg;
    }

    /** constructeur d'un etat a partir du graphe representant le monde
    * et du lieu de depart
    * @param tg graphe representant le monde
    * @param lieuDepart numero du lieu de depart
    */
    public EtatCas2(GrapheDeLieux tg, int lieuDepart) {
        this.tg = tg;
        this.lieuDepart = lieuDepart;
        this.etat = lieuDepart;
        this.listeSommetsVisite.add(this.lieuDepart);
        //System.out.println("DEPART " + this.etat);
        //System.out.println("\t visite" + this.listeSommetsVisite);
    }

    public EtatCas2(GrapheDeLieux tg, int lieuDepart, int etat, ArrayList<Integer> listeSommetsVisite) {
        this.tg = tg;
        this.lieuDepart = lieuDepart;
        this.etat = etat;
        this.listeSommetsVisite = new ArrayList<>(listeSommetsVisite);
        this.listeSommetsVisite.add(this.etat);
        //System.out.println("\t visite " + this.listeSommetsVisite);
    }

    // methodes de l'interface Etat
    // //////////////////////////////////////////////
    /** methode detectant si l'etat est une solution
    * @return true si l'etat courant est une solution, false sinon
    */
    public boolean estSolution() {
        return (this.etat == this.lieuDepart && this.listeSommetsVisite.size() == this.tg.getNbSommets()+1);
    }

    /** methode permettant de recuperer la liste des etats successeurs de l'etat courant
    * @return liste des etats successeurs de l'etat courant
    */

    //MARCHE APS
    public List<Etat> successeurs() {
        //System.out.println("\t=== SUCCESSEURS de " + this.etat + " ===");
        List<Etat> liste = new ArrayList<>();

        for (int adj : this.tg.getAdjacents(this.etat)){
            //System.out.println("\t\t" + adj + "-" + !this.listeSommetsVisite.contains(adj));
            if(adj==lieuDepart){
                if(this.listeSommetsVisite.size() == this.tg.getNbSommets()){
                    liste.add(new EtatCas2(this.tg, this.lieuDepart,adj, this.listeSommetsVisite));
                }
            }else{
                if(!this.listeSommetsVisite.contains(adj))
                    liste.add(new EtatCas2(this.tg, this.lieuDepart,adj, this.listeSommetsVisite));
            }
        }

        //System.out.println("\t adj " + liste);

        return liste;
    }

    /** methode permettant de recuperer l'heuristique de l'etat courant 
    * @return heuristique de l'etat courant
    */
    public double h() {      
        return this.tg.dist(this.etat, this.lieuDepart) ;
    }

    /** methode permettant de recuperer le cout du passage de l'etat courant à l'etat e
    * @param e un etat
    * @return cout du passage de l'etat courant à l'etat e
    */
    public double k(Etat e) {
        return this.tg.getCoutArete(this.etat, ((EtatCas2)e).getEtat());
    }

    /** methode permettant d'afficher le chamin qui a mene a l'etat courant en utilisant la map des peres
    * @param pere map donnant pour chaque etat, son pere 
    */
    public void displayPath(Map<Etat, Etat> pere) {
        Etat e = this;
        String s = "";
        int lieu = (int) ((EtatCas2)e).getEtat();
        s += lieu;
        while(pere.containsKey(e)) {
            e = pere.get(e);
            if(e == null) break;
            lieu = (int) ((EtatCas2)e).getEtat();
            s = ((EtatCas2)e).getEtat() + "-" + s;            
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

        return (this.tg.dist(this.etat, this.lieuDepart) <= this.tg.dist(((EtatCas2)o).getEtat(),((EtatCas2)o).lieuDepart)?-1:1);
    }

    // methodes pour pouvoir utiliser cet objet dans des listes et des map
    // //////////////////////////////////////////////
    /** methode permettant de recuperer le code de hachage de l'etat courant
    *  pour une utilisation dans des tables de hachage
    * @return code de hachage
    */
    public int hashCode() {
        return this.tg.hashCode() + 1*this.etat + 2*this.lieuDepart + 3*this.listeSommetsVisite.hashCode();
    }

    /** methode de comparaison de l'etat courant avec l'objet o
    * @param o l'objet avec lequel on compare
    * @return true si l'etat courant et o sont egaux, false sinon
    */
    public boolean equals(Object o) {
        if (! (o instanceof EtatCas2)){
            return false;
        }

        return this.hashCode() == ((EtatCas2)o).hashCode();

    }

    public int getEtat(){
        return this.etat;
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

