-- Création de la table Joueur (Player)
CREATE TABLE `joueur` (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `pseudo` VARCHAR(255) NOT NULL
);

-- Création de la table Partie (Game)
CREATE TABLE `partie` (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `code` VARCHAR(255) UNIQUE NOT NULL
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
    `idPartie` INT NOT NULL,
    `role` VARCHAR(50) NOT NULL,
    `score` INT DEFAULT 0,
    FOREIGN KEY (`idJoueur`) REFERENCES `joueur`(`id`),
    FOREIGN KEY (`idPartie`) REFERENCES `partie`(`id`)
);

-- Création de la table Grille (Grid)
CREATE TABLE `grille` (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `idPartie` INT NOT NULL,
    `idMot` INT NOT NULL,
    `couleur` VARCHAR(50) NOT NULL,
    FOREIGN KEY (`idPartie`) REFERENCES `partie`(`id`),
    FOREIGN KEY (`idMot`) REFERENCES `mot`(`id`),
    UNIQUE (`idPartie`, `idMot`) -- Mot unique part grille dans une partie
);




-- CREATE TABLE `partie`(
--     `id` INT NOT NULL AUTO_INCREMENT,
--     `code` INT NOT NULL,
--     `score` INT NOT NULL,
--     `id_carte` INT NOT NULL,
--     PRIMARY KEY(`id`)
-- );
    
-- CREATE TABLE `participer`(
--     `id` INT NOT NULL AUTO_INCREMENT,
--     `id_partie` INT NOT NULL,
--     `id_role` INT NOT NULL,
--     PRIMARY KEY(`id`)
-- );

-- CREATE TABLE `role`(
--     `id` INT NOT NULL AUTO_INCREMENT,
--     `nom` VARCHAR(45) NOT NULL,
--     PRIMARY KEY(`id`)
-- );

-- CREATE TABLE `posseder`(
--     `id` INT NOT NULL AUTO_INCREMENT,
--     `id_partie` INT NOT NULL,
--     `id_type` INT NOT NULL,
--     `id_dictionnaire` INT NOT NULL,
--     PRIMARY KEY(`id`)
-- );

-- CREATE TABLE `couleur`(
--     `id` INT NOT NULL AUTO_INCREMENT,
--     `nom` VARCHAR(5) NOT NULL,
--     PRIMARY KEY(`id`)
-- );

-- CREATE TABLE `mot`(
--     `id` INT NOT NULL AUTO_INCREMENT,
--     `nom` VARCHAR(128) NOT NULL,
--     PRIMARY KEY(`id`)
-- );

-- ALTER TABLE `partie`
-- ADD CONSTRAINT `fk_partie_carte`
-- FOREIGN KEY (`id_carte`)
-- REFERENCES `carte` (`id`)
-- ON UPDATE NO ACTION
-- ON DELETE NO ACTION;

-- ALTER TABLE `posseder`
-- ADD CONSTRAINT `fk_carte_type`
-- FOREIGN KEY (`id_type`)
-- REFERENCES `type` (`id`)
-- ON UPDATE NO ACTION
-- ON DELETE NO ACTION;

-- ALTER TABLE `posseder`
-- ADD CONSTRAINT `fk_carte_dictionnaire`
-- FOREIGN KEY (`id_dictionnaire`)
-- REFERENCES `dictionnaire` (`id`)
-- ON UPDATE NO ACTION
-- ON DELETE NO ACTION;

-- ALTER TABLE `participer`
-- ADD CONSTRAINT `fk_participer_role`
-- FOREIGN KEY (`id_role`)
-- REFERENCES `role` (`id`)
-- ON UPDATE NO ACTION
-- ON DELETE NO ACTION;

-- ALTER TABLE `participer`
-- ADD CONSTRAINT `fk_participer_partie`
-- FOREIGN KEY (`id_partie`)
-- REFERENCES `partie` (`id`)
-- ON UPDATE NO ACTION
-- ON DELETE NO ACTION;

-- INSERT INTO `mot` (mot) VALUES ('Agent'), ('Baleine'), ('Carotte'), ('Dent'), ('Église'), ('Fantôme'), ('Gâteau'), ('Hérisson'), ('Igloo'), ('Jungle'),
-- ('Ketchup'), ('Lampe'), ('Miroir'), ('Navire'), ('Océan'), ('Plume'), ('Quiche'), ('Rivière'), ('Savane'), ('Temple'), ('Univers'), ('Volcan'), ('Wagon'), ('Xylophone'), ('Yacht'), ('Zèbre'), ('Avion'), ('Bateau'), ('Chien'), ('Diamant'), ('Éléphant'), ('Fusée'), ('Garde'), ('Hôpital'), ('Île'), ('Jardin'), ('Kangourou'), ('Lion'), ('Magicien'), ('Neige'), ('Olive'), ('Pyramide'), ('Quête'), ('Robot'), ('Sorcier'), ('Tigre'), ('Usine'), ('Vaisseau'), ('Whisky'), ('Yacht'), ('Zénith'), ('Ananas'), ('Baguette'), ('Château'), ('Dragon'), ('Éclair'), ('Forêt'), ('Grenouille'), ('Hippopotame'), ('Insecte'), ('Javelot'), ('Koala'), ('Lune'), ('Moustique'), ('Nuit'), ('Or'), ('Pomme'), ('Quasar'), ('Rêve'), ('Soleil'), ('Tortue'), ('Uniforme'), ('Vague'), ('Wapiti'), ('Xylophage'), ('Yaourt'), ('Zeppelin'), ('Aventure'), ('Baleine'), ('Clown'), ('Désert'), ('Étoile'), ('Foudre'), ('Glacier'), ('Haricot'), ('Immeuble'), ('Jouet'), ('Klaxon'), ('Lanterne'), ('Microbe'), ('Nectar'), ('Orange'), ('Pirate'), ('Quarantaine'), ('Rubis'), ('Singe'), ('Trésor'), ('Unicorne'), ('Vampire'), ('Wagon-lit');

-- INSERT INTO `role` (nom) VALUES ('Maître des mots'), ('Maître des intuitions');

-- INSERT INTO `couleur` (nom) VALUES ("bleu"), ("gris"), ("noir");

-- -- DROP TABLE IF EXISTS `partie`;
-- -- DROP TABLE IF EXISTS `joueur`;
-- -- DROP TABLE IF EXISTS `role`;
-- -- DROP TABLE IF EXISTS `carte`;
-- -- DROP TABLE IF EXISTS `type`;
-- -- DROP TABLE IF EXISTS `dictionnaire`;