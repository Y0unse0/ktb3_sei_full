import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Elf elf = new Elf("엘프", 100, 10, 30);
        Knight knight = new Knight("기사", 100, 10, 30);
        Wizard wizard = new Wizard("마법사", 100, 10, 30);

        Goblin goblin = new Goblin("고블린", 80, 30);
        Dragon dragon = new Dragon("드래곤", 100, 60);
        String[] intro = {"게임에 오신 것을 환영합니다! 당신의 모험을 응원합니다.",
                "++++++++++++++++++++++++++++++++++++++++++++++++++", "",
                "어둠이 드리워진 땅에 고블린이 나타났습니다.",
                "",
                "고블린은 보급로를 끊어 마을 사람들을 굶주리게 하고 여행자들을 공격하고 있습니다.",
                "",
                "이를 보다못한 나라의 왕은 용맹한 원정대를 꾸려 고블린을 무찌르도록 했습니다.",
                "",
                "엘프, 기사, 마법사로 구성된 원정대가 사람들을 구하기 위해 마을을 나섰습니다.",
                "",
                "고블린 무리가 나타났습니다! 누가 선봉에서 싸우겠습니까?"
        };
        try {
            for (String l : intro) {
                System.out.println(l);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int heroNum = 3;
        int choice = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("상대:"+ goblin.name+ ", "+"현재 체력:" + goblin.currentHp + "/" + goblin.maxHp+", 공격력:"+ goblin.normalPower);
        System.out.println("");
        System.out.println("첫 전투에 나설 영웅을 선택하세요");

        Hero currentHero;
        while (heroNum > 0 && !goblin.isDead) {
            do {
                do{
                System.out.println("1. 엘프 2. 기사 3. 마법사");
                choice = scanner.nextInt();
                if (choice < 1 || choice > 3) {
                    System.out.println("잘못 입력하셨습니다. 다시 선택해주세요");
                }}while (choice < 1 || choice > 3);
                if (choice == 1) {
                    currentHero = elf;
                } else if (choice == 2) {
                    currentHero = knight;
                } else {
                    currentHero = wizard;
                }
                System.out.println(currentHero.name + "를 선택하셨습니다.");
                if (currentHero.isDead) {
                    System.out.println("선택하신 영웅은 이미 쓰러졌습니다! 다시 선택해주세요.");
                }
            } while (currentHero.isDead == true);

            choice = 0;
            do {
                do {
                    System.out.println("");
                    System.out.println("어떤 공격을 사용하시겠습니까?");
                    System.out.println("1. 노멀 어택: " + currentHero.normalAttackName + "(공격력:" + currentHero.normalPower + ") " +
                            " 2. 스페셜 어택: " + currentHero.specialAttackName + "(공격력:" + currentHero.specialPower + ", 남은 횟수:" + currentHero.specialAttackNum + ")");
                    choice = scanner.nextInt();

                    if (choice < 1 || choice > 2) {
                        System.out.println("잘못 입력하셨습니다. 다시 선택해주세요");
                    } else if (choice == 2 && currentHero.specialAttackNum == 0) {
                        System.out.println("스페셜 어택이 없습니다!! 다시 선택해주세요");
                        choice = 0;
                    }
                } while (choice != 1 && choice != 2);
                if (choice == 1) {
                    currentHero.normalAttack(goblin);
                } else {
                    currentHero.specialAttack(goblin);
                }
                System.out.println("현재 체력 " + currentHero.name + ": " + currentHero.currentHp + "/" + currentHero.maxHp + "  " + goblin.name + ": " + goblin.currentHp + "/" + goblin.maxHp);
                System.out.println("");

                if (goblin.isDead) {
                    System.out.println(goblin.name + "이 쓰러졌습니다!!!");
                    break;
                }
                try{
                    Thread.sleep(2000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                goblin.normalAttack(currentHero);
                System.out.println("현재 체력 " + currentHero.name + ": " + currentHero.currentHp + "/" + currentHero.maxHp + "  " + goblin.name + ": " + goblin.currentHp + "/" + goblin.maxHp);
                try{
                    Thread.sleep(2000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                if (currentHero.isDead) {
                    System.out.println("");
                    System.out.println(currentHero.name + "가 쓰러졌습니다!");
                    System.out.println("");
                    heroNum--;
                    if (heroNum == 0) {
                        System.out.println("전투에서 패배하였습니다..");
                        System.out.println("게임이 종료됩니다.");
                        System.exit(0);}
                    System.out.println("이어서 싸울 영웅을 선택해주세요.");
                }
            } while (!currentHero.isDead);
        }


            String[] middleMessage1 = {
                    "승리! 하지만 기쁨도 잠시..",
                    ""
            };
            try {
                for (String l : middleMessage1) {
                    System.out.println(l);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            dragon.image();
            String[] middleMessage2 = {
                    "",
                    "드래곤이다!!",
                    "",
                    "당신 앞에 나타난 드래곤은 입에서 불꽃을 뿜어내며 새로운 고블린들을 창조하고 있습니다.",
                    "",
                    "끝없는 위협을 막기위해선 드래곤을 무찔러야합니다.",
                    "",
                    "원정대는 마음을 가다듬고 다시 전투에 돌입합니다.",
                    ""
            };
            try {
                for (String l : middleMessage2) {
                    System.out.println(l);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("상대:"+ dragon.name+ ", "+"현재 체력:" + dragon.currentHp + "/" + dragon.maxHp+", 공격력:"+ dragon.normalPower);
            System.out.println("");
            System.out.println("현재 원정대의 상태");
            System.out.println(elf.name + "의 현재 체력:" + elf.currentHp + ", " + elf.name + "의 남은 스페셜 어택 횟수:" + elf.specialAttackNum);
            System.out.println(knight.name + "의 현재 체력:" + knight.currentHp + ", " + knight.name + "의 남은 스페셜 어택 횟수:" + knight.specialAttackNum);
            System.out.println(wizard.name + "의 현재 체력:" + wizard.currentHp + ", " + wizard.name + "의 남은 스페셜 어택 횟수:" + wizard.specialAttackNum);
            try{
                Thread.sleep(2000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("");
            System.out.println("전투에 나설 영웅을 선택하세요");
            while (heroNum > 0 && !dragon.isDead) {
                do {
                    do{
                    System.out.println("1. 엘프 2. 기사 3. 마법사");
                    choice = scanner.nextInt();
                    if (choice < 1 || choice > 3) {
                        System.out.println("잘못 입력하셨습니다. 다시 선택해주세요");
                    }}while (choice < 1 || choice > 3);
                    if (choice == 1) {
                        currentHero = elf;
                    } else if (choice == 2) {
                        currentHero = knight;
                    } else {
                        currentHero = wizard;
                    }
                    System.out.println(currentHero.name + "를 선택하셨습니다.");
                    System.out.println("현재 체력:" + currentHero.currentHp + "/" + currentHero.maxHp);
                    if (currentHero.isDead) {
                        System.out.println("선택하신 영웅은 이미 쓰러졌습니다! 다시 선택해주세요.");
                    }
                } while (currentHero.isDead == true);

                choice = 0;
                do {
                    do {
                        System.out.println("");
                        System.out.println("어떤 공격을 사용하시겠습니까?");
                        System.out.println("1. 노멀 어택: " + currentHero.normalAttackName + "(공격력:" + currentHero.normalPower + ") " +
                                " 2. 스페셜 어택: " + currentHero.specialAttackName + "(공격력:" + currentHero.specialPower + ", 남은 횟수:" + currentHero.specialAttackNum + ")");
                        choice = scanner.nextInt();

                        if (choice < 1 || choice > 2) {
                            System.out.println("잘못 입력하셨습니다. 다시 선택해주세요");
                        } else if (choice == 2 && currentHero.specialAttackNum == 0) {
                            System.out.println("스페셜 어택이 없습니다!! 다시 선택해주세요");
                            choice = 0;
                        }
                    } while (choice != 1 && choice != 2);

                    if (choice == 1) {
                        currentHero.normalAttack(dragon);
                    } else {
                        currentHero.specialAttack(dragon);
                    }
                    try{
                        Thread.sleep(2000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.println("현재 체력 " + currentHero.name + ": " + currentHero.currentHp + "/" + currentHero.maxHp + "  " + dragon.name + ": " + dragon.currentHp + "/" + dragon.maxHp);
                    System.out.println("");

                    if (dragon.isDead) {
                        System.out.println(dragon.name + "이 쓰러졌습니다!!!");
                        break;
                    }
                    try{
                        Thread.sleep(2000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    dragon.normalAttack(currentHero);
                    System.out.println("현재 체력 " + currentHero.name + ": " + currentHero.currentHp + "/" + currentHero.maxHp + "  " + dragon.name + ": " + dragon.currentHp + "/" + dragon.maxHp);
                    try{
                        Thread.sleep(2000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    if (currentHero.isDead) {
                        System.out.println("");
                        System.out.println(currentHero.name + "가 쓰러졌습니다!");
                        System.out.println("");
                        heroNum--;
                        if(heroNum==0){
                            System.out.println("전투에서 패배하였습니다..");
                            System.out.println("게임이 종료됩니다.");
                            System.exit(0);
                        }
                        System.out.println("이어서 싸울 영웅을 선택해주세요.");
                    }
                } while (!currentHero.isDead);
            }
                System.out.println("전투에서 승리하였습니다!");
                String[] ending= {
                        "드래곤의 심장이 멎자 그가 창조했던 모든 고블린의 기운이 사라집니다",
                        "",
                        "길고 험난했던 여정이 이제 막을 내렸습니다.",
                        "",
                        "원정대의 이야기는 영원히 기억될 것입니다.",
                        "",
                        "████████╗██╗  ██╗███████╗     ███████╗███╗   ██╗██████╗ ",
                        "╚══██╔══╝██║  ██║██╔════╝     ██╔════╝████╗  ██║██╔══██╗",
                        "   ██║   ███████║█████╗       █████╗  ██╔██╗ ██║██║  ██║",
                        "   ██║   ██╔══██║██╔══╝       ██╔══╝  ██║╚██╗██║██║  ██║",
                        "   ██║   ██║  ██║███████╗     ███████╗██║ ╚████║██████╔╝",
                        "   ╚═╝   ╚═╝  ╚═╝╚══════╝     ╚══════╝╚═╝  ╚═══╝╚═════╝ ",
                        ""

                };
                try{
                for(String l:ending){
                    System.out.println(l);
                    Thread.sleep(1000);
                }}catch(Exception e){
                    e.printStackTrace();
                }

    }
}



