public abstract class Charactor {
    public String name;
    public int currentHp;
    public int maxHp;
    public int normalPower;
    public String normalAttackName;
    public boolean isDead;

    public Charactor(String name, int maxHp, int normalPower) {
        this.name = name;
        this.maxHp = maxHp;
        this.currentHp = maxHp;
        this.normalPower = normalPower;
        isDead = false;
    }

    public void normalAttack(Charactor charactor) {
        charactor.currentHp-= this.normalPower;
        if(charactor.currentHp<0){
            charactor.currentHp=0;
        }
        if(charactor.currentHp<=0){
            charactor.isDead = true;
        }
    }



}

