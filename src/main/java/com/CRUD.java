package com;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class CRUD {

//	public static EntityManager getEntityManager() {
//		
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");//PersistenceUnitName
//		
//		EntityManager em = emf.createEntityManager();
//		
//		return em;
//		
//	}
//	
//	public static EntityTransaction getTransaction() {
//		
//		EntityTransaction et = getEntityManager().getTransaction();
//		
//		return et;
//	}
	public static Patient getPatient() {
		
		return  new Patient();
	}
	static Scanner in = new Scanner(System.in);
	static Scanner str = new Scanner(System.in);
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		
		boolean b = true;
		do {
			System.out.println("1.AddPatient");
			System.out.println("2.FetchPatientData");
			System.out.println("3.UpdatePatient");
			System.out.println("4.DeletePatient");
			System.out.println("5.Exit");
			int ch = in.nextInt();
			switch(ch) {
			case 1:{
				Patient p = getPatient();
				System.out.println("Enter name of Patient ");
				String name = str.nextLine(); 
				p.setPname(name);
				System.out.println("Enter Pno of Patient ");
				Long pno = in.nextLong();
				p.setPpno(pno);
				System.out.println("Enter City of Patient ");
				String city = str.nextLine();
				p.setCity(city);
				System.out.println("Enter Sickness of Patient ");
				String sick = str.nextLine();
				p.setIllness(sick);
				et.begin();
				em.persist(p);
				et.commit();
				System.out.println("Patient Added Successfully");
				break;
			}
			case 2:{
				System.out.println("1.Fetch by Id");
				System.out.println("2.Fetch by Name");
				System.out.println("3.Fetch all");
				int ch1 = in.nextInt();
				switch(ch1) {
				case 1:{
					System.out.println("Enter id to fetch patient");
					int id1 = in.nextInt();
					System.out.println(em.find(Patient.class, id1));
					break;
				}
				case 2:{
					try {
						System.out.println("Enter name to fetch patient");
						String name = str.nextLine();
						Query jpql = em.createQuery("select p from Patient p where p.pname='name'");
						List<Patient> pList = jpql.getResultList();
						for(Patient p : pList) {
							System.out.println(p);
						}
					}catch(Exception e) {
						e.printStackTrace();
						System.out.println("illegal input or no name Present");
					}
					break;
				}
				case 3:{
					
				Query jpql = em.createQuery("select p from Patient p");
				List<Patient> li = jpql.getResultList();
				for(Patient p : li) {
					System.out.println(p);
				}
					
					break;
				}
				default:{System.out.println("Invalid Input");
					break;
				}
				}
				break;
			}
			case 3:{
			
				System.out.println("Enter ID to be Updated ");
				int id = in.nextInt();
				Patient p =em.find(Patient.class, id);
				//System.out.println(p);
				if(p!=null) {
					
						System.out.println("1.UpdateName");
						System.out.println("2.UpdatePhoneNumber");
						System.out.println("3.UpdateCity");
						System.out.println("4.Update Patient");
					
						
						int cho = in.nextInt();
							switch(cho) {
							case 1:{System.out.println("Enter new Name ");
							String name = str.nextLine();
							
							p.setPname(name);
							et.begin();
							em.merge(p);
							et.commit();
							System.out.println("Name Updated Successful");
								break;
							}
							case 2:{
								System.out.println("Enter new PhoneNumber ");
								Long pno = in.nextLong();
								p.setPpno(pno);
								et.begin();
								em.merge(p);
								et.commit();
								System.out.println("PhoneNumber Updated Successful");
								break;
							}
							case 3:{
								System.out.println("Enter new city ");
								String city = str.nextLine();
								p.setCity(city);
								et.begin();
								em.merge(p);
								et.commit();
								System.out.println("City Updated Successful");
								break;
							}
							case 4:{
								
								System.out.println("Enter id to edit existing patient");
								int id1 = in.nextInt();
								Patient p1 =em.find(Patient.class, id1);
								System.out.println("Enter name of Patient ");
								String name = str.nextLine(); 
								p1.setPname(name);
								System.out.println("Enter Pno of Patient ");
								Long pno = in.nextLong();
								p1.setPpno(pno);
								System.out.println("Enter City of Patient ");
								String city = str.nextLine();
								p1.setCity(city);
								System.out.println("Enter Sickness of Patient ");
								String sick = str.nextLine();
								p1.setIllness(sick);
								et.begin();
								em.persist(p1);
								et.commit();
								System.out.println("Patient Updated Successfully");
								break;
							}
						
							default :{System.out.println("invalid Input");
							
							break;
						}
							}
				}else {
					System.out.println("No Id Present ");
				}
				
					break;
			}
			case 4:{
				System.out.println("Enter id to Delete patient");
				int id1 = in.nextInt();
				Patient p1 =em.find(Patient.class, id1);
				if(p1 !=null) {
					et.begin();
					em.remove(p1);
					et.commit();
					System.out.println("Patient Deleted Successfully");
				}else {
					System.out.println("No such Id Present");
				}
				
				break;
			}
			case 5:{System.out.println("ThankYou");
			b = false;
				break;
			}
			default :{System.out.println("invalid Input");
			
				break;
			}
			}
			
		}while(b);
	}
}
