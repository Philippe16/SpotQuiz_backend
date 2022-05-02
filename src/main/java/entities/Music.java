package entities;

public class Music {
    private String songTitle;
    private String artist;
    private String songSnippetLink;

    public Music() {
    }

    public Music(String songTitle, String artist, String songSnippetLink) {
        this.songTitle = songTitle;
        this.artist = artist;
        this.songSnippetLink = songSnippetLink;
    }

    public String getSongTitle() {
        return songTitle;
    }

    public void setSongTitle(String songTitle) {
        this.songTitle = songTitle;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getsongSnippetLink() {
        return songSnippetLink;
    }

    public void setsongSnippetLink(String songSnippetLink) {
        this.songSnippetLink = songSnippetLink;
    }
}
