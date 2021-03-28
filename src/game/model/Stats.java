package game.model;

public class Stats extends Model {
    private int score = 0;
    private int level = 1;
    private int remaining = 0;
    private int lives = 1;

    public void setScore(int score) {
        this.score = score;
        changed();
    }

    public void addScore(int score) {
        this.score += score;
        changed();
    }

    public void setLevel(int level) {
        this.level = level;
        changed();
    }

    public void setRemaining(int remaining) {
        this.remaining = remaining;
        changed();
    }

    public void setLives(int lives) {
        this.lives = lives;
        changed();
    }

    public int getLevel() {
        return level;
    }

    public int getScore() {
        return score;
    }

    public int getRemaining() {
        return remaining;
    }

    public int getLives() {
        return lives;
    }

    /**
     * Generate an emoji heart for each life.
     * 0x2764 = heart emoji
     * @return emoji hearts
     */
    public String getHearts() {
        if (lives > 0) {
            char[] hearts = new char[lives];
            for (int i = 0; i < lives; i++) {
                hearts[i] = Character.toChars(0x2764)[0];
            }
            return String.valueOf(hearts);
        } else {
            return "";
        }
    }

}
