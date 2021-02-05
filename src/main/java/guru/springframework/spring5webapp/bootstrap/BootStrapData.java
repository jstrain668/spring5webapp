package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRespository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRespository authorRespository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started in Bootstrap");

        Author eric = new Author("Eric","Evans");
        Book ddd = new Book("Domain Driven Design","123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        Publisher wrox = new Publisher("Wrox","17 Easy Street","New York","NY","ZX11");

        authorRespository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(wrox);

        System.out.println("Number of publishers: "+publisherRepository.count());

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE development without EJB","3933933930");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRespository.save(rod);
        bookRepository.save(noEJB);

        System.out.println("Number of books: "+bookRepository.count());

    }
}
