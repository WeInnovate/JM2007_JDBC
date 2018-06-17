package com.jm2007.annotation.pre;

public class App {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Dog dog = new Dog();
		dog.eat();
		dog.makeSound();
		dog.move();
	}

}
