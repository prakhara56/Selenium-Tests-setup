Feature: Record user interaction on assetmark.com

  Scenario: User fills out the consultation request form
    Given the user is on the AssetMark homepage
    When the user clicks on the 'Get Started' button
    Then the user should be navigated to the consultation request page
    When the user clicks in the 'First Name' input field
    And the user types 'pra' into the 'First Name' input field
    When the user clicks in the 'Last Name' input field
    And the user types 'a' into the 'Last Name' input field
    When the user clicks in the 'Email' input field
    And the user types 'r' into the 'Email' input field
