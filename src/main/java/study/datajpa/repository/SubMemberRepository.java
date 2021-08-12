package study.datajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.datajpa.entity.SubMember;

public interface SubMemberRepository extends JpaRepository<SubMember, Long> {
}
