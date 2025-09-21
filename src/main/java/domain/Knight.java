package domain;

public class Knight extends Hero {

    public Knight(String name, int maxHp, int normalPower,int specialPower){
        super(name,maxHp,normalPower);
        super.specialPower=specialPower;
        super.normalAttackName = "찌르기";
        super.specialAttackName = "최후의 일격";
    }
    @Override
    public void normalAttack(Character character) {
        System.out.println(this.name+"가 "+ normalAttackName+"를 사용했습니다.");
        super.normalAttack(character);
    }

}
