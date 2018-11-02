package com.keops.keops.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "photo")
public class Photo extends AuditModel {

    @Id
    @GeneratedValue
    @Column(name = "PHOTO_ID")
    private Long id;

    @Column(name = "LIKE_COUNT", nullable = false)
    private String likeCount;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ALBUM_ID", nullable = false)
    private Album album;

    @OneToMany(mappedBy = "photo")
    private Set<Like> photoLikes;

    @OneToMany(mappedBy = "photo")
    private Set<PhotoKeywords> photoKeyword;

    public Photo() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
