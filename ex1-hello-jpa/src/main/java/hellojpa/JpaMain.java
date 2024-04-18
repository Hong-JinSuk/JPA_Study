package hellojpa;

import hellojpa.service.JpaServiceV1;
import hellojpa.service.JpaServiceV3;
import jakarta.persistence.*;

import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        JpaServiceV3 service = new JpaServiceV3("hello");
        service.runService();
        service.close();
    }
}
