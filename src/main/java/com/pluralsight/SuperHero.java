package com.pluralsight;

import java.util.Random;

public class SuperHero extends SuperPerson{

    public SuperHero(String name, int health, int powerLevel){
        //since the parent knows what to do with this data, pass it to the parent constructor
        super(name, health);

        //deal with the custom hero stuff
        this.experiencePoints = powerLevel;
    }

    @Override
    public void fight(SuperPerson opponent){

        //generate a random number of damage to do
        Random rand = new Random();
        //return a whole number between 0 and 101 inculusive of the 0 but not the 101 (0-100)
        int baseDamage = rand.nextInt(101);

        //lets make the total damage interesting by taking into account our experiencePoints
        int totalDamage = baseDamage + this.experiencePoints;

        //determine if we missed or hit based on the baseDamage
        //if we got a 0 for the base damage we missed
        //otherwise we landed our attack on our opponent and took the damage away from their health
        if(baseDamage == 0){
            System.out.println(this.getName() + "  Swings heroically and misses because that happens sometimes");
        }else{
            System.out.println(this.getName() + " lands a super punch on  " + opponent.getName() + " and caused " + totalDamage + " damage");

            //actually cause the damage to the opponent
            opponent.takeDamage(totalDamage);
        }

    }

}