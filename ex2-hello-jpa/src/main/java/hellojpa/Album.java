package hellojpa;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
//@DiscriminatorValue("album") // 규약상 이렇게 넣을 수 있다.
@Getter @Setter
public class Album extends Item{

    private String artist;
}
