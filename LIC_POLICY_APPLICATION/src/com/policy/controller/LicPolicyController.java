package com.policy.controller;

import java.sql.SQLException;
import java.util.Scanner;

import com.policy.dao.LicPolicyDAO;
import com.policy.domain.LicPolicy;

public class LicPolicyController {
	public static void main(String[] args) throws SQLException {
		LicPolicyDAO daoObject = new LicPolicyDAO();
		LicPolicy policyObject = new LicPolicy();
		int choice = 0;

		while (choice == 0) {
			System.out.println("Choose required option");
			System.out.println("1: Create Policy Holder");
			System.out.println("2: Display Policy Holder details");
			System.out.println("3: Update or Modify Policy details");
			System.out.println("4: Delete Policy Holder\n");

			@SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);
			int optedOption = scan.nextInt();

			switch (optedOption) {
			// To create new lic policy
			case 1: {
				System.out.println("Enter the Insurance Policy required !!");
				System.out.println("Insurance Policies Available:\n1] Term Life Insurance\n"
						+ "2] Whole Life Insurance\n" + "3] Universal Life Insurance\n");

				int policy = scan.nextInt(); // helps user to choose either of the policy types
				if (policy == 1)
					policyObject.setPolicyName("Term Life Insurance");
				else if (policy == 2)
					policyObject.setPolicyName("Whole Life Insurance");
				else if (policy == 3)
					policyObject.setPolicyName("Universal Life Insurance");

				System.out.println("Enter Policy_holder_name : ");
				String policyholderName = scan.next();
				policyObject.setPolicyHolderName(policyholderName);

				System.out.println("Enter Policy_start_date : ");
				String startDate = scan.next();
				policyObject.setPolicyStartDate(startDate);

				System.out.println("Enter Premium_amount : ");
				float amount = scan.nextFloat();
				policyObject.setPremiumAmount(amount);

				System.out.println("Choose Premium_type !!!");
				System.out.println("Premium Types Available:\n1] Quaterly\n" + "2] Half-Yearly\n" + "3] Yearly\n");

				int type = scan.nextInt(); // helps user to choose either of the premium types
				if (type == 1)
					policyObject.setPremiumType("Quaterly");
				else if (type == 2)
					policyObject.setPremiumType("Half-Yearly");
				else if (type == 3)
					policyObject.setPremiumType("Yearly");

				int result = daoObject.createPolicy(policyObject);

				if (result == 0)
					System.out.println("Policy User Data  insertion unsuccessfull");
				else
					System.out.println("Policy User Data insertion successfull");
				break;
			}
			// To display details of a policy Holder using Policy Number
			case 2: {
				System.out.println("Enter PolicyNumber");
				policyObject.setPolicyNumber(scan.nextInt());
				daoObject.readPolicy(policyObject);
				break;
			}
			// To update or modify the Premium Amount using Policy Number
			case 3: {
				System.out.println("To Update Premium amount enter your Policy Number :");
				policyObject.setPolicyNumber(scan.nextInt());
				System.out.println("Enter Premium amount :");
				policyObject.setPremiumAmount(scan.nextFloat());

				int result = daoObject.updatePolicy(policyObject);
				if (result > 0)
					System.out.println("Premium Amount Updated successfully");
				else
					System.out.println("Premium Amount Not Updated");
				break;
			}
			// To delete Policy Holder using Policy Number
			case 4: {
				System.out.println("Enter PolicyNumber to Delete Policy holder");
				policyObject.setPolicyNumber(scan.nextInt());

				int result = daoObject.deletePolicy(policyObject);
				if (result == 0)
					System.out.println("Policy Holder Deletion Unsuccessfull");
				else
					System.out.println("Policy Holder Deletion successfull");
				break;
			}

			}
			System.out.println("Press 0 to continue");
			choice = scan.nextInt();
		}
	}

}

