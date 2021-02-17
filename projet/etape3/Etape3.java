package etape3 ;

import outils.* ;
import solvers.* ;


/** classe pour realiser l'etape 3 du projet (suite tache 2) */
public class Etape3{

    // tests
    // ////////////////////////////////////////////
    /** methode de TESTS pour Etape3
    * @param args parametre non utilise
    */
    public static void main(String[] args){
        SolverHC solverHC = new SolverHC();
        SolverTabou solverTabou = new SolverTabou();

        // tests sur Etape 3
        // ///////////////////
        // cas 1 : 10 villes de 0 à 9
        GrapheDeLieux tg = GrapheDeLieux.loadGraph("../Data/town10.txt",true) ;
        UneSolution tsp = new UneSolution(tg) ;
        System.out.println("======== Solver 1 pour 10 villes de 0 a 9 : \n");
        solverHC.hilClimbing(tsp,1);
        solverHC.hilClimbing(tsp,10);
        solverHC.hilClimbing(tsp,100);
        solverHC.hilClimbing(tsp,1000);
        
        System.out.println("======== Solver 2 pour 10 villes de 0 a 9 : \n");
        solverTabou.tabou(tsp,1); 
        solverTabou.tabou(tsp,10); 
        solverTabou.tabou(tsp,100);
        solverTabou.tabou(tsp,1000);                              
                                   
        // ///////////////////
        // cas 2 : 26 villes de 0 à 25
        tg = GrapheDeLieux.loadGraph("../Data/town30.txt",true) ;
        tsp = new UneSolution(tg) ;
        System.out.println("======== Solver 1 pour 26 villes de 0 a 25 : \n");
        solverHC.hilClimbing(tsp,1);
        solverHC.hilClimbing(tsp,10);
        solverHC.hilClimbing(tsp,100);
        solverHC.hilClimbing(tsp,1000);

        System.out.println("======== Solver 2 pour 26 villes de 0 a 25 : \n");
        solverTabou.tabou(tsp,1); 
        solverTabou.tabou(tsp,10); 
        solverTabou.tabou(tsp,100);
        solverTabou.tabou(tsp,1000);                    
                                   
                                   
        // ///////////////////
        // cas 3 : 150 villes 
        tg = GrapheDeLieux.loadGraph("../Data/town150.txt",true) ;
        tsp = new UneSolution(tg) ;
        System.out.println("======== Solver 1 pour 150 villes : \n");
        solverHC.hilClimbing(tsp,1);
        solverHC.hilClimbing(tsp,10);
        solverHC.hilClimbing(tsp,100);
        solverHC.hilClimbing(tsp,1000);

        System.out.println("======== Solver 2 pour 150 villes : \n");
        solverTabou.tabou(tsp,1); 
        solverTabou.tabou(tsp,10); 
        solverTabou.tabou(tsp,100);
        solverTabou.tabou(tsp,1000);                           
                                   
                                   
        // ///////////////////
        // cas 4 : 1000 villes 
        tg = GrapheDeLieux.loadGraph("../Data/town1000.txt",true) ;
        tsp = new UneSolution(tg) ;
        System.out.println("======== Solver 1 pour 1000 villes : \n");
        solverHC.hilClimbing(tsp,1);
        solverHC.hilClimbing(tsp,10);
        solverHC.hilClimbing(tsp,100);
        solverHC.hilClimbing(tsp,1000);

        System.out.println("======== Solver 2 pour 1000 villes : \n");
        solverTabou.tabou(tsp,1); 
        solverTabou.tabou(tsp,10); 
        solverTabou.tabou(tsp,100);
        solverTabou.tabou(tsp,1000);                            
    }
}
