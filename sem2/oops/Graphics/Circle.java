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
public class Circle implements Properties{
int radius;
public void area(){
Scanner sc=new Scanner(System.in);
System.out.println("enter radius");
radius=sc.nextInt();
System.out.println("Area ="+(3.14*radius*radius));
}
}