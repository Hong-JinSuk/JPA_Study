package hellojpa.service;

import hellojpa.member.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JpaServiceV1 {

    private EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction tx;

    public JpaServiceV1(String persistenceName) {
        this.emf = Persistence.createEntityManagerFactory(persistenceName);
        this.em = emf.createEntityManager();
        this.tx = em.getTransaction();
    }

    public void runService() {
        tx.begin();

        try {
            Member findMember = em.find(Member.class, 1L); // Member 에서 Key = 1 인 데이터 받아옴.
//            member.setName("?????"); // data 설정 및 수정 가능

//            em.persist(member); // 멤버 insert
//            em.flush(); // 즉시 DB에 반영
//            em.detach(member); // 영속 해제
//            em.clear(); // 전체 영속 해제

//            tx.rollback(); // 롤백

//            List<Member> result = em.createQuery("select m from Member as m", Member.class)
//                    .getResultList(); // 모두 받아옴

//            List<Member> result = em.createQuery("select m from Member as m", Member.class)
//                    .setFirstResult(2) // index ~ 다 검색
//                    .setMaxResults(2) // index 개수만큼 검색
//                    .getResultList(); // 2,3 index 검색

//            for (Member member : result) {
//                System.out.println("member.getName() = " + member.getName());
//            }
            tx.commit();
        } catch (Exception e) {
            System.out.println("[ RollBack Error : ]");
            e.printStackTrace();
            tx.rollback();
        } finally {
            em.close();
        }
    }

    public void close() {
        emf.close();
    }
}
