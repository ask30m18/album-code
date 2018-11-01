package model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "photo")
public class Photo {

    @Id
    @GeneratedValue
    @Column(name = "PHOTO_ID")
    private long id;

    @Column(name = "CREATED_DATE", nullable = false)
    private String createdDate;

    @Column(name = "LIKE_COUNT", nullable = false)
    private String likeCount;

    @ManyToOne
    @JoinColumn(name = "ALBUM_ID", nullable = false)
    private Album album;

    @OneToMany(mappedBy = "photo")
    private Set<Like> photoLikes;

    @OneToMany(mappedBy = "photo")
    private Set<PhotoKeywords> photoKeyword;

    public Photo() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(String likeCount) {
        this.likeCount = likeCount;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album1) {
        album = album1;
    }

    public Set<Like> getPhotoLikes() {
        return photoLikes;
    }

    public void setPhotoLikes(Set<Like> photoLikes) {
        this.photoLikes = photoLikes;
    }

    public Set<PhotoKeywords> getPhotoKeyword() {
        return photoKeyword;
    }

    public void setPhotoKeyword(Set<PhotoKeywords> photoKeyword) {
        this.photoKeyword = photoKeyword;
    }
}
