import MultimediaClasses.Multimedia;
import MultimediaClasses.Playable;
import MultimediaClasses.multimediaChildren.Audio;
import MultimediaClasses.multimediaChildren.Image;
import MultimediaClasses.multimediaChildren.Video;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    static void main(String[] args) {
        Image img = new Image("cielo", 4);
        Video vid = new Video("video", 3, 4, 2);
        Video vid2 = new Video("video2", 2, 1, 5);
        Audio aud = new Audio("aud", 4, 1);
        Audio aud2 = new Audio("aud2", 1, 3);
        Multimedia[] array = {img, vid, vid2, aud, aud2};
//        for (Multimedia single : array) {
//            if (single instanceof Image) {
//                Image imge = (Image) single;
//                imge.show();
//            } else {
//                Playable playableSingle = (Playable) single;
//                ((Playable) single).play();
//            }
//        }
        // inizializzare programma riproduzione
        menuStart(array);
    }

    public static void menuStart(Multimedia[] array) {
        System.out.println("Media disponibili:");
        for (Multimedia single : array) {
            System.out.println("-" + single);
        }
        System.out.println("premi qualsiasi tasto per entrare nel player oppure 'x' per terminare");
        String response = scanner.nextLine().trim();
        if (response.equals("x")) {
            scanner.close();
        } else {
            menuPlayer(array);
        }

    }

    public static void menuPlayer(Multimedia[] array) {
        System.out.println("menu del player, seleziona il numero del media per riprodurlo! \npremi '0' per tornare alla home");
        for (int i = 0; i < array.length; i++) {
            System.out.println((i + 1) + " - " + array[i]);
        }
        int numberSelected = 0;
        boolean valid = false;
        while (!valid) {
            try {
                numberSelected = Integer.parseInt(scanner.nextLine().trim());
                if (numberSelected == 0) {
                    menuStart(array);
                } else if (numberSelected > array.length || numberSelected < 1) {
                    throw new NumberFormatException();
                } else valid = true;

            } catch (NumberFormatException e) {
                System.out.println("numero non valido o troppo alto/basso, riprova");
            }

        }
        selectedMedia(numberSelected, array);


    }

    public static void selectedMedia(int n, Multimedia[] array) {
        System.out.println("media riprodotto : \n" + array[n - 1]);
        for (int i = 0; i < array.length; i++) {
            if (i == (n - 1)) {
                if (array[i] instanceof Image) {
                    Image imge = (Image) array[i];
                    imge.show();
                } else {
                    Playable playableSingle = (Playable) array[i];
                    playableSingle.play();
                }
            }

        }
        System.out.println("vuoi tornare al menu del player? premi un qualsiasi tasto");
        System.out.println("oppure premi 'x'per terminare l'attivita'");
        String response = scanner.nextLine().trim();
        if (response.equals("x")) scanner.close();
        else menuPlayer(array);
    }


}
