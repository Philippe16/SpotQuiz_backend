package dtos;

import entities.Music;

public class MusicDTO {
    private String songID;
    private String title;
    private String artist;
    private String coverImgLink;
    private String songSnippetLink;


    public MusicDTO() {
    }

    public MusicDTO(Music music) {
        this.songID = music.getSongID();
        this.title = music.getTitle();
        this.artist = music.getArtist();
        this.coverImgLink = music.getCoverImgLink();
        this.songSnippetLink = music.getSongSnippetLink();
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

    public String getSongSnippetLink() {
        return songSnippetLink;
    }

    public void setSongSnippetLink(String songSnippetLink) {
        this.songSnippetLink = songSnippetLink;
    }
}
