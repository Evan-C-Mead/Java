package music;

import util.Input;
import java.util.Arrays;

public class MusicApp {

    public static void main(String[] args) {
        playMusic();
    }

    public static void playMusic() {
        Music[] musicList = MusicList.allMusic();
        Input input = new Input();
        boolean pickOption = true;

        while (pickOption) {
            System.out.println("What would you like to look up?\n");
            System.out.println("0 - exit");
            System.out.println("1 - view all music");
            System.out.println("2 - view all artists");
            System.out.println("3 - view all genres");
            System.out.println("4 - view all albums");
            System.out.println("5 - view all songs");
            int userChoice = input.getInt();
            System.out.println();
            switch (userChoice) {
                case (0):
                    System.out.println("Are you sure you want to quit?");
                    boolean userConfirm = input.yesNo();
                    System.out.println();
                    if (userConfirm) {
                        pickOption = false;
                        System.out.println("This list is pretty neat...your loss...program terminated!");
                    } else {
                        System.out.println("Pick an option.");
                    }
                    break;
                case (1):
                    for (Music music : musicList) {
                        System.out.println(music.getArtistName() + " - " + music.getGenre() + " - " + music.getAlbum() + " - " + music.getSong());
                    }
                    System.out.println();
                    break;
                case (2):
                    for (Music music : musicList) {
                        System.out.println(music.getArtistName());
                    }
                    System.out.println();
                    break;
                case (3):
                    for (Music music : musicList) {
                        System.out.println(music.getGenre());
                    }
                    System.out.println();
                    break;
                case (4):
                    for (Music music : musicList) {
                        System.out.println(music.getAlbum() + " - by " + music.getArtistName());
                    }
                    System.out.println();
                    break;
                case (5):
                    for (Music music : musicList) {
                        System.out.println(music.getSong() + " - by " + music.getArtistName());
                    }
                    System.out.println();
                    break;
                default:
                    break;
            }
        }
    }

}
