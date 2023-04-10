INSERT INTO article(id, title, content)
VALUES(1, '가가가가', '1111');

INSERT INTO article(id, title, content)
VALUES(2, '나나나나', '2222');

INSERT INTO article(id, title, content)
VALUES(3, '다다다다', '3333');

--article 더미 데이터
INSERT INTO article(id, title, content)
VALUES(4, '당신의 인생 영화는?', '댓글 ㄱ');

INSERT INTO article(id, title, content)
VALUES(5, '당신의 소울 푸드는?', '댓글 ㄱㄱ');

INSERT INTO article(id, title, content)
VALUES(6, '당신의 취미는?', '댓글 ㄱㄱㄱ');

--comment 더미 데이터
--4번 게시글의 댓글들
INSERT INTO comment(id, article_id, nickname, body) VALUES (1, 4, 'Park', '굳 윌 헌팅');
INSERT INTO comment(id, article_id, nickname, body) VALUES (2, 4, 'Park', '굳 윌 11헌팅');
INSERT INTO comment(id, article_id, nickname, body) VALUES (3, 4, 'Park', '굳 윌22 헌팅');

--5번 게시글의 댓글들
INSERT INTO comment(id, article_id, nickname, body) VALUES (4, 5, 'Lee', '굳 윌 33헌팅');
INSERT INTO comment(id, article_id, nickname, body) VALUES (5, 5, 'Lee', '굳 윌 44헌팅');
INSERT INTO comment(id, article_id, nickname, body) VALUES (6, 5, 'Lee', '굳 윌55 헌팅');

--6번 게시글의 댓글들
INSERT INTO comment(id, article_id, nickname, body) VALUES (7, 6, 'Kim', '굳 윌 66헌팅');
INSERT INTO comment(id, article_id, nickname, body) VALUES (8, 6, 'Kim', '굳 윌 77헌팅');
INSERT INTO comment(id, article_id, nickname, body) VALUES (9, 6, 'Kim', '굳 윌88 헌팅');