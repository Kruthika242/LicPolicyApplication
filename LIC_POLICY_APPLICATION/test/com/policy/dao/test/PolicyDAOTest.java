package com.policy.dao.test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.policy.dao.LicPolicyDAO;
import com.policy.domain.LicPolicy;

public class PolicyDAOTest {

	@Before
	public void setUp() throws Exception {
		System.out.println("Setting up.....!!!");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Finishing off.....!!!");
	}

	@Test
	public void testCreateLicPolicy() {
		LicPolicyDAO daoObject = new LicPolicyDAO();
		LicPolicy policyObject = new LicPolicy("Whole Life Insurance", "Deepika", "2020-01-24", 8000, "Half-Yearly");

		int result1 = 0;
		result1 = daoObject.createPolicy(policyObject);
		assertEquals(1, result1);
	}

	@Test
	public void testReadLicPolicy() {
		LicPolicyDAO daoObject = new LicPolicyDAO();
		LicPolicy policyObject = new LicPolicy(502);

		boolean result2 = false;
		try {
			result2 = daoObject.readPolicy(policyObject);
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		assertEquals(true, result2);
	}

	@Test
	public void testUpdateLicPolicy() {
		LicPolicyDAO daoObject = new LicPolicyDAO();
		LicPolicy policyObject = new LicPolicy(502,10000);
		int result3 = 0;
		result3 = daoObject.updatePolicy(policyObject);
		assertEquals(1, result3);
	}

	@Test
	public void testDeleteLicPolicy() {
		LicPolicyDAO daoObject = new LicPolicyDAO();
		LicPolicy policyObject = new LicPolicy(504);

		int result4 = 0;
		result4 = daoObject.deletePolicy(policyObject);
		assertEquals(1, result4);
	}

}
