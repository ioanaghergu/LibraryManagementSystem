package ro.pao.application;

import ro.pao.exceptions.ObjectNotFound;
import ro.pao.gateways.Requests;
import ro.pao.model.*;
import ro.pao.model.enums.Genre;
import ro.pao.model.enums.MemberType;
import ro.pao.model.enums.Section;
import ro.pao.model.enums.Status;
import ro.pao.repository.impl.*;
import ro.pao.service.*;
import ro.pao.threads.FineCalculator;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;

public class Menu {

    private static Menu INSTANCE;

    private final AuthorService authorService = new AuthorServiceImpl(new AuthorRepositoryImpl());
    private final BookService bookService = new BookServiceImpl(new BookRepositoryImpl());
    private final BookCopyService copyService = new BookCopyServiceImpl(new BookCopyRepositoryImpl());
    private final FineService fineService = new FineServiceImpl(new FineRepositoryImpl());
    private final LoanService loanService = new LoanServiceImpl(new LoanRepositoryImpl());
    private final MemberService memberService = new MemberServiceImpl(new MemberRepositoryImpl());
    private final LibrarianService librarianService = new LibrarianServiceImpl(new LibrarianRepositoryImpl());


    public static Menu getInstance() {
        return (INSTANCE == null ? new Menu() : INSTANCE);
    }

    public void introAuthor() throws SQLException {

        String intro = "************************** DEMO FOR THE AUTHOR SERVICE INTERFACE **************************\n";

        System.out.println(intro);

        Author author = Author.builder()
                .id(UUID.randomUUID())
                .name("Cassandra Clare")
                .build();

        Author author1 = Author.builder()
                .id(UUID.randomUUID())
                .name("Holy Black")
                .build();

        authorService.addOnlyOne(author);
        authorService.addOnlyOne(author1);


        System.out.println("\n========== GET BY NAME METHOD ==========\n");

        System.out.println(authorService.getByName("Cassandra Clare").get());

        System.out.println("\n=======================================\n");


        System.out.println("\n========== UPDATE AUTHOR METHOD ==========\n");

        System.out.println("\n BEFORE \n");

        System.out.println(author);

        Author author2 = Author.builder()
                .name("Rupy Kaur")
                .build();

        authorService.editById(author.getId(), author2);


        System.out.println("\n AFTER \n");

        System.out.println(authorService.getById(author.getId()));

        System.out.println("\n=======================================\n");


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

        authorService.addAllFromGivenList(authors);

        System.out.println("\n========== ALL AUTHORS FROM DATABASE ==========\n");

        authorService.getAllFromList().forEach(System.out::println);


        System.out.println("\n========== REMOVE AUTHOR METHOD ==========\n");
        System.out.println("\n BEFORE \n");

        authorService.getAllFromList().forEach(System.out::println);

        System.out.println("\n AFTER \n");

        authorService.removeById(author.getId());
        authorService.getAllFromList().forEach(System.out::println);

        System.out.println("\n=======================================\n");


        System.out.println("************************** END OF DEMO **************************\n");


    }

    public void introBook() throws SQLException  {

        String intro = "************************** DEMO FOR THE BOOK SERVICE INTERFACE **************************\n";

        System.out.println(intro);

        Book book = Book.builder()
                .id(UUID.randomUUID())
                .title("Six of crows")
                .genre(Genre.SCIENCE_FICTION)
                .section(Section.FICTION)
                .publicationDate(LocalDate.of(2015, 8, 10))
                .id_author(authorService.getByName("Leigh Bardugo").get().getId())
                .build();

        Book book1 = Book.builder()
                .id(UUID.randomUUID())
                .title("The Raven King")
                .genre(Genre.YOUNG_ADULT)
                .section(Section.FICTION)
                .publicationDate(LocalDate.of(2020, 2, 19))
                .id_author(authorService.getByName("Maggie Stiefvatter").get().getId())
                .build();

        bookService.addOnlyOne(book);
        bookService.addOnlyOne(book1);


        System.out.println("\n========== GET BY TITLE METHOD ==========\n");

        System.out.println(bookService.getByTitle("Six of crows").get());

        System.out.println("\n=======================================\n");


        System.out.println("\n========== UPDATE BOOK METHOD ==========\n");

        System.out.println("\n BEFORE \n");

        System.out.println(book);

        Book book2 = Book.builder()
                .title("The raven boys")
                .build();

        bookService.editById(book1.getId(), book2);


        System.out.println("\n AFTER \n");

        System.out.println(bookService.getById(book1.getId()).get());

        System.out.println("\n=======================================\n");


        List<Book> books = List.of(
                Book.builder()
                        .id(UUID.randomUUID())
                        .title("King of scars")
                        .genre(Genre.SCIENCE_FICTION)
                        .section(Section.FICTION)
                        .publicationDate(LocalDate.of(2015, 8, 10))
                        .id_author(authorService.getByName("Leigh Bardugo").get().getId())
                        .build(),

                Book.builder()
                        .id(UUID.randomUUID())
                        .title("Shadow and Bone")
                        .genre(Genre.FANTASY)
                        .section(Section.FICTION)
                        .publicationDate(LocalDate.of(2017, 9, 20))
                        .id_author(authorService.getByName("Leigh Bardugo").get().getId())
                        .build(),

                Book.builder()
                        .id(UUID.randomUUID())
                        .title("The cruel prince")
                        .genre(Genre.HORROR)
                        .section(Section.CRIME)
                        .publicationDate(LocalDate.of(2018, 12, 7))
                        .id_author(authorService.getByName("Holy Black").get().getId())
                        .build(),

                Book.builder()
                        .id(UUID.randomUUID())
                        .title("Milk and Honey")
                        .genre(Genre.CONTEMPORARY)
                        .section(Section.ART)
                        .publicationDate(LocalDate.of(2017, 10, 15))
                        .id_author(authorService.getByName("Maggie Stiefvatter").get().getId())
                        .build(),

                Book.builder()
                        .id(UUID.randomUUID())
                        .title("The raven king")
                        .genre(Genre.CONTEMPORARY)
                        .section(Section.ART)
                        .publicationDate(LocalDate.of(2017, 10, 15))
                        .id_author(authorService.getByName("Maggie Stiefvatter").get().getId())
                        .build()
        );

        bookService.addAllFromGivenList(books);

        System.out.println("\n========== ALL BOOKS FROM DATABASE ==========\n");

        bookService.getAllFromList().forEach(System.out::println);


        System.out.println("\n========== REMOVE BOOK METHOD ==========\n");
        System.out.println("\n BEFORE \n");

        bookService.getAllFromList().forEach(System.out::println);

        System.out.println("\n AFTER \n");

        bookService.removeById(bookService.getByTitle("Milk and Honey").get().getId());

        bookService.getAllFromList().forEach(System.out::println);

        System.out.println("\n=======================================\n");


        System.out.println("************************** END OF DEMO **************************\n");


    }

    public void introBookCopy() throws SQLException {

        String intro = "************************** DEMO FOR THE BOOK COPY SERVICE INTERFACE **************************\n";

        System.out.println(intro);

        BookCopy copy = BookCopy.builder()
                .id(UUID.randomUUID())
                .title("Six of crows")
                .genre(Genre.SCIENCE_FICTION)
                .section(Section.FICTION)
                .publicationDate(LocalDate.of(2015, 8, 10))
                .id_author(authorService.getByName("Leigh Bardugo").get().getId())
                .status(Status.AVAILABLE)
                .build();

        BookCopy copy1 = BookCopy.builder()
                .id(UUID.randomUUID())
                .title("Six of crows")
                .genre(Genre.SCIENCE_FICTION)
                .section(Section.FICTION)
                .publicationDate(LocalDate.of(2015, 8, 10))
                .id_author(authorService.getByName("Leigh Bardugo").get().getId())
                .status(Status.DAMAGED)
                .build();

        copyService.addOnlyOne(copy);
        copyService.addOnlyOne(copy1);


        System.out.println("\n========== UPDATE BOOK COPY METHOD ==========\n");

        System.out.println("\n BEFORE \n");

        System.out.println(copy);

        BookCopy copy2 = BookCopy.builder()
                .status(Status.DAMAGED)
                .build();

        copyService.editById(copy.getId(), copy2);


        System.out.println("\n AFTER \n");

        System.out.println(copyService.getById(copy.getId()).get());

        System.out.println("\n=======================================\n");


        List<BookCopy> copies = List.of(
                BookCopy.builder()
                        .id(UUID.randomUUID())
                        .title("King of scars")
                        .genre(Genre.SCIENCE_FICTION)
                        .section(Section.FICTION)
                        .publicationDate(LocalDate.of(2015, 8, 10))
                        .id_author(authorService.getByName("Leigh Bardugo").get().getId())
                        .status(Status.BORROWED)
                        .issueDate(LocalDate.of(2023, 4, 2))
                        .dueDate(LocalDate.of(2023, 4, 16))
                        .returnDate(LocalDate.of(2023, 5, 20))
                        .build(),

                BookCopy.builder()
                        .id(UUID.randomUUID())
                        .title("Shadow and Bone")
                        .genre(Genre.FANTASY)
                        .section(Section.FICTION)
                        .publicationDate(LocalDate.of(2017, 9, 20))
                        .id_author(authorService.getByName("Leigh Bardugo").get().getId())
                        .status(Status.BORROWED)
                        .issueDate(LocalDate.of(2023, 5, 20))
                        .dueDate(LocalDate.of(2023, 6, 13))
                        .build()
        );

        copyService.addAllFromGivenList(copies);

        System.out.println("\n========== ALL COPIES FROM DATABASE ==========\n");

        copyService.getAllFromList().forEach(System.out::println);


        System.out.println("\n========== REMOVE COPY METHOD ==========\n");
        System.out.println("\n BEFORE \n");

        copyService.getAllFromList().forEach(System.out::println);

        System.out.println("\n AFTER \n");

        copyService.removeById(copy.getId());

        copyService.getAllFromList().forEach(System.out::println);

        System.out.println("\n=======================================\n");


        System.out.println("************************** END OF DEMO **************************\n");

    }

    public void introMember() throws SQLException {

        String intro = "************************** DEMO FOR THE MEMBER SERVICE INTERFACE **************************\n";

        System.out.println(intro);

        Member member = Member.builder()
                .id(UUID.randomUUID())
                .name("Popescu Diana")
                .memberType(MemberType.STANDARD)
                .build();

        Member member1 = Member.builder()
                .id(UUID.randomUUID())
                .name("Marin Luca")
                .memberType(MemberType.STANDARD)
                .build();

        memberService.addOnlyOne(member);
        memberService.addOnlyOne(member1);


        System.out.println("\n========== UPDATE MEMBER METHOD ==========\n");

        System.out.println("\n BEFORE \n");

        System.out.println(member);

        Member member2 = Member.builder()
                .memberType(MemberType.VIP)
                .build();

        memberService.editById(memberService.getById(member.getId()).get().getId(), member2);

        System.out.println("\n AFTER \n");

        System.out.println(memberService.getByName("Popescu Diana").get());

        System.out.println("\n=======================================\n");


        List<Member> members = List.of(
                Member.builder()
                        .id(UUID.randomUUID())
                        .name("Vodita Lidia")
                        .memberType(MemberType.STANDARD)
                        .build(),

                Member.builder()
                        .id(UUID.randomUUID())
                        .name("Andrei George")
                        .memberType(MemberType.VIP)
                        .build()
        );

        memberService.addAllFromGivenList(members);
        System.out.println("\n========== ALL MEMBERS FROM DATABASE ==========\n");

        memberService.getAllFromList().forEach(System.out::println);


        System.out.println("\n========== REMOVE MEMBER METHOD ==========\n");
        System.out.println("\n BEFORE \n");

        memberService.getAllFromList().forEach(System.out::println);

        System.out.println("\n AFTER \n");

        memberService.removeById(memberService.getByName("Andrei George").get().getId());

        memberService.getAllFromList().forEach(System.out::println);

        System.out.println("\n=======================================\n");


        System.out.println("************************** END OF DEMO **************************\n");


    }

    public void introFine() throws SQLException {

        String intro = "************************** DEMO FOR THE FINE SERVICE INTERFACE **************************\n";

        System.out.println(intro);

        Fine fine = Fine.builder()
                .id(UUID.randomUUID())
                .fineValue(20.0)
                .id_member(memberService.getByName("Popescu Diana").get().getId())
                .build();

        fineService.addOnlyOne(fine);


        System.out.println("\n========== UPDATE FINE METHOD ==========\n");

        System.out.println("\n BEFORE \n");

        System.out.println(fine);

        Fine fine1 = Fine.builder()
                .fineValue(50.0)
                .build();

        fineService.editById(fine.getId(), fine1);

        System.out.println("\n AFTER \n");

        System.out.println(fineService.getById(fine.getId()).get());

        System.out.println("\n=======================================\n");


        List<Fine> fines = List.of(
                Fine.builder()
                        .id(UUID.randomUUID())
                        .fineValue(20.0)
                        .id_member(memberService.getByName("Marin Luca").get().getId())
                        .build(),

                Fine.builder()
                        .id(UUID.randomUUID())
                        .fineValue(10.5)
                        .id_member(memberService.getByName("Vodita Lidia").get().getId())
                        .build()
        );

        fineService.addAllFromGivenList(fines);

        System.out.println("\n========== ALL FINES FROM DATABASE ==========\n");

        fineService.getAllFromList().forEach(System.out::println);


        System.out.println("\n========== REMOVE FINE METHOD ==========\n");
        System.out.println("\n BEFORE \n");

        fineService.getAllFromList().forEach(System.out::println);

        System.out.println("\n AFTER \n");

        fineService.removeById(fine.getId());

        fineService.getAllFromList().forEach(System.out::println);

        System.out.println("\n=======================================\n");


        System.out.println("************************** END OF DEMO **************************\n");


    }

    public void introLoan() throws SQLException {

        String intro = "************************** DEMO FOR THE LOAN SERVICE INTERFACE **************************\n";

        System.out.println(intro);

        Librarian issuer = Librarian.builder()
                .id(UUID.randomUUID())
                .name("Maria Neagu")
                .salary(2500.0)
                .build();

        Librarian receiver = Librarian.builder()
                .id(UUID.randomUUID())
                .name("Ana Pirvu")
                .salary(2600.0)
                .build();

        librarianService.addOnlyOne(issuer);
        librarianService.addOnlyOne(receiver);


        Loan loan = Loan.builder()
                .id(UUID.randomUUID())
                .id_issuer(librarianService.getById(issuer.getId()).get().getId())
                .id_receiver(librarianService.getById(receiver.getId()).get().getId())
                .id_member(memberService.getByName("Marin Luca").get().getId())
                .id_copy(copyService.getByTitle("King of scars").get().getId())
                .build();

        loanService.addOnlyOne(loan);


        System.out.println("\n========== UPDATE LOAN METHOD ==========\n");

        System.out.println("\n BEFORE \n");

        System.out.println(loan);

        Loan loan1 = Loan.builder()
                .id_member(memberService.getByName("Vodita Lidia").get().getId())
                .build();

        loanService.editById(loan.getId(), loan1);

        System.out.println("\n AFTER \n");

        System.out.println(loanService.getById(loan.getId()).get());

        System.out.println("\n=======================================\n");


        List<Loan> loans = List.of(
                Loan.builder()
                        .id(UUID.randomUUID())
                        .id_issuer(librarianService.getById(issuer.getId()).get().getId())
                        .id_receiver(librarianService.getById(receiver.getId()).get().getId())
                        .id_member(memberService.getByName("Popescu Diana").get().getId())
                        .id_copy(copyService.getByTitle("Six of crows").get().getId())
                        .build(),

                Loan.builder()
                        .id(UUID.randomUUID())
                        .id_issuer(librarianService.getById(issuer.getId()).get().getId())
                        .id_receiver(librarianService.getById(receiver.getId()).get().getId())
                        .id_member(memberService.getByName("Marin Luca").get().getId())
                        .id_copy(copyService.getByTitle("Shadow and Bone").get().getId())
                        .build()
        );

        loanService.addAllFromGivenList(loans);

        System.out.println("\n========== ALL LOANS FROM DATABASE ==========\n");

        loanService.getAllFromList().forEach(System.out::println);


        System.out.println("\n========== REMOVE LOAN METHOD ==========\n");
        System.out.println("\n BEFORE \n");

        loanService.getAllFromList().forEach(System.out::println);

        System.out.println("\n AFTER \n");

        loanService.removeById(loan.getId());

        loanService.getAllFromList().forEach(System.out::println);

        System.out.println("\n=======================================\n");


        System.out.println("************************** END OF DEMO **************************\n");


        List<Loan> loans1 = List.of(
                Loan.builder()
                        .id(UUID.randomUUID())
                        .id_issuer(librarianService.getById(issuer.getId()).get().getId())
                        .id_receiver(librarianService.getById(receiver.getId()).get().getId())
                        .id_member(memberService.getByName("Vodita Lidia").get().getId())
                        .id_copy(copyService.getByTitle("King of scars").get().getId())
                        .build(),

                Loan.builder()
                        .id(UUID.randomUUID())
                        .id_issuer(librarianService.getById(issuer.getId()).get().getId())
                        .id_receiver(librarianService.getById(receiver.getId()).get().getId())
                        .id_member(memberService.getByName("Vodita Lidia").get().getId())
                        .id_copy(copyService.getByTitle("King of scars").get().getId())
                        .build()
        );

        loanService.addAllFromGivenList(loans1);

    }

    public void Threads() throws SQLException {

        UUID member_id = memberService.getByName("Vodita Lidia").get().getId();

        FineCalculator fineCalculator = new FineCalculator();
        double totalFine = fineCalculator.calculateFine(member_id);

        System.out.println("Total fine for the member Vodita Lidia: " + totalFine);
    }

//    public void httpClient() {
//
//        Requests requests = new Requests();
//
//        requests.saveRequestInfo();
//
//        bookService.getAllFromList().forEach(System.out::println);
//    }


}