
Feature: ApiDemos switch test
  Scenario: ApiDemos switchbox test
    Given Application yuklendi
    When Kullanici anasayfaya geldi
    And Kullanici Api Demos butonuna tikladi
    Then Kullanici Api Demos ekranina geldi
    And Kullanici Preference linkine tikladi
    Then Kullanici Preference ekranina geldi
    And Switch linkini tikladi
    Then CheckBox Preference boxa tikladi
    And Switch preference secildi

