package hellojpa.member;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * SEQUENCE 전략 - 매핑
 */

@Entity
@SequenceGenerator(
        name = "MEMBER_SEQ_GENERATOR",
        //매핑할 데이터베이스 시퀀스 이름
        sequenceName = "MEMBER_SEQ",
        initialValue = 1, allocationSize = 1)
public class MemberV5 {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "MEMBER_SEQ_GENERATOR")
    private Long id;

    @Column(name = "name", nullable = false)
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }
}
