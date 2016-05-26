package ru.stqa.pft.sandbox;

/**
 * Created by kompu on 5/25/2016.
 */
public class Calculator {
  public double display = 0;
  public double memory = 0;

  public Calculator(){

  }

  public void type(double x){
    display = x;
  }
  public double add(double x){
    display = display + x;
    return display;
  }
  public double mult(double x){
    display = display * x;
    return display;
  }
  public double div(double x){
    display = display/x;
    return display;
  }
  public void store(){
    memory = display;
  }
  public void restore(){
    display = memory;
  }
  public void clearMemory(){
    memory = 0;
  }
  public void addToMemory(){
    memory = memory + display;
  }
  public void addMemory(){
    display = display + memory;
  }
}
