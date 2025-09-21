package service;

import domain.Hero;

import java.util.Scanner;

public class BattleSystem {
    private final Scanner scanner;
    public BattleSystem(Scanner scanner) {
        this.scanner = scanner;
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
