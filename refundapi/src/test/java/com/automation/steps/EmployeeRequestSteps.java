package com.automation.steps;

import com.automation.runner.TestRunner;

import io.cucumber.java.en.When;

public class EmployeeRequestSteps {

    // Title-Specific Features

        // scenario 1
        @When("the employee enters in a 50 character maximum reimbursement request title")
            public void the_employee_enters_in_a_50_character_maximum_reimbursement_request_title(){
                TestRunner.employeeRequest.enterRequestTitle("Employee E2E Test");
            }


    // Amount-Specific Features

        // scenario 1
        @When("the employee enters in a new reimbursement request amount up to $1000")
            public void the_employee_enters_in_a_new_reimbursement_request_amount_up_to_$1000(){
                TestRunner.employeeRequest.enterRequestAmount("999");
            }

    // Desc-Specific Features

        // scenario 1
        @When("the employee enters in a 500 character maximum reimbursement request description")
            public void the_employee_enters_in_a_500_character_maximum_reimbursement_request_description(){
                TestRunner.employeeRequest.enterRequestReason("This is our Employee E2E Test!");
            }


}
