Feature: Api Demos swipe
  Scenario: Swipe test
    Given App yuklensin
    And kullanici ana ekranda
    And kullanici "API Demos" butonuna tikladi
    Then kullanici "API Demos" ekraninda
    And kullanici "Views" butonuna tikladi
    Then kullanici "Views" ekraninda
    And kullanici "Date Widgets" butonuna tikladi
    Then kullanici "Views/Date Widgets" ekraninda
    And kullanici "2. Inline" butonuna tikladi
    And kullanici 9 tiklasin
    And kullanici 15 ten 45 e yesil topu kaydirsin