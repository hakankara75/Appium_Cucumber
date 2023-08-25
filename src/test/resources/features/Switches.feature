Feature: API Demos Switches

  Background: : Switch screen test
    Given App yuklensin
    When kullanici ana ekranda
    And kullanici API Demos butonuna tikladi
    Then kullanici API Demos ekraninda
    And kullanici "Preference" butonuna tikladi
    Then kullanici Preference ekraninda
    And kullanici Switches tikladi

  Scenario: Switch test
    #And kullanici "Checkbox preference" butonuna tikladi
    And kullanici check box tikladi
    And switch butonuna tikladi
    Then screenshot al
@emre
  Scenario: Switch button checks
    And check box secili olmali
    And ilk switch butonu kapali
    And ikinci switch butonu acik
    Then screenshot al
