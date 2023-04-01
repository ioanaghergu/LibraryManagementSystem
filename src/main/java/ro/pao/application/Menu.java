package ro.pao.application;

import ro.pao.model.Author;
import ro.pao.model.Book;
import ro.pao.model.BookCopy;
import ro.pao.model.Member;
import ro.pao.model.abstracts.Location;
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

    private Menu() {}


}
