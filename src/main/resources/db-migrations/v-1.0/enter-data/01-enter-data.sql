-- clients
INSERT INTO public.clients(discount_one, discount_two, name, uuid) VALUES (3, 5, 'Roman',	'8dc06ccd-21dc-4c83-9477-7ddccb6c1511');
INSERT INTO public.clients(discount_one, discount_two, name, uuid) VALUES (2, 5, 'Sergey', '354eb667-5c6e-4096-a415-82f507e5ff9f');
INSERT INTO public.clients(discount_one, discount_two, name, uuid) VALUES (3, 6, 'Jeka', 'a42bc42f-c6ff-4c17-b2e2-ac9c1252e08b');
INSERT INTO public.clients(discount_one, discount_two, name, uuid) VALUES (3, 6, 'Sany', '3b454226-9d41-4248-9e0e-044084f7d3ab');
INSERT INTO public.clients(discount_one, discount_two, name, uuid) VALUES (2, 4, 'Ivan', '01ef5da9-3513-4bbb-9e38-7c43237125ce');
INSERT INTO public.clients(discount_one, discount_two, name, uuid) VALUES (4, 7, 'Yury', '794c6d6b-f449-4e0f-b1b2-20237d6972d3');
INSERT INTO public.clients(discount_one, discount_two, name, uuid) VALUES (8, 8, 'Stepan', '861e70dc-7308-4876-bc98-e4b9c887ba46');
INSERT INTO public.clients(discount_one, discount_two, name, uuid) VALUES (1, 3, 'Nina', '3ce38ad4-76bc-4be8-bbe2-1c5ceef563f0');
INSERT INTO public.clients(discount_one, discount_two, name, uuid) VALUES (1, 3, 'Lena', '12a7f2d8-6890-4384-b9e3-9956dfa52dbc');
INSERT INTO public.clients(discount_one, discount_two, name, uuid) VALUES (5, 1, 'Katy', '497e0f33-f1fb-43b8-b47a-fa4d5b3b01f1');
INSERT INTO public.clients(discount_one, discount_two, name, uuid) VALUES (1, 3, 'Katty',	'f3dee5c6-9146-479e-a4c5-9b8db282eca5');
INSERT INTO public.clients(discount_one, discount_two, name, uuid) VALUES (2, 4, 'Tolik',	'10173a77-edb4-4d4a-a93f-d7c7284e6ad9');

-- products
INSERT INTO public.products(description, discount, name, price, uuid) VALUES ('LGA 775, Intel G31, 2xDDR2-800 МГц, 1xPCI-Ex16, Micro-ATX', 6, 'Материнская плата Esonic G31CHL3', 3000, '73f05325-f3e3-402f-8e9c-ce4d288b9ea8');
INSERT INTO public.products(description, discount, name, price, uuid) VALUES ('LGA 1151-v2, Intel H310, 2xDDR4-2666 МГц, 1xPCI-Ex16, Micro-ATX', 9, 'Материнская плата ASRock H310CM-DVS', 3200, '7a0123dd-15d2-424d-8128-9ff7355df28e');
INSERT INTO public.products(description, discount, name, price, uuid) VALUES ('LGA 775, Intel G41, 2xDDR3-1600 МГц, 1xPCI-Ex16, Micro-ATX', 5, 'Материнская плата AFOX IG41-MA7', 4000, '633bf848-1d01-47ac-a32c-fdb8130f094b');
INSERT INTO public.products(description, discount, name, price, uuid) VALUES ('LGA 1150, Intel H81, 2xDDR3-1333 МГц, 1xPCI-Ex16, Micro-ATX', 9, 'Материнская плата Esonic H81JEL', 4500, 'a9efdd76-70d0-4eba-a4e7-eee1312fd9f5');
INSERT INTO public.products(description, discount, name, price, uuid) VALUES ('AM4, 2 x 3 ГГц, L2 - 1 МБ, 2хDDR4-2400 МГц, AMD Radeon R5, TDP 35 Вт', 9, 'Процессор AMD A6-9500E OEM', 900, '340333fe-e7f7-4cbe-9791-7c9806d2d7cc');
INSERT INTO public.products(description, discount, name, price, uuid) VALUES ('LGA 1151-v2, 2 x 3.1 ГГц, L2 - 0.5 МБ, L3 - 2 МБ, 2хDDR4-2400 МГц, Intel UHD Graphics 610, TDP 54 Вт', 5, 'Процессор Intel Celeron G4900 OEM', 3400, '745aee97-ea0d-43dd-919b-27dc586917be');
INSERT INTO public.products(description, discount, name, price, uuid) VALUES ('AM4, 4 x 3.1 ГГц, L2 - 2 МБ, L3 - 8 МБ, 2хDDR4-2667 МГц, TDP 65 Вт', 8, 'Процессор AMD Ryzen 3 1200 OEM', 5700, '8c802848-cea8-4dc3-9c50-4d38e8fe813e');
INSERT INTO public.products(description, discount, name, price, uuid) VALUES ('LGA 1151-v2, 6 x 2.8 ГГц, L2 - 1.5 МБ, L3 - 9 МБ, 2хDDR4-2666 МГц, Intel UHD Graphics 630, TDP 65 Вт', 7, 'Процессор Intel Core i5-8400 OEM', 15700, '46d2db9d-4bb5-42d2-b0b1-f31f35530a07');
INSERT INTO public.products(description, discount, name, price, uuid) VALUES ('R534G1601U1SL-U] 4 ГБ [DDR3L, 4 ГБx1 шт, 1600 МГц, 11-11-11-28', 5, 'Оперативная память AMD Radeon R5 Entertainment Series', 650, '0b720f1c-7fab-4886-af90-a007c82d38d3');
INSERT INTO public.products(description, discount, name, price, uuid) VALUES ('PSD44G266681] 4 ГБ [DDR4, 4 ГБx1 шт, 2666 МГц, 19-19-19-43', 5, 'Оперативная память Patriot Signature Line', 1150, '420e7dfe-b4e6-4052-b2e3-a5b5985ce1d0');
INSERT INTO public.products(description, discount, name, price, uuid) VALUES ('AH4U08G26C08YMBAA-1] 8 ГБ [DDR4, 8 ГБx1 шт, 2666 МГц, 16-18-18-38', 5, 'Оперативная память Apacer NOX', 1700, 'ba7c1496-2487-4703-bb59-b6ef686ae73b');
INSERT INTO public.products(description, discount, name, price, uuid) VALUES ('KF437C19BBA/8] 8 ГБ [DDR4, 8 ГБx1 шт, 3733 МГц, 19-23-23', 6, 'Оперативная память Kingston FURY Beast Black RGB', 2300, '12842254-9100-484e-a9da-2bd70aa6ec2b');

-- sales
INSERT INTO public.sales(client_id, date, check_number)	VALUES (10, '2023-05-05 09:16:19.599', 100);
INSERT INTO public.sales(client_id, date, check_number)	VALUES (2, '2023-05-05 12:23:46.839', 101);
INSERT INTO public.sales(client_id, date, check_number)	VALUES (11, '2023-05-05 14:13:35.707', 102);
INSERT INTO public.sales(client_id, date, check_number)	VALUES (1, '2023-05-06 14:18:13.347', 100);
INSERT INTO public.sales(client_id, date, check_number)	VALUES (12, '2023-05-06 15:13:13.715', 101);
INSERT INTO public.sales(client_id, date, check_number)	VALUES (3, '2023-05-06 15:18:19.228', 102);
INSERT INTO public.sales(client_id, date, check_number)	VALUES (4, '2023-05-06 16:26:32.706', 103);

-- positions
INSERT INTO public.positions(final_discount, final_price, product_id, price_for_quantity, quantity, sale_id) VALUES (9, 9200, 12, 9200, 4, 1);
INSERT INTO public.positions(final_discount, final_price, product_id, price_for_quantity, quantity, sale_id) VALUES (11, 4500, 4, 4500, 1, 1);
INSERT INTO public.positions(final_discount, final_price, product_id, price_for_quantity, quantity, sale_id) VALUES (7, 15700, 8, 15700, 1, 1);
INSERT INTO public.positions(final_discount, final_price, product_id, price_for_quantity, quantity, sale_id) VALUES (8, 6256, 11, 6800, 4, 4);
INSERT INTO public.positions(final_discount, final_price, product_id, price_for_quantity, quantity, sale_id) VALUES (9, 3640, 3, 4000, 1, 4);
INSERT INTO public.positions(final_discount, final_price, product_id, price_for_quantity, quantity, sale_id) VALUES (6, 5358, 7, 5700, 1, 4);
INSERT INTO public.positions(final_discount, final_price, product_id, price_for_quantity, quantity, sale_id) VALUES (9, 6188, 11, 6800, 4, 5);
INSERT INTO public.positions(final_discount, final_price, product_id, price_for_quantity, quantity, sale_id) VALUES (12, 3520, 3, 4000, 1, 5);
INSERT INTO public.positions(final_discount, final_price, product_id, price_for_quantity, quantity, sale_id) VALUES (9, 5187, 7, 5700, 1, 5);
INSERT INTO public.positions(final_discount, final_price, product_id, price_for_quantity, quantity, sale_id) VALUES (7, 3720, 3, 4000, 1, 6);
INSERT INTO public.positions(final_discount, final_price, product_id, price_for_quantity, quantity, sale_id) VALUES (8, 5244, 7, 5700, 1, 6);
INSERT INTO public.positions(final_discount, final_price, product_id, price_for_quantity, quantity, sale_id) VALUES (7, 6324, 11, 6800, 4, 6);
INSERT INTO public.positions(final_discount, final_price, product_id, price_for_quantity, quantity, sale_id) VALUES (10, 810, 5, 900, 1, 7);
INSERT INTO public.positions(final_discount, final_price, product_id, price_for_quantity, quantity, sale_id) VALUES (7, 4278, 10, 4600, 4, 7);
INSERT INTO public.positions(final_discount, final_price, product_id, price_for_quantity, quantity, sale_id) VALUES (9, 2912, 2, 3200, 1, 7);
INSERT INTO public.positions(final_discount, final_price, product_id, price_for_quantity, quantity, sale_id) VALUES (11, 801, 5, 900, 1, 2);
INSERT INTO public.positions(final_discount, final_price, product_id, price_for_quantity, quantity, sale_id) VALUES (8, 1058, 10, 1150, 1, 2);
INSERT INTO public.positions(final_discount, final_price, product_id, price_for_quantity, quantity, sale_id) VALUES (9, 11648, 2, 12800, 4, 2);
INSERT INTO public.positions(final_discount, final_price, product_id, price_for_quantity, quantity, sale_id) VALUES (11, 801, 5, 900, 1, 3);
INSERT INTO public.positions(final_discount, final_price, product_id, price_for_quantity, quantity, sale_id) VALUES (7, 1070, 10, 1150, 1, 3);
INSERT INTO public.positions(final_discount, final_price, product_id, price_for_quantity, quantity, sale_id) VALUES (11, 11392, 2, 12800, 4, 3);

-- product-ratings
INSERT INTO public.product_ratings(rating, client_id, product_id)	VALUES (3, 10, 8);
INSERT INTO public.product_ratings(rating, client_id, product_id)	VALUES (3, 10, 4);
INSERT INTO public.product_ratings(rating, client_id, product_id)	VALUES (5, 10, 12);
INSERT INTO public.product_ratings(rating, client_id, product_id)	VALUES (4, 2, 2);
INSERT INTO public.product_ratings(rating, client_id, product_id)	VALUES (4, 2, 5);
INSERT INTO public.product_ratings(rating, client_id, product_id)	VALUES (5, 2, 10);
INSERT INTO public.product_ratings(rating, client_id, product_id)	VALUES (3, 3, 2);
INSERT INTO public.product_ratings(rating, client_id, product_id)	VALUES (3, 3, 5);
INSERT INTO public.product_ratings(rating, client_id, product_id)	VALUES (3, 3, 10);
INSERT INTO public.product_ratings(rating, client_id, product_id)	VALUES (2, 4, 2);
INSERT INTO public.product_ratings(rating, client_id, product_id)	VALUES (2, 4, 5);
INSERT INTO public.product_ratings(rating, client_id, product_id)	VALUES (4, 4, 10);