import MultimediaClasses.Multimedia;
import MultimediaClasses.Playable;
import MultimediaClasses.multimediaChildren.Audio;
import MultimediaClasses.multimediaChildren.Image;
import MultimediaClasses.multimediaChildren.Video;

public class Main {
    static void main(String[] args) {
        Image img = new Image("cielo", 4);
        Video vid = new Video("video", 3, 4, 2);
        Video vid2 = new Video("video2", 2, 1, 5);
        Audio aud = new Audio("aud", 4, 1);
        Audio aud2 = new Audio("aud2", 1, 3);
        Multimedia[] array = {img, vid, vid2, aud, aud2};
        for (Multimedia single : array) {
            if (single instanceof Image) {
                Image imge = (Image) single;
                imge.show();
            } else {
                Playable playableSingle = (Playable) single;
                ((Playable) single).play();
            }
        }

    }
}
