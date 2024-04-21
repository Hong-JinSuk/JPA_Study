package jpabook.jpashop.domain;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;

@Entity
@Getter @Setter
public class Album extends Item {

    private String artist;
    private String etc;
}
