package com.example.AddressBookApp.Repository;


import com.example.AddressBookApp.Model.Data;
import org.springframework.data.jpa.repository.JpaRepository;

 public interface DataRepository extends JpaRepository<Data, Long> {}

