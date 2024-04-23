package com.example.cmd.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigInteger;
import java.sql.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.cmd.demo.DTOs.Clinics;
import com.example.cmd.demo.RepositoryLayer.ClinicRepository;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private ClinicRepository clinicRepository;

	private Calculator c = new Calculator();

	@Test
	void contextLoads() {

	}

	@Test
	void testSum() {
		// Actual result
		int expectedResult = 17;
		int actualResult = c.doSum(12, 3, 2);

		assertEquals(expectedResult, actualResult);
	}

	@Test
	void testProduct() {
		// expected result

		int expectedResult = 6;

		int actualResult = c.doProduct(3, 2);

		assertEquals(expectedResult, actualResult);
	}

	@Test
	void testCompareNums() {
		// Actual result
		Boolean actualResult = c.compareTwoNums(3, 3);

		assertTrue(actualResult);
	}

	@Test
	void isPersonExists() {
		Clinics clinics = new Clinics();

		clinics.setClinicId("CL202200001");
		clinics.setClinicName("Some_Clinic");
		clinics.setBuisnessName("Some_Buisness");
		clinics.setStreetAddress("Some_Street");
		clinics.setCity("Some_City");
		clinics.setState("Some_State");
		clinics.setCountry("Some_Country");
		clinics.setZipCode("Some_ZipCode");
		clinics.setLatitude(91.12);
		clinics.setLongitude(-82.21);
		clinics.setServiceTag(BigInteger.valueOf(5));
		clinics.setDateCreated(new Date(System.currentTimeMillis()));

		Clinics actualResult = clinicRepository.findByClinicId(clinics.getClinicId());

		assertNotEquals(null, actualResult);
	}


	

}
