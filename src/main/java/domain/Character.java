package domain;

public abstract class Character {
    public String name;
    public int currentHp;
    public int maxHp;
    public int normalPower;
    public String normalAttackName;
    public boolean isDead;

    public Character(String name, int maxHp, int normalPower) {
        this.name = name;
        this.maxHp = maxHp;
        this.currentHp = maxHp;
        this.normalPower = normalPower;
        isDead = false;
    }

    public void normalAttack(Character character) {
        character.currentHp-= this.normalPower;
        if(character.currentHp<0){
            character.currentHp=0;
        }
        if(character.currentHp<=0){
            character.isDead = true;
        }
    }



}

