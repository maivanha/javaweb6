CREATE DATABASE smobile;
USE smobile;

-- Bảng account
CREATE TABLE account (
	id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
	username VARCHAR(300) NOT NULL UNIQUE,
	userpass VARCHAR(300) NOT NULL,
	email VARCHAR(300) NOT NULL 
);

CREATE TABLE customer (
	id INT PRIMARY KEY NOT NULL,
	email VARCHAR(300) NOT NULL,
	fullname NVARCHAR(400) NOT NULL,
	address NVARCHAR(300) NOT NULL,
	mobile CHAR(11) NOT NULL,
	FOREIGN KEY (id) REFERENCES account(id)
);

-- SELECT * FROM customer INNER JOIN account ON customer.id = account.id WHERE username = 'admin';

-- Bảng Phân loại sản phẩm
CREATE TABLE producttype(
	codeSP NVARCHAR(200) PRIMARY KEY NOT NULL,
	nameSP NVARCHAR(200) NOT NULL,
	description NVARCHAR(500)
);

-- Bảng Hãng sản xuất
CREATE TABLE company(
	codeCompany NVARCHAR(200) PRIMARY KEY NOT NULL,
	nameCompany NVARCHAR(200) NOT NULL,
	description NVARCHAR(500)
);

-- Bảng Sản phẩm
CREATE TABLE product(
	codeProduct INT AUTO_INCREMENT PRIMARY KEY,
	nameProduct NVARCHAR(200) NOT NULL,
	price INT(11) NOT NULL,
	numberOfpro INT NOT NULL,
	image VARCHAR(300) NOT NULL,
	codeSP NVARCHAR(200) NOT NULL,
	codeCompany NVARCHAR(200) NOT NULL,
	description NVARCHAR(500),
	FOREIGN KEY (codeSP) REFERENCES producttype(codeSP),
	FOREIGN KEY (codeCompany) REFERENCES company(codeCompany)
);

-- Bảng Đơn hàng
CREATE TABLE orders(
	codeOrder INT AUTO_INCREMENT PRIMARY KEY,
	dateOrder DATETIME,
	receiveddate DATETIME,
	fullname NVARCHAR(450) NOT NULL,
	address NVARCHAR(450) NOT NULL,
	email CHAR(200) NOT NULL,	
	price_order INT NOT NULL,
	confirm NVARCHAR(100),
	id INT NOT NULL,
	statuss INT,
	FOREIGN KEY (id) REFERENCES account(id)
);

ALTER TABLE orders
ALTER statuss SET DEFAULT '0';


-- Bảng chi tiết đơn hàng
CREATE TABLE orderdetail (
	codeOrderDetail INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
	codeOrder INT NOT NULL,
	codeProduct INT NOT NULL,
	nameProduct NVARCHAR(200) NOT NULL,
	quantity INT NOT NULL,
	price INT NOT NULL,
	price_total INT NOT NULL,
	FOREIGN KEY (codeOrder) REFERENCES orders(codeOrder)
);

INSERT INTO account (username, userpass, email) VALUE ('admin', sha2('123456',256), 'administrator@gmail.com');
INSERT INTO account (username, userpass, email) VALUE ('admin1', sha2('123456',256), 'administrator@gmail.com');
INSERT INTO account (username, userpass, email) VALUE ('admin2', sha2('123654',256), 'administrator@gmail.com');

SELECT * FROM account;


INSERT INTO customer VALUE ('1', 'administrator@gmail.com', 'Nguyễn Văn A', 'Hà Nội', '0123654123');
INSERT INTO customer VALUE ('2', 'administrator@gmail.com', 'Nguyễn Văn B', 'Hà Nội', '0123657896');
INSERT INTO customer VALUE ('3', 'administrator@gmail.com', 'Nguyễn Văn C', 'Hà Nội', '0123658521');

SELECT * FROM customer;

--
INSERT INTO producttype(codeSP, nameSP) VALUE ('SM001','Smart Phone');
INSERT INTO producttype(codeSP, nameSP) VALUE ('TL001','Tablet');

SELECT * FROM producttype;

--
INSERT INTO Company (codeCompany, nameCompany) VALUE ('IP001', 'Iphone');
INSERT INTO Company (codeCompany, nameCompany) VALUE ('SM001', 'Samsung');
INSERT INTO Company (codeCompany, nameCompany) VALUE ('N001', 'Nokia');
INSERT INTO Company (codeCompany, nameCompany) VALUE ('V001', 'Vivo');
INSERT INTO Company (codeCompany, nameCompany) VALUE ('H001', 'Huawei');
INSERT INTO Company (codeCompany, nameCompany) VALUE ('O001', 'Oppo');

SELECT * FROM Company;

--
INSERT INTO product (nameProduct, price, numberOfpro, image, codeSP, codeCompany) VALUE ('Samsung Galaxy S9', '23000000', '20', 'Samsung Galaxy S9.jpg', 'SM001', 'SM001');
INSERT INTO product (nameProduct, price, numberOfpro, image, codeSP, codeCompany) VALUE ('iPhone X 256GB', '13000000', '20', 'iphone x.jpg', 'SM001', 'IP001');
INSERT INTO product (nameProduct, price, numberOfpro, image, codeSP, codeCompany) VALUE ('Samsung Galaxy Note 8', '15000000', '20', 'Samsung Galaxy Note 8.jpg', 'SM001', 'SM001');
INSERT INTO product (nameProduct, price, numberOfpro, image, codeSP, codeCompany) VALUE ('Huawei Nova 2i', '5000000', '20', 'Huawei Nova 2i.jpg', 'SM001', 'H001');

INSERT INTO product (nameProduct, price, numberOfpro, image, codeSP, codeCompany) VALUE ('OPPO F7 128GB', '10000000', '20', 'OPPO F7 128GB.jpg', 'SM001', 'O001');
INSERT INTO product (nameProduct, price, numberOfpro, image, codeSP, codeCompany) VALUE ('iPhone 8 Plus 64GB', '12000000', '20', 'iPhone 8 Plus 64GB.jpg', 'SM001', 'IP001');
INSERT INTO product (nameProduct, price, numberOfpro, image, codeSP, codeCompany) VALUE ('VIVO Y71', '13000000', '20', 'VIVO Y71.jpg', 'SM001', 'V001');
INSERT INTO product (nameProduct, price, numberOfpro, image, codeSP, codeCompany) VALUE ('Samsung Galaxy J2 Pro', '20000000', '20', 'Samsung Galaxy J2 Pro.jpg', 'SM001', 'SM001');

SELECT * FROM product;

--
-- insert into orders(id, codeOrder, dateOrder, scheduledate, address, closedate, email, price_total) value ();

SELECT * FROM orders;

SELECT * FROM product ORDER BY codeProduct DESC;

CREATE TABLE news (
	codeNews INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
	title NVARCHAR(300) NOT NULL,
	image VARCHAR(300) NOT NULL,
	contents NVARCHAR(8000) NOT NULL
);

INSERT INTO news(title, image, contents) VALUE ('Xiaomi Mi 8 sẽ là smartphone đầu tiên trên thế giới có GPS' , 'xiaomi.jpg', 'Xiaomi Mi 8 sẽ là smartphone đầu tiên trên thế giới có GPS băng...');
INSERT INTO news(title, image, contents) VALUE ('Nokia tiếp tục giới thiệu sản phẩm. Sẽ có Nokia 2, 3
										và 5 mới?' , 'nokia5.jpg', 'Nokia tiếp tục giới thiệu sản phẩm. Sẽ có Nokia 2, 3
										và 5 mới?');
INSERT INTO news(title, image, contents) VALUE ('Smartphone Motorola của Lenovo tiếp tục gặp khó khăn
										trong quý 1/2018' , 'gadgetmatch.jpg', 'Smartphone Motorola của Lenovo tiếp tục gặp khó khăn
										trong quý 1/2018');
INSERT INTO news(title, image, contents) VALUE ('Vivo 1802 xuất hiện trên Geekbench: Chạy Android 8.1,
										dùng chip “lạ”' , 'vivo.jpg', 'Vivo 1802 xuất hiện trên Geekbench: Chạy Android 8.1,
										dùng chip “lạ”');
INSERT INTO news(title, image, contents) VALUE ('Lenovo Z5: Màn hình không viền, camera kép AI, ROM 4
										TB' , 'lenovo-z5.jpg', 'Lenovo Z5: Màn hình không viền, camera kép AI, ROM 4
										TB');
INSERT INTO news(title, image, contents) VALUE ('Galaxy J6: Màn hình tràn viền, camera 13MP, xuất hiện
										giá bán tại Việt Nam' , 'j6.jpg', 'Galaxy J6: Màn hình tràn viền, camera 13MP, xuất hiện
										giá bán tại Việt Nam');

SELECT * FROM news;								




--
-- insert into orders(address, email, quantity, price_totel, price_order,id) value ('');

SELECT * FROM orders;

SELECT * FROM customer INNER JOIN account ON customer.id = account.id;


SELECT * FROM account ORDER BY id DESC LIMIT 1;


SELECT * FROM customer INNER JOIN account ON customer.id = account.id WHERE username = 'admin';

SELECT *  FROM news LIMIT 0, 4;

SELECT * FROM product WHERE nameProduct LIKE 's%';

SELECT * FROM product ORDER BY codeProduct DESC LIMIT 1, 8;



CREATE TABLE rating (
	idRating INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
	valueRating DOUBLE,
	codeProduct INT NOT NULL,
	username VARCHAR(300) NOT NULL,
	FOREIGN KEY (codeProduct) REFERENCES product(codeProduct),
	FOREIGN KEY (username) REFERENCES account(username)
);

SELECT AVG(valueRating) AS tbc FROM rating WHERE codeProduct = '8';

