package com.example.AddressBookApp.Service;



import com.example.AddressBookApp.Repository.DataRepository;
import com.example.AddressBookApp.dto.AddressBookDTO;
import com.example.AddressBookApp.Model.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AddressBookServiceImpl implements AddressBookService {

    private final DataRepository dataRepository;

    @Autowired
    public AddressBookServiceImpl(DataRepository contactRepository) {
        this.dataRepository = contactRepository;
    }

    @Override
    public List<Data> findAll() {
        return dataRepository.findAll();
    }

    @Override
    public Optional<Data> findById(Long id) {
        return dataRepository.findById(id);
    }

    @Override
    public Data save(Data contact) {
        return dataRepository.save(contact);
    }

    @Override
    public void delete(Data contact) {
        dataRepository.delete(contact);
    }


}