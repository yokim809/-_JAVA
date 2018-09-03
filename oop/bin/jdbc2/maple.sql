- 테이블명: maple
- 논리적 모델링 속성: 처리번호, 목적지, 날짜, 회비, 인원수, 총금액, 등록 날짜
- 물리적 모델링 컬럼: mapleno(PK), mountain, mapledate, price, count, total, rdate;

CREATE TABLE maple(
  mapleno INT NOT NULL AUTO_INCREMENT,
  mountain VARCHAR(10) NOT NULL,
  mapledate DATE NOT NULL,
  price INT NOT NULL,
  count INT NOT NULL,
  total INT NOT NULL,
  rdate DATETIME NOT NULL,
  PRIMARY KEY(mapleno)
);

INSERT INTO maple(mountain, mapledate, price, count, total, rdate)
VALUES('내장산', now(), 50000, 4, (price * count), now());

2) 목록
SELECT mapleno, mountain, mapledate, price, count, total, rdate
FROM maple
ORDER BY mapleno ASC;

3)조회
SELECT mapleno, mountain, mapledate, price, count, total, rdate
FROM maple
WHERE mapleno = 1;

4)수정
UPDATE maple
SET mountain = '용마산', price = 30000, count = 3, total = (price * count)
WHERE mapleno = 1;

5)삭제
DELETE FROM maple
WHERE mapleno = 1;