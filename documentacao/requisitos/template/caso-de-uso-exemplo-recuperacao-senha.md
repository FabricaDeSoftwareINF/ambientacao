# Caso de Uso: Recuperação de Senha 

| <div style="width:290px">Versão</div> | Atividade | Autor | Data |
|:------------|:----------------|:--------------|:----------------|
| 1.0 | Versão Inicial do Arquivo | Carlos Henrique R. de Jesus | 27/10/2023 |
| 1.1 | Atualização do formato de descrição de telas e tags HTML | Matheus de Azevedo | 10/07/2024 |

## **Descrição**
Esta funcionalidade permite que usuário recupere a sua senha esquecida. O usuário deve fornecer seu e-mail ou seu CPF, para a recuperação.

## **Ator(es)**
Cliente.

## **Caminho para Acesso à Funcionalidade**
Tela inicial > Recuperação de Senha

## **Pré-condições**
Não se aplica.

## **Descrição da(s) Tela(s)**

<a name="tela1"></a>

**Tela 1** - `Esqueceu sua senha?`

![image](https://github.com/FabricaDeSoftwareINF/ipelab/assets/106249672/1f37234e-5f62-4f43-880a-fd6d86fe3482)

| Nome do Atributo | Preenchimento | Tipo | Máscara | Observações | Regra de Interface |
|:-----------------|:-------------:|:-----|:--------|:------------|:-------------------|
| E-mail ou CPF | OBR | Alfanumérico | | | [RI01](#RI) |
| Continuar | | Botão | | | |

<a name="tela2"></a>

**Tela 2** - `Mensagem de aviso`

![image](https://github.com/FabricaDeSoftwareINF/ipelab/assets/106249672/a547c1f9-40f9-4cf6-9362-36c475b376dd)

<a name="tela3"></a>

**Tela 3** - `Nova senha`

![image](https://github.com/FabricaDeSoftwareINF/ipelab/assets/106249672/f451466d-34d6-43e4-bad1-ffdc52bed7eb)

| Nome do Atributo | Preenchimento | Tipo | Máscara | Observações | Regra de Interface |
|:-----------------|:-------------:|:-----|:--------|:------------|:-------------------|
| Nova senha | OBR | Alfanumérico | | | [RI01](#RI), [RI03](#RI)  |
| Confirmar senha | OBR | Alfanumérico | | | [RI01](#RI), [RI03](#RI) |

<a name="tela4"></a>

**Tela 4** - `Login - Senha alterada`

![image](https://github.com/FabricaDeSoftwareINF/ipelab/assets/106249672/9503c84a-510c-454e-8667-f1abe1a27e51)

| Nome do Atributo | Preenchimento | Tipo | Máscara | Observações | Regra de Interface |
|:-----------------|:-------------:|:-----|:--------|:------------|:-------------------|
| Mensagem de sucesso | | Pop-Up | | | [RI02](#RI) |

<a name="tela5"></a>

**Tela 5** - `Nova senha - Senhas não coincidem`

![image](https://github.com/FabricaDeSoftwareINF/ipelab/assets/8249709/481e2ad5-ea97-4b8e-b087-999a033cd00e)

<a name="tela6"></a>

**Tela 6** - `Esqueceu sua senha? - Dados Invalidos`

![image](https://github.com/FabricaDeSoftwareINF/ipelab/assets/8249709/da026451-08cf-4333-bd09-1388ca6fb393)

| Nome do Atributo | Preenchimento | Tipo | Máscara | Observações | Regra de Interface |
|:-----------------|:-------------:|:-----|:--------|:------------|:-------------------|
| Mensagem de erro | | Pop-Up | | | [RI02](#RI) |

<a name="FP"></a>

## **Fluxo Principal**
### FP - Esqueceu a senha?

| ID | Passo | Fluxo | Regra de Negócio | Tela |
|:--------------|:----------------|:--------------|:----------------|:--------------|
| 1 | O sistema pede ao usuário para inserir o e-mail ou CPF o associado à conta |  | [RN01](#RN), [RN02](#RN) | [1](#tela1) |
| 2 | O usuário pressiona o botão continuar | [FEX01](#FC), [FEX02](#FC)  | | [1](#tela1) |
| 4 | O sistema mostra uma janela com a mensagem "instruções enviadadas por e-mail" |  | [RN03](#RN) | [2](#tela2) |
| 5 | O sistema envia um e-mail com um link de redefinição de senha para o e-mail do usuário | | [RN03](#RN) | |
| 6 | O Usuário clica no link e é direcionado para criar uma nova senha |  | | [3](#tela3) |
| 7 | Usuário insere a nova senha e pressiona o botão alterar | [FEX02](#FC), [FEX03](#FC), [FEX04](#FC)   | [RN04](#RN) | [3](#tela3) |
| 8 | O sitema exibe um pop-up com a mensagem "Senha alterada com sucesso!" |  | | [4](#tela4) |

<a name="FA"></a>

## **Fluxo Alternativo:**
Não se aplica.

<a name="FE"></a>

## **Fluxo Extensão:**
Não se aplica.

<a name="FEX"></a>

## **Fluxo Exceção**

<a name="FEX01"></a>

### FEX01 - Credenciais invalidas

| ID | Passo | Fluxo | Regra de Negócio | Tela |
|:--------------|:----------------|:--------------|:----------------|:--------------|
| 1 | O sistema identifica campo(s) preenchido(s) com dado(s) incorreto(s) |  | | [1](#tela1)|
| 2 | O sistema exibe a mensagem "E-mail ou CPF incorretos!" em um pop-up. |  | | [6](#tela6) |

<a name="FEX02"></a>

### FEX02 - Campo obrigatorio não informado

| ID | Passo | Fluxo | Regra de Negócio | Tela |
|:--------------|:----------------|:--------------|:----------------|:--------------|
| 1 | O sistema identifica que campos obrigatórios não foram preenchidos |  | | [1](#tela1), [3](#tela3) |
| 2 | O sistema exibe a mensagem "Campo obrigatório não informado" abaixo do(s) campo(s) não preenchido(s) |  |  | |

<a name="FEX03"></a>

### FEX03 - Senhas não coincidem

| ID | Passo | Fluxo | Regra de Negócio | Tela |
|:--------------|:----------------|:--------------|:----------------|:--------------|
| 1 | O sistema verifica que o conteúdo do campo "Confirmar Senha" não corresponde exatamente ao informado no campo "Senha".|  | | [3](#tela3) |
| 2 | O sistema exibe a mensagem "As senhas não coincidem" abaixo do campo "Confirmar senha" |  | | [5](#tela5) |

<a name="FEX04"></a>

### FEX04 - Senha inválida

| ID | Passo | Fluxo | Regra de Negócio | Tela |
|:--------------|:----------------|:--------------|:----------------|:--------------|
| 1 | O sistema identifica que a senha informada não atende os critérios definidos|  | [RN04](#RN) | [3](#tela3)|
| 2 | O sistema exibe a mensagem "A senha deve ter, no mínimo, 6 caracteres, incluir números e letras maiúsculas e minúsculas" abaixo do campo "Senha" |  | |  |

<a name="RN"></a>

## Regras de Negócio

| ID | Descrição da Regra |
|:-----|:-----|
| **RN01** | O CPF deve ser validado de acordo com as regras estipuladas pela receita federal, tendo cadastro na plataforma. |
| **RN02** | O email informado deve ser válido seguindo o formato 'usuario'@'dominio'. O domínio deve permitir múltiplos subdomínios, tendo cadastro na plataforma. |
| **RN03** |  O e-mail para recuperação de senha deve conter a seguinte redação: <br><br> Caro usuário, <br> <br> Percebemos que você solicitou a recuperação de sua senha. <br><br> Para redefinir sua senha, clique no link abaixo e siga as instruções na página: <br><br> [Link de Recuperação de Senha] <br><br> Se você não solicitou a recuperação de senha, por favor, ignore este e-mail. <br><br> Agradecemos a sua compreensão e estamos à disposição para qualquer esclarecimento adicional. <br>Atenciosamente, Equipe de Suporte do IPeLab. <br> <h6>Este é  um e-mail gerado automaticamente e não é necessário respondê-lo.</h6>|
| **RN04** | A senha deve ter, no mínimo, 6 caracteres, incluir números e letras maiúsculas e minúsculas. |

<a name="RI"></a>

## Regras de Interface 

| ID | Descrição da Regra |
|:-----|:-----|
| **RI01** | O campo deverá ficar com a borda vermelha quando for informado um valor inválido ou quando for um campo obrigatório e não estiver preenchido. |
| **RI02** | A pop-up deve ser exibida na tela por no máximo 10 segundos e o usuário deve possuir a opção de fechá-la manualmente. |
| **RI03** | Se as senhas inseridas nos campos ‘Senha’ e ‘Confirmação de Senha’ não forem iguais, os respectivos campos deverão ficar com a borda vermelha. |

