package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaMamberRepository implements MemberRepository{

    private final EntityManager em;

    public JpaMamberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member); // 입력하는게 persist라고..
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {
        em.createQuery("select m from Member m where m.name = :name", Member.class).setParameter("name", name).getResultList();

        return result.
    }

    @Override
    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class).getResultList();
    }
}
