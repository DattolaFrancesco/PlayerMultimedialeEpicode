package MultimediaClasses.multimediaChildren;

import MultimediaClasses.Playable;
import interfaces.Brightness;

public class Video extends Playable implements Brightness {
    private int brightness = 2;

    public Video(String title, int duration) {
        super(title, duration);
    }

    public Video(String title, int duration, int volume) {
        super(title, duration, volume);
    }

    public Video(String title, int duration, int volume, int brightness) {
        super(title, duration, volume);
        this.brightness = brightness;
    }

    // getter e setter

    public int getBrightness() {
        return brightness;
    }

    // serve principalmente per le funzioni di modifica dallo scanner
    public void setBrightness(int n) {
        this.brightness = n;
        if (this.brightness > 5) this.brightness = 5;
        else if (this.brightness < 0) this.brightness = 0;
    }

    public void brightnessUp() {
        this.brightness++;
        if (this.brightness > 5) this.brightness = 5;
    }


    public void brightnessDown() {
        this.brightness--;
        if (this.brightness < 0) this.brightness = 0;
    }


    public void brightnessUp(int num) {
        this.brightness += num;
        if (this.brightness > 5) this.brightness = 5;
    }


    public void brightnessDown(int num) {
        this.brightness -= num;
        if (this.brightness < 0) this.brightness = 0;
    }

    // implement playable
    @Override
    public void play() {
        for (int i = 0; i < getDuration(); i++) {
            String volumeLength = "";
            for (int j = 0; j < getVolume(); j++) {
                volumeLength += "!";
            }
            String brightnessLength = "";
            for (int y = 0; y < this.brightness; y++) {
                brightnessLength += "*";
            }
            System.out.println(getTitle() + volumeLength + brightnessLength);
        }
    }
    //String

    @Override
    public String toString() {
        return "Video{" +
                "title=" + getTitle() +
                ", duration=" + getDuration() +
                ", volume=" + getVolume() +
                ", brightness=" + brightness +
                '}';
    }

}
