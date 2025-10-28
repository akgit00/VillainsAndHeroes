package com.pluralsight;

public class ShowdownApp {

    public static void main(String[] args) {

        // Create our combatants
        SuperHero hero = new SuperHero("Jefre (just a regular guy)", 250, 20);
        SuperVillain villain = new SuperVillain("Batman", 230, 25);

        System.out.println(" Welcome to the Battle Arena! ");
        System.out.println("=====================================");
        System.out.println(hero.getName() + " VS " + villain.getName());
        System.out.println("=====================================\n");

        int round = 1;

        //display the current round of the fight
        while (hero.isAlive() && villain.isAlive()) {
            System.out.println("----- ROUND " + round + " -----");

            hero.fight(villain);
            System.out.println(villain.getStatus());

            //see if the villain is still alive
            if (!villain.isAlive()) {
                System.out.println(villain.getName() + " has been defeated!");
                System.out.println(hero.getName() + " is the winner!");
                break;
            }

            villain.fight(hero);
            System.out.println(hero.getStatus());

            // Check if hero is still alive
            if (!hero.isAlive()) {
                System.out.println(hero.getName() + " has fallen!");
                System.out.println(villain.getName() + " is victorious!");
                break;
            }

            // Separate rounds visually
            System.out.println("=============================\n");

            round++;
        }

        System.out.println("\nBattle Over!");



        }
    }
