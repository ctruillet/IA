package etape4 ;

import java.lang.* ;
import java.util.* ;
import outils.* ;
import solvers.* ;

public class Etape4Choco {

   public static void main (String [] args) {   
        ChocoSolverVerine solverVerine;
        System.out.println("\n====== TEST de ChocoSolverVerine ====") ;
        System.out.println("=============================") ;
        
        // TEST 1 : town10.txt
        GrapheDeLieux tg = GrapheDeLieux.loadGraph("../Data/town10.txt",true) ;
             
        System.out.println("\nTest sur town10 (on attend 3 couleurs) :") ;
        solverVerine = new ChocoSolverVerine(tg);
        solverVerine.solve();


		   
        // TEST 4 : flat20_3_0.col
        tg = GrapheDeLieux.loadGraph("../Data/pb-etape1/flat20_3_0.col",false) ;
        System.out.println("Test sur flat20_3_0.col (on attend 3 couleurs) :") ;
        solverVerine = new ChocoSolverVerine(tg);
        solverVerine.solve();


    
        // TEST 7 : jean.col
        tg = GrapheDeLieux.loadGraph("../Data/pb-etape1/jean.col",false) ;
        System.out.println("Test sur jean.col (on attend 10 couleurs) :") ;
        solverVerine = new ChocoSolverVerine(tg);
        solverVerine.solve();
		
	}
}

