# Caso de Uso: Cadastro de Professor
<a name="CC"></a>

| <div style="width:290px">Versão</div> | Atividade | Autor | Data |
|:------------|:----------------|:--------------|:----------------|
| 1.0 | Versão Inicial do Arquivo | Ramon Lopes | 26/03/2024 |
| 1.1 | Corrigindo fluxo principal | Ramon Lopes | 01/04/2024 |
| 1.2 | Atualização tags HTML | Matheus de Azevedo | 10/07/2024 |

## **Descrição**
Esta funcionalidade permite o cadastro de novos professores no sistema. O ator deve fornecer as informações de acordo.

## **Ator(es)**
Coordenadores e Diretores.

## **Caminho para Acesso à Funcionalidade**
Tela inicial > Tela de Cadastro de Professor.

## **Pré-condições**
Ator deve estar logado.

<a name="FP"></a>

## **Fluxo Principal**
### FP - Cadastro de novo professor 

| ID | Passo | Fluxo | Regra de Negócio |
|:--------------|:----------------|:--------------|:----------------|
| 1 | O usuário acessa a página de cadastro de professor. | | |
| 2 | O usuário preenche as informações necessárias, como nome completo, email, carga horária, área de atuação, entre outras. | | [RN01](#RN), [RN02](#RN) |
| 3 | O usuário pressiona o botão salvar. | [FEX01](#FEX01), [FEX02](#FEX02)  | |
| 4 | O sistema exibe o pop-up de cadastro realizado com sucesso na tela. | | |

<a name="FA"></a>

## **Fluxo Alternativo**

<a name="FA01"></a>

### FA01 - Cancelar cadastro 

| ID | Passo | Fluxo | Regra de Negócio |
|:--------------|:----------------|:--------------|:----------------|
| 1 | O usuário pressiona o botão cancelar. | | |
| 2 | O sistema exibe o pop-up de confirmação na tela. | | |
| 3 | O usuário pressiona o botão sim. |  | |
| 4 | O sistema retorna à tela anterior. | | |

<a name="FE"></a>

## **Fluxo Extensão**

Não se aplica.

<a name="FEX"></a>

## **Fluxo Exceção**

<a name="FEX01"></a>

### FEX01 - Campo obrigatorio não informado

| ID | Passo | Fluxo | Regra de Negócio |
|:--------------|:----------------|:--------------|:----------------|
| 1 | O sistema identifica que campos obrigatórios não foram preenchidos. | | |
| 2 | O sistema exibe a mensagem "Campo obrigatório não informado" abaixo do(s) campo(s) não preenchido(s). | | |

<a name="FEX02"></a>

### FEX02 - Professor já cadastrado

| ID | Passo | Fluxo | Regra de Negócio |
|:--------------|:----------------|:--------------|:----------------|
| 1 | O sistema verifica se existe algum professor cadastrado com o mesmo nome. | | |
| 2 | O sistema exibe um pop-up com a mensagem "Professor já cadastrado anteriormente". | | |

<a name="RN"></a>

## Regras de Negócio

| ID | Descrição da Regra |
|:-----|:-----|
| **RN01** | O CPF deve ser validado de acordo com as regras estipuladas pela receita federal. |
| **RN02** | O email informado deve ser válido seguindo o formato 'usuario'@'dominio'. O 'usuario' pode conter caracteres alfanuméricos e os seguintes caracteres especiais '.', '-' e '_'. O domínio deve permitir múltiplos subdomínios. |

<a name="RI"></a>

## Regras de Interface 

| ID | Descrição da Regra |
|:-----|:-----|
| **RI01** | O campo deverá ficar com a borda vermelha quando for informado um valor inválido ou quando for um campo obrigatório e não estiver preenchido. |
| **RI02** | A pop-up deve ser exibida na tela por no máximo 10 segundos e o usuário deve possuir a opção de fechá-la manualmente. |