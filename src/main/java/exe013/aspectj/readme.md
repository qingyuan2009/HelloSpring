# AspectJ ֧��5�����͵�֪ͨ

1.	@Before ǰ��֪ͨ
2.	@After	����֪ͨ
3.	@AfterReturning	����֪ͨ���������ؽ����ִ��
4.	@AfterThrowing	�쳣֪ͨ
5.	@Around	����֪ͨ��Χ���ŷ���ִ�У��������Ϊǰ�ã����ã����أ��쳣֪ͨ�Ľ����


# POM
<!-- AOP -->
<dependency>
	<groupId>org.springframework</groupId>
	<artifactId>spring-aop</artifactId>
	<version>5.2.1.RELEASE</version>
</dependency>

<dependency>
	<groupId>org.springframework</groupId>
	<artifactId>spring-aspects</artifactId>
	<version>5.2.1.RELEASE</version>
</dependency>

<!-- aspectJ -->
<dependency>
	<groupId>net.sourceforge.cglib</groupId>
	<artifactId>com.springsource.net.sf.cglib</artifactId>
	<version>2.2.0</version>
</dependency>

<dependency>
	<groupId>org.aopalliance</groupId>
	<artifactId>com.springsource.org.aopalliance</artifactId>
	<version>1.0.0</version>
</dependency>

<dependency>
	<groupId>org.aspectj</groupId>
	<artifactId>com.springsource.org.aspectj.weaver</artifactId>
	<version>1.7.2.RELEASE</version>
</dependency>