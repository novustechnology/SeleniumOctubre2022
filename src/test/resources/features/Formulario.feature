Feature: Automatización de formulario

  @Formulario
  Scenario: Llenado de datos
    Given ingreso a la pagina de Tutorialspoint
    And ingreso los datos del formulario
      | firstName | lastName | sex  | yearsExperience | profession        |
      | York      | Correa   | Male | 4               | Automation Tester |
    And cargo una imagen y selecciono el tipo de Selenium "Selenium Webdriver"
