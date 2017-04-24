Feature: Envio de E-mail

Scenario: Garantir que seja possível enviar e-mail para o usuário logado
Given O usuário esteja logado em sua conta de e-mail no site "https://www.bol.uol.com.br/"
When O usuário clica em "Escrever"
And Preenche o endereço com : "mviniciusfantinato@bol.com.br"
And Preenche o assunto com : "Teste de Envio"
And Clica em "Enviar"
Then O e-mail é enviado com sucesso e um Novo E-mail é recebido.