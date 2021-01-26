package etape3 ;

import outils.* ;
import solvers.* ;


/** classe pour realiser l'etape 3 du projet (suite tache 2) */
public class Etape3
{

    // tests
    // ////////////////////////////////////////////
    /** methode de TESTS pour Etape3
    * @param args parametre non utilise
    */
    public static void main(String[] args)
    {
                                   
        // tests sur Etape 3
        // ///////////////////
        // cas 1 : 10 villes de 0 à 9
        GrapheDeLieux tg = GrapheDeLieux.loadGraph("../Data/town10.txt",true) ;
        UneSolution tsp = new UneSolution(tg) ;
        System.out.println("======== Solver 1 pour 10 villes de 0 a 9 : \n");
        // appel du solver 1
        // ...                                  
        System.out.println("======== Solver 2 pour 10 villes de 0 a 9 : \n");
        // appel du solver 2
        // ...                                  
                                   
        // ///////////////////
        // cas 2 : 26 villes de 0 à 25
        tg = GrapheDeLieux.loadGraph("../Data/town30.txt",true) ;
        tsp = new UneSolution(tg) ;
        System.out.println("======== Solver 1 pour 26 villes de 0 a 25 : \n");
        // appel du solver 1
        // ...                                  
        System.out.println("======== Solver 2 pour 26 villes de 0 a 25 : \n");
        // appel du solver 2
        // ...                                  
                                   
                                   
        // ///////////////////
        // cas 3 : 150 villes 
        tg = GrapheDeLieux.loadGraph("../Data/town150.txt",true) ;
        tsp = new UneSolution(tg) ;
        System.out.println("======== Solver 1 pour 150 villes : \n");
        // appel du solver 1
        // ...                                  
        System.out.println("======== Solver 2 pour 150 villes : \n");
        // appel du solver 2
        // ...                                  
                                   
                                   
        // ///////////////////
        // cas 4 : 1000 villes 
        tg = GrapheDeLieux.loadGraph("../Data/town1000.txt",true) ;
        tsp = new UneSolution(tg) ;
        System.out.println("======== Solver 1 pour 1000 villes : \n");
        // appel du solver 1
        // ...                                  
        System.out.println("======== Solver 2 pour 1000 villes : \n");
        // appel du solver 2
        // ...                                  
    }
}
