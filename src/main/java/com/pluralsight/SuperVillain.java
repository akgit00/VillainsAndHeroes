package com.pluralsight;

import java.util.Random;

public class SuperVillain extends SuperPerson {

    public SuperVillain(String name, int health, int evilnessLevel) {
        super(name, health);

        this.experiencePoints = evilnessLevel;
    }

    // override the fight method to make villains fight differently
    @Override
    public void fight(SuperPerson opponent) {
        Random rand = new Random();

        // base damage
        int baseDamage = rand.nextInt(101);

        int totalDamage = baseDamage + (this.experiencePoints / 2);

        //10% chance of landing a hard punch
        boolean criticalHit = rand.nextInt(10) == 0;
        if (criticalHit) {
            totalDamage *= 2;
            System.out.println(this.getName() + " unleashes an evil attack on " + opponent.getName() + "!");
        }

        //determine if the attack hits or misses
        if (baseDamage == 0) {
            System.out.println(this.getName() + " tries to strike " + opponent.getName() + " but MISSES!");
        } else {
            System.out.println(this.getName() + " attacks " + opponent.getName() + " with sinister power and deals " + totalDamage + " damage!");

            //apply damage to the opponent
            opponent.takeDamage(totalDamage);

            //this is to log the hit(s) landed
            this.logHit(opponent);

            //villains can steal experience points from their victims if they're still alive
            if (opponent.isAlive()) {
                int stolenXP = rand.nextInt(6); //steal no more than 5 XP
                this.experiencePoints += stolenXP;
                System.out.println(this.getName() + " steals " + stolenXP + " experience points from " + opponent.getName() + "!");
            }
        }
    }
}