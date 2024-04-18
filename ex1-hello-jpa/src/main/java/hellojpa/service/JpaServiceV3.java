package hellojpa.service;

import hellojpa.member.Member;
import hellojpa.member.MemberV3;
import hellojpa.member.RoleType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import static hellojpa.member.RoleType.*;

public class JpaServiceV3 {

    private EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction tx;

    public JpaServiceV3(String persistenceName) {
        this.emf = Persistence.createEntityManagerFactory(persistenceName);
        this.em = emf.createEntityManager();
        this.tx = em.getTransaction();
    }

    public void runService() {
        tx.begin();


//        em.persist(member);

        try {
            tx.commit();
        } catch (Exception e) {
            System.out.println("[ RollBack Error : ]");
            e.printStackTrace();
            tx.rollback();
        } finally {
            em.close();
        }
    }

    private static void createMember(MemberV3 findMember, Long id, String username, Integer age, RoleType type) {
        findMember.setId(id);
        findMember.setUsername(username);
        findMember.setAge(age);
        findMember.setRoleType(type);
    }

    public void close() {
        emf.close();
    }
}
