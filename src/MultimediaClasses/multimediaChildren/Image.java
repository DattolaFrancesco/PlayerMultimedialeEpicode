package MultimediaClasses.multimediaChildren;

import MultimediaClasses.Multimedia;
import interfaces.Brightness;
import interfaces.ShowUnPlayable;

public class Image extends Multimedia implements Brightness, ShowUnPlayable {

    private int brightness = 2;

    public Image(String title) {
        super(title);
    }

    public Image(String title, int brightness) {
        super(title);
        if (brightness < 0) this.brightness = 0;
        else this.brightness = Math.min(brightness, 5);
    }

    // brightness
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

    // show img
    @Override
    public void show() {
        String brightnessLength = "";
        for (int y = 0; y < this.brightness; y++) {
            brightnessLength += "*";
        }
        System.out.println(getTitle() + brightnessLength);
    }

    @Override
    public String toString() {
        return "Image{" +
                "title=" + getTitle() +
                ", brightness=" + brightness +
                '}';
    }
}
