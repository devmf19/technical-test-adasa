CREATE TABLE company(
	id_company int primary key unique,
    codigo_company varchar(255) unique,
    name_company varchar(500),
    description_company varchar(1000)
);

create table application (
	app_id int primary key unique,
    app_code varchar(255) unique,
    app_name varchar (500),
    app_description varchar (1000)
);

create table version (
	version_id int primary key unique,
    app_id int not null unique,
    version varchar(500),
    version_description varchar(1000),
    foreign key (app_id) references application(app_id)
);

create table version_company(
	version_company_id int primary key unique,
    company_id int not null unique,
    version_id int not null,
    version_company_description varchar(1000),
    foreign key (company_id) references company(id_company),
    foreign key (version_id) references version(version_id)
);



CREATE TABLE TMP_LLENAR_CAMPOS (
	id_company  int ,
    codigo_company varchar(1000),
    name_company varchar(1000),
    description_company varchar(1000),
    
    version_id int,
    app_id int,
    version  varchar(1000),
    version_description varchar(1000),
    
    version_company_id int,
    version_company_description varchar(1000),
    
    app_code varchar(1000),
    app_name varchar(1000),
    app_description varchar(1000)
);


DELIMITER $$

CREATE PROCEDURE insertarDatos()
BEGIN
    DECLARE done INT DEFAULT 0;
    DECLARE v_id_company INT;
    DECLARE v_codigo_company VARCHAR(1000);
    DECLARE v_name_company VARCHAR(1000);
    DECLARE v_description_company VARCHAR(1000);
    
    DECLARE v_version_id INT;
    DECLARE v_app_id INT;
    DECLARE v_version VARCHAR(1000);
    DECLARE v_version_description VARCHAR(1000);
    
    DECLARE v_version_company_id INT;
    DECLARE v_version_company_description VARCHAR(1000);
    
    DECLARE v_app_code VARCHAR(1000);
    DECLARE v_app_name VARCHAR(1000);
    DECLARE v_app_description VARCHAR(1000);
    
    DECLARE curTemporal CURSOR FOR
        SELECT id_company, codigo_company, name_company, description_company,
               version_id, app_id, version, version_description,
               version_company_id, version_company_description,
               app_code, app_name, app_description
        FROM TMP_LLENAR_CAMPOS;
    
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = 1;

    OPEN curTemporal;

    read_loop: LOOP
        FETCH curTemporal INTO 
            v_id_company, v_codigo_company, v_name_company, v_description_company,
            v_version_id, v_app_id, v_version, v_version_description,
            v_version_company_id, v_version_company_description,
            v_app_code, v_app_name, v_app_description;
        
        IF done THEN
            LEAVE read_loop;
        END IF;

        INSERT INTO company (id_company, codigo_company, name_company, description_company)
        VALUES (v_id_company, v_codigo_company, v_name_company, v_description_company)
        ON DUPLICATE KEY UPDATE 
            codigo_company = VALUES(codigo_company), 
            name_company = VALUES(name_company), 
            description_company = VALUES(description_company);

        INSERT INTO application (app_id, app_code, app_name, app_description)
        VALUES (v_app_id, v_app_code, v_app_name, v_app_description)
        ON DUPLICATE KEY UPDATE 
            app_code = VALUES(app_code), 
            app_name = VALUES(app_name), 
            app_description = VALUES(app_description);

        INSERT INTO version (version_id, app_id, version, version_description)
        VALUES (v_version_id, v_app_id, v_version, v_version_description)
        ON DUPLICATE KEY UPDATE 
            version = VALUES(version), 
            version_description = VALUES(version_description);

        INSERT INTO version_company (version_company_id, company_id, version_id, version_company_description)
        VALUES (v_version_company_id, v_id_company, v_version_id, v_version_company_description)
        ON DUPLICATE KEY UPDATE 
            version_company_description = VALUES(version_company_description);
    END LOOP;

    CLOSE curTemporal;
END$$

DELIMITER ;



call insertarDatos();