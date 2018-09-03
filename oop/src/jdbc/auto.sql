�� /src/jdbc/auto.sql
-------------------------------------------------------------------------------------
1. ���̺� ����
CREATE TABLE sungjuk(
  hakno INT NOT NULL AUTO_INCREMENT, -- ���� �Ϸ� ��ȣ
  name  VARCHAR(10) NOT NULL, -- �ʼ� �Է�
  grade  INT                     NULL,   -- NULL�� ���� ����
  PRIMARY KEY(hakno)                 -- �ߺ��� ���� ���� �ȵ�.
);   
 
DROP TABLE sungjuk;
 
 
2. �ǽ�
 
1) �ڵ� ���� �÷�(hakno)�� ��Ͻ� �÷����� ������� �ʽ��ϴ�.
INSERT INTO sungjuk(name, grade)
VALUES('�մ���', 3);
 
-- WHERE���� �������� ��� ���ڵ� ���, *�� ��� �÷�
SELECT * FROM sungjuk;
+-------+-----------+-------+
| hakno | name      | grade |
+-------+-----------+-------+
|   1      | �մ���    |   3   |
+-------+-----------+-------+
 
2) grade �÷��� NULL �Ӽ��� �����Ǿ��־� ���� ������.
- NULL: �÷��� ������ �Է��� �߻��� ���� ����. 
 
INSERT INTO sungjuk(name)
VALUES('�Ʒι�');
 
SELECT * FROM sungjuk;
+-------+-----------+-------+
| hakno | name      | grade |
+-------+-----------+-------+
|     1   | �մ���     |     3    |
|     2   | �Ʒι�     |  NULL |
+-------+-----------+-------+
 
 
INSERT INTO sungjuk(name)
VALUES('ȫ�浿');
 
SELECT * FROM sungjuk;
+-------+-----------+-------+
| hakno | name      | grade |
+-------+-----------+-------+
|     1 | �մ���    |     3 |
|     2 | �Ʒι�    |  NULL |
|     3 | ȫ�浿    |  NULL |
+-------+-----------+-------+
 
INSERT INTO sungjuk(name)
VALUES('�����');
 
SELECT * FROM sungjuk;
+-------+-----------+-------+
| hakno | name      | grade |
+-------+-----------+-------+
|     1 | �մ���    |     3 |
|     2 | �Ʒι�    |  NULL |
|     3 | ȫ�浿    |  NULL |
|     4 | �����    |  NULL |
+-------+-----------+-------+
 
 
3. NOT NULL �÷��� name�� ������ ���
INSERT INTO sungjuk(grade)
VALUES(2);
 
- ���� �޽���
ERROR 1364 (HY000): Field 'name' doesn't have a default value
 
- NOT NULL �÷��� insert�ÿ� �ݵ�� ���� �־�� �մϴ�.
 
 
3. AUTO_INCREMENT�� �߻��� ���ڰ� �����Ǿ ó�� ���·�
   ���� �Ұ����մϴ�. �ߺ��� �߻��� ���ϱ����� ������ �մϴ�.
 
DELETE FROM sungjuk
WHERE hakno = 4;
 
SELECT * FROM sungjuk;
+-------+-----------+-------+
| hakno | name      | grade |
+-------+-----------+-------+
|     1 | �մ���    |     3 |
|     2 | �Ʒι�    |  NULL |
|     3 | ȫ�浿    |  NULL |
+-------+-----------+-------+
 
INSERT INTO sungjuk(name, grade)
VALUES('������', 1);
 
SELECT * FROM sungjuk;
+-------+-----------+-------+
| hakno | name      | grade |
+-------+-----------+-------+
|     1 | �մ���    |     3 |
|     2 | �Ʒι�    |  NULL |
|     3 | ȫ�浿    |  NULL |
|     5 | ������    |     1 |
+-------+-----------+-------+
 
-------------------------------------------------------------------------------------
