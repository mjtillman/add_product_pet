# add_product_pet

**Creating a database and user**

        create database pet_adoptions; -- Creates the new database
        create user 'admin'@'%' identified by 'password'; -- Creates the user
        grant all on pet_adoptions.* to 'admin'@'%'; -- Gives all privileges to the new user on the newly created database

**Creating a pets table**

        CREATE TABLE pet_adoptions.pets (
          `id` int NOT NULL AUTO_INCREMENT,
          `animal` varchar(100) DEFAULT NULL,
          `name` varchar(100) DEFAULT NULL,
          `color` varchar(100) DEFAULT NULL,
          `adoption_fee` decimal(20,2) unsigned DEFAULT NULL,
          PRIMARY KEY (`id`)
        );
        
**Insert data**

        use pet_adoptions;
        insert into pet_adoptions.pets (animal, name, color, adoption_fee) values ("Squid", "Squidward", "blue", 3000);
        insert into pet_adoptions.pets (animal, name, color, adoption_fee) values ("Squirrel", "Sandy", "brown", 5000);
        
**Testing a select**

        use pet_adoptions;
        select * from pets;
