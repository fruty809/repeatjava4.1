import java.util.Random;

public class Main {
    public static int bossHealth = 700;
    public static int bossDamage = 70;
    public static String bossDefence;
    public static int[] heroesHealth = {270, 280, 250};
    public static int[] heroesDamage = {30, 25, 25};
    public static String[] heroesTypeAttack = {"Physical", "Magical", "Kinetic"};
    public static int roundNumber;

    public static void main(String[] args) {
        printStatistics();
        while (!isGameOver()) {
            playRound();
        }
    }

    public static void playRound() {
        chooseBossDefence();
        roundNumber++;
        bossHits();
        heroesHits();
        printStatistics();
    }

    public static void chooseBossDefence(){
        Random random = new Random();
        int randomIndex = random.nextInt(heroesTypeAttack.length);
        bossDefence = heroesTypeAttack[randomIndex];
    }

    public static void bossHits() {
        for (int i = 0; i < heroesHealth.length; i++) {
            if (heroesHealth[i] > 0) {
                heroesHealth[i] = -bossDamage;
            }
        }
    }

    public static void heroesHits() {
        for (int i = 0; i < heroesDamage.length; i++) {
            if (heroesHealth[i] > 0 && bossHealth > 0) {
                int damage = heroesDamage[i];
                if (bossDefence == heroesTypeAttack[i]) {
                    Random random = new Random();
                    int coeff = random.nextInt(9);
                    damage = heroesDamage[i] * coeff;
                    System.out.println("Critical Damage : " + damage);
                }
                bossHealth -= heroesDamage[i];
                    if (bossHealth < 0) {
                        bossHealth = 0;
                    }
                }
            }
        }

    public static boolean isGameOver() {
        if (bossHealth <= 0) {
            System.out.println("hero won!");
            return true;
        }
        boolean allHeroesDead = true;
        for (int i = 0; i < heroesHealth.length; i++) {
            if (heroesHealth[i] > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("Boss won!!!");
        }
        return allHeroesDead;
    }

    public static void printStatistics() {
        System.out.println("ROUND" + roundNumber + "----------");
        System.out.println("Boss health" + bossHealth + "damage" + bossDamage + "defence" + (bossDefence == null ? "No defence" : bossDefence));
        for (int i = 0; i < heroesHealth.length; i++) {

        }
    }
}