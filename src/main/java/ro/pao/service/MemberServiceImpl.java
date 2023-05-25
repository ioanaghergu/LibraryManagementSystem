package ro.pao.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ro.pao.exceptions.ObjectNotFound;
import ro.pao.model.Member;
import ro.pao.repository.MemberRepository;
import ro.pao.service.MemberService;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

@RequiredArgsConstructor
@Getter

public non-sealed class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    private static final Logger logger = Logger.getGlobal();

    @Override
    public Optional<Member> getById(UUID id) throws SQLException {
        return memberRepository.getById(id);
    }

    @Override
    public Optional<Member> getByName(String name) throws SQLException, ObjectNotFound {

        Optional<Member> member = Optional.empty();

        try {
            member = memberRepository.getByName(name);

        } catch (ObjectNotFound e) {
            logger.log(Level.WARNING, e.getMessage());

        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage());
        }

        return member;
    }

    @Override
    public void addOnlyOne(Member member) throws SQLException {
        memberRepository.addNewObject(member);
    }

    @Override
    public void editById(UUID id, Member member) {
        memberRepository.editById(id, member);
    }

    @Override
    public void removeById(UUID id) {
        memberRepository.deleteById(id);
    }

    @Override
    public List<Member> getAllFromList() {
        return memberRepository.getAll();
    }

    @Override
    public void addAllFromGivenList(List<Member> members) {
        memberRepository.addAllFromGivenList(members);
    }
}
