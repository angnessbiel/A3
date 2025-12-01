# Sistema de Estoque

Este documento fornece uma visão geral das funcionalidades do sistema, as tecnologias e bibliotecas utilizadas, e a autoria do projeto.

***

## ✨ Funcionalidades do Programa

O sistema é uma aplicação de gerenciamento que otimiza o controle de produtos e a administração de usuários.

### 📦 Módulo de Gerenciamento de Produtos (Estoque)
O sistema permite a manipulação completa do estoque (**CRUD**: Criar, Recuperar/Listar, Alterar/Editar e Apagar/Excluir produtos). Ele apresenta o estoque em uma tabela organizada e calcula e exibe automaticamente o **Valor Total do Estoque** (Quantidade x Preço) na tela principal. Para auditoria, é possível gerar um **Relatório em PDF** contendo a lista completa de produtos e o valor total calculado.

### 🔐 Módulo de Usuários e Segurança
O acesso ao sistema é feito através de **Login e Autenticação** com credenciais. Usuários logados têm a funcionalidade de **editar** seu nome e **alterar** sua senha, garantindo a segurança e a personalização da conta.

***

## ⚙️ Tecnologias e Bibliotecas Utilizadas

* **Java:** Linguagem de programação principal utilizada em todo o desenvolvimento do sistema.
* **Swing (Java):** Framework padrão para a criação da Interface Gráfica de Usuário (GUI).
* **FlatLaf (FlatMacLightLaf):** Biblioteca essencial para aplicar uma estilização moderna (flat design) e aprimorada aos componentes Swing, como os campos arredondados.
* **BCRYPT:** Biblioteca crucial de segurança utilizada para **fazer o *hash* das senhas** antes de armazená-las no banco de dados, garantindo que as credenciais dos usuários estejam protegidas.
* **JDBC (Java Database Connectivity) e DAO:** Utilizado para a conexão com o banco de dados e para a persistência dos dados (seguindo o padrão Data Access Object).
* **iTextPDF:** Biblioteca utilizada especificamente para a **geração do relatório de estoque** em formato PDF.

***

## 👥 Autores

O projeto foi desenvolvido por:

* **Eduardo Alves**
* **Gabriel Mendes Angnes**
* **Jean Arthur Fazio**
* **Lucas Rodrigues**
