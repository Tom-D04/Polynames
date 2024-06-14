-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : ven. 14 juin 2024 à 23:47
-- Version du serveur : 10.4.32-MariaDB
-- Version de PHP : 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `poly_names`
--

-- --------------------------------------------------------

--
-- Structure de la table `card`
--

CREATE TABLE `card` (
  `word` varchar(32) NOT NULL,
  `color` varchar(32) NOT NULL,
  `state` tinyint(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `card`
--

INSERT INTO `card` (`word`, `color`, `state`) VALUES
('Aiguille', 'grey', 1),
('Asile', 'blue', 1),
('Bière', 'grey', 1),
('Brique', 'blue', 1),
('Bœuf', 'black', 1),
('Cadre', 'blue', 1),
('Cinéma', 'black', 1),
('Clé', 'grey', 1),
('Couronne', 'grey', 1),
('Crochet', 'blue', 1),
('Espagne', 'blue', 1),
('Feuille', 'grey', 1),
('Hiver', 'blue', 1),
('Hôpital', 'grey', 1),
('Kangourou', 'grey', 1),
('Maladie', 'blue', 1),
('Or', 'grey', 1),
('Palme', 'grey', 1),
('Perle', 'grey', 1),
('Pilote', 'grey', 1),
('Poêle', 'grey', 1),
('Pyramide', 'grey', 1),
('Règle', 'grey', 1),
('Reine', 'blue', 1),
('Vent', 'grey', 1);

-- --------------------------------------------------------

--
-- Structure de la table `game`
--

CREATE TABLE `game` (
  `id` int(11) NOT NULL,
  `authentication_code` int(11) NOT NULL,
  `score` int(11) NOT NULL DEFAULT 0,
  `spymaster` int(11) NOT NULL,
  `operative` int(11) NOT NULL,
  `turn` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `game`
--

INSERT INTO `game` (`id`, `authentication_code`, `score`, `spymaster`, `operative`, `turn`) VALUES
(1, 0, 0, 1, 2, 0);

-- --------------------------------------------------------

--
-- Structure de la table `hint`
--

CREATE TABLE `hint` (
  `id` int(11) NOT NULL,
  `hintValue` text NOT NULL,
  `cards_number` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `hint`
--

INSERT INTO `hint` (`id`, `hintValue`, `cards_number`) VALUES
(1, 'Your hint', 0);

-- --------------------------------------------------------

--
-- Structure de la table `words`
--

CREATE TABLE `words` (
  `id` int(11) UNSIGNED NOT NULL,
  `word` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `words`
--

INSERT INTO `words` (`id`, `word`) VALUES
(1, 'Afrique'),
(2, 'Aiguille'),
(3, 'Aile'),
(4, 'Air'),
(5, 'Alien'),
(6, 'Allemagne'),
(7, 'Alpes'),
(8, 'Amérique'),
(9, 'Amour'),
(10, 'Ampoule'),
(11, 'Ange'),
(12, 'Angleterre'),
(13, 'Anneau'),
(14, 'Appareil'),
(15, 'Araignée'),
(16, 'Arc'),
(17, 'Argent'),
(18, 'Asile'),
(19, 'Astérix'),
(20, 'Atlantique'),
(21, 'Atout'),
(22, 'Australie'),
(23, 'Avion'),
(24, 'Avocat'),
(25, 'Baguette'),
(26, 'Baie'),
(27, 'Balance'),
(28, 'Baleine'),
(29, 'Balle'),
(30, 'Ballon'),
(31, 'Banane'),
(32, 'Banc'),
(33, 'Bande'),
(34, 'Banque'),
(35, 'Bar'),
(36, 'Barre'),
(37, 'Base'),
(38, 'Bateau'),
(39, 'Bâton'),
(40, 'Berlin'),
(41, 'Bête'),
(42, 'Bière'),
(43, 'Blé'),
(44, 'Bœuf'),
(45, 'Boîte'),
(46, 'Boîte'),
(47, 'Bombe'),
(48, 'Bon'),
(49, 'Bouche'),
(50, 'Bouchon'),
(51, 'Bougie'),
(52, 'Boulet'),
(53, 'Bourse'),
(54, 'Bouteille'),
(55, 'Bouton'),
(56, 'Branche'),
(57, 'Bretelle'),
(58, 'Brique'),
(59, 'Bûche'),
(60, 'Bureau'),
(61, 'But'),
(62, 'Cabinet'),
(63, 'Cadre'),
(64, 'Cafard'),
(65, 'Café'),
(66, 'Camembert'),
(67, 'Campagne'),
(68, 'Canada'),
(69, 'Canard'),
(70, 'Canne'),
(71, 'Canon'),
(72, 'Carreau'),
(73, 'Carrière'),
(74, 'Carte'),
(75, 'Carton'),
(76, 'Cartouche'),
(77, 'Casino'),
(78, 'Ceinture'),
(79, 'Cellule'),
(80, 'Centre'),
(81, 'Cercle'),
(82, 'Chaîne'),
(83, 'Champ'),
(84, 'Champagne'),
(85, 'Chance'),
(86, 'Chapeau'),
(87, 'Charge'),
(88, 'Charme'),
(89, 'Chasse'),
(90, 'Chat'),
(91, 'Château'),
(92, 'Chausson'),
(93, 'Chef'),
(94, 'Chemise'),
(95, 'Cheval'),
(96, 'Chevalier'),
(97, 'Chien'),
(98, 'Chine'),
(99, 'Chocolat'),
(100, 'Chou'),
(101, 'Cinéma'),
(102, 'Cirque'),
(103, 'Citrouille'),
(104, 'Classe'),
(105, 'Clé'),
(106, 'Club'),
(107, 'Cochon'),
(108, 'Code'),
(109, 'Cœur'),
(110, 'Col'),
(111, 'Colle'),
(112, 'Commerce'),
(113, 'Coq'),
(114, 'Corde'),
(115, 'Corne'),
(116, 'Coton'),
(117, 'Coupe'),
(118, 'Courant'),
(119, 'Couronne'),
(120, 'Course'),
(121, 'Court'),
(122, 'Couteau'),
(123, 'Couverture'),
(124, 'Critique'),
(125, 'Crochet'),
(126, 'Cuisine'),
(127, 'Cycle'),
(128, 'Danse'),
(129, 'Dinosaure'),
(130, 'Docteur'),
(131, 'Don'),
(132, 'Dragon'),
(133, 'Droit'),
(134, 'Droite'),
(135, 'Eau'),
(136, 'Échelle'),
(137, 'Éclair'),
(138, 'École'),
(139, 'Égalité'),
(140, 'Égypte'),
(141, 'Enceinte'),
(142, 'Ensemble'),
(143, 'Entrée'),
(144, 'Éponge'),
(145, 'Espace'),
(146, 'Espagne'),
(147, 'Espion'),
(148, 'Esprit'),
(149, 'Essence'),
(150, 'Étoile'),
(151, 'Étude'),
(152, 'Europe'),
(153, 'Facteur'),
(154, 'Fantôme'),
(155, 'Farce'),
(156, 'Fer'),
(157, 'Ferme'),
(158, 'Feu'),
(159, 'Feuille'),
(160, 'Figure'),
(161, 'Filet'),
(162, 'Fin'),
(163, 'Flûte'),
(164, 'Forêt'),
(165, 'Formule'),
(166, 'Fort'),
(167, 'Fou'),
(168, 'Foyer'),
(169, 'Fraise'),
(170, 'Français'),
(171, 'Front'),
(172, 'Fuite'),
(173, 'Garde'),
(174, 'Gauche'),
(175, 'Géant'),
(176, 'Gel'),
(177, 'Génie'),
(178, 'Glace'),
(179, 'Gorge'),
(180, 'Grain'),
(181, 'Grèce'),
(182, 'Grenade'),
(183, 'Grue'),
(184, 'Guerre'),
(185, 'Guide'),
(186, 'Herbe'),
(187, 'Héros'),
(188, 'Himalaya'),
(189, 'Histoire'),
(190, 'Hiver'),
(191, 'Hollywood'),
(192, 'Hôpital'),
(193, 'Hôtel'),
(194, 'Indien'),
(195, 'Iris'),
(196, 'Jet'),
(197, 'Jeu'),
(198, 'Jour'),
(199, 'Journal'),
(200, 'Jumelles'),
(201, 'Jungle'),
(202, 'Kangourou'),
(203, 'Kiwi'),
(204, 'Lait'),
(205, 'Langue'),
(206, 'Laser'),
(207, 'Lentille'),
(208, 'Lettre'),
(209, 'Licorne'),
(210, 'Lien'),
(211, 'Ligne'),
(212, 'Lion'),
(213, 'Liquide'),
(214, 'Lit'),
(215, 'Livre'),
(216, 'Londres'),
(217, 'Louche'),
(218, 'Lumière'),
(219, 'Lune'),
(220, 'Lunettes'),
(221, 'Luxe'),
(222, 'Machine'),
(223, 'Magie'),
(224, 'Main'),
(225, 'Maîtresse'),
(226, 'Majeur'),
(227, 'Maladie'),
(228, 'Manche'),
(229, 'Manège'),
(230, 'Marche'),
(231, 'Marin'),
(232, 'Marque'),
(233, 'Marron'),
(234, 'Mars'),
(235, 'Membre'),
(236, 'Mémoire'),
(237, 'Menu'),
(238, 'Meuble'),
(239, 'Microscope'),
(240, 'Miel'),
(241, 'Millionnaire'),
(242, 'Mine'),
(243, 'Mineur'),
(244, 'Mode'),
(245, 'Molière'),
(246, 'Mort'),
(247, 'Mouche'),
(248, 'Moule'),
(249, 'Mousse'),
(250, 'Moustache'),
(251, 'Nain'),
(252, 'Napoléon'),
(253, 'Neige'),
(254, 'New-York'),
(255, 'Ninja'),
(256, 'Noël'),
(257, 'Nœud'),
(258, 'Noir'),
(259, 'Note'),
(260, 'Nuit'),
(261, 'Numéro'),
(262, 'œil'),
(263, 'œuf'),
(264, 'Oiseau'),
(265, 'Opéra'),
(266, 'Opération'),
(267, 'Or'),
(268, 'Orange'),
(269, 'Ordre'),
(270, 'Page'),
(271, 'Paille'),
(272, 'Palais'),
(273, 'Palme'),
(274, 'Papier'),
(275, 'Parachute'),
(276, 'Paris'),
(277, 'Partie'),
(278, 'Passe'),
(279, 'Patron'),
(280, 'Pêche'),
(281, 'Pendule'),
(282, 'Pensée'),
(283, 'Perle'),
(284, 'Peste'),
(285, 'Pétrole'),
(286, 'Phare'),
(287, 'Physique'),
(288, 'Piano'),
(289, 'Pièce'),
(290, 'Pied'),
(291, 'Pigeon'),
(292, 'Pile'),
(293, 'Pilote'),
(294, 'Pingouin'),
(295, 'Pirate'),
(296, 'Place'),
(297, 'Plage'),
(298, 'Plan'),
(299, 'Planche'),
(300, 'Plante'),
(301, 'Plat'),
(302, 'Plateau'),
(303, 'Plume'),
(304, 'Poêle'),
(305, 'Point'),
(306, 'Poire'),
(307, 'Poison'),
(308, 'Poisson'),
(309, 'Pôle'),
(310, 'Police'),
(311, 'Pomme'),
(312, 'Pompe'),
(313, 'Portable'),
(314, 'Poste'),
(315, 'Pouce'),
(316, 'Prêt'),
(317, 'Princesse'),
(318, 'Prise'),
(319, 'Pyramide'),
(320, 'Quartier'),
(321, 'Queue'),
(322, 'Radio'),
(323, 'Raie'),
(324, 'Rame'),
(325, 'Rat'),
(326, 'Rayon'),
(327, 'Recette'),
(328, 'Règle'),
(329, 'Reine'),
(330, 'Religieuse'),
(331, 'Remise'),
(332, 'Requin'),
(333, 'Résistance'),
(334, 'Restaurant'),
(335, 'Révolution'),
(336, 'Robe'),
(337, 'Robot'),
(338, 'Roi'),
(339, 'Rome'),
(340, 'Ronde'),
(341, 'Rose'),
(342, 'Rouge'),
(343, 'Rouleau'),
(344, 'Roulette'),
(345, 'Russie'),
(346, 'Sardine'),
(347, 'Satellite'),
(348, 'Scène'),
(349, 'Schtroumpf'),
(350, 'Science'),
(351, 'Sens'),
(352, 'Sept'),
(353, 'Serpent'),
(354, 'Siège'),
(355, 'Sirène'),
(356, 'Sol'),
(357, 'Soldat'),
(358, 'Soleil'),
(359, 'Solution'),
(360, 'Somme'),
(361, 'Sorcière'),
(362, 'Sortie'),
(363, 'Souris'),
(364, 'Table'),
(365, 'Tableau'),
(366, 'Talon'),
(367, 'Tambour'),
(368, 'Temple'),
(369, 'Temps'),
(370, 'Tennis'),
(371, 'Terre'),
(372, 'Tête'),
(373, 'Timbre'),
(374, 'Titre'),
(375, 'Toile'),
(376, 'Tokyo'),
(377, 'Tour'),
(378, 'Trait'),
(379, 'Trésor'),
(380, 'Trou'),
(381, 'Tube'),
(382, 'Tuile'),
(383, 'Uniforme'),
(384, 'Vague'),
(385, 'Vaisseau'),
(386, 'Vampire'),
(387, 'Vase'),
(388, 'Vent'),
(389, 'Verre'),
(390, 'Vert'),
(391, 'Vie'),
(392, 'Vin'),
(393, 'Visage'),
(394, 'Vision'),
(395, 'Voile'),
(396, 'Voiture'),
(397, 'Vol'),
(398, 'Voleur'),
(399, 'Volume'),
(400, 'Zéro');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `card`
--
ALTER TABLE `card`
  ADD PRIMARY KEY (`word`);

--
-- Index pour la table `game`
--
ALTER TABLE `game`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `hint`
--
ALTER TABLE `hint`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `words`
--
ALTER TABLE `words`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `game`
--
ALTER TABLE `game`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `hint`
--
ALTER TABLE `hint`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `words`
--
ALTER TABLE `words`
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=401;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
