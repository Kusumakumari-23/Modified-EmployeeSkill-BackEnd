Feature: Testing Skills Operations

  Scenario: I search for skillId
    
    Given I search for skillId
    When the skill should found
    Then return skillname and details skillName , details
    			

