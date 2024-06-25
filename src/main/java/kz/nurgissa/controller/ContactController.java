package kz.nurgissa.controller;

import kz.nurgissa.repositories.ContactRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ContactController {
    private final ContactRepository contactRepository;


}
