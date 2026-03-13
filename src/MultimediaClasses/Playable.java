package MultimediaClasses;

import interfaces.StartPlayable;
import interfaces.Volume;

public abstract class Playable extends Multimedia implements Volume, StartPlayable {
    private int duration;
    private int volume = 2;

    public Playable(String title) {
        super(title);
    }

    public Playable(String title, int duration) {
        super(title);
        if (duration < 1) this.duration = 1;
        else this.duration = Math.min(duration, 5);
    }

    public Playable(String title, int duration, int volume) {
        super(title);
        if (duration < 1) this.duration = 1;
        else this.duration = Math.min(duration, 5);
        if (volume < 0) this.volume = 0;
        else this.volume = Math.min(volume, 5);
    }
    //Getter e setter


    public int getVolume() {
        return volume;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    //Interface volume

    public void volumeUp() {
        this.volume++;
        if (this.volume > 5) this.volume = 5;
    }


    public void volumeDown() {
        this.volume--;
        if (this.volume < 0) this.volume = 0;
    }

    @Override
    public void volumeUp(int num) {
        this.volume += num;
        if (this.volume > 5) this.volume = 5;
    }

    @Override
    public void volumeDown(int num) {
        this.volume -= num;
        if (this.volume < 0) this.volume = 0;
    }


}
