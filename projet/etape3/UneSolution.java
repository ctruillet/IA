package etape3 ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random ;
import java.util.ArrayList;
import java.util.Collections;

import outils.* ;

/** Classe pour definir une solution pour le cas 3 de la tache 2
*/
public class UneSolution implements Solution {
    // attributs
    // //////////////////////////////////////////////
    /** le graphe representant le monde */
    GrapheDeLieux tg;
    ArrayList<Integer> cycle = new ArrayList<>();
    
    // constructeurs
    // A ECRIRE/COMPLETER
    // //////////////////////////////////////////////
    /** constructeur d'une solution a partir du graphe representant le monde
    * @param tg graphe representant le monde
    */
    public UneSolution(GrapheDeLieux tg) {
        this.tg = tg;

        this.cycle.clear();
        for(int i = 0; i<tg.getNbSommets(); i++){
            this.cycle.add(i);
        }
        this.cycle.add(0);
    }

    public UneSolution(GrapheDeLieux tg, ArrayList<Integer> cycle){
        this.tg = tg;
        this.cycle = cycle;
    }

    // methodes de l'interface Solution
    // //////////////////////////////////////////////
    /** methode recuperant la liste des voisins de la solution courante
    * @return liste des voisins de la solution courante
    */
    public List<Solution> lesVoisins() {
        // A ECRIRE et MAJ la valeur retournee
        List<Solution> listeSol = new ArrayList<Solution>() ;
        for (int i = 0; i < this.tg.getNbSommets(); i++) {
            Solution solution = nelleSolution();
            if(!this.cycle.contains(solution)) {
                listeSol.add(solution);
            }
            else{//retour en arrière
                i--;
            }
        }
        return listeSol ;
    }

    /** methode recuperant un voisin de la solution courante
    * @return voisin de la solution courante
    */
    public List<Solution> unVoisin() {
        // A ECRIRE et MAJ la valeur retournee
        List<Solution> listeSol = new ArrayList<Solution>();
        Solution solution = this.nelleSolution();
        listeSol.add(solution);
        
        return listeSol ;
    }

    /** methode recuperant la valeur de la solution courante
    * @return valeur de la solution courante
    */
    public double eval() {
        double poid = 0;
        if(this.cycle.size() <= 1){
            return poid;
        }

        for (int i=1; i<this.cycle.size(); i++){
            poid += this.tg.dist(this.cycle.get(i-1),this.cycle.get(i));
        }
        return poid;
    }
    
    /** methode generant aleatoirement une nouvelle solution 
    * a partir de la solution courante
    * @return nouvelle solution generee aleatoirement a partir de la solution courante
    */
    public Solution nelleSolution() {
        int random1=0, random2=0;
        ArrayList<Integer> newCycle = new ArrayList<Integer>(this.cycle);

        do{
            random1 = new Random().nextInt(newCycle.size());
            random2 = new Random().nextInt(newCycle.size());

        }while(random1 == 0 || random2 == 0 || random1 == random2 || random1 == newCycle.size() -1 || random2 == newCycle.size() -1);

        Collections.swap(newCycle, random1, random2);

    	return new UneSolution(this.tg, newCycle);
    }
    
    /** methode affichant la solution courante comme un chemin dans le graphe
    */
    public void displayPath() {
        System.out.println("PATH : " + this.cycle);
        
    }


    // methodes pour pouvoir utiliser cet objet dans des listes et des map
    // //////////////////////////////////////////////
    /** methode permettant de recuperer le code de hachage de la solution courante
    *  pour une utilisation dans des tables de hachage
    * @return code de hachage
    */
    public int hashCode() {
        return this.tg.hashCode() + 4 * this.cycle.hashCode();
    }

    /** methode de comparaison de la solution courante avec l'objet o
    * @param o l'objet avec lequel on compare
    * @return true si la solution courante et o sont egaux, false sinon
    */
    public boolean equals(Object o) {
        if (! (o instanceof UneSolution))
            return false;
        return (this.hashCode() == ((UneSolution)o).hashCode());    
    }
    

    // methode pour affichage futur (heritee d'Object)
    // //////////////////////////////////////////////
    /** methode mettant la solution courante sous la forme d'une 
    * chaine de caracteres en prevision d'un futur affichage
    * @return representation de la solution courante sour la forme d'une 
    *         chaine de caracteres
    */
    public String toString() {
        return this.cycle.toString() + "\n" + "Cout Total : " + this.eval() + "\n";
    }

}
