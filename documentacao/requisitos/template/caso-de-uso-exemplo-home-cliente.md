# Caso de Uso: Home Cliente 
<a name="CC"></a>

| <div style="width:290px">Versão</div> | Atividade | Autor | Data |
|:------------|:----------------|:--------------|:----------------|
| 1.0 | Versão Inicial do Arquivo | Carlos Henrique R. de Jesus | 06/12/2023 |
| 1.1 | Alterando os fluxos | Carlos Henrique R. de Jesus | 26/02/2024 |

## **Descrição**
Esta funcionalidade permite o acesso do cliente a tela home do cliente, possibilitando o acesso as funcionalidades como, criação de novas demandas, minhas demandas e vitrine de talentos.

## **Ator(es)**
Cliente.

## **Caminho para Acesso à Funcionalidade**
Tela inicial > Login

## **Pré-condições**
O usuário tem que ser um cliente.

## **Descrição da(s) Tela(s)**

<a name="tela1"></a>**Tela 1** - `Tela Home do Cliente`

![image](https://github.com/FabricaDeSoftwareINF/ipelab/assets/106249672/388e040e-8566-48fc-b463-905777531ea5)

| Nome do Atributo | Preench. Obrigatório | Preench. Automático | Tipo | Máscara | Observações | Regra de Interface |
|:--------------|:----------------:|:--------------:|:--------------|:----------------|:--------------|:----------------|
| Nova demanda | | | Botão | | | |
| Minhas demandas | | | Botão | | | |
| Vitrine de Talentos | | | Botão | | | |

<a name="FP"></a>

## **Fluxo Principal**
### FP - Nova demanda

| ID | Passo | Fluxo | Regra de Negócio | Tela |
|:--------------|:----------------|:--------------|:----------------|:--------------|
| 1 | Usuário clica em "Nova demanda" | | | [1](#tela1) |
| 2 | O sistema executa o caso de uso Nova demanda | | | [1](#tela1) |

<a name="FA"></a>

## **Fluxo Alternativo**

### FA01 - Minhas demandas

| ID | Passo | Fluxo | Regra de Negócio | Tela |
|:--------------|:----------------|:--------------|:----------------|:--------------|
| 1 | Usuário clica em "Minhas demandas" | | | [1](#tela1) |
| 2 | O sistema executa o caso de uso Minhas demandas | | | [1](#tela1) |

### FA02 - Vitrine de Talentos

| ID | Passo | Fluxo | Regra de Negócio | Tela |
|:--------------|:----------------|:--------------|:----------------|:--------------|
| 1 | Usuário clica em "Vitrine de Talentos" | | | [1](#tela1) |
| 2 | O sistema executa o caso de uso Vitrine de Talentos | | | [1](#tela1) |


<a name="FE"></a>

## **Fluxo Extensão**

Não se aplica.

<a name="FC"></a>

## **Fluxo Exceção**

Não se aplica.

<a name="RN"></a>

## Regras de Negócio

Não se aplica.

<a name="RI"></a>

## Regras de Interface 

Não se aplica.
