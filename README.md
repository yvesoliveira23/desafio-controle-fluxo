# Desafio Controle de Fluxo

Este projeto é um exercício de controle de fluxo em Java. O sistema recebe dois parâmetros inteiros via terminal e realiza uma contagem, imprimindo os números incrementados no console. 

## Estrutura do Projeto

```
desafio-controle-fluxo
├── src
│   ├── main
│   │   └── java
│   │       ├── Contador.java
│   │       └── ParametrosInvalidosException.java
├── pom.xml
└── README.md
```

## Como Executar

1. Certifique-se de ter o Java e o Maven instalados em sua máquina.
2. Clone o repositório ou baixe os arquivos do projeto.
3. Navegue até o diretório do projeto no terminal.
4. Compile o projeto usando o Maven:
   ```
   mvn clean install
   ```
5. Execute a classe `Contador` passando dois números inteiros como parâmetros:
   ```
   java src/main/java/Contador.java <primeiro_parametro> <segundo_parametro>
   ```

## Exceções

Se o primeiro parâmetro for maior que o segundo, uma exceção personalizada `ParametrosInvalidosException` será lançada com a mensagem: "O segundo parâmetro deve ser maior que o primeiro".