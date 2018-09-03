1. SQL
- 테이블명: pay
- 논리적 모델링 속성: 처리번호, 성명, 기본급, 경력, 수당, 급여, 등록 날짜
- 물리적 모델링 컬럼: payno(PK), name, basic, year, sudang, salary, rdate

CREATE TABLE pay(
  payno INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(10) NOT NULL,
  basic INT NOT NULL,
  year INT NOT NULL,
  sudang INT NOT NULL,
  salary INT NOT NULL,
  rdate DATETIME NOT NULL, -- 등록 날짜
  PRIMARY KEY(payno)
);

1) 등록
INSERT INTO pay(name, basic, year, sudang, salary, rdate)
VALUES('왕눈이', 1800000, 1, 200000, (basic + sudang), now());

INSERT INTO pay(name, basic, year, sudang, salary, rdate)
VALUES('아로미', 2000000, 2, 400000, (basic + sudang), now())

2)목록
SELECT payno, name, basic, year, sudang, salary, rdate
FROM pay
ORDER BY payno ASC;

3)조회
SELECT payno, name, basic, year, sudang, salary, rdate
FROM pay
WHERE payno = 1;

4)수정
UPDATE pay
SET name = '김영욱', basic = 3000000, year = 1, sudang = 600000, salary = (basic + sudang)
WHERE payno = 1;

5)삭제
DELETE FROM pay
WHERE payno = 1;