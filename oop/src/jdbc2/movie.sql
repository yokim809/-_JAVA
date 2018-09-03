1. SQL
- ���� �𵨸� �Ӽ�: ��ȭ��ȣ, ����, ����, �⿬, ��� ��¥
- ������ �𵨸� �÷�: movieno, title, good, name, rdate
CREATE TABLE movie(
  movieno INT NOT NULL AUTO_INCREMENT, -- ��ȭ ��ȣ
  title VARCHAR(100) NOT NULL, -- ��ȭ ����(����)
  good FLOAT NOT NULL,  -- ����
  name VARCHAR(30) NOT NULL, -- �⿬
  rdate DATETIME NOT NULL, -- ��� ��¥
  PRIMARY KEY(movieno)
);



1) ���
INSERT INTO movie(title, good, name, rdate)
VALUES('��ŸƮ��(�̵�, 2016)', 10.0, '�޸� �Ƶ���', now());

INSERT INTO movie(title, good, name, rdate)
VALUES('�ϻ�(�ѱ���ȭ, 2015)', 10.0, '������', now());

INSERT INTO movie(title, good, name, rdate)
VALUES('���ͽ��ڶ�(�̵�, 2014)', 10.0, '���ؼ�����', now());

INSERT INTO movie(title, good, name, rdate)
VALUES('���������(�̵�, 2012)', 10.0, '�����', now());

2) ���
SELECT movieno, title, good, name, rdate
FROM movie
ORDER BY movieno DESC;

3) ��ȸ
SELECT movieno, title, good, name, rdate
FROM movie
WHERE movieno = 1;

4) ����
UPDATE movie
SET title = '��Ʋ��Ÿ(�̵�,2004)', good=9.9, name='���̹� ���'
WHERE movieno = 1;

5) ����
SELECT * FROM movie;

DELETE FROM movie
WHERE movieno=3;