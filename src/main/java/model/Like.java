package model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "like")
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "LIKE_ID", unique = true, nullable = false)
    private Integer id;

    /* HAS A relationship */
    @OneToOne(cascade = CascadeType.ALL)
    private User admirer;

    @ManyToOne
    @JoinColumn(name = "PHOTO_ID", nullable = false)
    private Photo photo;

    @Temporal(TemporalType.DATE)
    @Column(name = "CREATED_AT", nullable = false)
    private Date createdAt;

    public Like() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getAdmirer() {
        return admirer;
    }

    public void setAdmirer(User admirer1) {
        admirer = admirer1;
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo1) {
        photo = photo1;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
