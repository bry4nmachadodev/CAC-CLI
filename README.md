# CAC-CLI 🚀

Conversor de texto para arquivos `.txt` e `.csv` via linha de comando - **Especialmente desenvolvido para criar decks do Anki!** 🎴

## 📋 Sobre o Projeto

CAC-CLI é uma aplicação Java para converter texto em arquivos estruturados. Permite criar arquivos de texto simples ou flashcards no formato CSV com frente e verso, **otimizado para importação no Anki**.

## ✨ Funcionalidades

- ✍️ **Conversor TXT**: Crie arquivos de texto linha por linha
- 🎴 **Conversor CSV para Anki**: Crie flashcards estruturados (frente/verso) prontos para importar
- 💾 **Salvamento automático**: Arquivos salvos em `Desktop/cac-cli/`
- 🖥️ **Multiplataforma**: Funciona em Windows, Linux e macOS
- 🤖 **IA generativa (opcional):** Gere frases automaticamente usando a API Groq.  

## ⚙️ Configuração da API

Para usar a funcionalidade de geração de frases via IA, é necessário configurar sua API Key nas variáveis de ambiente:

**No Linux/macOS:**
```bash
export GROQ_API_KEY="sua_api_key_aqui"
```
**No Windows (cmd):**
```bash
setx GROQ_API_KEY "sua_api_key_aqui"
```

### Como importar no Anki

1. Abra o Anki
2. Clique em **"Arquivo"** → **"Importar"**
3. Selecione o arquivo `deck-convertido.csv` da pasta `Desktop/cac-cli/`
4. Configure:
   - **Tipo**: Básico (frente e verso)
   - **Campos separados por**: vírgula
   - **Deck**: escolha ou crie um novo
5. Clique em **"Importar"**
6. Pronto! Seus flashcards estão no Anki! ✅

### Formato compatível

O CSV gerado segue o formato padrão do Anki:
```csv
frente,verso
"O que é Java?","Linguagem de programação orientada a objetos"
"O que é JVM?","Java Virtual Machine"
```

## 🚀 Como Usar

### Pré-requisitos

- Java 8 ou superior instalado
- Terminal/Prompt de Comando
- (Opcional) [Anki](https://apps.ankiweb.net/) instalado para usar os flashcards

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
-- Seja bem-vindo [seu-usuario] --
| ----------------------------- |
| 1 - Converter para .txt        |
| 2 - Converter para .csv        |
| 3 - Gerar deck via IA          |
| 4 - Sair                       |
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
/home/[seu-usuario]\Desktop\cac-cli\
```

A pasta `cac-cli` é criada automaticamente na primeira execução.

## 📝 Exemplos de Uso

### Convertendo para TXT
1. Escolha opção `1`
2. Digite seu texto
3. Confirme se deseja adicionar mais linhas
4. Arquivo salvo como `texto-convertido.txt`

### Convertendo para CSV (Anki)
1. Escolha opção `2`
2. Digite a **frente** do flashcard (ex: "O que é Python?")
3. Digite o **verso** do flashcard (ex: "Linguagem de programação interpretada")
4. Confirme se deseja adicionar mais frases
5. Arquivo salvo como `deck-convertido.csv`
6. **Importe no Anki** seguindo as instruções acima

**Formato do CSV:**
```csv
frente,verso
"Capital do Brasil","Brasília"
"Maior país do mundo","Rússia"
"Ano da Proclamação da República","1889"
```
### IA gerando deck especialmente pra você
1: Escolha opção 3
2: Responda as perguntas solicitadas
3: Arquivo salvo no seu Desktop/

## 🛠️ Tecnologias

- Java 8+
- OpenCSV (para manipulação de arquivos CSV)
- Maven (gerenciamento de dependências)

## 🤝 Contribuindo

Contribuições são bem-vindas! Se você tem ideias de melhorias ou encontrou algum bug:

1. Abra uma [Issue](../../issues/new) descrevendo:
   - 🐛 Bugs encontrados
   - 💡 Sugestões de features (ex: novos formatos de exportação)
   - 📖 Melhorias na documentação
   - 🎴 Sugestões para melhor integração com Anki

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

🎴 Bons estudos no Anki!
