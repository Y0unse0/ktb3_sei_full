package task;

import domain.Character;
import domain.Hero;

import java.util.Scanner;

public class HeroTask implements Runnable{
    private final Hero hero;
    private final Character villain;
    private volatile boolean running = true;




    public HeroTask(Hero hero, domain.Character villain) {
        this.hero = hero;
        this.villain = villain;
    }


    @Override
    public void run() {
        if (!hero.isDead) {
            Scanner scanner = new Scanner(System.in);

            int choice = 0;
            do {
                System.out.println("");
                System.out.println("어떤 공격을 사용하시겠습니까?");
                System.out.println("1. 노멀 어택: " + hero.normalAttackName + "(공격력:" + hero.normalPower + ") " +
                        " 2. 스페셜 어택: " + hero.specialAttackName + "(공격력:" + hero.specialPower + ", 남은 횟수:" + hero.specialAttackNum + ")");
                choice = scanner.nextInt();

                if (choice < 1 || choice > 2) {
                    System.out.println("잘못 입력하셨습니다. 다시 선택해주세요");
                } else if (choice == 2 && hero.specialAttackNum == 0) {
                    System.out.println("스페셜 어택이 없습니다!! 다시 선택해주세요");
                    choice = 0;
                }
            } while (choice != 1 && choice != 2);

            if (choice == 1) {
                hero.normalAttack(villain);
            } else {
                hero.specialAttack(villain);
            }
            System.out.println("현재 체력 " + hero.name + ": " + hero.currentHp + "/" + hero.maxHp + "  " + villain.name + ": " + villain.currentHp + "/" + villain.maxHp);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (villain.isDead) {
                System.out.println(villain.name + "이 쓰러졌습니다!!!");
                return;
            }
        }
    }
    public void stop() {
        running = false;
    }
}
