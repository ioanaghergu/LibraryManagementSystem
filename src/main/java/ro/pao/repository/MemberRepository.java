package ro.pao.repository;

import ro.pao.exceptions.ObjectNotFound;
import ro.pao.model.Member;

import java.sql.SQLException;
import java.util.Optional;

public interface MemberRepository extends Repository<Member> {
    Optional<Member> getByName(String name) throws SQLException, ObjectNotFound;
}
