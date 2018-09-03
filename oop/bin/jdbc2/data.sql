1. SQL
- ���� �𵨸� �Ӽ�: ��ȣ, ����, java, html, css3, ����, ���
- ������ �𵨸� �÷�: datano(PK), name, java, html, css3, tot, avg
- ���
  �մ���  80    90  100  270   90
  �Ʒι�  75    89   88   252   84
  ȫ�浿  60    85   77   222   74
  �����  100  90   83   273   91
  �����  91    92   97   280   93
  
  CREATE TABLE data(
    datano INT NOT NULL AUTO_INCREMENT, -- ��ȣ
    name VARCHAR(10) NOT NULL, -- ���� 
    java INT NOT NULL, -- java
    html INT NOT NULL, -- html
    css3 INT NOT NULL, -- css3
    tot INT NOT NULL, -- tot3
    avg INT NOT NULL, -- avg
    PRIMARY KEY(datano)
  );
  
  1) ���
  INSERT INTO data(name, java, html, css3, tot, avg)
  VALUES('�մ���', 80, 90, 100, 270, 90);
  
  INSERT INTO data(name, java, html, css3, tot, avg)
  VALUES('�Ʒι�', 75, 89, 88, 252, 84);
  
  INSERT INTO data(name, java, html, css3, tot, avg)
  VALUES('ȫ�浿', 60, 85, 77, 222, 74);
  
  INSERT INTO data(name, java, html, css3, tot, avg)
  VALUES('�����', 100, 90, 83, 273, 91);
  
  INSERT INTO data(name, java, html, css3, tot, avg)
  VALUES('�����', 91, 92, 97, 280, 93);
  
  INSERT INTO data(name, java, html, css3, tot, avg)
  VALUES('����', 80, 75, 80, (java+html+css3), (tot/3));
  
  2) ���
  SELECT datano, name, java, html, css3, tot, avg
  FROM data
  ORDER BY datano ASC;
  
  3) ��ȸ
  SELECT datano, name, java, html, css3, tot, avg
  FROM data
  WHERE datano = 1;
  
  4) ����
  UPDATE data
  SET name ='�迵��', java = 80, html = 80, css3 = 80, tot = 240, avg = 80
  WHERE datano = 1;
  
  5) ����
  DELETE FROM data
  WHERE datano = 3;