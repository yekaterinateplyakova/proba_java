package ru.stqa.pft.sandbox;

/**
 * Created by kompu on 5/24/2016.
 */
public class Transpander {
  public double truckPrice;
  public double busPrice;
  public double carPrice;
  public int countTruck = 0;
  public int countBus = 0;
  public int countCar = 0;
  public double sum = 0;

  public Transpander(double truckPrice, double busPrice, double carPrice){
    this.truckPrice = truckPrice;
    this.busPrice = busPrice;
    this.carPrice = carPrice;
  }

  public void truck(){
    countTruck = countTruck + 1;
    sum = sum + truckPrice;
  }

  public void bus(){
    countBus = countBus + 1;
    sum = sum + busPrice;
  }
  public void car(){
    countCar = countCar + 1;
    sum = sum + carPrice;
  }

  public int getTruckCount(){
    return this.countTruck;
  }
  public int getBusCount(){
    return this.countBus;
  }

  public int getCarCount(){
    return this.countCar;
  }

  public double getTotalSum(){
    return sum;
  }

  public double getTotalCount(){
    return getBusCount() + getCarCount() + getTruckCount();
  }

//  транспондер на платной автотрассе
//  у него будет конструктор, который принимает три параметра и задаёт стоимость проезда грузовика, автобуса, легковушки
//  у него будут методы
//  truck() -- оплатить проезд грузовика
//  bus() -- оплатить проезд автобуса
//  car() -- оплатить проезд легковушки
//  и набор методов, которые выдают подсчитанные данные:
//  getTruckCount()
//  getBusCount()
//  getCarCount()
//  getTotalCount()
//  getTotalSum()


}
