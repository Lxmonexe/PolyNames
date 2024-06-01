# Polynames - Jeu de Société en Ligne

## Description du Projet

**Polynames** est un jeu de société en ligne conçu pour être joué à distance via un navigateur web. Chaque joueur utilise son propre navigateur pour participer aux parties, permettant ainsi de jouer avec des amis ou des partenaires éloignés.

## Règles du Jeu

### Type de Jeu

Polynames est un jeu de société en ligne. Les joueurs se connectent via leur navigateur web, ce qui permet d'organiser des parties à distance.

### Création d'une Partie

1. **Création de Partie** : Un joueur se connecte à Polynames et demande la création d'une partie.
2. **Code de Partie** : Le joueur obtient un code unique pour inviter un partenaire.
3. **Rejoindre une Partie** : Le partenaire utilise le code pour rejoindre la partie.

### Début de la Partie

- **Rôles des Joueurs** : 
  - Maître des mots : doit faire deviner les mots.
  - Maître de l'intuition : doit deviner les mots.
- **Sélection des Rôles** : Les joueurs choisissent leur rôle ou le jeu le détermine aléatoirement.
- **Grille de Mots** : 25 mots sont tirés aléatoirement et représentés dans une grille de 5x5.
  - Mots bleus : mots à faire deviner (8 mots).
  - Mots neutres : mots sans effet (15 mots).
  - Mots éliminatoires : mots qui font perdre la partie (2 mots).

### Déroulement de la Partie

1. **Indice du Maître des Mots** : Le Maître des mots propose un indice composé d'un seul mot et indique le nombre de mots (N) que cet indice pourrait représenter.
2. **Découverte des Mots** : Le Maître de l'intuition peut découvrir jusqu'à N+1 cartes, une par une.
   - **Carte grise** : Le tour se termine, et le Maître des mots doit donner un nouvel indice.
   - **Carte noire** : La partie est perdue.
   - **Carte bleue** : La partie continue, et des points sont attribués.

### Score

- **Points** : 
  - Chaque carte bleue découverte vaut des points : 1ère carte = 1 point, 2ème carte = 2 points, 3ème carte = 3 points, etc.
  - Si une carte bleue est découverte en N+1, cette carte vaut N² points.
- **Cartes Grises** : Aucune valeur en points, le tour s'arrête.
- **Cartes Noires** : La partie est perdue et le score tombe à 0.

**Exemple de Calcul de Points** :
- **1er tour** : 2 mots à trouver, une carte bleue découverte : 1 point.
- **2ème tour** : 2 mots à trouver, trois cartes bleues découvertes : 1 + 2 + 9 = 12 points.
- **Total** : L'équipe a remporté 13 points à ce stade.

# Projet Polynames - Travail à Réaliser

## Description du Projet

Ce projet consiste à développer une application web de jeu de société en ligne, Polynames. Le projet inclut la conception d'une base de données, le développement de la partie serveur de l'application en Java, et le développement de l'application web front-end.

## Travail à Réaliser

### Base de Données

1. **Analyse et Modélisation**
   - Analyser le jeu et ses règles.
   - Déterminer un modèle Entités-Associations (E-A) valide.
   - Dériver le modèle relationnel correspondant.

2. **Implémentation**
   - Implémenter la base de données sur un SGBD MariaDB/MySQL.

3. **Développement Serveur**
   - Développer en Java la partie serveur de l'application en utilisant les classes `WebServer` et `MySQLDatabase` vues en travaux dirigés (TD).
   - Créer une API permettant aux joueurs de créer et jouer une partie.
   - Assurer l'interaction entre l'application serveur et la base de données.
   - Contrôler la validité des actions demandées par les joueurs pour éviter la triche.

### Documents à Rendre

1. **Diagramme Entités-Associations**
   - Réalisé avec le logiciel draw.io.

2. **Modèle Relationnel Correspondant**

3. **Script SQL**
   - Création de la base de données.
   - Insertion des données initiales (dont un dictionnaire d'au moins 50 mots).

4. **Code Source de l’API**

### Application Web

1. **Développement Front-End**
   - Développer les différents écrans présentés en annexes.
   - Interconnecter ces écrans avec les API développées.

2. **Technologies Utilisées**
   - Langages autorisés : HTML, CSS, JavaScript (JS).

### Documents à Rendre

1. **Code Source de l’Application Web**

## Date de Rendu

- **Date limite** : 14 juin 2024 à 23:59:59

---

Ce README fournit un aperçu détaillé du travail à réaliser pour le projet Polynames, ainsi que les livrables attendus et la date limite de soumission.

## Contact

Contacter notre équipe à (mailto:gabin_blanchet@etu.u-bourgogne.fr) et (mailto:arthur_albert@etu.u-bourgogne.fr).
