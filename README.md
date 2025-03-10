# Sistema de Gerenciamento de Reservas - Eclipse Hotel

Este projeto é um sistema de gerenciamento de reservas para o fictício "Eclipse Hotel". Ele foi desenvolvido utilizando **Java** com o framework **Spring Boot** e **PostgreSQL** como banco de dados. O sistema permite gerenciar clientes, quartos e reservas, além de fornecer endpoints para consultas específicas.

---

## 🚀 Tecnologias Utilizadas

- **Java 21**: Linguagem de programação principal.
- **Spring Boot**: Framework para desenvolvimento de aplicações Java.
- **Spring Data JPA**: Para mapeamento objeto-relacional (ORM) e acesso ao banco de dados.
- **PostgreSQL**: Banco de dados relacional utilizado.
- **Maven**: Gerenciador de dependências.

---

## 📋 Funcionalidades

O sistema oferece as seguintes funcionalidades:

### 1. **Gerenciamento de Clientes**
- Cadastro, consulta, atualização e exclusão de clientes.

### 2. **Gerenciamento de Quartos**
- Cadastro, consulta, atualização e exclusão de quartos.

### 3. **Gerenciamento de Reservas**
- Abertura de novas reservas.
- Encerramento de reservas.
- Consulta de reservas por intervalo de datas.
- Consulta de quartos ocupados no momento.

---

## 🔧 Como Configurar e Executar o Projeto

### Pré-requisitos
- **Java 21** instalado.
- **Maven** instalado.
- **PostgreSQL** instalado e configurado (ou use o H2 em memória).
- **Git** para clonar o repositório.

## ➡️ Melhorias Futuras
Devido ao tempo de desenvolvimento, não consegui implementar algumas melhorias que poderiam ser feitas nesse projeto. Por isso, segue algumas melhorias que podem ser implementadas (vou implementar posteriormente);

**- 1. Validação de Disponibilidade de Quartos
   Problema: O sistema não verifica se o quarto já está reservado para o período solicitado.

Solução: Implementar uma validação no endpoint de criação de reserva para garantir que o quarto esteja disponível no período de check-in e check-out solicitado.

**2. Melhorar o Tratamento de Exceções
   Problema: O tratamento de exceções atual é básico e não fornece informações detalhadas sobre o erro.

Solução: Criar uma classe de exceção personalizada e um @ControllerAdvice para tratar erros de forma mais amigável.

**3. Adicionar Autenticação e Autorização
   Problema: O sistema não possui controle de acesso, o que pode permitir que qualquer pessoa acesse ou modifique dados.

Solução: Implementar autenticação e autorização usando Spring Security.

**4. Adicionar Logs Detalhados
   Problema: O sistema não possui logs detalhados, o que dificulta a depuração em caso de erros.

Solução: Adicionar logs em pontos estratégicos do sistema, como em operações de CRUD e validações.

**5. Adicionar Documentação da API
   Problema: A API não está documentada, o que dificulta o uso por outros desenvolvedores ou equipes.

Solução: Usar o Swagger para gerar documentação automática da API.