Feature: UK Test Ticket - Validate get Help with Paying for nhs costs Online Service

  @regression @checkerServiceTest
    Scenario: Verify the eligibility of the User to get help with Paying for NHS Costs
  Given I am a citizen of the UK
  When I put my circumstances into the Checker tool
  Then I should get a result of whether I will get help or not
