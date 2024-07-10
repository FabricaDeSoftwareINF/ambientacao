# Caso de Uso: Cadastro 
<a name="CC"></a>

| <div style="width:290px">Versão</div> | Atividade | Autor | Data |
|:------------|:----------------|:--------------|:----------------|
| 1.0 | Versão Inicial do Arquivo | Carlos Henrique R. de Jesus | 27/10/2023 |
| 1.1 | Validando campos obrigatórios | Carlos Henrique R. de Jesus | 20/11/2023 |
| 1.2 | Alterando imagens e adicionando nova tela para solicitar concordância para divulgação de contato pessoal para os participantes do banco de talentos | Carlos Henrique R. de Jesus | 27/01/2023 |
| 1.3 | Atualização do formato de descrição de telas e tags HTML | Matheus de Azevedo | 10/07/2024 |

## **Descrição**
Esta funcionalidade permite o cadastro de novos usuários no sistema. O usuário deve fornecer suas informações de acordo.

## **Ator(es)**
Cliente.

## **Caminho para Acesso à Funcionalidade**
Tela inicial > Tela de Cadastro.

## **Pré-condições**
Não se aplica.

## **Descrição da(s) Tela(s)**

<a name="tela1"></a>

**Tela 1** - `Cadastro de pessoa física - Dados pessoais`

![image](https://github.com/FabricaDeSoftwareINF/ipelab/assets/106249672/d2703d49-ee31-4141-91a5-97ca9e32d867)

| Nome do Atributo | Preenchimento | Tipo | Máscara | Observações | Regra de Interface |
|:-----------------|:-------------:|:-----|:--------|:------------|:-------------------|
| Nome | OBR | Alfanumérico | | | [RI01](#RI) |
| CPF | OBR | Alfanumérico | XXX.XXX.XXX-XX | | [RI01](#RI) |
| E-mail | OBR | Alfanumérico | | | [RI01](#RI) |
| Telefone | OBR | Numérico | | | [RI01](#RI) |
| Perfil | OBR | Seleção única | | Valores válidos: Pesquisador, Estudante, Inventor Independente, Empreendedor e Representante De Empresa/Instituição | [RI01](#RI) |
| Senha | OBR | Alfanumérico | | | [RI01](#RI) |
| Confirmar Senha | OBR | Alfanumérico | | | [RI01](#RI), [RI03](#RI) |
| CEP | OBR | Alfanumérico | | | [RI01](#RI) |
| Endereço | OBR | Alfanumérico | | | [RI01](#RI) |
| Número | OBR | Alfanumérico | | | [RI01](#RI) |
| Complemento | | Alfanumérico | | | |
| Bairro | OBR | Alfanumérico | | | [RI01](#RI) |
| Cidade | OBR | Alfanumérico | | | [RI01](#RI) |
| Estado | OBR | Alfanumérico | | | [RI01](#RI) |
| Definição de vínculo | OBR | Seleção única | | Valores válidos: ICT, Empresa, Órgão de governo, Entidade da Sociedade Civil e Pessoa Física. | [RI01](#RI) |
| Banco de Talentos| OBR | Seleção única | | Valores válidos: Participar do Banco e Não Participar | [RI01](#RI), [RI04](#RI) |
| Avançar | | Botão | | | |

<a name="tela2"></a>

**Tela 2** - `Mensagem de divulgação dos dados de contato`

![image](https://github.com/FabricaDeSoftwareINF/ipelab/assets/8249709/be36957b-3dfe-4275-a492-d7358eafb281)

| Nome do Atributo | Preenchimento | Tipo | Máscara | Observações | Regra de Interface |
|:-----------------|:-------------:|:-----|:--------|:------------|:-------------------|
| Concordar | | Botão | | | |
| Negar | | Botão | | | |

<a name="tela3"></a>

**Tela 3** - `Cadastro de pessoa fisica - Banco de talentos`

![image](https://github.com/FabricaDeSoftwareINF/ipelab/assets/106249672/10f0d381-f6a5-4e02-b9e7-d719c5639e71)

| Nome do Atributo | Preenchimento | Tipo | Máscara | Observações | Regra de Interface |
|:-----------------|:-------------:|:-----|:--------|:------------|:-------------------|
| Instagram | | Alfanumérico | | | |
| Twitter | | Alfanumérico | | | |
| Facebook | | Alfanumérico | | | |
| LinkedIn | | Alfanumérico | | | |
| Forma de Contato | OBR | Seleção múltipla | | Valores válidos: E-mail, Instagram, Twitter, LinkedIn e Facebook |[RI01](#RI)  |
| Profissão ou Habilidade Principal | OBR | Alfanumérico | | | [RI01](#RI) |
| Descrição de Habilidades | OBR | Alfanumérico | | | [RI01](#RI) |
| Carregar foto | | Botão | | | |
| Remover foto | | Botão | | | |
| Cadastrar | | Botão | | | |
| Voltar | | Botão | | | |

<a name="tela4"></a>

**Tela 4** - `Cadastro de pessoa jurídica - Dados da empresa`

![image](https://github.com/FabricaDeSoftwareINF/ipelab/assets/106249672/8b49c5be-afb2-4aea-bb25-5fc3a056469e)

| Nome do Atributo | Preenchimento | Tipo | Máscara | Observações | Regra de Interface |
|:-----------------|:-------------:|:-----|:--------|:------------|:-------------------|
| Nome | OBR | Alfanumérico | | | [RI01](#RI) |
| CNPJ | OBR | Alfanumérico | XX.XXX.XXX/0001-XX | | [RI01](#RI) |
| Site | | Alfanumérico | | | |
| Telefone | OBR | Numérico | | | [RI01](#RI) |
| CEP | OBR | Alfanumérico | | | [RI01](#RI) |
| Endereço | OBR | Alfanumérico | | | [RI01](#RI) |
| Número | OBR | Alfanumérico | | | [RI01](#RI) |
| Complemento | | Alfanumérico | | | |
| Bairro | OBR | Alfanumérico | | | [RI01](#RI) |
| Cidade | OBR | Alfanumérico | | | [RI01](#RI) |
| Estado | OBR | Alfanumérico | | | [RI01](#RI) |
| Instagram | | Alfanumérico | | | |
| Twitter | | Alfanumérico | | | |
| LinkedIn | | Alfanumérico | | | |
| Facebook | | Alfanumérico | | | |
| Cadastrar | | Botão | | | |
| Voltar | | Botão | | | |

<a name="tela5"></a>

**Tela 5** - `Cadastro com Sucesso`

![image](https://github.com/FabricaDeSoftwareINF/ipelab/assets/106249672/f2c23331-5210-4b23-8ec7-3d5079cab100)

| Nome do Atributo | Preenchimento | Tipo | Máscara | Observações | Regra de Interface |
|:-----------------|:-------------:|:-----|:--------|:------------|:-------------------|
| Mensagem de sucesso | | Pop-Up | | | [RI02](#RI) |

<a name="tela6"></a>

**Tela 6** - `As senhas não coincidem`

![image](https://github.com/FabricaDeSoftwareINF/ipelab/assets/106249672/32105fb0-f552-419b-920f-446209776631)


<a name="FP"></a>

## **Fluxo Principal**
### FP - Cadastro de Pessoa Física 

| ID | Passo | Fluxo | Regra de Negócio | Tela |
|:--------------|:----------------|:--------------|:----------------|:--------------|
| 1 | O usuário insere informações necessárias, como email, senha, entre outras informações. | | [RN01](#RN), [RN02](#RN), [RN03](#RN) | [1](#tela1) |
| 2 | O usuário escolhe a opção de vínculo pessoa física | [FA01](#FA01) | | [1](#tela1) |
| 3 | O usuário escolhe participar do banco de talentos e pressiona o botão avançar | [FA02](#FA02), [FEX02](#FEX02) | | [1](#tela1) |
| 4 | O sistema exibe mensagem para concordância de divulgação dos contatos pessoais  | [FA02](#FA02) | [RN04](#RN) | [2](#tela2) |
| 5 | O usuário pressiona o botão concordar | [FA02](#FA02) | [RN05](#RN) | [2](#tela2) |
| 6 | O sistema mostra a página de cadastro do banco de talentos |  | | [3](#tela3) |
| 7 | O usuário insere informações necessárias |  |  | [3](#tela3) |
| 8 | O usuário pressiona o botão cadastrar | [FEX02](#FEX02)  | | [3](#tela3) |
| 9 | O sistema exibe o pop-up de cadastro realizado com sucesso na tela de login |  | | [5](#tela5) |

<a name="FA"></a>

## **Fluxo Alternativo**

<a name="FA01"></a>

### FA01 - Cadastro de Pessoa jurídica

| ID | Passo | Fluxo | Regra de Negócio | Tela |
|:--------------|:----------------|:--------------|:----------------|:--------------|
| 1 | O usuário escolhe uma das opções de vínculo entre ICT, Empresa, Órgão do governo e Entidade da Sociedade civil. | | | [1](#tela1) |
| 2| O usuário pressiona o botão avançar | [FEX01](#FC), [FEX02](#FEX02), [FEX03](#FEX03)  | | [1](#tela1) |
| 3 | O sistema mostra a tela de cadastro de dados da empresa |  | | [4](#tela4) |
| 4 | O usuário insere informações necessárias, como nome da empresa, CNPJ, entre outras informações da empresa. | | | [4](#tela4) |
| 5 | O usuário pressiona o botão cadastrar | [FEX02](#FEX02)  | | [4](#tela4) |
| 6 | O sistema exibe o pop-up de cadastro realizado com sucesso na tela de login |  |  | [5](#tela5) |

<a name="FA02"></a>

### FA02 - Não participar do Banco de Talentos

| ID | Passo | Fluxo | Regra de Negócio | Tela |
|:--------------|:----------------|:--------------|:----------------|:--------------|
| 1 | O usuário escolhe não participar do banco de talentos |  | | [1](#tela1) |
| 2 | O usuário pressiona o botão avançar | [FEX01](#FC), [FEX02](#FEX02), [FEX03](#FEX03)  | | [1](#tela1) |
| 3 | O sistema exibe o pop-up de cadastro realizado com sucesso na tela de login |  |  | [5](#tela5) |

<a name="FA03"></a>

### FA03 - Não concorda com a divulgação do contato pessoal no banco de talentos

| ID | Passo | Fluxo | Regra de Negócio | Tela |
|:--------------|:----------------|:--------------|:----------------|:--------------|
| 1 | O usuário pressiona o botão negar |  | | [2](#tela2) |
| 2 | O sistema volta para a tela inicial de cadastro |  |  | [1](#tela1) |

<a name="FE"></a>

## **Fluxo Extensão**

Não se aplica.

<a name="FEX"></a>

## **Fluxo Exceção**

<a name="FEX01"></a>

### FEX01 - Senhas não coincidem

| ID | Passo | Fluxo | Regra de Negócio | Tela |
|:--------------|:----------------|:--------------|:----------------|:--------------|
| 1 | O sistema verifica que o conteúdo do campo "Confirmar Senha" não corresponde exatamente ao informado no campo "Senha". |  | | [1](#tela1)|
| 2 | O sistema exibe a mensagem "As senhas não coincidem" abaixo do campo "Confirmar senha" |  | | [5](#tela5)|

<a name="FEX02"></a>

### FEX02 - Campo obrigatorio não informado

| ID | Passo | Fluxo | Regra de Negócio | Tela |
|:--------------|:----------------|:--------------|:----------------|:--------------|
| 1 | O sistema identifica que campos obrigatórios não foram preenchidos |  |  | [1](#tela1), [2](#tela2), [3](#tela3) |
| 2 | O sistema exibe a mensagem "Campo obrigatório não informado" abaixo do(s) campo(s) não preenchido(s) |  |  | [1](#tela1), [3](#tela2), [4](#tela3)|

<a name="FEX03"></a>

### FEX03 - Senha inválida

| ID | Passo | Fluxo | Regra de Negócio | Tela |
|:--------------|:----------------|:--------------|:----------------|:--------------|
| 1 | O sistema identifica que a senha informada não atende os critérios definidos|  | [RN03](#RN) | [1](#tela1)|
| 2 | O sistema exibe a mensagem "A senha deve ter, no mínimo, 6 caracteres, incluir números e letras maiúsculas e minúsculas" abaixo do campo "Senha" |  | | [1](#tela1) |

<a name="RN"></a>

## Regras de Negócio

| ID | Descrição da Regra |
|:-----|:-----|
| **RN01** | O CPF deve ser validado de acordo com as regras estipuladas pela receita federal |
| **RN02** | O email informado deve ser válido seguindo o formato 'usuario'@'dominio'. O 'usuario' pode conter caracteres alfanuméricos e os seguintes caracteres especiais '.', '-' e ''. O domínio deve permitir múltiplos subdomínios |
| **RN03** | A senha deve ter, no mínimo, 6 caracteres, incluir números e letras maiúsculas e minúsculas. |
| **RN04** | O sistema deve alertar aos usuários que tiverem interesse em participar do banco de talentos que eles terão seus dados de contato divulgados e informar quais são esses dados que serão divulgados. |
| **RN05** | O usuário deverá concordar com a divulgação de suas informações de contato para participar do banco de talentos. |


<a name="RI"></a>

## Regras de Interface 

| ID | Descrição da Regra |
|:-----|:-----|
| **RI01** | O campo deverá ficar com a borda vermelha quando for informado um valor inválido ou quando for um campo obrigatório e não estiver preenchido. |
| **RI02** | A pop-up deve ser exibida na tela por no máximo 10 segundos e o usuário deve possuir a opção de fechá-la manualmente. |
| **RI03** | Se as senhas inseridas nos campos ‘Senha’ e ‘Confirmação de Senha’ não forem iguais, os respectivos campos deverão ficar com a borda vermelha. |
| **RI04** | O campo “Banco de Talentos” deve ficar visível apenas quando selecionada a opção “Pessoa Física” na definição de vínculo.|
