# Caso de Uso: Cadastro de Usuários

| <div style="width:290px">Versão</div> | Atividade | Autor | Data |
|:------------|:----------------|:--------------|:----------------|
| 1.0 | Criação do documento | Mariana Soller Ramada  | 14/04/2022 |
| 1.1 | Corrigindo idenfiticador de Fluxo de Exceção e removendo seção de Regras Gerais | Mariana Soller Ramada | 27/02/2024 |

## **Descrição**
Essa funcionalidade é responsável por cadastrar usuários para permitir o acesso dos mesmos ao sistema.

## **Ator(es)**
Administrador

## **Caminho para Acesso à Funcionalidade**
Login > Menu > Usuários

## **Pré-condições**
O usuário deve possuir a permissão de administrador.

## **Descrição da(s) Tela(s)**

<a name="tela1"></a>**Tela 1**

![listagem-usuarios](https://user-images.githubusercontent.com/8249709/163399632-61aac45b-82ae-4c28-a9e3-62edcab44472.PNG)

| Nome do Atributo | Preenchimento | Tipo | Máscara | Observações | Regra de Interface |
|:-----------------|:-------------:|:-----|:--------|:------------|:-------------------|
| Adicionar usuário | | Botão | | | |
| Buscar | | Alfanumérico | | | |
| Lista de usuários | | | | | [RI01](#RIS) | 
| Editar | | Botão | | | | 
| Excluir | | Botão | | | | 


<a name="tela2"></a>**Tela 2**

![adicionar-usuario](https://user-images.githubusercontent.com/8249709/163402830-26f240aa-f332-4e38-8a80-e13d7b69e4b7.PNG)

| Nome do Atributo | Preenchimento | Tipo | Máscara | Observações | Regra de Interface |
|:-----------------|:-------------:|:-----|:--------|:------------|:-------------------|
| Nome | OBR | Alfanumérico | | | |
| CPF | OBR | Numérico | XXX.XXX.XXX-XX | | |
| Cancelar | | Botão | | | | 
| Adicionar | | Botão | | | |


<a name="tela3"></a>**Tela 3**

![editar-usuario](https://user-images.githubusercontent.com/8249709/163402841-afae1a53-9551-4292-9a68-28f36d34a10f.PNG)

| Nome do Atributo | Preenchimento | Tipo | Máscara | Observações | Regra de Interface |
|:-----------------|:-------------:|:-----|:--------|:------------|:-------------------|
| Nome | OBR, AUT | Alfanumérico | | | |
| CPF | OBR, AUT | Numérico | XXX.XXX.XXX-XX | | |
| Cancelar | | | Botão | | | | 
| Adicionar | | | Botão | | | | 



## **Fluxo Principal**
### <a name="FP"></a>FP - Adicionar usuário

| ID | Passo | Fluxo | Regra de Negócio | Tela |
|:--------------|:----------------|:--------------|:----------------|:--------------|
| 1 | O usuário pressiona o botão *Adicionar usuário* | [FA01](#FA01), [FA02](#FA02), [FA03](#FA03) | | [1](#tela1) |
| 2 | O sistema exibe a tela de inclusão de usuário |  | | [2](#tela2)|
| 3 | O usuário informa o nome, CPF e pressiona o botão *Adicionar* | [FEX01](#FEX01), [FEX02](#FEX02) |  | [2](#tela2) |
| 4 | O sistema exibe uma mensagem de sucesso |  | |  |


## **Fluxo Alternativo**

### <a name="FA01"></a>FA01 - Buscar usuário

| ID | Passo | Fluxo | Regra de Negócio | Tela |
|:--------------|:----------------|:--------------|:----------------|:--------------|
| 1 |	O usuário informa o nome do usuário | [FEX03](#FEX03) | [RN02](#RNS), [RN04](#RNS) | [1](#tela1) |
| 2 |	O sistema exibe o(s) usuário(s) que atende(m) à busca |  | [RN03](#RNS) |  |

### <a name="FA02"></a>FA02 - Editar usuário

| ID | Passo | Fluxo | Regra de Negócio | Tela |
|:--------------|:----------------|:--------------|:----------------|:--------------|
| 1 | O usuário pressiona o botão *Editar* |  |  | [1](#tela1) |
| 2 |	O sistema exibe a tela de edição de usuário |  |  | [3](#tela3) |
| 3 |	O usuário informa os novos dados e pressiona o botão *Atualizar*  | [FEX01](#FEX01), [FEX02](#FEX02) |  | [3](#tela3) |
| 4 |	O sistema exibe uma mensagem de sucesso |  |  |  |

### <a name="FA03"></a>FA03 - Excluir usuário

| ID | Passo | Fluxo | Regra de Negócio | Tela |
|:--------------|:----------------|:--------------|:----------------|:--------------|
| 1 | O usuário pressiona o botão *Excluir* |  |  | [1](#tela1) |
| 2 |	O sistema exibe a mensagem "Deseja excluir o usuário <nome-usuario>?" |  |  |  |
| 3 |	O usuário pressiona o botão *Confirmar*  | [FA04](#FA04) |  | |
| 4 |	O sistema exclui o respectivo usuário |  |  |  |
  
 ### <a name="FA04"></a>FA04 - Cancelar exclusão

| ID | Passo | Fluxo | Regra de Negócio | Tela |
|:--------------|:----------------|:--------------|:----------------|:--------------|
| 1 |	O usuário pressiona o botão *Cancelar*	 |  |  | [1](#tela1) |
| 2 | O sistema retorna o fluxo para o Passo 1 do [FP](#FP) |  |  |  |


## **Fluxo Extensão**: Não se aplica

## **Fluxo Exceção**
### <a name="FEX01"></a>FEX01 - Campos obrigatórios não preenchidos
| ID | Passo | Fluxo | Regra de Negócio | Tela |
|:--------------|:----------------|:--------------|:----------------|:--------------|
| 1 | O sistema identifica que campos obrigatórios não foram preenchidos |  | | |
| 2 | O sistema informa que é necessário preencher os respectivos campos |  | | |
| 3 | O sistema retorna o fluxo para o Passo 3 do [FP](#FP) ou [FA02](#FA02) |  | | |
  
### <a name="FEX02"></a>FEX02 - Dados inválidos
| ID | Passo | Fluxo | Regra de Negócio | Tela |
|:--------------|:----------------|:--------------|:----------------|:--------------|
| 1 | O sistema identifica que há dados informados inválidos |  | [RN01](#RNS) | |
| 2 | O sistema informa que há dados incorretos |  | | |
| 3 | O sistema retorna o fluxo para o Passo 3 do [FP](#FP) ou [FA02](#FA02) |  | | |
  
### <a name="FEX03"></a>FEX03 - Nenhum resultado encontrado
| ID | Passo | Fluxo | Regra de Negócio | Tela |
|:--------------|:----------------|:--------------|:----------------|:--------------|
| 1 | O sistema não encontra nenhum usuário que atenda aos critérios da busca	 |  | | |
| 2 | O sistema exibe o texto "Nenhum resultado encontrado" |  | | |
| 3 | O sistema retorna o fluxo para o Passo 1 do [FA01](#FA01) |  | | |

## <a name="RNS"></a>Regras de Negócio

| ID | Descrição da Regra |
|:-----|:-----|
| **RN01** | O CPF deve ser validado de acordo com as regras estipuladas pela receita federal. |
| **RN02** | O sistema deve permitir buscar usuários pelo nome. |
| **RN03** | O sistema deve exibir a lista de usuários em ordem crescente alfabética do nome do usuário.|
| **RN04** | Enquanto nenhuma pesquisa for realizada, o sistema exibe todos os usuários do sistema.|

## <a name="RIS"></a>Regras de Interface 

| ID | Descrição da Regra |
|:-----|:-----|
| **RI01** | A listagem deve ser paginada. Por padrão, devem ser exibidos 10 registros por página, porém essa quantidade pode ser alterada. |
