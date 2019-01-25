INSERT INTO Book
  (id, ISBN, DOI, title, downloaded_address, photo, category, price)
VALUES
  (1, '978-3-11-042640-3', '', 'Commercial Orchids', 'https://www.degruyter.com/view/product/456245?format=EBOK', 'https://www.doabooks.org/doab?func=cover&rid=16874', 'Plant Sciences', 34),
  (2, '978-3-03897-368-3', '', 'Dairy Products', 'https://www.mdpi.com/books/pdfview/book/1041', 'https://res.mdpi.com/bookfiles/book/1041/Dairy_Products.jpg', 'Animal Sciences', 29.99),
  (3, '978-1-4842-0100-8', 'https://doi.org/10.1007/978-1-4842-0100-8', 'Android Application Development for the Intel® Platform', 'https://link.springer.com/book/10.1007/978-1-4842-0100-8', 'https://images.springer.com/sgw/books/medium/9781484201015.jpg', 'Computer Science', 45),
  (4, '978-1-4842-0382-8', 'https://doi.org/10.1007/978-1-4842-0382-8', 'GUI Design for Android Apps', 'https://link.springer.com/book/10.1007/978-1-4842-0382-8', 'https://images.springer.com/sgw/books/medium/9781484203835.jpg', 'Computer Science', 25),
  (5, '978-3-03897-119-1', '', 'Algorithms for Scheduling Problems', 'https://www.mdpi.com/books/pdfview/book/722', 'http://res.mdpi.com/bookfiles/book/722/Algorithms_for_Scheduling_Problems.jpg', 'Computer Science', 30.00),
  (6, '978-3-319-73524-5', 'https://doi.org/10.1007/978-3-319-73524-5', 'The Plant Stem', 'https://link.springer.com/book/10.1007/978-3-319-73524-5#about', 'https://media.springernature.com/w306/springer-static/cover-hires/book/978-3-319-73524-5', 'Biology', 19.99);

INSERT INTO Author
  (id, surname, forename)
VALUES
  (1, 'De', 'Lakshman Chandra'),
  (2, 'Pathak', 'Promila'),
  (3, 'Rao', 'A. N.'),
  (4, 'Rajeevan', 'P. K.'),
  (5, 'Bradley', 'Beth Rice'),
  (6, 'O’Sullivan', 'Therese'),
  (7, 'Cohen', 'Ryan'),
  (8, 'Wan', 'Tao'),
  (9, 'Werner', 'Frank'),
  (10, 'Burtseva', 'Larysa'),
  (11, 'Sotskov', 'Yuri'),
  (12, 'Schweingruber1', 'Fritz H.'),
  (13, 'Börner', 'Annett');


INSERT INTO AuthorBook
  (author_id, book_id)
VALUES
  (1, 1),
  (2, 1),
  (3, 1),
  (4, 1),
  (5, 2),
  (6, 2),
  (7, 3),
  (8, 3),
  (7, 4),
  (8, 4),
  (9, 5),
  (10, 5),
  (11, 5),
  (12, 6),
  (13, 6);


INSERT INTO USER
  (id, email, password, confirmation_token, enabled)
VALUES
  (1, 'adeczka@onet.eu', 'ada123', '', 'true');

INSERT INTO UserBook
  (user_id, book_id, status, download_date)
VALUES
  (1, 6, 'DOWNLOADED', '2018-03-14'),
  (1, 1, 'FAVORITE', '2018-03-14');

INSERT INTO Favorite
  (user_id, book_id)
VALUES
  (1, 5),
  (1, 1);


INSERT INTO Basket
  (basket_id, user_id, status, realization_date)
VALUES
  (1, 1, 'WAITING', '2018-02-10'),
  (2, 1, 'BOUGHT', '2018-02-10');

INSERT INTO BasketBook
  (basket_id, book_id, user_id)
VALUES
  (1, 3, 1),
  (1, 4, 1),
  (2, 5, 1);
