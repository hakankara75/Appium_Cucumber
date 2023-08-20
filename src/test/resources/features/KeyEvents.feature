@n11
  Feature: Android key events
    Background: Activate the search box
      Given Click on the search box
    Scenario: Key events
      And Type "mobile" in the search box
      Then Press on the key "Space"
      And Press on the key "BackSpace"
      And Type "phone" in the search box
      Then Press on the key "Enter"