package com.d288.jhayma7;

import com.d288.jhayma7.dao.CustomerRepository;
import com.d288.jhayma7.dao.DivisionRepository;
import com.d288.jhayma7.entities.Customer;
import com.d288.jhayma7.entities.Division;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrap implements CommandLineRunner {
    private CustomerRepository customerRepository;
    private DivisionRepository divisionRepository;

    public BootStrap(CustomerRepository customerRepository, DivisionRepository divisionRepository) {
        this.customerRepository = customerRepository;
        this.divisionRepository = divisionRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Division jerry_d = this.divisionRepository.findById(2L).orElse(null);
        Division albert_d = this.divisionRepository.findById(3L).orElse(null);
        Division charlotte_d = this.divisionRepository.findById(4L).orElse(null);
        Division ben_d = this.divisionRepository.findById(5L).orElse(null);
        Division rose_d = this.divisionRepository.findById(6L).orElse(null);

        Customer jerry = new Customer("Jerry", "Johnson", "123 Maple Street", "62704", "+1-555-1234", jerry_d);
        Customer albert = new Customer("Albert", "Newson", "124 Maple Street", "62704", "+1-555-1235", albert_d);
        Customer charlotte = new Customer("Charlotte", "Capson", "125 Maple Street", "62704", "+1-555-1236", charlotte_d);
        Customer ben = new Customer("Ben", "Jerryson", "126 Maple Street", "62704", "+1-555-1237", ben_d);
        Customer rose = new Customer("Rose", "Kewlson", "127 Maple Street", "62704", "+1-555-1238", rose_d);

        this.customerRepository.save(jerry);
        this.customerRepository.save(albert);
        this.customerRepository.save(charlotte);
        this.customerRepository.save(ben);
        this.customerRepository.save(rose);
    }
}
