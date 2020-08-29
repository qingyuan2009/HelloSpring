#��Դ
Spring-�����ݶ��ư�-�й��-spring - java

# HelloSpring

���Bean���õ�xml�ļ�

# ʹ��annotation

*	@Component: ��IOC������������
*	@Repository: ��IOC��������ĳ־û������
*	@Servic: ��IOC���������ҵ���߼������
*	@Controller: ��IOC��������ı�������������

��4��ע��ʹ����û�����𣬿��Զ�ʹ��@Component, ����ֻ�������ڹ������

# MVC

*	��ͼ��/�����㣺 MVC
	V����ͼ��  JSP...
	C�����Ʋ㣬����̨����ͨ��ģ�Ͳ㷵�ظ���ͼ  --> @Controller
	M��ģ�Ͳ�
*	ҵ���߼���: service  --> @Service
*	���ݷ��ʲ�/�־ò㣺 DAO  --> @Repository

Controller(MVC) <-> Service <-> DAO

# Autowired
ע�������Y��ͨ�^�ӿ��{��bean
Autowired������byType, Ȼ������byName

**@Repository("dao")**   //ָ��IDֵ
**@Autowired(required=false)**  // required=false, ���b����b�䣬����Ҳ���󮐳�
**@Qualifier("userJDBCImpl")**  // ���Ԅ��b����ָ����Ҫ�b������
private UserDAO dao;

# �ӑB����
1.	��춽ӿڌ��F�ӑB���� JDK
2.	����^�Ќ��F�ӑB���� Cglib, Javassist

//�ӑB������ǄӑB���ɵģ� Ĭ�J����memory�У� �@�Y���԰������浽Ӳ�P
Properties properties = System.getProperties();
properties.put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
//����com�ļ��A�п������ɵĴ���� $Proxy0.class

# AOP
1.	���й�ע�㣺 ��ÿ�������г�ȡ������ͬһ��Ǻ���ҵ�� ���緽���е�ǰ�ú�����־����
2.	����(Aspect): ��װ���й�ע����Ϣ���࣬ÿ����ע������Ϊһ��֪ͨ����
3.	֪ͨ(Advice)���������Ҫ��ɵĸ������幤��
4.	Ŀ��(Target): ��֪ͨ�Ķ���
5.  ����(Proxy)�������Ĵ������
6.	���ӵ�(JointPoint): ���й�ע�����ʵ���ڶ�Ӧ�����е�λ�á��ݺ����꣺
	�����꣺������ ����add(int i, int j), sub, multiple, divid...
	�����꣺������ʼ�������쳣�� ��������
7.	�����(PointCut): ����־�������������ӵ㣬����ζ�����������

# AspectJ

# Spring��JDBC��֧��
Ϊ��ʹJDBC��������ʹ�ã�Spring��JDBC API�϶�����һ������㣬�Դ˽���һ��JDBC��ȡ���
Spring�ṩJDBCTemplate, ��DAO Util����

# �������
1.	DataSourceTransactionManager: JDBC
2.	JtaTransactionManager: J2EE
3.	HibernateTransactionManager: Hibernate

�������ԣ�����Spring transaction�����ԣ� ������JDBC����Ϊ
   1.  ���񴫲���Ϊ�� һ��������һ���������ʱ����ǰ���������ʹ������
            Propagation.REQUIRED  Ĭ��, ʹ�õ����ߵ����� ����ȫ�����������һ��
            Propagation.REQUIRES_NEW  �������ߵ�����������¿���������ʹ�ã� ����ȫ�����񲢲�����
   2.  ����ĸ��뼶�� 
            1 -> ��δ�ύ�����Զ����������δ�ύ������  A�� 50��Ϊ30δ�ύ�� B������AΪ30�� A����rollback�� ��������
            2 -> �����ύ  A�� 50��Ϊ30��δ�ύ�� B������A����Ϊ50�� ����ɲ����ظ���������
            4 -> ���ظ���  A�� ��5�����ݣ� B������5���� C����A�µ�3�����ݣ� B�ظ��������8�����ݣ� �ö�
            8 -> ���л�  A�������ݿ�ʱ�� B���ܲ����� ����Ҫ��A��������ȫ����Ч�ʵ͵�����
                     ��õ��� 2�� �����ύ�� MySQL Ĭ����4�����ظ��� 
   3.  Rollback�� 
            rollbackFor: ��ʲô�쳣����ʱrollback
            rollbackForClassName
            noRollbackFor�� ��ʲô�쳣����ʱ ���ع�
            norollbackForCalssName
   4.  �����ֻ������
            readOnly
                true: ����ֻ���� �û�����ֻ������ݿ���ж�ȡ�� �����޸ģ��������ݿⲻ��������Ż�Ч��
                false�� ��ֻ�� �� Ĭ��
   5.  ����ĳ�ʱ���ã� ǿ�ƻع�֮ǰ���õ�ʱ��



