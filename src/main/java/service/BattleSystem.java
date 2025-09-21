package service;

import domain.Character;
import domain.Hero;

import java.util.Scanner;

public class BattleSystem {
    private final Scanner scanner;
    public BattleSystem(Scanner scanner) {
        this.scanner = scanner;
    }

    public  void executeBattle(Hero hero, Character villain) {
        int choice = 0;
        do {
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
            System.out.println("");

            if (villain.isDead) {
                System.out.println(villain.name + "이 쓰러졌습니다!!!");
                break;
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            villain.normalAttack(hero);
            System.out.println("현재 체력 " + hero.name + ": " + hero.currentHp + "/" + hero.maxHp + "  " + villain.name + ": " + villain.currentHp + "/" + villain.maxHp);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (hero.isDead) {
                System.out.println("");
                System.out.println(hero.name + "가 쓰러졌습니다!");
                System.out.println("");
                break;

            }
        } while (!hero.isDead);

    }

    public Hero chooseHero( Hero hero1, Hero hero2,Hero hero3) {
        Hero currentHero;
        int choice = 0;
        do {
            do{
                System.out.println("1. 엘프 2. 기사 3. 마법사");
                choice = scanner.nextInt();
                if (choice < 1 || choice > 3) {
                    System.out.println("잘못 입력하셨습니다. 다시 선택해주세요");
                }}while (choice < 1 || choice > 3);
            if (choice == 1) {
                currentHero = hero1;
            } else if (choice == 2) {
                currentHero = hero2;
            } else {
                currentHero = hero3;
            }
            System.out.println(currentHero.name + "를 선택하셨습니다.");
            if (currentHero.isDead) {
                System.out.println("선택하신 영웅은 이미 쓰러졌습니다! 다시 선택해주세요.");
            }
        } while (currentHero.isDead);
        return currentHero;
    }
}
