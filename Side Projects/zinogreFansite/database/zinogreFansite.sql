DROP TABLE IF EXISTS zinogre_store;

CREATE table zinogre_store(
 item_id SERIAL PRIMARY KEY,
 name varchar(50),
 price float,
 description varchar(300),
 pic_location varchar(50)
 );
 
 constraint primary key item_id IS UNIQUE;

DROP TABLE IF EXISTS zinogre_hitzones;

 CREATE TABLE zinogre_hitzones(
        id SERIAL PRIMARY KEY,
        part varchar(30),
        sever_dmg integer,
        blunt_dmg integer,
        ranged_dmg integer,
        fire_dmg integer,
        water_dmg integer,
        thunder_dmg integer,
        ice_dmg integer,
        dragon_dmg integer,
        stun_dmg integer
        );
        
 CONSTRAINT PRIMARY KEY id IS UNIQUE;
        
 INSERT INTO zinogre_hitzones(part, sever_dmg, blunt_dmg, ranged_dmg, fire_dmg, water_dmg, thunder_dmg, ice_dmg, dragon_dmg, stun_dmg)
 VALUES ('Head', '45', '45', '50', '5', '10', '0', '15', '5', '100');
 INSERT INTO zinogre_hitzones(part, sever_dmg, blunt_dmg, ranged_dmg, fire_dmg, water_dmg, thunder_dmg, ice_dmg, dragon_dmg, stun_dmg)
 VALUES ('Neck', '40', '40', '45', '5', '10', '0', '15', '5', '100');
 INSERT INTO zinogre_hitzones(part, sever_dmg, blunt_dmg, ranged_dmg, fire_dmg, water_dmg, thunder_dmg, ice_dmg, dragon_dmg, stun_dmg)
 VALUES ('Torso', '30', '30', '20', '0', '5', '0', '5', '0', '0');
 INSERT INTO zinogre_hitzones(part, sever_dmg, blunt_dmg, ranged_dmg, fire_dmg, water_dmg, thunder_dmg, ice_dmg, dragon_dmg, stun_dmg)
 VALUES ('Back', '30', '30', '20', '0', '5', '0', '10', '0', '0');
 INSERT INTO zinogre_hitzones(part, sever_dmg, blunt_dmg, ranged_dmg, fire_dmg, water_dmg, thunder_dmg, ice_dmg, dragon_dmg, stun_dmg)
 VALUES ('Forelegs', '40', '40', '35', '5', '10', '0', '15', '5', '0');
 INSERT INTO zinogre_hitzones(part, sever_dmg, blunt_dmg, ranged_dmg, fire_dmg, water_dmg, thunder_dmg, ice_dmg, dragon_dmg, stun_dmg)
 VALUES ('Hindlegs', '30', '30', '20', '0', '5', '0', '5', '0', '0');
 INSERT INTO zinogre_hitzones(part, sever_dmg, blunt_dmg, ranged_dmg, fire_dmg, water_dmg, thunder_dmg, ice_dmg, dragon_dmg, stun_dmg)
 VALUES ('Tail', '30', '30', '20', '0', '5', '0', '10', '0', '0');
 INSERT INTO zinogre_hitzones(part, sever_dmg, blunt_dmg, ranged_dmg, fire_dmg, water_dmg, thunder_dmg, ice_dmg, dragon_dmg, stun_dmg)
 VALUES ('Head (Charged)', '65', '65', '55', '10', '20', '0', '25', '10', '100');
 INSERT INTO zinogre_hitzones(part, sever_dmg, blunt_dmg, ranged_dmg, fire_dmg, water_dmg, thunder_dmg, ice_dmg, dragon_dmg, stun_dmg)
 VALUES ('Neck (Charged)', '60', '60', '50', '5', '15', '0', '20', '5', '100');
 INSERT INTO zinogre_hitzones(part, sever_dmg, blunt_dmg, ranged_dmg, fire_dmg, water_dmg, thunder_dmg, ice_dmg, dragon_dmg, stun_dmg)
 VALUES ('Torso (Charged)', '25', '25', '15', '0', '5', '0', '10', '0', '0');
 INSERT INTO zinogre_hitzones(part, sever_dmg, blunt_dmg, ranged_dmg, fire_dmg, water_dmg, thunder_dmg, ice_dmg, dragon_dmg, stun_dmg)
 VALUES ('Back (Charged)', '40', '40', '45', '5', '10', '0', '15', '5', '0');
 INSERT INTO zinogre_hitzones(part, sever_dmg, blunt_dmg, ranged_dmg, fire_dmg, water_dmg, thunder_dmg, ice_dmg, dragon_dmg, stun_dmg)
 VALUES ('Forelegs (Charged)', '45', '45', '45', '5', '15', '0', '20', '5', '0');
 INSERT INTO zinogre_hitzones(part, sever_dmg, blunt_dmg, ranged_dmg, fire_dmg, water_dmg, thunder_dmg, ice_dmg, dragon_dmg, stun_dmg)
 VALUES ('Hindlegs (Charged)', '25', '25', '15', '0', '5', '0', '10', '0', '0');
 INSERT INTO zinogre_hitzones(part, sever_dmg, blunt_dmg, ranged_dmg, fire_dmg, water_dmg, thunder_dmg, ice_dmg, dragon_dmg, stun_dmg)
 VALUES ('Tail (Charged)', '45', '45', '45', '5', '10', '0', '15', '5', '0');