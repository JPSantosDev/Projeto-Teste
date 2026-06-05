package com.example.projetoteste.model

data class ModeloCurso (
    var id: Int = 0,
    val nivel: Nivel = Nivel.BASICO,
    var status: Status = Status.DISPONIVEL,
    val nomeCompleto: String = "",
    val nomeBreve: String = "",
    val categoriaCurso:String = "",
    val cargaHoraria: String = "",
    val descricaoCurta: String = "",
    val descricaoCompleta: String = ""
) {

    fun exemplos(): List<ModeloCurso> {
        return listOf(
            ModeloCurso(
                id = 1, nivel = Nivel.BASICO, status = Status.DISPONIVEL,
                nomeCompleto = "Desenvolvimento Android com Jetpack Compose",
                nomeBreve = "Android Compose", categoriaCurso = "Mobile",
                cargaHoraria = "60",
                descricaoCurta = "Crie interfaces modernas para Android usando Compose.",
                descricaoCompleta = "Aprenda a construir aplicativos Android do zero com Jetpack Compose, gerenciamento de estado, navegação entre telas, consumo de APIs REST e publicação na Play Store."
            ),
            ModeloCurso(
                id = 2, nivel = Nivel.BASICO, status = Status.DISPONIVEL,
                nomeCompleto = "Lógica de Programação para Iniciantes",
                nomeBreve = "Lógica Prog.", categoriaCurso = "Programação",
                cargaHoraria = "20",
                descricaoCurta = "Fundamentos de lógica para quem está começando.",
                descricaoCompleta = "Curso introdutório sobre algoritmos, fluxogramas, estruturas de decisão e repetição. Ideal para quem nunca programou antes e quer entender como o raciocínio lógico funciona na prática."
            ),
            ModeloCurso(
                id = 3, nivel = Nivel.BASICO, status = Status.DISPONIVEL,
                nomeCompleto = "Banco de Dados com SQL e PostgreSQL",
                nomeBreve = "SQL Avançado", categoriaCurso = "Banco de Dados",
                cargaHoraria = "40",
                descricaoCurta = "Domine consultas SQL e bancos relacionais.",
                descricaoCompleta = "Aprenda desde comandos básicos até consultas complexas com joins, subqueries, views, procedures e otimização de performance utilizando PostgreSQL como banco principal."
            ),
            ModeloCurso(
                id = 4, nivel = Nivel.BASICO, status = Status.EM_BREVE,
                nomeCompleto = "Desenvolvimento Web com React",
                nomeBreve = "React Web", categoriaCurso = "Web",
                cargaHoraria = "50",
                descricaoCurta = "Aplicações web modernas com React e hooks.",
                descricaoCompleta = "Curso completo de React cobrindo componentes funcionais, hooks, context API, consumo de APIs externas, roteamento com React Router e deploy de aplicações em produção."
            ),
            ModeloCurso(
                id = 5, nivel = Nivel.INTERMEDIARIO, status = Status.DISPONIVEL,
                nomeCompleto = "Python para Ciência de Dados",
                nomeBreve = "Python Data", categoriaCurso = "Data Science",
                cargaHoraria = "80",
                descricaoCurta = "Análise e visualização de dados com Python.",
                descricaoCompleta = "Explore pandas, numpy, matplotlib e scikit-learn para análise exploratória de dados, construção de modelos de machine learning e criação de dashboards interativos com Streamlit."
            ),
            ModeloCurso(
                id = 6, nivel = Nivel.INTERMEDIARIO, status = Status.DISPONIVEL,
                nomeCompleto = "Redes de Computadores",
                nomeBreve = "Redes", categoriaCurso = "Infraestrutura",
                cargaHoraria = "35",
                descricaoCurta = "Fundamentos de redes, protocolos e segurança.",
                descricaoCompleta = "Entenda como funcionam as redes de computadores, o modelo OSI, protocolo TCP/IP, roteamento, switches, DNS, DHCP e os fundamentos de segurança de rede aplicados ao ambiente corporativo."
            ),
            ModeloCurso(
                id = 7, nivel = Nivel.INTERMEDIARIO, status = Status.INDISPONIVEL,
                nomeCompleto = "DevOps com Docker e Kubernetes",
                nomeBreve = "DevOps K8s", categoriaCurso = "DevOps",
                cargaHoraria = "70",
                descricaoCurta = "Containers e orquestração na prática.",
                descricaoCompleta = "Aprenda a containerizar aplicações com Docker, orquestrar serviços com Kubernetes, configurar pipelines de CI/CD com GitHub Actions e monitorar ambientes em produção com Prometheus e Grafana."
            ),
            ModeloCurso(
                id = 8, nivel = Nivel.INTERMEDIARIO, status = Status.DISPONIVEL,
                nomeCompleto = "UI/UX Design para Aplicativos",
                nomeBreve = "UX Mobile", categoriaCurso = "Design",
                cargaHoraria = "25",
                descricaoCurta = "Interfaces intuitivas e acessíveis para apps.",
                descricaoCompleta = "Aprenda os princípios de design centrado no usuário, prototipagem com Figma, condução de testes de usabilidade, boas práticas de acessibilidade e como entregar especificações para desenvolvedores."
            ),
            ModeloCurso(
                id = 9, nivel = Nivel.AVANCADO, status = Status.DISPONIVEL,
                nomeCompleto = "Kotlin para Desenvolvimento Android",
                nomeBreve = "Kotlin Android", categoriaCurso = "Mobile",
                cargaHoraria = "45",
                descricaoCurta = "Kotlin do zero para criar seus primeiros apps.",
                descricaoCompleta = "Domine a linguagem Kotlin com foco em desenvolvimento Android: sintaxe moderna, orientação a objetos, coroutines, criação de layouts com XML e integração com bibliotecas do ecossistema Android."
            ),
            ModeloCurso(
                id = 10, nivel = Nivel.AVANCADO, status = Status.EM_BREVE,
                nomeCompleto = "Segurança da Informação e Ethical Hacking",
                nomeBreve = "Sec. Info", categoriaCurso = "Segurança",
                cargaHoraria = "90",
                descricaoCurta = "Técnicas de segurança ofensiva e defensiva.",
                descricaoCompleta = "Aprenda sobre vulnerabilidades, testes de penetração, criptografia, OWASP Top 10, análise de malware e como proteger sistemas e redes corporativas contra ataques reais."
            ),
            ModeloCurso(
                id = 11, nivel = Nivel.AVANCADO, status = Status.DISPONIVEL,
                nomeCompleto = "Desenvolvimento de APIs REST com Spring Boot",
                nomeBreve = "Spring Boot", categoriaCurso = "Back-end",
                cargaHoraria = "55",
                descricaoCurta = "APIs robustas e escaláveis com Spring Boot.",
                descricaoCompleta = "Construa APIs REST completas com Spring Boot, JPA e Hibernate, autenticação JWT, documentação com Swagger, testes unitários e de integração, e deploy em ambientes de nuvem."
            ),
            ModeloCurso(
                id = 12, nivel = Nivel.AVANCADO, status = Status.DISPONIVEL,
                nomeCompleto = "Git e GitHub para Trabalho em Equipe",
                nomeBreve = "Git & GitHub", categoriaCurso = "Ferramentas",
                cargaHoraria = "15",
                descricaoCurta = "Controle de versão com Git na prática.",
                descricaoCompleta = "Aprenda os comandos essenciais do Git, fluxo de trabalho com branches, pull requests, resolução de conflitos, boas práticas em repositórios GitHub e uso de Git em projetos colaborativos reais."
            )
        )
    }
}
