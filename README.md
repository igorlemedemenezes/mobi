# assembly-voting

# assembly-voting

API REST para votação em assembleia

Este projeto é um desafio técnico, descrição:

No cooperativismo, cada associado possui um voto e as decisões são tomadas em assembleias,
por votação. Imagine que você deve criar uma solução backend para gerenciar essas sessões de
votação.

Essa solução deve ser executada na nuvem e promover as seguintes funcionalidades através de
uma API REST:

- Cadastrar uma nova pauta
- Abrir uma sessão de votação em uma pauta (a sessão de votação deve ficar aberta por um tempo determinado na chamada de abertura ou 1 minuto por default)
- Receber votos dos associados em pautas (os votos são apenas 'Sim'/'Não'. Cada associado é identificado por um id único e pode votar apenas uma vez por pauta)
- Contabilizar os votos e dar o resultado da votação na pauta

Tarefa Bônus 1 - Integração com sistemas externos

    Integrar com um sistema que verifique, a partir do CPF do associado, se ele pode votar
    GET https://user-info.herokuapp.com/users/{cpf}
    Caso o CPF seja inválido, a API retornará o HTTP Status 404 (Not found). Você pode usar geradores de CPF para gerar CPFs válidos;
    Caso o CPF seja válido, a API retornará se o usuário pode (ABLE_TO_VOTE) ou não pode (UNABLE_TO_VOTE) executar a operação Exemplos de retorno do serviço
    
    R- Foi implementado o service chamado ExternalCommunicationService para fazer comunicação externa com outras API, neste caso o end-point de CPF.  

Tarefa Bônus 2 - Performance
	⦁	Imagine que sua aplicação possa ser usada em cenários que existam centenas de milhares de votos. Ela deve se comportar de maneira performática nesses cenários
	⦁	Testes de performance são uma boa maneira de garantir e observar como sua aplicação se comporta


Tarefa Bônus 4 - Versionamento da API

    Como você versionaria a API da sua aplicação? Que estratégia usar?
	
	R- Versionamento direto na rota, pois fica claro para o cliente o versionamento da API.
	
## Ferramentas utilizada

### Java 8
### Spring
### Maven
### Hibernate
### JPA
### Swagger
### JUnit
### Mockito