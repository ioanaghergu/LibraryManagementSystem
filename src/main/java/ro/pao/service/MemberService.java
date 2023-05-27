package ro.pao.service;

import ro.pao.exceptions.ObjectNotFound;
import ro.pao.model.Member;

import java.sql.SQLException;
import java.util.Optional;

public sealed interface MemberService extends Service<Member> permits MemberServiceImpl {
    Optional<Member> getByName(String name) throws SQLException;
}
