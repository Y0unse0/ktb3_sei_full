public class Goblin extends Charactor {
    public Goblin(String name, int maxHp, int normalPower){
        super(name, maxHp,normalPower);
        super.normalAttackName = "새총 공격";
    }

    @Override
    public void normalAttack(Charactor charactor) {
        System.out.println(this.name+"이 "+ normalAttackName+"을 사용했습니다.");
        super.normalAttack(charactor);
    }
}
