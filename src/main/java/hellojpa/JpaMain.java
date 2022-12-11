package hellojpa;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

public class JpaMain {
  public static void main(String[] args) {
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("hellojpa");
    EntityManager entityManager = factory.createEntityManager();
    EntityTransaction transaction = entityManager.getTransaction();
    transaction.begin();

    try {

      Team team = new Team();
      team.setName("teamA");
      entityManager.persist(team);

      Member member = new Member();
      member.setUsername("member1");
      member.setAge(10);
      member.setTeam(team);
      entityManager.persist(member);

      entityManager.flush();
      entityManager.clear();


      String query="select m.username, 'HELLO', true " +
                      " from Member m " +
                      " where m.type =hellojpa.MemberType.ADMIN "
                              ;
      List<Object[]> result = entityManager.createQuery(query).getResultList();

      for (Object[] objects : result) {
        System.out.println("objects[0] = " + objects[0]);
        System.out.println("objects[1] = " + objects[1]);
        System.out.println("objects[2] = " + objects[2]);
      }
      transaction.commit();

    } catch (Exception e) {
      transaction.rollback();
    }
  }
}
