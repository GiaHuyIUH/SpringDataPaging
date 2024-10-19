package vn.iuh.edu.fit.springdata2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import vn.iuh.edu.fit.springdata2.models.Account;
import vn.iuh.edu.fit.springdata2.repositories.AccountRepository;

import java.util.List;
import java.util.Random;

@SpringBootApplication
public class Springdata2Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Springdata2Application.class, args);
    }

    @Autowired
    private AccountRepository repository;

    @Override
    public void run(String... args) throws Exception {
//        Random rd = new Random();
//        for (long i=0; i<100; i++) {
//            Account account = new Account(i, "Name #" + i, rd.nextDouble(100000));
//            repository.save(account);
//        }
//        repository.findAll().forEach(System.out::println);

        PageRequest request = PageRequest.of(1, 5);
//        Page<Account> page = repository.findAll(request);
//        List<Account> accounts = page.getContent();
//        accounts.forEach(System.out::println);

        List<Account> accounts = repository.findByBalanceGreaterThan(50000, request);
        accounts.forEach(System.out::println);
    }
}
