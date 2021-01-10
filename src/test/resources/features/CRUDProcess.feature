Feature: CRUD Process

  Background:
    Given are on home page
    And user clicks in 'Processos' on menu

  Scenario: Create a new process
    Given user clicks on button 'Novo Processo'
    And user fills input with required fields
    When user clicks on 'Salvar' button
    Then user must see the "Processo foi criado com sucesso." message

  Scenario: View process detail
    Given user wants see details of a created process
    When user clicks on 'Mostrar' button
    Then user see process details

  Scenario Outline: Edit a Process
    Given user clicks on 'Editar' button of ID of created process
    And user informs "Vara" equals to "<vara>"
    And user informs "Numero processo" equals to "<numero_processo>"
    And user informs "Natureza" equals to "<natureza>"
    And user informs "Partes" equals to "<partes>"
    And user informs "Urgente" equals to "<urgente>"
    And user informs "Arbitramento" equals to "<arbitramento>"
    And user informs "Assistente social" equals to "<assistente_social>"
    And user informs "Data entrada" equals to "<data_entrada>"
    And user informs "Data saida" equals to "<data_saida>"
    And user informs "Data agendamento" equals to "<data_agendamento>"
    And user informs "Status" equals to "<status>"
    And user informs "Observacao" equals to "<observacao>"
    When user clicks on 'Salvar' button
    Then user must see the "Processo atualizado com sucesso." message
    Examples:
      | vara      | numero_processo | natureza  | partes            | urgente | arbitramento | assistente_social  | data_entrada | data_saida | data_agendamento | status     | observacao       |
      | São Paulo | 422             | Guarda2   | Doria X Serra     | Sim     | Sim          | Gisele da Silva    | 20/10/2022   | 20/10/2021 | 01/02/2024       | Aguardando |                  |
      | Curitiba  | 4265            | Guarda3   | JOao X Maria      | Não     | Não          | Gisele da Silva    | 20/10/2022   | 20/10/2021 | 01/02/2022       | Aguardando | Vai ser incrivel |
      | Osasco    | 422             | Guarda2   | Fulatinha         | Sim     | Sim          | Gisele da Silva    | 20/10/2022   | 20/10/2021 | 01/02/2021       | Aguardando |                  |
      | Acre      | 1               | Auditoria | Empresa X Empresa | Não     | Não          | Clayton das couves | 01/02/2018   | 01/02/2022 | 01/02/2023       | Em Analise |                  |

  Scenario: Delete a Process
    Given user wants delete a process
    When user clicks on 'Apagar' button of ID of created process
    Then user returns to page of process list

  @exclude
  Scenario: Delete multiples process
    Given user wants delete multiples processes
    When they select multiples processes
    When user clicks on 'Apagar' button of ID of created process
    Then user returns to page of process list
