## Descrição

Este projeto foi desenvolvido como parte do teste prático.
com o objetivo de demonstrar conhecimentos em Java, programação
orientada a objetos e manipulação de coleções.

## Tecnologias utilizadas

-   Java 17
-   API de Datas (LocalDate)
-   Streams e Collections
-   BigDecimal para cálculos monetários

## Estrutura do projeto

``` bash
src/
 ├── application/
 │    └── Principal.java
 ├── model/
 │    ├── Pessoa.java
 │    └── Funcionario.java
 ├── service/
 │    └── FuncionarioService.java
```

## Funcionalidades implementadas

-   Cadastro de funcionários\
-   Remoção de funcionário específico\
-   Formatação de datas e valores monetários\
-   Aplicação de aumento salarial\
-   Agrupamento por função\
-   Filtro de aniversariantes\
-   Identificação do funcionário mais velho\
-   Ordenação alfabética\
-   Cálculo do total de salários\
-   Cálculo de salários mínimos por funcionário

## Pré-requisitos
Antes de executar o projeto, é necessário ter instalado:

- Java 17 ou superior
- IDE Java (Eclipse, IntelliJ, etc)
- Git 

## Como executar o projeto

1.  Clone o repositório:

``` bash
git clone https://github.com/Carloshipol/challenge_iniflex.git
```

2.  Abra na IDE de sua preferência (Eclipse, IntelliJ, etc)

3.  Execute a classe:

``` bash
application.Principal
```

## Decisões técnicas

-   Utilização de `BigDecimal` para evitar problemas de precisão em
    cálculos financeiros
-   Separação de responsabilidades com camada de `service`, mantendo o
    código organizado e de fácil manutenção
-   Uso de `Streams` para operações de agrupamento, ordenação e filtros
