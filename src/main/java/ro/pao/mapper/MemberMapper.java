package ro.pao.mapper;

import ro.pao.model.Book;
import ro.pao.model.Location;
import ro.pao.model.Member;
import ro.pao.model.Publisher;
import ro.pao.model.enums.Genre;
import ro.pao.model.enums.MemberType;
import ro.pao.model.enums.Section;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class MemberMapper {
    private static final MemberMapper INSTANCE = new MemberMapper();

    private MemberMapper() {

    }

    public static MemberMapper getInstance() {
        return INSTANCE;
    }

    public Optional<Member> mapToMember(ResultSet resultSet) throws SQLException {
        if(resultSet.next()) {
            return Optional.of(
                    Member.builder()
                            .id(UUID.fromString(resultSet.getString("id")))
                            .name(resultSet.getString("name"))
                            .memberType(MemberType.valueOf(resultSet.getString("memberType")))
                            .build()
            );
        } else {
            return Optional.empty();
        }
    }

    public List<Member> mapToMemberList(ResultSet resultSet) throws SQLException {
        List<Member> memberList = new ArrayList<>();

        while (resultSet.next()) {
            memberList.add(
                    Member.builder()
                            .id(UUID.fromString(resultSet.getString("id")))
                            .name(resultSet.getString("name"))
                            .memberType(MemberType.valueOf(resultSet.getString("memberType")))
                            .build()
            );
        }

        return memberList;
    }

}
