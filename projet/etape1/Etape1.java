package etape1 ;

import java.lang.* ;
import java.util.* ;
import outils.* ;
import solvers.* ;


/** classe pour realiser l'etape 1 du projet (tache 1) */
public class Etape1 {

    // attributs
    // //////////////////////////////////////////////
    /** le graphe representant le monde */
    private GrapheDeLieux g ;
    /** la base de clauses representant le probleme */
    private ArrayList<ArrayList<Integer>> base ; // maj par majBase
    /** le nb de variables utilisees pour representer le probleme */
    private int nbVariables ; // maj par majBase
    
    // constructeur
    // //////////////////////////////////////////////
    /** constructeur
    * @param fn le nom du fichier dans lequel sont donnes les sommets et les aretes
    * @param format le format permet de distinguer entre les differents types de fichier 
    * (pour ceux contenant des poids et des coordonnees, format est true ;
    *  pour les autres, format est false)
    */
    public Etape1 (String fn, boolean format) {
        g = GrapheDeLieux.loadGraph(fn,format);
        base = new ArrayList<ArrayList<Integer>>() ;        
    }
    
    // methodes
    // //////////////////////////////////////////////
    /** methode de maj de la base de clauses et du nb de variables en fonction du pb traite 
    * @param x parametre servant pour definir la base qui representera le probleme 
    */
    public void majBase(int x) {
        this.base.clear();
        this.nbVariables = 0;

        ArrayList<Integer> sommets = this.g.getSommets();        
        for(int sommet : sommets) {
            int s = sommet * x + 1;
            ArrayList<Integer> adjacents = this.g.getAdjacents(sommet);
            for(int adjacent : adjacents) {
                int ad = adjacent * x + 1;
                for(int couleur = 0 ; couleur < x ; couleur++) {
                    // couleurs adjacente diférente
                    this.base.add(new ArrayList<Integer>(Arrays.asList(-(s + couleur), -(ad + couleur))));
                }
            }
            ArrayList<Integer> couleurs = new ArrayList<Integer>();
            for(int couleur = 0 ; couleur < x ; couleur++) {
                // un sommet = 1 seule couleur
                this.base.add(new ArrayList<Integer>(Arrays.asList(-(s + couleur) , -(s + ((couleur + 1) % x)))));
                couleurs.add(s+couleur);
            }
            // un sommet a une couleur
            
            this.base.add(couleurs);
            this.nbVariables = s + x - 1;
        }       
    }
    
    /** methode d'appel du solver sur la base de clauses representant le pb traite
    * @return true si la base de clauses representant le probleme est satisfiable, 
    *         false sinon
    */
    public boolean execSolver() {
        return SolverSAT.isSAT(base,nbVariables) ;
    }

    /** affichage de la base de clauses representant le probleme */
    public void affBase(){
        System.out.println("Base de clause utilise "+nbVariables+
                           " variables et contient les clauses suivantes : ") ;
        for (ArrayList<Integer> cl : base) {
            System.out.println(cl) ;
        }
    }
    
    // le main
    // //////////////////////////////////////////////
    /** methode de TESTS pour Etape1 
    * @param args parametre non utilise
    */
    public static void main(String [] args) {
    
        // TEST 1 : town10.txt avec 3 couleurs
        System.out.println("Test sur fichier town10.txt avec 3 couleurs") ;
        Etape1 e = new Etape1("../Data/town10.txt",true) ;
        e.majBase(3) ;
        e.affBase() ;
        System.out.println("Resultat obtenu (on attend true) :"+e.execSolver()) ;
        System.out.println("");
        
    
        // TEST 2 : town10.txt avec 2 couleurs
        System.out.println("Test sur fichier town10.txt avec 2 couleurs") ;
        e.majBase(2) ;
        e.affBase() ;
        System.out.println("Resultat obtenu (on attend false) :"+e.execSolver()) ;
        System.out.println("");

    
        // TEST 3 : town10.txt avec 4 couleurs
        System.out.println("Test sur fichier town10.txt avec 4 couleurs") ;
        e.majBase(4) ;
        e.affBase() ;
        System.out.println("Resultat obtenu (on attend true) :"+e.execSolver()) ;
        System.out.println("");  

    
        // TEST 4 : flat20_3_0.col avec 4 couleurs
        System.out.println("Test sur fichier flat20_3_0.col avec 4 couleurs") ;
        e = new Etape1("../Data/pb-etape1/flat20_3_0.col",false) ;
        e.majBase(4) ;
        //e.affBase() ;
        System.out.println("Resultat obtenu (on attend true) :"+e.execSolver()) ;
        System.out.println("");
    
        
        // TEST 5 : flat20_3_0.col avec 3 couleurs
        System.out.println("Test sur fichier flat20_3_0.col avec 3 couleurs") ;
        e.majBase(3) ;
        //e.affBase() ;
        System.out.println("Resultat obtenu (on attend true) :"+e.execSolver()) ;
        System.out.println("");
    
        
        // TEST 6 : flat20_3_0.col avec 2 couleurs
        System.out.println("Test sur fichier flat20_3_0.col avec 2 couleurs") ;
        e.majBase(2) ;
        //e.affBase() ;
        System.out.println("Resultat obtenu (on attend false) :"+e.execSolver()) ;
        System.out.println("");
        
    
        // TEST 7 : jean.col avec 10 couleurs
        System.out.println("Test sur fichier jean.col avec 10 couleurs") ;
        e = new Etape1("../Data/pb-etape1/jean.col",false) ;
        e.majBase(10) ;
        //e.affBase() ;
        System.out.println("Resultat obtenu (on attend true) :"+e.execSolver()) ;
        System.out.println("");

    
        // TEST 9 : jean.col avec 9 couleurs
        System.out.println("Test sur fichier jean.col avec 9 couleurs") ;
        e.majBase(9) ;
        //e.affBase() ;
        System.out.println("Resultat obtenu (on attend false) :"+e.execSolver()) ;
        System.out.println("");

    
        // TEST 8 : jean.col avec 3 couleurs
        System.out.println("Test sur fichier jean.col avec 3 couleurs") ;
        e.majBase(3) ;
        //e.affBase() ;
        System.out.println("Resultat obtenu (on attend false) :"+e.execSolver()) ;
        System.out.println("");
        
    }
}
