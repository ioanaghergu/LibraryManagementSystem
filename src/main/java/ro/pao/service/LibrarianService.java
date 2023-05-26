package ro.pao.service;

import ro.pao.model.Librarian;

public sealed interface LibrarianService extends Service<Librarian> permits LibrarianServiceImpl {
}
