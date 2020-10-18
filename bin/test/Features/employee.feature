Feature: Employee CRUD Operations

  #Scenario: Adding Employee details
  #Given an employee table to add details
  #When adding new employee with empId <empId>, firstName <firstName>, lastName <lastName>, hireDate <hireDate>, city <city>, email <email> and phoneNo <phoneNo>
  #Then It should add to the emp table
  Scenario Outline: Adding Skill details
    Given an skill table to add skill details
    When adding new skill with SkillId <skillId>, skillName <skillName> and details <details>
    Then It should add to skills table

    Examples: 
      | skillId | skillName | details        |
      |     110 | aws       | Amazon Service |
