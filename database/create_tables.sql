-- Base de données E-Commerce
-- Création des tables pour XAMPP/MySQL

-- Table des utilisateurs
CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

-- Table des produits
CREATE TABLE produits (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    ref VARCHAR(255) NOT NULL UNIQUE,
    name VARCHAR(255) NOT NULL,
    stock DOUBLE NOT NULL,
    user_id BIGINT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id)
);

-- Table des achats
CREATE TABLE achats (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    date_p DATE NOT NULL,
    quantity DOUBLE NOT NULL,
    product_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    FOREIGN KEY (product_id) REFERENCES produits(id),
    FOREIGN KEY (user_id) REFERENCES users(id)
);

-- Table des ventes
CREATE TABLE ventes (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    date_p DATE NOT NULL,
    quantity DOUBLE NOT NULL,
    product_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    FOREIGN KEY (product_id) REFERENCES produits(id),
    FOREIGN KEY (user_id) REFERENCES users(id)
);

-- Index pour optimiser les performances
CREATE INDEX idx_users_email ON users(email);
CREATE INDEX idx_produits_ref ON produits(ref);
CREATE INDEX idx_produits_user ON produits(user_id);
CREATE INDEX idx_achats_date ON achats(date_p);
CREATE INDEX idx_achats_product ON achats(product_id);
CREATE INDEX idx_achats_user ON achats(user_id);
CREATE INDEX idx_ventes_date ON ventes(date_p);
CREATE INDEX idx_ventes_product ON ventes(product_id);
CREATE INDEX idx_ventes_user ON ventes(user_id);
