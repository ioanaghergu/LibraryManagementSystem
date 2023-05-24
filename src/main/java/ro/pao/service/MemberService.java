package ro.pao.service;

import ro.pao.model.Member;

import java.sql.SQLException;
import java.util.Optional;

public interface MemberService extends Service<Member> {
    Optional<Member> getByName(String name) throws SQLException;
}
