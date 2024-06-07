package jetz.server.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long index;

    @OneToOne
    @JoinColumn(name = "zname")
    private Zuser zname;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String intro;

    private String profileImg;

    private String backgroundImg;

    private Long hits;

    private String isPublic;

    @OneToMany(mappedBy = "blog", cascade = CascadeType.REMOVE)
    private List<Post> postList;
}
