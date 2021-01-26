package etape2 ;

import java.util.List;
import java.util.Map;
/**
 * interface pour representer un etat dans un espace d'etats
 */
public interface Etat extends Comparable<Object>
{
    /** methode detectant si l'etat est une solution
    * @return true si l'etat courant est une solution, false sinon
    */
    public boolean estSolution();

    /** methode permettant de recuperer la liste des etats successeurs de l'etat courant
    * @return liste des etats successeurs de l'etat courant
    */
    public List<Etat> successeurs();

    /** methode permettant de recuperer l'heuristique de l'etat courant 
    * @return heuristique de l'etat courant
    */
    public double h();

    /** methode permettant de recuperer le cout du passage de l'etat courant à l'etat e
    * @param e un etat
    * @return cout du passage de l'etat courant à l'etat e
    */
    public double k(Etat e);
    
    /** methode permettant d'afficher le chamin qui a mene a l'etat courant en utilisant la map des peres
    * @param pere map donnant pour chaque etat, son pere 
    */
    public void displayPath(Map<Etat, Etat> pere);
   
}
