-- Création de la table Joueur (Player)
CREATE TABLE `joueur` (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `pseudo` VARCHAR(255) NOT NULL
);

-- Création de la table Partie (Game)
CREATE TABLE `partie` (
    `id` VARCHAR(7) PRIMARY KEY
);

-- Création de la table Mot (Word)
CREATE TABLE `mot` (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `texte` VARCHAR(255) UNIQUE NOT NULL
);

-- Création de la table Participer (Participation)
CREATE TABLE `participer` (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `idJoueur` INT NOT NULL,
    `idPartie` VARCHAR(7) NOT NULL,
    `role` VARCHAR(50) NOT NULL,
    `score` INT DEFAULT 0,
    FOREIGN KEY (`idJoueur`) REFERENCES `joueur`(`id`),
    FOREIGN KEY (`idPartie`) REFERENCES `partie`(`id`)
);

-- Création de la table Grille (Grid)
CREATE TABLE `grille` (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `idPartie` VARCHAR(7) NOT NULL,
    `idMot` INT NOT NULL,
    `couleur` VARCHAR(50) NOT NULL,
    FOREIGN KEY (`idPartie`) REFERENCES `partie`(`id`),
    FOREIGN KEY (`idMot`) REFERENCES `mot`(`id`)
    -- UNIQUE (`idPartie`, `idMot`) -- Mot unique part grille dans une partie
);

-- List généré par CHAT-GPT
INSERT INTO `mot` (`texte`) VALUES ('Pomme'), ('Soleil'), ('Montagne'), ('Océan'), ('Forêt'), ('Étoile'), ('Rivière'), 
('Fleur'), ('Neige'), ('Plage'), ('Cascade'), ('Papillon'), ('Nuage'), ('Volcan'), ('Tempête'), ('Arc-en-ciel'), 
('Savane'), ('Désert'), ('Grotte'), ('Planète'), ('Lune'), ('Comète'), ('Galaxie'), ('Univers'), ('Métropole'), 
('Village'), ('Pyramide'), ('Temple'), ('Forteresse'), ('Château'), ('Palais'), ('Tour'), ('Moulin'), ('Port'), 
('Parc'), ('Jardin'), ('Statue'), ('Fontaine'), ('Labyrinthe'), ('Phare'), ('Aquarium'), ('Zoo'), ('Musée'), 
('Bibliothèque'), ('Théâtre'), ('Stade'), ('Cirque'), ('Carnaval'), ('Foire'), ('Festival');


-- --  -- Jeu de donnée pour tester -- -- --
INSERT INTO `partie` (`id`) VALUES ("#2c5b8s");
INSERT INTO `joueur` (`pseudo`) VALUES ("gab"), ("art");
INSERT INTO `participer` (`idJoueur`, `idPartie`, `role`, `score`) VALUES (1, "#2c5b8s", 'MDM', 12);
INSERT INTO `participer` (`idJoueur`, `idPartie`, `role`, `score`) VALUES (2, "#2c5b8s", 'MDI', 12);

-- JOINTURE
SELECT `partie`.`code`, `mot`.`texte`, `grille`.`couleur` FROM `grille` 
INNER JOIN `partie` ON `partie`.`id` = `grille`.`idPartie` 
INNER JOIN `mot` ON `mot`.`id` = `grille`.`idMot`;

SELECT `partie`.`code`, `joueur`.`pseudo`, `participer`.`role`, `participer`.`score` FROM `participer`
INNER JOIN `partie` ON `partie`.`id` = `participer`.`idPartie` 
INNER JOIN `joueur` ON `joueur`.`id` = `participer`.`idJoueur`;

SELECT `partie`.`code`, `mot`.`texte`, `grille`.`couleur` FROM `grille` INNER JOIN `partie` ON `partie`.`id` = `grille`.`idPartie` 
INNER JOIN `partie` ON `partie`.`id` = `grille`.`idPartie` 
INNER JOIN `mot` ON `mot`.`id` = `grille`.`idMot`
WHERE `partie`.`code` = 1;

-- --  -- DROP TABLES -- -- --
-- DROP TABLE IF EXISTS `participer`;
-- DROP TABLE IF EXISTS `partie`;
-- DROP TABLE IF EXISTS `joueur`;
-- DROP TABLE IF EXISTS `grille`;
-- DROP TABLE IF EXISTS `mot`;