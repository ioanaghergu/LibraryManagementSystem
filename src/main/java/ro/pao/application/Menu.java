package ro.pao.application;

import ro.pao.model.Author;
import ro.pao.model.BookCopy;
import ro.pao.model.Member;
import ro.pao.model.enums.Genre;
import ro.pao.model.enums.MemberType;
import ro.pao.model.enums.Section;
import ro.pao.model.enums.Status;
import ro.pao.service.MemberService;
import ro.pao.service.impl.MemberServiceImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class Menu {

    private static Menu INSTANCE;

    private final MemberService memberService = new MemberServiceImpl();

    public static Menu getInstance() {
        return (INSTANCE == null ? new Menu() : INSTANCE);
    }

    private Menu() {
    }

    public void introMember() {

        String intro = "************************** DEMO FOR THE MEMBER SERVICE INTERFACE **************************\n";

        System.out.println(intro);

        List<Author> authors = List.of(
                Author.builder()
                        .id(UUID.randomUUID())
                        .name("Leigh Bardugo")
                        .email("leighbardugo@yahoo.com")
                        .build(),

                Author.builder()
                        .id(UUID.randomUUID())
                        .name("Maggie Stiefvatter")
                        .email("maggiestiefvatter@yahoo.com")
                        .build()
        );

        BookCopy book1 = BookCopy.builder()
                .id(UUID.randomUUID())
                .title("Six of crows")
                .genre(Genre.SCIENCE_FICTION)
                .section(Section.FICTION)
                .publicationDate(LocalDate.of(2023, 3, 31))
                .authors(authors)
                .copies(3)
                .copyNumber(UUID.randomUUID())
                .status(Status.DAMAGED)
                .issueDate(LocalDate.of(2020, 6, 7))
                .dueDate(LocalDate.of(2020, 6, 14))
                .returnDate(LocalDate.of(2020, 6, 20))
                .build();

        BookCopy book2 = BookCopy.builder()
                .id(UUID.randomUUID())
                .title("Crooked kingdom")
                .genre(Genre.SCIENCE_FICTION)
                .section(Section.FICTION)
                .publicationDate(LocalDate.of(2020, 4, 27))
                .authors(authors)
                .copies(7)
                .copyNumber(UUID.randomUUID())
                .status(Status.AVAILABLE)
                .issueDate(LocalDate.of(2021, 5, 7))
                .dueDate(LocalDate.of(2021, 5, 14))
                .returnDate(LocalDate.of(2021, 5, 12))
                .build();

        BookCopy book3 = BookCopy.builder()
                .id(UUID.randomUUID())
                .title("Siege and storm")
                .genre(Genre.SCIENCE_FICTION)
                .section(Section.FICTION)
                .publicationDate(LocalDate.of(2021, 4, 27))
                .authors(authors)
                .copies(5)
                .copyNumber(UUID.randomUUID())
                .status(Status.AVAILABLE)
                .issueDate(LocalDate.of(2019, 10, 9))
                .dueDate(LocalDate.of(2019, 10, 23))
                .returnDate(LocalDate.of(2019, 10, 15))
                .build();

        List<BookCopy> borrowedBooks = List.of(book1, book2, book3);
        List<BookCopy> returnedBooks = List.of(book1, book2);

        Member member = Member.builder()
                .id(UUID.randomUUID())
                .name("Popescu Diana")
                .email("popescudiana@yahoo.com")
                .phoneNumber("0770987245")
                .memberType(MemberType.STANDARD)
                .borrowedBooks(borrowedBooks)
                .returnedBooks(returnedBooks)
                .build();

        memberService.addOnlyOne(member);

        System.out.println("\nGet by Name method: \n");
        System.out.println(memberService.getByName("Popescu Diana"));


        Member member1 = Member.builder()
                .id(member.getId())
                .name("Marin Luca")
                .memberType(MemberType.STANDARD)
                .build();

        System.out.println("\nBefore update: \n");
        System.out.println(member);

        memberService.editMemberById(member.getId(), member1);
        memberService.addOnlyOne(member1);

        System.out.println("\nAfter update: \n");
        System.out.println(member1);

        Member member2 = Member.builder()
                .id(UUID.randomUUID())
                .name("Popescu Matei")
                .memberType(MemberType.VIP)
                .build();

        memberService.addOnlyOne(member2);

        System.out.println("\nGet by Id method: \n");
        System.out.println(memberService.getByID(member2.getId()));


        System.out.println("\nGet all members method: \n");
        memberService.getAllFromMap().
                forEach((key, value) -> System.out.println(value));


        System.out.println("""
                                
                Remove member by Id method:
                                
                Before:
                """);

        memberService.getAllFromMap().
                forEach((key, value) -> System.out.println(value));

        System.out.println("\nAfter: \n");

        memberService.removeMemberById(member2.getId());
        memberService.getAllFromMap().
                forEach((key, value) -> System.out.println(value));


    }

}
