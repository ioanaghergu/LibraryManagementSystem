package ro.pao.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ro.pao.application.csv.CsvFormatter;
import ro.pao.application.csv.CsvWriter;
import ro.pao.exceptions.ObjectNotFound;
import ro.pao.model.Member;
import ro.pao.repository.MemberRepository;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

@RequiredArgsConstructor
@Getter

public non-sealed class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    private static final Logger logger = Logger.getGlobal();

    private static final CsvFormatter CSV_FORMATTER = CsvFormatter.getInstance();

    private static final CsvWriter CSV_WRITER = CsvWriter.getInstance();

    Path auditPath = Paths.get("audit.csv");

    @Override
    public Optional<Member> getById(UUID id) throws SQLException {

        Optional<Member> member = Optional.empty();

        try {
            member = memberRepository.getById(id);

            LogRecord record = new LogRecord(Level.INFO, "Retrieved member with ID: " + id);

            CSV_WRITER.writeLine(CSV_FORMATTER.format(record), auditPath);

        } catch (Exception e) {
            logger.log(Level.WARNING, e.getMessage());

        }
        return member;
    }

    @Override
    public Optional<Member> getByName(String name) throws SQLException, ObjectNotFound {

        Optional<Member> member = Optional.empty();

        try {
            member = memberRepository.getByName(name);

            LogRecord record = new LogRecord(Level.INFO, "Retrieved member with name: " + name);

            CSV_WRITER.writeLine(CSV_FORMATTER.format(record), auditPath);

        } catch (ObjectNotFound e) {
            logger.log(Level.WARNING, e.getMessage());

        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage());
        }

        return member;
    }

    @Override
    public void addOnlyOne(Member member) throws SQLException {

        try {
            memberRepository.addNewObject(member);

            LogRecord record = new LogRecord(Level.INFO, "Added new member: " + member.getName());

            CSV_WRITER.writeLine(CSV_FORMATTER.format(record), auditPath);

        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
    }

    @Override
    public void editById(UUID id, Member member) {

        try {
            memberRepository.editById(id, member);

            LogRecord record = new LogRecord(Level.INFO, "Updated member with ID: " + id);

            CSV_WRITER.writeLine(CSV_FORMATTER.format(record), auditPath);

        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage());
        }


    }

    @Override
    public void removeById(UUID id) {

        try {
            memberRepository.deleteById(id);

            LogRecord record = new LogRecord(Level.INFO, "Deleted member with ID: " + id);

            CSV_WRITER.writeLine(CSV_FORMATTER.format(record), auditPath);

        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage());
        }

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
