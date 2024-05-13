# Caso de Uso: Login 


| <div style="width:290px">Versão</div> | Atividade | Autor | Data |
|:------------|:----------------|:--------------|:----------------|
| 1.0 | Versão Inicial do Arquivo | Carlos Henrique R. de Jesus | 27/10/2023 |
| 1.1 | Apagando os Destaques da Tela Inicial | Carlos Henrique R. de Jesus | 20/11/2023 |

## **Descrição**
Esta funcionalidade permite o acesso de um usuário ao sistema. O usuário deve fornecer suas credenciais autenticadas, como o endereço de e-mail ou cpf e uma senha, que são previamente definidas e associadas ao seu perfil

## **Ator(es)**
Cliente e Administrador do sistema.

## **Caminho para Acesso à Funcionalidade**
Tela inicial > Login

## **Pré-condições**
Não se aplica.

## **Descrição da(s) Tela(s)**

<a name="tela1"></a>**Tela 1** - `Tela Inicial`

![image](https://github.com/FabricaDeSoftwareINF/ipelab/assets/106249672/706717cd-a0c0-490f-99b4-1415bae7033c)

| Nome do Atributo | Preench. Obrigatório | Preench. Automático | Tipo | Máscara | Observações | Regra de Interface |
|:--------------|:----------------:|:--------------:|:--------------|:----------------|:--------------|:----------------|
| Entre | | | Botão | | | |
| Cadastre-se | | | Botão | | | |
| Clique aqui | | | Botão | | | |
| Slider navigation | | | Botão | | | |
| Ver Todos | | | Botão | | | |

<a name="tela2"></a>**Tela 2** - `Login`

![image](https://github.com/FabricaDeSoftwareINF/ipelab/assets/106249672/44c9b2e1-3d22-4aaa-a08c-7eb64f850661)

| Nome do Atributo | Preench. Obrigatório | Preench. Automático | Tipo | Máscara | Observações | Regra de Interface |
|:--------------|:----------------:|:--------------:|:--------------|:----------------|:--------------|:----------------|
| E-mail ou CPF | x | | Alfanumérico | | | [RI01](#RI) |
| Senha | x | | Alfanumérico | | | [RI01](#RI) |
| Esqueceu sua senha? | | | Botão | | | |
| Não tem cadastro? | | | Botão | | | |
| Entrar | | | Botão | | | |

<a name="tela3"></a>**Tela 3** - `Login Mensagem de Erro`

![image](https://github.com/FabricaDeSoftwareINF/ipelab/assets/8249709/6ecf3799-9dde-4f0d-a23c-aa076f2c7079)


| Nome do Atributo | Preench. Obrigatório | Preench. Automático | Tipo | Máscara | Observações | Regra de Interface |
|:--------------|:----------------:|:--------------:|:--------------|:----------------|:--------------|:----------------|
| Mensagem de erro | | | Pop-Up | | | [RI02](#RI) |

<a name="tela4"></a>**Tela 4** - `Login Mensagem Campo Obrigatório Não Preenchido`

![image](https://github.com/FabricaDeSoftwareINF/ipelab/assets/106249672/705bf51d-c4ac-4e30-9522-8a02dbc08329)

| Nome do Atributo | Preench. Obrigatório | Preench. Automático | Tipo | Máscara | Observações | Regra de Interface |
|:--------------|:----------------:|:--------------:|:--------------|:----------------|:--------------|:----------------|
| Mensagem de erro | | | Mensagem | | | [RI02](#RI) |

<a name="FP"></a>

## **Fluxo Principal**
### FP - Login

| ID | Passo | Fluxo | Regra de Negócio | Tela |
|:--------------|:----------------|:--------------|:----------------|:--------------|
| 1 | O sistema mostra a tela inicial |  |  | [1](#tela1) |
| 2 | O usuário clica no botão Clique aqui ou no botão Entre | [FA01](#FA), [FA03](#FA),  | | [1](#tela1) |
| 3 | O sistema mostra a tela de login | [FA01](#FA), [FA02](#FA) | | [2](#tela2) |
| 4 | O usúario informa o seu e-mail ou CPF e a senha | [FEX01](#FC), [FEX02](#FC) | [RN01](#RN), [RN02](#RN) | [2](#tela2) |
| 5 | O usúario pressiona o botão entrar ou pressiona a tecla enter |  | | [2](#tela2) |
| 6 | O sistema autentica, concede acesso ao usuário e executa o caso de uso [Home Cliente](https://github.com/FabricaDeSoftwareINF/ambientacao/blob/fc32d892fe36c7bcb704e8bb7ad1942c666d83ec/documentacao/requisitos/template/caso-de-uso-exemplo-home-cliente.md) ou Home Administrador (a depender do perfil do usuário) |  | |  |

<a name="FA"></a>

## **Fluxo Alternativo**

### FA01 - Cadastro

| ID | Passo | Fluxo | Regra de Negócio | Tela |
|:--------------|:----------------|:--------------|:----------------|:--------------|
| 1 | Usuário clica em "Cadastre-se" ou "Não tem cadastro?"  | | | [2](#tela2) |
| 2 | O sistema executa o caso de uso [Cadastro](https://github.com/FabricaDeSoftwareINF/ambientacao/blob/fc32d892fe36c7bcb704e8bb7ad1942c666d83ec/documentacao/requisitos/template/caso-de-uso-exemplo-cadastro-usuarios.md)| | | |

### FA02 - Recuperação de senha

| ID | Passo | Fluxo | Regra de Negócio | Tela |
|:--------------|:----------------|:--------------|:----------------|:--------------|
| 1 | Usuário clica em "Esqueceu sua senha?" | | | [2](#tela2) |
| 2 | O sistema executa o caso de uso [Recuperação de senha](https://github.com/FabricaDeSoftwareINF/ambientacao/blob/fc32d892fe36c7bcb704e8bb7ad1942c666d83ec/documentacao/requisitos/template/caso-de-uso-exemplo-recuperacao-senha.md)| | | |

### FA03 - Vitrine de Talentos

| ID | Passo | Fluxo | Regra de Negócio | Tela |
|:--------------|:----------------|:--------------|:----------------|:--------------|
| 1 | Usuário clica em "Ver todos" | | | [1](#tela1) |
| 2 | O sistema executa o caso de uso Vitrine de Talentos | | | |

<a name="FE"></a>

## **Fluxo Extensão:**

Não se aplica

<a name="FC"></a>

## **Fluxo Exceção**
### FEX01 - Credenciais inválidas

| ID | Passo | Fluxo | Regra de Negócio | Tela |
|:--------------|:----------------|:--------------|:----------------|:--------------|
| 1 | O sistema identifica campo(s) preenchido(s) com dado(s) incorreto(s) |  | | [3](#tela3) |
| 2 | O sistema exibe a mensagem "E-mail/CPF ou senha incorretos!" em um pop-up. |  | | [3](#tela3) |

### FEX02 - Campo obrigatório não informado

| ID | Passo | Fluxo | Regra de Negócio | Tela |
|:--------------|:----------------|:--------------|:----------------|:--------------|
| 1 | O sistema identifica que campos obrigatórios não foram preenchidos |  | | [4](#tela4)|
| 2 | O sistema exibe a mensagem "Campo obrigatório não informado" abaixo do(s) campo(s) não preenchido(s) |  |  | [4](#tela4) |

<a name="RN"></a>

## Regras de Negócio

| ID | Descrição da Regra |
|:-----|:-----|
| **RN01** | O CPF deve ser validado de acordo com as regras estipuladas pela receita federal |
| **RN02** | O email informado deve ser válido seguindo o formato 'usuario'@'dominio'. O 'usuario' pode conter caracteres alfanuméricos e os seguintes caracteres especiais '.', '-' e ''. O domínio deve permitir múltiplos subdomínios |

<a name="RI"></a>

## Regras de Interface 

| ID | Descrição da Regra |
|:-----|:-----|
| **RI01** | O campo deverá ficar com a borda vermelha quando for informado um valor inválido ou quando for um campo obrigatório e não estiver preenchido. |
| **RI02** | A pop-up deve ser exibida na tela por no máximo 10 segundos e o usuário deve possuir a opção de fechá-la manualmente. |

