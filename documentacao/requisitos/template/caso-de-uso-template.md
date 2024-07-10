# Caso de Uso: < nome do caso de uso >


| <div style="width:290px">Versão</div> | Atividade | Autor | Data |
|:------------|:----------------|:--------------|:----------------|
| 1.0 | Versão Inicial do Arquivo | Murilo Lopes da Luz  | 07/12/2021 |

## **Descrição**
Não se aplica.

## **Ator(es)**
Não se aplica.

## **Caminho para Acesso à Funcionalidade**
Não se aplica.

## **Pré-condições**
Não se aplica.

## **Descrição da(s) Tela(s)**

**Tela 1**
| Nome do Atributo | Preenchimento | Tipo | Máscara | Observações | Regra de Interface |
|:-----------------|:-------------:|:-----|:--------|:------------|:-------------------|
| Cancelar | | Botão | | | |
| CPF | OBR | Alfanumérico | XXX.XXX.XXX-XX | |[RI01](#RI)  |
| Nacionalidade | OBR | Seleção única| | Valores válidos: Brasileiro, Estrangeiro. Valor default: Brasileiro | |

- Preenchimento: 
  - **OBR:** Obrigatório
  - **AUT:** Automático
- Tipos: Inteiro, Numérico, Alfanumérico, Data, Hora, Botão, Seleção única, Seleção múltipla, Lista

## **Fluxo Principal**
### FP - < Nome do Fluxo >

| ID | Passo | Fluxo | Regra de Negócio | Tela |
|:--------------|:----------------|:--------------|:----------------|:--------------|
| 1 | |  | | |
| 2 | |  | | |


## **Fluxo Alternativo**

### FA01 - < Nome do Fluxo Alternativo >

| ID | Passo | Fluxo | Regra de Negócio | Tela |
|:--------------|:----------------|:--------------|:----------------|:--------------|
| 1 | |  | | |


## **Fluxo Extensão**
### FE01 - < Nome do Fluxo de Extensão >

| ID | Passo | Fluxo | Regra de Negócio | Tela |
|:--------------|:----------------|:--------------|:----------------|:--------------|
| 1 | |  | | |

## **Fluxo Exceção**
### FEX01 - < Nome do Fluxo de Exceção >

| ID | Passo | Fluxo | Regra de Negócio | Tela |
|:--------------|:----------------|:--------------|:----------------|:--------------|
| 1 | |  | | |

## Regras de Negócio

| ID | Descrição da Regra |
|:-----|:-----|
| **RN01** | O CPF deve ser validado de acordo com as regras estipuladas pela receita federal |

<a name="RI"></a>
## Regras de Interface 

| ID | Descrição da Regra |
|:-----|:-----|
| **RI01** | O campo deverá ficar com a borda vermelha quando for informado um valor inválido ou quando for um campo obrigatório e não estiver preenchido. |
