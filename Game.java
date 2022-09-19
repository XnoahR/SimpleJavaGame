
import java.util.*;

public class Game {

    public static class Player {

        public int Health;
        public int curHealth = Health;
        public int Attack;
        public boolean IsAttack = false;

        public Player() {
            this.Health = 100;
            this.curHealth = this.Health;
            this.Attack = 25;
        }

        public int Regen() {
            return this.curHealth += 50;
        }

        public int Skill1() {
            return this.Attack = 40;
        }

        public int Skill2() {
            return this.Attack = 60;
        }

        public void Attacked() {
            IsAttack = true;
        }

        public int getAttack() {
            return Attack;
        }

        public int getHealth() {
            return curHealth;
        }

        public boolean isIsAttack() {
            return IsAttack;
        }

    }

    public static class Enemy {

        public int Health;
        public int curHealth = Health;
        public int Attack;
        boolean isAttack;

        //Player player = new Player();
        public Enemy() {
            this.Health = 100;
            this.curHealth = this.Health;
            this.Attack = 25;
        }

        public int BasicAttack() {
            return this.Attack = 25;
        }

        public int Skill() {
            return this.Attack = 40;
        }

        public int getHealth() {
            return curHealth;
        }

        public int getAttack() {
            return Attack;
        }

        public void PrintBasicAttack() {
            System.out.println("Enemy Use Basic Attack!");
        }

        public void PrintSkill() {
            System.out.println("Enemy Use Skill!");
        }

        public void IsAttacked() {
            System.out.println("You Attacked enemy!");
            isAttack = true;
        }

    }

    public static void main(String[] args) {
        Player player = new Player();
        Enemy enemy = new Enemy();
        String EnemyAttPrint;
        Random Probability = new Random();
        int phase = 1;
        Scanner input = new Scanner(System.in);
        System.out.println("Player Attack : " + player.getAttack());
        System.out.println("Player Health : " + player.getHealth());
        System.out.println("Enemy Health : " + enemy.getHealth());
        while (player.curHealth > 0 && enemy.curHealth > 0) {
            System.out.println("Phase " + phase);
            System.out.println(" ");
            System.out.printf("Choose ur input :\n1. For Attack\n2. For Regen\n3. Use Skill\n4. Do Nothing\n");
            var x = input.nextInt();
            if (x == 1) {

                enemy.IsAttacked();
            } else if (x == 2) {
                player.Regen();
            } else if (x == 3) {
                System.out.printf("Choose the Skill! \n1. Water Slash(damage 40)\n2. Firebolt(Damage 60)\n");
                var sk = input.nextInt();
                if (sk == 1) {
                    player.Skill1();
                    System.out.println("Player use Water Slash!");
                    enemy.IsAttacked();
                    System.out.println("Enemy health -" + player.Skill1());
                } else if (sk == 2) {
                    player.Skill2();
                    System.out.println("Player use Firebolt!");
                    enemy.IsAttacked();
                    System.out.println("Enemy health -" + player.Skill2());
                } else {
                    System.out.println("Do Nothing");
                }
            } else {
            }

            if (enemy.isAttack == true) {
                enemy.curHealth -= player.Attack;
                enemy.isAttack = false;
            }
            if (enemy.curHealth < 0) {
                enemy.curHealth = 0;
            }
            System.out.println("Player`s turn is " + player.isIsAttack());
            if (enemy.curHealth != 0) {
                var Eattack = Probability.nextInt(1, 99);
                enemy.Attack = Eattack < 51 ? enemy.BasicAttack() : enemy.Skill();
                if (enemy.Attack == 40) {
                    enemy.PrintSkill();
                } else {
                    enemy.PrintBasicAttack();
                }

                System.out.println("enemy attack : " + enemy.Attack);
                player.Attacked();
                if (player.IsAttack == true) {
                    player.curHealth -= enemy.Attack;
                    player.IsAttack = false;
                }
                if (player.curHealth < 0) {
                    player.curHealth = 0;
                }
            }
            System.out.println("Enemy Health Remaining : " + enemy.getHealth());
            System.out.println("Player Health : " + player.getHealth());
            System.out.println("=========================================================================");
            System.out.println(" ");
            phase++;
        }
    }
}
