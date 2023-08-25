@deneme
Feature: API Demos expandable list
  Scenario: Expandable list test
    Given App yuklensin
    And kullanici ana ekranda
    And kullanici "API Demos" butonuna tikladi
    Then kullanici "API Demos" ekraninda
    And kullanici "Views" butonuna tikladi
    Then kullanici "Views" ekraninda
    And kullanici "Expandable Lists" butonuna tikladi
    Then kullanici "Views/Expandable Lists" ekraninda
    And kullanici "1. Custom Adapter" butonuna tikladi
    And kullanici "People Names" butonuna tikladi
    And kullanici "Fish Names" butonuna uzun basti
    Then kullanici "Sample menu" ekraninda