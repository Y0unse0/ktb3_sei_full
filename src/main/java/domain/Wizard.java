package domain;

public class Wizard extends Hero {

    public Wizard(String name, int maxHp, int normalPower,int specialPower){
        super(name,maxHp,normalPower);
        this.specialPower=specialPower;
        super.normalAttackName = "파이어 볼";
        super.specialAttackName = "마력 광선";
    }

    @Override
    public void normalAttack(Character character) {
        System.out.println(this.name+"가 "+ normalAttackName+"을 사용했습니다.");
        super.normalAttack(character);
    }
}
