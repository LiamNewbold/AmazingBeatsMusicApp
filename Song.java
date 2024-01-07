public class Song {
    private String title;
    private String artist;
    private int playCount;

    // Initiates class and key attributes
    public Song(String title, String artist, int playCount) {
        this.title = title;
        this.artist = artist;
        this.playCount = playCount;
    }

    // Returns the song title
    public String getTitle() {
        return title;
    }

    // Returns the song artist
    public String getArtist() {
        return artist;
    }

    // Returns the play count
    public int getPlayCount() {
        return playCount;
    }

    // Increments the play count
    public void incrementPlayCount() {
        playCount++;
    }

    // Increments the playcount by the incremenet measurement
    public void incrementPlayCountBy(int increment) {
        playCount += increment;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Artist: " + artist + ", Play Count: " + playCount;
    }
}

