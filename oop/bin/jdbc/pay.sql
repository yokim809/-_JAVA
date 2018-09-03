1. SQL
- ���̺��: pay
- ���� �𵨸� �Ӽ�: ó����ȣ, ����, �⺻��, ���, ����, �޿�, ��� ��¥
- ������ �𵨸� �÷�: payno(PK), name, basic, year, sudang, salary, rdate

CREATE TABLE pay(
  payno INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(10) NOT NULL,
  basic INT NOT NULL,
  year INT NOT NULL,
  sudang INT NOT NULL,
  salary INT NOT NULL,
  rdate DATETIME NOT NULL, -- ��� ��¥
  PRIMARY KEY(payno)
);

1) ���
INSERT INTO pay(name, basic, year, sudang, salary, rdate)
VALUES('�մ���', 1800000, 1, 200000, (basic + sudang), now());

INSERT INTO pay(name, basic, year, sudang, salary, rdate)
VALUES('�Ʒι�', 2000000, 2, 400000, (basic + sudang), now())

2)���
SELECT payno, name, basic, year, sudang, salary, rdate
FROM pay
ORDER BY payno ASC;

3)��ȸ
SELECT payno, name, basic, year, sudang, salary, rdate
FROM pay
WHERE payno = 1;

4)����
UPDATE pay
SET name = '�迵��', basic = 3000000, year = 1, sudang = 600000, salary = (basic + sudang)
WHERE payno = 1;

5)����
DELETE FROM pay
WHERE payno = 1;