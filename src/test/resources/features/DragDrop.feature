Feature: ApiDemos touch action
  Scenario: Drag and Drop
    Given Application yuklendi
    When Kullanici anasayfaya geldi
    Then Kullanici Api Demos butonuna tikladi
    And Kullanici Api Demos ekranina geldi
    Then Kullanici Views butonuna tikladi
    And Kullanici Views ekranina geldi
    Then Kullanici drag and drop butonuna tikladi
    When Kullanici birinci topu ikinci topun ustune tikladi
    Then Kullanici dorduncu topu gordu
    And Screenshot al