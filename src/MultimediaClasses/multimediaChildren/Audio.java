package MultimediaClasses.multimediaChildren;

import MultimediaClasses.Playable;

public class Audio extends Playable {


    public Audio(String title, int duration) {
        super(title, duration);
    }

    public Audio(String title, int duration, int volume) {
        super(title, duration, volume);
    }

    //    //Start media
    @Override
    public void play() {
        for (int i = 0; i < getDuration(); i++) {
            String volumeLength = "";
            for (int j = 0; j < getVolume(); j++) {
                volumeLength += "!";
            }
            System.out.println(getTitle() + volumeLength);
        }
    }

    //String
    @Override
    public String toString() {
        return "Audio{" +
                "title=" + getTitle() +
                ", duration=" + getDuration() +
                ", volume=" + getVolume() +
                '}';
    }


}
