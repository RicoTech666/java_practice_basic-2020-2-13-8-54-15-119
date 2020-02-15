package com.thoughtworks;

import java.util.Scanner;

public class App {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();
    Restaurant restaurant = new Restaurant();
    System.out.println(restaurant.bestCharge(input));
  }
}
