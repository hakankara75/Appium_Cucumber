
  Feature: N11 app mobile test
    Scenario: N11 searchbox test
      Given Type "Kulaklık" in the searchbox
      Then Click the "firs product"
      And Click the "sepetim"
      And Verify that "Ödemeye Geç" is visible

    Scenario: Scroll down
      Given Type "Kulaklık" in the searchbox
      Then Scroll down to the "Huawei"

    Scenario: Scroll down2
      Given Type "Kulaklık" in the searchbox
      Then Scroll down to the "Qcy"

    Scenario: Dropdown
      Given Click the "Kategoriler"
      And Click the "Otomotiv & Motosiklet"
      And Click the "Yedek Parça"
      And Click the "Egzoz"
      And Click the "Filtrele"
      And Click the "Teslimat Adresi Seç"
      Then Click the "Şehir Seç"
      And Scroll down to the "İstanbul"
      Then Click the "İstanbul"
      And Click the "İlçe Seç"
      And Scroll down to the "Beşiktaş"
      Then Click the "Beşiktaş"
      And Click the "Onayla"
      Then Click the "Sonuçları Göster"
      And Verify that "AYNI GÜN TESLİMAT" is visible
