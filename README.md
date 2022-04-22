# Wild_Fire_Simu

Version 9.3
- Dans la classe Vent :
   - Méthode Rotation_Matrice_Horaire() -> Rotation_Matrice_AntiHoraire()
   - Méthode Rotation_Matrice_AntiHoraire() -> Rotation_Matrice_Horaire()
        - Résolution du problème de rotation de matrice sur interface graphique
- Dans la classe Terrain :
   - Dans la méthode Affec_Vege() :
        - Argument feature_size : float -> int
- Dans la classe Fenetre :
    - dimension panel syncro avec la grille du terrain
    - Ajout Attribut Vent, Terrain et DemarrageOK
    - Méthode run() :
        - ajout de terrain et wind en argument
    - DemarrerActionPerformed() :
        - Ajout de condition de click : un click possible
    - GeneTerrainActionPerformed() : 
        - Création du terrain
        - Initialisation du vent
        - Création du pannel d'affichage de la simu
        - Condition de click pour le lancement
- Dans la classe Grille() :
    - Modifications mineurs et d'intégrité du code
- Dans la classe grillePanel :
    - Modifications mineurs et d'intégrité du code

Version 9.2
- Dans la classe Terrain :
   - Dans la méthode getBooleenRandomDouble() et getBooleenRandom() :
        - Resolution du probleme de propagation du feu : ajout de "if(Proba != 0.0){...}" 

Version 9.1
- Dans la classe Terrain : 
   - Dans la méthode Affec_Vege() :
        - Resolution du problème de generation de terrain : argument "int feature_size" -> "float feature_size"
   - Dans la méthode Depart_Feu() :
        - Resolution des départs sur cases non inflammable : suppression du if(...){...} -> boucle while(this.Grille_Terrain[x][y].getVegetation() == false){}
   - Dans la méthode CreaTableau() :
        - Utilisation this.Grille_Terrain + getter et setter  

Version 9.0
- Création du package graphique :	
   - Ajout de la JFrame Fenetre
   - Ajout de la classe Grille
   - Ajout de la JPanel grillePanel

Version 8.0
- Création de la classe OpenSimplexNoise
- Dans la classe Terrain ;
    - Dans la méthode Affec_Vege() :
        - Implementation du bruit de perlin pour faire la génération du terrain
        - Version avec graine de génération et sans graine de génération
    - Suppresion de la méthode Vegetation
    - Ajout de la méthode Convertisseur()

Version 7.0
- Dans la classe Terrain :
    - Dans la méthode Propa_Feu() : 
        - Ajout d'un ligne : "Position_Y = j-4;" -> Correction de la mauvaise propagation du feu
- Dans la classe Vent : 
    - Ajout des méthodes :
        - Rotation_Matrice_AntiHoraire
        - Rotation_Matrice_Horaire
        - Rotation_Matrice_180
    - Dans la classe Repartition_Vent :
        - Correction des coordonnées des Repartition de vent 
        - Prise en charge du system de rotation de matrice pour les directions du vent

Version 6.1
- Dans la classe Terrain :
    - Dans la méthode Propa_Feu()  :
        - Correction de problème d'indentation -> Mauvaise propagation
        - Problème de gestion des erreurs et compteurs -> Comportement des cases brûlées chaud pas bonne
    - Dans la méthode Iteration() :
        - Ajout de condition pour une case qui s'enflamme -> cases non inflammable qui s'enflamme  
        - Modification de la comparaison du niveau de combustion : " == " => ".equalsIgnoreCase()"
	

Version 6.0
- RECOMPILATION DU CODE EN ENTIER 
!!! VERSION DU CODE FONCTIONNEL !!!

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
