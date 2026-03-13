import MultimediaClasses.Multimedia;
import MultimediaClasses.Playable;
import MultimediaClasses.multimediaChildren.Audio;
import MultimediaClasses.multimediaChildren.Image;
import MultimediaClasses.multimediaChildren.Video;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Multimedia> multimedia = new ArrayList<>();

    static void main(String[] args) {
        // solo per usare lo scanner ->
        checkMediaType();
    }

    public static void menuCreation() {
        for (int i = 0; i < multimedia.size(); i++) {
            System.out.println("- " + multimedia.get(i));
        }
        System.out.println("vuoi creare altri media?" +
                "\n clicca qualsiasi tasto per creare un nuovo media" +
                "\n clicca 'p' per attivare il player " +
                "\n clicca 'm' per attivare le modifiche " +
                "\n clicca 'x' per terminare l'attivita'");
        String response = scanner.nextLine().trim();
        if (response.equals("p")) menuStart();
        else if (response.equals("x")) scanner.close();
        else if (response.equals("m")) selectMultimediaToModify();
        else checkMediaType();
    }

    public static void selectMultimediaToModify() {
        System.out.println("quale media vuoi modificare? digita la sua posizione");
        for (int i = 0; i < multimedia.size(); i++) {
            System.out.println((i) + "-" + multimedia.get(i));
        }
        int risposta = Integer.parseInt(scanner.nextLine());
        selectPossibleChange(multimedia.get(risposta));
    }

    public static void selectPossibleChange(Multimedia multimedia) {
        String type = multimedia.getClass().getSimpleName();
        switch (type) {
            case "Image" -> changeImage(multimedia);
            case "Video" -> changeVideo(multimedia);
            case "Audio" -> changeAudio(multimedia);
        }
    }

    public static void changeAudio(Multimedia multimedia) {
        System.out.println("immagine corrente : " + multimedia);
        System.out.println("premi : \n" +
                "  -'n' per modificare il titolo \n" +
                "  -'d' per modificare la durata' \n" +
                "  -'v' per modificare la volume' \n" +
                "  -qualsiasi altro tasto per uscire");
        String response = scanner.nextLine();
        if (response.equals("n")) changeTitle(multimedia);
        else if (response.equals("d")) changeDuration(multimedia);
        else if (response.equals("v")) changeVolume(multimedia);
        else menuCreation();
    }

    public static void changeVideo(Multimedia multimedia) {
        System.out.println("immagine corrente : " + multimedia);
        System.out.println("premi : \n" +
                "  -'n' per modificare il titolo \n" +
                "  -'b' per modificare la luminosita' \n" +
                "  -'d' per modificare la durata' \n" +
                "  -'v' per modificare la volume' \n" +
                "  -qualsiasi altro tasto per uscire");
        String response = scanner.nextLine();
        if (response.equals("n")) changeTitle(multimedia);
        else if (response.equals("b")) changeBrightness(multimedia);
        else if (response.equals("d")) changeDuration(multimedia);
        else if (response.equals("v")) changeVolume(multimedia);
        else menuCreation();
    }

    public static void changeVolume(Multimedia multimedia) {
        int volume = 0;
        boolean valid = false;
        if (multimedia instanceof Video) {
            Video vid = (Video) multimedia;
            System.out.println("volume corrente=" + vid.getVolume());
            System.out.println("scrivi un nuovo valore per la volume");
            while (!valid) {
                try {
                    volume = Integer.parseInt(scanner.nextLine().trim());
                    if (volume > 5 || volume < 0) {
                        throw new NumberFormatException();
                    } else valid = true;

                } catch (NumberFormatException e) {
                    System.out.println("numero non valido o troppo alto/basso, riprova");
                }

            }
            vid.setVolume(volume);
            System.out.println("volume cambiato in : " + vid.getVolume());
        }
        if (multimedia instanceof Audio) {
            Audio aud = (Audio) multimedia;
            System.out.println("volume corrente=" + aud.getVolume());
            System.out.println("scrivi un nuovo valore per la volume");
            while (!valid) {
                try {
                    volume = Integer.parseInt(scanner.nextLine().trim());
                    if (volume > 5 || volume < 0) {
                        throw new NumberFormatException();
                    } else valid = true;

                } catch (NumberFormatException e) {
                    System.out.println("numero non valido o troppo alto/basso, riprova");
                }

            }
            aud.setVolume(volume);
            System.out.println("volume cambiato in : " + aud.getVolume());
        }
        menuCreation();
    }

    public static void changeDuration(Multimedia multimedia) {
        int duration = 0;
        boolean valid = false;
        if (multimedia instanceof Video) {
            Video vid = (Video) multimedia;
            System.out.println("durata' corrente=" + vid.getDuration());
            System.out.println("scrivi un nuovo valore per la durata'");
            while (!valid) {
                try {
                    duration = Integer.parseInt(scanner.nextLine().trim());
                    if (duration > 5 || duration < 0) {
                        throw new NumberFormatException();
                    } else valid = true;

                } catch (NumberFormatException e) {
                    System.out.println("numero non valido o troppo alto/basso, riprova");
                }

            }
            vid.setDuration(duration);
            System.out.println("durata cambiata in : " + vid.getDuration());
        }
        if (multimedia instanceof Audio) {
            Audio aud = (Audio) multimedia;
            System.out.println("durata' corrente=" + aud.getDuration());
            System.out.println("scrivi un nuovo valore per la durata'");
            while (!valid) {
                try {
                    duration = Integer.parseInt(scanner.nextLine().trim());
                    if (duration > 5 || duration < 0) {
                        throw new NumberFormatException();
                    } else valid = true;

                } catch (NumberFormatException e) {
                    System.out.println("numero non valido o troppo alto/basso, riprova");
                }

            }
            aud.setDuration(duration);
            System.out.println("durata cambiata in : " + aud.getDuration());
        }
        menuCreation();
    }

    public static void changeImage(Multimedia multimedia) {
        System.out.println("immagine corrente : " + multimedia);
        System.out.println("premi : \n" +
                "  -'n' per modificare il titolo \n" +
                "  -'b' per modificare la luminosita' \n" +
                "  -qualsiasi altro tasto per uscire");
        String response = scanner.nextLine();
        if (response.equals("n")) changeTitle(multimedia);
        else if (response.equals("b")) changeBrightness(multimedia);
        else menuCreation();
    }

    public static void changeTitle(Multimedia multimedia) {
        System.out.println("titolo corrente=" + multimedia.getTitle());
        System.out.println("scrivi il nuovo titolo");
        String newTitle = scanner.nextLine().trim();
        multimedia.setTitle(newTitle);
        System.out.println("titolo cambiato in : " + multimedia.getTitle());
        menuCreation();
    }

    public static void changeBrightness(Multimedia multimedia) {
        int brightness = 0;
        boolean valid = false;
        if (multimedia instanceof Image) {
            Image imge = (Image) multimedia;
            System.out.println("luminosita' corrente=" + imge.getBrightness());
            System.out.println("scrivi un nuovo valore per la luminosita'");
            while (!valid) {
                try {
                    brightness = Integer.parseInt(scanner.nextLine().trim());
                    if (brightness > 5 || brightness < 0) {
                        throw new NumberFormatException();
                    } else valid = true;

                } catch (NumberFormatException e) {
                    System.out.println("numero non valido o troppo alto/basso, riprova");
                }

            }
            imge.setBrightness(brightness);
            System.out.println("luminosita'cambiata in : " + imge.getBrightness());
        }
        if (multimedia instanceof Video) {
            Video vid = (Video) multimedia;
            System.out.println("luminosita' corrente=" + vid.getBrightness());
            System.out.println("scrivi un nuovo valore per la luminosita'");
            while (!valid) {
                try {
                    brightness = Integer.parseInt(scanner.nextLine().trim());
                    if (brightness > 5 || brightness < 0) {
                        throw new NumberFormatException();
                    } else valid = true;

                } catch (NumberFormatException e) {
                    System.out.println("numero non valido o troppo alto/basso, riprova");
                }

            }
            vid.setBrightness(brightness);
            System.out.println("luminosita'cambiata in : " + vid.getBrightness());
        }
        menuCreation();

    }

    public static void checkMediaType() {
        boolean valid = false;
        String name = "";
        System.out.println("crea un muovo media...");
        while (!valid) {
            System.out.println("che tipo di media vuoi creare? scrivi bene! \nscegli tra : \n-Image \n-Video \n-Audio");
            name = scanner.nextLine().toLowerCase();
            if (name.equals("image") || name.equals("video") || name.equals("audio")) valid = true;
        }
        redirectCreateMedia(name);
    }

    public static void redirectCreateMedia(String name) {
        switch (name) {
            case "image" -> createImage();
            case "video" -> createVideo();
            case "audio" -> createAudio();
        }
    }

    public static void createImage() {
        int brightness = 0;
        boolean valid = false;
        System.out.println("come vuoi chiamare l'immagine?");
        String name = scanner.nextLine().trim();
        System.out.println("quanta luminosita? da 1-5");
        while (!valid) {
            try {
                brightness = Integer.parseInt(scanner.nextLine().trim());
                if (brightness > 5 || brightness < 0) {
                    throw new NumberFormatException();
                } else valid = true;

            } catch (NumberFormatException e) {
                System.out.println("numero non valido o troppo alto/basso, riprova");
            }

        }
        Image img = new Image(name, brightness);
        multimedia.add(img);
        menuCreation();

    }

    public static void createVideo() {
        int duration = 0;
        int brightness = 0;
        int volume = 0;
        boolean valid = false;
        System.out.println("come vuoi chiamare il video?");
        String name = scanner.nextLine().trim();
        System.out.println("quanto dura? da 1-5 minuti");
        while (!valid) {
            try {
                duration = Integer.parseInt(scanner.nextLine().trim());
                if (duration > 5 || duration < 0) {
                    throw new NumberFormatException();
                } else valid = true;

            } catch (NumberFormatException e) {
                System.out.println("numero non valido o troppo alto/basso, riprova");
            }

        }
        valid = false;
        System.out.println("quanta luminosita? da 1-5");
        while (!valid) {
            try {
                brightness = Integer.parseInt(scanner.nextLine().trim());
                if (brightness > 5 || brightness < 0) {
                    throw new NumberFormatException();
                } else valid = true;

            } catch (NumberFormatException e) {
                System.out.println("numero non valido o troppo alto/basso, riprova");
            }

        }
        valid = false;
        System.out.println("quanto volume? da 1-5");
        while (!valid) {
            try {
                volume = Integer.parseInt(scanner.nextLine().trim());
                if (volume > 5 || volume < 0) {
                    throw new NumberFormatException();
                } else valid = true;

            } catch (NumberFormatException e) {
                System.out.println("numero non valido o troppo alto/basso, riprova");
            }

        }
        Video video = new Video(name, duration, volume, brightness);
        multimedia.add(video);
        menuCreation();

    }

    public static void createAudio() {
        int duration = 0;
        int volume = 0;
        boolean valid = false;
        System.out.println("come vuoi chiamare l'audio?");
        String name = scanner.nextLine().trim();
        System.out.println("quanto dura? da 1-5 minuti");
        while (!valid) {
            try {
                duration = Integer.parseInt(scanner.nextLine().trim());
                if (duration > 5 || duration < 0) {
                    throw new NumberFormatException();
                } else valid = true;

            } catch (NumberFormatException e) {
                System.out.println("numero non valido o troppo alto/basso, riprova");
            }

        }
        valid = false;
        System.out.println("quanto volume? da 1-5");
        while (!valid) {
            try {
                volume = Integer.parseInt(scanner.nextLine().trim());
                if (volume > 5 || volume < 0) {
                    throw new NumberFormatException();
                } else valid = true;

            } catch (NumberFormatException e) {
                System.out.println("numero non valido o troppo alto/basso, riprova");
            }

        }
        Audio audio = new Audio(name, duration, volume);
        multimedia.add(audio);
        menuCreation();
    }

    public static void menuStart() {
        System.out.println("Media disponibili:");
        for (int i = 0; i < multimedia.size(); i++) {
            System.out.println("-" + multimedia.get(i));
        }
        System.out.println("premi qualsiasi tasto per entrare nel player oppure 'x' per terminare");
        System.out.println("puoi anche premere 'i' per accedere al menu di creazione/modifica");
        String response = scanner.nextLine().trim();
        if (response.equals("x")) {
            scanner.close();
        } else if (response.equals("i")) {
            menuCreation();
        } else {
            menuPlayer();
        }

    }

    public static void menuPlayer() {
        System.out.println("menu del player, seleziona il numero del media per riprodurlo! \npremi '0' per tornare alla home");
        for (int i = 0; i < multimedia.size(); i++) {
            System.out.println((i + 1) + " - " + multimedia.get(i));
        }
        int numberSelected = 0;
        boolean valid = false;
        while (!valid) {
            try {
                numberSelected = Integer.parseInt(scanner.nextLine().trim());
                if (numberSelected == 0) {
                    menuStart();
                } else if (numberSelected > multimedia.size() || numberSelected < 1) {
                    throw new NumberFormatException();
                } else valid = true;

            } catch (NumberFormatException e) {
                System.out.println("numero non valido o troppo alto/basso, riprova");
            }

        }
        selectedMedia(numberSelected);


    }

    public static void selectedMedia(int n) {
        System.out.println("media riprodotto : \n" + multimedia.get(n - 1));
        if (multimedia.get(n - 1) instanceof Image) {
            Image img = (Image) multimedia.get(n - 1);
            img.show();
        } else {
            Playable playable = (Playable) multimedia.get(n - 1);
            playable.play();
        }
        System.out.println("vuoi tornare al menu del player? premi un qualsiasi tasto");
        System.out.println("oppure premi 'x'per terminare l'attivita'");
        String response = scanner.nextLine().trim();
        if (response.equals("x")) scanner.close();
        else menuPlayer();
    }


}
