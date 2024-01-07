import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class AmazingBeatsMusicApp {
    private List<Song> songs = new ArrayList<>();

    public static void main(String[] args) {
        AmazingBeatsMusicApp app = new AmazingBeatsMusicApp();
        app.initialiseSongs(); 

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nAmazingBeats App Menu:");
            System.out.println("1. Add a new song");
            System.out.println("2. Remove a song");
            System.out.println("3. Print all songs");
            System.out.println("4. Print songs over a given play count");
            System.out.println("5. Exit");

            System.out.print("Enter your choice (1-5): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    app.addNewSong(scanner); // Call addNewSong method
                    break;
                case 2:
                    app.removeSong(scanner); // Call removeSong method
                    break;
                case 3:
                    app.simulateRandomPlay(); // Call simulateRandomPlay method to increase the listen/stream count before the songs are printed - implies that people are actively listening
                    app.printAllSongs(); // Call printAllSongs method
                    break;
                case 4:
                    app.printSongsOverPlayCount(scanner); // Call printSongsOverPlayerCount
                    break;
                case 5:
                    System.out.println("...Exiting Music Streaming App...");
                    System.exit(0); // Exits application
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
    }

    private void initialiseSongs() {
        // Song Details
        songs.add(new Song("Look At The Clouds", "Songer", 54230));
        songs.add(new Song("Sajna", "Caps", 34560));
        songs.add(new Song("Love", "Young Smokes", 20242));
        songs.add(new Song("Provisional Licence", "M1llionz", 40634));
        songs.add(new Song("On My Way", "Bad Boy Chiller Crew", 10342));
        songs.add(new Song("WYD Now?", "Sadie Jean", 103625));
        songs.add(new Song("I'd rather you cheat", "Songer", 30242));
        songs.add(new Song("3:15 (Breathe)", "Russ", 40757));
        songs.add(new Song("Chasing Cars", "Snow Patrol", 30964));
        songs.add(new Song("Mr. Brightside", "The Killers", 801343));

        // Increase song play count randomly when called
        simulateRandomPlay();
    }

    private void simulateRandomPlay() {
        Random random = new Random();
        for (Song song : songs) {
            int randomIncrement = random.nextInt(50000); // Random number between 0 and 50,000
            song.incrementPlayCountBy(randomIncrement); // Call incrementPlayCountBy method
        }
    }

    private void addNewSong(Scanner scanner) {
        System.out.print("Enter song title: ");
        String title = scanner.nextLine();

        System.out.print("Enter artist name: ");
        String artist = scanner.nextLine();

        songs.add(new Song(title, artist, 0));
        System.out.println("Song added successfully!");
    }

    private void removeSong(Scanner scanner) {
        System.out.print("Enter the title of the song to remove: ");
        String titleToRemove = scanner.nextLine();

        Iterator<Song> iterator = songs.iterator();
        while (iterator.hasNext()) {
            Song song = iterator.next();
            if (song.getTitle().equalsIgnoreCase(titleToRemove)) {
                iterator.remove();
                System.out.println("Song removed successfully!");
                return;
            }
        }

        System.out.println("Song not found.");
    }

    private void printAllSongs() {
        System.out.println("\nAll Songs:");
        for (Song song : songs) {
            System.out.println(song);
        }
    }

    private void printSongsOverPlayCount(Scanner scanner) {
        System.out.print("Enter the minimum play count: ");
        int minPlayCount = scanner.nextInt();

        System.out.println("\nSongs with play count over " + minPlayCount + ":");
        for (Song song : songs) {
            if (song.getPlayCount() > minPlayCount) {
                System.out.println(song);
            }
        }
    }
}
