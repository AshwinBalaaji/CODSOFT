import java.util.*;
public class Main
{
	public static void main(String[] args) {
	    Scanner sc=new Scanner(System.in);
	    System.out.println("Enter No of students:");
	    int n=sc.nextInt();
	    for(int k=0;k<n;k++){
	    System.out.println("Student Name:");
	    String s=sc.next();
	    System.out.println("Student Roll Number:");
	    int roll=sc.nextInt();
	    System.out.println("Enter No of subjects:");
	    int sub=sc.nextInt();
	    int arr[]=new int[sub];
	    for(int i=0;i<sub;i++)
	    {
	        System.out.println("Enter subject "+(i+1)+" marks:");
	        arr[i]=sc.nextInt();
	    }
	    int total=0;
	    for(int i=0;i<sub;i++)
	    {
	        total+=arr[i];
	    }
	    
	    String grade="";
	    float avg=(total)/(sub);
	   if(avg>90 && avg<=100)
	   {
	       grade="O";
	   }
	   else if(avg>80 && avg<=90)
	   {
	       grade="A";
	   }
	   else if(avg>70 && avg<=80)
	   {
	       grade="A+";
	   }
	   else if(avg>60 && avg<=70)
	   {
	       grade="B";
	   }
	   else if(avg>50 && avg<=60)
	   {
	       grade="B+";
	   }
	   else if(avg>40 && avg<=50)
	   {
	       grade="C";
	   }
	   System.out.println("The Name of the Student is "+s);
	   System.out.println("The roll no of the Student is "+roll);
	   System.out.println("The no of subjects is "+sub);
	   System.out.println("The Total Marks of the Student is "+total);
	   System.out.println("The Average Marks of the Student is "+avg);
	   System.out.println("The Grade of the Student is: "+ grade);
	   System.out.println("End of the "+(k+1)+" student");
	   System.out.println();
	   }
	   System.out.println("End of Program");
	}
}
