package task;

import domain.Hero;
import domain.Character;
public class VillainTask implements Runnable{
    private final Hero hero;
    private final Character villain;
    private  volatile boolean running = true;

    public VillainTask(Hero hero, Character villain) {
        this.hero = hero;
        this.villain = villain;
    }

    @Override
    public void run() {
            if(!villain.isDead) {
                villain.normalAttack(hero);
                System.out.println("현재 체력 " + hero.name + ": " + hero.currentHp + "/" + hero.maxHp + "  " + villain.name + ": " + villain.currentHp + "/" + villain.maxHp);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

    }

    public void stop() {
        running = false;
    }
}
