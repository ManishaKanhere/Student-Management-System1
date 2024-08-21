package com.example.test;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.example.entity.Student;



public class Main {
	static  int choice;
	public static void main(String[] args) {
  Scanner sc=new Scanner(System.in);
  
  
   System.out.println("\n\t--------STUDENT MANAGEMENT SYSTEM-----------\n");
	
	do {
		
		System.out.println("\n\t-----WELCOME TO THE STUDENENT MANAGEMENET SYSTEM---------\n");
		   System.out.println("1. Insert Student record");
           System.out.println("2. View all Student details");
           System.out.println("3. View Student by city name");
           System.out.println("4. Update student details by rollno");
           System.out.println("5. Delete student by rollno");
           System.out.println("6. Search Student on the basis of Min AND Max Percentage");
           System.out.println("7.Search Student on the basis of Percentage");
           System.out.println("8. Display details of 1st Ranker");
           System.out.println("9. Search student details on the basis of email id");
           System.out.println("10. Sort students by percent");
           System.out.println("11. Display list of failed learners");
           System.out.println("12. Exit");
           System.out.print("Enter your choice: ");
           
           
	
           choice = sc.nextInt();
           sc.nextLine();
           
           
           switch(choice) {
           case 1:
        		StudentTest.insertRecord();
        		break;
           case 2:
        	   StudentTest.viewAllStudent();
        	   
        	   break;
        	   
           
           case 3:
        		StudentTest.viewStudentByCity();
        		
        		break;
           case 4:

       		StudentTest. updateByRollNo();
       		break;
           case 5:
        	   StudentTest.deleteRollNo();
        	   break;
           case 6:
        	   StudentTest.searchStudentPercentMinMax(); 
        	   break;
           case 7:
        	   StudentTest.searchStudentPercent();
        	   break;
        	   
           case 8:
        	 StudentTest.firstRanker();
        	   break;
           case 9:
        	   StudentTest.searchStudentsEmailId();
        	   break;
           case 10:
        	   StudentTest.sortStudentPer();
         	   break;
            case 11:
      	     StudentTest.failedStudents();
      	     break;
            case 12:
            	System.out.println("exit!!!!");
            	break;
        	   default:
        		   System.out.println("Invalid choice please try again");
           }}
//           
	while (choice != 12);

      
      sc.close();
    System.out.println("System closed.");

		
		
	
		
           
			
		
//		System.out.println("---- using NamedQuery------ find by student mininmum and maximum percent");
//		 
//		 EntityManager entityManager=JAPUtil.getEntityManager();
//		entityManager.getTransaction().begin();
//
//		Query query = entityManager.createNamedQuery("findByStudent");  //2 step   calling namedQuery
//
//		query.setParameter("min", 50f);  //3 step   setting values for variables
//		query.setParameter("max", 90f);
//
//		List<Student> list = query.getResultList();
//
//		for (Student s: list) {
//
//			System.out.println(s);
//		}
//
//		entityManager.getTransaction().commit();

	}}

