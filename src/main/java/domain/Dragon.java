package domain;

public class Dragon extends Character {
    public Dragon(String name, int maxHp, int normalPower){
        super(name, maxHp,normalPower);
        super.normalAttackName = "발톱 베기";
    }
    @Override
    public void normalAttack(Character character) {
        System.out.println(this.name+"이 "+ normalAttackName+"를 사용했습니다.");
        super.normalAttack(character);
    }
    public void image(){
        System.out.println("       .     .");
        System.out.println("       |\\-=-/|");
        System.out.println("   /|  |O _ O|  |\\");
        System.out.println("  /' \\ \\_^-^_/ / `\\");
        System.out.println(" /'   \\-/ ~ \\-/   `\\");
        System.out.println("|      /\\\\ //\\      |");
        System.out.println(" \\|\\|\\/-\"\"-\"\"-\\/|/|/");
    }

}
