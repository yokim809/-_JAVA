- ���̺��: maple
- ���� �𵨸� �Ӽ�: ó����ȣ, ������, ��¥, ȸ��, �ο���, �ѱݾ�, ��� ��¥
- ������ �𵨸� �÷�: mapleno(PK), mountain, mapledate, price, count, total, rdate;

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
VALUES('�����', now(), 50000, 4, (price * count), now());

2) ���
SELECT mapleno, mountain, mapledate, price, count, total, rdate
FROM maple
ORDER BY mapleno ASC;

3)��ȸ
SELECT mapleno, mountain, mapledate, price, count, total, rdate
FROM maple
WHERE mapleno = 1;

4)����
UPDATE maple
SET mountain = '�븶��', price = 30000, count = 3, total = (price * count)
WHERE mapleno = 1;

5)����
DELETE FROM maple
WHERE mapleno = 1;