# Plano de Teste - Programa TC Educa - Gestão

## 1 - Introdução

Este documento descreve os requisitos a serem testados, os tipos de testes definidos para cada iteração, os recursos de hardware e software a serem empregados e o cronograma dos testes ao longo do projeto. As seções referentes aos requisitos, recursos e cronograma têm a finalidade de permitir o acompanhamento da evolução dos testes.

O programa alvo desse arquivo é o sistema de gestão do TC Educa, abrangendo 
tanto o front-end e backend. Os testes foram elaborados com base na 
[documentação de requisitos do gestão](https://docs.google.com/document/d/1SacKnCN70OkxFLJ_6ohV_kMXuWfXN23u-Yh4Qm1QB-c/edit?usp=share_link). 

## 2 - Requisitos a Testar

Nesta seção estão contidos os requisitos que serão alvo dos testes a serem realizados.

### 2.1 - Requisitos de Usuário:
|  Identificador  |                                                     Nome                                                      |
|:---------------:|:-------------------------------------------------------------------------------------------------------------:|
|       HU1       |                      Pessoas autorizadas tenham acesso às funções da aplicação de gestão                      |
|       HU2       |                              Administrador cadastrar os administradores de um TC                              |
|       HU3       |                           Administrador cadastrar outros administradores do sistema                           |
|       HU4       |              Administrador visualizar as informações a respeito do acesso à aplicação de gestão               |
|       HU5       |     Usuário ter acesso de onde os usuários estão requisitando informações sobre o PNE no Painel TC Educa      |
|       HU6       |                        Administrador de um TC cadastrar os suplentes do respectivo TC                         |
|       HU7       |       Administrador de um TC/suplente cadastrar os contatos dos auditados do próprio município /estado        |
|       HU8       |  Administrador de um TC/suplente selecionar filtros para gerar relatórios de acompanhamento das metas do PNE  |
|       HU9       |                      Administrador de um TC/suplente fazer download do relatório gerado                       |
|      HU10       |                    Administrador de um TC/suplente enviar, por e-mail, o relatório gerado                     |
|      HU11       |     Portador de um relatório de acompanhamento verificar se o relatório foi emitido pelo Sistema TC EDUCA     |

### 2.2 - Regras de Negócio:
| Identificador |                                                                Nome                                                                 |
|:-------------:|:-----------------------------------------------------------------------------------------------------------------------------------:|
|      RN1      |                                   Administrador de um TC pode cadastrar apenas usuários suplentes                                   |
|      RN2      |                                            Suplentes não podem cadastrar outros usuários                                            |
|      RN3      |                                          Somente existirá dois administradores por cada TC                                          |
|      RN4      |            O Administrador de um TC/suplente terá acesso somente aos dados que pertencem ao escopo do seu respectivo TC             |
|      RN5      |                                    O relatório terá template fixo e será igual para todos os TCs                                    |
|      RN6      |                                         O documento de relatório será gerado no formato PDF                                         |
|      RN7      | Para cada município/estado serão cadastrados até 3 contatos para envio dos relatórios de acompanhamento. Um para cada tipo de cargo |

### 2.3 - Requisitos de Software:
| Identificador |                                                                  Nome                                                                  |
|:-------------:|:--------------------------------------------------------------------------------------------------------------------------------------:|
|      RS1      |                                 O sistema deve identificar o Tribunal associado ao usuário autenticado                                 |
|      RS2      |                                            O sistema deve identificar o usuário autenticado                                            |
|      RS3      |                                            O sistema deve autenticar os usuários via gov.br                                            |
|      RS4      | O sistema deve possuir um mecanismo de verificação para identificar se um determinado relatório foi gerado pelo próprio sistema ou não |


## 3 - Tipos de Testes

### 3.1 Integração
- Objetivo: Verificar a correta interação entre os diferentes componentes do sistema, garantindo que eles funcionem de maneira harmoniosa e integrada. Esses testes visam identificar possíveis falhas ou problemas na comunicação e na integração entre os módulos, subsistemas ou serviços, assegurando que o sistema funcione adequadamente como um todo. 
- Técnica: Testes funcionais, que consistem em testes automatizados dos endpoints.
- Ferramenta: O [SpringBootTest](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/test/context/SpringBootTest.html) será usado para testar requisições aos endpoints do backend. 
- Cobertura: Todos endpoints do back-end e seus valores limites conforme descrito nas histórias de usuário.
- Critério de aceitação: 100% dos testes feitos e aprovados

### 3.2 Usabilidade
- Objetivo: Avaliar a facilidade de uso, eficiência e satisfação do usuário ao interagir com um produto, sistema ou interface. Esses testes visam identificar problemas de usabilidade, como dificuldades de navegação, compreensão das funcionalidades, fluxos confusos ou lentos, entre outros. O objetivo final é garantir que o produto seja intuitivo, amigável e proporcione uma experiência positiva ao usuário, atendendo às suas necessidades e expectativas. 
- Técnica: 10 Heurísticas de Nielsen, um conjunto de princípios de usabilidade criados por Jakob Nielsen, um renomado especialista em experiência do usuário.
- Cobertura: Percorrer todas telas e realizar todas ações possíveis.
- Critério de aceitação: No mínimo 80% das heurísticas, sendo consideradas como satisfatoriamente aplicadas.

### 3.3 Sistema
- Objetivo: Verificar se todas as funcionalidades e recursos do front-end estão implementados corretamente e funcionam conforme o esperado.
- Técnica:  Teste funcional automatizado do frontend, que realiza a execução de ações predeterminadas para validar se os fluxos de trabalho e funcionalidades estão operando corretamente no frontend.
- Ferramenta: O [Cypress](https://www.cypress.io/) será usado como uma ferramenta para testar a navegação pelas telas 
do front-end e validação dos conteúdos esperados.
- Cobertura: Abranger todas ações possíveis da tela e validar os valores limites das mesmas das histórias de usuário.
- Critério de aceitação: 100% dos testes criados e aprovados.


## 4 - Ambiente de teste - Software e Hardware

Inicialmente, o ambiente de software será composto pelos ambientes locais dos membros da equipe de teste. A configuração foi feita a partir de documentação previamente disponibilizada:
* [back-end](https://github.com/FabricaDeSoftwareINF/tceduca/blob/dev/gestao/backend/README.md)
* [front-end](https://github.com/FabricaDeSoftwareINF/tceduca/blob/dev/gestao/frontend/README.md)
* [cypress](https://github.com/FabricaDeSoftwareINF/tceduca-testes-aceitacao/blob/dev/README.md)


## 5  - Processo de Teste

Os testes serão conduzidos por meio de iterações, durante as quais serão produzidos relatórios para a equipe de desenvolvimento, contendo os erros identificados. Esse processo envolve as seguintes atividades:

1. Elaboração dos casos de teste:
* Identificar os casos de teste com base no escopo de teste, ações possíveis e valores limites, conforme documentado nos requisitos.
* Registrar os casos de teste em um documento separado por tipo de teste e funcionalidade.

2. Construção/Realização dos casos de teste:
* Com base nos casos de teste elaborados, construir os testes automatizados ou realizar os testes manuais.
* Executar os testes de acordo com as ferramentas e técnicas definidas no documento.

3. Elaboração do relatório:
* O relatório é elaborado seguindo o modelo específico para o tipo de teste, utilizando os resultados da execução.
* O modelo de relatório pode ser encontrado em "documentacao/gestao/templates/".
* O relatório será um documento MarkDown localizado em "documentacao/gestao/tipo de teste", em que "tipo de teste" refere-se ao tipo de teste realizado.
* O nome do relatório deve seguir a convenção relatorio-tipodeteste-hu, em que "hu" representa a história de usuário testada.

4. Entrega do relatório para a equipe de desenvolvimento:
* O relatório finalizado é entregue por meio do canal de comunicação oficial da Fábrica de Software.

## 6 - Considerações finais

### 6.1 - Testes rejeitados

Foi analisada a viabilidade inicial de realizar testes de performance e de
regressão. Os motivos que demarcam essa escolha foram:
* Os testes de performance são testes que visam identificar como o sistema 
responde a altas demandas e qual o tempo de resposta para suas atividades. 
Optamos por não focar na criação de tais testes no começo do processo de 
testagem, devido ao projeto ser focado para um baixo número de usuários 
concorrentes, de forma que apesar de ser um teste válido não é um teste essencial.
* Os testes de regressão foram desconsiderados devido a justaposição que teria entre os testes de prontidão, já que ambos representam, de forma simplificada, um relatório de testes para cada versionamento do software.
* Os testes de prontidão foram desconsiderados visto que são equivalentes ao teste de aceitação operacional de software e aborda aspectos já abordados pelos templates de teste que realizaremos.
