package hellojpa.service;

import hellojpa.member.MemberV4;
import hellojpa.member.MemberV5;
import hellojpa.member.RoleType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JpaServiceV5 {

    private EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction tx;

    public JpaServiceV5(String persistenceName) {
        this.emf = Persistence.createEntityManagerFactory(persistenceName);
        this.em = emf.createEntityManager();
        this.tx = em.getTransaction();
    }

    public void runService() {
        tx.begin();
        try {

            MemberV5 member1 = new MemberV5();
            member1.setUsername("C");

            MemberV5 member2 = new MemberV5();
            member2.setUsername("B");

            MemberV5 member3 = new MemberV5();
            member3.setUsername("C");

            System.out.println("======================");

            em.persist(member1);
            em.persist(member2);
            em.persist(member3);

            System.out.println("======================");
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
