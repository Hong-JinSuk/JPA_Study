package hellojpa.member;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class MemberV3 {
    @Id
    private Long id;

    // 객체는 username이라고 쓰고 싶은데 DB에는 name이라고 쓸 때, 이렇게 사용.
    // updatable : false 로 성정하면 현재 상태에서 값이 변경되지 않는다.
    // nullable : false 이면 null이 들어가면 NotNull 제약조건이 걸린다.
    // unique : true 이면 말 그대로 유니크한 값이 들어감. 단, 이름이 너무 이상해서 잘 안쓴다. (오류 등 이름을 반영하기 힘들어서)
    @Column(name = "name")
    private String username;

    private Integer age;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    private LocalDate testLocalDate;
    private LocalDateTime testLocalDateTime;

    // 큰 컨텐츠를 쓰고 싶을 때, 사용한다.
    @Lob
    private String description;

    @Transient
    private int temp;

    public MemberV3() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
