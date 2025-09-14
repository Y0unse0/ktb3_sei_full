public class Hero extends Charactor{
    public int specialPower;
    public int specialAttackNum;
    public String specialAttackName;

    public Hero(String name, int maxHp, int normalPower) {
        super(name, maxHp,normalPower);
        this.specialAttackNum = 2;
    }


    public void specialAttack(Charactor villain) {
        System.out.println(this.name+"가 "+ specialAttackName+"을 사용했습니다.");
        villain.currentHp -= specialPower;
        this.specialAttackNum--;
        if(villain.currentHp<0){
            villain.currentHp=0;
        }
        if(villain.currentHp<=0){
            villain.isDead = true;
        }
    }



}
