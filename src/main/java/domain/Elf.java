package domain;

public class Elf extends Hero {

    public Elf(String name, int maxHp, int normalPower,int specialPower){
        super(name,maxHp,normalPower);
        super.specialPower=specialPower;
        super.normalAttackName = "바람 화살";
        super.specialAttackName = "정령술";
    }
    @Override
    public void normalAttack(Character character) {
        System.out.println(this.name+"가 "+ normalAttackName+"을 사용했습니다.");
        super.normalAttack(character);
    }

}
