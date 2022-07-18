package com.javeriana.web.project.Questions.Question.Infrastructure.hibernate;


import com.javeriana.web.project.Questions.Question.Domain.Ports.QuestionRepository;
import com.javeriana.web.project.Questions.Question.Domain.Question;
import com.javeriana.web.project.Questions.Question.Domain.ValueObjects.QuestionId;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional("transactional-manager")
public class HibernateQuestionRepository implements QuestionRepository {

    protected final SessionFactory sessionFactory;
    protected final Class<Question> aggregateClass;

    public HibernateQuestionRepository(@Qualifier("session-factory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        this.aggregateClass = Question.class;
    }


    @Override
    public void save(Question question) {
        sessionFactory.getCurrentSession().save(question);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().clear();
    }

    @Override
    public Optional<Question> find(String questionId) {
        return Optional.ofNullable(sessionFactory.getCurrentSession().byId(aggregateClass).load(new QuestionId(questionId)));
    }

    @Override
    public Question update(String questionId, Question question) {
        sessionFactory.getCurrentSession().saveOrUpdate(questionId,question);
        return sessionFactory.getCurrentSession().byId(aggregateClass).load(new QuestionId(questionId));
    }

    @Override
    public Optional<List<Question>> findUnAnsweredQuestions() {
        String hql = "FROM Question E WHERE E.answer IS NULL OR E.answer = ''";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        return Optional.ofNullable(query.list());
    }

}
