package hellojpa;

import hellojpa.service.JpaServiceV1;
import hellojpa.service.JpaServiceV3;
import hellojpa.service.JpaServiceV4;
import hellojpa.service.JpaServiceV5;
import jakarta.persistence.*;

import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        JpaServiceV5 service = new JpaServiceV5("hello");
        service.runService();
        service.close();
    }
}
