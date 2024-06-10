package jetz.server.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long index;

    @ManyToOne
    private Post post;

    @ManyToOne
    @JoinColumn(name = "zname")
    private Zuser zname;

    @Column
    private String content;

    private LocalDateTime regDateTime;

    private LocalDateTime modDateTime;

    private Long likes;
}
