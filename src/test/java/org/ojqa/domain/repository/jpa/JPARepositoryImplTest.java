package org.ojqa.domain.repository.jpa;

import java.util.Date;

import org.ojqa.domain.pojo.Question;
import org.springframework.orm.jpa.JpaTemplate;

/**
 * I use AbstractTransactionalJUnit4SpringContextTests in version 46 , but it is really slow, so I roll back this test
 * to version 34.
 * 
 * @author iyu
 * 
 */
@SuppressWarnings("deprecation")
public class JPARepositoryImplTest extends BaseJPATest {
    private JpaTemplate jpaTemplate;

    @Override
    public void onSetUpBeforeTransaction() {
        this.jpaTemplate = (JpaTemplate) this.applicationContext.getBean("jpaTemplate");
    }

    public void testSaveQuestion() {
        Question question = new Question();
        question.setBody("body");
        question.setCreateTime(new Date());
        question.setTagNames("test");
        question.setTitle("test");

        this.jpaTemplate.persist(question);
        assertNotNull(question.getId());
        assertNotNull(question.getCreateTime());
    }

}
