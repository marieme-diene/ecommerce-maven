-- Données de test pour E-Commerce
-- À exécuter après avoir créé les tables

-- Insertion d'utilisateurs de test
INSERT INTO users (email, password) VALUES 
('admin@ecommerce.com', '$2a$10$N.zmdr9k7uOCQb376Q9O1E1Mz7S8K5t6K8K5t6K8K5t6'),
('user1@ecommerce.com', '$2a$10$N.zmdr9k7uOCQb376Q9O1E1Mz7S8K5t6K8K5t6K8K5t6'),
('user2@ecommerce.com', '$2a$10$N.zmdr9k7uOCQb376Q9O1E1Mz7S8K5t6K8K5t6K8K5t6');

-- Insertion de produits de test
INSERT INTO produits (ref, name, stock, user_id) VALUES 
('REF001', 'Ordinateur Portable', 15.0, 1),
('REF002', 'Smartphone Android', 25.0, 1),
('REF003', 'Casque Bluetooth', 50.0, 2),
('REF004', 'Clavier USB', 30.0, 2),
('REF005', 'Souris Optique', 40.0, 3);

-- Insertion d'achats de test
INSERT INTO achats (date_p, quantity, product_id, user_id) VALUES 
('2024-01-15', 10.0, 1, 1),
('2024-01-20', 5.0, 2, 1),
('2024-02-01', 20.0, 3, 2),
('2024-02-15', 15.0, 4, 3),
('2024-03-01', 8.0, 5, 1);

-- Insertion de ventes de test
INSERT INTO ventes (date_p, quantity, product_id, user_id) VALUES 
('2024-01-10', 2.0, 1, 1),
('2024-01-25', 3.0, 2, 2),
('2024-02-05', 5.0, 3, 3),
('2024-02-20', 4.0, 4, 1),
('2024-03-05', 6.0, 5, 2);
