package com.example.AddressBookApp.dto;

public class AddressBookDTO {



        private Long id;
        private String name;
        private String phoneNumber;

        // Constructors, Getters, and Setters
        public AddressBookDTO() {}

        public AddressBookDTO(Long id, String name, String phoneNumber) {
            this.id = id;
            this.name = name;
            this.phoneNumber = phoneNumber;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }
    }

