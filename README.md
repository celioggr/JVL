# Acerca da Java Vulnerable Lab

A Java Vulnerable Lab é uma aplicação originalmente desenvolvida pela [Cyber Security and Privacy Foundation](http://cysecurity.org). O código usado neste projecto contém ligeiras adaptações e customizações ao [código original](https://github.com/CSPF-Founder/JavaVulnerableLab). 

# Software a instalar

* [Java Development Kit para Java 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) 
* [Maven 3.x](http://maven.apache.org)
* [ZAP 2.7.0](http://www.dcc.fc.up.pt/~edrdo/QSES1718/trabalhos/03/ZAP_2.7.0_Crossplatform.zip), versão cross-platform, disponível a partir da página da disciplina.

Os plugins do SpotBugs, FindSecBugs e PITest (além de várias bibliotecas Java) serão automaticamente instalados pelo Maven durante a compilação do projecto.

Poderá ser conveniente o uso de um IDE para edição do código e que integre com o Maven. Recomenda-se o uso do [Eclipse IDE for Java Developers, versão Oxygen](https://www.eclipse.org/downloads/packages/eclipse-ide-java-developers/oxygen1a). Para importar o projecto Maven aceda a `File > Import > Maven > Existing Maven Projects` e selecione o directório para onde descomprimiu o projecto Maven.

# Estrutura do projecto Maven

Principais ficheiros e pastas:

* `pom.xml`: configuração do projecto (directório raíz)
* `src/main/java`: código Java 
* `src/test/java`: directório com testes JUnit
* `src/main/webapp`: código JSP e configuração da aplicação
* `target`: directório de ficheiros gerados durante compilação, execução, e testes JUnit.

Em `src/main/java/org/apache/jsp` irá aparecer código automaticamente gerado a partir dos arquivos JSP 
em `src/main/webapp`. Não deverá editar o código gerado.


# Uso do maven (linha de comandos)

Os comandos descritos deverão ser executados a partir do directório raíz `JavaVulnerableLab` do projecto
(que contém o ficheiro `pom.xml`).

## Compilação da JVL

Use `mvn package` para compilar a aplicação. Os ficheiros gerados durante a compilação são depositados no directório de compilação `target`. O comando `mvn clean` apaga o directório de compilação. Pode executar `mvn clean package` para forçar uma recompilação completa.


## Execução da JVL

Pode iniciar a aplicação com o comando `mvn package exec:exec`, podendo `package` ser omitido caso não queira recompilar a aplicação.
Aceda seguidamente a `https://localhost:9443` no seu browser. 

No início da execução, uma base de dados H2 será inicializada de fresco de acordo com as configurações expressas na servlet `org.cysecurity.cspf.jvl.controller.Install` (pasta `src/main/java`). Esta servlet pode ser invocada directamente (`https://localhost:9443/Install`) se quiser repôr o estado inicial da a base de dados.  Para aceder ao sistema na página de login poderá por exemplo usar as credenciais `admin/admin` ou `victim/victim` (entre outras definidas na inicialização da base de dados). 


## Análise Spotbugs 

Use `mvn package spotbugs:spotbugs spotbugs:gui` para correr o SpotBugs e abrir o SpotBugs GUI. Pode omitir `package` caso não queira recompilar a aplicação.

## Execução de testes JUnit + PITest

Use `mvn test` para executar os testes JUnit e PITest. O relatório HTML gerado pelo PITest é guardado em `target/pitest-reports'.

# Uso do ZAP

Extráia o arquivo do ZAP para um directório à sua escolha. Na pasta raíz irá encontrar os scripts `zap.sh` (para Linux/MacOS) ou `zap.bat` (para Windows) que permitem iniciar o ZAP. Uma vez lançado, o ZAP usa a porta 8080 para servir de HTTP/HTTPS proxy.

A partir do interface do ZAP deverá poder lançar o browser que quiser usar (Chrome, Safari, Firefox,  ...) por forma a evitar avisos relacionados com o uso de alguns certificados SSL. O browser deverá ser configurado por forma a usar o ZAP como HTTPS proxy.



