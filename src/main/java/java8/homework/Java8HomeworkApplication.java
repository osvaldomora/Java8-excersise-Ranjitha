package java8.homework;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java8.homework.three.database.Course;
import java8.homework.three.database.Student;
import java8.homework.three.database.StudentRepository;


@SpringBootApplication
public class Java8HomeworkApplication implements CommandLineRunner {

	@Autowired
	SessionFactory sFactory;
	
	@Autowired
	private StudentRepository stR;

	public static void main(String[] args) {
		SpringApplication.run(Java8HomeworkApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		save();
		getElements();

	}

	private void getElements() {
		


		List<Student> st1 = stR.findAll();

		System.out.println("Get all student details based on given course input");
		st1.stream().map(courses -> courses.getCourses()).flatMap(c -> c.stream())
				.filter(c -> c.getName().equals("html")).forEach(x -> System.out.println(x));

		System.out.println("Get the average score of all students for any given course");
		Double avg = st1.stream().map(courses -> courses.getCourses()).flatMap(c -> c.stream())
				.filter(c -> c.getName().equals("html")).map(x -> x.getAverage()).mapToInt(x -> x).average()
				.getAsDouble();

		System.out.println(avg);
		
		

	
		
		
	}

	private void save() {

		Session session = sFactory.openSession();
		try {
			Calendar c = Calendar.getInstance();
			c.setTime(new Date()); // Now use today date.
			c.add(Calendar.DATE, 50);

			Calendar c2 = Calendar.getInstance();
			c2.setTime(new Date()); // Now use today date.
			c2.add(Calendar.DATE, 100);

			Calendar c3 = Calendar.getInstance();
			c3.setTime(new Date()); // Now use today date.
			c3.add(Calendar.DATE, 150);

			Course co1 = Course.builder().name("html").id(1L).average(8).dateBegin(new Date()).dateEnd(c.getTime()).build();
			c.add(Calendar.DATE, 10);
			Course co2 = Course.builder().name("java8").id(2L).average(9).dateBegin(c.getTime()).dateEnd(c2.getTime()).build();
			c.add(Calendar.DATE, 5);
			Course co3 = Course.builder().name("sql").id(3L).average(10).dateBegin(c2.getTime()).dateEnd(c3.getTime()).build();

			List<Course> lc1 = Arrays.asList(co1, co2, co3);
			List<Course> lc2 = Arrays.asList(co1, co2);
			List<Course> lc3 = Arrays.asList(co1);

			Student s1 = Student.builder().name("lupe").courses(lc3).build();
			Student s2 = Student.builder().name("leo").courses(lc1).build();
			Student s3 = Student.builder().name("casimira").courses(lc2).build();

			session.beginTransaction();

			session.save(co1);
			session.save(co2);
			session.save(co3);
			session.save(s1);
			session.save(s2);
			session.save(s3);
			session.getTransaction().commit();

			session.close();// close session
//			sFactory.close();
		} catch (Exception e) {
			System.out.println("Error was made");
			e.printStackTrace();
		}

	}

}
