package hellojpa;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;
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
      team.setName("team");
      entityManager.persist(team);

      Team otherTeam = new Team();
      otherTeam.setName("otherTeam");
      entityManager.persist(otherTeam);

      Member member = new Member();
      member.setUsername("member");
      member.setAge(10);
      member.setTeam(team);
      entityManager.persist(member);

      Member otherMember = new Member();
      otherMember.setUsername("otherMember");
      otherMember.setAge(10);
      otherMember.setTeam(otherTeam);
      entityManager.persist(otherMember);

      Member anotherMember = new Member();
      anotherMember.setUsername("anotherMember");
      anotherMember.setAge(10);
      anotherMember.setTeam(otherTeam);
      entityManager.persist(anotherMember);
      entityManager.flush();
      entityManager.clear();

      int rstCnt = entityManager.createQuery("update Member m set m.age = 20")
              .executeUpdate();

      System.out.println("rstCnt = " + rstCnt);

      transaction.commit();

    } catch (Exception e) {
      transaction.rollback();
    }
  }
}
