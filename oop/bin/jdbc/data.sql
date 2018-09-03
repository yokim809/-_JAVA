1. SQL
- 논리적 모델링 속성: 번호, 성명, java, html, css3, 총점, 평균
- 물리적 모델링 컬럼: datano(PK), name, java, html, css3, tot, avg
- 목록
  왕눈이  80    90  100  270   90
  아로미  75    89   88   252   84
  홍길동  60    85   77   222   74
  가길순  100  90   83   273   91
  나길순  91    92   97   280   93
  
  CREATE TABLE data(
    datano INT NOT NULL AUTO_INCREMENT, -- 번호
    name VARCHAR(10) NOT NULL, -- 성명 
    java INT NOT NULL, -- java
    html INT NOT NULL, -- html
    css3 INT NOT NULL, -- css3
    tot INT NOT NULL, -- tot3
    avg INT NOT NULL, -- avg
    PRIMARY KEY(datano)
  );
  
  1) 등록
  INSERT INTO data(name, java, html, css3, tot, avg)
  VALUES('왕눈이', 80, 90, 100, 270, 90);
  
  INSERT INTO data(name, java, html, css3, tot, avg)
  VALUES('아로미', 75, 89, 88, 252, 84);
  
  INSERT INTO data(name, java, html, css3, tot, avg)
  VALUES('홍길동', 60, 85, 77, 222, 74);
  
  INSERT INTO data(name, java, html, css3, tot, avg)
  VALUES('가길순', 100, 90, 83, 273, 91);
  
  INSERT INTO data(name, java, html, css3, tot, avg)
  VALUES('나길순', 91, 92, 97, 280, 93);
  
  INSERT INTO data(name, java, html, css3, tot, avg)
  VALUES('영욱', 80, 75, 80, (java+html+css3), (tot/3));
  
  2) 목록
  SELECT datano, name, java, html, css3, tot, avg
  FROM data
  ORDER BY datano ASC;
  
  3) 조회
  SELECT datano, name, java, html, css3, tot, avg
  FROM data
  WHERE datano = 1;
  
  4) 수정
  UPDATE data
  SET name ='김영욱', java = 80, html = 80, css3 = 80, tot = 240, avg = 80
  WHERE datano = 1;
  
  5) 삭제
  DELETE FROM data
  WHERE datano = 3;