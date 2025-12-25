# CAC-CLI 🚀

Conversor de texto para arquivos `.txt` e `.csv` via linha de comando.

## 📋 Sobre o Projeto

CAC-CLI é uma aplicação Java para converter texto em arquivos estruturados. Permite criar arquivos de texto simples ou flashcards no formato CSV com frente e verso.

## ✨ Funcionalidades

- ✍️ **Conversor TXT**: Crie arquivos de texto linha por linha
- 🎴 **Conversor CSV**: Crie flashcards estruturados (frente/verso)
- 💾 **Salvamento automático**: Arquivos salvos em `Desktop/cac-cli/`
- 🖥️ **Multiplataforma**: Funciona em Windows, Linux e macOS

## 🚀 Como Usar

### Pré-requisitos

- Java 8 ou superior instalado
- Terminal/Prompt de Comando

### Executando o .jar

1. Baixe o arquivo `cac-cli.jar` da seção [Releases](../../releases)

2. Abra o terminal na pasta onde está o arquivo

3. Execute o comando:
```bash
java -jar cac-cli.jar
```

4. Siga as instruções no menu interativo

### Menu Principal
```
-- Seja bem vindo [seu-usuario] --
| ----------------------------- |
| Opção 1 - Converter para .txt |
| Opção 2 - Converter para .csv |
| Opção 3 - Sair                |
| ----------------------------- |
```

## 📂 Onde os arquivos são salvos?

Os arquivos convertidos são salvos automaticamente em:

**Windows:**
```
C:\Users\[seu-usuario]\Desktop\cac-cli\
```

**Linux/macOS:**
```
/home/[seu-usuario]/Desktop/cac-cli/
```

A pasta `cac-cli` é criada automaticamente na primeira execução.

## 📝 Exemplos de Uso

### Convertendo para TXT
1. Escolha opção `1`
2. Digite seu texto
3. Confirme se deseja adicionar mais linhas
4. Arquivo salvo como `texto-convertido.txt`

### Convertendo para CSV
1. Escolha opção `2`
2. Digite a **frente** do flashcard
3. Digite o **verso** do flashcard
4. Confirme se deseja adicionar mais frases
5. Arquivo salvo como `deck-convertido.csv`

**Formato do CSV:**
```csv
frente,verso
"Olá","Hello"
"Obrigado","Thank you"
```

## 🛠️ Tecnologias

- Java 8+
- OpenCSV (para manipulação de arquivos CSV)
- Maven (gerenciamento de dependências)

## 🤝 Contribuindo

Contribuições são bem-vindas! Se você tem ideias de melhorias ou encontrou algum bug:

1. Abra uma [Issue](../../issues/new) descrevendo:
   - 🐛 Bugs encontrados
   - 💡 Sugestões de features
   - 📖 Melhorias na documentação

2. Ou faça um Pull Request:
   - Fork o projeto
   - Crie uma branch (`git checkout -b feature/MinhaFeature`)
   - Commit suas mudanças (`git commit -m 'Adiciona nova feature'`)
   - Push para a branch (`git push origin feature/MinhaFeature`)
   - Abra um Pull Request

## 📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

## 👤 Autor

**Bryan**

---

⭐ Se este projeto foi útil para você, considere dar uma estrela!

💬 Dúvidas? Abra uma [Issue](../../issues)!
