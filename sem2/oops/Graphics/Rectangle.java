/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graphics;

/**
 *
 * @author Merin
 */
import java.util.*;
public class Rectangle implements Properties{
int length;
int breadth;
public void area(){
Scanner sc=new Scanner(System.in);
System.out.println("enter length");
length=sc.nextInt();

System.out.println("enter breadth");
breadth=sc.nextInt();
System.out.println("Area ="+(length*breadth));
}
}