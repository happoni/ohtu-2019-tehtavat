Feature: A new user account can be created if a proper unused username and password are given

    Scenario: creation is successful with valid username and password
        Given command register new user is selected
        When a valid username "liisa" and password "salainen1" and matching password confirmation "salainen1" are entered
        Then a new user is created

    Scenario: creation fails with too short username and valid password
        Given command register new user is selected
        When a too short username "ab" and a valid password "toimii22" and matching password confirmation "toimii22" are entered
        Then user is not created and error "username should have at least 3 characters" is reported   

    Scenario: creation fails with valid username and too short password
        Given command register new user is selected
        When a valid username "kalle" and too short password "pallo" and matching password confirmation "pallo" are entered
        Then user is not created and error "password should have at least 8 characters" is reported   

    Scenario: creation fails when password and password confirmation do not match
        Given command register new user is selected
        When a valid username "janne" and a valid password "kukkola3" and nonmatching password confirmation "lukkola3" are entered
        Then user is not created and error "password and password confirmation do not match" is reported   

