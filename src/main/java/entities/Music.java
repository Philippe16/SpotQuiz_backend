package entities;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table (name = "music")
public class Music {

    @Id
    @Basic(optional = false)
    @Size(max = 100)
    @NotNull
    @Column(name = "music_id")
    private String songID;

    @NotNull
    @Basic(optional = false)
    @Size(max = 250)
    @Column(name = "title")
    private String title;

    @NotNull
    @Basic(optional = false)
    @Size(max = 250)
    @Column(name = "artist")
    private String artist;

    @NotNull
    @Basic(optional = false)
    @Size(max = 250)
    @Column(name = "cover_img_link")
    private String coverImgLink;

    @NotNull
    @Basic(optional = false)
    @Size(max = 250)
    @Column(name = "audio_snippet_link")
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


