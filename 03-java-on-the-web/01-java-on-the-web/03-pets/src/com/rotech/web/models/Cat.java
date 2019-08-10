package com.rotech.web.models;

public class Cat extends Animal implements Pet{

	public Cat(String name, String breed, Integer weight){
		this.name = name;
		this.breed = breed;
		this.weight = weight;
	}
	@Override
	public String showAffection() {
		if(weight > 25) {
			return name + " sat beside you and purred";
		}
		return name + " hopped into your lap and purred";
	}
}
