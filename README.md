# Wild_Fire_Simu

Version 5.1
!!! CODE NON FONCTIONNEL !!!
- Dans la classe Terrain :
   - Dans la méthode Depart_Feu() :
      - Mise en place des getters et setters
   - Dans la méthode Propa_Feu() :
      - Mise en place des getters et setters
   - Dans la classe Iteration()
      - Mise en place des getters et setters

Version 5.0
!!! CODE NON FONCTIONNEL !!!
- Dans la classe Case : 
   - Changement des attributs de public à private
   - Ajout de getter et de setter pour chaque attribut
- Dans la classe Vent : 
   - Changement des attributs de public à private
   - Ajout de getter et de setter pour chaque attribut
- Dans la classe Terrain :
   - Changement des attributs de public à private
   - Ajout de getter et de setter pour chaque attribut

Version 4.3
- Dans la classe Case :
   - Suppression de toutes les méthodes Getter et Setter de chaque attribut
- Dans la classe Terrain :
   - Correction de la méthode Iteration()
   - Méthode Propa_Feu() fonctionnelle

Version 4.2
- Dans la classe Case :
   - public String Brulure_Case = "";
- Dans la classe Vent :
   - Ajout de l'attribut Repartition
   - La méthode Repartion_Vent ne retourne plus une grille de répartition mais l'affecte à l'attribut Repartition

Version 4.1
- Dans la classe Case :
   - Ajout de l'attribut Brulure_Case ("" = pas bruler, "A" = Enflammé, "B" = Brulé chaud, "C" = Cendre/Brulé Froid)
- Dans la classe Terrain :
   - Dans Depart_Feu() ajout de this.Grille_Terrain[x][y].Brulure_Case = "A";
   - getBooleenRandomFloat() est changé en getBooleenRandomDouble() pour obtenir un double à la place d'un float
   - Condamne() est changé en Iteration() (avec modification du code pour la prise en compte tous les changement d'état des cases à réaliser)
   - Modification de la méthode Propa_Feu()

Version 4.0
- Dans la classe Terrain :
   - Ajout de la méthode Propa_Feu()

 Version 3.5 :
 - Dans la classe Terrain :
   - ajout de la méthode Condamne, elle augmente les combustion de 1, et annule les vegetation des cases condamnées
   
 Version 3.4 :
 - Dans la classe Terrain :
  - ajout d'une méthode copiée/collée de getBooleenRandom, + modification de cette nouvelle méthode pour qu'elle puisse prendre en argument un float 

Version 3.3 :
- Dans le main :
  - Ajout des anciens tests issues du projet de Mathis (conversion, départ feu...)
- Dans la classe Terrain : 
  - Modification de la méthode conversion (avec la non prise en compte des majuscules)  
 
Version 3.2 :
- Dans la classe Vent :
  - Ajout de la méthode Repartion_Vent()

Version 3.1 :
- Dans la classe Terrain :
  - Modification CreaTableau() et Affec_Vege() pour prendre en compte les Exceptions

Version 3.0 :
- Dans la classe Terrain :
  - Création de la méthode propagation du feu (vent nul)
- Dans la classe Case :
  - ajout de l'attribut condamne dans la classe Case
  
Version 2.0 :
- Import de la methode Depart_Feu()

Version 1.0 :
- Ajout class ErreurExe (méthode de gestion des erreurs du programme)

Version 0.0 :
- Import du projet de Louis class Main
- Import du projet de Louis class Terrain
- Import du projet de Louis class Case
- Import du projet de Louis class Vent
