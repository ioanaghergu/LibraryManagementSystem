//package ro.pao.application;
//
//import ro.pao.model.*;
//import ro.pao.model.enums.Genre;
//import ro.pao.model.enums.MemberType;
//import ro.pao.model.enums.Section;
//import ro.pao.model.enums.Status;
//import ro.pao.service.impl.BookServiceImpl;
//import ro.pao.service.impl.MemberServiceImpl;
//
//import java.time.LocalDate;
//import java.util.*;
//
//public class Menu {
//
//    private static Menu INSTANCE;
//
//    private final MemberService memberService = new MemberServiceImpl();
//    private final BookService bookService = new BookServiceImpl();
//
//    public static Menu getInstance() {
//        return (INSTANCE == null ? new Menu() : INSTANCE);
//    }
//
//    private Menu() {
//    }
//
//    public void introMember() {
//
//        String intro = "************************** DEMO FOR THE MEMBER SERVICE INTERFACE **************************\n";
//
//        System.out.println(intro);
//
//        List<Author> authors = List.of(
//                Author.builder()
//                        .id(UUID.randomUUID())
//                        .name("Leigh Bardugo")
//                        .email("leighbardugo@yahoo.com")
//                        .build(),
//
//                Author.builder()
//                        .id(UUID.randomUUID())
//                        .name("Maggie Stiefvatter")
//                        .email("maggiestiefvatter@yahoo.com")
//                        .build()
//        );
//
//        BookCopy book1 = BookCopy.builder()
//                .id(UUID.randomUUID())
//                .title("Six of crows")
//                .genre(Genre.SCIENCE_FICTION)
//                .section(Section.FICTION)
//                .publicationDate(LocalDate.of(2023, 3, 31))
//                .authors(authors)
//                .copies(3)
//                .copyNumber(UUID.randomUUID())
//                .status(Status.DAMAGED)
//                .issueDate(LocalDate.of(2020, 6, 7))
//                .dueDate(LocalDate.of(2020, 6, 14))
//                .returnDate(LocalDate.of(2020, 6, 20))
//                .build();
//
//        BookCopy book2 = BookCopy.builder()
//                .id(UUID.randomUUID())
//                .title("Crooked kingdom")
//                .genre(Genre.SCIENCE_FICTION)
//                .section(Section.FICTION)
//                .publicationDate(LocalDate.of(2020, 4, 27))
//                .authors(authors)
//                .copies(7)
//                .copyNumber(UUID.randomUUID())
//                .status(Status.AVAILABLE)
//                .issueDate(LocalDate.of(2021, 5, 7))
//                .dueDate(LocalDate.of(2021, 5, 14))
//                .returnDate(LocalDate.of(2021, 5, 12))
//                .build();
//
//        BookCopy book3 = BookCopy.builder()
//                .id(UUID.randomUUID())
//                .title("Siege and storm")
//                .genre(Genre.SCIENCE_FICTION)
//                .section(Section.FICTION)
//                .publicationDate(LocalDate.of(2021, 4, 27))
//                .authors(authors)
//                .copies(5)
//                .copyNumber(UUID.randomUUID())
//                .status(Status.AVAILABLE)
//                .issueDate(LocalDate.of(2019, 10, 9))
//                .dueDate(LocalDate.of(2019, 10, 23))
//                .returnDate(LocalDate.of(2019, 10, 15))
//                .build();
//
//        List<BookCopy> borrowedBooks = List.of(book1, book2, book3);
//        List<BookCopy> returnedBooks = List.of(book1, book2);
//
//        Member member = Member.builder()
//                .id(UUID.randomUUID())
//                .name("Popescu Diana")
//                .email("popescudiana@yahoo.com")
//                .phoneNumber("0770987245")
//                .memberType(MemberType.STANDARD)
//                .borrowedBooks(borrowedBooks)
//                .returnedBooks(returnedBooks)
//                .build();
//
//        memberService.addOnlyOne(member);
//
//
//
//        System.out.println("\n========== GET BY NAME METHOD ==========\n");
//
//        System.out.println(memberService.getByName("Popescu Diana"));
//
//        System.out.println("\n=======================================\n");
//
//
//
//        Member member1 = Member.builder()
//                .id(member.getId())
//                .name("Marin Luca")
//                .memberType(MemberType.STANDARD)
//                .build();
//
//        System.out.println("\n========== UPDATE MEMBER METHOD ==========\n");
//
//        System.out.println("\n BEFORE \n");
//
//        System.out.println(member);
//
//
//        memberService.editMemberById(member.getId(), member1);
//        memberService.addOnlyOne(member1);
//
//
//        System.out.println("\n AFTER \n");
//
//        System.out.println(member1);
//
//        System.out.println("\n=======================================\n");
//
//
//
//        Member member2 = Member.builder()
//                .id(UUID.randomUUID())
//                .name("Popescu Matei")
//                .memberType(MemberType.VIP)
//                .build();
//
//        memberService.addOnlyOne(member2);
//
//        System.out.println("\n========== GET MEMBER BY ID METHOD ==========\n");
//
//        System.out.println(memberService.getByID(member2.getId()));
//
//        System.out.println("\n=======================================\n");
//
//
//
//        System.out.println("\n========== GET ALL MEMBERS METHOD ==========\n");
//
//        memberService.getAllFromMap().
//                forEach((key, value) -> System.out.println(value));
//
//        System.out.println("\n=======================================\n");
//
//
//
//        System.out.println("\n========== REMOVE MEMBER METHOD ==========\n");
//        System.out.println("\n BEFORE \n");
//
//        memberService.getAllFromMap().
//                forEach((key, value) -> System.out.println(value));
//
//        System.out.println("\n AFTER \n");
//
//        memberService.removeMemberById(member2.getId());
//        memberService.getAllFromMap().
//                forEach((key, value) -> System.out.println(value));
//
//        System.out.println("\n=======================================\n");
//
//        System.out.println("************************** END OF DEMO **************************\n");
//
//    }
//
//    public void introBook() {
//        String intro = "************************** DEMO FOR THE BOOK SERVICE INTERFACE **************************\n";
//
//        System.out.println(intro);
//
//        Author author = Author.builder()
//                .name("Leigh Bardugo")
//                .build();
//
//        Author author1 = Author.builder()
//                .name("Maggie Stiefvatter")
//                .build();
//
//        Author author2 = Author.builder()
//                .name("Cassandra Clare")
//                .build();
//
//        Author author3 = Author.builder()
//                .name("Holy Black")
//                .build();
//
//
//        Publisher publisher = Publisher.builder()
//                .id(UUID.randomUUID())
//                .name("RAO Publishing House")
//                .build();
//
//        Publisher publisher1 = Publisher.builder()
//                .id(UUID.randomUUID())
//                .name("Corint Publishing House")
//                .build();
//
//        Publisher publisher2 = Publisher.builder()
//                .id(UUID.randomUUID())
//                .name("Penguin Books")
//                .build();
//
//
//        List<Book> books = List.of(
//                Book.builder()
//                        .id(UUID.randomUUID())
//                        .title("Six of crows")
//                        .genre(Genre.SCIENCE_FICTION)
//                        .section(Section.FICTION)
//                        .publisher(publisher)
//                        .publicationDate(LocalDate.of(2015, 8, 10))
//                        .authors(List.of(author, author2))
//                        .copies(3)
//                        .build(),
//
//                Book.builder()
//                        .id(UUID.randomUUID())
//                        .title("Six of crows")
//                        .genre(Genre.FANTASY)
//                        .section(Section.FICTION)
//                        .publisher(publisher1)
//                        .publicationDate(LocalDate.of(2017, 9, 20))
//                        .authors(List.of(author1, author3))
//                        .copies(7)
//                        .build(),
//
//                Book.builder()
//                        .id(UUID.randomUUID())
//                        .title("The cruel prince")
//                        .genre(Genre.HORROR)
//                        .section(Section.CRIME)
//                        .publisher(publisher2)
//                        .publicationDate(LocalDate.of(2018, 12, 7))
//                        .authors(List.of(author2, author3))
//                        .copies(10)
//                        .build(),
//
//                Book.builder()
//                        .id(UUID.randomUUID())
//                        .title("Milk and Honey")
//                        .genre(Genre.CONTEMPORARY)
//                        .section(Section.ART)
//                        .publisher(publisher1)
//                        .publicationDate(LocalDate.of(2017, 10, 15))
//                        .authors(List.of(author1, author))
//                        .copies(18)
//                        .build(),
//
//                Book.builder()
//                        .id(UUID.randomUUID())
//                        .title("The Raven King")
//                        .genre(Genre.YOUNG_ADULT)
//                        .section(Section.FICTION)
//                        .publisher(publisher2)
//                        .publicationDate(LocalDate.of(2020, 2, 19))
//                        .authors(List.of(author3))
//                        .copies(31)
//                        .build()
//        );
//
//
//        Book book = Book.builder()
//                .id(UUID.randomUUID())
//                .title("Six of crows")
//                .genre(Genre.ROMANCE)
//                .section(Section.CLASSICS)
//                .publisher(publisher)
//                .publicationDate(LocalDate.of(2019, 8, 21))
//                .authors(List.of(author2, author1))
//                .copies(19)
//                .build();
//
//        bookService.addOnlyOne(book);
//
//
//        System.out.println("\n========== GET BOOK BY TITLE METHOD ==========\n");
//
//        System.out.println(bookService.getByTitle(book.getTitle()));
//
//        System.out.println("\n=======================================\n");
//
//
//
//        System.out.println("\n========== GET ALL BOOKS FROM LIST METHOD ==========\n");
//
//        bookService.getAllFromList()
//                .forEach(System.out::println);
//
//        System.out.println("\n=======================================\n");
//
//
//
//        System.out.println("\n========== ADD ALL BOOKS FROM GIVEN LIST METHOD ==========\n");
//
//        bookService.addAllFromGivenList(books);
//
//        bookService.getAllFromList()
//                .forEach(System.out::println);
//
//        System.out.println("\n=======================================\n");
//
//
//
//        System.out.println("\n========== SEARCH BOOKS BY TITLE METHOD ==========\n");
//
//        bookService.getAllByTitle("Six of crows")
//                .forEach(System.out::println);
//
//        System.out.println("\n=======================================\n");
//
//
//
//        System.out.println("\n========== UPDATE BOOK METHOD ==========\n");
//        System.out.println("\n BEFORE \n");
//
//        System.out.println(book);
//
//        Book book1 = Book.builder()
//                .id(book.getId())
//                .title("Siege and storm")
//                .build();
//
//        bookService.editBookById(book.getId(), book1);
//
//
//        System.out.println("\n AFTER \n");
//
//        System.out.println(bookService.getByID(book1.getId()));
//
//        System.out.println("\n=======================================\n");
//
//
//
//        System.out.println("\n========== REMOVE BOOK METHOD ==========\n");
//        System.out.println("\n BEFORE \n");
//
//        bookService.getAllFromList()
//                .forEach(System.out::println);
//
//
//        System.out.println("\n AFTER \n");
//
//        bookService.removeBookById(book1.getId());
//        bookService.getAllFromList()
//                .forEach(System.out::println);
//
//        System.out.println("\n=======================================\n");
//
//
//
//        System.out.println("\n========== SORT BOOKS BY PUBLICATION DATE METHOD ==========\n");
//
//        Collections.sort(bookService.getAllFromList());
//
//        bookService.getAllFromList()
//                .forEach(System.out :: println);
//
//        System.out.println("\n=======================================\n");
//
//        System.out.println("************************** END OF DEMO **************************\n");
//
//    }
//
//}