package ro.pao.gateways;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import ro.pao.mapper.BookMapper;
import ro.pao.model.Book;
import ro.pao.repository.impl.BookRepositoryImpl;
import ro.pao.service.BookService;
import ro.pao.service.BookServiceImpl;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import java.util.Iterator;
import java.util.UUID;

public class Requests {

    private static HttpClient httpClient = HttpClient.newHttpClient();

    private static ObjectMapper objectMapper = new ObjectMapper();

    private static BookMapper bookMapper = BookMapper.getInstance();

    private final BookService bookService = new BookServiceImpl(new BookRepositoryImpl());

    public void saveRequestInfo() {

        try {

            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(new URI("https://bookstore.toolsqa.com/BookStore/v1/Books"))
                    .GET()
                    .build();

            var httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            var body = httpResponse.body();

            System.out.println(body);

            JsonNode books = objectMapper.readTree(body);

            Iterator<JsonNode> iterator = books.iterator();

            while(iterator.hasNext()) {
                JsonNode book = iterator.next();

                    bookService.addFromJson(
                            Book.builder()
                                    .id(UUID.randomUUID())
                                    .title(bookMapper.mapJsonObjectToBook(book).getTitle())
                                    .build()
                    );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
