�� /src/jdbc/news.sql
-------------------------------------------------------------------------------------
1. news ���̺��� ���� 
   - PRIMARY KEY(newsno)
     newsno �÷��� ���� ���� 2���̻� ��ϵǴ� ���� ����,
     ���̺����� ���ڵ带 �����ϰ� �����ϴ� ��Ȱ�� ��.
 
   - ���̺��� 1���̻��� PK(Primary Key)�� ������ �־���մϴ�.
     ��) ��ǰ ��ȣ, ��� ��ȣ, �ֹε�� ��ȣ, ��ȭ ��ȣ, ���� ��ȣ,
          ���� �ڵ�, ���� �ڵ�, �μ� �ڵ�...
 
* /mysql56/bin/mysqld.exe�� ���� ���� �� SQL�� ���� �մϴ�.
* -- �ּ� ǥ�� �������� ������ �ѹ��̻� �� ���ϴ�.
 
CREATE TABLE news(        -- news: ���̺���, Excel sheet �̸��� ����
  newsno   INT,                -- �÷�, ���� ���� ��� ��ȣ
  title        VARCHAR(20),  -- �÷�, ����, �ѱ�/����/���� 20�� 
  rdate      DATETIME,       -- �÷�, �����(��¥/�ð�) 
  PRIMARY KEY(newsno)   
);  
-- PRIMARY KEY(newsno): ������ ���� newsno �÷��� �Ҵ� ����
 
-- ������ ���̺� ���: 
SHOW TABLES;
+------------------+
| Tables_in_javadb |
+------------------+
| news               |
+------------------+
 
 
2. ���̺� ����
DROP TABLE news;
  
 
3. ���
   - '': ���ڿ� ���� ���۰� ���Ḧ ��Ÿ���ϴ�.
   - now(): MySQL �Լ�, ���� ��¥�� �ð��� ����ϴ�.
   
1) ��¥�� ����
mysql> SELECT now();
+---------------------+
| now()               |
+---------------------+
| 2015-08-07 19:52:28 |
+---------------------+
 
2) �Ϲ����� ���
    INSERT INTO news(newsno, title, rdate)
    VALUES(1, '�Ѱ� �� ������ �ٽ� �����溸', now());
 
    SELECT * FROM news; -- *: ��� �÷�
+--------+---------------------------------+-----------------------+
| newsno | title                           | rdate                 |
+--------+---------------------------------+-----------------------+
|   1    | �Ѱ� �� ������ �ٽ� �����溸     | 2015-10-06 19:56:52   |
+--------+---------------------------------+-----------------------+    
 
 
3) ""�� ���
   - ���ڿ��� ���۰� ���Ḧ " ' ", " ' "(Single quotation)�� ����մϴ�.
   - java: System.out.println("���ù�� 6����...\"ȿ�� ����\"");
 
   INSERT INTO news(newsno, title, rdate)
   VALUES(2, '���ù�� 6����..."ȿ�� ����"', now());
 
mysql> SELECT * FROM news;
+--------+------------------------------------------+---------------------+
| newsno | title                                    | rdate               |
+--------+------------------------------------------+---------------------+
|      1 | �Ѱ� �� ������ �ٽ� �����溸             | 2015-12-03 19:43:17 |
|      2 | ���ù�� 6����..."ȿ�� ����"             | 2015-12-03 19:47:54 |
+--------+------------------------------------------+---------------------+
 
 
4) " ' "�� ���: \' ǥ��
   INSERT INTO news(newsno, title, rdate)
   VALUES(3, '����3�� �系������ '27�� ��'', now());
 
   You have an error in your SQL syntax; 
   check the manual that corresponds to your MySQL server version
   for the right syntax to use near '27�� ��'', now())' at line 2
 
   INSERT INTO news(newsno, title, rdate)
   VALUES(3, "����3�� �系������ '27�� ��'", now());
 
   INSERT INTO news(newsno, title, rdate)
   VALUES(4, 'ö���ľ� �� ��°..\'82.8%\'', now());
 
mysql> SELECT * FROM news;
+--------+------------------------------------------+---------------------+
| newsno | title                                    | rdate               |
+--------+------------------------------------------+---------------------+
|      1 | �Ѱ� �� ������ �ٽ� �����溸             | 2016-10-25 21:56:25 |
|      2 | ���ù�� 6����..."ȿ�� ����"             | 2016-10-25 22:01:22 |
|      3 | ����3�� �系������ '27�� ��'             | 2016-10-26 19:49:09 |
|      4 | ö���ľ� �� ��°..'82.8%'                | 2016-10-26 19:57:08 |
+--------+------------------------------------------+---------------------+
 
4. ��ȸ ���
   1) ��� �÷��� ��� ���ڵ� ���
      SELECT * FROM news;
+--------+------------------------------------------+---------------------+
| newsno | title                                    | rdate               |
+--------+------------------------------------------+---------------------+
|      1 | �Ѱ� �� ������ �ٽ� �����溸             | 2016-10-25 21:56:25 |
|      2 | ���ù�� 6����..."ȿ�� ����"             | 2016-10-25 22:01:22 |
|      3 | ����3�� �系������ '27�� ��'             | 2016-10-26 19:49:09 |
|      4 | ö���ľ� �� ��°..'82.8%'                | 2016-10-26 19:57:08 |
+--------+------------------------------------------+---------------------+
     
   2) newsno, title �÷��� ����ϰ� newsno �÷��� �������� ��������
      ������ �����մϴ�.
      - ORDER BY newsno ASC: newsno �÷� �������� ���� ���� ���
      - ORDER BY newsno DESC: newsno �÷� �������� ���� ���� ���
      
     SELECT newsno, title
     FROM news
     ORDER BY newsno ASC;
+--------+------------------------------------------+
| newsno | title                                    |
+--------+------------------------------------------+
|      1 | �Ѱ� �� ������ �ٽ� �����溸             |
|      2 | ���ù�� 6����..."ȿ�� ����"             |
|      3 | ����3�� �系������ '27�� ��'             |
|      4 | ö���ľ� �� ��°..'82.8%'                |
+--------+------------------------------------------+
        
  3) newsno �÷��� �������� �������� ������ �����մϴ�.
     - ���� ������ ��ǰ ���� ���
  
     SELECT newsno, title
     FROM news
     ORDER BY newsno DESC;
+--------+------------------------------------------+
| newsno | title                                    |
+--------+------------------------------------------+
|      4 | ö���ľ� �� ��°..'82.8%'                |
|      3 | ����3�� �系������ '27�� ��'             |
|      2 | ���ù�� 6����..."ȿ�� ����"             |
|      1 | �Ѱ� �� ������ �ٽ� �����溸             |
+--------+------------------------------------------+
 
  4) SQL�� ���ٷε� ǥ�� ����(�ĺ��� �� �ȵǾ� ���� �ƴ�)  
     SELECT newsno, title, rdate FROM news ORDER BY newsno DESC;
 
 
5. �Ѱ� ��ȸ
   - ���� �Ѱ��̳� Ư�� ������ ���ڵ带 ����ϴ� ����� ���մϴ�.
   - WHERE ���� Java�� IF���� ���� ����� �մϴ�. 
   - WHERE newsno = 1: newsno �÷��� ���� 1�� ���ڵ� ���
   - WHERE ���� �Ϲ����� ���� �����ڸ� ��� �����մϴ�.
     ��) newsno > 1, newsno < 1, newsno >= 1, newsno <= 1, =, !=
         OR, AND, NOT, <>, ()� ��� ����
   
   SELECT newsno, title
   FROM news
   WHERE newsno = 1;
 
+--------+------------------------------------------+
| newsno | title                                    |
+--------+------------------------------------------+
|        1 | �Ѱ� �� ������ �ٽ� �����溸            |
+--------+------------------------------------------+
 
 
6. ����
   - �÷��� ���� �����մϴ�.
   - WHERE�� ������ ��� ���ڵ尡 ��������� �Ϲ�������
     WHERE�� ����մϴ�.
   
1) ����
   - ��� ���ڵ� ����(���� �ƴ�) 
   UPDATE news
   SET title = '��ġ ���ֱ��� �Ҿ���� ����';
 
   SELECT newsno, title, rdate
   FROM news
   ORDER BY newsno ASC;
+--------+-----------------------------------------+---------------------+
| newsno | title                                   | rdate               |
+--------+-----------------------------------------+---------------------+
|      1 | ��ġ ���ֱ��� �Ҿ���� ����             | 2016-10-25 21:56:25 |
|      2 | ��ġ ���ֱ��� �Ҿ���� ����             | 2016-10-25 22:01:22 |
|      3 | ��ġ ���ֱ��� �Ҿ���� ����             | 2016-10-26 19:49:09 |
|      4 | ��ġ ���ֱ��� �Ҿ���� ����             | 2016-10-26 19:57:08 |
+--------+-----------------------------------------+---------------------+
   
   - Ư�� ���ڵ常 ����(����)
   UPDATE news
   SET title = '���� ��� ���Ǳ� ���...'
   WHERE newsno = 1;
   
2) ������ ���� Ȯ��
   SELECT newsno, title
   FROM news
   WHERE newsno = 1;
+--------+-----------------------------------+
| newsno | title                             |
+--------+-----------------------------------+
|      1 | ���� ��� ���Ǳ� ���...          |
+--------+-----------------------------------+
 
3) 2 �� ���ڵ��� title='�ѹݵ��� ���� 7.0 �߻��� ����' ����
   UPDATE news
   SET title = '�ѹݵ��� ���� 7.0 �߻��� ����'
   WHERE newsno = 2;

4) 3 �� ���ڵ��� title='4�밭 �ٽ� �ڿ�����' ����
   UPDATE news
   SET title = '4�밭 �ٽ� �ڿ�����'
   WHERE newsno = 3;
 
5) 4 �� ���ڵ��� title='������ ����Ʈ�� �ձ�...' ����
   UPDATE news
   SET title = '������ ����Ʈ�� �ձ�...'
   WHERE newsno = 4;
 
  
   SELECT newsno, title
   FROM news
   ORDER BY newsno ASC;
 
 newsno title
 ------ ------------------
      1 ���� ��� ���Ǳ� ���...
      2 �ѹݵ��� ���� 7.0 �߻��� ����
      3 4�밭 �ٽ� �ڿ�����
      4 ������ ����Ʈ�� �ձ�...
    
  
7. ����
   - WHERE ���� �����ϸ� ��� ���ڵ尡 �����˴ϴ�.
    
1) ����
   - ��� ���ڵ� ����(�������� ����)
     DELETE FROM news;
   
   - Ư�� ���ڵ� ����(����)
     DELETE FROM news
     WHERE newsno = 4;
   
2) ���� Ȯ��   
   SELECT newsno, title
   FROM news
   ORDER BY newsno ASC;
 
 newsno title
 ------ ------------------
      1 ���� ��� ���Ǳ� ���...
      2 �ѹݵ��� ���� 7.0 �߻��� ����
      3 4�밭 �ٽ� �ڿ�����
   
3) newsno �÷��� ���� 3�� ���ڵ� ����
DELETE FROM news
WHERE newsno = 3;
 
4) newsno �÷��� ���� 2�� ���ڵ� ����
DELETE FROM news
WHERE newsno = 2;
 
3) newsno �÷��� ���� 1�� ���ڵ� ����
 DELETE FROM news
WHERE newsno = 1;
 
-------------------------------------------------------------------------------------