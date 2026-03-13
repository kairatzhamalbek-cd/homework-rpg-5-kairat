package com.narxoz.rpg.decorator;

public class FireRuneDecorator extends ActionDecorator {
    public FireRuneDecorator(AttackAction wrappedAction) {
        super(wrappedAction);
    }

    @Override
    public String getActionName() {
        return super.getActionName() + " + Fire Rune";
    }

    @Override
    public int getDamage() {
        return super.getDamage() + 5;
    }

    @Override
    public String getEffectSummary() {
        return super.getEffectSummary() + ", burns the target";
    }
}
