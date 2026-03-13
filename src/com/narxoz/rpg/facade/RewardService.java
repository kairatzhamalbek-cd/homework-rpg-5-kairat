package com.narxoz.rpg.facade;

public class RewardService {
    public String determineReward(AdventureResult battleResult) {
        if (battleResult == null) {
            return "No reward";
        }
        if ("Draw".equals(battleResult.getWinner())) {
            return "No reward";
        }


        return "Treasure Chest";

    }}
