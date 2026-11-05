# 🖨️ Sistema de Controle de Impressora Elgin
### *(Controle de impressora com Java)*
---

## 📘 Sobre o Projeto


Este projeto foi desenvolvido pelo nosso grupo para se comunicar com uma impressora térmica **Elgin i8/i9** usando a biblioteca `E1_Impressora01.dll`. O sistema tem login com 3 tentativas, que é executado dentro de uma classe Usuario, e um menu com operações de impressão dentro de uma classe Impressora, que também possuí todos os métodos de cada opção. Faz parte da disciplina de **Programação Orientada a Objetos**.

---

## 🧰 Tecnologias Utilizadas

- **Java** *(Versão 27)*
- **IntelliJ IDEA** 
- **JNA 5.15.0** (comunicação com a DLL)
- **DLL E1_Impressora01** (SDK da Elgin)
- **Impressora Elgin i8 ou i9** *(i9 utilizada para testes)*

---

## 📁 Estrutura do Projeto

*(Liste suas pastas e classes e diga o que cada uma faz.)*

```
/src                      → Código-fonte com todas as classes dentro dele. 
   Main.java              → Classe principal, responsável por rodar o progarma e criar os objetos.
   Usuario.java           → Classe responsável pelo login com 3 tentativas.
   Impressora.java        → Classe responsável por mostrar o menu e executar cada opção dele.
/Bibliotecas E1 Impressora → DLLs da Elgin (x64 e x86)
/libs Java                → jna-5.15.0.jar (Versão do JNA utilizada)
```

---

## ⚙️ Instalação e Execução



### 1. Baixar o projeto
1. Acesse o repositório no GitHub.
2. Clique em **Code → Download ZIP**.
3. Extraia o arquivo.

### 2. Abrir no IntelliJ IDEA
1. **File → Open** e escolha a pasta extraída.
2. Em **File → Project Structure → Libraries**, confirme que o `jna-5.15.0.jar` está adicionado.
3. Conecte e ligue a impressora.
4. Abra `Main.java` e clique em ▶️ **Run**.
5. Faça o Login digitando o usuário e senha corretos, você terá 3 tentativas.
6. Escolha uma opção do menu apresentado, mas primeiro abra a conexão, caso contrário uma mensagem pedindo para abrir a conexão será enviada.

---

## 🔐 Login

*Usuário de teste: GrupoVictor; Senha de teste: 12345; 3 tentativas de acerto.*

---

## 📋 Funcionalidades do Menu

| Opção | O que faz |
|---|---|
| 1 | *(Configura a conexão com a impressora)* |
| 2 | *(Abre a conexão com a impressora)* |
| 3 | *(Fecha a conexão com a impressora)* |
| 4 | *(Imprime um texto)* |
| 5 | *(Imprime um QR code)* |
| 6 | *(Imprime um código de barras)* |
| 7 | *(Imprime XML SAT)* |
| 8 | *(Imprime XML de cancelamento SAT)* |
| 9 | *(Abre a gaveta da impressora)* |
| 10 | *(Emite sinal sonoro)* |
| EXTRA | *(Avança o papel e mostra o Status da impressora)* |
| 0 | *(Opção de sair do programa)* |
---

## 🧪 Testes Realizados

*(Liste o que você testou e o resultado. Ex.: login com senha errada 3 vezes, impressão de texto, QR Code, código de barras, bip, gaveta.)*

---

## 📚 Documentação Adicional

- Manual da impressora Elgin
- Documentação do SDK E1_Impressora

---

## 👥 Autores
*(em ordem alfabética)*

- Gabriel Brito
- Luiz Gustavo
- Victor Raphael Frana
