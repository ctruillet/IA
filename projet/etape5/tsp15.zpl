param path := "tsp15.txt";

param V := read path as "2n" use 1;

#set V := { read path as "<1n>" comment "#" };
set S := {0..V-1};
set A := {<i,j> in S * S with i<j};

set P[] := powerset(S);
set K := indexset(P);

param coordX[S] := read path as "1n" comment "#";
param coordY[S] := read path as "2n" comment "#";

defnumb dist(a,b) := sqrt((coordX[a]-coordX[b])^2 + (coordY[a]-coordY[b])^2);

var x[A] binary;

minimize cost : sum <i,j> in A : dist(i,j) * x[i,j];

subto sommetsConnect : 
	forall <s> in S do
	(sum <s,j> in A : x[s,j]) + (sum <i,s> in A : x[i,s]) == 2;

subto unSeulSommet :
	forall <k> in K with card(P[k]) > 2 and card(P[k]) < (card(S)-2) do
	sum <i,j> in A with <i> in P[k] and <j> in P[k] : x[i,j] <= (card(P[k])-1);