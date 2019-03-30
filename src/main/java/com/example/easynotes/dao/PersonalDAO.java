package com.example.easynotes.dao;

import java.util.ArrayList;

import com.example.easynotes.model.LoginRequest;
import com.example.easynotes.model.PersonDetails;

public interface PersonalDAO 
{

	public PersonDetails getPersonalDetails(String customerId);
}