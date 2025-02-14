Feature: User login and create repository on GitHub

  Scenario: User logs in and creates a new repository
    Given the user navigates to "https://github.com/login"
    When the user enters "prakharaa" into the login field
    And the user enters "prakhar123456@" into the password field
    And the user clicks the sign in button
    And the user clicks the "New" button to create a new repository
    And the user enters "new-repo-1" into the repository name field
    And the user selects "private" for repository visibility
    And the user checks the "Initialize this repository with a README" checkbox
    # And the user selects "Python" as the .gitignore template
    # And the user selects "Apache License 2.0" as the license
    Then the user clicks the "Create repository" button