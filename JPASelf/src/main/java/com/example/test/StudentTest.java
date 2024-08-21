package com.example.test;




import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.example.entity.Student;

public class StudentTest {
	
static	Scanner sc=new Scanner(System.in);
	
//private static	EntityManagerFactory entityManerFactory=Persistence.createEntityManagerFactory("PU");
//	 static EntityManager entityManager=entityManerFactory.createEntityManager();  //insted of this  i have to call the the method forJAPUtil
	 public static void insertRecord() {
		
		 System.out.println("Enter the student rollNo");
		 int rollNo=sc.nextInt();
		 System.out.println("Enter the student name");
		 String name=sc.next();
		 System.out.println("Enter the date of birth");
		String dob=sc.next();
		System.out.println("Enter the percent");
		float percent=sc.nextFloat();
		System.out.println("enter the city");
		String city=sc.next();
		System.out.println("enter the email");
		String emailId=sc.next();
		System.out.println("Enter the phone No");
		String phoneNo=sc.next();
		 
		 EntityManager entityManager=JAPUtil.getEntityManager();
		 
		 entityManager.getTransaction().begin();
		
		Student student=new Student(rollNo,name,dob,percent,city,emailId,phoneNo);
		
		entityManager.persist(student);
		entityManager.getTransaction().commit();
		entityManager.close();
		System.out.println(student);
		System.out.println("insert the successfully");
		System.out.println(" ");
	 }
	 
	 public static void  viewAllStudent() {
		 
		 EntityManager entityManager=JAPUtil.getEntityManager();
			entityManager.getTransaction().begin();

			Query query = entityManager.createNamedQuery("viewAllStudents"); 
			
			List<Student> list = query.getResultList();

			for (Student s: list) {

				System.out.println(s);
			}

			entityManager.getTransaction().commit();
			System.out.println("view students data successfully");
			System.out.println(" ");
		 }
		 
		 
		 
		 
	 
	 
	 public static void viewStudentByCity() {
		 
		 EntityManager entityManager=JAPUtil.getEntityManager();
		 Scanner sc=new Scanner(System.in);
		 System.out.println("View the data on the basis of student city");
		 System.out.println("Enter the student city ");
		 String city=sc.next();
		 
		 
		 entityManager.getTransaction().begin();
		Query query = entityManager.createQuery("SELECT s FROM Student s WHERE s.city = :city", Student.class);
	        query.setParameter("city", city);
	        
	        List<Student> students = query.getResultList();
	        
	        if (students.isEmpty()) {
	            System.out.println("No students found in the city: " + city);
	        } else 
	        {
	            for (Student student : students) {
	                System.out.println(student);
	                System.out.println("view student data successfully");
	            }
			
	        }
	         entityManager.getTransaction().commit();
		
		 
		 
		 
		 
	 }
	 public static  void updateByRollNo() {
		 
		 System.out.println("Update the Student DATA on the basis of ROLLNO");
		 
		 EntityManager em=JAPUtil.getEntityManager();
		 Scanner sc=new Scanner(System.in);
		 System.out.println(" Enter the roll no ");
		 int rollNo=sc.nextInt();
		 System.out.println("Enter the updated phone no");
		 String phoneNo=sc.next();
		 System.out.println("Enter the city ");
		 String city=sc.next();
		 
		 em.getTransaction().begin();
		 
		 Student s=em.find(Student.class, rollNo);
		 s.setPhoneNo(phoneNo);
		 s.setCity(city);
		 em.getTransaction().commit();
		 System.out.println("record updated successfully");
		
	 }
	 public static void deleteRollNo() {
		 
	
		 Scanner sc=new Scanner(System.in);
		 System.out.println("Delete the record");
		 System.out.println("Enter the rollNo for delete the record");
		 int rollNo=sc.nextInt();
		 
		 EntityManager entityManager=JAPUtil.getEntityManager();
			entityManager.getTransaction().begin();
		 
		 Student s=entityManager.find(Student.class, rollNo);
		 
		 if (s==null) {
	            System.out.println( rollNo+ "  student rollNo not found in the studentDetails table: ");
	        } else {
	        	
	       	 entityManager.remove(s);
	           
	    	 System.out.println("deleted record successefully");
	            }
			
		 
	
		 entityManager.getTransaction().commit();
	
		 
	 }
	 public static void searchStudentPercent() {
		 System.out.println("---------Search the data on the basis of Percentage");
		 System.out.println("Enter the percentage");
		 float percent=sc.nextFloat();
		 
		 EntityManager entityManager=JAPUtil.getEntityManager();
			entityManager.getTransaction().begin();
			
			Query query = entityManager.createQuery("SELECT s FROM Student s WHERE s.percent= :percent", Student.class);
	        query.setParameter("percent", percent);
	      
	        List<Student> students = query.getResultList();
	        
	        if (students.isEmpty()) {
	            System.out.println("No percentage found in the studentDetails table: " + percent);
	        } else 
	        {
	            for (Student student : students) {
	                System.out.println(student);
	                System.out.println("search  student data successfully on the basis of percentage");
	            }
			
	        }
	         entityManager.getTransaction().commit();
		
		 
		 
		 
			
		 
	 }
		
			
		 
 public static void searchStudentPercentMinMax() {
		 
System.out.println("---- using NamedQuery------ find by student mininmum and maximum percent");
System.out.println("Enter the Min AND Max percentage");
float min=sc.nextFloat();
float max=sc.nextFloat();
		 
		 EntityManager entityManager=JAPUtil.getEntityManager();
		entityManager.getTransaction().begin();

		Query query = entityManager.createNamedQuery("findByStudent");  //2 step   calling namedQuery

		query.setParameter("min", min);  //3 step   setting values for variables
		query.setParameter("max", max);

		List<Student> list = query.getResultList();

		for (Student s: list) {

			System.out.println(s);
		}

		entityManager.getTransaction().commit();
	 }
 
// public static void searchStudentPercent() {
//	 System.out.println("View the data on the basis of student percent");
//	 System.out.println("Enter the student percent");
//	 String percent=sc.next();
//	 
//	 EntityManager entityManager=JAPUtil.getEntityManager();
//		entityManager.getTransaction().begin();
//		
//		Query query = entityManager.createQuery("SELECT s FROM Student s WHERE s.percent = :percent", Student.class);
//        query.setParameter("percent", percent);
//        
//        List<Student> students = query.getResultList();
//        
//        if (students.isEmpty()) {
//            System.out.println("No students found this percent: " + percent);
//        } else 
//        {
//            for (Student student : students) {
//                System.out.println(student);
//                System.out.println("view student data successfully");
//            }
//		
//        }
//         entityManager.getTransaction().commit();
//	
//	 
//	 
//
// }

public static void firstRanker() {
	
	 EntityManager entityManager=JAPUtil.getEntityManager();
		entityManager.getTransaction().begin();
		
		Query query = entityManager.createQuery("SELECT s FROM Student s order by s.percent desc", Student.class);
          query.setMaxResults(1);
         Object studentRank= query.getSingleResult();
         entityManager.getTransaction().commit();
         System.out.println(studentRank);
         System.out.println();
//      
		
		

	
	
}

public static void searchStudentsEmailId() {
	System.out.println("Enter the emailId");
	String emailId=sc.nextLine();

	 EntityManager entityManager=JAPUtil.getEntityManager();
		entityManager.getTransaction().begin();
		
		Query query = entityManager.createQuery("SELECT s FROM Student s WHERE s.emailId= :emailId", Student.class);
        query.setParameter("emailId", emailId);
        
        List<Student> students = query.getResultList();
        
        if (students.isEmpty()) {
            System.out.println("No students found in this email: " + emailId);
        } else 
        {
            for (Student student : students) {
                System.out.println(student);
                System.out.println("search  student data successfully on the basis of emailId");
            }
		
        }
         entityManager.getTransaction().commit();
	
}
public static void sortStudentPer() {
	 EntityManager entityManager=JAPUtil.getEntityManager();
		entityManager.getTransaction().begin();
		Query query=entityManager.createQuery("select s from Student s order by  s.percent ");
		List<Student> student=query.getResultList();
		System.out.println("Sorting in asending order by percent:");
		
		for(Student students:student) {
			System.out.println(students);
		}
		entityManager.getTransaction().commit();
}
public static void failedStudents() {
	 EntityManager entityManager=JAPUtil.getEntityManager();
		entityManager.getTransaction().begin();
		Query query=entityManager.createQuery("select s from Student s where s.percent<:percent",Student.class);
		query.setParameter("percent", 35f);
		
		   List<Student> students = query.getResultList();
		   
		   if (students.isEmpty()) {
	            System.out.println("failde: ");
	        } else 
	        {
	            for (Student student : students) {
	                System.out.println(student);
	                System.out.println("");
		 
		     }
		     entityManager.getTransaction().commit();
		   
	
}

}
		 
		 
		 
}
	 
		
		
	 
	 


	
