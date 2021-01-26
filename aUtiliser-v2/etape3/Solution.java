package etape3 ;

import java.util.List;
import java.util.Map;

/**
 * interface pour representer une solution dans un espace de solutions
 */
public interface Solution {

    /** methode recuperant la liste des voisins de la solution courante
    * @return liste des voisins de la solution courante
    */
    public List<Solution> lesVoisins();

    /** methode recuperant un voisin de la solution courante
    * @return voisin de la solution courante
    */
    public List<Solution> unVoisin();

    /** methode recuperant la valeur de la solution courante
    * @return valeur de la solution courante
    */
    public double eval();

    /** methode affichant la solution courante comme un chemin dans le graphe
    */
    public void displayPath();

    /** methode generant aleatoirement une nouvelle solution 
    * a partir de la solution courante
    * @return nouvelle solution generee aleatoirement a partir de la solution courante
    */
    public Solution nelleSolution() ;

}
