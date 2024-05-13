 # Caso de Uso: Cadastro de Contatos

| <div style="width:290px">Versão</div> | Atividade              | Autor                      | Data       |
| :----------------------------------------- | :------------------- | :------------------------- | :--------- |
| 1.0                                        | Versão Inicial do Arquivo	 | Gustavo Coimbra Cavalcante | 17/03/2023 |

## **Descrição**

Esta funcionalidade permite o cadastro de contatos oficiais, para os quais serão enviados e-mails contendo os relatórios de acompanhamento. O termo cadastro prevê as operações de inclusão, alteração, exclusão e consulta.

## **Ator(es)** 

Administrador de Tribunal de Contas / Suplente

## **Caminho para Acesso à Funcionalidade**

Login > Controle > Contatos

## **Pré-Condições**

O usuário necessita estar autenticado como Administrador de Tribunal de Contas ou Suplente

## **Descrição da(s) tela(s)**

<a name="tela1"></a>**Tela 1**

![listagem](https://user-images.githubusercontent.com/106631464/227244789-5c8452bc-7f1e-4707-816d-ab5ea0bbab0e.png)

| Nome do Atributo  | Preench. Obrigatório | Preench. Automático | Tipo         | Máscara | Observações | Regra de Interface |
| ----------------- | -------------------- | ------------------- | ------------ | ------- | ----------- | ------------------ |
| Adicionar         |                      |                     | Botão        |         |             |                    |
| Campo pesquisar   |                      |                     | Alfanumérico |         |             |                    |
| Botão pesquisar   |                      |                     | Botão        |         |             |                    |
| Lista de Contatos    |                   |                     | Lista        |         |             | [RI03](#RI)        |
| Ordernar          |                      |                     | Botão        |         |             |                    |
| Editar            |                      |                     | Botão        |         |             |                    |
| Excluir           |                      |                     | Botão        |         |             |                    |


<a name="tela2"></a>**Tela 2**

![form](https://user-images.githubusercontent.com/106631464/227245063-ea4816de-2ae5-40f7-b1db-c050a4ee63b9.png)

| Nome do Atributo | Preench. Obrigatório | Preench. Automático | Tipo          | Máscara        | Observações | Regra de Interface |
| ---------------- | :------------------: | ------------------- | ------------- | -------------- | ----------- | ------------------ |
| Salvar           |                      |                     | Botão         |                |             |                    |
| Cancelar         |                      |                     | Botão         |                |             |                    |
| Nome             |          x           |                     | Alfanumérico  |                |             | [RI01](#RI)        |
| E-mail           |          x           |                     | Alfanumérico  |                |             | [RI01](#RI)        |
| Gestão           |          x           |                     | Seleção única |                | Valores válidos: Estadual, Municipal | [RI01](#RI) e [RI04](#RI) |
| Município        |          x           |                     | Seleção única |                | Valores válidos: nome dos municípios em ordem crescente alfabética | [RI01](#RI), [RI05](#RI) e [RI06](#RI) |
| Cargo            |          x           |                     | Seleção única |                | Valores válidos: Controle interno, Gestor, Secretário de Educação     | [RI01](#RI) |
| Descrição da Vaga |                     |                     | Alfanumérico  |                |             |                    | 


<a name="tela3"></a>**Tela 3**

![form-mensagem-erro](https://user-images.githubusercontent.com/106631464/227249121-08e25941-15d4-49b8-8fbc-a9ca18cf399d.png)

| Nome do Atributo | Preench. Obrigatório | Preench. Automático | Tipo          | Máscara        | Observações | Regra de Interface |
| ---------------- | :------------------: | ------------------- | ------------- | -------------- | ----------- | ------------------ |
| Mensagem de erro |                      |                     | Pop-up        |                |             | [RI02](#RI)        |


<a name="tela4"></a>**Tela 4**

![listagem-mensagem-de-sucesso](https://user-images.githubusercontent.com/106631464/227255071-35533c2c-a55b-4aa8-ae5d-858def045dbb.png)

| Nome do Atributo | Preench. Obrigatório | Preench. Automático | Tipo          | Máscara        | Observações | Regra de Interface |
| ---------------- | :------------------: | ------------------- | ------------- | -------------- | ----------- | ------------------ |
| Mensagem de sucesso |                   |                     | Pop-up        |                |             | [RI02](#RI)        |


<a name="tela5"></a>**Tela 5**

![mensagem-exclusao](https://user-images.githubusercontent.com/106631464/227255162-6694e6bf-f1e5-47d6-bd65-493ccb135340.png)

| Nome do Atributo | Preench. Obrigatório | Preench. Automático | Tipo          | Máscara        | Observações | Regra de Interface |
| ---------------- | :------------------: | ------------------- | ------------- | -------------- | ----------- | ------------------ |
| Confirmar           |                   |                     | Botão         |                |             |                    |
| Cancelar            |                   |                     | Botão         |                |             |                    |


<a name="tela6"></a>**Tela 6**

![busca-sem-resultados](https://user-images.githubusercontent.com/106631464/227255657-a3321c7c-8f1d-4f42-b7f7-c493dfa7314d.png)

| Nome do Atributo  | Preench. Obrigatório | Preench. Automático | Tipo         | Máscara | Observações | Regra de Interface |
| ----------------- | -------------------- | ------------------- | ------------ | ------- | ----------- | ------------------ |
| Lista de Contatos |                      |                     | Lista        |         |             | [RI03](#RI)        |


## **Fluxo Principal**
<a name="FP"></a>
### FP - Incluir Contato

| ID | Passo | Fluxo | Regra de Negócio | Tela |
|:--------------|:----------------|:--------------|:----------------|:--------------|
| 1 | Usuário clica no menu que gerencia o cadastro de Contatos.                      |                                               |   |             |
| 2 | Sistema retorna a listagem de Contatos.                                         |                       | [RN02](#RN) e [RN03](#RN) | [1](#tela1) |
| 3 | Usuário clica no botão *Adicionar* para incluir um novo Contato.                | [FA01](#FA01), [FA02](#FA02) e [FA03](#FA03)  |   | [1](#tela1) |
| 4 | Sistema retorna página contendo o formulário com os campos a serem preenchidos. |         | [RN01](#RN) e [RN04](#RN)               | [2](#tela2) |
| 5 | Usuário fornece os dados e clica no botão *Salvar*.                             | [FEX01](#FEX01), [FEX02](#FEX02), [FEX04](#FEX04) |           |   |             |
| 6 | Sistema salva o cadastro e exibe mensagem de sucesso.                           |                                   |               | [4](#tela4) |


## **Fluxo Alternativo**
<a name="FA01"></a>
### FA01 - Editar Contato

| ID | Passo | Fluxo | Regra de Negócio | Tela |
|:--------------|:----------------|:--------------|:----------------|:--------------|
| 1 | Usuário clica no botão *Editar* de um determinado Contato.                               |     |                                  | [1](#tela1) |
| 2 | Sistema retorna página contendo o formulário com os campos a serem preenchidos.          |     | [RN01](#RN) e [RN04](#RN)        | [2](#tela2) |
| 3 | Usuário fornece os dados e clica no botão *Salvar*.                                      | [FEX01](#FEX01) e [FEX02](#FEX02) |    | [2](#tela2) |
| 4 | Sistema salva o cadastro e exibe pop-up com a mensagem *"Registro alterado com sucesso"*. |     |                                  | [4](#tela4) |

<a name="FA02"></a>
### FA02 - Excluir Contato

| ID | Passo | Fluxo | Regra de Negócio | Tela |
|:--------------|:----------------|:--------------|:----------------|:--------------|
| 1 | Usuário clica no botão *Excluir* de um determinado Contato.                                |     |      | [1](#tela1) |
| 2 | Sistema exibe mensagem de confirmação de exclusão.                                         |     |      | [5](#tela5) |
| 3 | Usuário confirma a exclusão.                                                               |     |      |             |
| 4 | Sistema exclui o registro e exibe pop-up com a mensagem *"Registro excluído com sucesso"*. |     |      | [4](#tela4) |

<a name="FA03"></a>
### FA03 - Consultar Contato

| ID | Passo | Fluxo | Regra de Negócio | Tela |
|:--------------|:----------------|:--------------|:----------------|:--------------|
| 1 | Usuário busca pelo nome.                         |                 |    | [1](#tela1) |
| 2 | Sistema retorna Contato que corresponde à busca. | [FEX03](#FEX03) |    |             |


## **Fluxo de Extensão: Não se aplica**


## **Fluxo de Exceção**
<a name="FEX01"></a>
### FEX01 - Campo(s) obrigatório(s) não preenchido(s)

| ID | Passo | Fluxo | Regra de Negócio | Tela |
|:--------------|:----------------|:--------------|:----------------|:--------------|
| 1 | Sistema identifica campo(s) obrigatório(s) não preenchido(s) ao clicar em *Salvar*.                                                       |   |   |    |
| 2 | Sistema exibe a mensagem *"Campo obrigatório não informado"* abaixo do(s) campo(s) não preenchido(s) e exibe pop-up com mensagem de erro. |   |   | [3](#tela3) |

<a name="FEX02"></a>
### FEX02 - Campo(s) preenchido(s) com dado(s) incorreto(s)

| ID | Passo | Fluxo | Regra de Negócio | Tela |
|:--------------|:----------------|:--------------|:----------------|:--------------|
| 1 | Sistema identifica campo(s) preenchido(s) com dado(s) incorreto(s) ao clicar em *Salvar*.                                              |   |   |    |
| 2 | Sistema exibe a mensagem *"Dado inválido*" abaixo do(s) campo(s) preenchido(s) de forma incorreta e exibe pop-up com mensagem de erro. |   |   | [3](#tela3) |

<a name="FEX03"></a>
### FEX03 - Nenhum registro corresponde à busca

| ID | Passo | Fluxo | Regra de Negócio | Tela |
|:--------------|:----------------|:--------------|:----------------|:--------------|
| 1 | Usuário busca por nome inexistente como Contato.                             |   |   |             |
| 2 | O sistema exibe uma mensagem informando que nenhum resultado foi encontrado. |   |   | [6](#tela6) |

<a name="FEX04"></a> 
### FEX04 - Gestão com cargo já cadastrado

| ID | Passo | Fluxo | Regra de Negócio | Tela |
|:--------------|:----------------|:--------------|:----------------|:--------------|
| 1 | Sistema identifica a existência de contato associado ao cargo para determinado estado/município. |     | [RN04](#RN) |             |
| 2 | Sistema exibe pop-up com a mensagem de erro *"Erro ao salvar. Este cargo já possui contato cadastrado para esta gestão"*. |     |             | [3](#tela3) |

<a name="RN"></a>
## Regras de Negócio

| ID | Descrição da Regra |
|:-----|:-----|
| **RN01** | O email informado deve ser válido seguindo o formato 'usuario'@'dominio'. O 'usuario' pode conter caracteres alfanuméricos e os seguintes caracteres especiais '.', '-' e '_'._ O domínio deve permitir múltiplos subdomínios. |
| **RN02** | Enquanto nenhuma ação for realizada, o sistema exibe todos os Contatos. |
| **RN03** | O sistema deve exibir a lista de Contatos em ordem crescente alfabética pelo nome do contato. |
| **RN04** | Para cada município/estado serão cadastrados até 3 contatos para envio dos relatórios de acompanhamento. Um para cada tipo de cargo. |

<a name="RI"></a>
## Regras de Interface

| ID | Descrição da Regra |
|:-----|:-----|
| **RI01** | O campo deverá ficar com a borda vermelha quando for informado um valor inválido ou quando for um campo obrigatório e não estiver preenchido. |
| **RI02** | A pop-up deve ser exibida na tela por no máximo 10 segundos e o usuário deve possuir a opção de fechá-la manualmente. |
| **RI03** | A listagem deve ser paginada. Por padrão, devem ser exibidos 10 registros por página, porém essa quantidade pode ser alterada. |
| **RI04** | O campo deve ficar visível apenas quando o usuário logado estiver associado à um tribunal que possui os dois níveis de jurisdição: estadual e municipal. |
| **RI05** | O campo deve ficar visível quando selecionado a opção 'Municipal' no campo 'Gestão' ou quando o tribunal possuir apenas nível de jurisdição municipal. |
| **RI06** | O campo deve exibir apenas os municípios jurisdicionados pelo tribunal do usuário logado. | 
