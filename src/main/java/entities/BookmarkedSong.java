package entities;

public class BookmarkedSong {
    private String songID;
    private String title;
    private String artist;
    private String coverImgLink;

    public BookmarkedSong(){

    }

    public BookmarkedSong(String songID, String title, String artist, String coverImgLInk){
        this.songID = songID;
        this.title = title;
        this.artist = artist;
        this.coverImgLink = coverImgLInk;
    }

    public String getSongID() {
        return songID;
    }

    public void setSongID(String songID) {
        this.songID = songID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getCoverImgLink() {
        return coverImgLink;
    }

    public void setCoverImgLink(String coverImgLink) {
        this.coverImgLink = coverImgLink;
    }
}
