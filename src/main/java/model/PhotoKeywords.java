package model;

import javax.persistence.*;

@Entity
@Table(name = "photoKeywords")
public class PhotoKeywords {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "KEYWORDS_ID", unique = true, nullable = false)
    private Integer id;

    @Column(name = "KEYWORD", unique = true, nullable = false)
    private Integer keyword;

    @ManyToOne
    @JoinColumn(name = "PHOTO_ID", nullable = false)
    private Photo photo;

    public PhotoKeywords() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getKeyword() {
        return keyword;
    }

    public void setKeyword(Integer keyword) {
        this.keyword = keyword;
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo1) {
        photo = photo1;
    }
}
