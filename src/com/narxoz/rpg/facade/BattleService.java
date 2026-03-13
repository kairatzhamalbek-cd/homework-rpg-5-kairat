package com.narxoz.rpg.facade;

import com.narxoz.rpg.decorator.AttackAction;
import com.narxoz.rpg.enemy.BossEnemy;
import com.narxoz.rpg.hero.HeroProfile;


import java.util.Random;

public class BattleService {
    private Random random = new Random(1L);

    public BattleService setRandomSeed(long seed) {
        this.random = new Random(seed);
        return this;
    }

    public AdventureResult battle(HeroProfile hero, BossEnemy boss, AttackAction action) {

        AdventureResult result = new AdventureResult();
        int rounds = 0;
        int maxRounds = 5;

        while (hero.isAlive() && boss.isAlive() && rounds < maxRounds) {
            rounds++;
            int heroDamage = action.getDamage();
            boss.takeDamage(heroDamage);
            result.addLine(hero.getName() + " attacks with " + action.getActionName() +
                    " for " + heroDamage + " damage.");

            if (!boss.isAlive()) {
                break;
            }
            int bossDamage = boss.getAttackPower();
            hero.takeDamage(bossDamage);
            result.addLine(boss.getName() + " counterattacks for " + bossDamage + " damage.");
        }
        result.setRounds(rounds);

        if (hero.isAlive() && !boss.isAlive()) {
            result.setWinner(hero.getName());
            result.setReward("Victory reward");
        } else if (!hero.isAlive() && boss.isAlive()) {
            result.setWinner(boss.getName());
            result.setReward("No reward");
        } else {
            result.setWinner("Draw");
            result.setReward("No reward");
        }

        return result;



    }
}
