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
public class Square implements Properties{
int side;
public void area(){
Scanner sc=new Scanner(System.in);
System.out.println("enter side");
side=sc.nextInt();
System.out.println("Area ="+(side*side));
}
}