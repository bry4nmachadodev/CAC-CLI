# CAC-CLI 🚀

Conversor de texto para arquivos .txt e .csv via linha de comando - **Especialmente desenvolvido para criar decks do Anki!** 🎴

## 📋 Sobre o Projeto

CAC-CLI é uma aplicação Java para converter texto em arquivos estruturados. Permite criar arquivos de texto simples ou flashcards no formato CSV com frente e verso, **otimizado para importação no Anki**.

## ✨ Funcionalidades

- ✍️ **Conversor TXT**: Crie arquivos de texto linha por linha
- 🎴 **Conversor CSV para Anki**: Crie flashcards estruturados (frente/verso) prontos para importar
- 🎨 **Decks Coloridos com HTML**: Crie flashcards com palavras coloridas para facilitar o aprendizado visual
- 💾 **Salvamento automático**: Arquivos salvos em Desktop/cac-cli/
- 🖥️ **Multiplataforma**: Funciona em Windows, Linux e macOS
- 🤖 **IA generativa (Groq API)**: Gere frases automaticamente ou adicione cores inteligentes aos seus decks

## ⚙️ Configuração da API

Para usar as funcionalidades de IA (geração de frases e colorização), é necessário configurar sua API Key do Groq nas variáveis de ambiente:

**No Linux/macOS:**
```bash
export GROQ_API_KEY="sua_api_key_aqui"
```

**No Windows (cmd):**
```bash
setx GROQ_API_KEY "sua_api_key_aqui"
```

**Como obter sua API Key:**
1. Acesse [console.groq.com](https://console.groq.com)
2. Crie uma conta ou faça login
3. Vá em "API Keys" e gere uma nova chave
4. Configure a variável de ambiente conforme acima

### Como importar no Anki

1. Abra o Anki
2. Clique em **"Arquivo"** → **"Importar"**
3. Selecione o arquivo CSV da pasta Desktop/cac-cli/
4. Configure:
   - **Tipo**: Básico (frente e verso)
   - **Campos separados por**: vírgula (para decks normais) ou ponto e vírgula (para decks coloridos)
   - **Deck**: escolha ou crie um novo
   - **Permitir HTML**: ✅ MARQUE esta opção (essencial para decks coloridos!)
5. Clique em **"Importar"**
6. Pronto! Seus flashcards estão no Anki! ✅

### Formato compatível

**CSV padrão:**
```csv
frente,verso
"O que é Java?","Linguagem de programação orientada a objetos"
"O que é JVM?","Java Virtual Machine"
```

**CSV colorido (com HTML):**
```csv
<span style='color:red'>Как</span> <span style='color:blue'>дела́</span>?;<span style='color:red'>Como</span> <span style='color:blue'>vai</span>?
<span style='color:red'>Спаси́бо</span> <span style='color:blue'>большо́е</span>;<span style='color:red'>Muito</span> <span style='color:blue'>obrigado</span>
```

## 🚀 Como Usar

### Pré-requisitos

- Java 8 ou superior instalado
- Terminal/Prompt de Comando
- (Opcional) [Anki](https://apps.ankiweb.net/) instalado para usar os flashcards
- (Opcional) API Key do Groq para funcionalidades de IA

### Executando o .jar

1. Baixe o arquivo cac-cli.jar da seção [Releases](../../releases)
2. Abra o terminal na pasta onde está o arquivo
3. Execute o comando:
```bash
java -jar cac-cli.jar
```
4. Siga as instruções no menu interativo

### Menu Principal
```
-- Seja bem-vindo [seu-usuario] --
| --------------------------------- |
|  Opção 1 - Converter para .txt    |
|  Opção 2 - Converter para .csv    |
|  Opção 3 - IA - gerar deck        |
|  Opção 4 - Crie seu deck colorido |
|  Opção 5 - Sair                   |
| --------------------------------- |
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

A pasta cac-cli é criada automaticamente na primeira execução.

## 📝 Exemplos de Uso

### 1. Convertendo para TXT

1. Escolha opção **1**
2. Digite seu texto
3. Confirme se deseja adicionar mais linhas
4. Arquivo salvo como `texto-convertido.txt`

### 2. Convertendo para CSV (Anki)

1. Escolha opção **2**
2. Selecione o modo:
   - **Modo Guiado**: Digite frente e verso individualmente
   - **Modo Livre**: Cole tudo separado por ponto e vírgula
3. Digite a **frente** do flashcard (ex: "O que é Python?")
4. Digite o **verso** do flashcard (ex: "Linguagem de programação interpretada")
5. Confirme se deseja adicionar mais frases
6. Arquivo salvo como `deck-convertido.csv`
7. **Importe no Anki** seguindo as instruções acima

**Formato do CSV:**
```csv
frente,verso
"Capital do Brasil","Brasília"
"Maior país do mundo","Rússia"
"Ano da Proclamação da República","1889"
```

### 3. IA gerando deck especialmente pra você

1. Escolha opção **3**
2. Responda as perguntas:
   - Qual idioma? (ex: russo, espanhol, japonês)
   - Qual seu nível? (A0 - C2)
   - Quantas frases? (ex: 20, 50, 100)
3. A IA gera frases automaticamente com tradução
4. Arquivo salvo como `deck-anki_[idioma].csv`

**Exemplo de uso:**
```
Qual será o idioma do deck gerado? russo
Qual seu nível no idioma? (A0 - C2) A2
Quantas frases você quer? 30
```

### 4. 🎨 Crie seu deck colorido (NOVO!)

Esta é a funcionalidade mais avançada! Crie flashcards com **cores que associam palavras aos seus significados**.

1. Escolha opção **4**
2. Digite suas frases normalmente (frente e verso)
3. A IA adiciona cores HTML automaticamente
4. Palavras relacionadas ganham a **mesma cor** (facilitando memorização!)
5. Arquivo salvo como `deck-colorido.csv`

**Como funciona:**
- A IA identifica palavras-chave e seus significados
- Aplica a mesma cor para palavra estrangeira e tradução
- Você memoriza por associação visual de cores!

**Exemplo visual no Anki:**
- Frente: <span style='color:red'>Как</span> <span style='color:blue'>дела́</span>?
- Verso: <span style='color:red'>Como</span> <span style='color:blue'>vai</span>?

⚠️ **IMPORTANTE**: Ao importar no Anki, marque a opção **"Permitir HTML"** nas configurações de importação!

## 🛠️ Tecnologias

- Java 8+
- OpenCSV (para manipulação de arquivos CSV)
- OkHttp (para requisições HTTP)
- Gson (para processamento JSON)
- Groq API (modelo llama-3.3-70b-versatile)
- Maven (gerenciamento de dependências)

## 🤝 Contribuindo

Contribuições são bem-vindas! Se você tem ideias de melhorias ou encontrou algum bug:

1. Abra uma [Issue](../../issues/new) descrevendo:
   - 🐛 Bugs encontrados
   - 💡 Sugestões de features (ex: novos formatos de exportação)
   - 📖 Melhorias na documentação
   - 🎴 Sugestões para melhor integração com Anki
   - 🎨 Ideias para melhorar a colorização de decks

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
