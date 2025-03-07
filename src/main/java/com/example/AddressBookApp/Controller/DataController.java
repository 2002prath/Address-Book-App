package com.example.AddressBookApp.Controller;

import com.example.AddressBookApp.Model.Data;
import com.example.AddressBookApp.Repository.DataRepository;
import com.example.AddressBookApp.Service.AddressBookService;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController

@RequestMapping("/contacts")
public class DataController {

    private final AddressBookService addressBookService;

    @Autowired
    public DataController(AddressBookService addressBookService) {
        this.addressBookService = addressBookService;
    }

    @GetMapping
    public List<Data> getAllContacts() {
        return addressBookService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Data> getContactById(@PathVariable Long id) {
        return addressBookService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Data> createContact(@RequestBody Data data)
    {
        return new ResponseEntity<>(addressBookService.save(data), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Data> updateContact(@PathVariable Long id, @RequestBody Data contact) {
        return addressBookService.findById(id)
                .map(existingContact -> {
                    existingContact.setName(contact.getName());
                    existingContact.setPhone(contact.getPhone());
                    existingContact.setEmail(contact.getEmail());
                    return ResponseEntity.ok(addressBookService.save(existingContact));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteContact(@PathVariable Long id) {
        return addressBookService.findById(id)
                .map(contact -> {
                    addressBookService.delete(contact);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}


