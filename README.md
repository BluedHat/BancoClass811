# BancoClass811

Projeto final do módulo de banco de dados

tabelas chaves:
TRANSACAO -> que registra as transacoes
USUARIO -> que registra os usuários
CONTA -> que registra as contas

Ordem de correlação: Usuario possui contas que possuem transações.

Exemplos de comunicação com EndPoint:

Cadastrar usuario:

POST: http://localhost:8080/usuario
{
	"cpf": "88344866467",
	"nome": "Maria Antonia", 
	"senha": "8756232887",
	"login": "KTr524"
}

Listar um usuario especifico passando ID na URL
GET  http://localhost:8080/usuario/5486dcc5-a70f-4ba5-8d9f-94a4ba117886

Retorno esperado:
{
	"id": "5486dcc5-a70f-4ba5-8d9f-94a4ba117886",
	"cpf": "451344866467",
	"nome": "Jonathan",
	"dataCriacao": null,
	"dataAtualizacao": null,
	"username": null,
	"password": "546432887"
}

Associar conta a um usuário(cadastrar conta)
http://localhost:8080/conta/create/5486dcc5-a70f-4ba5-8d9f-94a4ba117886

Exemplo de conta:
{
	"tipoConta": "PF",
	"numero":"1254",
	"digitoNumero":"1",
	"agencia":"120",
	"digitoAgencia":"0",
	"depositoInicial":"250"	
}

Listar todas as contas:
http://localhost:8080/conta

Criar transação passando o ID da conta:
http://localhost:8080/transacao/made/d40380e8-ba9b-44c0-aa66-feeb0bd789c7

Exemplo de transação
{
	"valor":"90",
	"tipoTransacao":"credito"
}

Ordenar transações por data -> sem restriçãod e dados:
http://localhost:8080/transacao/conta

Retorno paginado 
http://localhost:8080/transacao/listpage

Extrato geral de transações por tipo (débito ou credito)
http://localhost:8080/transacao/view?tipoTransacao=credito


Observações, 

Quando uma transação é realizada o saldo da conta associada é modificado, sem +valor quando a operação é débito e -valor quando a operação é credito.



