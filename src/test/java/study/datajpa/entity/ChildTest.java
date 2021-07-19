package study.datajpa.entity;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@SpringBootTest
@Transactional
public class ChildTest {

    @PersistenceContext
    private EntityManager em;

    @Test
    @Rollback(value = false)
    public void saveNoCascade() {
        Parent parent = new Parent();
        em.persist(parent);

        Child child1 = new Child();
        child1.setParent(parent);
        parent.getChildren().add(child1);
        em.persist(child1);

        Child child2 = new Child();
        child2.setParent(parent);
        parent.getChildren().add(child2);
        em.persist(child2);
    }

    @Test
    @Rollback(value = false)
    public void saveWithCascade() {
        Child child1 = new Child();
        Child child2 = new Child();

        Parent parent = new Parent();
        parent.addChild(child1);
        parent.addChild(child2);


        em.persist(parent);
    }

    @Test
    @Rollback(value = false)
    public void findWithCascade() {
        Parent parent = em.find(Parent.class, 1018L);
        for (Child child : parent.getChildren()) {
            System.out.println(child.getId());
        }
    }

    @Test
    @Rollback(value = false)
    public void removeWithCascade() {
        Parent parent = em.find(Parent.class, 1421L);
        parent.getChildren().remove(0);
    }
}
