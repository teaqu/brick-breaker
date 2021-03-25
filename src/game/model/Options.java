package game.model;

public class Options extends Model {
    private int soundsVolume = 80;
    private int musicVolume = 30;

    public int getSoundsVolume() {
        return soundsVolume;
    }

    public void setSoundsVolume(int volume) {
        this.soundsVolume = volume;
    }

    public double getSoundsClipVolume() {
        return this.getClipVolume(soundsVolume);
    }

    public int getMusicVolume() {
        return musicVolume;
    }

    public void setMusicVolume(int musicVolume) {
        this.musicVolume = musicVolume;
    }

    public double getMusicClipVolume() {
        return this.getClipVolume(musicVolume);
    }

    /**
     * Volume for soundClip must be 0 < x <= 2.
     * Using 0 < x < 0.2 as volume very loud otherwise. This will give better
     * slider values.
     *
     * @return sound
     */
    private double getClipVolume(int sound) {
        return Math.max(0.2*sound/100, 0.0001);
    }

}
