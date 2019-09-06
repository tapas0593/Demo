package com.bridgelabz.myfirstspringhib;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class App {
	public static void main(String[] args) {
		Laptop laptop = new Laptop();
		laptop.setLaptopName("HP");
		laptop.setLid(102);

		Student student = new Student();
		StudentName name = new StudentName();
		name.setFirstName("Neil");
		name.setMidName("Nitin");
		name.setLastName("Mukesh");

		/*
		 * When there is OneToMany relationship. One Student can have many laptops
		 */
//		laptop.setStudent(student);

		/*
		 * When there is ManyToMay relationship. Many Students can have multiple Laptops
		 * and vice-versa
		 */
		laptop.getStudent().add(student);

		student.setAid(111);
		student.setName(name);
		student.setAddress("Mumbai");
		student.getLaptop().add(laptop);

		Configuration config = new Configuration().configure().addAnnotatedClass(Student.class)
				.addAnnotatedClass(Laptop.class);

		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();

		/*
		 * The method buildSessionFactory() from the type Configuration is deprecated
		 * 
		 * SessionFactory f = config.buildSessionFactory();
		 */
		SessionFactory factory = config.buildSessionFactory(reg);

		Session session = factory.openSession();

		Transaction tx = session.beginTransaction();

		/*
		 * To save data to DB
		 */
		session.save(student);
		session.save(laptop);

		/*
		 * To fetch data from DB
		 */
//		student = (Student) session.get(Student.class, 001);
		tx.commit();

	}
}
