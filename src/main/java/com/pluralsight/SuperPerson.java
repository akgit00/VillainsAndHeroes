package com.pluralsight;
import java.util.HashMap;

public class SuperPerson {

    //create soe properties for the class
    protected String name;
    protected int health;
    protected int experiencePoints;

    //battle log for tracking hits on opponents
    private HashMap<String, Integer> battleLog = new HashMap<>();


    //the constructor to help create an instance of our Super Person
    public SuperPerson(String name, int health) {
        this.name = name;
        this.health = health;
    }

    //this method is for updating the log entry for a SuperPerson
    public void logHit(SuperPerson opponent) {
        String opponentName = opponent.name;
        int count = battleLog.getOrDefault(opponentName, 0);
        battleLog.put(opponentName, count + 1);
    }

    //this method is for printing the battle log
    public void printBattleLog() {
        System.out.println("\n Battle log for " + name + ":");
        if (battleLog.isEmpty()) {
            System.out.println(" - No hits recorded yet.");
        } else {
            for (HashMap.Entry<String, Integer> entry : battleLog.entrySet()) {
                System.out.println(" - Hit " + entry.getKey() + ": " + entry.getValue() + " times");
            }
        }
    }

    //method to determine if this SuperPerson is alive
    public boolean isAlive(){
        //how can I determine if this thing is alive
        if(this.health > 0){
            return true;
        }else{
            return false;
        }

        //alternate way with one-line of code
        //return this.health > 0;
    }

    //if we take on damage it should lower our health
    public void takeDamage(int amountOfDamage){

        //take the damage hit to the health
        this.health -= amountOfDamage;

        //make sure that if the damage went below 0 we just set it to 0
        if(this.health < 0){
            this.health = 0;
        }
    }

    //this method will allow a SuperPerson to fight another SuperPerson
    public void fight(SuperPerson opponent){
        System.out.println(this.getName() + " is ready to fight: " + opponent.getName());
    }

    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getExperiencePoints() {
        return experiencePoints;
    }

    public void setExperiencePoints(int experiencePoints) {
        this.experiencePoints = experiencePoints;
    }

    //method that allows the SuperPerson to tell us how they are
    public String getStatus(){
        return this.getName() + " has " + this.getHealth() + " health!";
    }

}