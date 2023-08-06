Feature: ApiDemos test
  Scenario: ApiDemos text boxa data gonderme
    Given Application yuklendi
    When Kullanici anasayfaya geldi
    And Kullanici Api Demos butonuna tikladi
    Then Kullanici Api Demos ekranina geldi
    And Kullanici Preference linkine tikladi
    Then Kullanici Preference ekranina geldi
    And Kullanici Preference Dependencies linkine tikladi
    And Kullanici wifi check boxi secti
    And Kullanici wifi settingsi tikladi
    Then Wifi settings popup goruldu
    And kullanici "text" yazdi
    And kullanici OK butonuna tikladi

