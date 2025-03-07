package com.example.AddressBookApp.Service;

import com.example.AddressBookApp.dto.AddressBookDTO;
import com.example.AddressBookApp.Model.Data;

import java.util.List;
import java.util.Optional;

public interface AddressBookService {

    List<Data> findAll();
    Optional<Data> findById(Long id);
    Data save(Data contact);
    Data updateContact(Long id, Data addressBook);
    void delete(Data contact);
    }





