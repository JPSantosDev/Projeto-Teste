# Catálogo Aprender+

Aplicativo Android desenvolvido em Jetpack Compose como projeto prático da Semana 04 do treinamento WorldSkills — Desenvolvimento de Aplicativos Móveis (Ocupação 08).

O app é uma vitrine mobile de cursos técnicos e profissionalizantes da plataforma fictícia **Aprender+**, com catálogo navegável, busca, filtros, seleção visual e tela de detalhe.

---

## Como executar

**Requisitos:**
- Android Studio (versão estável)
- JDK 17 ou superior
- Emulador Android API 26+ ou dispositivo físico com Android 8.0+

**Passos:**
1. Clone o repositório
2. Abra o projeto no Android Studio
3. Aguarde a sincronização do Gradle
4. Execute em emulador (recomendado: Pixel 7 ou Pixel 8) ou dispositivo físico
5. O app abre diretamente na tela de catálogo com 12 cursos pré-carregados

---

## Estrutura do projeto

```
com.example.projetoteste/
├── MainActivity.kt
├── model/
│   ├── ModeloCurso.kt         — data class com todos os campos do curso
│   ├── Nivel.kt               — enum com Básico, Intermediário, Avançado
│   ├── Status.kt              — enum com Disponível, Em breve, Indisponível
│   └── ResultadoValidado.kt   — modelo para resultado de validação
├── ui/
│   ├── components/
│   │   ├── Buskar.kt          — campo de busca com placeholder "Busca"
│   │   ├── CabecalhoCadastro.kt — cabeçalho com título e subtítulo obrigatórios
│   │   ├── CursoCard.kt       — card reutilizável com seleção visual
│   │   ├── FiltroScreen.kt    — filtro por nível ou categoria com chips
│   │   ├── CadastrarButtons.kt — botões do formulário de cadastro
│   │   ├── ContainerImage.kt  — identidade visual com imagem local
│   │   └── FormularioCurso.kt — formulário de cadastro de curso
│   ├── screens/
│   │   ├── FullApplication.kt — entrada principal com abas e estado compartilhado
│   │   ├── MainScreen.kt      — catálogo com busca, filtro e lista
│   │   ├── CursoDetalhe.kt    — detalhe do curso selecionado
│   │   └── CoursesScreen.kt   — cadastro visual de novo curso
│   └── theme/
│       ├── Color.kt, Theme.kt, Type.kt — tema Material 3 com dark mode forçado
└── utils/
    └── CursoValidator.kt      — validações do formulário de cadastro
```

---

## Como a navegação foi organizada

A navegação entre catálogo e detalhe foi implementada com **estado local** em vez de Navigation Compose. O `FullApplication` mantém o estado `cursoSelecionado: ModeloCurso?`:

- Quando `cursoSelecionado == null` → exibe o `Scaffold` com as abas (catálogo e cadastro)
- Quando `cursoSelecionado != null` → exibe o `CursoDetalhe` por cima, ocultando as abas
- O botão voltar na tela de detalhe zera o estado, retornando ao catálogo

O smart cast `val cursoAtual = cursoSelecionado` é usado para evitar o operador `!!`, garantindo acesso seguro ao valor não-nulo.

A alternância entre as abas **Meus Cursos** e **Cadastrar Curso** é feita por `selectedTab: Int` controlado pelo `NavigationBar` dentro do `Scaffold`.

---

## Como o estado foi controlado

| Estado | Tipo | Onde vive | Motivo |
|---|---|---|---|
| `cursos` | `List<ModeloCurso>` | `FullApplication` | compartilhado entre catálogo e cadastro |
| `cursoSelecionado` | `ModeloCurso?` | `FullApplication` | controla abertura do detalhe |
| `idSelecionado` | `Int?` | `FullApplication` | controla seleção visual do card |
| `campoBusca` | `String` | `MainScreen` — `rememberSaveable` | preservado ao rotacionar a tela |
| `filtroSelecionado` | `String` | `MainScreen` — `rememberSaveable` | preservado ao rotacionar a tela |
| `tipoFiltro` | `String` | `MainScreen` — `rememberSaveable` | preservado ao rotacionar a tela |

O `rememberSaveable` foi escolhido para busca e filtro para que o contexto não se perca ao rotacionar o dispositivo. O state hoisting é aplicado no `CursoCard`: ele não controla seu próprio estado de seleção — recebe `selecionado: Boolean` por parâmetro e emite `onCursoClick` para o pai decidir.

---

## Como a busca e os filtros funcionam

### Busca

O campo filtra a lista por três campos simultaneamente com `ignoreCase = true`:

```kotlin
curso.nomeCompleto.contains(campoBusca, ignoreCase = true) ||
curso.nomeBreve.contains(campoBusca, ignoreCase = true) ||
curso.categoriaCurso.contains(campoBusca, ignoreCase = true)
```

A lista original nunca é alterada. A exibida é sempre derivada via `.filter {}`, garantindo que limpar o campo restaure todos os cursos compatíveis com o filtro ativo.

### Filtro

Usa `SingleChoiceSegmentedButtonRow` para escolher o tipo (Nível ou Categoria) e `FilterChip` em `LazyRow` para as opções. A opção **Todos** está sempre presente.

Busca e filtro são combinados com `&&`:

```kotlin
val matchBusca = /* contém o texto digitado */
val matchFiltro = filtroSelecionado == "Todos" ||
    (tipoFiltro == "Nivel" && curso.nivel.label == filtroSelecionado) ||
    (tipoFiltro == "Categoria" && curso.categoriaCurso == filtroSelecionado)

matchBusca && matchFiltro
```

Trocar o tipo de filtro (Nível ↔ Categoria) reseta automaticamente o valor selecionado para "Todos".

---

## Modelo de dados

```kotlin
data class ModeloCurso(
    var id: Int = 0,
    val nivel: Nivel = Nivel.BASICO,
    var status: Status = Status.DISPONIVEL,
    val nomeCompleto: String = "",
    val nomeBreve: String = "",
    val categoriaCurso: String = "",
    val cargaHoraria: String = "",
    val descricaoCurta: String = "",
    val descricaoCompleta: String = "",
    val percentualProgresso: Double = 0.0
)
```

Os 12 cursos locais estão definidos em `exemplos()` na própria `ModeloCurso`, cobrindo categorias como Mobile, Web, Back-end, Data Science, Design, DevOps, Segurança, Infraestrutura e Ferramentas, com níveis e status variados.

---

## Testes realizados

### Inicialização
- [x] App abre sem crash
- [x] Tela exibe "Catálogo Aprender+"
- [x] Tela exibe "Explore cursos técnicos e profissionalizantes."
- [x] Lista exibe 12 cursos sem ação do usuário
- [x] Rolagem vertical funciona

### Lista
- [x] Todos os cursos aparecem em cards
- [x] Card exibe nome completo
- [x] Card exibe nome breve
- [x] Card exibe categoria
- [x] Card exibe nível
- [x] Card exibe carga horária
- [x] Card exibe status com texto correto
- [x] Card exibe percentual de progresso com barra visual
- [x] Espaçamento consistente entre cards
- [x] App não trava ao rolar rapidamente

### Busca
- [x] Busca por nome completo retorna curso correto
- [x] Busca por parte do nome retorna curso correto
- [x] Busca por categoria retorna cursos compatíveis
- [x] Busca com maiúsculas e minúsculas funciona
- [x] Limpar busca restaura resultados
- [x] Busca inexistente exibe "Nenhum curso encontrado"
- [x] Busca inexistente exibe "Ajuste a busca ou altere o filtro selecionado."

### Filtro
- [x] "Todos" exibe todos os cursos compatíveis com a busca
- [x] Selecionar nível atualiza a lista
- [x] Selecionar categoria atualiza a lista
- [x] Filtro ativo fica visualmente identificado
- [x] Busca e filtro funcionam juntos
- [x] Alterar filtro não apaga o texto da busca
- [x] Filtro sem resultado exibe estado vazio

### Seleção
- [x] Clicar em um item altera o estado visual (borda colorida)
- [x] Apenas um item fica selecionado por vez
- [x] Seleção baseada no id do curso
- [x] Estado de seleção não é isolado no card
- [x] Seleção não quebra ao aplicar filtro

### Detalhe
- [x] Tela exibe "Detalhe do curso"
- [x] Tela exibe nome completo, nome breve, categoria, nível, carga horária, status
- [x] Tela exibe percentual de progresso com barra visual
- [x] Tela exibe descrição completa
- [x] Tela exibe texto informativo de preparação profissional
- [x] Tela exibe "Este curso faz parte da trilha Aprender+."
- [x] Conteúdo longo permite rolagem
- [x] Botão voltar retorna ao catálogo sem crash
- [x] Detalhe corresponde ao curso clicado
- [x] Abrir vários detalhes em sequência funciona

---

## Decisões técnicas

**Navegação por estado em vez de NavHost:** a tela de detalhe é controlada pelo estado `cursoSelecionado` em vez de Navigation Compose. Isso simplifica o fluxo para o escopo atual, evitando serialização de argumentos e configuração de rotas. A limitação é que o cenário de "curso não encontrado" por ID inválido não é demonstrável sem rota com argumento.

**Modo escuro forçado:** o app usa `AppCompatDelegate.MODE_NIGHT_YES` na `MainActivity` para garantir o tema escuro independentemente da configuração do sistema, evitando que `dynamicColor = true` do Material 3 sobrescreva as cores em Android 12+.

**Lista imutável durante filtros:** a lista `cursos` nunca é alterada. A filtragem usa `.filter {}` que retorna uma nova lista derivada, preservando os dados originais e permitindo restauração sem efeitos colaterais.

**State hoisting no card:** o `CursoCard` não toma nenhuma decisão de seleção. Recebe `selecionado: Boolean` e `onCursoClick` por parâmetro, tornando-o previsível, reutilizável e testável.

**rememberSaveable para busca e filtro:** garante que o usuário não perde o contexto ao rotacionar a tela ou ao sistema recriar a Activity.

---

## Limitações conhecidas

- Navigation Compose (NavHost/NavController) não foi implementado; a navegação é baseada em estado local
- O cenário de "Curso não encontrado" por ID inválido não é demonstrável sem rota com argumento
- O modo de visualização alternativo Cards/Lista (RF11 opcional) não foi implementado
- Testes automatizados com Compose UI Test não foram implementados nesta entrega

---

## Tecnologias utilizadas

- Kotlin
- Jetpack Compose
- Material 3
- Android SDK mínimo: API 26 (Android 8.0)
- Gradle Kotlin DSL
