package com.bridgelabz.HQLDemo;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Configuration config = new Configuration().addAnnotatedClass(Student.class).configure("hibernate.cfg.xml");
		ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(config.getProperties())
				.buildServiceRegistry();
		SessionFactory factory = config.buildSessionFactory(registry);
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		/**
		 * FOR ADDING DATA TO DATABASE
		 */
//		Random randomNumber = new Random();
//		for (int i = 1; i <= 50; i++) {
//			Student stud = new Student();
//			stud.setRollNum(i);
//			stud.setName("Student" + i);
//			stud.setMarks(randomNumber.nextInt(100));
//			session.save(stud);
//		}

		/**
		 * FOR FETCHING DATA USING HQL QUERIES
		 */
//		Query hql = session.createQuery("from Student where rollNum = :b");
//		hql.setParameter("b", 5);
//		List<Student> students = hql.list();
//		for (Student studs : students) {
//			System.out.println(studs);
//		}

		// Selecting/Fetching the Columns
//		Query hql = session.createQuery("select rollNum, name, marks from Student where rollNum = 7");
//		Object[] student = (Object[]) hql.uniqueResult();
//		System.out.println(student[0] + " : " + student[1] + " : " + student[2]);

		// Fetching the table
		Query hql = session.createQuery("select rollNum, name, marks from Student");
		List<Object[]> students = (List<Object[]>) hql.list();
		for (Object[] stud : students) {
			System.out.println(stud[0] + " : " + stud[1] + " : " + stud[2]);
		}

		/**
		 * FETCHING DATA USING SQL
		 */
//		SQLQuery sql = session.createSQLQuery("select * from HQL_Student where marks > 50");
//		sql.addEntity(Student.class);
//		List<Student> students = sql.list();
//		for (Student stud : students) {
//			System.out.println(stud);
//		}

		// Native Query
//		SQLQuery sql = session.createSQLQuery("select name, marks from HQL_Student where marks > 50");
//		sql.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
//		List students = sql.list();
//		for (Object s : students) {
//			Map m = (Map) s;
//			System.out.println(m.get("name") + " : " + m.get("marks"));
//		}
		tx.commit();
	}
}
