CREATE TABLE repo
(
repo_id INT AUTO_INCREMENT PRIMARY KEY,
repo_name VARCHAR(100),
repo_type INT NOT NULL,
UNIQUE(repo_name)
);

CREATE TABLE item
(
item_id INT AUTO_INCREMENT PRIMARY KEY,
item_name VARCHAR(100),
unit VARCHAR(5),
price DOUBLE DEFAULT 0,
pic_url VARCHAR(100),
UNIQUE(item_name)
);

CREATE TABLE contract
(
contract_id INT AUTO_INCREMENT PRIMARY KEY,
provider_id INT,
item_id INT,
contract_num INT DEFAULT 0,
price DOUBLE DEFAULT 0,
contract_date DATE,
act_num INT DEFAULT 0,
FOREIGN KEY (item_id) REFERENCES item(item_id)
);

CREATE TABLE item_log
(
log_id INT AUTO_INCREMENT PRIMARY KEY,
in_date DATE,
repo_id INT,
item_id INT,
num INT,
contract_id INT,
FOREIGN KEY(repo_id) REFERENCES repo(repo_id),
FOREIGN KEY(item_id) REFERENCES item(item_id),
FOREIGN KEY(contract_id) REFERENCES contract(contract_id)
);

CREATE TABLE item_rec
(
item_rec_id INT AUTO_INCREMENT PRIMARY KEY,
item_id INT,
num INT,
repo_id INT,
FOREIGN KEY (item_id) REFERENCES item(item_id),
FOREIGN KEY (repo_id) REFERENCES repo(repo_id),
UNIQUE (item_id,repo_id)
);

CREATE TABLE employee
(
    employees_id INT AUTO_INCREMENT PRIMARY KEY,
    employees_name VARCHAR(100),
    job VARCHAR(100),
    password VARCHAR(8)
);