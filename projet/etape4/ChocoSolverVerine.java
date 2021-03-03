package etape4;

import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solution;
import org.chocosolver.solver.variables.IntVar;
import outils.* ;

public class ChocoSolverVerine {
    //Attributs
    protected Model model;
    protected GrapheDeLieux tg;
    protected int nbCouleur;

    //Constructeur
    public ChocoSolverVerine(GrapheDeLieux tg){
        this.tg = tg;
        this.model = new Model("Choco SolverVerine");
        this.nbCouleur = tg.getNbSommets();
    }

    public ChocoSolverVerine(GrapheDeLieux tg, int nbCouleur){
        this(tg);
        this.nbCouleur = nbCouleur;
    }

    //Méthodes
    public void solve(){
        // Liste des couleurs avec pour indice les sommets
        IntVar couleurs []= new IntVar[tg.getNbSommets()];


        // CONTRAINTES

        // Nombre min et max de couleurs differentes (1 - NbSommets)
        for (int i=0; i<tg.getNbSommets(); i++){
            couleurs[i] = model.intVar("sommet"+i,1,this.nbCouleur);
        }

        // Les sommets adjacents doivent avoir des couleurs différentes
        for (int sommet:tg.getSommets()) {
            for (int adj:tg.getAdjacents(sommet)) {
                //On ajoute la contrainte au modele
                model.arithm(couleurs[sommet], "!=", couleurs[adj]).post();
            }
        }

        // Pécupération du nombre de couleurs (valeurs la plus élevée du tableau)
        IntVar nbColor = model.intVar(1, tg.getNbSommets());
        //On ajoute la contrainte au modele
        model.max(nbColor, couleurs).post();

        //model.setObjective(Model.MINIMIZE, nbColor);

        // résolution du problème en minimisant le nombre de couleurs
        Solution sol = model.getSolver().findOptimalSolution(nbColor, Model.MINIMIZE);

        //affichage de la meilleure solution
        if (sol == null){
            System.out.print("\tPas de solution");
        }else{
            System.out.print("\tSolution : " + sol.getIntVal(nbColor) + " couleurs\n | ");
            for(int i=0; i<tg.getNbSommets(); i++){
                System.out.print(i + " = " + sol.getIntVal(couleurs[i]) + " | ");
            }
        }
        System.out.println("\n");
    }

}