package ro.pao.service.impl;

import lombok.Getter;
import lombok.NoArgsConstructor;
import ro.pao.model.Member;
import ro.pao.service.MemberService;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter
public class MemberServiceImpl implements MemberService {
    private static Map<UUID, Member> memberList = new HashMap<>();

    @Override
    public Optional<Member> getByID(UUID id) {
        return memberList.values()
                .stream()
                .filter(member -> id.equals(member.getId()))
                .findFirst();
    }

    @Override
    public Optional<Member> getByName(String name) {
        return memberList.values()
                .stream()
                .filter(member -> name.equals(member.getName()))
                .findFirst();
    }

    @Override
    public Map<UUID, Member> getAllFromMap() {
        return memberList;
    }

    @Override
    public void addOnlyOne(Member member) {
        memberList.put(member.getId(), member);

    }

    @Override
    public void removeMemberById(UUID id) {
        memberList = memberList.entrySet()
                .stream()
                .filter(member -> !id.equals(member.getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    @Override
    public void editMemberById(UUID id, Member newMember) {
        removeMemberById(id);
        addOnlyOne(newMember);
    }
}