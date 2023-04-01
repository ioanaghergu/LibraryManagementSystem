package ro.pao.service;

import ro.pao.model.Member;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public interface MemberService {

    Optional<Member> getByID(UUID id);

    Optional<Member> getByName(String name);

    Map<UUID, Member> getAllFromMap();

    void addOnlyOne(Member member);

    void removeMemberById(UUID id);

    void editMemberById(UUID id, Member newMember);
}
