package me.ewan.security.Common;

import me.ewan.security.account.Account;
import me.ewan.security.account.AccountService;
import me.ewan.security.book.Book;
import me.ewan.security.book.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DefaultDataGenerator implements ApplicationRunner {

    @Autowired
    AccountService accountService;

    @Autowired
    BookRepository bookRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Account ewan = createUser("ewan");
        Account ewan2 = createUser("ewan2");

        Book spring = createBook("Spring", ewan);
        Book hibernate = createBook("hibernate", ewan2);
    }

    private Book createBook(String name, Account author){
        Book book = new Book();
        book.setTitle(name);
        book.setAuthor(author);
        return bookRepository.save(book);
    }

    private Account createUser (String name){
        Account account = Account.builder()
                .username(name)
                .password("123")
                .role("USER")
                .build();

        return accountService.createNew(account);
    }
}
