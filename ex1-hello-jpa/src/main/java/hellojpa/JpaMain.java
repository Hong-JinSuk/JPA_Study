package hellojpa;

import jakarta.persistence.*;

import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        // EntityManagerFactory를 만들면 일단, DB 및 다양한 기능은 된다고 볼 수 있다.
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        // 연결된 곳에서 하나의 매니저를 불러온다.
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin(); // 트랜잭션 시작

        try {

//            Member findMember = em.find(Member.class, 1L); Member 에서 Key = 1 인 데이터 받아옴.
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


            tx.commit(); // 트랜잭션 종료
        } catch (Exception e) {
            System.out.println("rollback");
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
