
-- БАЗА ДАНИХ
-- Можливість створення БД з метою уникнення некваліфікованих
-- дій, краще залишити за розробником.
-- Тому такий функціонал у додатку не прописуємо.
-- Тут, БД створюємо через візуальний інструмент, наприклад,
-- MySQL Workbench.
CREATE DATABASE hibernate_db;

-- ТАБЛИЦІ
-- Можливість створення таблиць БД, з метою уникнення некваліфікованих
-- дій, краще залишити за розробником.
-- Тому такий функціонал у додатку не прописуємо.
-- Попередньо, необхідно спроектувати таблиці та їх зв'язки,
-- на основі сутностей реального світу.
-- Тут, таблиці БД створюємо через візуальний інструмент, наприклад,
-- MySQL Workbench.

CREATE TABLE IF NOT EXISTS contacts1
( id INTEGER NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(128) NOT NULL,
  last_name VARCHAR(128) NOT NULL,
  phone VARCHAR(56) NOT NULL,
  email VARCHAR(128) NOT NULL,
  PRIMARY KEY (id)
);

-- УВАГА.
-- Застосовано HQL (Hibernate Query Language).
-- HQL – об'єктно-орієнтована мова запитів, яка дуже схожа на SQL.
-- https://docs.jboss.org/hibernate/orm/6.2/userguide/html_single/Hibernate_User_Guide.html#hql
-- https://docs.jboss.org/hibernate/orm/6.2/userguide/html_single/Hibernate_User_Guide.html#query-language

-- HQL
INSERT INTO Contact (firstName, lastName, phone, email) VALUES (:firstName, :lastName, :phone, :email)
-- SQL
INSERT INTO contacts (first_name, last_name, phone, email) VALUES (:first_name, :last_name, :phone, :email)


-- HQL
FROM Contact
-- SQL
SELECT * FROM contacts


-- HQL
UPDATE Contact SET phone = :phone WHERE id = :id
-- SQL
UPDATE contacts SET phone = :phone WHERE id = :id


-- HQL
DELETE FROM Contact WHERE id = :id
-- SQL
DELETE FROM contacts WHERE id = :id;