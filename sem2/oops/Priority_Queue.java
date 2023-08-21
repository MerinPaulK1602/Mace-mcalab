import java.util.*;

public class Priority_Queue{

	public static void main(String[] args){
	
		PriorityQueue<Student> pq = new PriorityQueue<Student>(5, new StudentComparator());
		
		Student student1 = new Student("Nandini", 3.2);
		
		pq.add(student1);
		
		Student student2 = new Student("Chithra", 6.5);
		
		pq.add(student2);
		
		Student student3 = new Student("Prasanth", 4.0);
		
		pq.add(student3);
		
		Student student4 = new Student("Abin", 6.5);
		
		pq.add(student4);
		
	System.out.println("Students served in their priority order");
	
		while(!pq.isEmpty()){
		
			System.out.println(pq.poll());
			
			//System.out.println(pq.poll().getName());
			
		}
		
	}
	
}



class StudentComparator implements Comparator<Student>{

	public int compare(Student s1,Student s2){
	
		if (s1.cgpa < s2.cgpa)
		
			return 1;
			
		else if (s1.cgpa > s2.cgpa)
		
			return -1;
			
				return 0;
				
	}
		
}

	



class Student{

	public String name;
	
	public double cgpa;
	
	public Student(String name, double cgpa){
	
		this.name = name;
		
		this.cgpa = cgpa;
		
	}
	
	/*public String getName(){
	
		return name;
		
	}
	
	public double getCGPA(){
	
		return cgpa;
		
	} */
	
	public String toString(){
	
		return this.name+" "+this.cgpa;
		
	}
	
}
		
		
