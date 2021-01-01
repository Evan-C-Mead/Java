package music;

public class Music {

    private String artistName;
    private String genre;
    private String album;
    private String song;

    public Music(String artistName, String genre, String album, String song) {
        this.artistName = artistName;
        this.genre = genre;
        this.album = album;
        this.song = song;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }
}
