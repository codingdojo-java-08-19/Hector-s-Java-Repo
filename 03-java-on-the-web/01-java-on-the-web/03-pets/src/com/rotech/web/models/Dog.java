package com.rotech.web.models;

public class Dog extends Animal implements Pet{

	public Dog(String name, String breed, int weight){
		this.name = name;
		this.breed = breed;
		this.weight = weight;
	}
	@Override
	public String showAffection() {
		if(weight > 25) {
			return name + " sat beside you and cuddled with you";
		}
		return name + " hopped into your lap and cuddled with you";
	}
}
