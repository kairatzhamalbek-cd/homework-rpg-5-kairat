package com.narxoz.rpg;

import com.narxoz.rpg.decorator.AttackAction;
import com.narxoz.rpg.decorator.BasicAttack;
import com.narxoz.rpg.decorator.CriticalFocusDecorator;
import com.narxoz.rpg.decorator.FireRuneDecorator;
import com.narxoz.rpg.decorator.PoisonCoatingDecorator;
import com.narxoz.rpg.enemy.BossEnemy;
import com.narxoz.rpg.facade.AdventureResult;
import com.narxoz.rpg.facade.DungeonFacade;
import com.narxoz.rpg.hero.HeroProfile;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Homework 5 Demo: Decorator + Facade ===\n");

        HeroProfile hero = new HeroProfile("Arthas", 50);
        BossEnemy boss = new BossEnemy("Dragon", 35, 8);

        AttackAction basic = new BasicAttack("Strike", 10);
        AttackAction fireAttack = new FireRuneDecorator(basic);
        AttackAction poisonAttack = new PoisonCoatingDecorator(basic);
        AttackAction enhanced = new FireRuneDecorator(
                new PoisonCoatingDecorator(
                        new CriticalFocusDecorator(basic)
                )
        );

        System.out.println("--- Decorator Preview ---");
        System.out.println("Base action: " + basic.getActionName());
        System.out.println("Base damage: " + basic.getDamage());
        System.out.println("Base effects: " + basic.getEffectSummary());
        System.out.println();
        System.out.println("Fire action: " + fireAttack.getActionName());
        System.out.println("Fire damage: " + fireAttack.getDamage());
        System.out.println("Fire effects: " + fireAttack.getEffectSummary());
        System.out.println();

        System.out.println("Poison action: " + poisonAttack.getActionName());
        System.out.println("Poison damage: " + poisonAttack.getDamage());
        System.out.println("Poison effects: " + poisonAttack.getEffectSummary());
        System.out.println();

        System.out.println("Enhanced action: " + enhanced.getActionName());
        System.out.println("Enhanced damage: " + enhanced.getDamage());
        System.out.println("Enhanced effects: " + enhanced.getEffectSummary());

        System.out.println("\n--- Facade Preview ---");
        DungeonFacade facade = new DungeonFacade().setRandomSeed(42L);
        AdventureResult result = facade.runAdventure(hero, boss, enhanced);

        System.out.println("Winner: " + result.getWinner());
        System.out.println("Rounds: " + result.getRounds());
        System.out.println("Reward: " + result.getReward());
        System.out.println("Battle log:");
        for (String line : result.getLog()) {
            System.out.println(line);
        }


        System.out.println("\n=== Demo Complete ===");
    }
}
