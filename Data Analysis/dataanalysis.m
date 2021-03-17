%% Load Data
books = readtable('workspaceCSCI4830-techproject-Sossa\techprojectCSCI4830-Sossa\target\BookRecommender\WEB-INF\good_reads_final.csv');

%% Clean Data
books.author_gender = strrep(books.author_gender, 'male', 'Male');
books.author_gender = strrep(books.author_gender, 'female', 'Female');
books.author_gender = strrep(books.author_gender, 'feMale', 'Female');

books(:, {'book_id', 'author_genres', 'author_id'}) = [];

books = convertvars(books, {'author_gender', 'author_name', 'author_page_url', 'birthplace', 'book_fullurl', 'book_title', 'genre_1', 'genre_2'}, 'categorical');

books = books(books.publish_date >= 1900, :);