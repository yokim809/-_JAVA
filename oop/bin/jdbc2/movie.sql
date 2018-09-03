1. SQL
- 논리적 모델링 속성: 영화번호, 제목, 평점, 출연, 등록 날짜
- 물리적 모델링 컬럼: movieno, title, good, name, rdate
CREATE TABLE movie(
  movieno INT NOT NULL AUTO_INCREMENT, -- 영화 번호
  title VARCHAR(100) NOT NULL, -- 영화 제목(연도)
  good FLOAT NOT NULL,  -- 평점
  name VARCHAR(30) NOT NULL, -- 출연
  rdate DATETIME NOT NULL, -- 등록 날짜
  PRIMARY KEY(movieno)
);



1) 등록
INSERT INTO movie(title, good, name, rdate)
VALUES('스타트랙(미드, 2016)', 10.0, '메리 맥도넬', now());

INSERT INTO movie(title, good, name, rdate)
VALUES('암살(한국영화, 2015)', 10.0, '전지현', now());

INSERT INTO movie(title, good, name, rdate)
VALUES('인터스텔라(미드, 2014)', 10.0, '앤해서웨이', now());

INSERT INTO movie(title, good, name, rdate)
VALUES('레미제라블(미드, 2012)', 10.0, '휴잭맨', now());

2) 목록
SELECT movieno, title, good, name, rdate
FROM movie
ORDER BY movieno DESC;

3) 조회
SELECT movieno, title, good, name, rdate
FROM movie
WHERE movieno = 1;

4) 수정
UPDATE movie
SET title = '배틀스타(미드,2004)', good=9.9, name='제이미 밤버'
WHERE movieno = 1;

5) 삭제
SELECT * FROM movie;

DELETE FROM movie
WHERE movieno=3;