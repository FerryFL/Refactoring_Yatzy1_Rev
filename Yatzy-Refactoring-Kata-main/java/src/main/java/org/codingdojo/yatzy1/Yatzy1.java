package org.codingdojo.yatzy1;

public class Yatzy1 {
	
	private int[] dice;

    public Yatzy1(int... dice) {
        this.dice = dice;
    }

    public void setDice(int... dice) {
        this.dice = dice;
    }

    public int sum() {
        int sum = 0;
        for (int die : dice) {
            sum += die;
        }
        return sum;
    }

    public int chance() {
        int sum = 0;
        for (int die : dice) {
            sum += die;
        }
        return sum;
    }

    public int yatzy() {
        for (int i = 1; i < dice.length; i++) {
            if (dice[i] != dice[0]) return 0;
        }
        return 50;
    }
    
    public int countOccurrences(int value) {
        int count = 0;
        for (int die : dice) {
            if (die == value) {
                count++;
            }
        }
        return count;
    }

    public int ones() {
        return countOccurrences(1);
    }

    public int twos() {
        return countOccurrences(2) * 2;
    }

    public int threes() {
        return countOccurrences(3) * 3;
    }

    public int fours() {
        return countOccurrences(4) * 4;
    }

    public int fives() {
        return countOccurrences(5) * 5;
    }

    public int sixes() {
        return countOccurrences(6) * 6;
    }
    
    private static int[] countDiceOccurrences(int... dice) {
        int[] tallies = new int[6];
        for (int die : dice)
            tallies[die - 1]++;
        return tallies;
    }

    public int score_pair(int... dice)
    {
        int[] counts = new int[6];
        for (int die : dice)
            counts[die - 1]++;
        for (int i = 5; i >= 0; i--)
            if (counts[i] >= 2)
                return (i + 1) * 2;
        return 0;
    }


    public static int two_pair(int... dice) {
        int[] counts = countDiceOccurrences(dice);
        return calculateTwoPairScore(counts);
    }

    private static int calculateTwoPairScore(int[] counts) {
        int n = 0;
        int score = 0;
        for (int i = 5; i >= 0; i--) {
            if (counts[i] >= 2) {
                n++;
                score += (i + 1);
            }
        }
        return (n == 2) ? score * 2 : 0;
    }

    private static int calculateOfAKind(int[] dice, int count) {
        int[] tallies = countDiceOccurrences(dice);
        for (int i = 0; i < tallies.length; i++) {
            if (tallies[i] >= count) {
                return (i + 1) * count;
            }
        }
        return 0;
    }

    public static int four_of_a_kind(int... dice) {
        return calculateOfAKind(dice, 4);
    }

    public static int three_of_a_kind(int... dice) {
        return calculateOfAKind(dice, 3);
    }



    public static int smallStraight(int... dice) {
        int[] tallies = countDiceOccurrences(dice);
        if (tallies[0] == 1 && tallies[1] == 1 && tallies[2] == 1 && tallies[3] == 1 && tallies[4] == 1)
            return 15;
        return 0;
    }

    public static int largeStraight(int... dice) {
        int[] tallies = countDiceOccurrences(dice);
        if (tallies[1] == 1 && tallies[2] == 1 && tallies[3] == 1 && tallies[4] == 1 && tallies[5] == 1)
            return 20;
        return 0;
    }


    public static int fullHouse(int... dice) {
        int[] tallies = countDiceOccurrences(dice);
        return calculateFullHouseScore(tallies);
    }

    private static int calculateFullHouseScore(int[] tallies) {
        boolean hasTwo = false;
        boolean hasThree = false;
        int twoValue = 0;
        int threeValue = 0;

        for (int i = 0; i < tallies.length; i++) {
            if (tallies[i] == 2) {
                hasTwo = true;
                twoValue = i + 1;
            } else if (tallies[i] == 3) {
                hasThree = true;
                threeValue = i + 1;
            }
        }

        return (hasTwo && hasThree) ? twoValue * 2 + threeValue * 3 : 0;
    }
}




