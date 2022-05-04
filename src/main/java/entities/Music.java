package entities;

import javax.persistence.*;

@Entity
@Table (name = "music")
public class Music {

    @Id
    @Basic(optional = false)
    @Column(name = "music_id", nullable = false, unique = true)
    private String songID;

    @Basic(optional = false)
    @Column(name = "title", nullable = false)
    private String title;

    @Basic(optional = false)
    @Column(name = "artist", nullable = false)
    private String artist;

    @Basic(optional = false)
    @Column(name = "cover_img_link", nullable = false)
    private String coverImgLink;

    @Basic(optional = false)
    @Column(name = "audio_snippet_link", nullable = false)
    private String songSnippetLink;

    public Music() {
    }

    public Music(String songID, String title, String artist, String coverImgLink, String songSnippetLink) {
        this.songID = songID;
        this.title = title;
        this.artist = artist;
        this.coverImgLink = coverImgLink;
        this.songSnippetLink = songSnippetLink;
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


