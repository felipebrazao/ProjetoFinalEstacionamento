Aqui está um README mais detalhado para o projeto:

---

# Projeto Final Estacionamento

Este projeto é uma aplicação de gestão de estacionamento, desenvolvido em Java, com foco em simular o processo de controle de veículos que entram e saem de um estacionamento, com a capacidade de gerar relatórios e salvar dados de forma persistente.

## Funcionalidades
- **Cadastro de veículos**: Adiciona veículos ao estacionamento com detalhes como placa, modelo e tipo.
- **Controle de entrada e saída**: Registra quando um veículo entra ou sai do estacionamento.
- **Relatórios**: Gera relatórios sobre os veículos estacionados no sistema.
- **Persistência de dados**: Utiliza arquivos JSON para armazenar e carregar as informações dos veículos.
- **Testes automatizados**: Utiliza JUnit 5 para garantir o funcionamento adequado dos métodos principais.

## Tecnologias
- **Java 8 ou superior**
- **JUnit 5**: Para testes automatizados.
- **Bibliotecas externas**: JSON para leitura e escrita de arquivos.

## Instruções de Execução
1. Clone o repositório:
   ```bash
   git clone https://github.com/felipebrazao/ProjetoFinalEstacionamento
   ```
2. Compile e execute a classe `Main` para iniciar a aplicação.
3. O sistema permitirá o cadastro de veículos e controle de entradas/saídas diretamente via interface no console.

## Dependências
- **Jackson**: Para manipulação de arquivos JSON.
- **JUnit 5**: Para execução de testes automatizados.
- **Maven**: Para gerenciamento de dependências (caso esteja utilizando).

## Testes
Os testes automatizados podem ser executados via Maven ou diretamente pelo ambiente de desenvolvimento integrado (IDE) como o IntelliJ ou Eclipse.

### Executando os Testes com Maven:
1. Navegue até o diretório do projeto.
2. Execute o comando:
   ```bash
   mvn test
   ```

## Estrutura de Diretórios
```plaintext
src/
 ├── main/
 │    ├── java/
 │    │   ├── estacionamento/
 │    │   │    ├── Main.java
 │    │   │    └── ...
 └── test/
      ├── java/
           ├── estacionamento/
           │    ├── MainTest.java
           │    └── ...
