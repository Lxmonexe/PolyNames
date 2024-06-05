CREATE TABLE `partie`(
    `id` INT NOT NULL AUTO_INCREMENT,
    `code` INT NOT NULL,
    `score` INT NOT NULL,
    `id_joueur` INT NOT NULL,
    `id_carte` INT NOT NULL,
    PRIMARY KEY(`id`)
);
    
CREATE TABLE `joueur`(
    `id` INT NOT NULL AUTO_INCREMENT,
    `id_role` INT NOT NULL,
    PRIMARY KEY(`id`)
);

CREATE TABLE `role`(
    `id` INT NOT NULL AUTO_INCREMENT,
    `nom` VARCHAR(45) NOT NULL,
    PRIMARY KEY(`id`)
);

CREATE TABLE `carte`(
    `id` INT NOT NULL AUTO_INCREMENT,
    `mot` VARCHAR(45) NOT NULL,
    `id_type` INT NOT NULL,
    PRIMARY KEY(`id`)
);

CREATE TABLE `type`(
    `id` INT NOT NULL AUTO_INCREMENT,
    `couleur` VARCHAR(45) NOT NULL,
    `nombre` INT NOT NULL,
    PRIMARY KEY(`id`)
);

CREATE TABLE `dictionnaire`(
    `id` INT NOT NULL AUTO_INCREMENT,
    `mot` VARCHAR(128) NOT NULL,
    PRIMARY KEY(`id`)
);

ALTER TABLE `partie`
ADD CONSTRAINT "FK_partie_joueur"
FOREIGN KEY (`id_joueur`)
REFERENCES `joueur` (`id`)
ON UPDATE NO ACTION
ON DELETE NO ACTION;

ALTER TABLE `partie`
ADD CONSTRAINT "FK_partie_carte"
FOREIGN KEY (`id_carte`)
REFERENCES `carte` (`id`)
ON UPDATE NO ACTION
ON DELETE NO ACTION;

ALTER TABLE `carte`
ADD CONSTRAINT "FK_carte_type"
FOREIGN KEY (`id_type`)
REFERENCES `type` (`id`)
ON UPDATE NO ACTION
ON DELETE NO ACTION;

ALTER TABLE `carte`
ADD CONSTRAINT "FK_carte_dictionnaire"
FOREIGN KEY (`id_dictionnaire`)
REFERENCES `dictionnaire` (`id`)
ON UPDATE NO ACTION
ON DELETE NO ACTION;

ALTER TABLE `joueur`
ADD CONSTRAINT "FK_joueur_role"
FOREIGN KEY (`id_role`)
REFERENCES `role` (`id`)
ON UPDATE NO ACTION
ON DELETE NO ACTION;

INSERT INTO `dictionnaire` (mot) VALUES ('Agent'), ('Baleine'), ('Carotte'), ('Dent'), ('Église'), ('Fantôme'), ('Gâteau'), ('Hérisson'), ('Igloo'), ('Jungle'),
('Ketchup'), ('Lampe'), ('Miroir'), ('Navire'), ('Océan'), ('Plume'), ('Quiche'), ('Rivière'), ('Savane'), ('Temple'), ('Univers'), ('Volcan'), ('Wagon'), ('Xylophone'), ('Yacht'), ('Zèbre'), ('Avion'), ('Bateau'), ('Chien'), ('Diamant'), ('Éléphant'), ('Fusée'), ('Garde'), ('Hôpital'), ('Île'), ('Jardin'), ('Kangourou'), ('Lion'), ('Magicien'), ('Neige'), ('Olive'), ('Pyramide'), ('Quête'), ('Robot'), ('Sorcier'), ('Tigre'), ('Usine'), ('Vaisseau'), ('Whisky'), ('Yacht'), ('Zénith'), ('Ananas'), ('Baguette'), ('Château'), ('Dragon'), ('Éclair'), ('Forêt'), ('Grenouille'), ('Hippopotame'), ('Insecte'), ('Javelot'), ('Koala'), ('Lune'), ('Moustique'), ('Nuit'), ('Or'), ('Pomme'), ('Quasar'), ('Rêve'), ('Soleil'), ('Tortue'), ('Uniforme'), ('Vague'), ('Wapiti'), ('Xylophage'), ('Yaourt'), ('Zeppelin'), ('Aventure'), ('Baleine'), ('Clown'), ('Désert'), ('Étoile'), ('Foudre'), ('Glacier'), ('Haricot'), ('Immeuble'), ('Jouet'), ('Klaxon'), ('Lanterne'), ('Microbe'), ('Nectar'), ('Orange'), ('Pirate'), ('Quarantaine'), ('Rubis'), ('Singe'), ('Trésor'), ('Unicorne'), ('Vampire'), ('Wagon-lit');

INSERT INTO role (nom) VALUES ('Maître des mots'), ('Maître des intuitions');

INSERT INTO type (couleur, nombre) VALUES ("bleu", 8), ("gris", 15), ("noir", 2);