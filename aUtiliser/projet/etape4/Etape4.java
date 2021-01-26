package etape4 ;

import java.lang.* ;
import java.util.* ;
import outils.* ;
import solvers.* ;

public class Etape4 {

   public static void main (String [] args) {
   
        System.out.println("\n====== TEST de SolverCSP ====") ;
        System.out.println("=============================") ;
        
        // TEST 1 : town10.txt avec 3 couleurs
        GrapheDeLieux tg = GrapheDeLieux.loadGraph("../Data/town10.txt",true) ;
		System.out.println("\nTest sur town10 avec 3 couleurs (on attend OK) :") ;
        // choisir ici un algo et l'executer 
		
        // TEST 2 : town10.txt avec 2 couleurs
		System.out.println("\nTest sur town10 avec 2 couleurs (on attend NOK) :") ;
        // choisir ici un algo et l'executer 
		
        // TEST 3 : town10.txt avec 4 couleurs
		System.out.println("\nTest sur town10 avec 4 couleurs (on attend OK) :") ;
        // choisir ici un algo et l'executer 


		   
        // TEST 4 : flat20_3_0.col avec 4 couleurs
        tg = GrapheDeLieux.loadGraph("../Data/pb-etape1/flat20_3_0.col",false) ;
        System.out.println("Test sur flat20_3_0.col avec 4 couleurs (on attend OK) :") ;
        // choisir ici un algo et l'executer 
    
        // TEST 5 : flat20_3_0.col avec 3 couleurs
        System.out.println("Test sur flat20_3_0.col avec 3 couleurs (on attend OK) :") ;
        // choisir ici un algo et l'executer 
    
        // TEST 6 : flat20_3_0.col avec 2 couleurs
        System.out.println("Test sur flat20_3_0.col avec 2 couleurs (on attend NOK) :") ;
        // choisir ici un algo et l'executer 


    
        // TEST 7 : jean.col avec 10 couleurs
        tg = GrapheDeLieux.loadGraph("../Data/pb-etape1/jean.col",false) ;
        System.out.println("Test sur jean.col avec 10 couleurs (on attend OK) :") ;
        // choisir ici un algo et l'executer 
    
        // TEST 9 : jean.col avec 3 couleurs
        System.out.println("Test sur jean.col avec 3 couleurs (on attend NOK) :") ;
        // choisir ici un algo et l'executer 
    
        // TEST 8 : jean.col avec 9 couleurs
        System.out.println("Test sur jean.col avec 9 couleurs (on attend NOK) :") ;
        // choisir ici un algo et l'executer 
		
		
	}
}

