INSERT INTO Book
  (id, ISBN, bookTitle, DOI, adressURL, photo, subject )
VALUES
  (1, '9780870740114', 'Backwoods to Border', '', 'https://digital.library.unt.edu/ark:/67531/metadc38306/m1/3/sizes/', '', 'Anthropology' ),
 b (2, '9782889198177' 'The Bacterial Cell: Coupling between Growth, Nucleoid Replication, Cell Division and Shape', '10.3389/978-2-88919-817-7', 'https://www.frontiersin.org/research-topics/2905/the-bacterial-cell-coupling-between-growth-nucleoid-replication-cell-division-and-shape', '', 'Microbiology'),
  (3, '9783038973690', 'Dairy Products', '', 'https://www.mdpi.com/books/pdfview/book/1041', '', 'Animal Sciences'),
  (4, '9781441122810', 'Wag the Dog', '', 'https://www.doabooks.org/doab?func=fulltext&uiLanguage=en&rid=27279', '', 'Performing Arts'),
  (5, '9781926836591', 'Working People in Alberta: A History', '', 'http://www.aupress.ca/index.php/books/120194', 'http://www.aupress.ca/books/120194/images/cover.jpg', 'History'),
  (6, '9781927356067', 'The Wages of Relief: Cities and the Unemployed in Prairie Canada, 1929', '', '', 'https://www.doabooks.org/doab?func=cover&rid=15431', 'History'),

INSERT INTO Author
  (id, surname, forename)
VALUES
  (1, 'Boatright/Day', ''),
  (2, 'Zaritsky', 'Arieh'),
  (3, 'Woldringh', 'Conrad L'),
  (4, 'Mannik', 'Jaan' ),
  (5, 'Bradley', 'Beth'),
  (6, 'O’Sullivan', 'Therese'),
  (7, 'Thanouli ', ''),
  (8, 'Eleftheria', ''),
  (9,  'Strikwerda', 'Eric'),
  (10, 'Finkel', 'Alvin')




INSERT INTO AuthorBook
  (authorID, bookID)
VALUES
  (1, 1),
  (2, 2),
  (3, 2),
  (4, 2),
  (5, 3),
  (6, 3),
  (9, 5),
  (10, 5),


