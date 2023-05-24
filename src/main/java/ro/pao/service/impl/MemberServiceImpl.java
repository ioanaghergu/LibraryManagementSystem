package ro.pao.service.impl;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ro.pao.model.Member;
import ro.pao.repository.MemberRepository;
import ro.pao.service.MemberService;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Getter

public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public Optional<Member> getById(UUID id) throws SQLException {
        return memberRepository.getById(id);
    }

    @Override
    public Optional<Member> getByName(String name) throws SQLException {
        return memberRepository.getByName(name);
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
