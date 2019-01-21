insert into customers (code, name, location, registration_date, is_active, type) values ('308ff29881164e9f', 'Luke Skywalker', 'Tatooine', 
PARSEDATETIME ('01-01-2019 12:01:02','dd-MM-yyyy hh:mm:ss'), 'y', 1);

insert into customers (code, name, location, registration_date, is_active, type) values ('bb6f6222517c46c1', 'Bruce Wayne', 'Gotham City', 
PARSEDATETIME ('21-11-2017 21:31:02','dd-MM-yyyy hh:mm:ss'), 'n', 2);

insert into customers (code, name, location, registration_date, is_active, type) values ('b6bf6812c8e645ea', 'Frodo Baggins', 'Bag End, Shire', 
PARSEDATETIME ('30-05-2016 08:19:02','dd-MM-yyyy hh:mm:ss'), 'y', 3);

insert into customers (code, name, location, registration_date, is_active, type) values ('724282cab24a40d4', 'Harry Potter', '4, Privet Drive, Little Whinging, Surrey, England, Great Britain.', 
PARSEDATETIME ('06-03-2018 16:02:02','dd-MM-yyyy hh:mm:ss'), 'y', 0);


insert into orders (id, order_date, confirm_date, complete_date, product, price, status, customer_code) 
values (3023,  PARSEDATETIME ('01-01-2019 12:01:02','dd-MM-yyyy hh:mm:ss'), PARSEDATETIME ('11-01-2019 13:15:19','dd-MM-yyyy hh:mm:ss'), 
PARSEDATETIME ('21-02-2019 20:15:20','dd-MM-yyyy hh:mm:ss'), 'LG Oled TV', 10, 2, '308ff29881164e9f');

insert into orders (id, order_date, confirm_date, complete_date, product, price, status, customer_code) 
values (56055230,  PARSEDATETIME ('01-01-2019 12:01:02','dd-MM-yyyy hh:mm:ss'), PARSEDATETIME ('11-01-2019 13:15:19','dd-MM-yyyy hh:mm:ss'), 
PARSEDATETIME ('21-02-2019 20:15:20','dd-MM-yyyy hh:mm:ss'), 'Nintendo Switch Pro Controller', 900, 1, '308ff29881164e9f');

insert into orders (id, order_date, confirm_date, complete_date, product, price, status, customer_code) 
values (6865603,  PARSEDATETIME ('01-01-2019 12:01:02','dd-MM-yyyy hh:mm:ss'), PARSEDATETIME ('11-01-2019 13:15:19','dd-MM-yyyy hh:mm:ss'), 
PARSEDATETIME ('21-02-2019 20:15:20','dd-MM-yyyy hh:mm:ss'), 'Apple iPad Mini', 10000, 1, '724282cab24a40d4');

insert into orders (id, order_date, confirm_date, complete_date, product, price, status, customer_code) 
values (12302157,  PARSEDATETIME ('01-01-2019 12:01:02','dd-MM-yyyy hh:mm:ss'), PARSEDATETIME ('11-01-2019 13:15:19','dd-MM-yyyy hh:mm:ss'), 
PARSEDATETIME ('21-02-2019 20:15:20','dd-MM-yyyy hh:mm:ss'), 'JAM Heavy Metal Wireless Stereo Speaker', 20000, 0, '724282cab24a40d4');

insert into orders (id, order_date, confirm_date, complete_date, product, price, status, customer_code) 
values (87053,  PARSEDATETIME ('01-01-2019 12:01:02','dd-MM-yyyy hh:mm:ss'), PARSEDATETIME ('11-01-2019 13:15:19','dd-MM-yyyy hh:mm:ss'), 
PARSEDATETIME ('21-02-2019 20:15:20','dd-MM-yyyy hh:mm:ss'), 'HP OfficeJet 3830 All-in-One Wireless Printer', 6000, 3, 'b6bf6812c8e645ea');

insert into orders (id, order_date, confirm_date, complete_date, product, price, status, customer_code) 
values (78576055,  PARSEDATETIME ('01-01-2019 12:01:02','dd-MM-yyyy hh:mm:ss'), PARSEDATETIME ('11-01-2019 13:15:19','dd-MM-yyyy hh:mm:ss'), 
PARSEDATETIME ('21-02-2019 20:15:20','dd-MM-yyyy hh:mm:ss'), 'Kingdom Hearts III - PlayStation 4', 4200, 1, 'b6bf6812c8e645ea');

insert into orders (id, order_date, confirm_date, complete_date, product, price, status, customer_code) 
values (230586,  PARSEDATETIME ('01-01-2019 12:01:02','dd-MM-yyyy hh:mm:ss'), PARSEDATETIME ('11-01-2019 13:15:19','dd-MM-yyyy hh:mm:ss'), 
PARSEDATETIME ('21-02-2019 20:15:20','dd-MM-yyyy hh:mm:ss'), 'iRobot Roomba 675 Robot Vacuum. Good for Pet Hair, Carpets, Hard Floors', 1000, 2, 'bb6f6222517c46c1');

insert into orders (id, order_date, confirm_date, complete_date, product, price, status, customer_code) 
values (987560,  PARSEDATETIME ('01-01-2019 12:01:02','dd-MM-yyyy hh:mm:ss'), PARSEDATETIME ('11-01-2019 13:15:19','dd-MM-yyyy hh:mm:ss'), 
PARSEDATETIME ('21-02-2019 20:15:20','dd-MM-yyyy hh:mm:ss'), 'Taylor Classic Series Large Dial Oven Thermometer', 5000, 0, 'bb6f6222517c46c1');

insert into orders (id, order_date, confirm_date, complete_date, product, price, status, customer_code) 
values (30520765,  PARSEDATETIME ('01-01-2019 12:01:02','dd-MM-yyyy hh:mm:ss'), PARSEDATETIME ('11-01-2019 13:15:19','dd-MM-yyyy hh:mm:ss'), 
PARSEDATETIME ('21-02-2019 20:15:20','dd-MM-yyyy hh:mm:ss'), 'Dirt Devil Simpli-Stik Lightweight Corded Bagless Stick Vacuum, SD20000RED', 300, 0, 'bb6f6222517c46c1');

insert into orders (id, order_date, confirm_date, complete_date, product, price, status, customer_code) 
values (867605,  PARSEDATETIME ('01-01-2019 12:01:02','dd-MM-yyyy hh:mm:ss'), PARSEDATETIME ('11-01-2019 13:15:19','dd-MM-yyyy hh:mm:ss'), 
PARSEDATETIME ('21-02-2019 20:15:20','dd-MM-yyyy hh:mm:ss'), 'Oreck Paper Bag, Oreck Type CC Uprights Hypoallergenic (8 Bags)', 9000, 1, 'bb6f6222517c46c1');

insert into orders (id, order_date, confirm_date, complete_date, product, price, status, customer_code) 
values (2356765,  PARSEDATETIME ('01-01-2019 12:01:02','dd-MM-yyyy hh:mm:ss'), PARSEDATETIME ('11-01-2019 13:15:19','dd-MM-yyyy hh:mm:ss'), 
PARSEDATETIME ('21-02-2019 20:15:20','dd-MM-yyyy hh:mm:ss'), 'Brita Small 5 Cup Water Filter Pitcher with 1 Standard Filter, BPA Free', 100000, 3, 'bb6f6222517c46c1');

insert into orders (id, order_date, confirm_date, complete_date, product, price, status, customer_code) 
values (75603,  PARSEDATETIME ('01-01-2019 12:01:02','dd-MM-yyyy hh:mm:ss'), PARSEDATETIME ('11-01-2019 13:15:19','dd-MM-yyyy hh:mm:ss'), 
PARSEDATETIME ('21-02-2019 20:15:20','dd-MM-yyyy hh:mm:ss'), 'Prismacolor Premier Pencil Sharpener', 3000, 2, '724282cab24a40d4');