# Caso de Uso: < nome do caso de uso >


| <div style="width:290px">Versão</div> | Atividade | Autor | Data |
|:------------|:----------------|:--------------|:----------------|
| 1.0 | Versão Inicial do Arquivo | Murilo Lopes da Luz  | 07/12/2021 |
| 1.1 | Atualização do formato da descrição de telas e tags HTML | Matheus de Azevedo | 10/07/2024 |

## **Descrição**
Não se aplica.

## **Ator(es)**
Não se aplica.

## **Caminho para Acesso à Funcionalidade**
Não se aplica.

## **Pré-condições**
Não se aplica.

## **Descrição da(s) Tela(s)**

<a name="tela1"></a>

**Tela 1**
| Nome do Atributo | Preenchimento | Tipo | Máscara | Observações | Regra de Interface |
|:-----------------|:-------------:|:-----|:--------|:------------|:-------------------|
| Cancelar | | Botão | | | |
| CPF | OBR | Alfanumérico | XXX.XXX.XXX-XX | |[RI01](#RI)  |
| Nacionalidade | OBR,AUT | Seleção única | | Valores válidos: Brasileiro, Estrangeiro. Valor padrão: Brasileiro | |

- Preenchimento: 
  - **OBR:** Obrigatório
  - **AUT:** Automático
- Tipos: Inteiro, Numérico, Alfanumérico, Data, Hora, Botão, Seleção única, Seleção múltipla, Lista

<a name="FP"></a>

## **Fluxo Principal**
### FP - < Nome do Fluxo >

| ID | Passo | Fluxo | Regra de Negócio | Tela |
|:--------------|:----------------|:--------------|:----------------|:--------------|
| 1 | |  | | |
| 2 | |  | | |

<a name="FA"></a>

## **Fluxo Alternativo**

<a name="FA01"></a>

### FA01 - < Nome do Fluxo Alternativo >

| ID | Passo | Fluxo | Regra de Negócio | Tela |
|:--------------|:----------------|:--------------|:----------------|:--------------|
| 1 | |  | | |

<a name="FE"></a>

## **Fluxo Extensão**

<a name="FE01"></a>

### FE01 - < Nome do Fluxo de Extensão >

| ID | Passo | Fluxo | Regra de Negócio | Tela |
|:--------------|:----------------|:--------------|:----------------|:--------------|
| 1 | |  | | |

<a name="FEX"></a>

## **Fluxo Exceção**

<a name="FEX01"></a>

### FEX01 - < Nome do Fluxo de Exceção >

| ID | Passo | Fluxo | Regra de Negócio | Tela |
|:--------------|:----------------|:--------------|:----------------|:--------------|
| 1 | |  | | |

<a name="RN"></a>

## Regras de Negócio

| ID | Descrição da Regra |
|:-----|:-----|
| **RN01** | O CPF deve ser validado de acordo com as regras estipuladas pela receita federal |

<a name="RI"></a>

## Regras de Interface 

| ID | Descrição da Regra |
|:-----|:-----|
| **RI01** | O campo deverá ficar com a borda vermelha quando for informado um valor inválido ou quando for um campo obrigatório e não estiver preenchido. |
