INSERT INTO Author
  (Id, Surname, Forename)
VALUES
  (1, 'Miller', 'Katarzyna'),
  (2, 'Giżyńska', 'Suzan'),
  (3, 'Mickiewicz', 'Adam'),
  (4, 'Nowak', 'Jan'),
  (5, 'Kowalski', 'Adam');

INSERT INTO Book
  (Id, ISBN, bookTitle)
VALUES
  (1, '4444', 'Instrkcja'),
  (2, '3333', 'Pan Tadues'),
  (3, '4523636', 'Ksiazka');


INSERT INTO authorbook
  (author_id, book_id)
VALUES
  (1, 1),
  (1, 2),
  (3, 2),
  (4, 3),
  (5, 3);



