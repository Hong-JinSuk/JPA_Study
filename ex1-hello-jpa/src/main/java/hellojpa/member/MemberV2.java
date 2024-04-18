package hellojpa.member;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Table에 이름을 부여하여 매핑
 */

@Entity
@Table(name = "myTable") // 을 하면 TableName의 테이블에 insert된다.
public class MemberV2 {

    @Id
    private Long id;
    private String name;

    public MemberV2(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public MemberV2() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
