package com.jm2007.annotation.pre;

public class Dog extends Animal {

	@Override
	public void makeSound() {
		System.out.println("Dog is barking.");
	}

	@Deprecated
	public void move() {
		System.out.println("Dog is running...");
	}
}
