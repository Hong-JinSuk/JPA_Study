package hellojpa;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.JOINED) // 각 테이블을 나누는 방법, 편의성이 좋음 솔직히 제일 좋은듯
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // 하나의 테이블로 하는 방법, 성능이 좋음, DTYPE 이 없으면 구별할 수 없으므로 자동으로 들어간다.
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) // 애는 쓰면 안되는 스타일...
@DiscriminatorColumn // about DTYPE : Entity 명으로 들어온다.
@Getter @Setter
public abstract class Item {

    @Id @GeneratedValue
    private Long id;

    private String name;
    private int price;


}
