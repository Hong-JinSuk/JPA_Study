package hellojpa.service;

import hellojpa.member.MemberV3;
import hellojpa.member.MemberV4;
import hellojpa.member.RoleType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JpaServiceV4 {

    private EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction tx;

    public JpaServiceV4(String persistenceName) {
        this.emf = Persistence.createEntityManagerFactory(persistenceName);
        this.em = emf.createEntityManager();
        this.tx = em.getTransaction();
    }

    public void runService() {
        tx.begin();
        try {

            MemberV4 member = new MemberV4();
            member.setUsername("C");

            em.persist(member);
            tx.commit();
        } catch (Exception e) {
            System.out.println("[ RollBack Error : ]");
            e.printStackTrace();
            tx.rollback();
        } finally {
            em.close();
        }
    }

    private static void createMember(MemberV4 member, Long id, String username, Integer age, RoleType type) {
        member.setId(id);
        member.setUsername(username);
        member.setAge(age);
        member.setRoleType(type);
    }

    public void close() {
        emf.close();
    }
}
